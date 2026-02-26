package com.braze.models;

import bo.app.px;
import bo.app.rx;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import h9.a;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class FeatureFlag implements IPutIntoJson<JSONObject> {
    public static final px Companion = new px();
    private final boolean enabled;
    private final String id;
    private final JSONObject properties;
    private final String trackingString;

    public FeatureFlag(String id, boolean z10, JSONObject properties, String str) {
        t.i(id, "id");
        t.i(properties, "properties");
        this.id = id;
        this.enabled = z10;
        this.properties = properties;
        this.trackingString = str;
    }

    public final FeatureFlag deepcopy$android_sdk_base_release() {
        return new FeatureFlag(this.id, this.enabled, JsonUtils.deepcopy(this.properties), this.trackingString);
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("enabled", this.enabled);
            jSONObject.put("properties", this.properties);
            jSONObject.put("fts", this.trackingString);
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) rx.f3810a, 4, (Object) null);
        }
        return jSONObject;
    }
}
