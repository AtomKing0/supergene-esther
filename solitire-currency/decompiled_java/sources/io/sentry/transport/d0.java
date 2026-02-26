package io.sentry.transport;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TransportResult.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d0 {

    /* JADX INFO: compiled from: TransportResult.java */
    private static final class b extends d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28266a;

        b(int i10) {
            super();
            this.f28266a = i10;
        }

        @Override // io.sentry.transport.d0
        public int c() {
            return this.f28266a;
        }

        @Override // io.sentry.transport.d0
        public boolean d() {
            return false;
        }
    }

    /* JADX INFO: compiled from: TransportResult.java */
    private static final class c extends d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f28267a = new c();

        private c() {
            super();
        }

        @Override // io.sentry.transport.d0
        public int c() {
            return -1;
        }

        @Override // io.sentry.transport.d0
        public boolean d() {
            return true;
        }
    }

    private d0() {
    }

    @NotNull
    public static d0 a() {
        return b(-1);
    }

    @NotNull
    public static d0 b(int i10) {
        return new b(i10);
    }

    @NotNull
    public static d0 e() {
        return c.f28267a;
    }

    public abstract int c();

    public abstract boolean d();
}
