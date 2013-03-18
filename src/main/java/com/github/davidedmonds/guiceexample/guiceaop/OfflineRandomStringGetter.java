package com.github.davidedmonds.guiceexample.guiceaop;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Logger;

public class OfflineRandomStringGetter implements RandomStringGetter {

    private final Logger logger;

    @Inject
    OfflineRandomStringGetter(Logger logger) {
        this.logger = logger;
    }

    @GUIError
    @Override
    public String getNextWord() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        logger.info("OfflineRandomStringGetter says: Time to get another random string!");
        return new String(MessageDigest.getInstance("MD5").digest(Long.toString(new Date().getTime()).getBytes("UTF-8")));
    }
}
