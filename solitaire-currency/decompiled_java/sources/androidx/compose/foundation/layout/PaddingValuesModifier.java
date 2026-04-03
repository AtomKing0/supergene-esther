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
final class PaddingValuesModifier extends InspectorValueInfo implements LayoutModifier {

    @NotNull
    private final PaddingValues paddingValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaddingValuesModifier(@NotNull PaddingValues paddingValues, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(paddingValues, "paddingValues");
        t.i(inspectorInfo, "inspectorInfo");
        this.paddingValues = paddingValues;
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
        PaddingValuesModifier paddingValuesModifier = obj instanceof PaddingValuesModifier ? (PaddingValuesModifier) obj : null;
        if (paddingValuesModifier == null) {
            return false;
        }
        return t.d(this.paddingValues, paddingValuesModifier.paddingValues);
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
    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
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
        boolean z10 = false;
        float f10 = 0;
        if (Dp.m3672compareTo0680j_4(this.paddingValues.mo380calculateLeftPaddingu2uoSUM(measure.getLayoutDirection()), Dp.m3673constructorimpl(f10)) >= 0 && Dp.m3672compareTo0680j_4(this.paddingValues.mo382calculateTopPaddingD9Ej5fM(), Dp.m3673constructorimpl(f10)) >= 0 && Dp.m3672compareTo0680j_4(this.paddingValues.mo381calculateRightPaddingu2uoSUM(measure.getLayoutDirection()), Dp.m3673constructorimpl(f10)) >= 0 && Dp.m3672compareTo0680j_4(this.paddingValues.mo379calculateBottomPaddingD9Ej5fM(), Dp.m3673constructorimpl(f10)) >= 0) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
        int iMo290roundToPx0680j_4 = measure.mo290roundToPx0680j_4(this.paddingValues.mo380calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())) + measure.mo290roundToPx0680j_4(this.paddingValues.mo381calculateRightPaddingu2uoSUM(measure.getLayoutDirection()));
        int iMo290roundToPx0680j_42 = measure.mo290roundToPx0680j_4(this.paddingValues.mo382calculateTopPaddingD9Ej5fM()) + measure.mo290roundToPx0680j_4(this.paddingValues.mo379calculateBottomPaddingD9Ej5fM());
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(ConstraintsKt.m3657offsetNN6EwU(j10, -iMo290roundToPx0680j_4, -iMo290roundToPx0680j_42));
        return MeasureScope.CC.p(measure, ConstraintsKt.m3655constrainWidthK40F9xA(j10, placeableMo2987measureBRTryo0.getWidth() + iMo290roundToPx0680j_4), ConstraintsKt.m3654constrainHeightK40F9xA(j10, placeableMo2987measureBRTryo0.getHeight() + iMo290roundToPx0680j_42), null, new PaddingValuesModifier$measure$2(placeableMo2987measureBRTryo0, measure, this), 4, null);
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
}
