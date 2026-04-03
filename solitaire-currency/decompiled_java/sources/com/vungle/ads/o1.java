package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o1 extends b2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(@NotNull String placementId) {
        super(201, Sdk$SDKError.b.INVALID_PLACEMENT_ID, "Placement '" + placementId + "' is invalid", placementId, null, null, 48, null);
        kotlin.jvm.internal.t.i(placementId, "placementId");
    }
}
