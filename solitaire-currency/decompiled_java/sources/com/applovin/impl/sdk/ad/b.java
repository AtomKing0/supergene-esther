package com.applovin.impl.sdk.ad;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.arch.core.util.Function;
import androidx.core.util.Consumer;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.applovin.impl.adview.e;
import com.applovin.impl.b1;
import com.applovin.impl.b4;
import com.applovin.impl.d4;
import com.applovin.impl.k0;
import com.applovin.impl.l4;
import com.applovin.impl.p7;
import com.applovin.impl.s3;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.applovin.impl.z6;
import com.applovin.impl.z7;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.unity3d.services.UnityAdsConstants;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends AppLovinAdImpl implements d4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f6942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f6943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f6944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicReference f6945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Bundle f6946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d f6947j;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.ad.b$b, reason: collision with other inner class name */
    public enum EnumC0172b {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    public enum c {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f6959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f6960e;

        private d() {
            this.f6956a = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.n(), b.this.m());
            this.f6957b = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.n(), b.this.o());
            this.f6958c = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.n(), b.this.k());
            this.f6959d = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.n(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(l4.f5624e1)).intValue());
            this.f6960e = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.n(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(l4.f5616d1)).intValue());
        }
    }

    public enum e {
        RESIZE_ASPECT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public b(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f6942e = CollectionUtils.synchronizedList();
        this.f6943f = new AtomicBoolean();
        this.f6944g = new AtomicBoolean();
        this.f6945h = new AtomicReference();
        this.f6946i = new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List f(v4 v4Var) {
        return z6.a(v4Var.a("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List j(v4 v4Var) {
        return z6.a(v4Var.a("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle k(v4 v4Var) {
        return JsonUtils.toBundle(v4Var.a("ah_parameters", (JSONObject) null));
    }

    private String l0() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String o(v4 v4Var) {
        return JsonUtils.getString(v4Var.a("video_button_properties", (JSONObject) null), "video_button_html", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean s(v4 v4Var) {
        return JsonUtils.getBoolean(v4Var.a("video_button_properties", (JSONObject) null), "should_cache_video_button_html_assets", Boolean.FALSE);
    }

    public boolean A0() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", Boolean.FALSE);
    }

    public boolean B0() {
        return getBooleanFromAdObject("gase", Boolean.FALSE);
    }

    public boolean C0() {
        return getBooleanFromAdObject("lock_current_orientation", Boolean.FALSE);
    }

    public abstract boolean D0();

    public AtomicBoolean E0() {
        return this.f6943f;
    }

    public boolean F0() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.a(l4.P1));
    }

    public boolean G0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE);
    }

    public abstract boolean H0();

    public boolean I0() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.valueOf(z6.h(com.applovin.impl.sdk.j.n()) || z6.f(com.applovin.impl.sdk.j.n()) || ((Boolean) this.sdk.a(l4.N5)).booleanValue()));
    }

    public abstract void J0();

    public boolean K0() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", Boolean.FALSE);
    }

    public boolean L0() {
        String str = this.sdk.g0().getExtraParameters().get("should_apply_system_insets_padding");
        return StringUtils.isValidString(str) ? Boolean.parseBoolean(str) : getBooleanFromAdObject("sasip", (Boolean) this.sdk.a(l4.f5729r2));
    }

    public boolean M0() {
        return getBooleanFromAdObject("should_apply_web_view_settings_to_web_view_button", (Boolean) this.sdk.a(l4.R5));
    }

    public abstract String N();

    public boolean N0() {
        v4 v4Var = this.synchronizedAdObject;
        return v4Var != null ? ((Boolean) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.i
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.s((v4) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_cache_video_button_html_assets", Boolean.FALSE).booleanValue();
    }

    public boolean O0() {
        return this.f6944g.get();
    }

    public EnumC0172b P() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0172b.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0172b.DO_NOT_DISMISS;
            }
        }
        return EnumC0172b.UNSPECIFIED;
    }

    public boolean P0() {
        return getBooleanFromAdObject("custom_tabs_should_track_events", Boolean.FALSE);
    }

    public int Q() {
        return getColorFromAdObject("postitial_progress_bar_color", -922746881);
    }

    public boolean Q0() {
        return getBooleanFromAdObject("serfaad", (Boolean) this.sdk.a(l4.L0));
    }

    public long R() {
        return getLongFromAdObject("postitial_progress_bar_total_ms", -1L);
    }

    public boolean R0() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", Boolean.FALSE);
    }

    public List S() {
        return getStringListFromAdObject("pbpn", this.sdk.c(l4.f5598a6));
    }

    public boolean S0() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", Boolean.FALSE);
    }

    public long T() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1L);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1L;
    }

    public boolean T0() {
        return getBooleanFromAdObject("fmsstwvoar", Boolean.FALSE);
    }

    public int U() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    public boolean U0() {
        return getBooleanFromAdObject("sftbpn", Boolean.FALSE);
    }

    public List V() {
        String stringFromAdObject = getStringFromAdObject("required_html_resources", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    public boolean V0() {
        return getBooleanFromAdObject("fvcetwv", Boolean.FALSE);
    }

    public List W() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", null);
        ArrayList arrayList = stringFromAdObject != null ? new ArrayList(CollectionUtils.explode(stringFromAdObject)) : new ArrayList(this.sdk.c(l4.D0));
        if (z6.h(com.applovin.impl.sdk.j.n())) {
            arrayList.add("https://p.applov.in/");
        }
        return arrayList;
    }

    public boolean W0() {
        return getBooleanFromAdObject("avoms", Boolean.FALSE);
    }

    public List X() {
        return getStringListFromAdObject("rea", V());
    }

    public boolean X0() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", Boolean.TRUE);
    }

    public e.a Y() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? n() : a(intFromAdObject);
    }

    public boolean Y0() {
        return getBooleanFromAdObject("require_interaction_for_click", Boolean.FALSE);
    }

    public List Z() {
        return getStringListFromAdObject("substrings_for_disabled_click_logic", Collections.emptyList());
    }

    public boolean Z0() {
        return getBooleanFromAdObject("sruifwvc", Boolean.FALSE);
    }

    public c a0() {
        c cVar = c.DEFAULT;
        String upperCase = getStringFromAdObject("ad_target", cVar.toString()).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? c.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? c.ACTIVITY_LANDSCAPE : cVar;
    }

    public boolean a1() {
        return getBooleanFromAdObject("respect_adview_fully_watched", Boolean.FALSE);
    }

    public String b0() {
        return getStringFromAdObject("tmas", (String) this.sdk.a(l4.f5619d4));
    }

    public boolean b1() {
        return getBooleanFromAdObject("sscomt", Boolean.FALSE);
    }

    public Uri c0() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "https://assets.applovin.com/sound_on.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean c1() {
        return getBooleanFromAdObject("sudbia", (Boolean) this.sdk.a(l4.Z5));
    }

    public String d0() {
        v4 v4Var = this.synchronizedAdObject;
        return v4Var != null ? (String) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.j
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.n((v4) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_base_url", UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
    }

    public boolean d1() {
        return getBooleanFromAdObject("upiosp", Boolean.FALSE);
    }

    public Bundle e() {
        return this.f6946i;
    }

    public String e0() {
        v4 v4Var = this.synchronizedAdObject;
        return v4Var != null ? (String) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.k
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.o((v4) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", "");
    }

    public p7 f0() {
        v4 v4Var = this.synchronizedAdObject;
        return v4Var != null ? (p7) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.x
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f6986a.p((v4) obj);
            }
        }) : new p7(getJsonObjectFromAdObject("video_button_properties", null), this.sdk);
    }

    public List g() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.m
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6978a.b((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public abstract Uri g0();

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public abstract s3 getAdEventTracker();

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", null);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        v4 v4Var = this.synchronizedAdObject;
        return v4Var != null ? (Bundle) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.k((v4) obj);
            }
        }) : JsonUtils.toBundle(getJsonObjectFromAdObject("ah_parameters", null));
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public List getOpenMeasurementVerificationScriptResources() {
        List list;
        final Function function = new Function() { // from class: com.applovin.impl.sdk.ad.e
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f6971a.a((JSONArray) obj);
            }
        };
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.p
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.a(function, (v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            list = (List) function.apply(getJsonArrayFromAdObject("omid_verification_script_resources", null));
        }
        return list;
    }

    public List getPrivacySandboxImpressionAttributionUrls() {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        String clCode = getClCode();
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().replace("{CLCODE}", clCode));
        }
        return arrayList;
    }

    public String h() {
        String stringFromAdObject = getStringFromAdObject("base_url", UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    public long h0() {
        return getLongFromAdObject("close_delay", 0L);
    }

    public List i() {
        return this.f6942e;
    }

    public long i0() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5L));
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public abstract boolean isOpenMeasurementEnabled();

    public abstract Uri j();

    public int j0() {
        return z6.a(getIntFromAdObject("video_completion_percent", -1));
    }

    public List k0() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.z
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6988a.q((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("video_end_urls", new JSONObject()), getClCode(), l0(), this.sdk);
        }
        return listA;
    }

    public d l() {
        if (this.f6947j == null) {
            this.f6947j = new d();
        }
        return this.f6947j;
    }

    public int m() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.a(l4.E1)).intValue());
    }

    public e m0() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", null);
        return "top".equals(stringFromAdObject) ? e.TOP : "bottom".equals(stringFromAdObject) ? e.BOTTOM : TtmlNode.LEFT.equals(stringFromAdObject) ? e.LEFT : TtmlNode.RIGHT.equals(stringFromAdObject) ? e.RIGHT : e.RESIZE_ASPECT;
    }

    public e.a n() {
        List listK = K();
        int intFromAdObject = getIntFromAdObject("close_style", (listK == null || listK.size() <= 0) ? -1 : ((Integer) listK.get(0)).intValue());
        return intFromAdObject == -1 ? a(hasVideoUrl()) : a(intFromAdObject);
    }

    public int n0() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    public boolean o0() {
        return getBooleanFromAdObject("progress_bar_enabled", Boolean.FALSE);
    }

    public long p() {
        List listL = L();
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", (listL == null || listL.size() <= 0) ? 0L : ((Integer) listL.get(0)).intValue());
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0L;
        }
        return longFromAdObject;
    }

    public abstract Uri p0();

    public int q() {
        return getColorFromAdObject("countdown_color", -922746881);
    }

    public int q0() {
        return getIntFromAdObject("whalt", z6.a(getSize()) ? 1 : ((Boolean) this.sdk.a(l4.f5732r5)).booleanValue() ? 0 : -1);
    }

    public int r() {
        return getIntFromAdObject("countdown_length", 0);
    }

    public com.applovin.impl.adview.m r0() {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (com.applovin.impl.adview.m) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.u
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.r((v4) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new com.applovin.impl.adview.m(jsonObjectFromAdObject);
        }
        return null;
    }

    public List s0() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", null));
    }

    public List t() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.f
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6972a.d((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List t0() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    public boolean u0() {
        return getBooleanFromAdObject("aocve", (Boolean) this.sdk.a(l4.I5));
    }

    public boolean v0() {
        return getBooleanFromAdObject("is_adaptive_ad", Boolean.FALSE);
    }

    public boolean w0() {
        return getBooleanFromAdObject("bvde", (Boolean) this.sdk.a(l4.f5777x5));
    }

    public boolean x0() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.a(l4.C1));
    }

    public boolean y0() {
        return getBooleanFromAdObject("custom_tabs_client_warmup_enabled", Boolean.FALSE);
    }

    public boolean z0() {
        return getBooleanFromAdObject("custom_tabs_enabled", Boolean.FALSE);
    }

    private List K() {
        return getIntegerListFromAdObject("multi_close_style", null);
    }

    private String c(MotionEvent motionEvent, boolean z10, boolean z11) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", null);
        Map mapA = a(motionEvent, z10, z11);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, mapA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List e(v4 v4Var) {
        return z6.a(v4Var.a("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List i(v4 v4Var) {
        return z6.a(v4Var.a("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map m(v4 v4Var) {
        try {
            return JsonUtils.toStringMap(v4Var.a("http_headers_for_postbacks", new JSONObject()));
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List q(v4 v4Var) {
        return z6.a(v4Var.a("video_end_urls", new JSONObject()), getClCode(), l0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.applovin.impl.adview.m r(v4 v4Var) {
        JSONObject jSONObjectA = v4Var.a("web_view_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new com.applovin.impl.adview.m(jSONObjectA);
        }
        return null;
    }

    public List A() {
        return getStringListFromAdObject("custom_tabs_warmup_urls", Collections.emptyList());
    }

    public boolean B() {
        return getBooleanFromAdObject("dismiss_on_skip", Boolean.FALSE);
    }

    public int C() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    public int D() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    public int E() {
        return z6.a(getIntFromAdObject("graphic_completion_percent", -1), 90);
    }

    public List F() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.n
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6979a.l((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("imp_urls", new JSONObject()), getClCode(), null, null, O(), R0(), this.sdk);
        }
        return listA;
    }

    public int G() {
        return getIntFromAdObject("mdafra", ((Integer) this.sdk.a(l4.M0)).intValue());
    }

    public boolean H() {
        return getBooleanFromAdObject("playback_requires_user_action", Boolean.TRUE);
    }

    public String I() {
        return getStringFromFullResponse("event_id", null);
    }

    public List J() {
        List listK = K();
        if (listK == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listK.size());
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(a(((Integer) it.next()).intValue()));
        }
        return arrayList;
    }

    public List L() {
        return getIntegerListFromAdObject("multi_close_delay_graphic", null);
    }

    public Uri M() {
        String stringFromAdObject = getStringFromAdObject("mute_image", "https://assets.applovin.com/sound_off.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public Map O() {
        HashMap map = new HashMap();
        try {
            v4 v4Var = this.synchronizedAdObject;
            map.putAll(v4Var != null ? (Map) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.r
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.m((v4) obj);
                }
            }) : JsonUtils.toStringMap(getJsonObjectFromAdObject("http_headers_for_postbacks", new JSONObject())));
        } catch (JSONException e10) {
            this.sdk.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.I().a("DirectAd", "Failed to retrieve http headers for postbacks", e10);
            }
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", Boolean.FALSE)) {
            map.put("User-Agent", z7.a());
        }
        return map;
    }

    public void b(boolean z10) {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.a("html_resources_cached", z10);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putBoolean(this.adObject, "html_resources_cached", z10);
        }
    }

    public List d() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.y
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6987a.a((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List u() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.w
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6985a.e((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List v() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.s
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6982a.f((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List w() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.g
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6973a.g((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public b1 x() {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (b1) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.o
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.h((v4) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("custom_tabs_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new b1(jsonObjectFromAdObject);
        }
        return null;
    }

    public List y() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.q
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6981a.i((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List z() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.t
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6983a.j((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            try {
                URL url = new URL(JsonUtils.getString(jSONObject, "url", null));
                String string = JsonUtils.getString(jSONObject, "vendor_key", null);
                String string2 = JsonUtils.getString(jSONObject, "parameters", null);
                if (StringUtils.isValidString(string) && StringUtils.isValidString(string2)) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                }
            } catch (Throwable th) {
                this.sdk.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.I().a("DirectAd", "Failed to parse OMID verification script resource", th);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b1 h(v4 v4Var) {
        JSONObject jSONObjectA = v4Var.a("custom_tabs_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new b1(jSONObjectA);
        }
        return null;
    }

    public b4 f() {
        return (b4) this.f6945h.getAndSet(null);
    }

    public int k() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.a(l4.D1)).intValue());
    }

    public int o() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.a(l4.F1)).intValue());
    }

    public Bundle s() {
        Map map;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            map = (Map) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.v
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6984a.c((v4) obj);
                }
            });
        } else {
            try {
                map = JsonUtils.toStringMap(getJsonObjectFromAdObject("custom_tabs_http_headers", new JSONObject()));
            } catch (JSONException e10) {
                this.sdk.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.I().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e10);
                }
                map = new HashMap();
            }
        }
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        if (getBooleanFromAdObject("custom_tabs_should_use_webview_ua", Boolean.FALSE)) {
            bundle.putString("User-Agent", z7.a());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List l(v4 v4Var) {
        return z6.a(v4Var.a("imp_urls", new JSONObject()), getClCode(), null, null, O(), R0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ p7 p(v4 v4Var) {
        return new p7(v4Var.a("video_button_properties", (JSONObject) null), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map c(v4 v4Var) {
        try {
            return JsonUtils.toStringMap(v4Var.a("custom_tabs_http_headers", new JSONObject()));
        } catch (JSONException e10) {
            this.sdk.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.I().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e10);
            }
            return new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String n(v4 v4Var) {
        return JsonUtils.getString(v4Var.a("video_button_properties", (JSONObject) null), "video_button_base_url", UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List g(v4 v4Var) {
        return z6.a(v4Var.a("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List b(v4 v4Var) {
        return z6.a(v4Var.a("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    public void c(Uri uri) {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.b("unmute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "unmute_image", uri.toString());
        }
    }

    public List d(MotionEvent motionEvent, boolean z10, boolean z11) {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        Map mapA = a(motionEvent, z10, z11);
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(StringUtils.replace(it.next(), mapA));
        }
        return arrayList;
    }

    private List b(final MotionEvent motionEvent, final boolean z10, final boolean z11) {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.a0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6938a.a(motionEvent, z10, z11, (v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("click_tracking_urls", new JSONObject()), a(motionEvent, z10, z11), c(motionEvent, z10, z11), O(), R0(), this.sdk);
        }
        return listA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List d(v4 v4Var) {
        return z6.a(v4Var.a("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    public void c() {
        this.f6944g.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List a(Function function, v4 v4Var) {
        return (List) function.apply(v4Var.a("omid_verification_script_resources", (JSONArray) null));
    }

    public void a(Uri uri) {
        this.f6942e.add(uri);
    }

    public void a(final String str) {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.a(new Consumer() { // from class: com.applovin.impl.sdk.ad.h
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    b.a(str, (v4) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", str);
        }
    }

    public List b(final MotionEvent motionEvent, final boolean z10) {
        List listA;
        List list;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            list = (List) v4Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.l
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6975a.a(motionEvent, z10, (v4) obj);
                }
            });
        } else {
            synchronized (this.adObjectLock) {
                listA = z6.a(getJsonObjectFromAdObject("video_click_tracking_urls", new JSONObject()), a(motionEvent, true, z10), null, O(), R0(), this.sdk);
            }
            list = listA;
        }
        return list.isEmpty() ? b(motionEvent, true, z10) : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, v4 v4Var) {
        JsonUtils.putString(v4Var.a("video_button_properties", (JSONObject) null), "video_button_html", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(v4 v4Var) {
        return z6.a(v4Var.a("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    public List a(MotionEvent motionEvent, boolean z10) {
        return b(motionEvent, false, z10);
    }

    public void b(Uri uri) {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.b("mute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "mute_image", uri.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z10, boolean z11, v4 v4Var) {
        return z6.a(v4Var.a("click_tracking_urls", new JSONObject()), a(motionEvent, z10, z11), c(motionEvent, z10, z11), O(), R0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z10, v4 v4Var) {
        return z6.a(v4Var.a("video_click_tracking_urls", new JSONObject()), a(motionEvent, true, z10), null, O(), R0(), this.sdk);
    }

    private Map a(MotionEvent motionEvent, boolean z10, boolean z11) {
        Point pointB = k0.b(com.applovin.impl.sdk.j.n());
        HashMap map = new HashMap(7);
        map.put("{CLCODE}", getClCode());
        map.put("{CLICK_X}", String.valueOf(motionEvent != null ? motionEvent.getRawX() : -1.0f));
        map.put("{CLICK_Y}", String.valueOf(motionEvent != null ? motionEvent.getRawY() : -1.0f));
        map.put("{SCREEN_WIDTH}", String.valueOf(pointB.x));
        map.put("{SCREEN_HEIGHT}", String.valueOf(pointB.y));
        map.put("{IS_VIDEO_CLICK}", String.valueOf(z10));
        map.put("{IS_INSTALL}", String.valueOf(z11));
        return map;
    }

    public void a(b4 b4Var) {
        this.f6945h.set(b4Var);
    }

    private e.a a(boolean z10) {
        return z10 ? e.a.WHITE_ON_TRANSPARENT : e.a.WHITE_ON_BLACK;
    }

    protected e.a a(int i10) {
        if (i10 == 1) {
            return e.a.WHITE_ON_TRANSPARENT;
        }
        if (i10 == 2) {
            return e.a.INVISIBLE;
        }
        if (i10 == 3) {
            return e.a.TRANSPARENT_SKIP;
        }
        return e.a.WHITE_ON_BLACK;
    }
}
