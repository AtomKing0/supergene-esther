package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f20687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final k f20688b;

    public v(@NotNull String resource, @NotNull k creativeType) {
        kotlin.jvm.internal.t.i(resource, "resource");
        kotlin.jvm.internal.t.i(creativeType, "creativeType");
        this.f20687a = resource;
        this.f20688b = creativeType;
    }

    @NotNull
    public final k a() {
        return this.f20688b;
    }

    @NotNull
    public final String b() {
        return this.f20687a;
    }
}
