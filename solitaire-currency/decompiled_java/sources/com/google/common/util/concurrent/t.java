package com.google.common.util.concurrent;

import com.google.common.util.concurrent.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SettableFuture.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t<V> extends a.j<V> {
    private t() {
    }

    public static <V> t<V> E() {
        return new t<>();
    }

    @Override // com.google.common.util.concurrent.a
    public boolean A(V v10) {
        return super.A(v10);
    }

    @Override // com.google.common.util.concurrent.a
    public boolean B(Throwable th) {
        return super.B(th);
    }

    @Override // com.google.common.util.concurrent.a
    public boolean C(m<? extends V> mVar) {
        return super.C(mVar);
    }

    @Override // com.google.common.util.concurrent.a.j, com.google.common.util.concurrent.a, com.google.common.util.concurrent.m
    public /* bridge */ /* synthetic */ void addListener(Runnable runnable, Executor executor) {
        super.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.a.j, com.google.common.util.concurrent.a, java.util.concurrent.Future
    public /* bridge */ /* synthetic */ boolean cancel(boolean z10) {
        return super.cancel(z10);
    }

    @Override // com.google.common.util.concurrent.a.j, com.google.common.util.concurrent.a, java.util.concurrent.Future
    public /* bridge */ /* synthetic */ Object get() throws ExecutionException, InterruptedException {
        return super.get();
    }

    @Override // com.google.common.util.concurrent.a.j, com.google.common.util.concurrent.a, java.util.concurrent.Future
    public /* bridge */ /* synthetic */ boolean isCancelled() {
        return super.isCancelled();
    }
}
