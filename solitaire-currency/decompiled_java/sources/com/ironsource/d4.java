package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final JSONObject f11754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f11756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f11761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f11762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f11763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f11764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final JSONObject f11765l;

    public d4(@NotNull JSONObject config) {
        kotlin.jvm.internal.t.i(config, "config");
        this.f11754a = config;
        this.f11755b = config.optBoolean("isExternalArmEventsEnabled", true);
        String strOptString = config.optString("externalArmEventsUrl", ac.f11217j);
        kotlin.jvm.internal.t.h(strOptString, "config.optString(EXTERNA…AL_EVENTS_IMPRESSION_URL)");
        this.f11756c = strOptString;
        this.f11757d = config.optBoolean("sid", true);
        this.f11758e = config.optBoolean("radvid", false);
        this.f11759f = config.optInt("uaeh", 0);
        this.f11760g = config.optBoolean("sharedThreadPool", false);
        this.f11761h = config.optBoolean("sharedThreadPoolADP", true);
        this.f11762i = config.optInt(ad.B0, -1);
        this.f11763j = config.optBoolean("axal", false);
        this.f11764k = config.optBoolean("psrt", false);
        this.f11765l = config.optJSONObject("epConfig");
    }

    public static /* synthetic */ d4 a(d4 d4Var, JSONObject jSONObject, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jSONObject = d4Var.f11754a;
        }
        return d4Var.a(jSONObject);
    }

    public final int b() {
        return this.f11762i;
    }

    @Nullable
    public final JSONObject c() {
        return this.f11765l;
    }

    @NotNull
    public final String d() {
        return this.f11756c;
    }

    public final boolean e() {
        return this.f11764k;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d4) && kotlin.jvm.internal.t.d(this.f11754a, ((d4) obj).f11754a);
    }

    public final boolean f() {
        return this.f11758e;
    }

    public final boolean g() {
        return this.f11757d;
    }

    public final boolean h() {
        return this.f11760g;
    }

    public int hashCode() {
        return this.f11754a.hashCode();
    }

    public final boolean i() {
        return this.f11761h;
    }

    public final int j() {
        return this.f11759f;
    }

    public final boolean k() {
        return this.f11763j;
    }

    public final boolean l() {
        return this.f11755b;
    }

    @NotNull
    public String toString() {
        return "ApplicationGeneralSettings(config=" + this.f11754a + ')';
    }

    @NotNull
    public final d4 a(@NotNull JSONObject config) {
        kotlin.jvm.internal.t.i(config, "config");
        return new d4(config);
    }

    private final JSONObject a() {
        return this.f11754a;
    }
}
