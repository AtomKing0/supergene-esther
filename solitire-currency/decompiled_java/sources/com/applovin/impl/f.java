package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.y1;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f extends z1 {
    public f(com.applovin.impl.sdk.j jVar) {
        super(jVar, y1.b.AD);
    }

    public void a(y1 y1Var, com.applovin.impl.sdk.ad.b bVar) {
        a(y1Var, bVar, new HashMap());
    }

    public void a(y1 y1Var, com.applovin.impl.sdk.ad.b bVar, Map map) {
        a(y1Var, bVar != null ? bVar.getAdZone() : null, bVar, null, map);
    }

    public void a(y1 y1Var, s sVar, AppLovinError appLovinError) {
        a(y1Var, sVar, null, appLovinError, new HashMap());
    }

    private void a(y1 y1Var, s sVar, com.applovin.impl.sdk.ad.b bVar, AppLovinError appLovinError, Map map) {
        if (((Boolean) this.f7884a.a(l4.H)).booleanValue() && this.f7884a.z0()) {
            return;
        }
        if (bVar != null) {
            map.putAll(a2.b(bVar));
        } else if (sVar != null) {
            CollectionUtils.putStringIfValid("ad_zone_id", sVar.e(), map);
            MaxAdFormat maxAdFormatD = sVar.d();
            if (maxAdFormatD != null) {
                CollectionUtils.putStringIfValid("ad_format", maxAdFormatD.getLabel(), map);
            }
        }
        AppLovinAdSize appLovinAdSizeA = a(sVar, bVar);
        if (appLovinAdSizeA != null) {
            CollectionUtils.putStringIfValid("ad_size", appLovinAdSizeA.getLabel(), map);
        }
        if (appLovinError != null) {
            CollectionUtils.putStringIfValid("error_message", appLovinError.getMessage(), map);
            CollectionUtils.putStringIfValid("error_code", String.valueOf(appLovinError.getCode()), map);
        }
        d(y1Var, map);
    }

    private AppLovinAdSize a(s sVar, com.applovin.impl.sdk.ad.b bVar) {
        AppLovinAdSize appLovinAdSizeF = sVar != null ? sVar.f() : null;
        if (appLovinAdSizeF != null) {
            return appLovinAdSizeF;
        }
        if (bVar != null) {
            return bVar.getSize();
        }
        return null;
    }
}
