package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;

/* JADX INFO: compiled from: EdgeToEdgeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d {
    public static void a(@NonNull Window window, boolean z10, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2) {
        boolean z11 = num == null || num.intValue() == 0;
        boolean z12 = num2 == null || num2.intValue() == 0;
        if (z11 || z12) {
            int iB = n4.a.b(window.getContext(), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
            if (z11) {
                num = Integer.valueOf(iB);
            }
            if (z12) {
                num2 = Integer.valueOf(iB);
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, !z10);
        int iC = c(window.getContext(), z10);
        int iB2 = b(window.getContext(), z10);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, n4.a.h(num.intValue())));
        e(window, d(iB2, n4.a.h(num2.intValue())));
    }

    @TargetApi(21)
    private static int b(Context context, boolean z10) {
        if (z10 && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.setAlphaComponent(n4.a.b(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (z10) {
            return 0;
        }
        return n4.a.b(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    @TargetApi(21)
    private static int c(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return n4.a.b(context, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    private static boolean d(int i10, boolean z10) {
        return n4.a.h(i10) || (i10 == 0 && z10);
    }

    public static void e(@NonNull Window window, boolean z10) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z10);
    }

    public static void f(@NonNull Window window, boolean z10) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(z10);
    }
}
