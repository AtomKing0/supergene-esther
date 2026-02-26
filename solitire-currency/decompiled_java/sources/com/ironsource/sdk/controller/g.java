package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15015c = "com.ironsource.sdk.controller.g";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15016d = "functionName";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15017e = "params";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15018f = "hash";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f15019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f15020b;

    g(b bVar, s sVar) {
        this.f15019a = bVar;
        this.f15020b = sVar;
    }

    private String a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("functionName", SDKUtils.encodeString(str));
            jSONObject.put("params", SDKUtils.encodeString(str2));
            jSONObject.put(f15018f, SDKUtils.encodeString(str3));
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        return jSONObject.toString();
    }

    private void b(String str, String str2, String str3) {
        this.f15019a.a(a(str, str2, str3));
    }

    @JavascriptInterface
    public void messageHandler(String str, String str2, String str3) {
        try {
            Logger.i(f15015c, "messageHandler(" + str + " " + str3 + ")");
            if (this.f15020b.a(str, str2, str3)) {
                a(str, str2);
            } else {
                b(str, str2, str3);
            }
        } catch (Exception e10) {
            a(e10);
        }
    }

    private void a(Exception exc) {
        IronLog.INTERNAL.error(exc.toString());
        Logger.i(f15015c, "messageHandler failed with exception " + exc.getMessage());
    }

    private void a(String str, String str2) throws Exception {
        this.f15019a.a(str, str2);
    }
}
