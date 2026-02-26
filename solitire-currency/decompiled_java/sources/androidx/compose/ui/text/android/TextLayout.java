package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.p;
import v8.s;

/* JADX INFO: compiled from: TextLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class TextLayout {
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;

    @NotNull
    private final Layout layout;

    @NotNull
    private final l layoutHelper$delegate;

    @NotNull
    private final LayoutIntrinsics layoutIntrinsics;
    private final int lineCount;
    private final int topPadding;

    public TextLayout(@NotNull CharSequence charSequence, float f10, @NotNull TextPaint textPaint, int i10, @Nullable TextUtils.TruncateAt truncateAt, int i11, float f11, @Px float f12, boolean z10, boolean z11, int i12, int i13, int i14, int i15, @Nullable int[] iArr, @Nullable int[] iArr2, @NotNull LayoutIntrinsics layoutIntrinsics) {
        boolean z12;
        boolean z13;
        Layout layoutCreate;
        t.i(charSequence, "charSequence");
        t.i(textPaint, "textPaint");
        t.i(layoutIntrinsics, "layoutIntrinsics");
        this.includePadding = z10;
        this.fallbackLineSpacing = z11;
        this.layoutIntrinsics = layoutIntrinsics;
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristic = TextLayoutKt.getTextDirectionHeuristic(i11);
        Layout.Alignment alignment = TextAlignmentAdapter.INSTANCE.get(i10);
        boolean z14 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, BaselineShiftSpan.class) < length;
        BoringLayout.Metrics boringMetrics = layoutIntrinsics.getBoringMetrics();
        double d10 = f10;
        int iCeil = (int) Math.ceil(d10);
        if (boringMetrics == null || layoutIntrinsics.getMaxIntrinsicWidth() > f10 || z14) {
            this.isBoringLayout = false;
            z12 = false;
            z13 = true;
            layoutCreate = StaticLayoutFactory.INSTANCE.create(charSequence, 0, charSequence.length(), textPaint, iCeil, textDirectionHeuristic, alignment, i12, truncateAt, (int) Math.ceil(d10), f11, f12, i15, z10, z11, i13, i14, iArr, iArr2);
        } else {
            this.isBoringLayout = true;
            layoutCreate = BoringLayoutFactory.INSTANCE.create(charSequence, textPaint, iCeil, boringMetrics, alignment, z10, truncateAt, iCeil);
            z13 = true;
            z12 = false;
        }
        this.layout = layoutCreate;
        int iMin = Math.min(layoutCreate.getLineCount(), i12);
        this.lineCount = iMin;
        this.didExceedMaxLines = (iMin >= i12 && (layoutCreate.getEllipsisCount(iMin + (-1)) > 0 || layoutCreate.getLineEnd(iMin + (-1)) != charSequence.length())) ? z13 : z12;
        s verticalPaddings = TextLayoutKt.getVerticalPaddings(this);
        s lineHeightPaddings = TextLayoutKt.getLineHeightPaddings(this);
        this.topPadding = Math.max(((Number) verticalPaddings.c()).intValue(), ((Number) lineHeightPaddings.c()).intValue());
        this.bottomPadding = Math.max(((Number) verticalPaddings.d()).intValue(), ((Number) lineHeightPaddings.d()).intValue());
        this.layoutHelper$delegate = n.b(p.f35203c, new TextLayout$layoutHelper$2(this));
    }

    private final LayoutHelper getLayoutHelper() {
        return (LayoutHelper) this.layoutHelper$delegate.getValue();
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout textLayout, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return textLayout.getPrimaryHorizontal(i10, z10);
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout textLayout, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return textLayout.getSecondaryHorizontal(i10, z10);
    }

    public final void fillBoundingBoxes(int i10, int i11, @NotNull float[] array, int i12) {
        float secondaryDownstream;
        float secondaryUpstream;
        t.i(array, "array");
        int length = getText().length();
        int i13 = 1;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("startOffset must be > 0".toString());
        }
        if (!(i10 < length)) {
            throw new IllegalArgumentException("startOffset must be less than text length".toString());
        }
        if (!(i11 > i10)) {
            throw new IllegalArgumentException("endOffset must be greater than startOffset".toString());
        }
        if (!(i11 <= length)) {
            throw new IllegalArgumentException("endOffset must be smaller or equal to text length".toString());
        }
        if (!(array.length - i12 >= (i11 - i10) * 4)) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4".toString());
        }
        int lineForOffset = getLineForOffset(i10);
        int lineForOffset2 = getLineForOffset(i11 - 1);
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        if (lineForOffset > lineForOffset2) {
            return;
        }
        int i14 = lineForOffset;
        int i15 = i12;
        while (true) {
            int lineStart = getLineStart(i14);
            int lineEnd = getLineEnd(i14);
            int iMin = Math.min(i11, lineEnd);
            float lineTop = getLineTop(i14);
            float lineBottom = getLineBottom(i14);
            int i16 = getParagraphDirection(i14) == i13 ? i13 : 0;
            int i17 = i16 ^ 1;
            for (int iMax = Math.max(i10, lineStart); iMax < iMin; iMax++) {
                boolean zIsRtlCharAt = isRtlCharAt(iMax);
                if (i16 != 0 && !zIsRtlCharAt) {
                    secondaryDownstream = horizontalPositionCache.getPrimaryDownstream(iMax);
                    secondaryUpstream = horizontalPositionCache.getPrimaryUpstream(iMax + 1);
                } else if (i16 != 0 && zIsRtlCharAt) {
                    secondaryUpstream = horizontalPositionCache.getSecondaryDownstream(iMax);
                    secondaryDownstream = horizontalPositionCache.getSecondaryUpstream(iMax + 1);
                } else if (i17 == 0 || !zIsRtlCharAt) {
                    secondaryDownstream = horizontalPositionCache.getSecondaryDownstream(iMax);
                    secondaryUpstream = horizontalPositionCache.getSecondaryUpstream(iMax + 1);
                } else {
                    secondaryUpstream = horizontalPositionCache.getPrimaryDownstream(iMax);
                    secondaryDownstream = horizontalPositionCache.getPrimaryUpstream(iMax + 1);
                }
                array[i15] = secondaryDownstream;
                array[i15 + 1] = lineTop;
                array[i15 + 2] = secondaryUpstream;
                array[i15 + 3] = lineBottom;
                i15 += 4;
            }
            if (i14 == lineForOffset2) {
                return;
            }
            i14++;
            i13 = 1;
        }
    }

    public final int getBottomPadding$ui_text_release() {
        return this.bottomPadding;
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final int getHeight() {
        return (this.didExceedMaxLines ? this.layout.getLineBottom(this.lineCount - 1) : this.layout.getHeight()) + this.topPadding + this.bottomPadding;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    @NotNull
    public final Layout getLayout() {
        return this.layout;
    }

    @NotNull
    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final float getLineAscent(int i10) {
        return this.layout.getLineAscent(i10);
    }

    public final float getLineBaseline(int i10) {
        return this.topPadding + this.layout.getLineBaseline(i10);
    }

    public final float getLineBottom(int i10) {
        return this.topPadding + this.layout.getLineBottom(i10) + (i10 == this.lineCount + (-1) ? this.bottomPadding : 0);
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final float getLineDescent(int i10) {
        return this.layout.getLineDescent(i10);
    }

    public final int getLineEllipsisCount(int i10) {
        return this.layout.getEllipsisCount(i10);
    }

    public final int getLineEllipsisOffset(int i10) {
        return this.layout.getEllipsisStart(i10);
    }

    public final int getLineEnd(int i10) {
        return this.layout.getEllipsisStart(i10) == 0 ? this.layout.getLineEnd(i10) : this.layout.getText().length();
    }

    public final int getLineForOffset(int i10) {
        return this.layout.getLineForOffset(i10);
    }

    public final int getLineForVertical(int i10) {
        return this.layout.getLineForVertical(this.topPadding + i10);
    }

    public final float getLineHeight(int i10) {
        return getLineBottom(i10) - getLineTop(i10);
    }

    public final float getLineLeft(int i10) {
        return this.layout.getLineLeft(i10);
    }

    public final float getLineRight(int i10) {
        return this.layout.getLineRight(i10);
    }

    public final int getLineStart(int i10) {
        return this.layout.getLineStart(i10);
    }

    public final float getLineTop(int i10) {
        return this.layout.getLineTop(i10) + (i10 == 0 ? 0 : this.topPadding);
    }

    public final int getLineVisibleEnd(int i10) {
        if (this.layout.getEllipsisStart(i10) == 0) {
            return this.layout.getLineVisibleEnd(i10);
        }
        return this.layout.getEllipsisStart(i10) + this.layout.getLineStart(i10);
    }

    public final float getLineWidth(int i10) {
        return this.layout.getLineWidth(i10);
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final int getOffsetForHorizontal(int i10, float f10) {
        return this.layout.getOffsetForHorizontal(i10, f10);
    }

    public final int getParagraphDirection(int i10) {
        return this.layout.getParagraphDirection(i10);
    }

    public final float getPrimaryHorizontal(int i10, boolean z10) {
        return getLayoutHelper().getHorizontalPosition(i10, true, z10);
    }

    public final float getSecondaryHorizontal(int i10, boolean z10) {
        return getLayoutHelper().getHorizontalPosition(i10, false, z10);
    }

    public final void getSelectionPath(int i10, int i11, @NotNull Path dest) {
        t.i(dest, "dest");
        this.layout.getSelectionPath(i10, i11, dest);
        if (this.topPadding == 0 || dest.isEmpty()) {
            return;
        }
        dest.offset(0.0f, this.topPadding);
    }

    @NotNull
    public final CharSequence getText() {
        CharSequence text = this.layout.getText();
        t.h(text, "layout.text");
        return text;
    }

    public final int getTopPadding$ui_text_release() {
        return this.topPadding;
    }

    public final boolean isEllipsisApplied(int i10) {
        return this.layout.getEllipsisCount(i10) > 0;
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        return this.fallbackLineSpacing && !this.isBoringLayout && Build.VERSION.SDK_INT >= 28;
    }

    public final boolean isLineEllipsized(int i10) {
        return this.layout.getEllipsisStart(i10) != 0;
    }

    public final boolean isRtlCharAt(int i10) {
        return this.layout.isRtlCharAt(i10);
    }

    public final void paint(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        int i10 = this.topPadding;
        if (i10 != 0) {
            canvas.translate(0.0f, i10);
        }
        this.layout.draw(canvas);
        int i11 = this.topPadding;
        if (i11 != 0) {
            canvas.translate(0.0f, (-1) * i11);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getBottomPadding$ui_text_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLayout$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTopPadding$ui_text_release$annotations() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextLayout(CharSequence charSequence, float f10, TextPaint textPaint, int i10, TextUtils.TruncateAt truncateAt, int i11, float f11, float f12, boolean z10, boolean z11, int i12, int i13, int i14, int i15, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics, int i16, k kVar) {
        float f13 = (i16 & 2) != 0 ? 0.0f : f10;
        int i17 = (i16 & 8) != 0 ? 0 : i10;
        TextUtils.TruncateAt truncateAt2 = (i16 & 16) != 0 ? null : truncateAt;
        int i18 = (i16 & 32) != 0 ? 2 : i11;
        this(charSequence, f13, textPaint, i17, truncateAt2, i18, (i16 & 64) != 0 ? 1.0f : f11, (i16 & 128) != 0 ? 0.0f : f12, (i16 & 256) != 0 ? false : z10, (i16 & 512) != 0 ? true : z11, (i16 & 1024) != 0 ? Integer.MAX_VALUE : i12, (i16 & 2048) != 0 ? 0 : i13, (i16 & 4096) != 0 ? 0 : i14, (i16 & 8192) != 0 ? 0 : i15, (i16 & 16384) != 0 ? null : iArr, (32768 & i16) != 0 ? null : iArr2, (i16 & 65536) != 0 ? new LayoutIntrinsics(charSequence, textPaint, i18) : layoutIntrinsics);
    }
}
