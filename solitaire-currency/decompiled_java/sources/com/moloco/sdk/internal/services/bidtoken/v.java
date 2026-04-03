package com.moloco.sdk.internal.services.bidtoken;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public interface v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f18570a = a.f18571a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18571a = new a();

        @NotNull
        public final v a(@NotNull com.moloco.sdk.internal.bidtoken.b bidTokenParser, @NotNull com.moloco.sdk.internal.services.r timeProviderService) {
            kotlin.jvm.internal.t.i(bidTokenParser, "bidTokenParser");
            kotlin.jvm.internal.t.i(timeProviderService, "timeProviderService");
            return new w(bidTokenParser, timeProviderService);
        }
    }

    @NotNull
    l a();

    @Nullable
    Object a(@NotNull z8.d<? super c> dVar);

    @Nullable
    Object b(@NotNull l lVar, @NotNull z8.d<? super k0> dVar);
}
