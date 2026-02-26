package com.unity3d.services.store.gpbl.listeners;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseHistoryRecordBridge;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PurchaseHistoryResponseListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface PurchaseHistoryResponseListener {
    void onPurchaseHistoryUpdated(@NotNull BillingResultBridge billingResultBridge, @Nullable List<? extends PurchaseHistoryRecordBridge> list);
}
