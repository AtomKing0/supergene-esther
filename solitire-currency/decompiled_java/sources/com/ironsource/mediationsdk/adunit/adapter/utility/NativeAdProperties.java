package com.ironsource.mediationsdk.adunit.adapter.utility;

import com.ironsource.i9;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class NativeAdProperties {

    @NotNull
    private final AdOptionsPosition adOptionsPosition;

    @NotNull
    private final AdOptionsPosition defaultAdOptionPosition;

    public NativeAdProperties(@NotNull JSONObject config) {
        t.i(config, "config");
        this.defaultAdOptionPosition = AdOptionsPosition.BOTTOM_LEFT;
        this.adOptionsPosition = getAdOptionsPosition(config);
    }

    @NotNull
    public final AdOptionsPosition getAdOptionsPosition() {
        return this.adOptionsPosition;
    }

    private final AdOptionsPosition getAdOptionsPosition(JSONObject jSONObject) {
        String position = jSONObject.optString(AdOptionsPosition.AD_OPTIONS_POSITION_KEY, this.defaultAdOptionPosition.toString());
        try {
            t.h(position, "position");
            return AdOptionsPosition.valueOf(position);
        } catch (Exception e10) {
            i9.d().a(e10);
            return this.defaultAdOptionPosition;
        }
    }
}
