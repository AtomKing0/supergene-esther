package com.unity3d.services.store.core;

import com.unity3d.services.store.StoreEvent;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GatewayStoreExceptionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GatewayStoreExceptionHandler implements StoreExceptionHandler {
    @Override // com.unity3d.services.store.core.StoreExceptionHandler
    public void handleStoreException(@NotNull StoreEvent storeEvent, int i10, @NotNull Exception exception) throws Exception {
        t.i(storeEvent, "storeEvent");
        t.i(exception, "exception");
        throw exception;
    }
}
