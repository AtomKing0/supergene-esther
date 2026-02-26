package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    @NotNull
    public static final AdLoad a(@NotNull o0 scope, @NotNull h9.l<? super Long, q9.b> timeout, @NotNull String adUnitId, @NotNull h9.l<? super com.moloco.sdk.internal.ortb.model.c, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> recreateXenossAdLoader, @NotNull AdFormatType adFormatType) {
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(timeout, "timeout");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(recreateXenossAdLoader, "recreateXenossAdLoader");
        kotlin.jvm.internal.t.i(adFormatType, "adFormatType");
        return new g(scope, timeout, adUnitId, recreateXenossAdLoader, com.moloco.sdk.internal.ortb.c.a(), z.a(), adFormatType);
    }
}
