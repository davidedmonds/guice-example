package com.github.davidedmonds.guiceexample.guicefactory;

import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HelloGuiceFactoryWorldTest {

    @Test
    public void verifyLabelCreation() {
        RandomStringLabelFactory randomStringLabelFactory = mock(RandomStringLabelFactory.class);
        when(randomStringLabelFactory.create(any(Shell.class))).thenReturn(mock(RandomStringLabel.class));
        HelloGuiceFactoryWorld helloGuiceFactoryWorld = new HelloGuiceFactoryWorld(randomStringLabelFactory);
        verify(randomStringLabelFactory).create(any(Shell.class));
    }
}
