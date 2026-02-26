package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.applovin.impl.l4;
import com.applovin.impl.m1;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.v4;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppLovinAdImpl extends AppLovinAdBase implements AppLovinAd, m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f6930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.s f6931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f6933d;

    protected AppLovinAdImpl(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f6930a = new Bundle();
    }

    private long b() {
        return getLongFromAdObject("ad_expiration_ms", ((Long) this.sdk.a(l4.V0)).longValue());
    }

    public boolean canExpire() {
        return getSize() == AppLovinAdSize.INTERSTITIAL && b() > 0;
    }

    public boolean equals(Object obj) {
        AppLovinAd appLovinAdC;
        if ((obj instanceof c) && (appLovinAdC = ((c) obj).c()) != null) {
            obj = appLovinAdC;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && getAdIdNumber() == ((AppLovinAdImpl) obj).getAdIdNumber();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1L);
    }

    public com.applovin.impl.s getAdZone() {
        com.applovin.impl.s sVar = this.f6931b;
        if (sVar != null) {
            if (sVar.f() != null && this.f6931b.g() != null) {
                return this.f6931b;
            }
            if (getSize() == null && getType() == null) {
                return this.f6931b;
            }
        }
        com.applovin.impl.s sVarA = com.applovin.impl.s.a(getSize(), getType(), getStringFromFullResponse(AppLovinUtils.ServerParameterKeys.ZONE_ID, null), getBooleanFromFullResponse("is_bidding", false), getBooleanFromFullResponse("is_direct_sold", false));
        this.f6931b = sVarA;
        return sVarA;
    }

    public c getDummyAd() {
        return this.f6933d;
    }

    public Bundle getMAXAdValues() {
        return this.f6930a;
    }

    public abstract JSONObject getOriginalFullResponse();

    public String getRawFullResponse() {
        String string;
        v4 v4Var = this.synchronizedFullResponse;
        if (v4Var != null) {
            return v4Var.toString();
        }
        synchronized (this.fullResponseLock) {
            string = this.fullResponse.toString();
        }
        return string;
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", null));
    }

    @Override // com.applovin.impl.m1
    public long getTimeToLiveMillis() {
        if (!canExpire()) {
            return Long.MAX_VALUE;
        }
        return b() - (System.currentTimeMillis() - getCreatedAtMillis());
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse("ad_type", null));
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (getAdZone().i()) {
            return null;
        }
        return getStringFromFullResponse(AppLovinUtils.ServerParameterKeys.ZONE_ID, null);
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", Boolean.FALSE);
    }

    public boolean hasVideoUrl() {
        this.sdk.I();
        if (!com.applovin.impl.sdk.n.a()) {
            return false;
        }
        this.sdk.I().b("AppLovinAd", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return (int) getAdIdNumber();
    }

    public boolean isExpired() {
        return this.f6932c;
    }

    public boolean isVideoAd() {
        return this.adObject.has("is_video_ad") ? getBooleanFromAdObject("is_video_ad", Boolean.FALSE) : hasVideoUrl();
    }

    public void setDummyAd(c cVar) {
        this.f6933d = cVar;
    }

    @Override // com.applovin.impl.m1
    public void setExpired() {
        this.f6932c = true;
    }

    public void setHasShown(boolean z10) {
        try {
            v4 v4Var = this.synchronizedAdObject;
            if (v4Var != null) {
                v4Var.a("shown", (Object) Boolean.valueOf(z10));
                return;
            }
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z10);
            }
        } catch (Throwable unused) {
        }
    }

    public void setMaxAdValue(String str, Object obj) {
        BundleUtils.put(str, obj, this.f6930a);
    }

    @NonNull
    public String toString() {
        return "AppLovinAd{adIdNumber=" + getAdIdNumber() + ", zoneId=\"" + getZoneId() + "\"}";
    }
}
