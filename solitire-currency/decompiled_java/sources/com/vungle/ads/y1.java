package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class y1 extends b2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(@NotNull String errorMessage) {
        super(Integer.valueOf(b2.UNKNOWN_EXCEPTION_CODE), Sdk$SDKError.b.UNKNOWN_ERROR, errorMessage, null, null, null, 56, null);
        kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
    }
}
