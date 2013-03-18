package com.github.davidedmonds.guiceexample.guiceconfig;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloGuiceConfiguredWorldTest {
    private HelloGuiceConfiguredWorld helloGuiceConfiguredWorld;
    private RandomStringGetter randomStringGetter;

    @Before
    public void setUp() {
        randomStringGetter = mock(RandomStringGetter.class);
        when(randomStringGetter.getNextWord()).thenReturn("TeN-ChArS!");
        helloGuiceConfiguredWorld = new HelloGuiceConfiguredWorld(randomStringGetter);
    }

    @Test
    public void labelShouldBeSetToA10CharacterLongString() {
        assertEquals(10, helloGuiceConfiguredWorld.getLabel().getText().trim().length());
    }

    @Test
    public void labelShouldBeSetToResponseFromRandomStringGetter() {
        assertEquals("TeN-ChArS!", helloGuiceConfiguredWorld.getLabel().getText().trim());
    }
}
