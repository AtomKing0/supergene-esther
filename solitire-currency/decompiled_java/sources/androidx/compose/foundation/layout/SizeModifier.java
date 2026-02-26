package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
final class SizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean enforceIncoming;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeModifier(float f10, float f11, float f12, float f13, boolean z10, h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(f10, f11, f12, f13, z10, lVar);
    }

    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m451getTargetConstraintsOenEA2s(Density density) {
        int iE;
        int iE2;
        float f10 = this.maxWidth;
        Dp.Companion companion = Dp.Companion;
        int i10 = 0;
        int iMo290roundToPx0680j_4 = !Dp.m3678equalsimpl0(f10, companion.m3693getUnspecifiedD9Ej5fM()) ? density.mo290roundToPx0680j_4(((Dp) n9.o.g(Dp.m3671boximpl(this.maxWidth), Dp.m3671boximpl(Dp.m3673constructorimpl(0)))).m3687unboximpl()) : Integer.MAX_VALUE;
        int iMo290roundToPx0680j_42 = !Dp.m3678equalsimpl0(this.maxHeight, companion.m3693getUnspecifiedD9Ej5fM()) ? density.mo290roundToPx0680j_4(((Dp) n9.o.g(Dp.m3671boximpl(this.maxHeight), Dp.m3671boximpl(Dp.m3673constructorimpl(0)))).m3687unboximpl()) : Integer.MAX_VALUE;
        if (Dp.m3678equalsimpl0(this.minWidth, companion.m3693getUnspecifiedD9Ej5fM()) || (iE = n9.o.e(n9.o.j(density.mo290roundToPx0680j_4(this.minWidth), iMo290roundToPx0680j_4), 0)) == Integer.MAX_VALUE) {
            iE = 0;
        }
        if (!Dp.m3678equalsimpl0(this.minHeight, companion.m3693getUnspecifiedD9Ej5fM()) && (iE2 = n9.o.e(n9.o.j(density.mo290roundToPx0680j_4(this.minHeight), iMo290roundToPx0680j_42), 0)) != Integer.MAX_VALUE) {
            i10 = iE2;
        }
        return ConstraintsKt.Constraints(iE, iMo290roundToPx0680j_4, i10, iMo290roundToPx0680j_42);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SizeModifier)) {
            return false;
        }
        SizeModifier sizeModifier = (SizeModifier) obj;
        return Dp.m3678equalsimpl0(this.minWidth, sizeModifier.minWidth) && Dp.m3678equalsimpl0(this.minHeight, sizeModifier.minHeight) && Dp.m3678equalsimpl0(this.maxWidth, sizeModifier.maxWidth) && Dp.m3678equalsimpl0(this.maxHeight, sizeModifier.maxHeight) && this.enforceIncoming == sizeModifier.enforceIncoming;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    public int hashCode() {
        return ((((((Dp.m3679hashCodeimpl(this.minWidth) * 31) + Dp.m3679hashCodeimpl(this.minHeight)) * 31) + Dp.m3679hashCodeimpl(this.maxWidth)) * 31) + Dp.m3679hashCodeimpl(this.maxHeight)) * 31;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        long jM451getTargetConstraintsOenEA2s = m451getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m3638getHasFixedHeightimpl(jM451getTargetConstraintsOenEA2s) ? Constraints.m3640getMaxHeightimpl(jM451getTargetConstraintsOenEA2s) : ConstraintsKt.m3654constrainHeightK40F9xA(jM451getTargetConstraintsOenEA2s, measurable.maxIntrinsicHeight(i10));
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        long jM451getTargetConstraintsOenEA2s = m451getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m3639getHasFixedWidthimpl(jM451getTargetConstraintsOenEA2s) ? Constraints.m3641getMaxWidthimpl(jM451getTargetConstraintsOenEA2s) : ConstraintsKt.m3655constrainWidthK40F9xA(jM451getTargetConstraintsOenEA2s, measurable.maxIntrinsicWidth(i10));
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        long jConstraints;
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        long jM451getTargetConstraintsOenEA2s = m451getTargetConstraintsOenEA2s(measure);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m3653constrainN9IONVI(j10, jM451getTargetConstraintsOenEA2s);
        } else {
            float f10 = this.minWidth;
            Dp.Companion companion = Dp.Companion;
            jConstraints = ConstraintsKt.Constraints(!Dp.m3678equalsimpl0(f10, companion.m3693getUnspecifiedD9Ej5fM()) ? Constraints.m3643getMinWidthimpl(jM451getTargetConstraintsOenEA2s) : n9.o.j(Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(jM451getTargetConstraintsOenEA2s)), !Dp.m3678equalsimpl0(this.maxWidth, companion.m3693getUnspecifiedD9Ej5fM()) ? Constraints.m3641getMaxWidthimpl(jM451getTargetConstraintsOenEA2s) : n9.o.e(Constraints.m3641getMaxWidthimpl(j10), Constraints.m3643getMinWidthimpl(jM451getTargetConstraintsOenEA2s)), !Dp.m3678equalsimpl0(this.minHeight, companion.m3693getUnspecifiedD9Ej5fM()) ? Constraints.m3642getMinHeightimpl(jM451getTargetConstraintsOenEA2s) : n9.o.j(Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(jM451getTargetConstraintsOenEA2s)), !Dp.m3678equalsimpl0(this.maxHeight, companion.m3693getUnspecifiedD9Ej5fM()) ? Constraints.m3640getMaxHeightimpl(jM451getTargetConstraintsOenEA2s) : n9.o.e(Constraints.m3640getMaxHeightimpl(j10), Constraints.m3642getMinHeightimpl(jM451getTargetConstraintsOenEA2s)));
        }
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(jConstraints);
        return MeasureScope.CC.p(measure, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new SizeModifier$measure$1(placeableMo2987measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        long jM451getTargetConstraintsOenEA2s = m451getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m3638getHasFixedHeightimpl(jM451getTargetConstraintsOenEA2s) ? Constraints.m3640getMaxHeightimpl(jM451getTargetConstraintsOenEA2s) : ConstraintsKt.m3654constrainHeightK40F9xA(jM451getTargetConstraintsOenEA2s, measurable.minIntrinsicHeight(i10));
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        long jM451getTargetConstraintsOenEA2s = m451getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m3639getHasFixedWidthimpl(jM451getTargetConstraintsOenEA2s) ? Constraints.m3641getMaxWidthimpl(jM451getTargetConstraintsOenEA2s) : ConstraintsKt.m3655constrainWidthK40F9xA(jM451getTargetConstraintsOenEA2s, measurable.minIntrinsicWidth(i10));
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    public /* synthetic */ SizeModifier(float f10, float f11, float f12, float f13, boolean z10, h9.l lVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? Dp.Companion.m3693getUnspecifiedD9Ej5fM() : f10, (i10 & 2) != 0 ? Dp.Companion.m3693getUnspecifiedD9Ej5fM() : f11, (i10 & 4) != 0 ? Dp.Companion.m3693getUnspecifiedD9Ej5fM() : f12, (i10 & 8) != 0 ? Dp.Companion.m3693getUnspecifiedD9Ej5fM() : f13, z10, lVar, null);
    }

    private SizeModifier(float f10, float f11, float f12, float f13, boolean z10, h9.l<? super InspectorInfo, k0> lVar) {
        super(lVar);
        this.minWidth = f10;
        this.minHeight = f11;
        this.maxWidth = f12;
        this.maxHeight = f13;
        this.enforceIncoming = z10;
    }
}
