package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.environment.StringUtils;
import com.ironsource.hm;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mj;
import com.ironsource.rt;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.wp;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15130d = "u";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15131e = "updateToken";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15132f = "getToken";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f15133g = "functionName";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f15134h = "functionParams";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15135i = "success";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f15136j = "fail";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15138b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hm f15137a = new hm();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private rt f15139c = new rt();

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15143d;

        private b() {
        }
    }

    public u(Context context) {
        this.f15138b = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.f15140a = jSONObject.optString("functionName");
        bVar.f15141b = jSONObject.optJSONObject("functionParams");
        bVar.f15142c = jSONObject.optString("success");
        bVar.f15143d = jSONObject.optString("fail");
        return bVar;
    }

    private void a(b bVar, mj mjVar) {
        try {
            JSONObject jSONObjectA = this.f15139c.a();
            Iterator<String> itKeys = jSONObjectA.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObjectA.get(next);
                if (obj instanceof String) {
                    jSONObjectA.put(next, StringUtils.encodeURI((String) obj));
                }
            }
            mjVar.a(true, bVar.f15142c, jSONObjectA);
        } catch (Exception e10) {
            i9.d().a(e10);
            mjVar.a(false, bVar.f15143d, e10.getMessage());
        }
    }

    void a(String str, mj mjVar) throws Exception {
        b bVarA = a(str);
        if (f15131e.equals(bVarA.f15140a)) {
            a(bVarA.f15141b, bVarA, mjVar);
            return;
        }
        if (f15132f.equals(bVarA.f15140a)) {
            a(bVarA, mjVar);
            return;
        }
        Logger.i(f15130d, "unhandled API request " + str);
    }

    public void a(JSONObject jSONObject, b bVar, mj mjVar) {
        wp wpVar = new wp();
        try {
            this.f15137a.a(jSONObject);
            mjVar.a(true, bVar.f15142c, wpVar);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            Logger.i(f15130d, "updateToken exception " + e10.getMessage());
            mjVar.a(false, bVar.f15143d, wpVar);
        }
    }
}
