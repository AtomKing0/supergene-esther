package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class c0 {

    public /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.l<z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {
        public a(Object obj) {
            super(1, obj, b.class, "loadAndReadyMraid", "loadAndReadyMraid(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
            return ((b) this.receiver).c0(dVar);
        }
    }

    public static final class b extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ s9.y<Boolean> f19052m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, z zVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVar, s9.y<Boolean> yVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.q qVar) {
            super(context, str, qVar, null, null, zVar, false, fVar, 88, null);
            this.f19052m = yVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
        public void k0() {
            super.k0();
            this.f19052m.setValue(Boolean.FALSE);
        }
    }

    public /* synthetic */ class c extends kotlin.jvm.internal.q implements h9.a<v8.k0> {
        public c(Object obj) {
            super(0, obj, b.class, "closeFullscreenAdRepresentation", "closeFullscreenAdRepresentation()V", 0);
        }

        public final void c() {
            ((b) this.receiver).k0();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            c();
            return v8.k0.f35197a;
        }
    }

    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q> a(@NotNull Context context, @NotNull com.moloco.sdk.internal.ortb.model.c bid, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(bid, "bid");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        return r.b(context, bid, a.g.f18914a.b().d(), watermark, null, null, 48, null);
    }

    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> b(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull String adm, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        return e.a(context, customUserEventBuilderService, adm, externalLinkHandler, watermark);
    }

    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> c(@NotNull Context context, @NotNull o0 scope, @NotNull com.moloco.sdk.internal.ortb.model.c bid, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull s9.y<Boolean> isAdDisplaying, boolean z10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(bid, "bid");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(isAdDisplaying, "isAdDisplaying");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.h.a(context, scope, z10);
        b bVar = new b(context, externalLinkHandler, fVarA, isAdDisplaying, bid.a(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.q.Interstitial);
        return h0.a(context, watermark, new e0(scope, bid, a.C0337a.f18870a.a(), new a(bVar)), bVar, new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k(true, new c(bVar), scope, v8.c0.c(n9.o.e(0, 0)), fVarA.c(), fVarA.w(), null), MraidActivity.f19487f);
    }
}
