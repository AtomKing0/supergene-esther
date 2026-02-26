package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Intent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 {
    public static final void a(@NotNull Intent intent, int i10) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        intent.putExtra("CLOSE_DELAY_SECONDS", i10);
    }

    public static final void b(@NotNull Intent intent, @Nullable Boolean bool) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        if (bool != null) {
            bool.booleanValue();
            intent.putExtra("SKIP_ENABLED", bool.booleanValue());
        }
    }

    public static final void c(@NotNull Intent intent, boolean z10) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        intent.putExtra("AUTO_STORE_ON_COMPLETE", z10);
    }

    public static final boolean d(@NotNull Intent intent) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        return intent.getBooleanExtra("AUTO_STORE_ON_COMPLETE", false);
    }

    public static final void e(@NotNull Intent intent, int i10) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        intent.putExtra("DEC_DELAY_SECONDS", i10);
    }

    public static final void f(@NotNull Intent intent, boolean z10) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        intent.putExtra("AUTO_STORE_ON_SKIP", z10);
    }

    public static final boolean g(@NotNull Intent intent) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        return intent.getBooleanExtra("AUTO_STORE_ON_SKIP", false);
    }

    public static final int h(@NotNull Intent intent) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        return intent.getIntExtra("CLOSE_DELAY_SECONDS", 0);
    }

    public static final void i(@NotNull Intent intent, int i10) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        intent.putExtra("SKIP_DELAY_SECONDS", i10);
    }

    public static final void j(@NotNull Intent intent, boolean z10) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        intent.putExtra("START_MUTED", z10);
    }

    public static final int k(@NotNull Intent intent) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        return intent.getIntExtra("DEC_DELAY_SECONDS", 0);
    }

    @Nullable
    public static final Boolean l(@NotNull Intent intent) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        if (intent.hasExtra("SKIP_ENABLED")) {
            return Boolean.valueOf(intent.getBooleanExtra("SKIP_ENABLED", false));
        }
        return null;
    }

    public static final int m(@NotNull Intent intent) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        return intent.getIntExtra("SKIP_DELAY_SECONDS", 0);
    }

    public static final boolean n(@NotNull Intent intent) {
        kotlin.jvm.internal.t.i(intent, "<this>");
        return intent.getBooleanExtra("START_MUTED", true);
    }
}
