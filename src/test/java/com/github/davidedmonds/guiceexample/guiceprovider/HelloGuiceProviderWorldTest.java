package com.github.davidedmonds.guiceexample.guiceprovider;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloGuiceProviderWorldTest {
    private HelloGuiceProviderWorld helloGuiceProviderWorld;
    private RandomStringGetter randomStringGetter;

    @Before
    public void setUp() {
        randomStringGetter = mock(RandomStringGetter.class);
        when(randomStringGetter.getNextWord()).thenReturn("TeN-ChArS!");
        helloGuiceProviderWorld = new HelloGuiceProviderWorld(randomStringGetter);
    }

    @Test
    public void labelShouldBeSetToA10CharacterLongString() {
        assertEquals(10, helloGuiceProviderWorld.getLabel().getText().trim().length());
    }

    @Test
    public void labelShouldBeSetToResponseFromRandomStringGetter() {
        assertEquals("TeN-ChArS!", helloGuiceProviderWorld.getLabel().getText().trim());
    }
}
