package androidx.compose.material;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.a;
import androidx.compose.ui.b;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.c;
import androidx.compose.ui.unit.DpSize;
import h9.l;
import h9.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TouchTarget.kt */
/* JADX INFO: loaded from: classes.dex */
final class MinimumTouchTargetModifier implements LayoutModifier {
    private final long size;

    public /* synthetic */ MinimumTouchTargetModifier(long j10, k kVar) {
        this(j10);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        MinimumTouchTargetModifier minimumTouchTargetModifier = obj instanceof MinimumTouchTargetModifier ? (MinimumTouchTargetModifier) obj : null;
        if (minimumTouchTargetModifier == null) {
            return false;
        }
        return DpSize.m3768equalsimpl0(this.size, minimumTouchTargetModifier.size);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return b.d(this, obj, pVar);
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ, reason: not valid java name */
    public final long m1062getSizeMYxV2XQ() {
        return this.size;
    }

    public int hashCode() {
        return DpSize.m3773hashCodeimpl(this.size);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return c.a(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return c.b(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
        int iMax = Math.max(placeableMo2987measureBRTryo0.getWidth(), measure.mo290roundToPx0680j_4(DpSize.m3771getWidthD9Ej5fM(this.size)));
        int iMax2 = Math.max(placeableMo2987measureBRTryo0.getHeight(), measure.mo290roundToPx0680j_4(DpSize.m3769getHeightD9Ej5fM(this.size)));
        return MeasureScope.CC.p(measure, iMax, iMax2, null, new MinimumTouchTargetModifier$measure$1(iMax, placeableMo2987measureBRTryo0, iMax2), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return c.c(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return c.d(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    private MinimumTouchTargetModifier(long j10) {
        this.size = j10;
    }
}
