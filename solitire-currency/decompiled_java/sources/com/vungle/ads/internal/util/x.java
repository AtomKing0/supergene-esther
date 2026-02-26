package com.vungle.ads.internal.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewUtility.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class x {

    @NotNull
    public static final x INSTANCE = new x();

    private x() {
    }

    public final int dpToPixels(@NotNull Context context, int i10) {
        kotlin.jvm.internal.t.i(context, "context");
        return (int) ((i10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @NotNull
    public final v8.s<Integer, Integer> getDeviceWidthAndHeightWithOrientation(@NotNull Context context, int i10) {
        kotlin.jvm.internal.t.i(context, "context");
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i11 = resources.getConfiguration().orientation;
        if (i10 == 0) {
            i10 = i11;
        }
        return i10 == i11 ? new v8.s<>(Integer.valueOf(Math.round(displayMetrics.widthPixels / displayMetrics.density)), Integer.valueOf(Math.round(displayMetrics.heightPixels / displayMetrics.density))) : new v8.s<>(Integer.valueOf(Math.round(displayMetrics.heightPixels / displayMetrics.density)), Integer.valueOf(Math.round(displayMetrics.widthPixels / displayMetrics.density)));
    }

    @NotNull
    public final WebView getWebView(@NotNull Context context) throws InstantiationException {
        kotlin.jvm.internal.t.i(context, "context");
        try {
            return new WebView(context);
        } catch (Resources.NotFoundException e10) {
            throw new InstantiationException("Cannot instantiate WebView due to Resources.NotFoundException: " + e10 + ".message");
        } catch (Exception e11) {
            throw new InstantiationException(e11.getMessage());
        }
    }
}
