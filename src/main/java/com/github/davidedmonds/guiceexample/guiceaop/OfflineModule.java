package com.github.davidedmonds.guiceexample.guiceaop;

import com.google.inject.AbstractModule;


public class OfflineModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RandomStringGetter.class).to(OfflineRandomStringGetter.class);
    }
}
