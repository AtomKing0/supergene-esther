package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y2 extends q2 {
    protected y2(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.g gVar, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, gVar, jVar);
    }

    public float b0() {
        return a("viewability_min_alpha", ((Float) this.f4682a.a(l4.f5728r1)).floatValue() / 100.0f);
    }

    public int c0() {
        return a("viewability_min_pixels", -1);
    }

    public int d0() {
        MaxAdFormat format = getFormat();
        l4 l4Var = format == MaxAdFormat.BANNER ? l4.f5672k1 : format == MaxAdFormat.MREC ? l4.f5688m1 : format == MaxAdFormat.LEADER ? l4.f5704o1 : format == MaxAdFormat.NATIVE ? l4.f5720q1 : null;
        if (l4Var != null) {
            return a("viewability_min_height", ((Integer) this.f4682a.a(l4Var)).intValue());
        }
        return 0;
    }

    public float e0() {
        return a("viewability_min_percentage_dp", -1.0f);
    }

    public float f0() {
        return a("viewability_min_percentage_pixels", -1.0f);
    }

    public long g0() {
        return a("viewability_timer_min_visible_ms", ((Long) this.f4682a.a(l4.f5736s1)).longValue());
    }

    public int h0() {
        MaxAdFormat format = getFormat();
        l4 l4Var = format == MaxAdFormat.BANNER ? l4.f5664j1 : format == MaxAdFormat.MREC ? l4.f5680l1 : format == MaxAdFormat.LEADER ? l4.f5696n1 : format == MaxAdFormat.NATIVE ? l4.f5712p1 : null;
        if (l4Var != null) {
            return a("viewability_min_width", ((Integer) this.f4682a.a(l4Var)).intValue());
        }
        return 0;
    }

    public boolean i0() {
        return c0() >= 0 || e0() >= 0.0f || f0() >= 0.0f;
    }
}
