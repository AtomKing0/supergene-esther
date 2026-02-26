package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidMultiParagraphDraw.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidMultiParagraphDrawKt {
    public static final void drawMultiParagraph(@NotNull MultiParagraph multiParagraph, @NotNull Canvas canvas, @NotNull Brush brush, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        t.i(multiParagraph, "<this>");
        t.i(canvas, "canvas");
        t.i(brush, "brush");
        canvas.save();
        if (multiParagraph.getParagraphInfoList$ui_text_release().size() <= 1 || (brush instanceof SolidColor)) {
            drawParagraphs(multiParagraph, canvas, brush, shadow, textDecoration);
        } else if (brush instanceof ShaderBrush) {
            List<ParagraphInfo> paragraphInfoList$ui_text_release = multiParagraph.getParagraphInfoList$ui_text_release();
            int size = paragraphInfoList$ui_text_release.size();
            float fMax = 0.0f;
            float height = 0.0f;
            for (int i10 = 0; i10 < size; i10++) {
                ParagraphInfo paragraphInfo = paragraphInfoList$ui_text_release.get(i10);
                height += paragraphInfo.getParagraph().getHeight();
                fMax = Math.max(fMax, paragraphInfo.getParagraph().getWidth());
            }
            Shader shaderMo1573createShaderuvyYCjk = ((ShaderBrush) brush).mo1573createShaderuvyYCjk(SizeKt.Size(fMax, height));
            Matrix matrix = new Matrix();
            shaderMo1573createShaderuvyYCjk.getLocalMatrix(matrix);
            List<ParagraphInfo> paragraphInfoList$ui_text_release2 = multiParagraph.getParagraphInfoList$ui_text_release();
            int size2 = paragraphInfoList$ui_text_release2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ParagraphInfo paragraphInfo2 = paragraphInfoList$ui_text_release2.get(i11);
                paragraphInfo2.getParagraph().paint(canvas, BrushKt.ShaderBrush(shaderMo1573createShaderuvyYCjk), shadow, textDecoration);
                canvas.translate(0.0f, paragraphInfo2.getParagraph().getHeight());
                matrix.setTranslate(0.0f, -paragraphInfo2.getParagraph().getHeight());
                shaderMo1573createShaderuvyYCjk.setLocalMatrix(matrix);
            }
        }
        canvas.restore();
    }

    public static /* synthetic */ void drawMultiParagraph$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, Shadow shadow, TextDecoration textDecoration, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            shadow = null;
        }
        if ((i10 & 8) != 0) {
            textDecoration = null;
        }
        drawMultiParagraph(multiParagraph, canvas, brush, shadow, textDecoration);
    }

    private static final void drawParagraphs(MultiParagraph multiParagraph, Canvas canvas, Brush brush, Shadow shadow, TextDecoration textDecoration) {
        List<ParagraphInfo> paragraphInfoList$ui_text_release = multiParagraph.getParagraphInfoList$ui_text_release();
        int size = paragraphInfoList$ui_text_release.size();
        for (int i10 = 0; i10 < size; i10++) {
            ParagraphInfo paragraphInfo = paragraphInfoList$ui_text_release.get(i10);
            paragraphInfo.getParagraph().paint(canvas, brush, shadow, textDecoration);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
    }
}
