package com.github.davidedmonds.guiceexample.moreguice;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloMoreGuicedWorldTest {
    private HelloMoreGuicedWorld helloMoreGuicedWorld;
    private MoreGuicedRandomStringGetter moreGuicedRandomStringGetter;

    @Before
    public void setUp() {
        moreGuicedRandomStringGetter = mock(MoreGuicedRandomStringGetter.class);
        when(moreGuicedRandomStringGetter.getNextWord()).thenReturn("TeN-ChArS!");
        helloMoreGuicedWorld = new HelloMoreGuicedWorld(moreGuicedRandomStringGetter);
    }

    @Test
    public void labelShouldBeSetToA10CharacterLongString() {
        assertEquals(10, helloMoreGuicedWorld.getLabel().getText().trim().length());
    }

    @Test
    public void labelShouldBeSetToResponseFromGuicedRandomStringGetter() {
        assertEquals("TeN-ChArS!", helloMoreGuicedWorld.getLabel().getText().trim());
    }
}
