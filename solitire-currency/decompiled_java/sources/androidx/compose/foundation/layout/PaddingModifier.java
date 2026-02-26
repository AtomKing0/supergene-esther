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
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
final class PaddingModifier extends InspectorValueInfo implements LayoutModifier {
    private final float bottom;
    private final float end;
    private final boolean rtlAware;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingModifier(float f10, float f11, float f12, float f13, boolean z10, h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(f10, f11, f12, f13, z10, lVar);
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
        PaddingModifier paddingModifier = obj instanceof PaddingModifier ? (PaddingModifier) obj : null;
        return paddingModifier != null && Dp.m3678equalsimpl0(this.start, paddingModifier.start) && Dp.m3678equalsimpl0(this.top, paddingModifier.top) && Dp.m3678equalsimpl0(this.end, paddingModifier.end) && Dp.m3678equalsimpl0(this.bottom, paddingModifier.bottom) && this.rtlAware == paddingModifier.rtlAware;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m404getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m405getEndD9Ej5fM() {
        return this.end;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m406getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m407getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((((((Dp.m3679hashCodeimpl(this.start) * 31) + Dp.m3679hashCodeimpl(this.top)) * 31) + Dp.m3679hashCodeimpl(this.end)) * 31) + Dp.m3679hashCodeimpl(this.bottom)) * 31) + androidx.compose.foundation.e.a(this.rtlAware);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.a(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.b(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        int iMo290roundToPx0680j_4 = measure.mo290roundToPx0680j_4(this.start) + measure.mo290roundToPx0680j_4(this.end);
        int iMo290roundToPx0680j_42 = measure.mo290roundToPx0680j_4(this.top) + measure.mo290roundToPx0680j_4(this.bottom);
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(ConstraintsKt.m3657offsetNN6EwU(j10, -iMo290roundToPx0680j_4, -iMo290roundToPx0680j_42));
        return MeasureScope.CC.p(measure, ConstraintsKt.m3655constrainWidthK40F9xA(j10, placeableMo2987measureBRTryo0.getWidth() + iMo290roundToPx0680j_4), ConstraintsKt.m3654constrainHeightK40F9xA(j10, placeableMo2987measureBRTryo0.getHeight() + iMo290roundToPx0680j_42), null, new PaddingModifier$measure$1(this, placeableMo2987measureBRTryo0, measure), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.c(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.d(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    private PaddingModifier(float f10, float f11, float f12, float f13, boolean z10, h9.l<? super InspectorInfo, k0> lVar) {
        super(lVar);
        this.start = f10;
        this.top = f11;
        this.end = f12;
        this.bottom = f13;
        this.rtlAware = z10;
        if (!((f10 >= 0.0f || Dp.m3678equalsimpl0(f10, Dp.Companion.m3693getUnspecifiedD9Ej5fM())) && (f11 >= 0.0f || Dp.m3678equalsimpl0(f11, Dp.Companion.m3693getUnspecifiedD9Ej5fM())) && ((f12 >= 0.0f || Dp.m3678equalsimpl0(f12, Dp.Companion.m3693getUnspecifiedD9Ej5fM())) && (f13 >= 0.0f || Dp.m3678equalsimpl0(f13, Dp.Companion.m3693getUnspecifiedD9Ej5fM()))))) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
    }

    public /* synthetic */ PaddingModifier(float f10, float f11, float f12, float f13, boolean z10, h9.l lVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? Dp.m3673constructorimpl(0) : f10, (i10 & 2) != 0 ? Dp.m3673constructorimpl(0) : f11, (i10 & 4) != 0 ? Dp.m3673constructorimpl(0) : f12, (i10 & 8) != 0 ? Dp.m3673constructorimpl(0) : f13, z10, lVar, null);
    }
}
