package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.s3;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends AppLovinAdImpl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AppLovinAd f6968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.applovin.impl.s f6969f;

    public c(com.applovin.impl.s sVar, com.applovin.impl.sdk.j jVar) {
        super(new JSONObject(), new JSONObject(), jVar);
        this.f6969f = sVar;
    }

    private AppLovinAd d() {
        return (AppLovinAd) this.sdk.i().f(this.f6969f);
    }

    private String e() {
        com.applovin.impl.s adZone = getAdZone();
        if (adZone == null || adZone.i()) {
            return null;
        }
        return adZone.e();
    }

    public void a(AppLovinAd appLovinAd) {
        this.f6968e = appLovinAd;
    }

    public AppLovinAd c() {
        AppLovinAd appLovinAd = this.f6968e;
        return appLovinAd != null ? appLovinAd : d();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        AppLovinAd appLovinAdC = c();
        return appLovinAdC != null ? appLovinAdC.equals(obj) : super.equals(obj);
    }

    public AppLovinAd f() {
        return this.f6968e;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public s3 getAdEventTracker() {
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.impl.sdk.AppLovinAdBase
    public long getAdIdNumber() {
        AppLovinAd appLovinAdC = c();
        if (appLovinAdC instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) appLovinAdC).getAdIdNumber();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public com.applovin.impl.s getAdZone() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) c();
        return appLovinAdImpl != null ? appLovinAdImpl.getAdZone() : this.f6969f;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        AppLovinAd appLovinAdC = c();
        if (appLovinAdC instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) appLovinAdC).getCreatedAtMillis();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        return new Bundle();
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public String getOpenMeasurementContentUrl() {
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public String getOpenMeasurementCustomReferenceData() {
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public List getOpenMeasurementVerificationScriptResources() {
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        AppLovinAd appLovinAdC = c();
        if (appLovinAdC instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) appLovinAdC).getOriginalFullResponse();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return getAdZone().f();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return getAdZone().g();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (this.f6969f.i()) {
            return null;
        }
        return this.f6969f.e();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        AppLovinAd appLovinAdC = c();
        return appLovinAdC != null ? appLovinAdC.hashCode() : super.hashCode();
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return false;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean isExpired() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) c();
        return appLovinAdImpl != null && appLovinAdImpl.isExpired();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public boolean isOpenMeasurementEnabled() {
        return false;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean isVideoAd() {
        AppLovinAd appLovinAdC = c();
        return (appLovinAdC instanceof AppLovinAdImpl) && ((AppLovinAdImpl) appLovinAdC).isVideoAd();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + e() + "'}";
    }
}
