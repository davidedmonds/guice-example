package com.github.davidedmonds.guiceexample.guicefactory;

import org.eclipse.swt.widgets.Shell;

public interface RandomStringLabelFactory {
    RandomStringLabel create(Shell shell);
}
