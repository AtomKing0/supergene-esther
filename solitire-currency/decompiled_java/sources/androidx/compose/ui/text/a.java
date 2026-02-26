package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Paragraph.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    @ExperimentalTextApi
    public static void a(Paragraph paragraph, @NotNull Canvas canvas, @NotNull Brush brush, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        t.i(canvas, "canvas");
        t.i(brush, "brush");
        throw new UnsupportedOperationException("Using brush for painting the paragraph is a separate functionality that is not supported on this platform");
    }

    public static /* synthetic */ int c(Paragraph paragraph, int i10, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEnd");
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return paragraph.getLineEnd(i10, z10);
    }

    public static /* synthetic */ void d(Paragraph paragraph, Canvas canvas, Brush brush, Shadow shadow, TextDecoration textDecoration, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint");
        }
        if ((i10 & 4) != 0) {
            shadow = null;
        }
        if ((i10 & 8) != 0) {
            textDecoration = null;
        }
        paragraph.paint(canvas, brush, shadow, textDecoration);
    }

    public static /* synthetic */ void e(Paragraph paragraph, Canvas canvas, long j10, Shadow shadow, TextDecoration textDecoration, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-RPmYEkk");
        }
        if ((i10 & 2) != 0) {
            j10 = Color.Companion.m1634getUnspecified0d7_KjU();
        }
        paragraph.mo3256paintRPmYEkk(canvas, j10, (i10 & 4) != 0 ? null : shadow, (i10 & 8) != 0 ? null : textDecoration);
    }
}
