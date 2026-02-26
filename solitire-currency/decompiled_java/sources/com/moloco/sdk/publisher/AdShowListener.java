package com.moloco.sdk.publisher;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface AdShowListener {
    void onAdClicked(@NotNull MolocoAd molocoAd);

    void onAdHidden(@NotNull MolocoAd molocoAd);

    void onAdShowFailed(@NotNull MolocoAdError molocoAdError);

    void onAdShowSuccess(@NotNull MolocoAd molocoAd);
}
