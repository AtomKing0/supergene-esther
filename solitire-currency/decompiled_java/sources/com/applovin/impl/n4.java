package com.applovin.impl;

import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;

/* JADX INFO: loaded from: classes2.dex */
public class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f6406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n4 f6381c = new n4("com.applovin.sdk.impl.isFirstRun", String.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n4 f6382d = new n4("com.applovin.sdk.launched_before", Boolean.class);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n4 f6383e = new n4("com.applovin.sdk.latest_installed_version", String.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n4 f6384f = new n4("com.applovin.sdk.install_date", Long.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n4 f6385g = new n4("com.applovin.sdk.user_id", String.class);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n4 f6386h = new n4("com.applovin.sdk.compass_id", String.class);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n4 f6387i = new n4("com.applovin.sdk.compass_random_token", String.class);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n4 f6388j = new n4("com.applovin.sdk.applovin_random_token", String.class);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n4 f6389k = new n4("com.applovin.sdk.device_test_group", String.class);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n4 f6390l = new n4("com.applovin.sdk.compliance.has_user_consent", Boolean.class);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final n4 f6391m = new n4("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final n4 f6392n = new n4("com.applovin.sdk.compliance.is_do_not_sell", Boolean.class);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final n4 f6393o = new n4("com.applovin.sdk.has_seen_but_not_accepted_privacy_policy", Boolean.class);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final n4 f6394p = new n4(OTIABTCFKeys.IABTCF_CMPSDKID, Object.class);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final n4 f6395q = new n4(OTIABTCFKeys.IABTCF_CMPSDKVERSION, Object.class);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final n4 f6396r = new n4(OTIABTCFKeys.IABTCF_GDPRAPPLIES, Object.class);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final n4 f6397s = new n4("IABTCF_TCString", String.class);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final n4 f6398t = new n4(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, String.class);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final n4 f6399u = new n4(OTIABTCFKeys.IABTCF_VENDORCONSENTS, String.class);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final n4 f6400v = new n4(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, String.class);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final n4 f6401w = new n4(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, String.class);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final n4 f6402x = new n4(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, String.class);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final n4 f6403y = new n4(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, String.class);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final n4 f6404z = new n4("com.applovin.sdk.stats", String.class);
    public static final n4 A = new n4("com.applovin.sdk.impl.ad.persistence.queue", String.class);
    public static final n4 B = new n4("com.applovin.sdk.mediation.signal_providers", String.class);
    public static final n4 C = new n4("com.applovin.sdk.mediation.auto_init_adapters", String.class);
    public static final n4 D = new n4("com.applovin.sdk.persisted_data", String.class);
    public static final n4 E = new n4("com.applovin.sdk.mediation.test_mode_enabled", Boolean.class);
    public static final n4 F = new n4("com.applovin.sdk.mediation.should_use_applovin_adaptive_sizing_formula", Boolean.class);
    public static final n4 G = new n4("com.applovin.sdk.user_agent", String.class);
    public static final n4 H = new n4("com.applovin.sdk.last_fullscreen_ad_timestamp_ms", Long.class);
    public static final n4 I = new n4("com.applovin.sdk.last_fullscreen_ad_duration_ms", Long.class);
    public static final n4 J = new n4("com.applovin.sdk.app_killed_urls_from_last_ad", String.class);
    public static final n4 K = new n4("com.applovin.sdk.app_killed_last_ad_data", String.class);
    public static final n4 L = new n4("com.applovin.sdk.template_browser_package_name", String.class);

    public n4(String str, Class cls) {
        this.f6405a = str;
        this.f6406b = cls;
    }

    public String a() {
        return this.f6405a;
    }

    public Class b() {
        return this.f6406b;
    }

    public String toString() {
        return "Key{name='" + this.f6405a + "', type=" + this.f6406b + '}';
    }
}
