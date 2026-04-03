package com.ironsource;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class na {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final na f14102a = new na();

    private na() {
    }

    public final int a(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return a(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public final int b(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return a(context, context.getResources().getDisplayMetrics().widthPixels);
    }

    private final int a(Context context, int i10) {
        return j9.c.c(i10 / context.getResources().getDisplayMetrics().density);
    }
}
