package com.iab.omid.library.ironsrc.adsession.media;

import com.iab.omid.library.ironsrc.utils.d;
import com.iab.omid.library.ironsrc.utils.g;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f10790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f10792d;

    private VastProperties(boolean z10, Float f10, boolean z11, Position position) {
        this.f10789a = z10;
        this.f10790b = f10;
        this.f10791c = z11;
        this.f10792d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z10, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(false, null, z10, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f10, boolean z10, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f10), z10, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f10789a);
            if (this.f10789a) {
                jSONObject.put("skipOffset", this.f10790b);
            }
            jSONObject.put("autoPlay", this.f10791c);
            jSONObject.put(v8.h.L, this.f10792d);
        } catch (JSONException e10) {
            d.a("VastProperties: JSON error", e10);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f10792d;
    }

    public Float getSkipOffset() {
        return this.f10790b;
    }

    public boolean isAutoPlay() {
        return this.f10791c;
    }

    public boolean isSkippable() {
        return this.f10789a;
    }
}
