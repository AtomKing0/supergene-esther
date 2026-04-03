package com.unity3d.ads.core.data.model.exception;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LoadException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LoadException extends Exception {
    private final int errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadException(int i10, @NotNull String message) {
        super(message);
        t.i(message, "message");
        this.errorCode = i10;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
