package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q2 extends a3 implements MaxAd {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f6643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f6644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected com.applovin.impl.mediation.g f6645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f6646n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MaxAdWaterfallInfo f6647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f6648p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f6649q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f6650r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Bundle f6651s;

    protected q2(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.g gVar, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, jVar);
        this.f6643k = new AtomicBoolean();
        this.f6644l = new AtomicBoolean();
        this.f6645m = gVar;
        this.f6646n = gVar != null ? gVar.b() : null;
    }

    private long I() {
        return a("load_started_time_ms", 0L);
    }

    public static q2 a(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(jSONObject2, "ad_format", null);
        MaxAdFormat fromString = MaxAdFormat.formatFromString(string);
        Objects.requireNonNull(fromString, "Invalid ad format for string: " + string);
        if (fromString.isAdViewAd()) {
            return new s2(map, jSONObject, jSONObject2, jVar);
        }
        if (fromString == MaxAdFormat.NATIVE) {
            return new u2(map, jSONObject, jSONObject2, jVar);
        }
        if (fromString.isFullscreenAd()) {
            return new t2(map, jSONObject, jSONObject2, jVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle c(v4 v4Var) {
        JSONObject jSONObjectA;
        if (v4Var.a("credentials")) {
            jSONObjectA = v4Var.a("credentials", new JSONObject());
        } else {
            jSONObjectA = v4Var.a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, "placement_id", O());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject d(v4 v4Var) {
        return JsonUtils.deepCopy(v4Var.a("publisher_extra_info", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double e(v4 v4Var) {
        return Double.valueOf(JsonUtils.getDouble(v4Var.a("revenue_parameters", (JSONObject) null), ImpressionData.IMPRESSION_DATA_KEY_REVENUE, -1.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject f(v4 v4Var) {
        return JsonUtils.deepCopy(v4Var.a("revenue_parameters", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(v4 v4Var) {
        return JsonUtils.getString(v4Var.a("revenue_parameters", (JSONObject) null), ImpressionData.IMPRESSION_DATA_KEY_PRECISION, "");
    }

    public com.applovin.impl.mediation.g A() {
        return this.f6645m;
    }

    public Bundle B() {
        return this.f6651s;
    }

    public String C() {
        return a("bcode", "");
    }

    public long D() {
        return a("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1L, l()));
    }

    public String E() {
        return a("bid_response", (String) null);
    }

    public Bundle F() {
        JSONObject jSONObjectA;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return (Bundle) v4Var.a(new Function() { // from class: com.applovin.impl.sc
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f6842a.c((v4) obj);
                }
            });
        }
        if (c("credentials")) {
            jSONObjectA = a("credentials", new JSONObject());
        } else {
            jSONObjectA = a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, "placement_id", O());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    public long G() {
        if (I() > 0) {
            return H() - I();
        }
        return -1L;
    }

    public long H() {
        return a("load_completed_time_ms", 0L);
    }

    public String J() {
        return this.f6649q;
    }

    public JSONObject K() {
        v4 v4Var = this.f4689h;
        return v4Var != null ? (JSONObject) v4Var.a(new Function() { // from class: com.applovin.impl.rc
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return q2.d((v4) obj);
            }
        }) : a("publisher_extra_info", new JSONObject());
    }

    public String L() {
        return JsonUtils.getString(M(), "revenue_event", "");
    }

    public JSONObject M() {
        v4 v4Var = this.f4689h;
        return v4Var != null ? (JSONObject) v4Var.a(new Function() { // from class: com.applovin.impl.vc
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return q2.f((v4) obj);
            }
        }) : a("revenue_parameters", new JSONObject());
    }

    public String N() {
        return b("event_id", "");
    }

    public String O() {
        return a("third_party_ad_placement_id", (String) null);
    }

    public List P() {
        return b("mwf_info_urls");
    }

    public String Q() {
        return b("waterfall_name", "");
    }

    public String R() {
        return b("waterfall_test_name", "");
    }

    public boolean S() {
        return StringUtils.isValidString(E());
    }

    public boolean T() {
        com.applovin.impl.mediation.g gVar = this.f6645m;
        return gVar != null && gVar.k() && this.f6645m.j();
    }

    public boolean U() {
        return a("only_load_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean V() {
        return a("prefer_load_when_initialized", Boolean.TRUE).booleanValue();
    }

    public void W() {
        c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    public void X() {
        c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public Boolean Y() {
        return a("destroy_on_ui_thread", (Boolean) null);
    }

    public Boolean Z() {
        return a("load_on_ui_thread", (Boolean) null);
    }

    public abstract q2 a(com.applovin.impl.mediation.g gVar);

    public Boolean a0() {
        return a("show_on_ui_thread", (Boolean) null);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectK = K();
        JsonUtils.putAll(jSONObjectK, jSONObject);
        a("publisher_extra_info", (Object) jSONObjectK);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdReviewCreativeId() {
        return this.f6650r;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getCreativeId() {
        return a("creative_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspId() {
        return a("dsp_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspName() {
        return a("dsp_name", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(a("ad_format", b("ad_format", (String) null)));
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxNativeAd getNativeAd() {
        com.applovin.impl.mediation.g gVar = this.f6645m;
        if (gVar != null) {
            return gVar.e();
        }
        return null;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkName() {
        return a("network_name", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(O());
    }

    @Override // com.applovin.mediation.MaxAd
    public long getRequestLatencyMillis() {
        return this.f6648p;
    }

    @Override // com.applovin.mediation.MaxAd
    public double getRevenue() {
        if (!((Boolean) this.f4682a.a(g3.f5242r7)).booleanValue() || !getFormat().isFullscreenAd() || u().get()) {
            v4 v4Var = this.f4689h;
            return v4Var != null ? ((Double) v4Var.a(new Function() { // from class: com.applovin.impl.tc
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return q2.e((v4) obj);
                }
            })).doubleValue() : JsonUtils.getDouble(a("revenue_parameters", (JSONObject) null), ImpressionData.IMPRESSION_DATA_KEY_REVENUE, -1.0d);
        }
        this.f4682a.I();
        if (!com.applovin.impl.sdk.n.a()) {
            return 0.0d;
        }
        this.f4682a.I().b("MediatedAd", "Attempting to retrieve revenue when not available yet");
        return 0.0d;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getRevenuePrecision() {
        v4 v4Var = this.f4689h;
        return v4Var != null ? (String) v4Var.a(new Function() { // from class: com.applovin.impl.uc
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return q2.g((v4) obj);
            }
        }) : JsonUtils.getString(a("revenue_parameters", (JSONObject) null), ImpressionData.IMPRESSION_DATA_KEY_PRECISION, "");
    }

    @Override // com.applovin.mediation.MaxAd
    public AppLovinSdkUtils.Size getSize() {
        int iA = a("ad_width", -3);
        int iA2 = a("ad_height", -3);
        return (iA == -3 || iA2 == -3) ? getFormat().getSize() : new AppLovinSdkUtils.Size(iA, iA2);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdWaterfallInfo getWaterfall() {
        return this.f6647o;
    }

    public void h(String str) {
        this.f6650r = str;
    }

    public void i(String str) {
        this.f6649q = str;
    }

    @Override // com.applovin.impl.a3
    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + O() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }

    public String z() {
        return this.f6646n;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str, String str2) {
        JSONObject jSONObjectX = x();
        if (jSONObjectX.has(str)) {
            return JsonUtils.getString(jSONObjectX, str, str2);
        }
        Bundle bundleL = l();
        if (bundleL.containsKey(str)) {
            return bundleL.getString(str);
        }
        JSONObject jSONObjectK = K();
        return jSONObjectK.has(str) ? JsonUtils.getString(jSONObjectK, str, str2) : a(str, str2);
    }

    public void t() {
        this.f6645m = null;
        this.f6647o = null;
    }

    public AtomicBoolean u() {
        return this.f6643k;
    }

    public String v() {
        return a("adomain", (String) null);
    }

    public AtomicBoolean w() {
        return this.f6644l;
    }

    public JSONObject x() {
        v4 v4Var = this.f4689h;
        return v4Var != null ? (JSONObject) v4Var.a(new Function() { // from class: com.applovin.impl.wc
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return q2.b((v4) obj);
            }
        }) : a("ad_values", new JSONObject());
    }

    public View y() {
        com.applovin.impl.mediation.g gVar;
        if (!T() || (gVar = this.f6645m) == null) {
            return null;
        }
        return gVar.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject b(v4 v4Var) {
        return JsonUtils.deepCopy(v4Var.a("ad_values", new JSONObject()));
    }

    public void a(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.f6647o = maxAdWaterfallInfo;
    }

    public void a(long j10) {
        this.f6648p = j10;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectX = x();
        JsonUtils.putAll(jSONObjectX, jSONObject);
        a("ad_values", (Object) jSONObjectX);
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("ad_values")) {
            a(BundleUtils.toJSONObject(bundle.getBundle("ad_values")));
        }
        if (bundle.containsKey("creative_id") && !c("creative_id")) {
            c("creative_id", BundleUtils.getString("creative_id", bundle));
        }
        if (bundle.containsKey("ad_width") && !c("ad_width") && bundle.containsKey("ad_height") && !c("ad_height")) {
            int i10 = BundleUtils.getInt("ad_width", bundle);
            int i11 = BundleUtils.getInt("ad_height", bundle);
            c("ad_width", i10);
            c("ad_height", i11);
        }
        if (bundle.containsKey("publisher_extra_info")) {
            b(BundleUtils.toJSONObject(bundle.getBundle("publisher_extra_info")));
        }
        if (bundle.containsKey("array_parameters")) {
            this.f6651s = bundle.getBundle("array_parameters");
        }
    }
}
