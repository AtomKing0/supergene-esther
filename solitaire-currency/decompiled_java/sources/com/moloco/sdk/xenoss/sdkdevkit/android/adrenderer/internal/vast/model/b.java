package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f20603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f20604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final c f20605c;

    public b(@Nullable String str, @Nullable Integer num, @NotNull c child) {
        kotlin.jvm.internal.t.i(child, "child");
        this.f20603a = str;
        this.f20604b = num;
        this.f20605c = child;
    }

    @NotNull
    public final c a() {
        return this.f20605c;
    }

    @Nullable
    public final Integer b() {
        return this.f20604b;
    }
}
