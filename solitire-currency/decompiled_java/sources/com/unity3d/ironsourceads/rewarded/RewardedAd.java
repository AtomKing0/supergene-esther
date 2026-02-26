package com.unity3d.ironsourceads.rewarded;

import android.app.Activity;
import com.ironsource.ap;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.zo;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RewardedAd implements ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final zo f23867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private RewardedAdListener f23868b;

    public RewardedAd(@NotNull zo rewardedAdInternal) {
        t.i(rewardedAdInternal, "rewardedAdInternal");
        this.f23867a = rewardedAdInternal;
        rewardedAdInternal.a(this);
    }

    @NotNull
    public final RewardedAdInfo getAdInfo() {
        return this.f23867a.b();
    }

    @Nullable
    public final RewardedAdListener getListener() {
        return this.f23868b;
    }

    public final boolean isReadyToShow() {
        return this.f23867a.d();
    }

    @Override // com.ironsource.ap
    public void onAdInstanceDidBecomeVisible() {
        RewardedAdListener rewardedAdListener = this.f23868b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdShown(this);
        }
    }

    @Override // com.ironsource.ap
    public void onRewardedAdClicked() {
        RewardedAdListener rewardedAdListener = this.f23868b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdClicked(this);
        }
    }

    @Override // com.ironsource.ap
    public void onRewardedAdDismissed() {
        RewardedAdListener rewardedAdListener = this.f23868b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdDismissed(this);
        }
    }

    @Override // com.ironsource.ap
    public void onRewardedAdFailedToShow(@NotNull IronSourceError error) {
        t.i(error, "error");
        RewardedAdListener rewardedAdListener = this.f23868b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdFailedToShow(this, error);
        }
    }

    @Override // com.ironsource.ap
    public void onRewardedAdShown() {
        RewardedAdListener rewardedAdListener = this.f23868b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdShown(this);
        }
    }

    @Override // com.ironsource.ap
    public void onUserEarnedReward() {
        RewardedAdListener rewardedAdListener = this.f23868b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onUserEarnedReward(this);
        }
    }

    public final void setListener(@Nullable RewardedAdListener rewardedAdListener) {
        this.f23868b = rewardedAdListener;
    }

    public final void show(@NotNull Activity activity) {
        t.i(activity, "activity");
        this.f23867a.a(activity);
    }
}
