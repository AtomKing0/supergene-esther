package com.ironsource.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.ju;
import com.ironsource.kf;
import com.ironsource.pf;
import com.ironsource.xu;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a implements kf {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14877d = "loadWithUrl";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14878e = "sendMessage";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f14879f = "removeAdView";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f14880g = "webviewAction";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f14881h = "handleGetViewVisibility";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f14882i = "functionName";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f14883j = "functionParams";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f14884k = "success";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f14885l = "fail";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f14886m = "errMsg";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f14887n = "%s | unsupported AdViews API";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private xu f14888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private pf f14889b = pf.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f14890c;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f14891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f14892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f14893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f14894d;

        private b() {
        }
    }

    public a(Context context) {
        this.f14890c = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.f14891a = jSONObject.optString("functionName");
        bVar.f14892b = jSONObject.optJSONObject("functionParams");
        bVar.f14893c = jSONObject.optString("success");
        bVar.f14894d = jSONObject.optString("fail");
        return bVar;
    }

    public void a(xu xuVar) {
        this.f14888a = xuVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(java.lang.String r10, com.ironsource.mj r11) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.a.a(java.lang.String, com.ironsource.mj):void");
    }

    @Override // com.ironsource.kf
    public void a(String str, String str2, String str3) {
        a(str, ju.a(str2, str3));
    }

    @Override // com.ironsource.kf
    public void a(String str, JSONObject jSONObject) {
        if (this.f14888a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f14888a.a(str, jSONObject);
    }
}
