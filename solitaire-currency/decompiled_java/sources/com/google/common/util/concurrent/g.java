package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ForwardingListenableFuture.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g<V> extends f<V> implements m<V> {

    /* JADX INFO: compiled from: ForwardingListenableFuture.java */
    public static abstract class a<V> extends g<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m<V> f10201a;

        protected a(m<V> mVar) {
            this.f10201a = (m) e5.o.j(mVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.u
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final m<V> delegate() {
            return this.f10201a;
        }
    }

    protected g() {
    }

    @Override // com.google.common.util.concurrent.m
    public void addListener(Runnable runnable, Executor executor) {
        a().addListener(runnable, executor);
    }

    /* JADX INFO: renamed from: c */
    protected abstract m<? extends V> a();
}
