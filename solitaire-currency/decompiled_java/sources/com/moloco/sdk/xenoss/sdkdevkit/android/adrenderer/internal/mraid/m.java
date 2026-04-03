package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.webkit.WebView;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class m extends e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final h9.a<k0> f19579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public final h9.a<k0> f19580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i f19581o;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidInline", f = "MraidInline.kt", l = {41}, m = "load")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19582j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19583k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f19585m;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f19583k = obj;
            this.f19585m |= Integer.MIN_VALUE;
            return m.this.m0(this);
        }
    }

    public /* synthetic */ m(Context context, String str, h9.a aVar, h9.a aVar2, h9.a aVar3, h9.l lVar, boolean z10, z zVar, f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i iVar, int i10, kotlin.jvm.internal.k kVar) {
        this(context, str, aVar, aVar2, aVar3, lVar, z10, zVar, fVar, (i10 & 512) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.k.a() : iVar);
    }

    @NotNull
    public final WebView c() {
        return l0().c();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void g(@NotNull a.AbstractC0481a.c button) {
        kotlin.jvm.internal.t.i(button, "button");
        this.f19581o.g(button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void j(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        kotlin.jvm.internal.t.i(buttonType, "buttonType");
        this.f19581o.j(buttonType);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
    public void k0() {
        super.k0();
        this.f19580n.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(@org.jetbrains.annotations.NotNull z8.d<? super android.webkit.WebView> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m.a
            if (r0 == 0) goto L13
            r0 = r5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m.a) r0
            int r1 = r0.f19585m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f19585m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f19583k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f19585m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f19582j
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m) r0
            v8.u.b(r5)
            goto L44
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            v8.u.b(r5)
            r0.f19582j = r4
            r0.f19585m = r3
            java.lang.Object r5 = r4.c0(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r0 = r4
        L44:
            boolean r5 = r5 instanceof com.moloco.sdk.internal.t.b
            if (r5 == 0) goto L51
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f r5 = r0.l0()
            android.webkit.WebView r5 = r5.c()
            goto L52
        L51:
            r5 = 0
        L52:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m.m0(z8.d):java.lang.Object");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
    public void t() {
        super.t();
        this.f19579m.invoke();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull Context context, @NotNull String adm, @NotNull h9.a<k0> onNeedToDetachAdViewBeforeExpand, @NotNull h9.a<k0> onExpandAdViewClosed, @NotNull h9.a<k0> onClick, @NotNull h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, k0> onError, boolean z10, @NotNull z externalLinkHandler, @NotNull f mraidBridge, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i buttonTracker) {
        super(context, adm, q.Inline, onClick, onError, externalLinkHandler, z10, mraidBridge);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(onNeedToDetachAdViewBeforeExpand, "onNeedToDetachAdViewBeforeExpand");
        kotlin.jvm.internal.t.i(onExpandAdViewClosed, "onExpandAdViewClosed");
        kotlin.jvm.internal.t.i(onClick, "onClick");
        kotlin.jvm.internal.t.i(onError, "onError");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(mraidBridge, "mraidBridge");
        kotlin.jvm.internal.t.i(buttonTracker, "buttonTracker");
        this.f19579m = onNeedToDetachAdViewBeforeExpand;
        this.f19580n = onExpandAdViewClosed;
        this.f19581o = buttonTracker;
    }
}
