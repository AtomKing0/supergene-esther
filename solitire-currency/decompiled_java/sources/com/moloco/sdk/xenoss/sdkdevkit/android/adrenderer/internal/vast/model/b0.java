package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f20606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f20607b;

    public b0(@Nullable String str, @NotNull String url) {
        kotlin.jvm.internal.t.i(url, "url");
        this.f20606a = str;
        this.f20607b = url;
    }

    @NotNull
    public final String a() {
        return this.f20607b;
    }
}
