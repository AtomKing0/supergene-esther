package com.ironsource;

import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ro {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, rm> f14721a;

    static final class a extends kotlin.jvm.internal.v implements h9.l<String, v8.s<? extends String, ? extends rm>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f14722a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(JSONObject jSONObject) {
            super(1);
            this.f14722a = jSONObject;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v8.s<String, rm> invoke(String networkName) throws JSONException {
            kotlin.jvm.internal.t.h(networkName, "networkName");
            JSONObject jSONObject = this.f14722a.getJSONObject(networkName);
            kotlin.jvm.internal.t.h(jSONObject, "providerSettings.getJSONObject(networkName)");
            return v8.y.a(networkName, new rm(networkName, jSONObject));
        }
    }

    public ro(@NotNull JSONObject providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        Iterator<String> itKeys = providerSettings.keys();
        kotlin.jvm.internal.t.h(itKeys, "providerSettings\n          .keys()");
        Map<String, rm> mapV = kotlin.collections.r0.v(o9.o.s(o9.m.c(itKeys), new a(providerSettings)));
        this.f14721a = mapV;
        for (Map.Entry<String, rm> entry : mapV.entrySet()) {
            entry.getKey();
            rm value = entry.getValue();
            if (b(value)) {
                value.b(a(value));
            }
        }
    }

    private final rm a(rm rmVar) {
        return this.f14721a.get(rmVar.h());
    }

    private final boolean b(rm rmVar) {
        if (rmVar.o()) {
            return rmVar.l().length() > 0;
        }
        return false;
    }

    @NotNull
    public final Map<String, rm> a() {
        return this.f14721a;
    }
}
