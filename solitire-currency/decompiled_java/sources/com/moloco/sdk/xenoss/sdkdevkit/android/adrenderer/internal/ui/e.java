package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static final int a(int i10, @NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return (int) (i10 * context.getResources().getDisplayMetrics().density);
    }
}
