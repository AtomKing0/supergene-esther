package com.unity3d.ironsourceads.interstitial;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.ph;
import com.ironsource.qh;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class InterstitialAd implements qh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ph f23854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private InterstitialAdListener f23855b;

    public InterstitialAd(@NotNull ph interstitialAdInternal) {
        t.i(interstitialAdInternal, "interstitialAdInternal");
        this.f23854a = interstitialAdInternal;
        interstitialAdInternal.a(this);
    }

    @NotNull
    public final InterstitialAdInfo getAdInfo() {
        return this.f23854a.b();
    }

    @Nullable
    public final InterstitialAdListener getListener() {
        return this.f23855b;
    }

    public final boolean isReadyToShow() {
        return this.f23854a.d();
    }

    @Override // com.ironsource.qh
    public void onAdInstanceDidBecomeVisible() {
        InterstitialAdListener interstitialAdListener = this.f23855b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdShown(this);
        }
    }

    @Override // com.ironsource.qh
    public void onAdInstanceDidClick() {
        InterstitialAdListener interstitialAdListener = this.f23855b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdClicked(this);
        }
    }

    @Override // com.ironsource.qh
    public void onAdInstanceDidDismiss() {
        InterstitialAdListener interstitialAdListener = this.f23855b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdDismissed(this);
        }
    }

    @Override // com.ironsource.qh
    public void onAdInstanceDidFailedToShow(@NotNull IronSourceError error) {
        t.i(error, "error");
        InterstitialAdListener interstitialAdListener = this.f23855b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdFailedToShow(this, error);
        }
    }

    @Override // com.ironsource.qh
    public void onAdInstanceDidShow() {
        InterstitialAdListener interstitialAdListener = this.f23855b;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdShown(this);
        }
    }

    public final void setListener(@Nullable InterstitialAdListener interstitialAdListener) {
        this.f23855b = interstitialAdListener;
    }

    public final void show(@NotNull Activity activity) {
        t.i(activity, "activity");
        this.f23854a.a(activity);
    }

    @Override // com.ironsource.qh
    public void onAdInstanceDidReward(@Nullable String str, int i10) {
    }
}
