package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class PopupLayoutHelperImpl29 extends PopupLayoutHelperImpl {
    @Override // androidx.compose.ui.window.PopupLayoutHelperImpl, androidx.compose.ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(@NotNull View composeView, int i10, int i11) {
        t.i(composeView, "composeView");
        composeView.setSystemGestureExclusionRects(v.q(new Rect(0, 0, i10, i11)));
    }
}
