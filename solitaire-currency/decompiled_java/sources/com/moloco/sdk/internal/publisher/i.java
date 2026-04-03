package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.InterstitialAdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    public static final class a extends kotlin.jvm.internal.v implements h9.l<com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f18023g = new a();

        public a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f invoke(@Nullable com.moloco.sdk.internal.ortb.model.o oVar) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVarJ;
            return (oVar == null || (fVarJ = com.moloco.sdk.internal.e.j(oVar)) == null) ? com.moloco.sdk.internal.e.i() : fVarJ;
        }
    }

    public static final class b implements InterstitialAdShowListener, AdShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdShowListener f18024a;

        public b(InterstitialAdShowListener interstitialAdShowListener) {
            this.f18024a = q.a(interstitialAdShowListener);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdClicked(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            this.f18024a.onAdClicked(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdHidden(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            this.f18024a.onAdHidden(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowFailed(@NotNull MolocoAdError molocoAdError) {
            kotlin.jvm.internal.t.i(molocoAdError, "molocoAdError");
            this.f18024a.onAdShowFailed(molocoAdError);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowSuccess(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            this.f18024a.onAdShowSuccess(molocoAd);
        }
    }

    @NotNull
    public static final InterstitialAd a(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, @NotNull c0<InterstitialAdShowListener> adDataHolder, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        kotlin.jvm.internal.t.i(adDataHolder, "adDataHolder");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        return new h(new d0(context, appLifecycleTrackerService, customUserEventBuilderService, adUnitId, persistentHttpRequest, externalLinkHandler, a.f18023g, adDataHolder, AdFormatType.INTERSTITIAL, watermark, adCreateLoadTimeoutManager));
    }

    @NotNull
    public static final InterstitialAdShowListener c(@Nullable InterstitialAdShowListener interstitialAdShowListener) {
        return new b(interstitialAdShowListener);
    }
}
