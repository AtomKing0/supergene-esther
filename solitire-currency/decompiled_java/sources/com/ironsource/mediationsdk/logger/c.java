package com.ironsource.mediationsdk.logger;

import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import io.sentry.protocol.ViewHierarchyNode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IronSourceLogger.IronSourceTag f13670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13673d;

    public c(IronSourceLogger.IronSourceTag ironSourceTag, String str, String str2, int i10) {
        this.f13670a = ironSourceTag;
        this.f13671b = str;
        this.f13672c = str2;
        this.f13673d = i10;
    }

    public int a() {
        return this.f13673d;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", this.f13671b);
            jSONObject.put(ViewHierarchyNode.JsonKeys.TAG, this.f13670a);
            jSONObject.put(AppLovinEventTypes.USER_COMPLETED_LEVEL, this.f13673d);
            jSONObject.put("message", this.f13672c);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        return jSONObject;
    }
}
