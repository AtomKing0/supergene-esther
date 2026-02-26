package com.moloco.sdk.internal.publisher;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Float f18270b;

    public r(@NotNull String burl, @Nullable Float f10) {
        kotlin.jvm.internal.t.i(burl, "burl");
        this.f18269a = burl;
        this.f18270b = f10;
    }

    @NotNull
    public final String a() {
        return this.f18269a;
    }
}
