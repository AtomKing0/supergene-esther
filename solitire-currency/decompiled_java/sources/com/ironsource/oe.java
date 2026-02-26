package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface oe {

    public interface a {
        @NotNull
        Object a(@NotNull String str, @NotNull LevelPlay.AdFormat adFormat, @NotNull h8 h8Var, @NotNull ud udVar);

        void b(@NotNull String str, @NotNull LevelPlay.AdFormat adFormat);
    }

    @NotNull
    f8 a(@NotNull String str, @NotNull LevelPlay.AdFormat adFormat);
}
