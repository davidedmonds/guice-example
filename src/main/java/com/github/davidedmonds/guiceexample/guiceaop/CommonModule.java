package com.github.davidedmonds.guiceexample.guiceaop;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.matcher.Matchers;

public class CommonModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().build(RandomStringLabelFactory.class));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(GUIError.class), new GUIErrorInterceptor());
    }
}
