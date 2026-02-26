package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.b2;
import com.vungle.ads.internal.h;
import com.vungle.ads.z1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BannerAdImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends com.vungle.ads.u {

    @NotNull
    private final com.vungle.ads.internal.presenter.c adPlayCallback;

    @NotNull
    private final z1 adSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Context context, @NotNull String placementId, @NotNull z1 adSize, @NotNull com.vungle.ads.c adConfig) {
        super(context, placementId, adConfig);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(placementId, "placementId");
        kotlin.jvm.internal.t.i(adSize, "adSize");
        kotlin.jvm.internal.t.i(adConfig, "adConfig");
        this.adSize = adSize;
        com.vungle.ads.internal.a adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        kotlin.jvm.internal.t.g(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.BannerAdInternal");
        this.adPlayCallback = ((i) adInternal$vungle_ads_release).wrapCallback$vungle_ads_release(new a(placementId));
    }

    @NotNull
    public final com.vungle.ads.internal.presenter.c getAdPlayCallback$vungle_ads_release() {
        return this.adPlayCallback;
    }

    @NotNull
    public final z1 getAdViewSize() {
        com.vungle.ads.internal.a adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        kotlin.jvm.internal.t.g(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.BannerAdInternal");
        z1 updatedAdSize$vungle_ads_release = ((i) adInternal$vungle_ads_release).getUpdatedAdSize$vungle_ads_release();
        return updatedAdSize$vungle_ads_release == null ? this.adSize : updatedAdSize$vungle_ads_release;
    }

    @Override // com.vungle.ads.u
    @NotNull
    public i constructAdInternal$vungle_ads_release(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return new i(context, this.adSize);
    }

    /* JADX INFO: compiled from: BannerAdImpl.kt */
    public static final class a implements com.vungle.ads.internal.presenter.b {
        final /* synthetic */ String $placementId;

        a(String str) {
            this.$placementId = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdClick$lambda-3, reason: not valid java name */
        public static final void m4042onAdClick$lambda3(h this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            com.vungle.ads.v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdClicked(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdEnd$lambda-2, reason: not valid java name */
        public static final void m4043onAdEnd$lambda2(h this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            com.vungle.ads.v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdEnd(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdImpression$lambda-1, reason: not valid java name */
        public static final void m4044onAdImpression$lambda1(h this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            com.vungle.ads.v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdImpression(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdLeftApplication$lambda-4, reason: not valid java name */
        public static final void m4045onAdLeftApplication$lambda4(h this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            com.vungle.ads.v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdLeftApplication(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdStart$lambda-0, reason: not valid java name */
        public static final void m4046onAdStart$lambda0(h this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            com.vungle.ads.v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdStart(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onFailure$lambda-5, reason: not valid java name */
        public static final void m4047onFailure$lambda5(h this$0, b2 error) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(error, "$error");
            com.vungle.ads.v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdFailedToPlay(this$0, error);
            }
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdClick(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final h hVar = h.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.b
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.m4042onAdClick$lambda3(hVar);
                }
            });
            h.this.getDisplayToClickMetric$vungle_ads_release().markEnd();
            com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release(h.this.getDisplayToClickMetric$vungle_ads_release(), (16 & 2) != 0 ? null : this.$placementId, (16 & 4) != 0 ? null : h.this.getCreativeId(), (16 & 8) != 0 ? null : h.this.getEventId(), (16 & 16) != 0 ? null : null);
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdEnd(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final h hVar = h.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.d
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.m4043onAdEnd$lambda2(hVar);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdImpression(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final h hVar = h.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.c
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.m4044onAdImpression$lambda1(hVar);
                }
            });
            h.this.getPresentToDisplayMetric$vungle_ads_release().markEnd();
            com.vungle.ads.o.logMetric$vungle_ads_release$default(com.vungle.ads.o.INSTANCE, h.this.getPresentToDisplayMetric$vungle_ads_release(), this.$placementId, h.this.getCreativeId(), h.this.getEventId(), (String) null, 16, (Object) null);
            h.this.getDisplayToClickMetric$vungle_ads_release().markStart();
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdLeftApplication(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final h hVar = h.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.m4045onAdLeftApplication$lambda4(hVar);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdStart(@Nullable String str) {
            h.this.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
            h.this.getShowToPresentMetric$vungle_ads_release().markEnd();
            com.vungle.ads.o.logMetric$vungle_ads_release$default(com.vungle.ads.o.INSTANCE, h.this.getShowToPresentMetric$vungle_ads_release(), this.$placementId, h.this.getCreativeId(), h.this.getEventId(), (String) null, 16, (Object) null);
            h.this.getPresentToDisplayMetric$vungle_ads_release().markStart();
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final h hVar = h.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.m4046onAdStart$lambda0(hVar);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onFailure(@NotNull final b2 error) {
            kotlin.jvm.internal.t.i(error, "error");
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final h hVar = h.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.m4047onFailure$lambda5(hVar, error);
                }
            });
            h.this.getShowToFailMetric$vungle_ads_release().markEnd();
            com.vungle.ads.o.logMetric$vungle_ads_release$default(com.vungle.ads.o.INSTANCE, h.this.getShowToFailMetric$vungle_ads_release(), this.$placementId, h.this.getCreativeId(), h.this.getEventId(), (String) null, 16, (Object) null);
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdRewarded(@Nullable String str) {
        }
    }
}
