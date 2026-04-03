package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Canvas.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {
    @NotNull
    public static final Canvas Canvas(@NotNull ImageBitmap image) {
        kotlin.jvm.internal.t.i(image, "image");
        return AndroidCanvas_androidKt.ActualCanvas(image);
    }

    public static final void rotate(@NotNull Canvas canvas, float f10, float f11, float f12) {
        kotlin.jvm.internal.t.i(canvas, "<this>");
        if (f10 == 0.0f) {
            return;
        }
        canvas.translate(f11, f12);
        canvas.rotate(f10);
        canvas.translate(-f11, -f12);
    }

    public static final void rotateRad(@NotNull Canvas canvas, float f10, float f11, float f12) {
        kotlin.jvm.internal.t.i(canvas, "<this>");
        rotate(canvas, DegreesKt.degrees(f10), f11, f12);
    }

    public static /* synthetic */ void rotateRad$default(Canvas canvas, float f10, float f11, float f12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        rotateRad(canvas, f10, f11, f12);
    }

    public static final void scale(@NotNull Canvas canvas, float f10, float f11, float f12, float f13) {
        kotlin.jvm.internal.t.i(canvas, "<this>");
        if (f10 == 1.0f) {
            if (f11 == 1.0f) {
                return;
            }
        }
        canvas.translate(f12, f13);
        canvas.scale(f10, f11);
        canvas.translate(-f12, -f13);
    }

    public static /* synthetic */ void scale$default(Canvas canvas, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = f10;
        }
        scale(canvas, f10, f11, f12, f13);
    }

    public static final void withSave(@NotNull Canvas canvas, @NotNull h9.a<v8.k0> block) {
        kotlin.jvm.internal.t.i(canvas, "<this>");
        kotlin.jvm.internal.t.i(block, "block");
        try {
            canvas.save();
            block.invoke();
        } finally {
            r.b(1);
            canvas.restore();
            r.a(1);
        }
    }

    public static final void withSaveLayer(@NotNull Canvas canvas, @NotNull Rect bounds, @NotNull Paint paint, @NotNull h9.a<v8.k0> block) {
        kotlin.jvm.internal.t.i(canvas, "<this>");
        kotlin.jvm.internal.t.i(bounds, "bounds");
        kotlin.jvm.internal.t.i(paint, "paint");
        kotlin.jvm.internal.t.i(block, "block");
        try {
            canvas.saveLayer(bounds, paint);
            block.invoke();
        } finally {
            r.b(1);
            canvas.restore();
            r.a(1);
        }
    }
}
