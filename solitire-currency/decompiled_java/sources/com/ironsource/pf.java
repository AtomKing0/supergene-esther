package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v8;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class pf implements u2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14325b = "pf";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static pf f14326c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, hg> f14327a = Collections.synchronizedMap(new HashMap());

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ of f14328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f14329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14330c;

        a(of ofVar, Context context, String str) {
            this.f14328a = ofVar;
            this.f14329b = context;
            this.f14330c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            pf.this.f14327a.put(this.f14330c, new jf(this.f14328a, this.f14329b));
        }
    }

    private hf a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(v8.h.O));
            String string = jSONObject2.get("height").toString();
            String string2 = jSONObject2.get("width").toString();
            return new hf(Integer.parseInt(string2), Integer.parseInt(string), jSONObject2.get("label").toString());
        } catch (Exception e10) {
            i9.d().a(e10);
            return new hf();
        }
    }

    private hf b(JSONObject jSONObject) {
        hf hfVar = new hf();
        try {
            return a(jSONObject);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return hfVar;
        }
    }

    public String c(JSONObject jSONObject) throws JSONException {
        return (jSONObject == null || !jSONObject.has("adViewId")) ? (jSONObject == null || !jSONObject.has("params")) ? "" : new JSONObject(jSONObject.getString("params")).getString("adViewId") : jSONObject.getString("adViewId");
    }

    public void d(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = new JSONObject(jSONObject.getString("params")).getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(f14325b, "sendMessageToAd fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f14327a.containsKey(string)) {
            Logger.i(f14325b, "sendMessageToAd fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        hg hgVar = this.f14327a.get(string);
        if (hgVar != null) {
            hgVar.c(jSONObject, str, str2);
        }
    }

    private boolean d(JSONObject jSONObject) {
        return jSONObject.optBoolean(v8.h.f15816s0);
    }

    @Override // com.ironsource.u2
    @Nullable
    public hg a(String str) {
        if (str.isEmpty() || !this.f14327a.containsKey(str)) {
            return null;
        }
        return this.f14327a.get(str);
    }

    public void b(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(f14325b, "performWebViewAction fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f14327a.containsKey(string)) {
            Logger.i(f14325b, "performWebViewAction fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        hg hgVar = this.f14327a.get(string);
        String string2 = jSONObject.getString(v8.h.f15822v0);
        if (hgVar != null) {
            hgVar.a(string2, str, str2);
        }
    }

    public void c(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(f14325b, "removeAdView fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f14327a.containsKey(string)) {
            Logger.i(f14325b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        hg hgVar = this.f14327a.get(string);
        this.f14327a.remove(string);
        if (hgVar != null) {
            hgVar.a(str, str2);
        }
    }

    public static synchronized pf a() {
        if (f14326c == null) {
            f14326c = new pf();
        }
        return f14326c;
    }

    public void a(kf kfVar, JSONObject jSONObject, Context context, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(f14325b, "loadWithUrl fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        hf hfVarB = b(jSONObject);
        if (this.f14327a.containsKey(string)) {
            Logger.i(f14325b, "sendMessageToAd fail - collection already contain adViewId");
            throw new Exception("collection already contain adViewId");
        }
        of ofVar = new of(kfVar, context, string, hfVarB);
        ofVar.e(IronSourceStorageUtils.getNetworkStorageDir(context));
        ofVar.b(jSONObject, str, str2);
        if (d(jSONObject)) {
            ve.f15889a.d(new a(ofVar, context, string));
        } else {
            this.f14327a.put(string, ofVar);
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(f14325b, "removeAdView fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f14327a.containsKey(string)) {
            Logger.i(f14325b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        hg hgVar = this.f14327a.get(string);
        if (hgVar != null) {
            hgVar.a(jSONObject, str, str2);
        }
    }
}
