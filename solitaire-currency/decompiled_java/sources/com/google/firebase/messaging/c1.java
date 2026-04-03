package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: TopicsStore.java */
/* JADX INFO: loaded from: classes3.dex */
final class c1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("TopicsStore.class")
    private static WeakReference<c1> f10376d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f10377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y0 f10378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f10379c;

    private c1(SharedPreferences sharedPreferences, Executor executor) {
        this.f10379c = executor;
        this.f10377a = sharedPreferences;
    }

    @WorkerThread
    public static synchronized c1 b(Context context, Executor executor) {
        c1 c1Var;
        WeakReference<c1> weakReference = f10376d;
        c1Var = weakReference != null ? weakReference.get() : null;
        if (c1Var == null) {
            c1Var = new c1(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
            c1Var.d();
            f10376d = new WeakReference<>(c1Var);
        }
        return c1Var;
    }

    @WorkerThread
    private synchronized void d() {
        this.f10378b = y0.d(this.f10377a, "topic_operation_queue", ",", this.f10379c);
    }

    synchronized boolean a(b1 b1Var) {
        return this.f10378b.b(b1Var.e());
    }

    @Nullable
    synchronized b1 c() {
        return b1.a(this.f10378b.f());
    }

    synchronized boolean e(b1 b1Var) {
        return this.f10378b.g(b1Var.e());
    }
}
