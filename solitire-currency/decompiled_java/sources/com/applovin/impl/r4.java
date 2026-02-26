package com.applovin.impl;

import com.applovin.impl.p4;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r4 extends a3 {
    public r4(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, jVar);
    }

    public p4.b t() {
        return p4.b.values()[a("signal_cache_level", ((Integer) this.f4682a.a(g3.Y6)).intValue())];
    }

    @Override // com.applovin.impl.a3
    public String toString() {
        return "SignalProviderSpec{adObject=" + a() + '}';
    }

    public long u() {
        return a("signal_expiration_ms", ((Long) this.f4682a.a(g3.X6)).longValue());
    }

    public boolean v() {
        return a("only_collect_signal_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean w() {
        return a("prefer_collect_signal_when_initialized", Boolean.TRUE).booleanValue();
    }

    public boolean x() {
        return a("fail_collection_for_empty_signal", (Boolean) this.f4682a.a(g3.f5256z7)).booleanValue();
    }

    public boolean y() {
        return a("ignore_init_failure", Boolean.FALSE).booleanValue();
    }

    public boolean z() {
        return a("use_cached_adapter", Boolean.TRUE).booleanValue();
    }
}
