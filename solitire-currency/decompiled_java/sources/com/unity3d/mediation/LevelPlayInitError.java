package com.unity3d.mediation;

import com.ironsource.dq;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlayInitError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f23903b;

    public LevelPlayInitError(int i10, @NotNull String errorMessage) {
        t.i(errorMessage, "errorMessage");
        this.f23902a = i10;
        this.f23903b = errorMessage;
    }

    public final int getErrorCode() {
        return this.f23902a;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.f23903b;
    }

    @NotNull
    public String toString() {
        return "LevelPlayError(errorCode=" + this.f23902a + ", errorMessage='" + this.f23903b + "')";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayInitError(@NotNull dq sdkError) {
        this(sdkError.c(), sdkError.d());
        t.i(sdkError, "sdkError");
    }
}
