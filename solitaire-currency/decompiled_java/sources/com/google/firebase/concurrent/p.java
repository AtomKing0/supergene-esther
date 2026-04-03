package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DelegatingScheduledFuture.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"RestrictedApi"})
class p<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledFuture<?> f10289a;

    /* JADX INFO: compiled from: DelegatingScheduledFuture.java */
    class a implements b<V> {
        a() {
        }

        @Override // com.google.firebase.concurrent.p.b
        public void a(Throwable th) {
            p.this.setException(th);
        }

        @Override // com.google.firebase.concurrent.p.b
        public void set(V v10) {
            p.this.set(v10);
        }
    }

    /* JADX INFO: compiled from: DelegatingScheduledFuture.java */
    interface b<T> {
        void a(Throwable th);

        void set(T t10);
    }

    /* JADX INFO: compiled from: DelegatingScheduledFuture.java */
    interface c<T> {
        ScheduledFuture<?> a(b<T> bVar);
    }

    p(c<V> cVar) {
        this.f10289a = cVar.a(new a());
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    protected void afterDone() {
        this.f10289a.cancel(wasInterrupted());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f10289a.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f10289a.getDelay(timeUnit);
    }
}
