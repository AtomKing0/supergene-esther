package com.unity3d.ads.core.domain.events;

import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: GetTransactionRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface GetTransactionRequest {
    @Nullable
    Object invoke(@NotNull List<TransactionEventRequestOuterClass.TransactionData> list, @NotNull d<? super TransactionEventRequestOuterClass.TransactionEventRequest> dVar);
}
