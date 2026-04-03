package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class dp implements p0<RewardedAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final jt f11853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final RewardedAdLoaderListener f11854b;

    public dp(@NotNull jt threadManager, @NotNull RewardedAdLoaderListener publisherListener) {
        kotlin.jvm.internal.t.i(threadManager, "threadManager");
        kotlin.jvm.internal.t.i(publisherListener, "publisherListener");
        this.f11853a = threadManager;
        this.f11854b = publisherListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dp this$0, IronSourceError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        this$0.f11854b.onRewardedAdLoadFailed(error);
    }

    @Override // com.ironsource.p0
    public void onAdLoadFailed(@NotNull final IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        this.f11853a.a(new Runnable() { // from class: com.ironsource.bw
            @Override // java.lang.Runnable
            public final void run() {
                dp.a(this.f11477a, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dp this$0, RewardedAd adObject) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adObject, "$adObject");
        this$0.f11854b.onRewardedAdLoaded(adObject);
    }

    @Override // com.ironsource.p0
    public void a(@NotNull final RewardedAd adObject) {
        kotlin.jvm.internal.t.i(adObject, "adObject");
        this.f11853a.a(new Runnable() { // from class: com.ironsource.aw
            @Override // java.lang.Runnable
            public final void run() {
                dp.a(this.f11318a, adObject);
            }
        });
    }
}
