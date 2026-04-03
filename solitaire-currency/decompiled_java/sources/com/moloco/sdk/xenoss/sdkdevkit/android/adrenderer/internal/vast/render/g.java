package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f21297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final t f21298b;

    public g(@NotNull String url, @NotNull t offset) {
        kotlin.jvm.internal.t.i(url, "url");
        kotlin.jvm.internal.t.i(offset, "offset");
        this.f21297a = url;
        this.f21298b = offset;
    }

    @NotNull
    public final t a() {
        return this.f21298b;
    }

    @NotNull
    public final String b() {
        return this.f21297a;
    }
}
