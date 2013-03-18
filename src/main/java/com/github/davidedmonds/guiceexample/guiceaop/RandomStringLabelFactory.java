package com.github.davidedmonds.guiceexample.guiceaop;

import org.eclipse.swt.widgets.Shell;

public interface RandomStringLabelFactory {
    RandomStringLabel create(Shell shell);
}
