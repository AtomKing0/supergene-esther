package com.applovin.impl;

import android.app.ActivityManager;
import android.net.Uri;
import android.os.SystemClock;
import com.applovin.impl.i4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import io.sentry.protocol.App;
import io.sentry.protocol.Device;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h5 extends w4 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicBoolean f5333j = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f5334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f5335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f5336i;

    public interface b {
        void a(JSONObject jSONObject);
    }

    private class c extends w4 {
        public c(com.applovin.impl.sdk.j jVar) {
            super("TaskTimeoutFetchBasicSettings", jVar, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h5.this.f5336i != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "Timing out fetch basic settings...");
                }
                h5.this.a(new JSONObject());
            }
        }
    }

    public h5(int i10, com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskFetchBasicSettings", jVar, true);
        this.f5335h = new Object();
        this.f5334g = i10;
        this.f5336i = bVar;
    }

    private HashMap b(String str) {
        return a(str, 0L, 0, null, null);
    }

    private String f() {
        return n0.a((String) this.f7677a.a(l4.f5703o0), "5.0/i", b());
    }

    private String g() {
        return n0.a((String) this.f7677a.a(l4.f5695n0), "5.0/i", b());
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.applovin.impl.sdk.j jVar = this.f7677a;
            l4 l4Var = l4.S4;
            if (((Boolean) jVar.a(l4Var)).booleanValue() || ((Boolean) this.f7677a.a(l4Var)).booleanValue()) {
                jSONObject.put("rid", UUID.randomUUID().toString());
            }
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            JsonUtils.putStringIfValid(jSONObject, "ad_review_sdk_version", h.b());
            jSONObject.put("init_count", this.f5334g);
            jSONObject.put("server_installed_at", this.f7677a.a(l4.f5702o));
            if (this.f7677a.v0()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f7677a.s0()) {
                jSONObject.put("first_install_v2", true);
            }
            JsonUtils.putStringIfValid(jSONObject, "process_name", z6.b(a()));
            JsonUtils.putBooleanIfValid(jSONObject, "is_main_process", z6.g(a()));
            JsonUtils.putStringIfValid(jSONObject, "plugin_version", (String) this.f7677a.a(l4.f5761v3));
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider", this.f7677a.O());
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider_v2", this.f7677a.z());
            jSONObject.put("installed_mediation_adapters", l3.b(this.f7677a));
            Map mapC = this.f7677a.y().C();
            jSONObject.put(v8.h.V, mapC.get(v8.h.V));
            jSONObject.put(App.JsonKeys.APP_VERSION, mapC.get(App.JsonKeys.APP_VERSION));
            jSONObject.put("debug", mapC.get("debug"));
            jSONObject.put("tg", mapC.get("tg"));
            jSONObject.put("target_sdk", mapC.get("target_sdk"));
            List<String> adUnitIds = this.f7677a.G() != null ? this.f7677a.G().getAdUnitIds() : null;
            if (adUnitIds != null && adUnitIds.size() > 0) {
                List<String> listRemoveTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(adUnitIds);
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(listRemoveTrimmedEmptyStrings, listRemoveTrimmedEmptyStrings.size()));
            }
            jSONObject.put("IABTCF_TCString", mapC.get("IABTCF_TCString"));
            jSONObject.put(OTIABTCFKeys.IABTCF_GDPRAPPLIES, mapC.get(OTIABTCFKeys.IABTCF_GDPRAPPLIES));
            Object obj = mapC.get(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT);
            if (obj instanceof String) {
                JsonUtils.putStringIfValid(jSONObject, OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, (String) obj);
            }
            jSONObject.put("consent_flow_info", this.f7677a.v().b());
            Map mapK = this.f7677a.y().K();
            jSONObject.put("platform", mapK.get("platform"));
            jSONObject.put("os", mapK.get("os"));
            jSONObject.put(Device.JsonKeys.LOCALE, mapK.get(Device.JsonKeys.LOCALE));
            jSONObject.put(Device.JsonKeys.BRAND, mapK.get(Device.JsonKeys.BRAND));
            jSONObject.put("brand_name", mapK.get("brand_name"));
            jSONObject.put("hardware", mapK.get("hardware"));
            jSONObject.put("model", mapK.get("model"));
            jSONObject.put("revision", mapK.get("revision"));
            jSONObject.put("is_tablet", mapK.get("is_tablet"));
            jSONObject.put("screen_size_in", mapK.get("screen_size_in"));
            jSONObject.put("supported_abis", mapK.get("supported_abis"));
            if (((Boolean) this.f7677a.a(l4.G3)).booleanValue()) {
                jSONObject.put("mtl", this.f7677a.f0().getLastTrimMemoryLevel());
            }
            try {
                ActivityManager activityManager = (ActivityManager) com.applovin.impl.sdk.j.n().getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager != null) {
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("fm", memoryInfo.availMem);
                    jSONObject.put("tm", memoryInfo.totalMem);
                    jSONObject.put("lmt", memoryInfo.threshold);
                    jSONObject.put("lm", memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            t.a aVarF = this.f7677a.y().f();
            jSONObject.put("dnt", aVarF.c());
            jSONObject.put("dnt_code", aVarF.b().b());
            Boolean boolB = l0.c().b(a());
            if (((Boolean) this.f7677a.a(l4.f5738s3)).booleanValue() && StringUtils.isValidString(aVarF.a()) && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfa", aVarF.a());
            }
            k.b bVarD = this.f7677a.y().D();
            if (((Boolean) this.f7677a.a(l4.f5682l3)).booleanValue() && bVarD != null && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfv", bVarD.f7155a);
                jSONObject.put("idfv_scope", bVarD.f7156b);
            }
            if (((Boolean) this.f7677a.a(l4.f5706o3)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f7677a.s());
            }
            if (((Boolean) this.f7677a.a(l4.f5722q3)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f7677a.a0());
            }
            if (this.f7677a.l0().c()) {
                jSONObject.put("test_mode", true);
            }
            List listB = this.f7677a.l0().b();
            if (listB != null && !listB.isEmpty()) {
                jSONObject.put("test_mode_networks", listB);
            }
            jSONObject.put("sdk_extra_parameters", new JSONObject(this.f7677a.g0().getExtraParameters()));
            Map mapD0 = this.f7677a.d0();
            if (!CollectionUtils.isEmpty(mapD0)) {
                jSONObject.put("segments", new JSONObject(mapD0));
            }
            if (this.f5334g > 1) {
                ArrayService arrayServiceO = this.f7677a.o();
                if (arrayServiceO.getIsDirectDownloadEnabled() != null) {
                    jSONObject.put("ah_dd_enabled", arrayServiceO.getIsDirectDownloadEnabled());
                }
                jSONObject.put("ah_sdk_version_code", arrayServiceO.getAppHubVersionCode());
                jSONObject.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceO.getRandomUserToken()));
                jSONObject.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceO.getAppHubPackageName()));
            }
        } catch (JSONException e10) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Failed to create JSON body", e10);
            }
            this.f7677a.A().a(this.f7678b, "createJSONBody", e10);
        }
        return jSONObject;
    }

    protected Map h() {
        HashMap map = new HashMap();
        if (!((Boolean) this.f7677a.a(l4.T4)).booleanValue() && !((Boolean) this.f7677a.a(l4.S4)).booleanValue()) {
            map.put("rid", UUID.randomUUID().toString());
        }
        if (!((Boolean) this.f7677a.a(l4.F4)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f7677a.b0());
        }
        Boolean boolB = l0.b().b(a());
        if (boolB != null) {
            map.put("huc", boolB.toString());
        }
        Boolean boolB2 = l0.c().b(a());
        if (boolB2 != null) {
            map.put("aru", boolB2.toString());
        }
        Boolean boolB3 = l0.a().b(a());
        if (boolB3 != null) {
            map.put("dns", boolB3.toString());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!k0.i() && f5333j.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(com.applovin.impl.sdk.j.n());
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.a(this.f7678b, "Cannot update security provider", th);
                }
            }
        }
        this.f7677a.o0().d(y1.f7779f, b(g()));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map mapH = h();
        a.C0175a c0175aB = com.applovin.impl.sdk.network.a.a(this.f7677a).b(g()).a(f()).b(mapH).a(e()).b(((Boolean) this.f7677a.a(l4.f5628e5)).booleanValue()).c("POST").a((Object) new JSONObject()).a(((Integer) this.f7677a.a(l4.P2)).intValue()).b(((Integer) this.f7677a.a(l4.S2)).intValue());
        com.applovin.impl.sdk.j jVar = this.f7677a;
        l4 l4Var = l4.O2;
        com.applovin.impl.sdk.network.a aVarA = c0175aB.c(((Integer) jVar.a(l4Var)).intValue()).e(((Boolean) this.f7677a.a(l4.f5602b3)).booleanValue()).a(i4.a.a(((Integer) this.f7677a.a(l4.K4)).intValue())).f(true).a();
        this.f7677a.j0().a(new c(this.f7677a), r5.b.TIMEOUT, ((long) ((Integer) this.f7677a.a(l4Var)).intValue()) + 250);
        a aVar = new a(aVarA, this.f7677a, d(), jElapsedRealtime);
        aVar.c(l4.f5695n0);
        aVar.b(l4.f5703o0);
        this.f7677a.j0().a(aVar);
    }

    class a extends z5 {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f5337m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z10, long j10) {
            super(aVar, jVar, z10);
            this.f5337m = j10;
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, JSONObject jSONObject, int i10) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f5337m;
            h5.this.a(jSONObject);
            this.f7677a.o0().d(y1.f7781g, h5.this.a(str, jElapsedRealtime, i10, jSONObject, null));
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Unable to fetch basic SDK settings: server returned " + i10);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f5337m;
            h5.this.a(jSONObject != null ? jSONObject : new JSONObject());
            this.f7677a.o0().d(y1.f7783h, h5.this.a(str, jElapsedRealtime, i10, jSONObject, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap a(String str, long j10, int i10, JSONObject jSONObject, String str2) {
        Uri uriBuild = Uri.parse(str).buildUpon().clearQuery().build();
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, v8.i.D, uriBuild.getHost());
        if (jSONObject != null) {
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "auto_init_adapters", null);
            if (jSONArray != null) {
                JsonUtils.putInt(jSONObject2, "signal_provider_count", jSONArray.length());
            }
            if (jSONArray2 != null) {
                JsonUtils.putInt(jSONObject2, "auto_init_adapter_count", jSONArray2.length());
            }
        }
        HashMap map = new HashMap();
        map.put("attempt_number", Integer.toString(this.f5334g));
        map.put("error_message", str2);
        map.put("url", uriBuild.toString());
        map.put("details", jSONObject2.toString());
        map.put("duration_ms", Long.toString(j10));
        map.put("code", Integer.toString(i10));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        b bVar;
        synchronized (this.f5335h) {
            bVar = this.f5336i;
            this.f5336i = null;
        }
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }
}
