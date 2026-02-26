package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f20610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Boolean f20611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final f f20612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<p> f20613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<String> f20614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final List<i> f20615f;

    public d(@NotNull String vastAdTagUrl, @Nullable Boolean bool, @Nullable f fVar, @NotNull List<p> impressions, @NotNull List<String> errorUrls, @NotNull List<i> creatives) {
        kotlin.jvm.internal.t.i(vastAdTagUrl, "vastAdTagUrl");
        kotlin.jvm.internal.t.i(impressions, "impressions");
        kotlin.jvm.internal.t.i(errorUrls, "errorUrls");
        kotlin.jvm.internal.t.i(creatives, "creatives");
        this.f20610a = vastAdTagUrl;
        this.f20611b = bool;
        this.f20612c = fVar;
        this.f20613d = impressions;
        this.f20614e = errorUrls;
        this.f20615f = creatives;
    }

    @NotNull
    public final List<i> a() {
        return this.f20615f;
    }

    @NotNull
    public final List<String> b() {
        return this.f20614e;
    }

    @Nullable
    public final Boolean c() {
        return this.f20611b;
    }

    @NotNull
    public final List<p> d() {
        return this.f20613d;
    }

    @NotNull
    public final String e() {
        return this.f20610a;
    }
}
