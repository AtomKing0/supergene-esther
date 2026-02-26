package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.publisher.Banner;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    public /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.v<Context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, com.moloco.sdk.internal.a, com.moloco.sdk.internal.services.b0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f18278b = new a();

        public a() {
            super(8, t.class, "createXenossAggregatedBanner", "createXenossAggregatedBanner(Landroid/content/Context;Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService;Lcom/moloco/sdk/internal/ortb/model/Bid;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/ExternalLinkHandler;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/Watermark;Lcom/moloco/sdk/internal/ViewLifecycleOwner;Lcom/moloco/sdk/internal/services/ClickthroughService;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/ui/ButtonTracker;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/XenossBannerView;", 1);
        }

        @Override // h9.v
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> invoke(@NotNull Context p02, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a p12, @NotNull com.moloco.sdk.internal.ortb.model.c p22, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z p32, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r p42, @NotNull com.moloco.sdk.internal.a p52, @NotNull com.moloco.sdk.internal.services.b0 p62, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i p72) {
            kotlin.jvm.internal.t.i(p02, "p0");
            kotlin.jvm.internal.t.i(p12, "p1");
            kotlin.jvm.internal.t.i(p22, "p2");
            kotlin.jvm.internal.t.i(p32, "p3");
            kotlin.jvm.internal.t.i(p42, "p4");
            kotlin.jvm.internal.t.i(p52, "p5");
            kotlin.jvm.internal.t.i(p62, "p6");
            kotlin.jvm.internal.t.i(p72, "p7");
            return t.f(p02, p12, p22, p32, p42, p52, p62, p72);
        }
    }

    public /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p, c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f18279b = new b();

        public b() {
            super(1, t.class, "createXenossAggregatedAdShowListener", "createXenossAggregatedAdShowListener(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/VastAdShowListener;)Lcom/moloco/sdk/internal/publisher/BannerKt$createXenossAggregatedAdShowListener$1;", 1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p p02) {
            kotlin.jvm.internal.t.i(p02, "p0");
            return t.e(p02);
        }
    }

    public static final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p f18280a;

        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p pVar) {
            this.f18280a = pVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c
        public void a() {
            this.f18280a.a();
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c
        public void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            kotlin.jvm.internal.t.i(internalShowError, "internalShowError");
            this.f18280a.a(internalShowError);
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p
        public void a(boolean z10) {
            this.f18280a.a(z10);
        }
    }

    @NotNull
    public static final Banner b(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull String adUnitId, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager, @NotNull com.moloco.sdk.internal.a viewLifecycleOwnerSingleton, @NotNull com.moloco.sdk.internal.i bannerSize, @NotNull com.moloco.sdk.internal.services.b0 clickthroughService) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        kotlin.jvm.internal.t.i(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        kotlin.jvm.internal.t.i(bannerSize, "bannerSize");
        kotlin.jvm.internal.t.i(clickthroughService, "clickthroughService");
        return new v(context, appLifecycleTrackerService, customUserEventBuilderService, adUnitId, z10, externalLinkHandler, a.f18278b, b.f18279b, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, clickthroughService);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f c(com.moloco.sdk.internal.ortb.model.o oVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVarD;
        return (oVar == null || (fVarD = com.moloco.sdk.internal.e.d(oVar)) == null) ? com.moloco.sdk.internal.e.c() : fVarD;
    }

    public static final c e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p pVar) {
        return new c(pVar);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> f(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.internal.ortb.model.c cVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z zVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, com.moloco.sdk.internal.a aVar2, com.moloco.sdk.internal.services.b0 b0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i iVar) {
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d(context, aVar, null, cVar, c(cVar.d().d()), zVar, rVar, aVar2, p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain().plus(y2.b(null, 1, null))), b0Var, iVar);
    }
}
