package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.p;
import v8.q;

/* JADX INFO: compiled from: AndroidParagraph.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraph implements Paragraph {
    private final long constraints;
    private final boolean ellipsis;

    @NotNull
    private final TextLayout layout;
    private final int maxLines;

    @NotNull
    private final AndroidParagraphIntrinsics paragraphIntrinsics;

    @NotNull
    private final List<Rect> placeholderRects;

    @NotNull
    private final l wordBoundary$delegate;

    /* JADX INFO: compiled from: AndroidParagraph.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i10, boolean z10, long j10, k kVar) {
        this(androidParagraphIntrinsics, i10, z10, j10);
    }

    private final TextLayout constructTextLayout(int i10, int i11, TextUtils.TruncateAt truncateAt, int i12) {
        return new TextLayout(this.paragraphIntrinsics.getCharSequence$ui_text_release(), getWidth(), getTextPaint$ui_text_release(), i10, truncateAt, this.paragraphIntrinsics.getTextDirectionHeuristic$ui_text_release(), 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, i12, 0, 0, i11, null, null, this.paragraphIntrinsics.getLayoutIntrinsics$ui_text_release(), 55424, null);
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout textLayout) {
        if (!(textLayout.getText() instanceof Spanned)) {
            return new ShaderBrushSpan[0];
        }
        ShaderBrushSpan[] brushSpans = (ShaderBrushSpan[]) ((Spanned) textLayout.getText()).getSpans(0, textLayout.getText().length(), ShaderBrushSpan.class);
        t.h(brushSpans, "brushSpans");
        return brushSpans.length == 0 ? new ShaderBrushSpan[0] : brushSpans;
    }

    private final WordBoundary getWordBoundary() {
        return (WordBoundary) this.wordBoundary$delegate.getValue();
    }

    /* JADX INFO: renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final void m3516fillBoundingBoxes8ffj60Q(long j10, @NotNull float[] array, int i10) {
        t.i(array, "array");
        this.layout.fillBoundingBoxes(TextRange.m3333getMinimpl(j10), TextRange.m3332getMaximpl(j10), array, i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    @NotNull
    public ResolvedTextDirection getBidiRunDirection(int i10) {
        return this.layout.isRtlCharAt(i10) ? ResolvedTextDirection.Rtl : ResolvedTextDirection.Ltr;
    }

    @Override // androidx.compose.ui.text.Paragraph
    @NotNull
    public Rect getBoundingBox(int i10) {
        float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, i10, false, 2, null);
        float primaryHorizontal$default2 = TextLayout.getPrimaryHorizontal$default(this.layout, i10 + 1, false, 2, null);
        int lineForOffset = this.layout.getLineForOffset(i10);
        return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default2, this.layout.getLineBottom(lineForOffset));
    }

    @NotNull
    public final CharSequence getCharSequence$ui_text_release() {
        return this.paragraphIntrinsics.getCharSequence$ui_text_release();
    }

    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public final long m3517getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.ui.text.Paragraph
    @NotNull
    public Rect getCursorRect(int i10) {
        if (i10 >= 0 && i10 <= getCharSequence$ui_text_release().length()) {
            float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, i10, false, 2, null);
            int lineForOffset = this.layout.getLineForOffset(i10);
            return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
        }
        throw new AssertionError("offset(" + i10 + ") is out of bounds (0," + getCharSequence$ui_text_release().length());
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final boolean getEllipsis() {
        return this.ellipsis;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getFirstBaseline() {
        return getLineBaseline$ui_text_release(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHeight() {
        return this.layout.getHeight();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHorizontalPosition(int i10, boolean z10) {
        return z10 ? TextLayout.getPrimaryHorizontal$default(this.layout, i10, false, 2, null) : TextLayout.getSecondaryHorizontal$default(this.layout, i10, false, 2, null);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLastBaseline() {
        return this.maxLines < getLineCount() ? getLineBaseline$ui_text_release(this.maxLines - 1) : getLineBaseline$ui_text_release(getLineCount() - 1);
    }

    public final float getLineAscent$ui_text_release(int i10) {
        return this.layout.getLineAscent(i10);
    }

    public final float getLineBaseline$ui_text_release(int i10) {
        return this.layout.getLineBaseline(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBottom(int i10) {
        return this.layout.getLineBottom(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public final float getLineDescent$ui_text_release(int i10) {
        return this.layout.getLineDescent(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineEnd(int i10, boolean z10) {
        return z10 ? this.layout.getLineVisibleEnd(i10) : this.layout.getLineEnd(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForOffset(int i10) {
        return this.layout.getLineForOffset(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForVerticalPosition(float f10) {
        return this.layout.getLineForVertical((int) f10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineHeight(int i10) {
        return this.layout.getLineHeight(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineLeft(int i10) {
        return this.layout.getLineLeft(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineRight(int i10) {
        return this.layout.getLineRight(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineStart(int i10) {
        return this.layout.getLineStart(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineTop(int i10) {
        return this.layout.getLineTop(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineWidth(int i10) {
        return this.layout.getLineWidth(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M */
    public int mo3254getOffsetForPositionk4lQ0M(long j10) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Offset.m1368getYimpl(j10)), Offset.m1367getXimpl(j10));
    }

    @Override // androidx.compose.ui.text.Paragraph
    @NotNull
    public ResolvedTextDirection getParagraphDirection(int i10) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(i10)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    @NotNull
    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    @Override // androidx.compose.ui.text.Paragraph
    @NotNull
    public Path getPathForRange(int i10, int i11) {
        boolean z10 = false;
        if (i10 >= 0 && i10 <= i11) {
            z10 = true;
        }
        if (z10 && i11 <= getCharSequence$ui_text_release().length()) {
            android.graphics.Path path = new android.graphics.Path();
            this.layout.getSelectionPath(i10, i11, path);
            return AndroidPath_androidKt.asComposePath(path);
        }
        throw new AssertionError("Start(" + i10 + ") or End(" + i11 + ") is out of Range(0.." + getCharSequence$ui_text_release().length() + "), or start > end!");
    }

    @Override // androidx.compose.ui.text.Paragraph
    @NotNull
    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    @NotNull
    public final Locale getTextLocale$ui_text_release() {
        Locale textLocale = this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
        t.h(textLocale, "paragraphIntrinsics.textPaint.textLocale");
        return textLocale;
    }

    @NotNull
    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getWidth() {
        return Constraints.m3641getMaxWidthimpl(this.constraints);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* JADX INFO: renamed from: getWordBoundary--jx7JFs */
    public long mo3255getWordBoundaryjx7JFs(int i10) {
        return TextRangeKt.TextRange(getWordBoundary().getWordStart(i10), getWordBoundary().getWordEnd(i10));
    }

    @VisibleForTesting
    public final boolean isEllipsisApplied$ui_text_release(int i10) {
        return this.layout.isEllipsisApplied(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean isLineEllipsized(int i10) {
        return this.layout.isLineEllipsized(i10);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public void paint(@NotNull Canvas canvas, @NotNull Brush brush, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        t.i(canvas, "canvas");
        t.i(brush, "brush");
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m3525setBrushd16Qtg0(brush, SizeKt.Size(getWidth(), getHeight()));
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* JADX INFO: renamed from: paint-RPmYEkk */
    public void mo3256paintRPmYEkk(@NotNull Canvas canvas, long j10, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        t.i(canvas, "canvas");
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m3526setColor8_81llA(j10);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    public /* synthetic */ AndroidParagraph(String str, TextStyle textStyle, List list, List list2, int i10, boolean z10, long j10, FontFamily.Resolver resolver, Density density, k kVar) {
        this(str, textStyle, list, list2, i10, z10, j10, resolver, density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.compose.ui.text.platform.AndroidParagraph] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    private AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i10, boolean z10, long j10) {
        List<Rect> listL;
        Rect rect;
        float horizontalPosition;
        float lineBaseline;
        int heightPx;
        float lineTop;
        float heightPx2;
        float lineBaseline2;
        this.paragraphIntrinsics = androidParagraphIntrinsics;
        this.maxLines = i10;
        this.ellipsis = z10;
        this.constraints = j10;
        boolean z11 = false;
        if (!(Constraints.m3642getMinHeightimpl(j10) == 0 && Constraints.m3643getMinWidthimpl(j10) == 0)) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        }
        if (i10 >= 1) {
            TextStyle style = androidParagraphIntrinsics.getStyle();
            int iM3524toLayoutAlignAMY3VfE = AndroidParagraph_androidKt.m3524toLayoutAlignAMY3VfE(style.m3357getTextAlignbuA522U());
            TextAlign textAlignM3357getTextAlignbuA522U = style.m3357getTextAlignbuA522U();
            ?? M3589equalsimpl0 = textAlignM3357getTextAlignbuA522U == null ? 0 : TextAlign.m3589equalsimpl0(textAlignM3357getTextAlignbuA522U.m3592unboximpl(), TextAlign.Companion.m3595getJustifye0LSkKk());
            TextUtils.TruncateAt truncateAt = z10 ? TextUtils.TruncateAt.END : null;
            TextLayout textLayoutConstructTextLayout = constructTextLayout(iM3524toLayoutAlignAMY3VfE, M3589equalsimpl0, truncateAt, i10);
            if (z10 && textLayoutConstructTextLayout.getHeight() > Constraints.m3640getMaxHeightimpl(j10) && i10 > 1) {
                int iNumberOfLinesThatFitMaxHeight = AndroidParagraph_androidKt.numberOfLinesThatFitMaxHeight(textLayoutConstructTextLayout, Constraints.m3640getMaxHeightimpl(j10));
                if (iNumberOfLinesThatFitMaxHeight > 0 && iNumberOfLinesThatFitMaxHeight != i10) {
                    textLayoutConstructTextLayout = constructTextLayout(iM3524toLayoutAlignAMY3VfE, M3589equalsimpl0, truncateAt, iNumberOfLinesThatFitMaxHeight);
                }
                this.layout = textLayoutConstructTextLayout;
            } else {
                this.layout = textLayoutConstructTextLayout;
            }
            getTextPaint$ui_text_release().m3525setBrushd16Qtg0(style.getBrush(), SizeKt.Size(getWidth(), getHeight()));
            for (ShaderBrushSpan shaderBrushSpan : getShaderBrushSpans(this.layout)) {
                shaderBrushSpan.m3541setSizeiaC8Vc4(Size.m1424boximpl(SizeKt.Size(getWidth(), getHeight())));
            }
            CharSequence charSequence$ui_text_release = this.paragraphIntrinsics.getCharSequence$ui_text_release();
            if (!(charSequence$ui_text_release instanceof Spanned)) {
                listL = v.l();
            } else {
                Object[] spans = ((Spanned) charSequence$ui_text_release).getSpans(0, charSequence$ui_text_release.length(), PlaceholderSpan.class);
                t.h(spans, "getSpans(0, length, PlaceholderSpan::class.java)");
                ArrayList arrayList = new ArrayList(spans.length);
                int length = spans.length;
                int i11 = 0;
                while (i11 < length) {
                    PlaceholderSpan placeholderSpan = (PlaceholderSpan) spans[i11];
                    Spanned spanned = (Spanned) charSequence$ui_text_release;
                    int spanStart = spanned.getSpanStart(placeholderSpan);
                    int spanEnd = spanned.getSpanEnd(placeholderSpan);
                    int lineForOffset = this.layout.getLineForOffset(spanStart);
                    boolean z12 = (this.layout.getLineEllipsisCount(lineForOffset) <= 0 || spanEnd <= this.layout.getLineEllipsisOffset(lineForOffset)) ? z11 : true;
                    boolean z13 = spanEnd > this.layout.getLineEnd(lineForOffset) ? true : z11;
                    if (z12 || z13) {
                        rect = null;
                    } else {
                        int i12 = WhenMappings.$EnumSwitchMapping$0[getBidiRunDirection(spanStart).ordinal()];
                        if (i12 != 1) {
                            if (i12 != 2) {
                                throw new q();
                            }
                            horizontalPosition = getHorizontalPosition(spanStart, true) - placeholderSpan.getWidthPx();
                        } else {
                            horizontalPosition = getHorizontalPosition(spanStart, true);
                        }
                        float widthPx = placeholderSpan.getWidthPx() + horizontalPosition;
                        TextLayout textLayout = this.layout;
                        switch (placeholderSpan.getVerticalAlign()) {
                            case 0:
                                lineBaseline = textLayout.getLineBaseline(lineForOffset);
                                heightPx = placeholderSpan.getHeightPx();
                                lineTop = lineBaseline - heightPx;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 1:
                                lineTop = textLayout.getLineTop(lineForOffset);
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 2:
                                lineBaseline = textLayout.getLineBottom(lineForOffset);
                                heightPx = placeholderSpan.getHeightPx();
                                lineTop = lineBaseline - heightPx;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 3:
                                lineTop = ((textLayout.getLineTop(lineForOffset) + textLayout.getLineBottom(lineForOffset)) - placeholderSpan.getHeightPx()) / 2;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 4:
                                heightPx2 = placeholderSpan.getFontMetrics().ascent;
                                lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                                lineTop = heightPx2 + lineBaseline2;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 5:
                                lineBaseline = placeholderSpan.getFontMetrics().descent + textLayout.getLineBaseline(lineForOffset);
                                heightPx = placeholderSpan.getHeightPx();
                                lineTop = lineBaseline - heightPx;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 6:
                                Paint.FontMetricsInt fontMetrics = placeholderSpan.getFontMetrics();
                                heightPx2 = ((fontMetrics.ascent + fontMetrics.descent) - placeholderSpan.getHeightPx()) / 2;
                                lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                                lineTop = heightPx2 + lineBaseline2;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            default:
                                throw new IllegalStateException("unexpected verticalAlignment");
                        }
                    }
                    arrayList.add(rect);
                    i11++;
                    z11 = false;
                }
                listL = arrayList;
            }
            this.placeholderRects = listL;
            this.wordBoundary$delegate = n.b(p.f35203c, new AndroidParagraph$wordBoundary$2(this));
            return;
        }
        throw new IllegalArgumentException("maxLines should be greater than 0".toString());
    }

    @VisibleForTesting
    public static /* synthetic */ void getCharSequence$ui_text_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTextLocale$ui_text_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTextPaint$ui_text_release$annotations() {
    }

    private AndroidParagraph(String str, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i10, boolean z10, long j10, FontFamily.Resolver resolver, Density density) {
        this(new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density), i10, z10, j10, null);
    }
}
