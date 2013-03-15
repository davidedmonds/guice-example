package com.github.davidedmonds.guiceexample.staticsingleton;

import us.monoid.web.Resty;

import java.io.IOException;

/**
 * Static random string getting instance.
 */
public class StaticRandomStringGetter {
    private static final StaticRandomStringGetter INSTANCE = new StaticRandomStringGetter();

    private StaticRandomStringGetter() {
    }

    public static StaticRandomStringGetter getInstance() {
        return INSTANCE;
    }

    public String getNextWord() {
        System.out.println("StaticRandomStringGetter says: Time to get another random string!");
        try {
            return new Resty().text("http://www.random.org/strings/?num=1&len=10&digits=on&upperalpha=on&loweralpha=on&unique=off&format=plain&rnd=new").toString();
        } catch (IOException e) {
            return "ERRORERROR";
        }
    }
}
