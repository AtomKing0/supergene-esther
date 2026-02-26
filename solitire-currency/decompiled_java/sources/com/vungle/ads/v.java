package com.vungle.ads;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BaseAdListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface v {
    void onAdClicked(@NotNull u uVar);

    void onAdEnd(@NotNull u uVar);

    void onAdFailedToLoad(@NotNull u uVar, @NotNull b2 b2Var);

    void onAdFailedToPlay(@NotNull u uVar, @NotNull b2 b2Var);

    void onAdImpression(@NotNull u uVar);

    void onAdLeftApplication(@NotNull u uVar);

    void onAdLoaded(@NotNull u uVar);

    void onAdStart(@NotNull u uVar);
}
