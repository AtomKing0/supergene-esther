package com.ironsource;

import java.util.HashSet;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f15988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final HashSet<String> f15989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f15990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f15991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f15992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f15994g;

    public w3(@NotNull JSONObject applicationCrashReporterSettings) throws JSONException {
        kotlin.jvm.internal.t.i(applicationCrashReporterSettings, "applicationCrashReporterSettings");
        this.f15988a = applicationCrashReporterSettings.optBoolean("enabled", false);
        List<String> listB = hj.b(applicationCrashReporterSettings.optJSONArray(y3.f16246b));
        this.f15989b = listB != null ? kotlin.collections.d0.N0(listB) : null;
        String strOptString = applicationCrashReporterSettings.optString(y3.f16247c);
        kotlin.jvm.internal.t.h(strOptString, "applicationCrashReporter…(CRASHREPORTER_URL_FIELD)");
        this.f15990c = strOptString;
        String strOptString2 = applicationCrashReporterSettings.optString(y3.f16248d);
        kotlin.jvm.internal.t.h(strOptString2, "applicationCrashReporter…SHREPORTER_KEYWORD_FIELD)");
        this.f15991d = strOptString2;
        this.f15992e = applicationCrashReporterSettings.optBoolean(y3.f16249e, false);
        this.f15993f = applicationCrashReporterSettings.optInt("timeout", 5000);
        this.f15994g = applicationCrashReporterSettings.optBoolean(y3.f16251g, false);
    }

    public final int a() {
        return this.f15993f;
    }

    @Nullable
    public final HashSet<String> b() {
        return this.f15989b;
    }

    @NotNull
    public final String c() {
        return this.f15991d;
    }

    @NotNull
    public final String d() {
        return this.f15990c;
    }

    public final boolean e() {
        return this.f15992e;
    }

    public final boolean f() {
        return this.f15988a;
    }

    public final boolean g() {
        return this.f15994g;
    }
}
