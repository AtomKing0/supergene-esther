package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class tn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Boolean f15408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Integer f15409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final g8 f15410c;

    public tn(@NotNull JSONObject features) {
        kotlin.jvm.internal.t.i(features, "features");
        this.f15408a = features.has("enabled") ? Boolean.valueOf(features.getBoolean("enabled")) : null;
        this.f15409b = features.has("numOfSeconds") ? Integer.valueOf(features.getInt("numOfSeconds")) : null;
        this.f15410c = g8.Second;
    }

    @Nullable
    public final Boolean a() {
        return this.f15408a;
    }

    @Nullable
    public final Integer b() {
        return this.f15409b;
    }

    @NotNull
    public final g8 c() {
        return this.f15410c;
    }
}
