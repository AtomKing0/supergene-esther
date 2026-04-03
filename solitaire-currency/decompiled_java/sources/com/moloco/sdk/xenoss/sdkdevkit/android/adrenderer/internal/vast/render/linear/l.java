package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f21428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21429b;

    public l(@NotNull String url, int i10) {
        t.i(url, "url");
        this.f21428a = url;
        this.f21429b = i10;
    }

    public final int a() {
        return this.f21429b;
    }

    @NotNull
    public final String b() {
        return this.f21428a;
    }
}
