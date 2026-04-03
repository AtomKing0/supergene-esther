package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n1 extends b2 {
    public n1(@Nullable String str) {
        super(207, Sdk$SDKError.b.PLACEMENT_AD_TYPE_MISMATCH, str + " Ad type does not match with placement type.", str, null, null, 48, null);
    }
}
