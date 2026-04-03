package com.vungle.ads;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FullscreenAdListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface k0 extends v {
    @Override // com.vungle.ads.v
    /* synthetic */ void onAdClicked(@NotNull u uVar);

    @Override // com.vungle.ads.v
    /* synthetic */ void onAdEnd(@NotNull u uVar);

    @Override // com.vungle.ads.v
    /* synthetic */ void onAdFailedToLoad(@NotNull u uVar, @NotNull b2 b2Var);

    @Override // com.vungle.ads.v
    /* synthetic */ void onAdFailedToPlay(@NotNull u uVar, @NotNull b2 b2Var);

    @Override // com.vungle.ads.v
    /* synthetic */ void onAdImpression(@NotNull u uVar);

    @Override // com.vungle.ads.v
    /* synthetic */ void onAdLeftApplication(@NotNull u uVar);

    @Override // com.vungle.ads.v
    /* synthetic */ void onAdLoaded(@NotNull u uVar);

    @Override // com.vungle.ads.v
    /* synthetic */ void onAdStart(@NotNull u uVar);
}
