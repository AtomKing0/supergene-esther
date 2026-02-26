package io.sentry;

/* JADX INFO: compiled from: NoOpScopesLifecycleToken.java */
/* JADX INFO: loaded from: classes5.dex */
public final class w2 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final w2 f28452a = new w2();

    private w2() {
    }

    public static w2 a() {
        return f28452a;
    }

    @Override // io.sentry.k1, java.lang.AutoCloseable
    public void close() {
    }
}
