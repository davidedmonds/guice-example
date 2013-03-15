package com.github.davidedmonds.guiceexample.simpleguice;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GuicedRandomStringGetterTest {
    @Test
    public void getNextWordReturnsA10CharacterString() {
        assertEquals(10, new GuicedRandomStringGetter().getNextWord().trim().length());
    }
}
