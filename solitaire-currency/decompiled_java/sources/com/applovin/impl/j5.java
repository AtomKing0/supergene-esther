package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.i3;
import com.applovin.impl.i4;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MaxAdFormat f5476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f5477i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f5478j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f5479k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final JSONArray f5480l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Context f5481m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final a.InterfaceC0165a f5482n;

    public j5(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, JSONArray jSONArray, Context context, com.applovin.impl.sdk.j jVar, a.InterfaceC0165a interfaceC0165a) {
        super("TaskFetchMediatedAd", jVar, str);
        this.f5475g = str;
        this.f5476h = maxAdFormat;
        this.f5477i = map;
        this.f5478j = map2;
        this.f5479k = map3;
        this.f5480l = jSONArray;
        this.f5481m = context;
        this.f5482n = interfaceC0165a;
    }

    private void c(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.f7677a.Q().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData == null || !z6.f(com.applovin.impl.sdk.j.n())) {
            return;
        }
        JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
    }

    private void d(JSONObject jSONObject) {
        if (((Boolean) this.f7677a.a(l4.f5651h4)).booleanValue()) {
            j3 j3VarR = this.f7677a.R();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            h3 h3Var = h3.f5330c;
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) j3VarR.a(h3Var, i3.a.AD_UNIT_ID));
            JsonUtils.putJSONObject(jSONObject2, "arpau", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            JsonUtils.putAll(jSONObject4, (Map<String, ?>) j3VarR.a(h3Var, i3.a.AD_FORMAT));
            JsonUtils.putJSONObject(jSONObject2, "arpaf", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            JsonUtils.putAll(jSONObject5, (Map<String, ?>) j3VarR.a(h3.f5331d, i3.a.AD));
            JsonUtils.putJSONObject(jSONObject2, "ttdasipa_ms", jSONObject5);
            JsonUtils.putJSONObject(jSONObject, "mediation_stats", jSONObject2);
        }
    }

    private String e() {
        return b3.a(this.f7677a);
    }

    private String f() {
        return b3.b(this.f7677a);
    }

    private JSONObject g() throws JSONException {
        Map mapA = this.f7677a.y().a((Map) null, false, true);
        mapA.putAll(this.f5479k);
        JSONObject jSONObject = new JSONObject(mapA);
        e(jSONObject);
        h(jSONObject);
        f(jSONObject);
        c(jSONObject);
        g(jSONObject);
        d(jSONObject);
        return jSONObject;
    }

    private Map h() {
        HashMap map = new HashMap(2);
        map.put("AppLovin-Ad-Unit-Id", this.f5475g);
        map.put("AppLovin-Ad-Format", this.f5476h.getLabel());
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Attempt", this.f5478j.get("retry_attempt"), map);
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Delay-Sec", this.f5478j.get("retry_delay_sec"), map);
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Fetching next ad for " + this.f5476h.getLabel() + " ad unit " + this.f5475g);
        }
        e2.a();
        if (((Boolean) this.f7677a.a(l4.D3)).booleanValue() && z6.j() && com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "User is connected to a VPN");
        }
        this.f7677a.J().a(y1.L, this.f5476h, this.f5475g, (MaxError) null);
        if (((Boolean) this.f7677a.a(l4.f5651h4)).booleanValue()) {
            j3 j3VarR = this.f7677a.R();
            h3 h3Var = h3.f5330c;
            j3VarR.a(h3Var, i3.a(this.f5475g));
            j3VarR.a(h3Var, i3.a(this.f5476h));
        }
        z6.a(this.f7677a, this.f7678b);
        w1 w1VarE = this.f7677a.E();
        w1VarE.c(v1.f7569s);
        v1 v1Var = v1.f7557g;
        if (w1VarE.b(v1Var) == 0) {
            w1VarE.b(v1Var, System.currentTimeMillis());
        }
        try {
            JSONObject jSONObjectG = g();
            HashMap map = new HashMap();
            if (!((Boolean) this.f7677a.a(l4.U4)).booleanValue() && !((Boolean) this.f7677a.a(l4.S4)).booleanValue()) {
                map.put("rid", UUID.randomUUID().toString());
            }
            if (!((Boolean) this.f7677a.a(l4.F4)).booleanValue()) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f7677a.b0());
            }
            if (this.f7677a.l0().c()) {
                map.put("test_mode", "1");
            }
            List listB = this.f7677a.l0().b();
            String str = this.f7677a.g0().getExtraParameters().get("fan");
            if (listB != null && !listB.isEmpty()) {
                String strA = g9.a(",", listB);
                map.put("filter_ad_network", strA);
                if (!this.f7677a.l0().c()) {
                    map.put("fhkZsVqYC7", "1");
                }
                if (this.f7677a.l0().d()) {
                    map.put("force_ad_network", strA);
                }
            } else if (StringUtils.isValidString(str)) {
                map.put("filter_ad_network", str);
            }
            a(w1VarE);
            a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f7677a).c("POST").a(h()).b(f()).a(e()).b(map).a(jSONObjectG).b(((Boolean) this.f7677a.a(g3.A7)).booleanValue()).a((Object) new JSONObject()).c(((Long) this.f7677a.a(g3.A6)).intValue()).a(((Integer) this.f7677a.a(l4.J2)).intValue()).b(((Long) this.f7677a.a(g3.f5255z6)).intValue()).a(i4.a.a(((Integer) this.f7677a.a(l4.L4)).intValue())).f(true).a(), this.f7677a);
            aVar.c(g3.f5251x6);
            aVar.b(g3.f5253y6);
            this.f7677a.j0().a(aVar);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Unable to fetch ad for Ad Unit ID: " + this.f5475g, th);
            }
            a("", 0, th.getMessage());
        }
    }

    class a extends z5 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, JSONObject jSONObject, int i10) {
            if (i10 == 200) {
                JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f7904l.a());
                JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f7904l.b());
                HashMap map = new HashMap(6);
                CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
                CollectionUtils.putStringIfValid("code", String.valueOf(i10), map);
                CollectionUtils.putStringIfValid("ad_unit_id", j5.this.f5475g, map);
                CollectionUtils.putStringIfValid("ad_format", j5.this.f5476h.getLabel(), map);
                CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.f7904l.a()), map);
                CollectionUtils.putStringIfValid("response_size", String.valueOf(this.f7904l.b()), map);
                this.f7677a.J().d(y1.M, map);
                j5.this.b(jSONObject);
                return;
            }
            j5.this.a(str, i10, (String) null);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            j5.this.a(str, i10, str2);
            this.f7677a.A().a("fetchMediatedAd", str, i10, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        try {
            n0.c(jSONObject, this.f7677a);
            n0.b(jSONObject, this.f7677a);
            n0.a(jSONObject, this.f7677a);
            b3.f(jSONObject, this.f7677a);
            b3.d(jSONObject, this.f7677a);
            b3.e(jSONObject, this.f7677a);
            b3.g(jSONObject, this.f7677a);
            x.b(this.f7677a);
            MaxAdFormat fromString = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "ad_format", null));
            if (this.f5476h == fromString) {
                a(jSONObject);
                return;
            }
            if (fromString == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "Mediated ad response is missing the ad format field for ad unit " + this.f5475g);
                }
                if (jSONObject.has("ads")) {
                    HashMap map = new HashMap(3);
                    CollectionUtils.putStringIfValid("details", "Missing ad format field", map);
                    CollectionUtils.putStringIfValid("ad_unit_id", this.f5475g, map);
                    CollectionUtils.putStringIfValid("mcode", JsonUtils.getString(jSONObject, "mcode", ""), map);
                    this.f7677a.A().a(y1.f7814w0, this.f7678b, map);
                }
                this.f5482n.onAdLoadFailed(this.f5475g, MaxAdapterError.NO_FILL);
                return;
            }
            String label = fromString.getLabel();
            String label2 = this.f5476h.getLabel();
            String str = "Incorrect format (" + label + ") loaded for (" + label2 + ") ad. Please verify if the ad unit ID (" + this.f5475g + ") is assigned to the correct ad format.";
            if (z6.a(this.f5476h, fromString)) {
                com.applovin.impl.sdk.n.j(this.f7678b, str);
                a(jSONObject);
                return;
            }
            e1.a(str, new Object[0]);
            com.applovin.impl.sdk.n.h(this.f7678b, str);
            this.f5482n.onAdLoadFailed(this.f5475g, new MaxAdapterError(MaxAdapterError.INVALID_CONFIGURATION, 0, str));
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("ad_unit_id", this.f5475g);
            CollectionUtils.putStringIfValid("name", label2, mapHashMap);
            CollectionUtils.putStringIfValid("details", label, mapHashMap);
            this.f7677a.A().a(y1.f7798o0, "incompatible_ad_format", mapHashMap);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Unable to process mediated ad response for ad unit " + this.f5475g, th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f5475g);
        jSONObject2.put("ad_format", this.f5476h.getLabel());
        Map map = CollectionUtils.map(this.f5478j);
        com.applovin.impl.sdk.o oVarT = this.f7677a.T();
        CollectionUtils.putStringIfValid("previous_request_id", oVarT.b(this.f5475g), map);
        CollectionUtils.putStringIfValid("previous_loaded_request_id", oVarT.a(this.f5475g), map);
        o.a aVarC = oVarT.c(this.f5475g);
        if (aVarC != null) {
            if (Boolean.parseBoolean(this.f7677a.g0().getExtraParameters().get("esc"))) {
                map.put("previous_winning_network", "APPLOVIN_NETWORK");
                map.put("previous_winning_network_name", "AppLovin");
            } else {
                map.put("previous_winning_network", aVarC.a());
                map.put("previous_winning_network_name", aVarC.c());
            }
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void f(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.f7677a.M().a()));
            jSONObject2.put("installed", l3.b(this.f7677a));
            jSONObject2.put("initialized", this.f7677a.L().b());
            jSONObject2.put("initialized_classnames", new JSONArray((Collection) this.f7677a.L().a()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.f7677a.M().c()));
            jSONObject2.put("failed_classnames", new JSONArray(this.f7677a.M().b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e10) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Failed to populate adapter classNames", e10);
            }
            throw new RuntimeException("Failed to populate classNames: " + e10);
        }
    }

    private void a(JSONObject jSONObject) {
        t5 t5Var = new t5(this.f5475g, this.f5476h, this.f5477i, jSONObject, this.f5481m, this.f7677a, this.f5482n);
        long j10 = JsonUtils.getLong(jSONObject, "process_waterfall_delay_ms", -1L);
        if (j10 > 0) {
            this.f7677a.j0().a(t5Var, r5.b.MEDIATION, j10, true);
        } else {
            this.f7677a.j0().a(t5Var);
        }
    }

    private void h(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f5480l;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i10, String str2) {
        MaxErrorImpl maxErrorImpl;
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Unable to fetch ad for ad unit " + this.f5475g + ": server returned " + i10);
        }
        if (i10 == -800) {
            this.f7677a.E().c(v1.f7570t);
        }
        if (i10 == -1009) {
            maxErrorImpl = new MaxErrorImpl(-1009, str2);
        } else if (i10 == -1001) {
            maxErrorImpl = new MaxErrorImpl(-1001, str2);
        } else if (StringUtils.isValidString(str2)) {
            maxErrorImpl = new MaxErrorImpl(-1000, str2);
        } else {
            maxErrorImpl = new MaxErrorImpl(-1);
        }
        HashMap map = new HashMap(5);
        CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
        CollectionUtils.putStringIfValid("code", String.valueOf(i10), map);
        CollectionUtils.putStringIfValid("error_message", str2, map);
        CollectionUtils.putStringIfValid("ad_unit_id", this.f5475g, map);
        CollectionUtils.putStringIfValid("ad_format", this.f5476h.getLabel(), map);
        this.f7677a.J().d(y1.N, map);
        l2.a(this.f5482n, this.f5475g, maxErrorImpl);
    }

    private void g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.f7677a.g0().getExtraParameters()));
    }

    private void a(w1 w1Var) {
        v1 v1Var = v1.f7557g;
        long jB = w1Var.b(v1Var);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jB > TimeUnit.MINUTES.toMillis(((Integer) this.f7677a.a(l4.f5634f3)).intValue())) {
            w1Var.b(v1Var, jCurrentTimeMillis);
            w1Var.a(v1.f7558h);
            w1Var.a(v1.f7559i);
        }
    }
}
