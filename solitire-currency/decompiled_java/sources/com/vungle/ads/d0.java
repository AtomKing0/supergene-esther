package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.d0;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseFullscreenAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d0 extends u implements i0 {

    /* JADX INFO: compiled from: BaseFullscreenAd.kt */
    public static final class a implements com.vungle.ads.internal.presenter.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdClick$lambda-3, reason: not valid java name */
        public static final void m4021onAdClick$lambda3(d0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdClicked(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdEnd$lambda-2, reason: not valid java name */
        public static final void m4022onAdEnd$lambda2(d0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdEnd(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdImpression$lambda-1, reason: not valid java name */
        public static final void m4023onAdImpression$lambda1(d0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdImpression(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdLeftApplication$lambda-5, reason: not valid java name */
        public static final void m4024onAdLeftApplication$lambda5(d0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdLeftApplication(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdRewarded$lambda-4, reason: not valid java name */
        public static final void m4025onAdRewarded$lambda4(d0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            s1 s1Var = adListener instanceof s1 ? (s1) adListener : null;
            if (s1Var != null) {
                s1Var.onAdRewarded(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdStart$lambda-0, reason: not valid java name */
        public static final void m4026onAdStart$lambda0(d0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdStart(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onFailure$lambda-6, reason: not valid java name */
        public static final void m4027onFailure$lambda6(d0 this$0, b2 error) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(error, "$error");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdFailedToPlay(this$0, error);
            }
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdClick(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final d0 d0Var = d0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.y
                @Override // java.lang.Runnable
                public final void run() {
                    d0.a.m4021onAdClick$lambda3(d0Var);
                }
            });
            d0.this.getDisplayToClickMetric$vungle_ads_release().markEnd();
            o.INSTANCE.logMetric$vungle_ads_release(d0.this.getDisplayToClickMetric$vungle_ads_release(), (16 & 2) != 0 ? null : d0.this.getPlacementId(), (16 & 4) != 0 ? null : d0.this.getCreativeId(), (16 & 8) != 0 ? null : d0.this.getEventId(), (16 & 16) != 0 ? null : null);
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdEnd(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final d0 d0Var = d0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.z
                @Override // java.lang.Runnable
                public final void run() {
                    d0.a.m4022onAdEnd$lambda2(d0Var);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdImpression(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final d0 d0Var = d0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.x
                @Override // java.lang.Runnable
                public final void run() {
                    d0.a.m4023onAdImpression$lambda1(d0Var);
                }
            });
            d0.this.getPresentToDisplayMetric$vungle_ads_release().markEnd();
            o.logMetric$vungle_ads_release$default(o.INSTANCE, d0.this.getPresentToDisplayMetric$vungle_ads_release(), d0.this.getPlacementId(), d0.this.getCreativeId(), d0.this.getEventId(), (String) null, 16, (Object) null);
            d0.this.getDisplayToClickMetric$vungle_ads_release().markStart();
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdLeftApplication(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final d0 d0Var = d0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.b0
                @Override // java.lang.Runnable
                public final void run() {
                    d0.a.m4024onAdLeftApplication$lambda5(d0Var);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdRewarded(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final d0 d0Var = d0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.w
                @Override // java.lang.Runnable
                public final void run() {
                    d0.a.m4025onAdRewarded$lambda4(d0Var);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdStart(@Nullable String str) {
            d0.this.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
            d0.this.getShowToPresentMetric$vungle_ads_release().markEnd();
            o.logMetric$vungle_ads_release$default(o.INSTANCE, d0.this.getShowToPresentMetric$vungle_ads_release(), d0.this.getPlacementId(), d0.this.getCreativeId(), d0.this.getEventId(), (String) null, 16, (Object) null);
            d0.this.getPresentToDisplayMetric$vungle_ads_release().markStart();
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final d0 d0Var = d0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.a0
                @Override // java.lang.Runnable
                public final void run() {
                    d0.a.m4026onAdStart$lambda0(d0Var);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onFailure(@NotNull final b2 error) {
            kotlin.jvm.internal.t.i(error, "error");
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final d0 d0Var = d0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.c0
                @Override // java.lang.Runnable
                public final void run() {
                    d0.a.m4027onFailure$lambda6(d0Var, error);
                }
            });
            d0.this.getShowToFailMetric$vungle_ads_release().markEnd();
            o.logMetric$vungle_ads_release$default(o.INSTANCE, d0.this.getShowToFailMetric$vungle_ads_release(), d0.this.getPlacementId(), d0.this.getCreativeId(), d0.this.getEventId(), (String) null, 16, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(@NotNull Context context, @NotNull String placementId, @NotNull c adConfig) {
        super(context, placementId, adConfig);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(placementId, "placementId");
        kotlin.jvm.internal.t.i(adConfig, "adConfig");
    }

    @Override // com.vungle.ads.u, com.vungle.ads.a, com.vungle.ads.i0
    public void load(@Nullable String str) {
        setSignaledAd$vungle_ads_release(getSignalManager$vungle_ads_release().getSignaledAd(getPlacementId()));
        super.load(str);
    }

    @Override // com.vungle.ads.u
    public void onAdLoaded$vungle_ads_release(@NotNull com.vungle.ads.internal.model.b advertisement) {
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
        super.onAdLoaded$vungle_ads_release(advertisement);
        com.vungle.ads.internal.signals.c signaledAd$vungle_ads_release = getSignaledAd$vungle_ads_release();
        if (signaledAd$vungle_ads_release == null) {
            return;
        }
        signaledAd$vungle_ads_release.setAdAvailabilityCallbackTime(System.currentTimeMillis());
    }

    @Override // com.vungle.ads.i0
    public void play(@Nullable Context context) {
        o oVar = o.INSTANCE;
        oVar.logMetric$vungle_ads_release(new v1(Sdk$SDKMetric.b.PLAY_AD_API), (30 & 2) != 0 ? null : getPlacementId(), (30 & 4) != 0 ? null : getCreativeId(), (30 & 8) != 0 ? null : getEventId(), (30 & 16) != 0 ? null : null);
        getResponseToShowMetric$vungle_ads_release().markEnd();
        o.logMetric$vungle_ads_release$default(oVar, getResponseToShowMetric$vungle_ads_release(), getPlacementId(), getCreativeId(), getEventId(), (String) null, 16, (Object) null);
        getShowToPresentMetric$vungle_ads_release().markStart();
        getShowToFailMetric$vungle_ads_release().markStart();
        com.vungle.ads.internal.signals.c signaledAd$vungle_ads_release = getSignaledAd$vungle_ads_release();
        if (signaledAd$vungle_ads_release != null) {
            signaledAd$vungle_ads_release.setPlayAdTime(System.currentTimeMillis());
            signaledAd$vungle_ads_release.calculateTimeBetweenAdAvailabilityAndPlayAd();
            getSignalManager$vungle_ads_release().registerSignaledAd(context, signaledAd$vungle_ads_release);
        }
        getAdInternal$vungle_ads_release().play(context, new a());
    }
}
