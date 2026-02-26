package androidx.compose.ui.draw;

import androidx.compose.foundation.e;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import h9.l;
import h9.p;
import j9.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: PainterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class PainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {

    @NotNull
    private final Alignment alignment;
    private final float alpha;

    @Nullable
    private final ColorFilter colorFilter;

    @NotNull
    private final ContentScale contentScale;

    @NotNull
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    public /* synthetic */ PainterModifier(Painter painter, boolean z10, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter, l lVar, int i10, k kVar) {
        this(painter, z10, (i10 & 4) != 0 ? Alignment.Companion.getCenter() : alignment, (i10 & 8) != 0 ? ContentScale.Companion.getInside() : contentScale, (i10 & 16) != 0 ? 1.0f : f10, (i10 & 32) != 0 ? null : colorFilter, lVar);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m1291calculateScaledSizeE7KxVPU(long j10) {
        if (!getUseIntrinsicSize()) {
            return j10;
        }
        long jSize = SizeKt.Size(!m1293hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo2089getIntrinsicSizeNHjbRc()) ? Size.m1436getWidthimpl(j10) : Size.m1436getWidthimpl(this.painter.mo2089getIntrinsicSizeNHjbRc()), !m1292hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo2089getIntrinsicSizeNHjbRc()) ? Size.m1433getHeightimpl(j10) : Size.m1433getHeightimpl(this.painter.mo2089getIntrinsicSizeNHjbRc()));
        if (!(Size.m1436getWidthimpl(j10) == 0.0f)) {
            if (!(Size.m1433getHeightimpl(j10) == 0.0f)) {
                return ScaleFactorKt.m3051timesUQTWf7w(jSize, this.contentScale.mo2978computeScaleFactorH7hwNQA(jSize, j10));
            }
        }
        return Size.Companion.m1445getZeroNHjbRc();
    }

    private final boolean getUseIntrinsicSize() {
        if (this.sizeToIntrinsics) {
            return (this.painter.mo2089getIntrinsicSizeNHjbRc() > Size.Companion.m1444getUnspecifiedNHjbRc() ? 1 : (this.painter.mo2089getIntrinsicSizeNHjbRc() == Size.Companion.m1444getUnspecifiedNHjbRc() ? 0 : -1)) != 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m1292hasSpecifiedAndFiniteHeightuvyYCjk(long j10) {
        if (Size.m1432equalsimpl0(j10, Size.Companion.m1444getUnspecifiedNHjbRc())) {
            return false;
        }
        float fM1433getHeightimpl = Size.m1433getHeightimpl(j10);
        return !Float.isInfinite(fM1433getHeightimpl) && !Float.isNaN(fM1433getHeightimpl);
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m1293hasSpecifiedAndFiniteWidthuvyYCjk(long j10) {
        if (Size.m1432equalsimpl0(j10, Size.Companion.m1444getUnspecifiedNHjbRc())) {
            return false;
        }
        float fM1436getWidthimpl = Size.m1436getWidthimpl(j10);
        return !Float.isInfinite(fM1436getWidthimpl) && !Float.isNaN(fM1436getWidthimpl);
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m1294modifyConstraintsZezNO4M(long j10) {
        boolean z10 = Constraints.m3637getHasBoundedWidthimpl(j10) && Constraints.m3636getHasBoundedHeightimpl(j10);
        boolean z11 = Constraints.m3639getHasFixedWidthimpl(j10) && Constraints.m3638getHasFixedHeightimpl(j10);
        if ((!getUseIntrinsicSize() && z10) || z11) {
            return Constraints.m3632copyZbe2FdA$default(j10, Constraints.m3641getMaxWidthimpl(j10), 0, Constraints.m3640getMaxHeightimpl(j10), 0, 10, null);
        }
        long jMo2089getIntrinsicSizeNHjbRc = this.painter.mo2089getIntrinsicSizeNHjbRc();
        long jM1291calculateScaledSizeE7KxVPU = m1291calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m3655constrainWidthK40F9xA(j10, m1293hasSpecifiedAndFiniteWidthuvyYCjk(jMo2089getIntrinsicSizeNHjbRc) ? c.c(Size.m1436getWidthimpl(jMo2089getIntrinsicSizeNHjbRc)) : Constraints.m3643getMinWidthimpl(j10)), ConstraintsKt.m3654constrainHeightK40F9xA(j10, m1292hasSpecifiedAndFiniteHeightuvyYCjk(jMo2089getIntrinsicSizeNHjbRc) ? c.c(Size.m1433getHeightimpl(jMo2089getIntrinsicSizeNHjbRc)) : Constraints.m3642getMinHeightimpl(j10))));
        return Constraints.m3632copyZbe2FdA$default(j10, ConstraintsKt.m3655constrainWidthK40F9xA(j10, c.c(Size.m1436getWidthimpl(jM1291calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m3654constrainHeightK40F9xA(j10, c.c(Size.m1433getHeightimpl(jM1291calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    @Override // androidx.compose.ui.draw.DrawModifier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(@org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.drawscope.ContentDrawScope r13) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draw.PainterModifier.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }

    public boolean equals(@Nullable Object obj) {
        PainterModifier painterModifier = obj instanceof PainterModifier ? (PainterModifier) obj : null;
        if (painterModifier != null && t.d(this.painter, painterModifier.painter) && this.sizeToIntrinsics == painterModifier.sizeToIntrinsics && t.d(this.alignment, painterModifier.alignment) && t.d(this.contentScale, painterModifier.contentScale)) {
            return ((this.alpha > painterModifier.alpha ? 1 : (this.alpha == painterModifier.alpha ? 0 : -1)) == 0) && t.d(this.colorFilter, painterModifier.colorFilter);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @Nullable
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @NotNull
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @NotNull
    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.painter.hashCode() * 31) + e.a(this.sizeToIntrinsics)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return iHashCode + (colorFilter != null ? colorFilter.hashCode() : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicHeight(i10);
        }
        long jM1294modifyConstraintsZezNO4M = m1294modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i10, 0, 0, 13, null));
        return Math.max(Constraints.m3642getMinHeightimpl(jM1294modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i10));
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicWidth(i10);
        }
        long jM1294modifyConstraintsZezNO4M = m1294modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i10, 7, null));
        return Math.max(Constraints.m3643getMinWidthimpl(jM1294modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i10));
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(m1294modifyConstraintsZezNO4M(j10));
        return MeasureScope.CC.p(measure, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new PainterModifier$measure$1(placeableMo2987measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicHeight(i10);
        }
        long jM1294modifyConstraintsZezNO4M = m1294modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i10, 0, 0, 13, null));
        return Math.max(Constraints.m3642getMinHeightimpl(jM1294modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i10));
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicWidth(i10);
        }
        long jM1294modifyConstraintsZezNO4M = m1294modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i10, 7, null));
        return Math.max(Constraints.m3643getMinWidthimpl(jM1294modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i10));
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PainterModifier(@NotNull Painter painter, boolean z10, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter, @NotNull l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(painter, "painter");
        t.i(alignment, "alignment");
        t.i(contentScale, "contentScale");
        t.i(inspectorInfo, "inspectorInfo");
        this.painter = painter;
        this.sizeToIntrinsics = z10;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f10;
        this.colorFilter = colorFilter;
    }
}
