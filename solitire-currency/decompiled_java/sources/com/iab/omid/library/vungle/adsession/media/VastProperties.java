package com.iab.omid.library.vungle.adsession.media;

import com.iab.omid.library.vungle.utils.d;
import com.iab.omid.library.vungle.utils.g;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f11042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f11043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f11044d;

    private VastProperties(boolean z10, Float f10, boolean z11, Position position) {
        this.f11041a = z10;
        this.f11042b = f10;
        this.f11043c = z11;
        this.f11044d = position;
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
            jSONObject.put("skippable", this.f11041a);
            if (this.f11041a) {
                jSONObject.put("skipOffset", this.f11042b);
            }
            jSONObject.put("autoPlay", this.f11043c);
            jSONObject.put(v8.h.L, this.f11044d);
        } catch (JSONException e10) {
            d.a("VastProperties: JSON error", e10);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f11044d;
    }

    public Float getSkipOffset() {
        return this.f11042b;
    }

    public boolean isAutoPlay() {
        return this.f11043c;
    }

    public boolean isSkippable() {
        return this.f11041a;
    }
}
