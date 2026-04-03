package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q0 extends b2 {
    public q0() {
        this(0, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ q0(int i10, Sdk$SDKError.b bVar, String str, String str2, String str3, String str4, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? b2.INVALID_AD_STATE : i10, (i11 & 2) != 0 ? null : bVar, (i11 & 4) != 0 ? "Ad state is invalid" : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) == 0 ? str4 : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(int i10, @Nullable Sdk$SDKError.b bVar, @NotNull String errorMessage, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(Integer.valueOf(i10), bVar, errorMessage, str, str2, str3, null);
        kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
    }
}
