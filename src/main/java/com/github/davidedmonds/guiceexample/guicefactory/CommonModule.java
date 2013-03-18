package com.github.davidedmonds.guiceexample.guicefactory;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class CommonModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().build(RandomStringLabelFactory.class));
    }
}
