package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f19505a = new a();

    public final float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public final float b(float f10, @NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return f10 / a(context);
    }

    public final int c(float f10, @NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return (int) (b(f10, context) + 0.5f);
    }
}
