package com.moloco.sdk.publisher;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface AdLoad {

    public interface Listener {
        void onAdLoadFailed(@NotNull MolocoAdError molocoAdError);

        void onAdLoadSuccess(@NotNull MolocoAd molocoAd);
    }

    boolean isLoaded();

    void load(@NotNull String str, @Nullable Listener listener);
}
