package io.sentry.util;

import io.sentry.k1;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyEvaluator.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class r<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a<T> f28368b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private volatile T f28367a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f28369c = new io.sentry.util.a();

    /* JADX INFO: compiled from: LazyEvaluator.java */
    public interface a<T> {
        @NotNull
        T a();
    }

    public r(@NotNull a<T> aVar) {
        this.f28368b = aVar;
    }

    @NotNull
    public T a() {
        if (this.f28367a == null) {
            k1 k1VarA = this.f28369c.a();
            try {
                if (this.f28367a == null) {
                    this.f28367a = this.f28368b.a();
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return this.f28367a;
    }

    public void b() {
        k1 k1VarA = this.f28369c.a();
        try {
            this.f28367a = null;
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void c(@Nullable T t10) {
        k1 k1VarA = this.f28369c.a();
        try {
            this.f28367a = t10;
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
