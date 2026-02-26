package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
final class d extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f9970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ReentrantLock f9971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Condition f9972c;

    private d() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f9971b = reentrantLock;
        this.f9972c = reentrantLock.newCondition();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Log.i("SwappyDisplayManager", "Starting looper thread");
        this.f9971b.lock();
        Looper.prepare();
        this.f9970a = new Handler();
        this.f9972c.signal();
        this.f9971b.unlock();
        Looper.loop();
        Log.i("SwappyDisplayManager", "Terminating looper thread");
    }

    @Override // java.lang.Thread
    public final void start() {
        this.f9971b.lock();
        super.start();
        try {
            this.f9972c.await();
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.f9971b.unlock();
    }
}
