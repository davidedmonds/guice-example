package com.github.davidedmonds.guiceexample.guiceprovider;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Provider;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloGuiceProviderWorldTest {
    private HelloGuiceProviderWorld helloGuiceProviderWorld;
    private Provider<RandomStringGetter> randomStringProvider;
    private RandomStringGetter randomStringGetter;

    @Before
    public void setUp() {
        randomStringProvider = mock(Provider.class);
        randomStringGetter = mock(RandomStringGetter.class);

        when(randomStringProvider.get()).thenReturn(randomStringGetter);
        when(randomStringGetter.getNextWord()).thenReturn("TeN-ChArS!");

        helloGuiceProviderWorld = new HelloGuiceProviderWorld(randomStringProvider);
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
