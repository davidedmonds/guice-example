package com.github.davidedmonds.guiceexample.guicefactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import javax.inject.Inject;
import javax.inject.Provider;

public class HelloGuiceFactoryWorld {
    private RandomStringLabel label;
    private Display display;
    private Shell shell;

    @Inject
    HelloGuiceFactoryWorld(RandomStringLabelFactory randomStringLabelFactory) {
        display = Display.getDefault();
        shell = new Shell(display);
        label = randomStringLabelFactory.create(shell);
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

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("offline")) {
            launch(new OfflineModule());
        } else {
            launch(new RestyModule());
        }
    }

    public static void launch(Module module) {
        Injector injector = Guice.createInjector(new CommonModule(), module);
        HelloGuiceFactoryWorld hello = injector.getInstance(HelloGuiceFactoryWorld.class);
        hello.run();
        hello.dispose();
    }

    public RandomStringLabel getLabel() {
        return label;
    }
}
