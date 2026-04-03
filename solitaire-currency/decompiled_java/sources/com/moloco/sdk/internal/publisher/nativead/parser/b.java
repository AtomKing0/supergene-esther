package com.moloco.sdk.internal.publisher.nativead.parser;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c f18204b;

    public b(int i10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c errorSubType) {
        t.i(errorSubType, "errorSubType");
        this.f18203a = i10;
        this.f18204b = errorSubType;
    }

    public final int a() {
        return this.f18203a;
    }

    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b() {
        return this.f18204b;
    }
}
