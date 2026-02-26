package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes4.dex */
public class is extends Thread {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static is f12659b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f12660a;

    private class a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f12661a;

        a(String str) {
            super(str);
            setUncaughtExceptionHandler(new com.ironsource.mediationsdk.logger.d());
        }

        Handler a() {
            return this.f12661a;
        }

        void b() {
            this.f12661a = new Handler(getLooper());
        }
    }

    private is() {
        a aVar = new a(getClass().getSimpleName());
        this.f12660a = aVar;
        aVar.start();
        this.f12660a.b();
    }

    public static synchronized is a() {
        if (f12659b == null) {
            f12659b = new is();
        }
        return f12659b;
    }

    public synchronized void a(Runnable runnable) {
        a aVar = this.f12660a;
        if (aVar == null) {
            return;
        }
        Handler handlerA = aVar.a();
        if (handlerA != null) {
            handlerA.post(runnable);
        }
    }
}
