package io.sentry.transport;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProxyAuthenticator.java */
/* JADX INFO: loaded from: classes5.dex */
final class w extends Authenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f28299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f28300b;

    w(@NotNull String str, @NotNull String str2) {
        this.f28299a = (String) io.sentry.util.w.c(str, "user is required");
        this.f28300b = (String) io.sentry.util.w.c(str2, "password is required");
    }

    @Override // java.net.Authenticator
    @Nullable
    protected PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() == Authenticator.RequestorType.PROXY) {
            return new PasswordAuthentication(this.f28299a, this.f28300b.toCharArray());
        }
        return null;
    }
}
