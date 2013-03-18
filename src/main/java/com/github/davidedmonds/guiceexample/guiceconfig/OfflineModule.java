package com.github.davidedmonds.guiceexample.guiceconfig;

import com.google.inject.AbstractModule;

import javax.inject.Singleton;


public class OfflineModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RandomStringGetter.class).to(OfflineRandomStringGetter.class).in(Singleton.class);
    }
}
