package com.github.davidedmonds.guiceexample.moreguice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import us.monoid.web.Resty;

public class MoreGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        // Nothing to configure here
    }

    @Provides
    private Resty provideResty() {
        return new Resty();
    }
}
