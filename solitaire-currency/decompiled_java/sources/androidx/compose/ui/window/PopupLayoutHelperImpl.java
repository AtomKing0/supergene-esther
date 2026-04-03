package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
class PopupLayoutHelperImpl implements PopupLayoutHelper {
    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public void getWindowVisibleDisplayFrame(@NotNull View composeView, @NotNull Rect outRect) {
        t.i(composeView, "composeView");
        t.i(outRect, "outRect");
        composeView.getWindowVisibleDisplayFrame(outRect);
    }

    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(@NotNull View composeView, int i10, int i11) {
        t.i(composeView, "composeView");
    }

    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public void updateViewLayout(@NotNull WindowManager windowManager, @NotNull View popupView, @NotNull ViewGroup.LayoutParams params) {
        t.i(windowManager, "windowManager");
        t.i(popupView, "popupView");
        t.i(params, "params");
        windowManager.updateViewLayout(popupView, params);
    }
}
