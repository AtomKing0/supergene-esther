package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class th implements p0<InterstitialAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final jt f15397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final InterstitialAdLoaderListener f15398b;

    public th(@NotNull jt threadManager, @NotNull InterstitialAdLoaderListener publisherListener) {
        kotlin.jvm.internal.t.i(threadManager, "threadManager");
        kotlin.jvm.internal.t.i(publisherListener, "publisherListener");
        this.f15397a = threadManager;
        this.f15398b = publisherListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(th this$0, IronSourceError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        this$0.f15398b.onInterstitialAdLoadFailed(error);
    }

    @Override // com.ironsource.p0
    public void onAdLoadFailed(@NotNull final IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        this.f15397a.a(new Runnable() { // from class: com.ironsource.o00
            @Override // java.lang.Runnable
            public final void run() {
                th.a(this.f14197a, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(th this$0, InterstitialAd adObject) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adObject, "$adObject");
        this$0.f15398b.onInterstitialAdLoaded(adObject);
    }

    @Override // com.ironsource.p0
    public void a(@NotNull final InterstitialAd adObject) {
        kotlin.jvm.internal.t.i(adObject, "adObject");
        this.f15397a.a(new Runnable() { // from class: com.ironsource.p00
            @Override // java.lang.Runnable
            public final void run() {
                th.a(this.f14289a, adObject);
            }
        });
    }
}
