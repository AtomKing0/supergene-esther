package com.moloco.sdk.internal;

import android.content.Context;
import com.moloco.sdk.internal.publisher.c0;
import com.moloco.sdk.internal.services.b0;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.moloco.sdk.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.i f17534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f17535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final b0 f17536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final v8.l f17537d;

    public /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f17538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f17539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ z f17540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f17541e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(x xVar, c cVar, z zVar, Context context) {
            super(1, t.a.class, "createVastController", "createNativeAd$createVastController(Lcom/moloco/sdk/internal/services/AudioService;Lcom/moloco/sdk/internal/AdFactoryImpl;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/ExternalLinkHandler;Landroid/content/Context;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/render/Ad;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/render/ad/AdController;", 0);
            this.f17538b = xVar;
            this.f17539c = cVar;
            this.f17540d = zVar;
            this.f17541e = context;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a p02) {
            kotlin.jvm.internal.t.i(p02, "p0");
            return c.j(this.f17538b, this.f17539c, this.f17540d, this.f17541e, p02);
        }
    }

    public static final class b extends kotlin.jvm.internal.v implements h9.a<Boolean> {
        public b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(c.this.f17534a.h());
        }
    }

    public c(@NotNull com.moloco.sdk.i initResponse, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull b0 clickthroughService) {
        kotlin.jvm.internal.t.i(initResponse, "initResponse");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(clickthroughService, "clickthroughService");
        this.f17534a = initResponse;
        this.f17535b = customUserEventBuilderService;
        this.f17536c = clickthroughService;
        this.f17537d = v8.n.a(new b());
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a j(x xVar, c cVar, z zVar, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar) {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b(aVar, zVar, context, cVar.f17535b, xVar.c(), Boolean.FALSE, 0, 0, 0, false, false);
    }

    @Override // com.moloco.sdk.internal.b
    @NotNull
    public InterstitialAd a(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t viewVisibilityTracker, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        return com.moloco.sdk.internal.publisher.i.a(context, appLifecycleTrackerService, this.f17535b, adUnitId, externalLinkHandler, persistentHttpRequest, (64 & 64) != 0 ? new c0(null, null, null, null, null, 31, null) : null, watermark, adCreateLoadTimeoutManager);
    }

    @Override // com.moloco.sdk.internal.b
    @NotNull
    public NativeAd b(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull x audioService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t viewVisibilityTracker, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, @NotNull com.moloco.sdk.internal.a viewLifecycleOwnerSingleton, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager, @NotNull com.moloco.sdk.internal.services.r timeProvider) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(audioService, "audioService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        kotlin.jvm.internal.t.i(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        kotlin.jvm.internal.t.i(timeProvider, "timeProvider");
        return new com.moloco.sdk.internal.publisher.nativead.b(adUnitId, new com.moloco.sdk.internal.publisher.nativead.c(context, adUnitId, new com.moloco.sdk.internal.publisher.x(com.moloco.sdk.internal.ortb.c.a(), com.moloco.sdk.internal.publisher.z.a()), new com.moloco.sdk.internal.publisher.nativead.parser.a(), adCreateLoadTimeoutManager, com.moloco.sdk.acm.a.f17293a, timeProvider), new com.moloco.sdk.internal.publisher.nativead.a(context, viewVisibilityTracker, viewLifecycleOwnerSingleton, watermark, new a(audioService, this, externalLinkHandler, context)), appLifecycleTrackerService, this.f17535b, externalLinkHandler, persistentHttpRequest, adCreateLoadTimeoutManager);
    }

    @Override // com.moloco.sdk.internal.b
    @NotNull
    public Banner c(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t viewVisibilityTracker, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager, @NotNull com.moloco.sdk.internal.a viewLifecycleOwnerSingleton, @NotNull i bannerSize) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        kotlin.jvm.internal.t.i(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        kotlin.jvm.internal.t.i(bannerSize, "bannerSize");
        return com.moloco.sdk.internal.publisher.t.b(context, appLifecycleTrackerService, this.f17535b, adUnitId, i(), externalLinkHandler, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, this.f17536c);
    }

    @Override // com.moloco.sdk.internal.b
    @NotNull
    public Banner d(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t viewVisibilityTracker, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager, @NotNull com.moloco.sdk.internal.a viewLifecycleOwnerSingleton, @NotNull i bannerSize) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        kotlin.jvm.internal.t.i(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        kotlin.jvm.internal.t.i(bannerSize, "bannerSize");
        return com.moloco.sdk.internal.publisher.t.b(context, appLifecycleTrackerService, this.f17535b, adUnitId, i(), externalLinkHandler, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, this.f17536c);
    }

    @Override // com.moloco.sdk.internal.b
    @NotNull
    public Banner e(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t viewVisibilityTracker, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager, @NotNull com.moloco.sdk.internal.a viewLifecycleOwnerSingleton, @NotNull i bannerSize) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        kotlin.jvm.internal.t.i(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        kotlin.jvm.internal.t.i(bannerSize, "bannerSize");
        return com.moloco.sdk.internal.publisher.t.b(context, appLifecycleTrackerService, this.f17535b, adUnitId, i(), externalLinkHandler, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, this.f17536c);
    }

    @Override // com.moloco.sdk.internal.b
    @NotNull
    public RewardedInterstitialAd f(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t viewVisibilityTracker, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        return com.moloco.sdk.internal.publisher.m.a(context, appLifecycleTrackerService, this.f17535b, adUnitId, externalLinkHandler, persistentHttpRequest, (64 & 64) != 0 ? new c0(null, null, null, null, null, 31, null) : null, watermark, adCreateLoadTimeoutManager);
    }

    public final boolean i() {
        return ((Boolean) this.f17537d.getValue()).booleanValue();
    }
}
