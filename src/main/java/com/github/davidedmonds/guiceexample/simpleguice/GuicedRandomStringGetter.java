package com.github.davidedmonds.guiceexample.simpleguice;

import us.monoid.web.Resty;

import java.io.IOException;

/**
 * Static random string getting instance.
 */
public class GuicedRandomStringGetter {

    public String getNextWord() {
        System.out.println("GuicedRandomStringGetter says: Time to get another random string!");
        try {
            return new Resty().text("http://www.random.org/strings/?num=1&len=10&digits=on&upperalpha=on&loweralpha=on&unique=off&format=plain&rnd=new").toString();
        } catch (IOException e) {
            return "ERRORERROR";
        }
    }
}
