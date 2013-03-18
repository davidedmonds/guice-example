package com.github.davidedmonds.guiceexample.simpleguice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import javax.inject.Inject;

public class HelloGuicedWorld {
    private Label label;
    private Display display;
    private Shell shell;

    @Inject
    HelloGuicedWorld(GuicedRandomStringGetter guicedRandomStringGetter) {
        display = Display.getDefault();
        shell = new Shell(display);
        label = new Label(shell, SWT.NONE);
        label.setText(guicedRandomStringGetter.getNextWord());
        shell.pack();
        label.pack();
        shell.open();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        HelloGuicedWorld hello = injector.getInstance(HelloGuicedWorld.class);
        hello.run();
        hello.dispose();
    }

    public void run() {
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    public void dispose() {
        display.dispose();
        label.dispose();
    }

    public Label getLabel() {
        return label;
    }
}
