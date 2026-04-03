package com.unity3d.ads.core.data.model.exception;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExposureException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExposureException extends Exception {

    @NotNull
    private final Object[] parameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposureException(@NotNull String message, @NotNull Object[] parameters) {
        super(message);
        t.i(message, "message");
        t.i(parameters, "parameters");
        this.parameters = parameters;
    }

    @NotNull
    public final Object[] getParameters() {
        return this.parameters;
    }
}
