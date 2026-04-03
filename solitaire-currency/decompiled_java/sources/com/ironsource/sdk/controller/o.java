package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.zm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15081c = "o";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15082d = "activate";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15083e = "startSession";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15084f = "finishSession";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f15085g = "impressionOccurred";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f15086h = "getOmidData";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15087i = "omidFunction";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f15088j = "omidParams";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f15089k = "success";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f15090l = "fail";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f15091m = "%s | unsupported OMID API";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zm f15093b = new zm();

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15097d;

        private b() {
        }
    }

    public o(Context context) {
        this.f15092a = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.f15094a = jSONObject.optString(f15087i);
        bVar.f15095b = jSONObject.optJSONObject(f15088j);
        bVar.f15096c = jSONObject.optString("success");
        bVar.f15097d = jSONObject.optString("fail");
        return bVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(java.lang.String r9, com.ironsource.mj r10) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.o.a(java.lang.String, com.ironsource.mj):void");
    }
}
