package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.qf;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.v8;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class hm {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ce f12506b = el.N().f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ed f12505a = new ed();

    public void a() {
        JSONObject jSONObject = new JSONObject(IronSourceQaProperties.getInstance().getParameters());
        if (jSONObject.length() > 0) {
            this.f12505a.a("debug", jSONObject);
        }
    }

    public void b() {
        String controllerConfig = SDKUtils.getControllerConfig();
        if (TextUtils.isEmpty(controllerConfig)) {
            return;
        }
        try {
            this.f12505a.a(ad.f11242i, new JSONObject(controllerConfig).opt(v8.a.f15689p));
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void c() {
        this.f12505a.a("uxt", Boolean.valueOf(IronSourceStorageUtils.isUxt()));
    }

    public void d() {
        this.f12505a.a(ad.M, "8.4.0");
    }

    public void e() {
        HashMap map = new HashMap();
        map.put(ad.f11274x, zm.f16439f);
        map.put(ad.f11272w, zm.f16438e);
        this.f12505a.a(map);
    }

    public void a(Context context) {
        if (context instanceof Activity) {
            this.f12505a.a(ad.f11254n, Boolean.valueOf(this.f12506b.a((Activity) context)));
        }
    }

    public void b(Context context) {
        this.f12505a.a("gpi", Boolean.valueOf(un.d(context)));
    }

    public void a(qf.c cVar) {
        this.f12505a.a(ad.f11238g1, Integer.valueOf(cVar.ordinal()));
    }

    public void a(List<String> list) {
        this.f12505a.a(ad.f11247j1, list);
    }

    public void a(Map<String, JSONObject> map) {
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            this.f12505a.a(entry.getKey(), (Object) entry.getValue());
        }
    }

    public void a(JSONObject jSONObject) {
        this.f12505a.a(ad.f11250l, jSONObject);
    }

    public void a(boolean z10) {
        this.f12505a.a(ad.A0, Boolean.valueOf(z10));
    }
}
