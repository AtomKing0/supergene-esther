package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting(otherwise = 2)
public interface PopupLayoutHelper {
    void getWindowVisibleDisplayFrame(@NotNull View view, @NotNull Rect rect);

    void setGestureExclusionRects(@NotNull View view, int i10, int i11);

    void updateViewLayout(@NotNull WindowManager windowManager, @NotNull View view, @NotNull ViewGroup.LayoutParams layoutParams);
}
