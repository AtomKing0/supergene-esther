package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.i9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkSettings {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f13700r = "customNetwork";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f13701s = "customNetworkPackage";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f13702t = "customNetworkAdapterName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f13705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f13706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f13707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f13708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONObject f13709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f13711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f13712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f13713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f13714l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f13715m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f13716n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f13717o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f13718p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f13719q;

    public NetworkSettings(NetworkSettings networkSettings) {
        this.f13703a = networkSettings.getProviderName();
        this.f13713k = networkSettings.getProviderName();
        this.f13704b = networkSettings.getProviderTypeForReflection();
        this.f13706d = networkSettings.getRewardedVideoSettings();
        this.f13707e = networkSettings.getInterstitialSettings();
        this.f13708f = networkSettings.getBannerSettings();
        this.f13709g = networkSettings.getNativeAdSettings();
        this.f13705c = networkSettings.getApplicationSettings();
        this.f13714l = networkSettings.getRewardedVideoPriority();
        this.f13715m = networkSettings.getInterstitialPriority();
        this.f13716n = networkSettings.getBannerPriority();
        this.f13717o = networkSettings.getNativeAdPriority();
        this.f13718p = networkSettings.getProviderDefaultInstance();
        this.f13719q = networkSettings.getProviderNetworkKey();
    }

    public String getAdSourceNameForEvents() {
        return this.f13711i;
    }

    public JSONObject getApplicationSettings() {
        return this.f13705c;
    }

    public int getBannerPriority() {
        return this.f13716n;
    }

    public JSONObject getBannerSettings() {
        return this.f13708f;
    }

    public String getCustomNetwork() {
        JSONObject jSONObject = this.f13705c;
        if (jSONObject != null) {
            return jSONObject.optString("customNetwork");
        }
        return null;
    }

    public String getCustomNetworkAdapterName(IronSource.AD_UNIT ad_unit) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if ((ad_unit == null && (jSONObject2 = this.f13705c) != null) || ((ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) && (jSONObject2 = this.f13706d) != null) || ((ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL) && (jSONObject2 = this.f13707e) != null) || (ad_unit.equals(IronSource.AD_UNIT.BANNER) && (jSONObject2 = this.f13708f) != null)))) {
            return jSONObject2.optString(f13702t);
        }
        if (!ad_unit.equals(IronSource.AD_UNIT.NATIVE_AD) || (jSONObject = this.f13709g) == null) {
            return null;
        }
        return jSONObject.optString(f13702t);
    }

    public String getCustomNetworkPackage() {
        JSONObject jSONObject = this.f13705c;
        return jSONObject != null ? jSONObject.optString(f13701s, "") : "";
    }

    public int getInstanceType(IronSource.AD_UNIT ad_unit) {
        JSONObject nativeAdSettings;
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            nativeAdSettings = getRewardedVideoSettings();
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            nativeAdSettings = getInterstitialSettings();
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            nativeAdSettings = getBannerSettings();
        } else {
            if (ad_unit != IronSource.AD_UNIT.NATIVE_AD) {
                return 1;
            }
            nativeAdSettings = getNativeAdSettings();
        }
        return nativeAdSettings.optInt("instanceType");
    }

    public int getInterstitialPriority() {
        return this.f13715m;
    }

    public JSONObject getInterstitialSettings() {
        return this.f13707e;
    }

    public int getMaxAdsPerSession(IronSource.AD_UNIT ad_unit) {
        JSONObject nativeAdSettings;
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            nativeAdSettings = getRewardedVideoSettings();
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            nativeAdSettings = getInterstitialSettings();
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            nativeAdSettings = getBannerSettings();
        } else {
            if (ad_unit != IronSource.AD_UNIT.NATIVE_AD) {
                return 99;
            }
            nativeAdSettings = getNativeAdSettings();
        }
        return nativeAdSettings.optInt("maxAdsPerSession", 99);
    }

    public int getNativeAdPriority() {
        return this.f13717o;
    }

    public JSONObject getNativeAdSettings() {
        return this.f13709g;
    }

    public String getProviderDefaultInstance() {
        return this.f13718p;
    }

    public String getProviderInstanceName() {
        return this.f13713k;
    }

    public String getProviderName() {
        return this.f13703a;
    }

    public String getProviderNetworkKey() {
        return this.f13719q;
    }

    public String getProviderTypeForReflection() {
        return this.f13704b;
    }

    public int getRewardedVideoPriority() {
        return this.f13714l;
    }

    public JSONObject getRewardedVideoSettings() {
        return this.f13706d;
    }

    public String getSubProviderId() {
        return this.f13710h;
    }

    public boolean isBidder(IronSource.AD_UNIT ad_unit) {
        return !isCustomNetwork() && getInstanceType(ad_unit) == 2;
    }

    public boolean isCustomNetwork() {
        return !TextUtils.isEmpty(getCustomNetwork());
    }

    public boolean isIronSource() {
        return getProviderTypeForReflection().equalsIgnoreCase("IronSource");
    }

    public boolean isMultipleInstances() {
        return this.f13712j;
    }

    public void setAdSourceNameForEvents(String str) {
        this.f13711i = str;
    }

    public void setApplicationSettings(JSONObject jSONObject) {
        this.f13705c = jSONObject;
    }

    public void setBannerPriority(int i10) {
        this.f13716n = i10;
    }

    public void setBannerSettings(String str, Object obj) {
        try {
            this.f13708f.put(str, obj);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void setInterstitialPriority(int i10) {
        this.f13715m = i10;
    }

    public void setInterstitialSettings(String str, Object obj) {
        try {
            this.f13707e.put(str, obj);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void setIsMultipleInstances(boolean z10) {
        this.f13712j = z10;
    }

    public void setNativeAdPriority(int i10) {
        this.f13717o = i10;
    }

    public void setNativeAdSettings(String str, Object obj) {
        try {
            this.f13709g.put(str, obj);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void setProviderNetworkKey(String str) {
        this.f13719q = str;
    }

    public void setRewardedVideoPriority(int i10) {
        this.f13714l = i10;
    }

    public void setRewardedVideoSettings(String str, Object obj) {
        try {
            this.f13706d.put(str, obj);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void setSubProviderId(String str) {
        this.f13710h = str;
    }

    public boolean shouldEarlyInit() {
        JSONObject jSONObject = this.f13705c;
        if (jSONObject != null) {
            return jSONObject.optBoolean(IronSourceConstants.EARLY_INIT_FIELD);
        }
        return false;
    }

    public NetworkSettings(String str) {
        this.f13703a = str;
        this.f13713k = str;
        this.f13704b = str;
        this.f13718p = str;
        this.f13719q = str;
        this.f13706d = new JSONObject();
        this.f13707e = new JSONObject();
        this.f13708f = new JSONObject();
        this.f13709g = new JSONObject();
        this.f13705c = new JSONObject();
        this.f13714l = -1;
        this.f13715m = -1;
        this.f13716n = -1;
        this.f13717o = -1;
    }

    public void setBannerSettings(JSONObject jSONObject) {
        this.f13708f = jSONObject;
    }

    public void setInterstitialSettings(JSONObject jSONObject) {
        this.f13707e = jSONObject;
    }

    public void setNativeAdSettings(JSONObject jSONObject) {
        this.f13709g = jSONObject;
    }

    public void setRewardedVideoSettings(JSONObject jSONObject) {
        this.f13706d = jSONObject;
    }

    public NetworkSettings(String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        this.f13703a = str;
        this.f13713k = str;
        this.f13704b = str2;
        this.f13718p = str3;
        this.f13719q = str4;
        this.f13706d = jSONObject2;
        this.f13707e = jSONObject3;
        this.f13708f = jSONObject4;
        this.f13709g = jSONObject5;
        this.f13705c = jSONObject;
        this.f13714l = -1;
        this.f13715m = -1;
        this.f13716n = -1;
        this.f13717o = -1;
    }
}
