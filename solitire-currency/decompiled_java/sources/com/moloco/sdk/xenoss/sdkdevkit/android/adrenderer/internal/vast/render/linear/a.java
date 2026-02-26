package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f21351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f21352b;

    public a(@NotNull String url, long j10) {
        t.i(url, "url");
        this.f21351a = url;
        this.f21352b = j10;
    }

    public final long a() {
        return this.f21352b;
    }

    @NotNull
    public final String b() {
        return this.f21351a;
    }
}
