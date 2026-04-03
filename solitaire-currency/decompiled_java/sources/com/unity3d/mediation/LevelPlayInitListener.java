package com.unity3d.mediation;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface LevelPlayInitListener {
    void onInitFailed(@NotNull LevelPlayInitError levelPlayInitError);

    void onInitSuccess(@NotNull LevelPlayConfiguration levelPlayConfiguration);
}
