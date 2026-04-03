package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f20643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f20644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Integer f20645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f20646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final t f20647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Long f20648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final o f20649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<String> f20650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final a0 f20651i;

    public n(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable t tVar, @Nullable Long l10, @Nullable o oVar, @NotNull List<String> viewTrackingUrlList, @NotNull a0 resource) {
        kotlin.jvm.internal.t.i(viewTrackingUrlList, "viewTrackingUrlList");
        kotlin.jvm.internal.t.i(resource, "resource");
        this.f20643a = str;
        this.f20644b = num;
        this.f20645c = num2;
        this.f20646d = str2;
        this.f20647e = tVar;
        this.f20648f = l10;
        this.f20649g = oVar;
        this.f20650h = viewTrackingUrlList;
        this.f20651i = resource;
    }

    @Nullable
    public final String a() {
        return this.f20646d;
    }

    @Nullable
    public final o b() {
        return this.f20649g;
    }

    @Nullable
    public final Long c() {
        return this.f20648f;
    }

    @Nullable
    public final Integer d() {
        return this.f20645c;
    }

    @Nullable
    public final t e() {
        return this.f20647e;
    }

    @NotNull
    public final a0 f() {
        return this.f20651i;
    }

    @NotNull
    public final List<String> g() {
        return this.f20650h;
    }

    @Nullable
    public final Integer h() {
        return this.f20644b;
    }
}
