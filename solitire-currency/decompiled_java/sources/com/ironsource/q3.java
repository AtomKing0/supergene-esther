package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<LevelPlay.AdFormat, p> f14432a;

    public q3(@NotNull JSONObject applicationAuctionSettings) {
        kotlin.jvm.internal.t.i(applicationAuctionSettings, "applicationAuctionSettings");
        LevelPlay.AdFormat[] adFormatArrValues = LevelPlay.AdFormat.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(adFormatArrValues.length), 16));
        for (LevelPlay.AdFormat adFormat : adFormatArrValues) {
            JSONObject jSONObjectOptJSONObject = applicationAuctionSettings.optJSONObject(ks.a(adFormat));
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            } else {
                kotlin.jvm.internal.t.h(jSONObjectOptJSONObject, "applicationAuctionSettin…ormatKey) ?: JSONObject()");
            }
            linkedHashMap.put(adFormat, new p(jSONObjectOptJSONObject));
        }
        this.f14432a = linkedHashMap;
    }

    @NotNull
    public final Map<LevelPlay.AdFormat, p> a() {
        return this.f14432a;
    }
}
