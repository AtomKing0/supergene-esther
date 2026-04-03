package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class fq extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final IronSourceError f12168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12169b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fq(@NotNull IronSourceError error) {
        super(error.getErrorMessage());
        kotlin.jvm.internal.t.i(error, "error");
        this.f12168a = error;
        this.f12169b = error.getErrorCode();
    }

    @NotNull
    public final IronSourceError a() {
        return this.f12168a;
    }

    public final int b() {
        return this.f12169b;
    }
}
