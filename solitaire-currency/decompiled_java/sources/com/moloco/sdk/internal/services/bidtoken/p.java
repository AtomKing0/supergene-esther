package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.service_locator.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f18482a = a.f18483a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18483a = new a();

        @NotNull
        public final p a() {
            a.e eVar = a.e.f18889a;
            return new q(eVar.f(), eVar.g());
        }
    }

    @NotNull
    com.moloco.sdk.e a(@NotNull com.moloco.sdk.internal.services.bidtoken.providers.k kVar, @NotNull g gVar);

    @NotNull
    byte[] b(@NotNull byte[] bArr, @NotNull byte[] bArr2);
}
