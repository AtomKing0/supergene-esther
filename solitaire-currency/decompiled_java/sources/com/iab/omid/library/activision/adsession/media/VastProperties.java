package com.iab.omid.library.activision.adsession.media;

import com.iab.omid.library.activision.utils.d;
import com.iab.omid.library.activision.utils.g;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f10519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f10521d;

    private VastProperties(boolean z10, Float f10, boolean z11, Position position) {
        this.f10518a = z10;
        this.f10519b = f10;
        this.f10520c = z11;
        this.f10521d = position;
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
            jSONObject.put("skippable", this.f10518a);
            if (this.f10518a) {
                jSONObject.put("skipOffset", this.f10519b);
            }
            jSONObject.put("autoPlay", this.f10520c);
            jSONObject.put(v8.h.L, this.f10521d);
        } catch (JSONException e10) {
            d.a("VastProperties: JSON error", e10);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f10521d;
    }

    public Float getSkipOffset() {
        return this.f10519b;
    }

    public boolean isAutoPlay() {
        return this.f10520c;
    }

    public boolean isSkippable() {
        return this.f10518a;
    }
}
