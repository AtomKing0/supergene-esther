package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import org.jetbrains.annotations.NotNull;
import s9.c0;

/* JADX INFO: compiled from: TransactionEventRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TransactionEventRepository {
    void addTransactionEvent(@NotNull TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequest);

    @NotNull
    c0<TransactionEventRequestOuterClass.TransactionEventRequest> getTransactionEvents();
}
