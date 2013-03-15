package com.github.davidedmonds.guiceexample.moreguice;

import org.junit.Before;
import org.junit.Test;
import us.monoid.web.Resty;
import us.monoid.web.TextResource;

import java.io.IOException;
import java.util.logging.Logger;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoreGuicedRandomStringGetterTest {

    private Resty resty;
    private TextResource resource;
    private Logger logger;
    private MoreGuicedRandomStringGetter moreGuicedRandomStringGetter;

    @Before
    public void setUp() throws IOException {
        resty = mock(Resty.class);
        resource = mock(TextResource.class);
        logger = mock(Logger.class);

        when(resty.text(anyString())).thenReturn(resource);
        when(resource.toString()).thenReturn("TeN-ChArS!");

        moreGuicedRandomStringGetter = new MoreGuicedRandomStringGetter(resty, logger);
    }

    @Test
    public void getNextWordReturnsA10CharacterString() {
        assertEquals(10, moreGuicedRandomStringGetter.getNextWord().trim().length());
    }

    @Test
    public void getNextWordReturnsStringReturnedByResty() {
        assertEquals("TeN-ChArS!", moreGuicedRandomStringGetter.getNextWord().trim());
    }

    @Test
    public void getNextWordLogsALineToConsole() {
        moreGuicedRandomStringGetter.getNextWord();
        verify(logger).info("MoreGuicedRandomStringGetter says: Time to get another random string!");
    }
}
