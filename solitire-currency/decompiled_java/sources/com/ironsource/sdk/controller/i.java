package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.ce;
import com.ironsource.el;
import com.ironsource.mj;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.v8;
import com.ironsource.wp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15026c = "i";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15027d = "getDeviceData";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15028e = "deviceDataFunction";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15029f = "deviceDataParams";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f15030g = "success";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f15031h = "fail";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ce f15033b = el.N().f();

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15037d;

        private b() {
        }
    }

    public i(Context context) {
        this.f15032a = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.f15034a = jSONObject.optString(f15028e);
        bVar.f15035b = jSONObject.optJSONObject(f15029f);
        bVar.f15036c = jSONObject.optString("success");
        bVar.f15037d = jSONObject.optString("fail");
        return bVar;
    }

    private wp a() {
        wp wpVar = new wp();
        wpVar.b(SDKUtils.encodeString(v8.i.f15848i0), SDKUtils.encodeString(String.valueOf(this.f15033b.c())));
        wpVar.b(SDKUtils.encodeString(v8.i.f15850j0), SDKUtils.encodeString(String.valueOf(this.f15033b.h(this.f15032a))));
        wpVar.b(SDKUtils.encodeString(v8.i.f15852k0), SDKUtils.encodeString(String.valueOf(this.f15033b.G(this.f15032a))));
        wpVar.b(SDKUtils.encodeString(v8.i.f15854l0), SDKUtils.encodeString(String.valueOf(this.f15033b.l(this.f15032a))));
        wpVar.b(SDKUtils.encodeString(v8.i.f15856m0), SDKUtils.encodeString(String.valueOf(this.f15033b.c(this.f15032a))));
        wpVar.b(SDKUtils.encodeString(v8.i.f15858n0), SDKUtils.encodeString(String.valueOf(this.f15033b.d(this.f15032a))));
        return wpVar;
    }

    void a(String str, mj mjVar) throws Exception {
        b bVarA = a(str);
        if (f15027d.equals(bVarA.f15034a)) {
            mjVar.a(true, bVarA.f15036c, a());
            return;
        }
        Logger.i(f15026c, "unhandled API request " + str);
    }
}
