package com.moloco.sdk.internal.services.encryption;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C0328a f18631a = C0328a.f18632a;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.encryption.a$a, reason: collision with other inner class name */
    public static final class C0328a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0328a f18632a = new C0328a();

        @NotNull
        public final a a() {
            return new b();
        }
    }

    @NotNull
    byte[] a(@NotNull String str);

    @NotNull
    byte[] a(@NotNull byte[] bArr);
}
