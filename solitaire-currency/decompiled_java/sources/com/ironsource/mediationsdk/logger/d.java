package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.lang.Thread;

/* JADX INFO: loaded from: classes4.dex */
public class d implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "Thread name =" + thread.getName(), th);
    }
}
