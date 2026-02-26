package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f4880a;

    public b1(JSONObject jSONObject) {
        this.f4880a = jSONObject;
    }

    protected Integer a() {
        return JsonUtils.getInteger(this.f4880a, "dark_mode_toolbar_color", null);
    }

    protected String b() {
        return JsonUtils.getString(this.f4880a, "digital_asset_link_url", null);
    }

    protected Boolean c() {
        return JsonUtils.getBoolean(this.f4880a, "instant_apps_enabled", null);
    }

    protected String d() {
        return JsonUtils.getString(this.f4880a, "referrer", null);
    }

    protected Integer e() {
        return JsonUtils.getInteger(this.f4880a, "session_url_relation", null);
    }

    protected Integer f() {
        return JsonUtils.getInteger(this.f4880a, "share_state", null);
    }

    protected Boolean g() {
        return JsonUtils.getBoolean(this.f4880a, "should_show_title", null);
    }

    protected Integer h() {
        return JsonUtils.getInteger(this.f4880a, "toolbar_color", null);
    }

    protected Boolean i() {
        return JsonUtils.getBoolean(this.f4880a, "url_bar_hiding_enabled", null);
    }
}
