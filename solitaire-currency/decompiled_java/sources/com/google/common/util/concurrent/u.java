package com.google.common.util.concurrent;

import com.google.common.util.concurrent.e;
import com.ironsource.v8;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: TrustedListenableFutureTask.java */
/* JADX INFO: loaded from: classes3.dex */
class u<V> extends e.a<V> implements RunnableFuture<V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile l<?> f10211h;

    /* JADX INFO: compiled from: TrustedListenableFutureTask.java */
    private final class a extends l<V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Callable<V> f10212c;

        a(Callable<V> callable) {
            this.f10212c = (Callable) e5.o.j(callable);
        }

        @Override // com.google.common.util.concurrent.l
        void a(Throwable th) {
            u.this.B(th);
        }

        @Override // com.google.common.util.concurrent.l
        void b(V v10) {
            u.this.A(v10);
        }

        @Override // com.google.common.util.concurrent.l
        final boolean d() {
            return u.this.isDone();
        }

        @Override // com.google.common.util.concurrent.l
        V e() throws Exception {
            return this.f10212c.call();
        }

        @Override // com.google.common.util.concurrent.l
        String f() {
            return this.f10212c.toString();
        }
    }

    u(Callable<V> callable) {
        this.f10211h = new a(callable);
    }

    static <V> u<V> E(Runnable runnable, V v10) {
        return new u<>(Executors.callable(runnable, v10));
    }

    static <V> u<V> F(Callable<V> callable) {
        return new u<>(callable);
    }

    @Override // com.google.common.util.concurrent.a
    protected void m() {
        l<?> lVar;
        super.m();
        if (D() && (lVar = this.f10211h) != null) {
            lVar.c();
        }
        this.f10211h = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        l<?> lVar = this.f10211h;
        if (lVar != null) {
            lVar.run();
        }
        this.f10211h = null;
    }

    @Override // com.google.common.util.concurrent.a
    protected String x() {
        l<?> lVar = this.f10211h;
        if (lVar == null) {
            return super.x();
        }
        return "task=[" + lVar + v8.i.f15839e;
    }
}
