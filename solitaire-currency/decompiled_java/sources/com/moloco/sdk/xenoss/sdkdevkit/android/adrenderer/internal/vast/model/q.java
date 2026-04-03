package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final f f20656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f20657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f20658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f20659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final u f20660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final List<p> f20661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final List<String> f20662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<i> f20663h;

    public q(@Nullable f fVar, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable u uVar, @NotNull List<p> impressions, @NotNull List<String> errorUrls, @NotNull List<i> creatives) {
        kotlin.jvm.internal.t.i(impressions, "impressions");
        kotlin.jvm.internal.t.i(errorUrls, "errorUrls");
        kotlin.jvm.internal.t.i(creatives, "creatives");
        this.f20656a = fVar;
        this.f20657b = str;
        this.f20658c = str2;
        this.f20659d = str3;
        this.f20660e = uVar;
        this.f20661f = impressions;
        this.f20662g = errorUrls;
        this.f20663h = creatives;
    }

    @NotNull
    public final List<i> a() {
        return this.f20663h;
    }

    @NotNull
    public final List<String> b() {
        return this.f20662g;
    }

    @NotNull
    public final List<p> c() {
        return this.f20661f;
    }
}
