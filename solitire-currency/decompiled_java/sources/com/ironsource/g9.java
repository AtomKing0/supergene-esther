package com.ironsource;

import java.lang.Thread;

/* JADX INFO: loaded from: classes4.dex */
public class g9 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f12230a;

    g9(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f12230a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        h9 h9Var = new h9(th);
        if (h9Var.d()) {
            new wb(h9Var.b(), "" + System.currentTimeMillis(), "Crash").a();
        }
        this.f12230a.uncaughtException(thread, th);
    }
}
