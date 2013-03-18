package com.github.davidedmonds.guiceexample.guiceprovider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import us.monoid.web.Resty;

public class RestyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RandomStringGetter.class).to(RestyRandomStringGetter.class);
    }

    @Provides
    private Resty provideResty() {
        return new Resty();
    }
}
