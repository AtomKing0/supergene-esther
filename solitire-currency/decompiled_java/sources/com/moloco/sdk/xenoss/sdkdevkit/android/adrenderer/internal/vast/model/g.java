package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f20620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f20621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Integer f20622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f20623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f20624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final h f20625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final e f20626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<w> f20627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final List<a0> f20628i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable String str3, @Nullable h hVar, @Nullable e eVar, @NotNull List<w> creativeViewTrackingList, @NotNull List<? extends a0> resources) {
        kotlin.jvm.internal.t.i(creativeViewTrackingList, "creativeViewTrackingList");
        kotlin.jvm.internal.t.i(resources, "resources");
        this.f20620a = str;
        this.f20621b = num;
        this.f20622c = num2;
        this.f20623d = str2;
        this.f20624e = str3;
        this.f20625f = hVar;
        this.f20626g = eVar;
        this.f20627h = creativeViewTrackingList;
        this.f20628i = resources;
    }

    @Nullable
    public final String a() {
        return this.f20624e;
    }

    @Nullable
    public final h b() {
        return this.f20625f;
    }

    @NotNull
    public final List<w> c() {
        return this.f20627h;
    }

    @Nullable
    public final Integer d() {
        return this.f20622c;
    }

    @NotNull
    public final List<a0> e() {
        return this.f20628i;
    }

    @Nullable
    public final Integer f() {
        return this.f20621b;
    }
}
