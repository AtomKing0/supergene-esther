package com.unity3d.services.store.gpbl.listeners;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PurchasesResponseListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface PurchasesResponseListener {
    void onPurchaseResponse(@NotNull BillingResultBridge billingResultBridge, @Nullable List<? extends PurchaseBridge> list);
}
