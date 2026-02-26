package com.unity3d.services.core.extensions;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TaskExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AbortRetryException extends Exception {

    @NotNull
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbortRetryException(@NotNull String reason) {
        super(reason);
        t.i(reason, "reason");
        this.reason = reason;
    }
}
