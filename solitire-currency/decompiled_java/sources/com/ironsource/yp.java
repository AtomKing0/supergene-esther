package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class yp implements Runnable {
    public abstract void a() throws Exception;

    public void a(@NotNull Throwable t10) {
        kotlin.jvm.internal.t.i(t10, "t");
        ks.a(t10);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            i9.d().a(th);
            try {
                a(th);
            } catch (Throwable th2) {
                i9.d().a(th2);
            }
        }
    }
}
