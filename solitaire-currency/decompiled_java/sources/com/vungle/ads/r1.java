package com.vungle.ads;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RewardedAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class r1 extends j0 implements com.vungle.ads.internal.presenter.q {

    @Nullable
    private String alertBodyText;

    @Nullable
    private String alertCloseButtonText;

    @Nullable
    private String alertContinueButtonText;

    @Nullable
    private String alertTitleText;

    @Nullable
    private String userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
    }

    @Override // com.vungle.ads.internal.presenter.q
    @Nullable
    public String getAlertBodyText() {
        return this.alertBodyText;
    }

    @Nullable
    public final String getAlertBodyText$vungle_ads_release() {
        return this.alertBodyText;
    }

    @Override // com.vungle.ads.internal.presenter.q
    @Nullable
    public String getAlertCloseButtonText() {
        return this.alertCloseButtonText;
    }

    @Nullable
    public final String getAlertCloseButtonText$vungle_ads_release() {
        return this.alertCloseButtonText;
    }

    @Override // com.vungle.ads.internal.presenter.q
    @Nullable
    public String getAlertContinueButtonText() {
        return this.alertContinueButtonText;
    }

    @Nullable
    public final String getAlertContinueButtonText$vungle_ads_release() {
        return this.alertContinueButtonText;
    }

    @Override // com.vungle.ads.internal.presenter.q
    @Nullable
    public String getAlertTitleText() {
        return this.alertTitleText;
    }

    @Nullable
    public final String getAlertTitleText$vungle_ads_release() {
        return this.alertTitleText;
    }

    @Override // com.vungle.ads.internal.presenter.q
    @Nullable
    public String getUserId() {
        return this.userId;
    }

    @Nullable
    public final String getUserId$vungle_ads_release() {
        return this.userId;
    }

    @Override // com.vungle.ads.internal.a
    public boolean isValidAdTypeForPlacement(@NotNull com.vungle.ads.internal.model.j placement) {
        kotlin.jvm.internal.t.i(placement, "placement");
        return placement.isRewardedVideo();
    }

    @Override // com.vungle.ads.internal.a
    public void renderAd$vungle_ads_release(@Nullable com.vungle.ads.internal.presenter.b bVar, @NotNull com.vungle.ads.internal.model.b advertisement) {
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
        com.vungle.ads.internal.ui.a.Companion.setPresenterDelegate$vungle_ads_release(this);
        super.renderAd$vungle_ads_release(bVar, advertisement);
    }

    public final void setAlertBodyText$vungle_ads_release(@Nullable String str) {
        this.alertBodyText = str;
    }

    public final void setAlertCloseButtonText$vungle_ads_release(@Nullable String str) {
        this.alertCloseButtonText = str;
    }

    public final void setAlertContinueButtonText$vungle_ads_release(@Nullable String str) {
        this.alertContinueButtonText = str;
    }

    public final void setAlertTitleText$vungle_ads_release(@Nullable String str) {
        this.alertTitleText = str;
    }

    public final void setUserId$vungle_ads_release(@Nullable String str) {
        this.userId = str;
    }
}
