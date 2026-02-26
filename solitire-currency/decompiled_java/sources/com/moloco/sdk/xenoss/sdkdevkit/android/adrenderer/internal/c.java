package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final void a(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "<this>");
        View hideSystemUI$lambda$0 = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 30) {
            c(activity);
        } else {
            kotlin.jvm.internal.t.h(hideSystemUI$lambda$0, "hideSystemUI$lambda$0");
            b(hideSystemUI$lambda$0);
        }
    }

    public static final void b(View view) {
        view.setSystemUiVisibility(4102);
    }

    public static final void c(Activity activity) {
        WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(activity.getWindow(), activity.getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
    }
}
