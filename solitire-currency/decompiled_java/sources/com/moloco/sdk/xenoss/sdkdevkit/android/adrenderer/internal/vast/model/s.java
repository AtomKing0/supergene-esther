package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f20671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f20672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f20673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f20674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Integer f20675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Integer f20676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f20677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final Integer f20678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final Integer f20679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final Integer f20680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final Boolean f20681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f20682l;

    public s(@NotNull String mediaFileUrl, @Nullable String str, boolean z10, @NotNull String type, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Boolean bool, @Nullable String str3) {
        kotlin.jvm.internal.t.i(mediaFileUrl, "mediaFileUrl");
        kotlin.jvm.internal.t.i(type, "type");
        this.f20671a = mediaFileUrl;
        this.f20672b = str;
        this.f20673c = z10;
        this.f20674d = type;
        this.f20675e = num;
        this.f20676f = num2;
        this.f20677g = str2;
        this.f20678h = num3;
        this.f20679i = num4;
        this.f20680j = num5;
        this.f20681k = bool;
        this.f20682l = str3;
    }

    @Nullable
    public final String a() {
        return this.f20682l;
    }

    @Nullable
    public final Integer b() {
        return this.f20678h;
    }

    @Nullable
    public final Integer c() {
        return this.f20676f;
    }

    @Nullable
    public final Integer d() {
        return this.f20680j;
    }

    @NotNull
    public final String e() {
        return this.f20671a;
    }

    @Nullable
    public final Integer f() {
        return this.f20679i;
    }

    @NotNull
    public final String g() {
        return this.f20674d;
    }

    @Nullable
    public final Integer h() {
        return this.f20675e;
    }

    public final boolean i() {
        return this.f20673c;
    }
}
