package com.applovin.impl;

import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o5 extends m5 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final i f6466j;

    public o5(i iVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(s.a("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", jVar);
        this.f6466j = iVar;
    }

    @Override // com.applovin.impl.f5
    protected Map h() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.f6466j.b());
        map.put("adtoken_prefix", this.f6466j.d());
        return map;
    }
}
