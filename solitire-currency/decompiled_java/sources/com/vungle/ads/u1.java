package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u1 extends b2 {
    public u1() {
        super(Integer.valueOf(b2.SDK_VERSION_BELOW_REQUIRED_VERSION), Sdk$SDKError.b.API_REQUEST_ERROR, "Config: SDK is supported only for API versions 21 and above", null, null, null, 56, null);
    }
}
