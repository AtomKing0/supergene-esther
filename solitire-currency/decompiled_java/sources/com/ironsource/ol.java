package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface ol {
    void b(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void j(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onNativeAdLoadFailed(@Nullable IronSourceError ironSourceError);
}
