package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import r9.a;
import s9.c0;
import s9.e0;
import s9.j;
import s9.x;

/* JADX INFO: compiled from: AndroidTransactionEventRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidTransactionEventRepository implements TransactionEventRepository {

    @NotNull
    private final x<TransactionEventRequestOuterClass.TransactionEventRequest> _transactionEvents;

    @NotNull
    private final c0<TransactionEventRequestOuterClass.TransactionEventRequest> transactionEvents;

    public AndroidTransactionEventRepository() {
        x<TransactionEventRequestOuterClass.TransactionEventRequest> xVarA = e0.a(10, 10, a.DROP_OLDEST);
        this._transactionEvents = xVarA;
        this.transactionEvents = j.b(xVarA);
    }

    @Override // com.unity3d.ads.core.data.repository.TransactionEventRepository
    public void addTransactionEvent(@NotNull TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequest) {
        t.i(transactionEventRequest, "transactionEventRequest");
        this._transactionEvents.a(transactionEventRequest);
    }

    @Override // com.unity3d.ads.core.data.repository.TransactionEventRepository
    @NotNull
    public c0<TransactionEventRequestOuterClass.TransactionEventRequest> getTransactionEvents() {
        return this.transactionEvents;
    }
}
