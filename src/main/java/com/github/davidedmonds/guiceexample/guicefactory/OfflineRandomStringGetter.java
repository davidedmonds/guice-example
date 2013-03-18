package com.github.davidedmonds.guiceexample.guicefactory;

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

    @Override
    public String getNextWord() {
        logger.info("OfflineRandomStringGetter says: Time to get another random string!");
        try {
            return new String(MessageDigest.getInstance("MD5").digest(Long.toString(new Date().getTime()).getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            return "ALGORITHM!";
        } catch (UnsupportedEncodingException e) {
            return "ENCODING!!";
        }
    }
}
