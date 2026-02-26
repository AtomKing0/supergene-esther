package com.applovin.impl;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.v8;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f6790a;

    public enum a {
        NEUTRAL,
        POSITIVE,
        NEGATIVE
    }

    private s0(JSONObject jSONObject) {
        this.f6790a = jSONObject;
    }

    public static s0 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "title", (JSONObject) null), v8.h.W, null);
        if ("TOS".equalsIgnoreCase(string) && jVar.v().h() == null) {
            return null;
        }
        if ("PP".equalsIgnoreCase(string) && jVar.v().f() == null) {
            return null;
        }
        return new s0(jSONObject);
    }

    public String b() {
        return JsonUtils.getString(this.f6790a, NotificationCompat.CATEGORY_EVENT, null);
    }

    public a c() {
        String string = JsonUtils.getString(this.f6790a, TtmlNode.TAG_STYLE, null);
        return "default".equalsIgnoreCase(string) ? a.POSITIVE : ("destructive".equalsIgnoreCase(string) || "cancel".equalsIgnoreCase(string)) ? a.NEGATIVE : a.NEUTRAL;
    }

    public String d() {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f6790a, "title", (JSONObject) null);
        return com.applovin.impl.sdk.j.a(JsonUtils.getString(jSONObject, v8.h.W, ""), JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "replacements", null), null));
    }

    public String toString() {
        return "ConsentFlowStateAlertAction{title=" + d() + ", destinationStateId=" + a() + ", event=" + b() + "}";
    }

    public int a() {
        return JsonUtils.getInt(this.f6790a, "destination_state_id", -1);
    }
}
