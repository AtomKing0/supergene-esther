package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final a0 f21282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f21285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<String> f21286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final List<String> f21287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final Long f21288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final t f21289h;

    public e(@NotNull a0 resource, int i10, int i11, @Nullable String str, @NotNull List<String> clickTracking, @NotNull List<String> viewTracking, @Nullable Long l10, @Nullable t tVar) {
        kotlin.jvm.internal.t.i(resource, "resource");
        kotlin.jvm.internal.t.i(clickTracking, "clickTracking");
        kotlin.jvm.internal.t.i(viewTracking, "viewTracking");
        this.f21282a = resource;
        this.f21283b = i10;
        this.f21284c = i11;
        this.f21285d = str;
        this.f21286e = clickTracking;
        this.f21287f = viewTracking;
        this.f21288g = l10;
        this.f21289h = tVar;
    }

    @Nullable
    public final String a() {
        return this.f21285d;
    }

    @NotNull
    public final List<String> b() {
        return this.f21286e;
    }

    @Nullable
    public final Long c() {
        return this.f21288g;
    }

    public final int d() {
        return this.f21284c;
    }

    @Nullable
    public final t e() {
        return this.f21289h;
    }

    @NotNull
    public final a0 f() {
        return this.f21282a;
    }

    @NotNull
    public final List<String> g() {
        return this.f21287f;
    }

    public final int h() {
        return this.f21283b;
    }
}
