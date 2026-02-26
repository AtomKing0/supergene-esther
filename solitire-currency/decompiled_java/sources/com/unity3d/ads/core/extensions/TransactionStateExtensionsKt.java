package com.unity3d.ads.core.extensions;

import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TransactionStateExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TransactionStateExtensionsKt {
    @NotNull
    public static final TransactionEventRequestOuterClass.TransactionState fromPurchaseState(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? TransactionEventRequestOuterClass.TransactionState.UNRECOGNIZED : TransactionEventRequestOuterClass.TransactionState.TRANSACTION_STATE_PENDING : TransactionEventRequestOuterClass.TransactionState.TRANSACTION_STATE_UNSPECIFIED : TransactionEventRequestOuterClass.TransactionState.TRANSACTION_STATE_PURCHASED;
    }
}
