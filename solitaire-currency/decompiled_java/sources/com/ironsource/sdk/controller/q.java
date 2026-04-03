package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mj;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v3;
import com.ironsource.wp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15108b = "q";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15109c = "getPermissions";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15110d = "isPermissionGranted";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15111e = "permissions";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15112f = "permission";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f15113g = "status";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f15114h = "functionName";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15115i = "functionParams";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f15116j = "success";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f15117k = "fail";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f15118l = "unhandledPermission";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15119a;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15122c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15123d;

        private b() {
        }
    }

    public q(Context context) {
        this.f15119a = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.f15120a = jSONObject.optString("functionName");
        bVar.f15121b = jSONObject.optJSONObject("functionParams");
        bVar.f15122c = jSONObject.optString("success");
        bVar.f15123d = jSONObject.optString("fail");
        return bVar;
    }

    public void b(JSONObject jSONObject, b bVar, mj mjVar) {
        String str;
        boolean z10;
        wp wpVar = new wp();
        try {
            String string = jSONObject.getString(f15112f);
            wpVar.b(f15112f, string);
            if (v3.d(this.f15119a, string)) {
                wpVar.b("status", String.valueOf(v3.c(this.f15119a, string)));
                str = bVar.f15122c;
                z10 = true;
            } else {
                wpVar.b("status", f15118l);
                str = bVar.f15123d;
                z10 = false;
            }
            mjVar.a(z10, str, wpVar);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            wpVar.b("errMsg", e10.getMessage());
            mjVar.a(false, bVar.f15123d, wpVar);
        }
    }

    void a(String str, mj mjVar) throws Exception {
        b bVarA = a(str);
        if (f15109c.equals(bVarA.f15120a)) {
            a(bVarA.f15121b, bVarA, mjVar);
            return;
        }
        if (f15110d.equals(bVarA.f15120a)) {
            b(bVarA.f15121b, bVarA, mjVar);
            return;
        }
        Logger.i(f15108b, "PermissionsJSAdapter unhandled API request " + str);
    }

    public void a(JSONObject jSONObject, b bVar, mj mjVar) {
        wp wpVar = new wp();
        try {
            wpVar.a("permissions", v3.a(this.f15119a, jSONObject.getJSONArray("permissions")));
            mjVar.a(true, bVar.f15122c, wpVar);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            Logger.i(f15108b, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e10.getMessage());
            wpVar.b("errMsg", e10.getMessage());
            mjVar.a(false, bVar.f15123d, wpVar);
        }
    }
}
