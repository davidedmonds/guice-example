package com.github.davidedmonds.guiceexample.simpleguice;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloGuicedWorldTest {
    private HelloGuicedWorld helloGuicedWorld;
    private GuicedRandomStringGetter guicedRandomStringGetter;

    @Before
    public void setUp() {
        guicedRandomStringGetter = mock(GuicedRandomStringGetter.class);
        when(guicedRandomStringGetter.getNextWord()).thenReturn("TeN-ChArS!");
        helloGuicedWorld = new HelloGuicedWorld(guicedRandomStringGetter);
    }

    @Test
    public void labelShouldBeSetToA10CharacterLongString() {
        assertEquals(10, helloGuicedWorld.getLabel().getText().trim().length());
    }

    @Test
    public void labelShouldBeSetToResponseFromGuicedRandomStringGetter() {
        assertEquals("TeN-ChArS!", helloGuicedWorld.getLabel().getText().trim());
    }
}
