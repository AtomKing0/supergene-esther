package com.moloco.sdk.publisher;

import com.moloco.sdk.publisher.AdShowListener;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface FullscreenAd<T extends AdShowListener> extends AdLoad, Destroyable {
    void show(@Nullable T t10);
}
