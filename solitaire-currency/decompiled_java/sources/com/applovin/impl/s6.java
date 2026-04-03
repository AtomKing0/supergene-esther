package com.applovin.impl;

import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f6818c;

    public s6(com.applovin.impl.sdk.j jVar) {
        this.f6816a = jVar;
        n4 n4Var = n4.E;
        this.f6817b = ((Boolean) jVar.a(n4Var, Boolean.FALSE)).booleanValue() || w.a(com.applovin.impl.sdk.j.n()).a("applovin.sdk.is_test_environment") || AppLovinSdkUtils.isEmulator() || jVar.y().Q();
        jVar.c(n4Var);
    }

    private void e() {
        com.applovin.impl.sdk.i iVarR = this.f6816a.r();
        if (this.f6817b) {
            iVarR.b(this.f6818c);
        } else {
            iVarR.a(this.f6818c);
        }
    }

    public void a(String str) {
        if (StringUtils.isValidString(str)) {
            a(Collections.singletonList(str));
        } else {
            a((List) null);
        }
    }

    public List b() {
        return this.f6818c;
    }

    public boolean c() {
        return this.f6817b;
    }

    public boolean d() {
        List list = this.f6818c;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void a(List list) {
        if (list == null && this.f6818c == null) {
            return;
        }
        if (list == null || !list.equals(this.f6818c)) {
            this.f6818c = list;
            e();
        }
    }

    public void a() {
        this.f6816a.b(n4.E, Boolean.TRUE);
    }

    public void a(JSONObject jSONObject) {
        if (this.f6817b) {
            return;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray());
        com.applovin.impl.sdk.k kVarY = this.f6816a.y();
        boolean zQ = kVarY.Q();
        String strA = kVarY.f().a();
        k.b bVarD = kVarY.D();
        this.f6817b = zQ || JsonUtils.containsCaseInsensitiveString(strA, jSONArray) || JsonUtils.containsCaseInsensitiveString(bVarD != null ? bVarD.f7155a : null, jSONArray);
    }
}
