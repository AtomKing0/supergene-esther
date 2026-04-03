package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.InterstitialAdShowListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements InterstitialAd, a0, FullscreenAd<InterstitialAdShowListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final d0<InterstitialAdShowListener> f18022a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull d0<? super InterstitialAdShowListener> fullscreenAd) {
        kotlin.jvm.internal.t.i(fullscreenAd, "fullscreenAd");
        this.f18022a = fullscreenAd;
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void show(@Nullable InterstitialAdShowListener interstitialAdShowListener) {
        this.f18022a.show(i.c(interstitialAdShowListener));
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        this.f18022a.destroy();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f18022a.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(@NotNull String bidResponseJson, @Nullable AdLoad.Listener listener) {
        kotlin.jvm.internal.t.i(bidResponseJson, "bidResponseJson");
        this.f18022a.load(bidResponseJson, listener);
    }

    @Override // com.moloco.sdk.internal.publisher.a0
    public void setCreateAdObjectStartTime(long j10) {
        this.f18022a.setCreateAdObjectStartTime(j10);
    }
}
