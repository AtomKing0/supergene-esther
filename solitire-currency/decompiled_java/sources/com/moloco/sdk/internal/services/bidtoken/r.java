package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.service_locator.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f18552a = a.f18553a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18553a = new a();

        @NotNull
        public final r a() {
            return new s(a.h.f18920a.f(), p.f18482a.a(), com.moloco.sdk.internal.services.encryption.a.f18631a.a(), com.moloco.sdk.internal.services.bidtoken.providers.l.f18519a.a());
        }
    }

    @Nullable
    Object a(@NotNull String str, @NotNull g gVar, @NotNull z8.d<? super v8.t<String>> dVar);
}
