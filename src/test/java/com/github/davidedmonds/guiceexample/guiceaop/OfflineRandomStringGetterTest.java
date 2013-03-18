package com.github.davidedmonds.guiceexample.guiceaop;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OfflineRandomStringGetterTest {

    private Logger logger;
    private OfflineRandomStringGetter offlineRandomStringGetter;

    @Before
    public void setUp() throws IOException {
        logger = mock(Logger.class);
        offlineRandomStringGetter = new OfflineRandomStringGetter(logger);
    }

    @Test
    public void getNextWordReturnsANonNullString() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        assertNotNull(offlineRandomStringGetter.getNextWord());
    }

    @Test
    public void getNextWordLogsALineToConsole() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        offlineRandomStringGetter.getNextWord();
        verify(logger).info("OfflineRandomStringGetter says: Time to get another random string!");
    }
}
