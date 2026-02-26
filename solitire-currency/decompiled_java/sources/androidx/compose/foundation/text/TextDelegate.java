package androidx.compose.foundation.text;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@InternalFoundationTextApi
public final class TextDelegate {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Density density;

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    @Nullable
    private LayoutDirection intrinsicsLayoutDirection;
    private final int maxLines;
    private final int overflow;

    @Nullable
    private MultiParagraphIntrinsics paragraphIntrinsics;

    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;

    @NotNull
    private final TextStyle style;

    @NotNull
    private final AnnotatedString text;

    /* JADX INFO: compiled from: TextDelegate.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final void paint(@NotNull Canvas canvas, @NotNull TextLayoutResult textLayoutResult) {
            t.i(canvas, "canvas");
            t.i(textLayoutResult, "textLayoutResult");
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }
    }

    public /* synthetic */ TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i10, boolean z10, int i11, Density density, FontFamily.Resolver resolver, List list, k kVar) {
        this(annotatedString, textStyle, i10, z10, i11, density, resolver, list);
    }

    private final MultiParagraphIntrinsics getNonNullIntrinsics() {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics != null) {
            return multiParagraphIntrinsics;
        }
        throw new IllegalStateException("layoutIntrinsics must be called first");
    }

    /* JADX INFO: renamed from: layout-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m716layoutNN6EwU$default(TextDelegate textDelegate, long j10, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            textLayoutResult = null;
        }
        return textDelegate.m719layoutNN6EwU(j10, layoutDirection, textLayoutResult);
    }

    /* JADX INFO: renamed from: layoutText-K40F9xA, reason: not valid java name */
    private final MultiParagraph m717layoutTextK40F9xA(long j10, LayoutDirection layoutDirection) {
        layoutIntrinsics(layoutDirection);
        int iM3643getMinWidthimpl = Constraints.m3643getMinWidthimpl(j10);
        boolean z10 = false;
        int iM3641getMaxWidthimpl = ((this.softWrap || TextOverflow.m3619equalsimpl0(this.overflow, TextOverflow.Companion.m3627getEllipsisgIe3tQ8())) && Constraints.m3637getHasBoundedWidthimpl(j10)) ? Constraints.m3641getMaxWidthimpl(j10) : Integer.MAX_VALUE;
        if (!this.softWrap && TextOverflow.m3619equalsimpl0(this.overflow, TextOverflow.Companion.m3627getEllipsisgIe3tQ8())) {
            z10 = true;
        }
        int i10 = z10 ? 1 : this.maxLines;
        if (iM3643getMinWidthimpl != iM3641getMaxWidthimpl) {
            iM3641getMaxWidthimpl = o.n(getMaxIntrinsicWidth(), iM3643getMinWidthimpl, iM3641getMaxWidthimpl);
        }
        return new MultiParagraph(getNonNullIntrinsics(), ConstraintsKt.Constraints$default(0, iM3641getMaxWidthimpl, 0, Constraints.m3640getMaxHeightimpl(j10), 5, null), i10, TextOverflow.m3619equalsimpl0(this.overflow, TextOverflow.Companion.m3627getEllipsisgIe3tQ8()), null);
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @Nullable
    public final LayoutDirection getIntrinsicsLayoutDirection$foundation_release() {
        return this.intrinsicsLayoutDirection;
    }

    public final int getMaxIntrinsicWidth() {
        return (int) Math.ceil(getNonNullIntrinsics().getMaxIntrinsicWidth());
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getMinIntrinsicWidth() {
        return (int) Math.ceil(getNonNullIntrinsics().getMinIntrinsicWidth());
    }

    /* JADX INFO: renamed from: getOverflow-gIe3tQ8, reason: not valid java name */
    public final int m718getOverflowgIe3tQ8() {
        return this.overflow;
    }

    @Nullable
    public final MultiParagraphIntrinsics getParagraphIntrinsics$foundation_release() {
        return this.paragraphIntrinsics;
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    @NotNull
    public final TextStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final AnnotatedString getText() {
        return this.text;
    }

    @NotNull
    /* JADX INFO: renamed from: layout-NN6Ew-U, reason: not valid java name */
    public final TextLayoutResult m719layoutNN6EwU(long j10, @NotNull LayoutDirection layoutDirection, @Nullable TextLayoutResult textLayoutResult) {
        t.i(layoutDirection, "layoutDirection");
        if (textLayoutResult != null && TextLayoutHelperKt.m741canReuse7_7YC6M(textLayoutResult, this.text, this.style, this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, j10)) {
            return textLayoutResult.m3319copyO0kMr_c(new TextLayoutInput(textLayoutResult.getLayoutInput().getText(), this.style, textLayoutResult.getLayoutInput().getPlaceholders(), textLayoutResult.getLayoutInput().getMaxLines(), textLayoutResult.getLayoutInput().getSoftWrap(), textLayoutResult.getLayoutInput().m3317getOverflowgIe3tQ8(), textLayoutResult.getLayoutInput().getDensity(), textLayoutResult.getLayoutInput().getLayoutDirection(), textLayoutResult.getLayoutInput().getFontFamilyResolver(), j10, (k) null), ConstraintsKt.m3652constrain4WqzIAM(j10, IntSizeKt.IntSize((int) Math.ceil(textLayoutResult.getMultiParagraph().getWidth()), (int) Math.ceil(textLayoutResult.getMultiParagraph().getHeight()))));
        }
        return new TextLayoutResult(new TextLayoutInput(this.text, this.style, this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, j10, (k) null), m717layoutTextK40F9xA(j10, layoutDirection), ConstraintsKt.m3652constrain4WqzIAM(j10, IntSizeKt.IntSize((int) Math.ceil(r0.getWidth()), (int) Math.ceil(r0.getHeight()))), null);
    }

    public final void layoutIntrinsics(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || multiParagraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(this.text, TextStyleKt.resolveDefaults(this.style, layoutDirection), this.placeholders, this.density, this.fontFamilyResolver);
        }
        this.paragraphIntrinsics = multiParagraphIntrinsics;
    }

    public final void setIntrinsicsLayoutDirection$foundation_release(@Nullable LayoutDirection layoutDirection) {
        this.intrinsicsLayoutDirection = layoutDirection;
    }

    public final void setParagraphIntrinsics$foundation_release(@Nullable MultiParagraphIntrinsics multiParagraphIntrinsics) {
        this.paragraphIntrinsics = multiParagraphIntrinsics;
    }

    private TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i10, boolean z10, int i11, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list) {
        this.text = annotatedString;
        this.style = textStyle;
        this.maxLines = i10;
        this.softWrap = z10;
        this.overflow = i11;
        this.density = density;
        this.fontFamilyResolver = resolver;
        this.placeholders = list;
        if (!(i10 > 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public /* synthetic */ TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i10, boolean z10, int i11, Density density, FontFamily.Resolver resolver, List list, int i12, k kVar) {
        this(annotatedString, textStyle, (i12 & 4) != 0 ? Integer.MAX_VALUE : i10, (i12 & 8) != 0 ? true : z10, (i12 & 16) != 0 ? TextOverflow.Companion.m3626getClipgIe3tQ8() : i11, density, resolver, (i12 & 128) != 0 ? v.l() : list, null);
    }
}
