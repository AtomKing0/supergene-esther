package androidx.compose.ui.graphics;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CanvasUtils.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class CanvasZHelper {

    @NotNull
    public static final CanvasZHelper INSTANCE = new CanvasZHelper();

    private CanvasZHelper() {
    }

    @DoNotInline
    public final void enableZ(@NotNull android.graphics.Canvas canvas, boolean z10) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
        if (z10) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
