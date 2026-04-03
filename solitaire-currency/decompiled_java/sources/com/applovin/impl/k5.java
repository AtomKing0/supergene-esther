package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.i4;
import com.applovin.impl.m0;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.t;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.v8;
import io.sentry.protocol.App;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0.e f5545g;

    public k5(m0.e eVar, com.applovin.impl.sdk.j jVar) {
        super("TaskFetchMediationDebuggerInfo", jVar, true);
        this.f5545g = eVar;
    }

    protected Map e() {
        HashMap map = new HashMap();
        map.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.f7677a.a(l4.F4)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f7677a.b0());
        }
        Map mapC = this.f7677a.y().C();
        map.put(v8.h.V, String.valueOf(mapC.get(v8.h.V)));
        map.put(App.JsonKeys.APP_VERSION, String.valueOf(mapC.get(App.JsonKeys.APP_VERSION)));
        Map mapK = this.f7677a.y().K();
        map.put("platform", String.valueOf(mapK.get("platform")));
        map.put("os", String.valueOf(mapK.get("os")));
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map mapE = e();
        JSONObject jSONObjectA = a(a());
        if (((Boolean) this.f7677a.a(l4.V4)).booleanValue() || ((Boolean) this.f7677a.a(l4.S4)).booleanValue()) {
            JsonUtils.putAll(jSONObjectA, (Map<String, ?>) mapE);
            mapE = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f7677a).c("POST").b(b3.i(this.f7677a)).a(b3.h(this.f7677a)).b(mapE).a(jSONObjectA).a((Object) new JSONObject()).c(((Long) this.f7677a.a(g3.B6)).intValue()).a(i4.a.a(((Integer) this.f7677a.a(l4.M4)).intValue())).a(), this.f7677a, d());
        aVar.c(g3.f5251x6);
        aVar.b(g3.f5253y6);
        this.f7677a.j0().a(aVar);
    }

    class a extends z5 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z10) {
            super(aVar, jVar, z10);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, JSONObject jSONObject, int i10) {
            k5.this.f5545g.a(str, jSONObject, i10);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            k5.this.f5545g.a(str, i10, str2, jSONObject);
        }
    }

    private JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArrayIfValid(jSONObject, "installed_mediation_adapters", l3.b(this.f7677a));
        JsonUtils.putBoolean(jSONObject, "is_tablet", AppLovinSdkUtils.isTablet(context));
        t.a aVarF = this.f7677a.y().f();
        JsonUtils.putStringIfValid(jSONObject, "dnt_code", aVarF.b().b());
        JsonUtils.putStringIfValid(jSONObject, "idfa", aVarF.a());
        Map mapD0 = this.f7677a.d0();
        if (!CollectionUtils.isEmpty(mapD0)) {
            JsonUtils.putJSONObject(jSONObject, "segments", new JSONObject(mapD0));
        }
        return jSONObject;
    }
}
