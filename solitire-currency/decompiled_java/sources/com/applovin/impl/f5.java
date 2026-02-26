package com.applovin.impl;

import com.applovin.impl.i4;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final s f5187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f5188h;

    public f5(s sVar, String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
        this.f5187g = sVar;
        this.f5188h = jVar.b();
    }

    private Map g() {
        HashMap map = new HashMap(3);
        map.put("AppLovin-Zone-Id", this.f5187g.e());
        if (this.f5187g.f() != null) {
            map.put("AppLovin-Ad-Size", this.f5187g.f().getLabel());
        }
        if (this.f5187g.g() != null) {
            map.put("AppLovin-Ad-Type", this.f5187g.g().getLabel());
        }
        return map;
    }

    protected abstract w4 a(JSONObject jSONObject);

    protected void a(int i10, String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Unable to fetch " + this.f5187g + " ad: server returned " + i10);
        }
        if (i10 == -800) {
            this.f7677a.E().c(v1.f7563m);
        }
        this.f7677a.g().a(y1.f7789k, this.f5187g, new AppLovinError(i10, str));
    }

    protected void b(JSONObject jSONObject) {
        n0.c(jSONObject, this.f7677a);
        n0.b(jSONObject, this.f7677a);
        n0.a(jSONObject, this.f7677a);
        s.a(jSONObject);
        this.f7677a.j0().a(a(jSONObject));
    }

    protected abstract String e();

    protected abstract String f();

    protected Map h() {
        HashMap map = new HashMap(4);
        map.put(AppLovinUtils.ServerParameterKeys.ZONE_ID, this.f5187g.e());
        if (this.f5187g.f() != null) {
            map.put("size", this.f5187g.f().getLabel());
        }
        if (this.f5187g.g() != null) {
            map.put("require", this.f5187g.g().getLabel());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        i4.a aVarA;
        Map map;
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Fetching next ad of zone: " + this.f5187g);
        }
        if (((Boolean) this.f7677a.a(l4.D3)).booleanValue() && z6.j() && com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "User is connected to a VPN");
        }
        z6.a(this.f7677a, this.f7678b);
        JSONObject jSONObject = null;
        this.f7677a.g().a(y1.f7785i, this.f5187g, (AppLovinError) null);
        w1 w1VarE = this.f7677a.E();
        w1VarE.c(v1.f7554d);
        v1 v1Var = v1.f7557g;
        if (w1VarE.b(v1Var) == 0) {
            w1VarE.b(v1Var, System.currentTimeMillis());
        }
        try {
            JSONObject andResetCustomPostBody = this.f7677a.k().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.f7677a.a(l4.U2)).booleanValue()) {
                i4.a aVarA2 = i4.a.a(((Integer) this.f7677a.a(l4.N4)).intValue());
                JSONObject jSONObject2 = new JSONObject(this.f7677a.y().a(h(), false, true));
                map = new HashMap();
                if (!((Boolean) this.f7677a.a(l4.W4)).booleanValue() && !((Boolean) this.f7677a.a(l4.S4)).booleanValue()) {
                    map.put("rid", UUID.randomUUID().toString());
                }
                if (!((Boolean) this.f7677a.a(l4.F4)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f7677a.b0());
                }
                JsonUtils.putAll(jSONObject2, andResetCustomPostBody);
                aVarA = aVarA2;
                jSONObject = jSONObject2;
            } else {
                aVarA = i4.a.a(((Integer) this.f7677a.a(l4.O4)).intValue());
                Map mapA = z6.a(this.f7677a.y().a(h(), false, false));
                if (andResetCustomPostBody != null) {
                    jSONObject = andResetCustomPostBody;
                } else {
                    str = "GET";
                }
                map = mapA;
            }
            if (z6.f(a()) || z6.h(a())) {
                map.putAll(this.f7677a.k().getAndResetCustomQueryParams());
            }
            if (StringUtils.isValidString(this.f5188h)) {
                map.put("sts", this.f5188h);
            }
            a(w1VarE);
            a.C0175a c0175aF = com.applovin.impl.sdk.network.a.a(this.f7677a).b(f()).a(e()).b(map).c(str).a(g()).a((Object) new JSONObject()).a(((Integer) this.f7677a.a(l4.J2)).intValue()).c(((Boolean) this.f7677a.a(l4.K2)).booleanValue()).d(((Boolean) this.f7677a.a(l4.L2)).booleanValue()).c(((Integer) this.f7677a.a(l4.I2)).intValue()).a(aVarA).f(true);
            if (jSONObject != null) {
                c0175aF.a(jSONObject);
                c0175aF.b(((Boolean) this.f7677a.a(l4.f5644g5)).booleanValue());
            }
            a aVar = new a(c0175aF.a(), this.f7677a);
            aVar.c(l4.f5711p0);
            aVar.b(l4.f5719q0);
            this.f7677a.j0().a(aVar);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Unable to fetch ad for zone id: " + this.f5187g, th);
            }
            a(0, th.getMessage());
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
                HashMap map = new HashMap(5);
                CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
                CollectionUtils.putStringIfValid("code", String.valueOf(i10), map);
                CollectionUtils.putStringIfValid("ad_zone_id", f5.this.f5187g.e(), map);
                CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.f7904l.a()), map);
                CollectionUtils.putStringIfValid("response_size", String.valueOf(this.f7904l.b()), map);
                this.f7677a.g().d(y1.f7787j, map);
                f5.this.b(jSONObject);
                return;
            }
            f5.this.a(i10, MaxAdapterError.NO_FILL.getErrorMessage());
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            f5.this.a(i10, str2);
            this.f7677a.A().a("fetchAd", str, i10, str2);
        }
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
