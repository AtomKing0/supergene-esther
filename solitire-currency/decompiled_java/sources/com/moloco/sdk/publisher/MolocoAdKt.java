package com.moloco.sdk.publisher;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class MolocoAdKt {
    @NotNull
    public static final MolocoAd createAdInfo(@NotNull String adUnitId, @Nullable Float f10) {
        t.i(adUnitId, "adUnitId");
        return new MolocoAd("Moloco", adUnitId, f10);
    }

    public static /* synthetic */ MolocoAd createAdInfo$default(String str, Float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = null;
        }
        return createAdInfo(str, f10);
    }
}
