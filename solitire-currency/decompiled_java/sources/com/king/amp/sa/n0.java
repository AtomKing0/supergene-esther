package com.king.amp.sa;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: AdRunnable.java */
/* JADX INFO: loaded from: classes4.dex */
public class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f16834a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16835b;

    public n0(String str) {
        this.f16835b = str;
    }

    public void a() {
        this.f16834a.post(this);
    }

    public void b() throws Exception {
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
            synchronized (this) {
                notifyAll();
            }
        } catch (Throwable th) {
            try {
                Logging.logBreadcrumb(this.f16835b, th.toString());
                synchronized (this) {
                    notifyAll();
                }
            } catch (Throwable th2) {
                synchronized (this) {
                    notifyAll();
                    throw th2;
                }
            }
        }
    }
}
