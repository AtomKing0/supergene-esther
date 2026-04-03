package io.sentry.transport;

import java.net.Authenticator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AuthenticatorWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final m f28289a = new m();

    private m() {
    }

    public static m a() {
        return f28289a;
    }

    public void b(@NotNull Authenticator authenticator) {
        Authenticator.setDefault(authenticator);
    }
}
