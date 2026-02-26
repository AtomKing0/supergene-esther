package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.banner.BannerAdLoaderListener;
import com.unity3d.ironsourceads.banner.BannerAdView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class y6 implements p0<BannerAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final jt f16260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final BannerAdLoaderListener f16261b;

    public y6(@NotNull jt threadManager, @NotNull BannerAdLoaderListener publisherListener) {
        kotlin.jvm.internal.t.i(threadManager, "threadManager");
        kotlin.jvm.internal.t.i(publisherListener, "publisherListener");
        this.f16260a = threadManager;
        this.f16261b = publisherListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(y6 this$0, IronSourceError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        this$0.f16261b.onBannerAdLoadFailed(error);
    }

    @Override // com.ironsource.p0
    public void onAdLoadFailed(@NotNull final IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        this.f16260a.a(new Runnable() { // from class: com.ironsource.m10
            @Override // java.lang.Runnable
            public final void run() {
                y6.a(this.f13112a, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(y6 this$0, BannerAdView adObject) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adObject, "$adObject");
        this$0.f16261b.onBannerAdLoaded(adObject);
    }

    @Override // com.ironsource.p0
    public void a(@NotNull final BannerAdView adObject) {
        kotlin.jvm.internal.t.i(adObject, "adObject");
        this.f16260a.a(new Runnable() { // from class: com.ironsource.n10
            @Override // java.lang.Runnable
            public final void run() {
                y6.a(this.f14056a, adObject);
            }
        });
    }
}
