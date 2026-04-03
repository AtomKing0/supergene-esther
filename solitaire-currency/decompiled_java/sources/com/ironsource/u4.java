package com.ironsource;

import com.ironsource.ad;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final ad.a f15557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ArrayList<String> f15558b = new ArrayList<>(new s4().a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final cd f15559c = new cd();

    public u4(@Nullable ad.a aVar) {
        this.f15557a = aVar;
    }

    @NotNull
    public final JSONObject a() {
        ad.a aVar = this.f15557a;
        JSONObject jSONObjectA = aVar != null ? this.f15559c.a(this.f15558b, aVar) : null;
        if (jSONObjectA == null) {
            jSONObjectA = this.f15559c.a(this.f15558b);
            kotlin.jvm.internal.t.h(jSONObjectA, "mGlobalDataReader.getDataByKeys(mAuctionKeyList)");
        }
        return a(jSONObjectA);
    }

    private final JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectB = dd.b(jSONObject.optJSONObject(ad.f11264s));
        if (jSONObjectB != null) {
            jSONObject.put(ad.f11264s, jSONObjectB);
        }
        return jSONObject;
    }
}
