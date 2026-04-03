package com.vungle.ads;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RewardedAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q1 extends d0 {
    public /* synthetic */ q1(Context context, String str, c cVar, int i10, kotlin.jvm.internal.k kVar) {
        this(context, str, (i10 & 4) != 0 ? new c() : cVar);
    }

    private final r1 getRewardedAdInternal() {
        com.vungle.ads.internal.a adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        kotlin.jvm.internal.t.g(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.RewardedAdInternal");
        return (r1) adInternal$vungle_ads_release;
    }

    public final void setAlertBodyText(@NotNull String bodyText) {
        kotlin.jvm.internal.t.i(bodyText, "bodyText");
        getRewardedAdInternal().setAlertBodyText$vungle_ads_release(bodyText);
    }

    public final void setAlertCloseButtonText(@NotNull String closeButtonText) {
        kotlin.jvm.internal.t.i(closeButtonText, "closeButtonText");
        getRewardedAdInternal().setAlertCloseButtonText$vungle_ads_release(closeButtonText);
    }

    public final void setAlertContinueButtonText(@NotNull String continueButtonText) {
        kotlin.jvm.internal.t.i(continueButtonText, "continueButtonText");
        getRewardedAdInternal().setAlertContinueButtonText$vungle_ads_release(continueButtonText);
    }

    public final void setAlertTitleText(@NotNull String titleText) {
        kotlin.jvm.internal.t.i(titleText, "titleText");
        getRewardedAdInternal().setAlertTitleText$vungle_ads_release(titleText);
    }

    public final void setUserId(@NotNull String userId) {
        kotlin.jvm.internal.t.i(userId, "userId");
        getRewardedAdInternal().setUserId$vungle_ads_release(userId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(@NotNull Context context, @NotNull String placementId, @NotNull c adConfig) {
        super(context, placementId, adConfig);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(placementId, "placementId");
        kotlin.jvm.internal.t.i(adConfig, "adConfig");
    }

    @Override // com.vungle.ads.u
    @NotNull
    public r1 constructAdInternal$vungle_ads_release(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return new r1(context);
    }
}
