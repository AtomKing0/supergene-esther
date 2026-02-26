package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextLayoutResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutResult {
    private final float firstBaseline;
    private final float lastBaseline;

    @NotNull
    private final TextLayoutInput layoutInput;

    @NotNull
    private final MultiParagraph multiParagraph;

    @NotNull
    private final List<Rect> placeholderRects;
    private final long size;

    public /* synthetic */ TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j10, k kVar) {
        this(textLayoutInput, multiParagraph, j10);
    }

    /* JADX INFO: renamed from: copy-O0kMr_c$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m3318copyO0kMr_c$default(TextLayoutResult textLayoutResult, TextLayoutInput textLayoutInput, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            textLayoutInput = textLayoutResult.layoutInput;
        }
        if ((i10 & 2) != 0) {
            j10 = textLayoutResult.size;
        }
        return textLayoutResult.m3319copyO0kMr_c(textLayoutInput, j10);
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResult textLayoutResult, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return textLayoutResult.getLineEnd(i10, z10);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-O0kMr_c, reason: not valid java name */
    public final TextLayoutResult m3319copyO0kMr_c(@NotNull TextLayoutInput layoutInput, long j10) {
        t.i(layoutInput, "layoutInput");
        return new TextLayoutResult(layoutInput, this.multiParagraph, j10, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutResult)) {
            return false;
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
        if (!t.d(this.layoutInput, textLayoutResult.layoutInput) || !t.d(this.multiParagraph, textLayoutResult.multiParagraph) || !IntSize.m3831equalsimpl0(this.size, textLayoutResult.size)) {
            return false;
        }
        if (this.firstBaseline == textLayoutResult.firstBaseline) {
            return ((this.lastBaseline > textLayoutResult.lastBaseline ? 1 : (this.lastBaseline == textLayoutResult.lastBaseline ? 0 : -1)) == 0) && t.d(this.placeholderRects, textLayoutResult.placeholderRects);
        }
        return false;
    }

    @NotNull
    public final ResolvedTextDirection getBidiRunDirection(int i10) {
        return this.multiParagraph.getBidiRunDirection(i10);
    }

    @NotNull
    public final Rect getBoundingBox(int i10) {
        return this.multiParagraph.getBoundingBox(i10);
    }

    @NotNull
    public final Rect getCursorRect(int i10) {
        return this.multiParagraph.getCursorRect(i10);
    }

    public final boolean getDidOverflowHeight() {
        return this.multiParagraph.getDidExceedMaxLines() || ((float) IntSize.m3832getHeightimpl(this.size)) < this.multiParagraph.getHeight();
    }

    public final boolean getDidOverflowWidth() {
        return ((float) IntSize.m3833getWidthimpl(this.size)) < this.multiParagraph.getWidth();
    }

    public final float getFirstBaseline() {
        return this.firstBaseline;
    }

    public final boolean getHasVisualOverflow() {
        return getDidOverflowWidth() || getDidOverflowHeight();
    }

    public final float getHorizontalPosition(int i10, boolean z10) {
        return this.multiParagraph.getHorizontalPosition(i10, z10);
    }

    public final float getLastBaseline() {
        return this.lastBaseline;
    }

    @NotNull
    public final TextLayoutInput getLayoutInput() {
        return this.layoutInput;
    }

    public final float getLineBottom(int i10) {
        return this.multiParagraph.getLineBottom(i10);
    }

    public final int getLineCount() {
        return this.multiParagraph.getLineCount();
    }

    public final int getLineEnd(int i10, boolean z10) {
        return this.multiParagraph.getLineEnd(i10, z10);
    }

    public final int getLineForOffset(int i10) {
        return this.multiParagraph.getLineForOffset(i10);
    }

    public final int getLineForVerticalPosition(float f10) {
        return this.multiParagraph.getLineForVerticalPosition(f10);
    }

    public final float getLineLeft(int i10) {
        return this.multiParagraph.getLineLeft(i10);
    }

    public final float getLineRight(int i10) {
        return this.multiParagraph.getLineRight(i10);
    }

    public final int getLineStart(int i10) {
        return this.multiParagraph.getLineStart(i10);
    }

    public final float getLineTop(int i10) {
        return this.multiParagraph.getLineTop(i10);
    }

    @NotNull
    public final MultiParagraph getMultiParagraph() {
        return this.multiParagraph;
    }

    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m3320getOffsetForPositionk4lQ0M(long j10) {
        return this.multiParagraph.m3251getOffsetForPositionk4lQ0M(j10);
    }

    @NotNull
    public final ResolvedTextDirection getParagraphDirection(int i10) {
        return this.multiParagraph.getParagraphDirection(i10);
    }

    @NotNull
    public final Path getPathForRange(int i10, int i11) {
        return this.multiParagraph.getPathForRange(i10, i11);
    }

    @NotNull
    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m3321getSizeYbymL2g() {
        return this.size;
    }

    /* JADX INFO: renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m3322getWordBoundaryjx7JFs(int i10) {
        return this.multiParagraph.m3252getWordBoundaryjx7JFs(i10);
    }

    public int hashCode() {
        return (((((((((this.layoutInput.hashCode() * 31) + this.multiParagraph.hashCode()) * 31) + IntSize.m3834hashCodeimpl(this.size)) * 31) + Float.floatToIntBits(this.firstBaseline)) * 31) + Float.floatToIntBits(this.lastBaseline)) * 31) + this.placeholderRects.hashCode();
    }

    public final boolean isLineEllipsized(int i10) {
        return this.multiParagraph.isLineEllipsized(i10);
    }

    @NotNull
    public String toString() {
        return "TextLayoutResult(layoutInput=" + this.layoutInput + ", multiParagraph=" + this.multiParagraph + ", size=" + ((Object) IntSize.m3836toStringimpl(this.size)) + ", firstBaseline=" + this.firstBaseline + ", lastBaseline=" + this.lastBaseline + ", placeholderRects=" + this.placeholderRects + ')';
    }

    private TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j10) {
        this.layoutInput = textLayoutInput;
        this.multiParagraph = multiParagraph;
        this.size = j10;
        this.firstBaseline = multiParagraph.getFirstBaseline();
        this.lastBaseline = multiParagraph.getLastBaseline();
        this.placeholderRects = multiParagraph.getPlaceholderRects();
    }
}
