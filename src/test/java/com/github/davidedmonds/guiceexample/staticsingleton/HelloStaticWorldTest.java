package com.github.davidedmonds.guiceexample.staticsingleton;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HelloStaticWorldTest {
    private HelloStaticWorld helloStaticWorld;

    @Before
    public void setUp() {
        helloStaticWorld = new HelloStaticWorld();
    }

    @Test
    public void labelShouldBeSetToA10CharacterLongString() {
        assertEquals(10, helloStaticWorld.getLabel().getText().trim().length());
    }
}
