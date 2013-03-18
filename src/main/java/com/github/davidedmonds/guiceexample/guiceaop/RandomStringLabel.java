package com.github.davidedmonds.guiceexample.guiceaop;

import com.google.inject.assistedinject.Assisted;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import javax.inject.Inject;

public class RandomStringLabel {
    private final Label label;
    private final RandomStringGetter randomStringGetter;

    @Inject
    RandomStringLabel(RandomStringGetter randomStringGetter, @Assisted Shell shell) throws Exception {
        this.randomStringGetter = randomStringGetter;
        label = new Label(shell, SWT.NONE);
    }

    public void pack() throws Exception {
        label.setText(randomStringGetter.getNextWord());
        label.pack();
    }

    public void dispose() {
        label.dispose();
    }

    public String getText() {
        return label.getText();
    }
}
