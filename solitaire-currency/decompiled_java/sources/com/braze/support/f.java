package com.braze.support;

import bo.app.qy;
import com.braze.models.FeatureFlag;
import com.braze.support.BrazeLogger;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8118a = new f();

    public final FeatureFlag a(JSONObject featureFlagObject) {
        t.i(featureFlagObject, "featureFlagObject");
        try {
            String string = featureFlagObject.getString("id");
            t.h(string, "featureFlagObject.getString(FeatureFlag.ID)");
            boolean z10 = featureFlagObject.getBoolean("enabled");
            JSONObject jSONObjectOptJSONObject = featureFlagObject.optJSONObject("properties");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            return new FeatureFlag(string, z10, jSONObjectOptJSONObject, JsonUtils.getOptionalString(featureFlagObject, "fts"));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new qy(featureFlagObject), 4, (Object) null);
            return null;
        }
    }
}
