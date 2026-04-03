package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f20654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f20655b;

    public p(@Nullable String str, @NotNull String impressionUrl) {
        kotlin.jvm.internal.t.i(impressionUrl, "impressionUrl");
        this.f20654a = str;
        this.f20655b = impressionUrl;
    }

    @NotNull
    public final String a() {
        return this.f20655b;
    }
}
