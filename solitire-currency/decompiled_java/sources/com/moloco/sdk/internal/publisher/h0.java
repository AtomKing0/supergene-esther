package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.MolocoAd;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface h0 {
    void a(@NotNull com.moloco.sdk.internal.q qVar);

    void onAdClicked(@NotNull MolocoAd molocoAd);

    void onAdHidden(@NotNull MolocoAd molocoAd);

    void onAdShowSuccess(@NotNull MolocoAd molocoAd);
}
