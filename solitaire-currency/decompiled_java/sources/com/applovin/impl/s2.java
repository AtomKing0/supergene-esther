package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s2 extends y2 {
    public s2(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, null, jVar);
    }

    @Override // com.applovin.impl.q2
    public q2 a(com.applovin.impl.mediation.g gVar) {
        return new s2(this, gVar);
    }

    public long j0() {
        long jA = a("ad_refresh_ms", -1L);
        return jA >= 0 ? jA : b("ad_refresh_ms", ((Long) this.f4682a.a(g3.G6)).longValue());
    }

    public long k0() {
        return z6.e(a("bg_color", (String) null));
    }

    public int l0() {
        int iA = a("ad_view_height", -2);
        if (iA != -2) {
            return iA;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public long m0() {
        return a("viewability_imp_delay_ms", ((Long) this.f4682a.a(l4.f5656i1)).longValue());
    }

    public int n0() {
        int iA = a("ad_view_width", -2);
        if (iA != -2) {
            return iA;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public boolean o0() {
        return j0() >= 0;
    }

    public boolean p0() {
        return a("proe", (Boolean) this.f4682a.a(g3.f5233i7)).booleanValue();
    }

    private s2(s2 s2Var, com.applovin.impl.mediation.g gVar) {
        super(s2Var.i(), s2Var.a(), s2Var.g(), gVar, s2Var.f4682a);
    }
}
