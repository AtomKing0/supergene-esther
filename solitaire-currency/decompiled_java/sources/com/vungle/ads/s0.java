package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s0 extends b2 {
    public s0(@Nullable String str) {
        super(222, Sdk$SDKError.b.INVALID_WATERFALL_PLACEMENT_ID, str + " header bidding status does not match with loadAd parameters", str, null, null, 48, null);
    }
}
