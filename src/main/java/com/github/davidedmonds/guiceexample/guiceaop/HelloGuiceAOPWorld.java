package com.github.davidedmonds.guiceexample.guiceaop;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import javax.inject.Inject;

public class HelloGuiceAOPWorld {
    private RandomStringLabel label;
    private Display display;
    private Shell shell;

    @Inject
    HelloGuiceAOPWorld(RandomStringLabelFactory randomStringLabelFactory) {
        display = Display.getDefault();
        shell = new Shell(display);
        label = randomStringLabelFactory.create(shell);
    }

    public void run() throws Exception {
        shell.pack();
        label.pack();
        shell.open();
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

    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equals("offline")) {
            launch(new OfflineModule());
        } else {
            launch(new RestyModule());
        }
    }

    public static void launch(Module module) throws Exception {
        Injector injector = Guice.createInjector(new CommonModule(), module);
        HelloGuiceAOPWorld hello = injector.getInstance(HelloGuiceAOPWorld.class);
        hello.run();
        hello.dispose();
    }

    public RandomStringLabel getLabel() {
        return label;
    }
}
