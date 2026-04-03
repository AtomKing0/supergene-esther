package com.vungle.ads.internal.executor;

import com.vungle.ads.internal.util.p;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FutureResult.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b<T> implements Future<T> {

    @NotNull
    public static final a Companion = new a(null);
    private static final String TAG = b.class.getSimpleName();

    @Nullable
    private final Future<T> future;

    /* JADX INFO: compiled from: FutureResult.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        public final String getTAG() {
            return b.TAG;
        }
    }

    public b(@Nullable Future<T> future) {
        this.future = future;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        Future<T> future = this.future;
        if (future != null) {
            return future.cancel(z10);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public T get() {
        try {
            Future<T> future = this.future;
            if (future != null) {
                return future.get();
            }
            return null;
        } catch (InterruptedException unused) {
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            t.h(TAG2, "TAG");
            aVar.w(TAG2, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e10) {
            p.a aVar2 = p.Companion;
            String TAG3 = TAG;
            t.h(TAG3, "TAG");
            aVar2.e(TAG3, "error on execution", e10);
            return null;
        }
    }

    @Nullable
    public final Future<T> getFuture() {
        return this.future;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Future<T> future = this.future;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Future<T> future = this.future;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public T get(long j10, @NotNull TimeUnit unit) {
        t.i(unit, "unit");
        try {
            Future<T> future = this.future;
            if (future != null) {
                return future.get(j10, unit);
            }
            return null;
        } catch (InterruptedException unused) {
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            t.h(TAG2, "TAG");
            aVar.w(TAG2, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e10) {
            p.a aVar2 = p.Companion;
            String TAG3 = TAG;
            t.h(TAG3, "TAG");
            aVar2.e(TAG3, "error on execution", e10);
            return null;
        } catch (TimeoutException e11) {
            p.a aVar3 = p.Companion;
            String TAG4 = TAG;
            t.h(TAG4, "TAG");
            aVar3.e(TAG4, "error on timeout", e11);
            t.h(TAG4, "TAG");
            aVar3.w(TAG4, "future.get() Timeout on Thread " + Thread.currentThread().getName());
            return null;
        }
    }
}
