package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f21627a;

    public n(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f21627a = context;
    }

    public final DisplayMetrics a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    @RequiresApi(30)
    public final DisplayMetrics b(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.density = this.f21627a.getResources().getDisplayMetrics().density;
        displayMetrics.densityDpi = this.f21627a.getResources().getDisplayMetrics().densityDpi;
        displayMetrics.widthPixels = windowManager.getCurrentWindowMetrics().getBounds().width();
        displayMetrics.heightPixels = windowManager.getCurrentWindowMetrics().getBounds().height();
        return displayMetrics;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m
    @NotNull
    public com.moloco.sdk.common_adapter_internal.a invoke() {
        WindowManager windowManager = (WindowManager) ContextCompat.getSystemService(this.f21627a, WindowManager.class);
        if (windowManager == null) {
            return new com.moloco.sdk.common_adapter_internal.a(0, 0, 0.0f, 0.0f, 0, 0.0f);
        }
        DisplayMetrics displayMetricsB = Build.VERSION.SDK_INT >= 30 ? b(windowManager) : a(windowManager);
        int i10 = displayMetricsB.widthPixels;
        return new com.moloco.sdk.common_adapter_internal.a(i10, displayMetricsB.heightPixels, i0.a(i10, displayMetricsB.density), i0.a(displayMetricsB.heightPixels, displayMetricsB.density), displayMetricsB.densityDpi, displayMetricsB.density);
    }
}
