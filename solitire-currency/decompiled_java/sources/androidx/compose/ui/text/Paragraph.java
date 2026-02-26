package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Paragraph.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Paragraph {

    /* JADX INFO: compiled from: Paragraph.kt */
    public static final class DefaultImpls {
        @ExperimentalTextApi
        @Deprecated
        public static void paint(@NotNull Paragraph paragraph, @NotNull Canvas canvas, @NotNull Brush brush, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
            t.i(canvas, "canvas");
            t.i(brush, "brush");
            a.a(paragraph, canvas, brush, shadow, textDecoration);
        }
    }

    @NotNull
    ResolvedTextDirection getBidiRunDirection(int i10);

    @NotNull
    Rect getBoundingBox(int i10);

    @NotNull
    Rect getCursorRect(int i10);

    boolean getDidExceedMaxLines();

    float getFirstBaseline();

    float getHeight();

    float getHorizontalPosition(int i10, boolean z10);

    float getLastBaseline();

    float getLineBottom(int i10);

    int getLineCount();

    int getLineEnd(int i10, boolean z10);

    int getLineForOffset(int i10);

    int getLineForVerticalPosition(float f10);

    float getLineHeight(int i10);

    float getLineLeft(int i10);

    float getLineRight(int i10);

    int getLineStart(int i10);

    float getLineTop(int i10);

    float getLineWidth(int i10);

    float getMaxIntrinsicWidth();

    float getMinIntrinsicWidth();

    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    int mo3254getOffsetForPositionk4lQ0M(long j10);

    @NotNull
    ResolvedTextDirection getParagraphDirection(int i10);

    @NotNull
    Path getPathForRange(int i10, int i11);

    @NotNull
    List<Rect> getPlaceholderRects();

    float getWidth();

    /* JADX INFO: renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    long mo3255getWordBoundaryjx7JFs(int i10);

    boolean isLineEllipsized(int i10);

    @ExperimentalTextApi
    void paint(@NotNull Canvas canvas, @NotNull Brush brush, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration);

    /* JADX INFO: renamed from: paint-RPmYEkk, reason: not valid java name */
    void mo3256paintRPmYEkk(@NotNull Canvas canvas, long j10, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration);
}
