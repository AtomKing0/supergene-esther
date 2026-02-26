package androidx.activity;

import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EdgeToEdge.kt */
/* JADX INFO: loaded from: classes.dex */
final class EdgeToEdgeBase implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(@NotNull SystemBarStyle statusBarStyle, @NotNull SystemBarStyle navigationBarStyle, @NotNull Window window, @NotNull View view, boolean z10, boolean z11) {
        t.i(statusBarStyle, "statusBarStyle");
        t.i(navigationBarStyle, "navigationBarStyle");
        t.i(window, "window");
        t.i(view, "view");
    }
}
