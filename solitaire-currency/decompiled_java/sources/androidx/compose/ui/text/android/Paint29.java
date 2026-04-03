package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PaintExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class Paint29 {

    @NotNull
    public static final Paint29 INSTANCE = new Paint29();

    private Paint29() {
    }

    @DoNotInline
    public static final void getTextBounds(@NotNull Paint paint, @NotNull CharSequence text, int i10, int i11, @NotNull Rect rect) {
        t.i(paint, "paint");
        t.i(text, "text");
        t.i(rect, "rect");
        paint.getTextBounds(text, i10, i11, rect);
    }
}
