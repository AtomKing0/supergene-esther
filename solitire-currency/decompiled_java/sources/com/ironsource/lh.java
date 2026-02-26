package com.ironsource;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface lh {
    void a(@Nullable LevelPlayAdError levelPlayAdError);

    void a(@NotNull LevelPlayAdError levelPlayAdError, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void a(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void b(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void c(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void d(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdInfoChanged(@NotNull LevelPlayAdInfo levelPlayAdInfo);
}
