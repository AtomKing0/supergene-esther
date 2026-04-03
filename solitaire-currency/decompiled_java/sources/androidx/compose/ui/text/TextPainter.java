package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.a1;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextPainter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextPainter {

    @NotNull
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    public final void paint(@NotNull Canvas canvas, @NotNull TextLayoutResult textLayoutResult) {
        t.i(canvas, "canvas");
        t.i(textLayoutResult, "textLayoutResult");
        boolean z10 = textLayoutResult.getHasVisualOverflow() && TextOverflow.m3619equalsimpl0(textLayoutResult.getLayoutInput().m3317getOverflowgIe3tQ8(), TextOverflow.Companion.m3626getClipgIe3tQ8());
        if (z10) {
            Rect rectM1407Recttz77jQw = RectKt.m1407Recttz77jQw(Offset.Companion.m1383getZeroF1C5BW0(), SizeKt.Size(IntSize.m3833getWidthimpl(textLayoutResult.m3321getSizeYbymL2g()), IntSize.m3832getHeightimpl(textLayoutResult.m3321getSizeYbymL2g())));
            canvas.save();
            a1.o(canvas, rectM1407Recttz77jQw, 0, 2, null);
        }
        try {
            Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
            if (brush != null) {
                textLayoutResult.getMultiParagraph().paint(canvas, brush, textLayoutResult.getLayoutInput().getStyle().getShadow(), textLayoutResult.getLayoutInput().getStyle().getTextDecoration());
            } else {
                textLayoutResult.getMultiParagraph().m3253paintRPmYEkk(canvas, textLayoutResult.getLayoutInput().getStyle().m3351getColor0d7_KjU(), textLayoutResult.getLayoutInput().getStyle().getShadow(), textLayoutResult.getLayoutInput().getStyle().getTextDecoration());
            }
        } finally {
            if (z10) {
                canvas.restore();
            }
        }
    }
}
