package com.unity3d.services.store.core;

import com.unity3d.services.store.StoreEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StoreExceptionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface StoreExceptionHandler {
    void handleStoreException(@NotNull StoreEvent storeEvent, int i10, @NotNull Exception exc);
}
