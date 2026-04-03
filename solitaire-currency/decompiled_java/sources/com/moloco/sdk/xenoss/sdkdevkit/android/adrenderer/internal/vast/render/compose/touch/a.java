package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y9.a;
import y9.c;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements PressGestureScope, Density {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Density f21229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final y9.a f21232d;

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a$a, reason: collision with other inner class name */
    @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.PressGestureScopeImpl2", f = "Tap.kt", l = {123}, m = "awaitRelease")
    public static final class C0459a extends d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f21233j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f21235l;

        public C0459a(z8.d<? super C0459a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21233j = obj;
            this.f21235l |= Integer.MIN_VALUE;
            return a.this.awaitRelease(this);
        }
    }

    @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.PressGestureScopeImpl2", f = "Tap.kt", l = {130}, m = "tryAwaitRelease")
    public static final class b extends d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f21236j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f21237k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f21239m;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21237k = obj;
            this.f21239m |= Integer.MIN_VALUE;
            return a.this.tryAwaitRelease(this);
        }
    }

    public a(@NotNull Density density) {
        t.i(density, "density");
        this.f21229a = density;
        this.f21232d = c.a(false);
    }

    public final void a() {
        this.f21231c = true;
        a.C0755a.c(this.f21232d, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object awaitRelease(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a.C0459a
            if (r0 == 0) goto L13
            r0 = r5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a.C0459a) r0
            int r1 = r0.f21235l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21235l = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f21233j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f21235l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            v8.u.b(r5)
            r0.f21235l = r3
            java.lang.Object r5 = r4.tryAwaitRelease(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L48
            v8.k0 r5 = v8.k0.f35197a
            return r5
        L48:
            androidx.compose.foundation.gestures.GestureCancellationException r5 = new androidx.compose.foundation.gestures.GestureCancellationException
            java.lang.String r0 = "The press gesture was canceled."
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a.awaitRelease(z8.d):java.lang.Object");
    }

    public final void b() {
        this.f21230b = true;
        a.C0755a.c(this.f21232d, null, 1, null);
    }

    public final void c() {
        a.C0755a.b(this.f21232d, null, 1, null);
        this.f21230b = false;
        this.f21231c = false;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f21229a.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.f21229a.getFontScale();
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo289roundToPxR2X_6o(long j10) {
        return this.f21229a.mo289roundToPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo290roundToPx0680j_4(float f10) {
        return this.f21229a.mo290roundToPx0680j_4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo291toDpGaN1DYA(long j10) {
        return this.f21229a.mo291toDpGaN1DYA(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo292toDpu2uoSUM(float f10) {
        return this.f21229a.mo292toDpu2uoSUM(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo294toDpSizekrfVVM(long j10) {
        return this.f21229a.mo294toDpSizekrfVVM(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo295toPxR2X_6o(long j10) {
        return this.f21229a.mo295toPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo296toPx0680j_4(float f10) {
        return this.f21229a.mo296toPx0680j_4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        t.i(dpRect, "<this>");
        return this.f21229a.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo297toSizeXkaWNTQ(long j10) {
        return this.f21229a.mo297toSizeXkaWNTQ(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo298toSp0xMU5do(float f10) {
        return this.f21229a.mo298toSp0xMU5do(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo299toSpkPz2Gy4(float f10) {
        return this.f21229a.mo299toSpkPz2Gy4(f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object tryAwaitRelease(@org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a.b
            if (r0 == 0) goto L13
            r0 = r5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a$b r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a.b) r0
            int r1 = r0.f21239m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21239m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a$b r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f21237k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f21239m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f21236j
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a) r0
            v8.u.b(r5)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            v8.u.b(r5)
            boolean r5 = r4.f21230b
            if (r5 != 0) goto L4e
            boolean r5 = r4.f21231c
            if (r5 != 0) goto L4e
            y9.a r5 = r4.f21232d
            r0.f21236j = r4
            r0.f21239m = r3
            r2 = 0
            java.lang.Object r5 = y9.a.C0755a.a(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r0 = r4
        L4f:
            boolean r5 = r0.f21230b
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a.tryAwaitRelease(z8.d):java.lang.Object");
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo293toDpu2uoSUM(int i10) {
        return this.f21229a.mo293toDpu2uoSUM(i10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo300toSpkPz2Gy4(int i10) {
        return this.f21229a.mo300toSpkPz2Gy4(i10);
    }
}
