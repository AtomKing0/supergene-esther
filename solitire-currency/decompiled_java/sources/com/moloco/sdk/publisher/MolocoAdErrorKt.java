package com.moloco.sdk.publisher;

import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class MolocoAdErrorKt {
    @NotNull
    public static final MolocoAdError createAdErrorInfo(@NotNull String adUnitId, @NotNull MolocoAdError.ErrorType errorType) {
        t.i(adUnitId, "adUnitId");
        t.i(errorType, "errorType");
        return new MolocoAdError("Moloco", adUnitId, errorType, null, 8, null);
    }
}
