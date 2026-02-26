package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class rm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f14706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f14707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f14708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f14709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f14710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final JSONObject f14711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Map<String, JSONObject> f14712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final String f14713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final String f14714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f14715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private rm f14716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final v8.l f14717l;

    static final class a extends kotlin.jvm.internal.v implements h9.a<NetworkSettings> {
        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NetworkSettings invoke() {
            String strJ = rm.this.j();
            String strL = rm.this.l();
            String strH = rm.this.h();
            String strK = rm.this.k();
            JSONObject jSONObjectC = rm.this.c();
            rm rmVar = rm.this.f14716k;
            JSONObject jSONObjectMergeJsons = IronSourceUtils.mergeJsons(jSONObjectC, rmVar != null ? rmVar.c() : null);
            JSONObject jSONObjectM = rm.this.m();
            rm rmVar2 = rm.this.f14716k;
            JSONObject jSONObjectMergeJsons2 = IronSourceUtils.mergeJsons(jSONObjectM, rmVar2 != null ? rmVar2.m() : null);
            JSONObject jSONObjectE = rm.this.e();
            rm rmVar3 = rm.this.f14716k;
            JSONObject jSONObjectMergeJsons3 = IronSourceUtils.mergeJsons(jSONObjectE, rmVar3 != null ? rmVar3.e() : null);
            JSONObject jSONObjectD = rm.this.d();
            rm rmVar4 = rm.this.f14716k;
            JSONObject jSONObjectMergeJsons4 = IronSourceUtils.mergeJsons(jSONObjectD, rmVar4 != null ? rmVar4.d() : null);
            JSONObject jSONObjectG = rm.this.g();
            rm rmVar5 = rm.this.f14716k;
            NetworkSettings networkSettings = new NetworkSettings(strJ, strL, strH, strK, jSONObjectMergeJsons, jSONObjectMergeJsons2, jSONObjectMergeJsons3, jSONObjectMergeJsons4, IronSourceUtils.mergeJsons(jSONObjectG, rmVar5 != null ? rmVar5.g() : null));
            networkSettings.setIsMultipleInstances(rm.this.o());
            networkSettings.setSubProviderId(rm.this.n());
            networkSettings.setAdSourceNameForEvents(rm.this.b());
            return networkSettings;
        }
    }

    public rm(@NotNull String providerName, @NotNull JSONObject networkSettings) {
        kotlin.jvm.internal.t.i(providerName, "providerName");
        kotlin.jvm.internal.t.i(networkSettings, "networkSettings");
        this.f14706a = providerName;
        this.f14707b = providerName;
        String strOptString = networkSettings.optString(sm.f15320d, providerName);
        kotlin.jvm.internal.t.h(strOptString, "networkSettings.optStrin…,\n          providerName)");
        this.f14708c = strOptString;
        String strOptString2 = networkSettings.optString(sm.f15321e, strOptString);
        kotlin.jvm.internal.t.h(strOptString2, "networkSettings.optStrin…roviderTypeForReflection)");
        this.f14709d = strOptString2;
        Object objOpt = networkSettings.opt(sm.f15322f);
        this.f14710e = objOpt instanceof String ? (String) objOpt : null;
        this.f14711f = networkSettings.optJSONObject("application");
        LevelPlay.AdFormat[] adFormatArrValues = LevelPlay.AdFormat.values();
        ArrayList arrayList = new ArrayList(adFormatArrValues.length);
        for (LevelPlay.AdFormat adFormat : adFormatArrValues) {
            arrayList.add(ks.a(adFormat));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(kotlin.collections.w.v(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            String str = (String) obj;
            JSONObject jSONObjectOptJSONObject = networkSettings.optJSONObject("adFormats");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(str) : null;
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
            }
            linkedHashMap.put(obj, jSONObjectOptJSONObject2);
        }
        this.f14712g = linkedHashMap;
        String strOptString3 = networkSettings.optString("spId", "0");
        kotlin.jvm.internal.t.h(strOptString3, "networkSettings.optStrin…B_PROVIDER_ID_FIELD, \"0\")");
        this.f14713h = strOptString3;
        String strOptString4 = networkSettings.optString(sm.f15317a);
        kotlin.jvm.internal.t.h(strOptString4, "networkSettings.optString(AD_SOURCE_NAME_FIELD)");
        this.f14714i = strOptString4;
        this.f14715j = networkSettings.optBoolean(sm.f15319c, false);
        this.f14717l = v8.n.a(new a());
    }

    @NotNull
    public final String b() {
        return this.f14714i;
    }

    @Nullable
    public final JSONObject c() {
        return this.f14711f;
    }

    @NotNull
    public final JSONObject d() {
        JSONObject jSONObjectMergeJsons = IronSourceUtils.mergeJsons(this.f14712g.get("banner"), this.f14711f);
        kotlin.jvm.internal.t.h(jSONObjectMergeJsons, "mergeJsons(\n            …EY], applicationSettings)");
        return jSONObjectMergeJsons;
    }

    @NotNull
    public final JSONObject e() {
        JSONObject jSONObjectMergeJsons = IronSourceUtils.mergeJsons(this.f14712g.get("interstitial"), this.f14711f);
        kotlin.jvm.internal.t.h(jSONObjectMergeJsons, "mergeJsons(\n            …EY], applicationSettings)");
        return jSONObjectMergeJsons;
    }

    @NotNull
    public final NetworkSettings f() {
        return (NetworkSettings) this.f14717l.getValue();
    }

    @NotNull
    public final JSONObject g() {
        JSONObject jSONObjectMergeJsons = IronSourceUtils.mergeJsons(this.f14712g.get(kq.f12892i), this.f14711f);
        kotlin.jvm.internal.t.h(jSONObjectMergeJsons, "mergeJsons(\n            …EY], applicationSettings)");
        return jSONObjectMergeJsons;
    }

    @NotNull
    public final String h() {
        return this.f14709d;
    }

    @NotNull
    public final String i() {
        return this.f14707b;
    }

    @NotNull
    public final String j() {
        return this.f14706a;
    }

    @Nullable
    public final String k() {
        return this.f14710e;
    }

    @NotNull
    public final String l() {
        return this.f14708c;
    }

    @NotNull
    public final JSONObject m() {
        JSONObject jSONObjectMergeJsons = IronSourceUtils.mergeJsons(this.f14712g.get("rewarded"), this.f14711f);
        kotlin.jvm.internal.t.h(jSONObjectMergeJsons, "mergeJsons(\n            …     applicationSettings)");
        return jSONObjectMergeJsons;
    }

    @NotNull
    public final String n() {
        return this.f14713h;
    }

    public final boolean o() {
        return this.f14715j;
    }

    @NotNull
    public final Map<String, JSONObject> a() {
        return this.f14712g;
    }

    public final void b(@Nullable rm rmVar) {
        this.f14716k = rmVar;
    }
}
