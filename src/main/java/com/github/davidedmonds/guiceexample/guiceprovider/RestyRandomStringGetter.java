package com.github.davidedmonds.guiceexample.guiceprovider;

import us.monoid.web.Resty;

import javax.inject.Inject;
import java.io.IOException;
import java.util.logging.Logger;

public class RestyRandomStringGetter implements RandomStringGetter {
    private final Resty resty;
    private final Logger logger;

    @Inject
    RestyRandomStringGetter(Resty resty, Logger logger) {
        this.resty = resty;
        this.logger = logger;
    }

    public String getNextWord() {
        logger.info("RestyRandomStringGetter says: Time to get another random string!");
        try {
            return resty.text("http://www.random.org/strings/?num=1&len=10&digits=on&upperalpha=on&loweralpha=on&unique=off&format=plain&rnd=new").toString();
        } catch (IOException e) {
            return "ERRORERROR";
        }
    }
}
