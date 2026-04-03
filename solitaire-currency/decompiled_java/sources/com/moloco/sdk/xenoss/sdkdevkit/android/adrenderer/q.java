package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Boolean f21629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f21633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f21634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final h9.p<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> f21635h;

    public q() {
        this(false, null, 0, 0, 0, false, false, null, 255, null);
    }

    public final boolean a() {
        return this.f21634g;
    }

    public final boolean b() {
        return this.f21633f;
    }

    public final int c() {
        return this.f21631d;
    }

    public final int d() {
        return this.f21632e;
    }

    @Nullable
    public final Boolean e() {
        return this.f21629b;
    }

    public final int f() {
        return this.f21630c;
    }

    public final boolean g() {
        return this.f21628a;
    }

    @NotNull
    public final h9.p<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> h() {
        return this.f21635h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(boolean z10, @Nullable Boolean bool, int i10, int i11, int i12, boolean z11, boolean z12, @NotNull h9.p<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> VastRenderer) {
        kotlin.jvm.internal.t.i(VastRenderer, "VastRenderer");
        this.f21628a = z10;
        this.f21629b = bool;
        this.f21630c = i10;
        this.f21631d = i11;
        this.f21632e = i12;
        this.f21633f = z11;
        this.f21634g = z12;
        this.f21635h = VastRenderer;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ q(boolean z10, Boolean bool, int i10, int i11, int i12, boolean z11, boolean z12, h9.p pVar, int i13, kotlin.jvm.internal.k kVar) {
        h9.p pVarB;
        boolean z13 = (i13 & 1) != 0 ? true : z10;
        Boolean bool2 = (i13 & 2) != 0 ? null : bool;
        int i14 = (i13 & 4) != 0 ? 5 : i10;
        int i15 = (i13 & 8) != 0 ? 5 : i11;
        int i16 = (i13 & 16) == 0 ? i12 : 5;
        boolean z14 = (i13 & 32) != 0 ? false : z11;
        boolean z15 = (i13 & 64) == 0 ? z12 : false;
        if ((i13 & 128) != 0) {
            pVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.b((1023 & 1) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : 0L, (1023 & 2) != 0 ? k.i.f21111g : null, (1023 & 4) != 0 ? k.j.f21112g : null, (1023 & 8) != 0 ? k.C0456k.f21113g : null, (1023 & 16) != 0 ? k.l.f21114g : null, (1023 & 32) != 0 ? null : null, (1023 & 64) != 0 ? k.m.f21115g : null, (1023 & 128) != 0 ? k.n.f21116g : null, (1023 & 256) != 0 ? k.o.f21117g : null, (1023 & 512) != 0 ? a.h.f18920a.h() : null);
        } else {
            pVarB = pVar;
        }
        this(z13, bool2, i14, i15, i16, z14, z15, pVarB);
    }
}
