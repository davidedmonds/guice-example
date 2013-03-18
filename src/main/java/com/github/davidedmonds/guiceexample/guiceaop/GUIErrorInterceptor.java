package com.github.davidedmonds.guiceexample.guiceaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;

public class GUIErrorInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object o = null;
        try {
            o = invocation.proceed();
        } catch (Exception e) {
            Status status = new Status(IStatus.ERROR, "blah", e.getLocalizedMessage(), e);
            ErrorDialog.openError(null, null, null, status);
        }
        return o;
    }
}
