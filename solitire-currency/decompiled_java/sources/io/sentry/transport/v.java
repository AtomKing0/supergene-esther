package io.sentry.transport;

/* JADX INFO: compiled from: NoOpTransportGate.java */
/* JADX INFO: loaded from: classes5.dex */
public final class v implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final v f28298a = new v();

    private v() {
    }

    public static v a() {
        return f28298a;
    }

    @Override // io.sentry.transport.s
    public boolean isConnected() {
        return true;
    }
}
