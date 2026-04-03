package com.ironsource;

import io.sentry.protocol.MeasurementValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Boolean f11376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Integer f11377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final g8 f11378c;

    public b8(@NotNull JSONObject features) {
        kotlin.jvm.internal.t.i(features, "features");
        this.f11376a = features.has("enabled") ? Boolean.valueOf(features.getBoolean("enabled")) : null;
        this.f11377b = features.has("maxImpressions") ? Integer.valueOf(features.getInt("maxImpressions")) : null;
        this.f11378c = features.has(MeasurementValue.JsonKeys.UNIT) ? g8.f12223c.a(features.optString(MeasurementValue.JsonKeys.UNIT)) : null;
    }

    @Nullable
    public final Boolean a() {
        return this.f11376a;
    }

    @Nullable
    public final Integer b() {
        return this.f11377b;
    }

    @Nullable
    public final g8 c() {
        return this.f11378c;
    }
}
