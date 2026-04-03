package io.sentry;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpScopesStorage.java */
/* JADX INFO: loaded from: classes5.dex */
public final class x2 implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x2 f28459a = new x2();

    private x2() {
    }

    public static x2 c() {
        return f28459a;
    }

    @Override // io.sentry.g1
    public k1 b(@Nullable f1 f1Var) {
        return w2.a();
    }

    @Override // io.sentry.g1
    @Nullable
    public f1 get() {
        return v2.a();
    }

    @Override // io.sentry.g1
    public void a() {
    }

    @Override // io.sentry.g1
    public void close() {
    }
}
