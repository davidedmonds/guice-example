package com.github.davidedmonds.guiceexample.guicefactory;

import com.google.inject.assistedinject.Assisted;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import javax.inject.Inject;

public class RandomStringLabel {
    private final Label label;

    @Inject
    RandomStringLabel(RandomStringGetter randomStringGetter, @Assisted Shell shell) {
        label = new Label(shell, SWT.NONE);
        label.setText(randomStringGetter.getNextWord());
    }

    public void pack() {
        label.pack();
    }

    public void dispose() {
        label.dispose();
    }

    public String getText() {
        return label.getText();
    }
}
