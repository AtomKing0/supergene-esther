package com.applovin.impl;

import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class l5 extends n5 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final i f5794j;

    public l5(i iVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(s.a("adtoken_zone"), "TaskFetchNativeTokenAd", appLovinNativeAdLoadListener, jVar);
        this.f5794j = iVar;
    }

    @Override // com.applovin.impl.f5
    protected Map h() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.f5794j.b());
        map.put("adtoken_prefix", this.f5794j.d());
        return map;
    }
}
