package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: FcmExecutors.java */
/* JADX INFO: loaded from: classes3.dex */
class n {
    @SuppressLint({"ThreadPoolCreation"})
    private static Executor a(String str) {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(str));
    }

    static Executor b() {
        return a("Firebase-Messaging-File-Io");
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ScheduledExecutorService c() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init"));
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ExecutorService d() {
        return e6.b.a().a(new NamedThreadFactory("Firebase-Messaging-Intent-Handle"), e6.c.HIGH_SPEED);
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ExecutorService e() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Network-Io"));
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ExecutorService f() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Task"));
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ScheduledExecutorService g() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io"));
    }
}
