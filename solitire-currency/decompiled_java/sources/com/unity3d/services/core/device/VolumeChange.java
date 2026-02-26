package com.unity3d.services.core.device;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VolumeChange.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface VolumeChange {
    void clearAllListeners();

    void registerListener(@NotNull VolumeChangeListener volumeChangeListener);

    void startObserving();

    void stopObserving();

    void unregisterListener(@NotNull VolumeChangeListener volumeChangeListener);
}
