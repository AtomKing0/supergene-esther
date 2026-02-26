package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultScopesStorage.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class r implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ThreadLocal<f1> f28135a = new ThreadLocal<>();

    /* JADX INFO: compiled from: DefaultScopesStorage.java */
    static final class a implements k1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final f1 f28136a;

        a(@Nullable f1 f1Var) {
            this.f28136a = f1Var;
        }

        @Override // io.sentry.k1, java.lang.AutoCloseable
        public void close() {
            r.f28135a.set(this.f28136a);
        }
    }

    @Override // io.sentry.g1
    public k1 b(@Nullable f1 f1Var) {
        f1 f1Var2 = get();
        f28135a.set(f1Var);
        return new a(f1Var2);
    }

    @Override // io.sentry.g1
    public void close() {
        f28135a.remove();
    }

    @Override // io.sentry.g1
    @Nullable
    public f1 get() {
        return f28135a.get();
    }

    @Override // io.sentry.g1
    public void a() {
    }
}
