package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map f6784e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f6785f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f6786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppLovinAdSize f6788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAdType f6789d;

    private s(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, boolean z10, boolean z11) {
        String lowerCase;
        if (TextUtils.isEmpty(str) && (appLovinAdType == null || appLovinAdSize == null)) {
            throw new IllegalArgumentException("No zone identifier or type or size specified");
        }
        this.f6788c = appLovinAdSize;
        this.f6789d = appLovinAdType;
        if (StringUtils.isValidString(str)) {
            lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        } else {
            lowerCase = (appLovinAdSize.getLabel() + "_" + appLovinAdType.getLabel()).toLowerCase(Locale.ENGLISH);
        }
        if (z10) {
            lowerCase = lowerCase + "_bidding";
        }
        if (z11) {
            lowerCase = lowerCase + "_direct_sold";
        }
        this.f6787b = lowerCase;
    }

    public static s a(String str) {
        return a(null, null, str);
    }

    public static s b(String str) {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str);
    }

    public static s c() {
        return a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR);
    }

    public static s h() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED);
    }

    public static s j() {
        return a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR);
    }

    public static s k() {
        return a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR);
    }

    public static s l() {
        return a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE);
    }

    public static s m() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
    }

    public MaxAdFormat d() {
        AppLovinAdSize appLovinAdSizeF = f();
        if (appLovinAdSizeF == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (appLovinAdSizeF == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (appLovinAdSizeF == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (appLovinAdSizeF != AppLovinAdSize.INTERSTITIAL) {
            if (appLovinAdSizeF == AppLovinAdSize.NATIVE) {
                return MaxAdFormat.NATIVE;
            }
            return null;
        }
        if (g() == AppLovinAdType.REGULAR) {
            return MaxAdFormat.INTERSTITIAL;
        }
        if (g() == AppLovinAdType.APP_OPEN) {
            return MaxAdFormat.APP_OPEN;
        }
        if (g() == AppLovinAdType.INCENTIVIZED) {
            return MaxAdFormat.REWARDED;
        }
        return null;
    }

    public String e() {
        return this.f6787b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        return this.f6787b.equalsIgnoreCase(((s) obj).f6787b);
    }

    public AppLovinAdSize f() {
        if (this.f6788c == null && JsonUtils.valueExists(this.f6786a, "ad_size")) {
            this.f6788c = AppLovinAdSize.fromString(JsonUtils.getString(this.f6786a, "ad_size", null));
        }
        return this.f6788c;
    }

    public AppLovinAdType g() {
        if (this.f6789d == null && JsonUtils.valueExists(this.f6786a, "ad_type")) {
            this.f6789d = AppLovinAdType.fromString(JsonUtils.getString(this.f6786a, "ad_type", null));
        }
        return this.f6789d;
    }

    public int hashCode() {
        return this.f6787b.hashCode();
    }

    public boolean i() {
        return a().contains(this);
    }

    public String toString() {
        return "AdZone{id=" + this.f6787b + ", zoneObject=" + this.f6786a + '}';
    }

    public static s a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return a(appLovinAdSize, appLovinAdType, null);
    }

    public static s b() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.APP_OPEN);
    }

    public static s a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        return a(appLovinAdSize, appLovinAdType, str, false, false);
    }

    public static s a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, boolean z10, boolean z11) {
        s sVar = new s(appLovinAdSize, appLovinAdType, str, z10, z11);
        synchronized (f6785f) {
            String str2 = sVar.f6787b;
            Map map = f6784e;
            if (map.containsKey(str2)) {
                sVar = (s) map.get(str2);
            } else {
                map.put(str2, sVar);
            }
        }
        return sVar;
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has("ad_type")) {
            synchronized (f6785f) {
                s sVar = (s) f6784e.get(JsonUtils.getString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, ""));
                if (sVar != null) {
                    sVar.f6788c = AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", ""));
                    sVar.f6789d = AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", ""));
                }
            }
        }
    }

    public static Collection a() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(7);
        Collections.addAll(linkedHashSet, c(), k(), j(), m(), b(), h(), l());
        return Collections.unmodifiableSet(linkedHashSet);
    }
}
