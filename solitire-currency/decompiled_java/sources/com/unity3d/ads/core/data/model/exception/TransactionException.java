package com.unity3d.ads.core.data.model.exception;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TransactionException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TransactionException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionException(@NotNull String message) {
        super(message);
        t.i(message, "message");
    }
}
