package com.github.davidedmonds.guiceexample.guiceconfig;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import javax.inject.Inject;

public class HelloGuiceConfiguredWorld {
    private Label label;
    private Display display;
    private Shell shell;

    @Inject
    HelloGuiceConfiguredWorld(RandomStringGetter randomStringGetter) {
        display = Display.getDefault();
        shell = new Shell(display);
        label = new Label(shell, SWT.NONE);
        label.setText(randomStringGetter.getNextWord());
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
        if (args.length > 0 && args[0].equals("offline")) {
            launch(new OfflineModule());
        } else {
            launch(new RestyModule());
        }
    }

    public static void launch(Module module) {
        Injector injector = Guice.createInjector(module);
        HelloGuiceConfiguredWorld hello = injector.getInstance(HelloGuiceConfiguredWorld.class);
        hello.run();
        hello.dispose();
    }
}
