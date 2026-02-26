package io.sentry.android.core;

import io.sentry.SentryOptions;
import io.sentry.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: AndroidTransportGate.java */
/* JADX INFO: loaded from: classes5.dex */
final class j0 implements io.sentry.transport.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27356a;

    /* JADX INFO: compiled from: AndroidTransportGate.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27357a;

        static {
            int[] iArr = new int[r0.a.values().length];
            f27357a = iArr;
            try {
                iArr[r0.a.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27357a[r0.a.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27357a[r0.a.NO_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    j0(@NotNull SentryOptions sentryOptions) {
        this.f27356a = sentryOptions;
    }

    @TestOnly
    boolean a(@NotNull r0.a aVar) {
        int i10 = a.f27357a[aVar.ordinal()];
        return i10 == 1 || i10 == 2 || i10 == 3;
    }

    @Override // io.sentry.transport.s
    public boolean isConnected() {
        return a(this.f27356a.getConnectionStatusProvider().a());
    }
}
