package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface mk {
    void a(@NotNull kk kkVar);

    void a(@NotNull kk kkVar, @NotNull IronSourceError ironSourceError);

    void a(@NotNull kk kkVar, @NotNull IronSourceError ironSourceError, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void a(@NotNull kk kkVar, @NotNull Placement placement, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void a(@NotNull kk kkVar, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void a(@NotNull kk kkVar, boolean z10, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void b(@NotNull kk kkVar);

    void b(@NotNull kk kkVar, @NotNull Placement placement, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void b(@NotNull kk kkVar, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void c(@NotNull kk kkVar, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void d(@NotNull kk kkVar, @NotNull LevelPlayAdInfo levelPlayAdInfo);
}
