package com.github.davidedmonds.guiceexample.guicefactory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomStringLabelTest {
    private RandomStringGetter randomStringGetter;
    private RandomStringLabel randomStringLabel;

    @Before
    public void setUp() {
        randomStringGetter = mock(RandomStringGetter.class);
        when(randomStringGetter.getNextWord()).thenReturn("TeN-ChArS!");
        randomStringLabel = new RandomStringLabel(randomStringGetter, new Shell(Display.getDefault()));
    }

    @Test
    public void labelShouldBeSetToA10CharacterLongString() {
        assertEquals(10, randomStringLabel.getText().trim().length());
    }

    @Test
    public void labelShouldBeSetToResponseFromRandomStringGetter() {
        assertEquals("TeN-ChArS!", randomStringLabel.getText().trim());
    }
}
