package com.ironsource;

import com.ironsource.mediationsdk.e;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a5 extends e.a {
    public a5(l4 l4Var, URL url, JSONObject jSONObject, boolean z10, int i10, long j10, boolean z11, boolean z12, int i11) {
        super(l4Var, url, jSONObject, z10, i10, j10, z11, z12, i11);
    }

    @Override // com.ironsource.mediationsdk.e.a
    protected void a(boolean z10, l4 l4Var, long j10) {
        try {
            if (z10) {
                ((t4) l4Var).a(this.f13562b, this.f13566f + 1, j10, this.f13570j, this.f13569i);
            } else {
                l4Var.a(this.f13563c, this.f13564d, this.f13566f + 1, this.f13567g, j10);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            l4Var.a(1009, e10.getMessage(), this.f13566f + 1, this.f13567g, j10);
        }
    }
}
