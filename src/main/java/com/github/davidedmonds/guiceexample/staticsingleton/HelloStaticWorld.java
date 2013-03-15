package com.github.davidedmonds.guiceexample.staticsingleton;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * This is an example class demonstrating our present static singleton pattern
 */
public class HelloStaticWorld {
    private Label label;
    private Display display;
    private Shell shell;

    public HelloStaticWorld() {
        display = new Display();
        shell = new Shell(display);
        label = new Label(shell, SWT.NONE);
        label.setText(StaticRandomStringGetter.getInstance().getNextWord());
        shell.pack();
        label.pack();
        shell.open();
    }

    public void run() {
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) {
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

    public static void main(String[] args) {
        HelloStaticWorld hello = new HelloStaticWorld();
        hello.run();
        hello.dispose();
    }
}
