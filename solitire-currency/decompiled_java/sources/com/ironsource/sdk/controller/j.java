package com.ironsource.sdk.controller;

import com.ironsource.fc;
import com.ironsource.hc;
import com.ironsource.hn;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.nj;
import com.ironsource.oj;
import com.ironsource.rf;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.zf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final hc f15039b;

    class a implements hn {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ oj f15040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ nj f15041b;

        a(oj ojVar, nj njVar) {
            this.f15040a = ojVar;
            this.f15041b = njVar;
        }

        @Override // com.ironsource.hn
        public void a(zf zfVar) {
            try {
                oj ojVar = this.f15040a;
                nj njVar = this.f15041b;
                ojVar.b(njVar, j.this.a(njVar, zfVar.a()));
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @Override // com.ironsource.hn
        public void a(zf zfVar, rf rfVar) {
            try {
                oj ojVar = this.f15040a;
                nj njVar = this.f15041b;
                ojVar.a(njVar, j.this.a(njVar, rfVar.b()));
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }
    }

    j(String str, hc hcVar) {
        this.f15038a = str;
        this.f15039b = hcVar;
    }

    private hn a(nj njVar, oj ojVar) {
        return new a(ojVar, njVar);
    }

    private zf b(JSONObject jSONObject, String str) throws Exception {
        if (!jSONObject.has(fc.c.f12110c) || !jSONObject.has(fc.c.f12109b)) {
            throw new Exception(fc.a.f12094a);
        }
        String string = jSONObject.getString(fc.c.f12110c);
        return new zf(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, string), jSONObject.getString(fc.c.f12109b));
    }

    private zf a(JSONObject jSONObject, String str) throws Exception {
        if (jSONObject.has(fc.c.f12111d)) {
            return new zf(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, jSONObject.getString(fc.c.f12111d)));
        }
        throw new Exception(fc.a.f12095b);
    }

    private JSONObject a(nj njVar, long j10) {
        try {
            return njVar.e().put("result", j10);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(nj njVar, String str) {
        try {
            return njVar.e().put("errMsg", str);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(nj njVar, JSONObject jSONObject) {
        try {
            return njVar.e().put("result", jSONObject);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return new JSONObject();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(org.json.JSONObject r10, com.ironsource.mj r11) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.j.a(org.json.JSONObject, com.ironsource.mj):void");
    }
}
