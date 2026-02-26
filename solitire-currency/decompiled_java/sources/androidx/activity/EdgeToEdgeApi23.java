package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EdgeToEdge.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
final class EdgeToEdgeApi23 implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    @DoNotInline
    public void setUp(@NotNull SystemBarStyle statusBarStyle, @NotNull SystemBarStyle navigationBarStyle, @NotNull Window window, @NotNull View view, boolean z10, boolean z11) {
        t.i(statusBarStyle, "statusBarStyle");
        t.i(navigationBarStyle, "navigationBarStyle");
        t.i(window, "window");
        t.i(view, "view");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(statusBarStyle.getScrim$activity_release(z10));
        window.setNavigationBarColor(navigationBarStyle.getDarkScrim$activity_release());
        new WindowInsetsControllerCompat(window, view).setAppearanceLightStatusBars(!z10);
    }
}
