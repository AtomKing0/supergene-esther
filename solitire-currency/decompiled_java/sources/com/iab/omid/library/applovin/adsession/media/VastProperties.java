package com.iab.omid.library.applovin.adsession.media;

import com.iab.omid.library.applovin.utils.d;
import com.iab.omid.library.applovin.utils.g;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f10654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f10656d;

    private VastProperties(boolean z10, Float f10, boolean z11, Position position) {
        this.f10653a = z10;
        this.f10654b = f10;
        this.f10655c = z11;
        this.f10656d = position;
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
            jSONObject.put("skippable", this.f10653a);
            if (this.f10653a) {
                jSONObject.put("skipOffset", this.f10654b);
            }
            jSONObject.put("autoPlay", this.f10655c);
            jSONObject.put(v8.h.L, this.f10656d);
        } catch (JSONException e10) {
            d.a("VastProperties: JSON error", e10);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f10656d;
    }

    public Float getSkipOffset() {
        return this.f10654b;
    }

    public boolean isAutoPlay() {
        return this.f10655c;
    }

    public boolean isSkippable() {
        return this.f10653a;
    }
}
