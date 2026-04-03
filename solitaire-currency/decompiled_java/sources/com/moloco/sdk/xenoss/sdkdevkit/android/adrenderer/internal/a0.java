package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f19023a;

    public a0(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f19023a = context;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z
    public boolean a(@NotNull String uri) {
        kotlin.jvm.internal.t.i(uri, "uri");
        return b0.b(this.f19023a, uri);
    }
}
