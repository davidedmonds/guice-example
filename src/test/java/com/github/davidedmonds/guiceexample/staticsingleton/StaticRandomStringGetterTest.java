package com.github.davidedmonds.guiceexample.staticsingleton;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StaticRandomStringGetterTest {
    @Test
    public void getNextWordReturnsA10CharacterString() {
        assertEquals(10, StaticRandomStringGetter.getInstance().getNextWord().trim().length());
    }
}
