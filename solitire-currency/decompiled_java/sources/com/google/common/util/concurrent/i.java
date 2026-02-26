package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: Futures.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends k {

    /* JADX INFO: compiled from: Futures.java */
    private static final class a<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Future<V> f10202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h<? super V> f10203b;

        a(Future<V> future, h<? super V> hVar) {
            this.f10202a = future;
            this.f10203b = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Future<V> future = this.f10202a;
            if ((future instanceof h5.a) && (thA = h5.b.a((h5.a) future)) != null) {
                this.f10203b.onFailure(thA);
                return;
            }
            try {
                this.f10203b.onSuccess(i.b(this.f10202a));
            } catch (Error e10) {
                e = e10;
                this.f10203b.onFailure(e);
            } catch (RuntimeException e11) {
                e = e11;
                this.f10203b.onFailure(e);
            } catch (ExecutionException e12) {
                this.f10203b.onFailure(e12.getCause());
            }
        }

        public String toString() {
            return e5.i.b(this).c(this.f10203b).toString();
        }
    }

    public static <V> void a(m<V> mVar, h<? super V> hVar, Executor executor) {
        e5.o.j(hVar);
        mVar.addListener(new a(mVar, hVar), executor);
    }

    public static <V> V b(Future<V> future) throws ExecutionException {
        e5.o.q(future.isDone(), "Future was expected to be done: %s", future);
        return (V) v.a(future);
    }
}
