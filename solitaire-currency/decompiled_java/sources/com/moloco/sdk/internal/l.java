package com.moloco.sdk.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17655b;

    public l(@NotNull String description, int i10) {
        kotlin.jvm.internal.t.i(description, "description");
        this.f17654a = description;
        this.f17655b = i10;
    }

    @NotNull
    public final String a() {
        return this.f17654a;
    }

    public final int b() {
        return this.f17655b;
    }
}
