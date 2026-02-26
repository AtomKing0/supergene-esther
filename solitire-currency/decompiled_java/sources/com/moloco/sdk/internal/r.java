package com.moloco.sdk.internal;

import com.moloco.sdk.publisher.MolocoAdError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class r {
    @NotNull
    public static final q a(@NotNull String adUnitId, @NotNull MolocoAdError.ErrorType errorType, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c subErrorType) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(errorType, "errorType");
        kotlin.jvm.internal.t.i(subErrorType, "subErrorType");
        return new q(new MolocoAdError("Moloco", adUnitId, errorType, null, 8, null), subErrorType);
    }
}
