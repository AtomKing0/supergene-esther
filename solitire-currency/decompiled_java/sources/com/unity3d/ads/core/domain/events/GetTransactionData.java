package com.unity3d.ads.core.domain.events;

import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetTransactionData.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface GetTransactionData {
    @NotNull
    TransactionEventRequestOuterClass.TransactionData invoke(@NotNull PurchaseBridge purchaseBridge, @NotNull SkuDetailsBridge skuDetailsBridge);
}
