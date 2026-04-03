package com.applovin.impl;

import android.text.TextUtils;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class v1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f7552b = new HashSet(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set f7553c = new HashSet(16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v1 f7554d = a(ServiceProvider.NAMED_AD_REQ);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v1 f7555e = a("ad_imp");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v1 f7556f = a("max_ad_imp");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v1 f7557g = a("ad_session_start");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v1 f7558h = a("ad_imp_session");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v1 f7559i = a("max_ad_imp_session");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v1 f7560j = a("cached_files_expired");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v1 f7561k = a("cache_drop_count");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v1 f7562l = a("sdk_reset_state_count", true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v1 f7563m = a("ad_response_process_failures", true);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final v1 f7564n = a("response_process_failures", true);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v1 f7565o = a("incent_failed_to_display_count", true);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final v1 f7566p = a("app_paused_and_resumed");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final v1 f7567q = a("ad_rendered_with_mismatched_sdk_key", true);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final v1 f7568r = a("ad_shown_outside_app_count");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final v1 f7569s = a("med_ad_req");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final v1 f7570t = a("med_ad_response_process_failures", true);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final v1 f7571u = a("med_waterfall_ad_no_fill", true);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final v1 f7572v = a("med_waterfall_ad_adapter_load_failed", true);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final v1 f7573w = a("med_waterfall_ad_invalid_response", true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7574a;

    static {
        a("fullscreen_ad_nil_vc_count");
        a("applovin_bundle_missing");
    }

    private v1(String str) {
        this.f7574a = str;
    }

    private static v1 a(String str) {
        return a(str, false);
    }

    public String b() {
        return this.f7574a;
    }

    private static v1 a(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        }
        Set set = f7552b;
        if (set.contains(str)) {
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
        set.add(str);
        v1 v1Var = new v1(str);
        if (z10) {
            f7553c.add(v1Var);
        }
        return v1Var;
    }

    public static Set a() {
        return f7553c;
    }
}
