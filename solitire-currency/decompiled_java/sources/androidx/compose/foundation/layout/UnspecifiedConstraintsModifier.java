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
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
final class UnspecifiedConstraintsModifier extends InspectorValueInfo implements LayoutModifier {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsModifier(float f10, float f11, h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(f10, f11, lVar);
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
        if (!(obj instanceof UnspecifiedConstraintsModifier)) {
            return false;
        }
        UnspecifiedConstraintsModifier unspecifiedConstraintsModifier = (UnspecifiedConstraintsModifier) obj;
        return Dp.m3678equalsimpl0(this.minWidth, unspecifiedConstraintsModifier.minWidth) && Dp.m3678equalsimpl0(this.minHeight, unspecifiedConstraintsModifier.minHeight);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m452getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m453getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    public int hashCode() {
        return (Dp.m3679hashCodeimpl(this.minWidth) * 31) + Dp.m3679hashCodeimpl(this.minHeight);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return n9.o.e(measurable.maxIntrinsicHeight(i10), !Dp.m3678equalsimpl0(this.minHeight, Dp.Companion.m3693getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo290roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return n9.o.e(measurable.maxIntrinsicWidth(i10), !Dp.m3678equalsimpl0(this.minWidth, Dp.Companion.m3693getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo290roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        float f10 = this.minWidth;
        Dp.Companion companion = Dp.Companion;
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(ConstraintsKt.Constraints((Dp.m3678equalsimpl0(f10, companion.m3693getUnspecifiedD9Ej5fM()) || Constraints.m3643getMinWidthimpl(j10) != 0) ? Constraints.m3643getMinWidthimpl(j10) : n9.o.e(n9.o.j(measure.mo290roundToPx0680j_4(this.minWidth), Constraints.m3641getMaxWidthimpl(j10)), 0), Constraints.m3641getMaxWidthimpl(j10), (Dp.m3678equalsimpl0(this.minHeight, companion.m3693getUnspecifiedD9Ej5fM()) || Constraints.m3642getMinHeightimpl(j10) != 0) ? Constraints.m3642getMinHeightimpl(j10) : n9.o.e(n9.o.j(measure.mo290roundToPx0680j_4(this.minHeight), Constraints.m3640getMaxHeightimpl(j10)), 0), Constraints.m3640getMaxHeightimpl(j10)));
        return MeasureScope.CC.p(measure, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new UnspecifiedConstraintsModifier$measure$1(placeableMo2987measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return n9.o.e(measurable.minIntrinsicHeight(i10), !Dp.m3678equalsimpl0(this.minHeight, Dp.Companion.m3693getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo290roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return n9.o.e(measurable.minIntrinsicWidth(i10), !Dp.m3678equalsimpl0(this.minWidth, Dp.Companion.m3693getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo290roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    public /* synthetic */ UnspecifiedConstraintsModifier(float f10, float f11, h9.l lVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? Dp.Companion.m3693getUnspecifiedD9Ej5fM() : f10, (i10 & 2) != 0 ? Dp.Companion.m3693getUnspecifiedD9Ej5fM() : f11, lVar, null);
    }

    private UnspecifiedConstraintsModifier(float f10, float f11, h9.l<? super InspectorInfo, k0> lVar) {
        super(lVar);
        this.minWidth = f10;
        this.minHeight = f11;
    }
}
