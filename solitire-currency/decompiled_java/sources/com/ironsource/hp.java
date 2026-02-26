package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface hp {
    void a(@Nullable IronSourceError ironSourceError);

    void a(@Nullable IronSourceError ironSourceError, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void a(@NotNull Placement placement, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void a(boolean z10, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void b(@NotNull Placement placement, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void d(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void f(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void h(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void i(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onRewardedVideoAdEnded();

    void onRewardedVideoAdStarted();
}
