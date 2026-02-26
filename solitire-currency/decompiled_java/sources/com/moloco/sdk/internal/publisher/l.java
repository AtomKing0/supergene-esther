package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements RewardedInterstitialAd, a0, FullscreenAd<RewardedInterstitialAdShowListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final d0<RewardedInterstitialAdShowListener> f18042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18043b;

    public static final class a extends kotlin.jvm.internal.v implements h9.l<Boolean, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ RewardedInterstitialAdShowListener f18044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ l f18045h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, l lVar) {
            super(1);
            this.f18044g = rewardedInterstitialAdShowListener;
            this.f18045h = lVar;
        }

        public final void a(boolean z10) {
            this.f18044g.onRewardedVideoCompleted(MolocoAdKt.createAdInfo$default(this.f18045h.f18043b, null, 2, null));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Boolean bool) {
            a(bool.booleanValue());
            return k0.f35197a;
        }
    }

    public static final class b extends kotlin.jvm.internal.v implements h9.a<Boolean> {
        public b() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return l.this.f18042a.t();
        }
    }

    public static final class c extends kotlin.jvm.internal.v implements h9.a<com.moloco.sdk.internal.ortb.model.q> {
        public c() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.internal.ortb.model.q invoke() {
            return l.this.f18042a.o();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(@NotNull d0<? super RewardedInterstitialAdShowListener> fullscreenAd, @NotNull String adUnitId) {
        kotlin.jvm.internal.t.i(fullscreenAd, "fullscreenAd");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        this.f18042a = fullscreenAd;
        this.f18043b = adUnitId;
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void show(@Nullable RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener) {
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListenerD = m.d(m.c(rewardedInterstitialAdShowListener, new c()), this.f18042a.n() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.VAST, new b());
        this.f18042a.l(new a(rewardedInterstitialAdShowListenerD, this));
        this.f18042a.show(rewardedInterstitialAdShowListenerD);
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        this.f18042a.destroy();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f18042a.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(@NotNull String bidResponseJson, @Nullable AdLoad.Listener listener) {
        kotlin.jvm.internal.t.i(bidResponseJson, "bidResponseJson");
        this.f18042a.load(bidResponseJson, listener);
    }

    @Override // com.moloco.sdk.internal.publisher.a0
    public void setCreateAdObjectStartTime(long j10) {
        this.f18042a.setCreateAdObjectStartTime(j10);
    }
}
