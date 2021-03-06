package com.github.davidedmonds.guiceexample.guicefactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import us.monoid.web.Resty;

@SuppressWarnings("unused") // Lots of provider methods in here that appear unused, but are in fact part of Guice config.
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
