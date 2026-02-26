package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final d f21708b;

    public b(@NotNull d delegate) {
        t.i(delegate, "delegate");
        this.f21708b = delegate;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(@NotNull String url) {
        t.i(url, "url");
        this.f21708b.a(url);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(@NotNull String url, @NotNull byte[] body, @NotNull e8.c contentType) {
        t.i(url, "url");
        t.i(body, "body");
        t.i(contentType, "contentType");
        this.f21708b.a(url, body, contentType);
    }
}
