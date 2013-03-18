package com.github.davidedmonds.guiceexample.guiceconfig;

import org.junit.Before;
import org.junit.Test;
import us.monoid.web.Resty;
import us.monoid.web.TextResource;

import java.io.IOException;
import java.util.logging.Logger;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class RestyRandomStringGetterTest {

    private Resty resty;
    private TextResource resource;
    private Logger logger;
    private RestyRandomStringGetter restyRandomStringGetter;

    @Before
    public void setUp() throws IOException {
        resty = mock(Resty.class);
        resource = mock(TextResource.class);
        logger = mock(Logger.class);

        when(resty.text(anyString())).thenReturn(resource);
        when(resource.toString()).thenReturn("TeN-ChArS!");

        restyRandomStringGetter = new RestyRandomStringGetter(resty, logger);
    }

    @Test
    public void getNextWordReturnsA10CharacterString() {
        assertEquals(10, restyRandomStringGetter.getNextWord().trim().length());
    }

    @Test
    public void getNextWordReturnsStringReturnedByResty() {
        assertEquals("TeN-ChArS!", restyRandomStringGetter.getNextWord().trim());
    }

    @Test
    public void getNextWordReturnsErrorStringIfRestyThrowsException() throws IOException {
        when(resty.text(anyString())).thenThrow(new IOException("IO"));
        assertEquals("ERRORERROR", restyRandomStringGetter.getNextWord().trim());
    }

    @Test
    public void getNextWordLogsALineToConsole() {
        restyRandomStringGetter.getNextWord();
        verify(logger).info("RestyRandomStringGetter says: Time to get another random string!");
    }
}
