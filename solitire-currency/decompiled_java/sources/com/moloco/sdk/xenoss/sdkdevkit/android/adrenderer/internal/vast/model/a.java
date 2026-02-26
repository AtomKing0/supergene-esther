package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final b0 f20597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<b0> f20598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<b0> f20599c;

    public a(@Nullable b0 b0Var, @NotNull List<b0> clickTrackingList, @NotNull List<b0> customClickList) {
        kotlin.jvm.internal.t.i(clickTrackingList, "clickTrackingList");
        kotlin.jvm.internal.t.i(customClickList, "customClickList");
        this.f20597a = b0Var;
        this.f20598b = clickTrackingList;
        this.f20599c = customClickList;
    }

    @Nullable
    public final b0 a() {
        return this.f20597a;
    }

    @NotNull
    public final List<b0> b() {
        return this.f20598b;
    }

    @NotNull
    public final List<b0> c() {
        return this.f20599c;
    }
}
