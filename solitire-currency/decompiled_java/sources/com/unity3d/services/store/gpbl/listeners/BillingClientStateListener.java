package com.unity3d.services.store.gpbl.listeners;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BillingClientStateListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface BillingClientStateListener {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(@NotNull BillingResultBridge billingResultBridge);
}
