package androidx.compose.ui.graphics;

import android.graphics.Rect;
import android.graphics.RectF;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RectHelper.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RectHelper_androidKt {
    @NotNull
    public static final Rect toAndroidRect(@NotNull androidx.compose.ui.geometry.Rect rect) {
        kotlin.jvm.internal.t.i(rect, "<this>");
        return new Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }

    @NotNull
    public static final RectF toAndroidRectF(@NotNull androidx.compose.ui.geometry.Rect rect) {
        kotlin.jvm.internal.t.i(rect, "<this>");
        return new RectF(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
    }

    @NotNull
    public static final androidx.compose.ui.geometry.Rect toComposeRect(@NotNull Rect rect) {
        kotlin.jvm.internal.t.i(rect, "<this>");
        return new androidx.compose.ui.geometry.Rect(rect.left, rect.top, rect.right, rect.bottom);
    }
}
