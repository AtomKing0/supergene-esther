package com.ironsource;

import com.ironsource.ee;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ab implements ee, ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private JSONObject f11207a = new JSONObject();

    private final JSONObject c() {
        JSONObject jSONObjectOptJSONObject = this.f11207a.optJSONObject(bb.f11388a);
        return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
    }

    @Override // com.ironsource.cb
    public int a() {
        String strOptString = c().optString(db.f11787b);
        kotlin.jvm.internal.t.h(strOptString, "traits.optString(ISN_CTRL_INIT_DELAY)");
        Integer numL = p9.p.l(strOptString);
        if (numL != null) {
            return numL.intValue();
        }
        return 0;
    }

    @Override // com.ironsource.cb
    public boolean b() {
        String strOptString = c().optString(db.f11786a);
        kotlin.jvm.internal.t.h(strOptString, "traits.optString(IS_EP_CONFIG_ENABLED)");
        String lowerCase = strOptString.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return kotlin.jvm.internal.t.d(lowerCase, com.ironsource.mediationsdk.metadata.a.f13688g);
    }

    @Override // com.ironsource.ee
    @NotNull
    public JSONObject config() {
        return this.f11207a;
    }

    @Override // com.ironsource.ee.a
    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = this.f11207a;
        }
        this.f11207a = jSONObject;
        IronLog.INTERNAL.verbose("setEpConfig: " + this.f11207a);
    }
}
