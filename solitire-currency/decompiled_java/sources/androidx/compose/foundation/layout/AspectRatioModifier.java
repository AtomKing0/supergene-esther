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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AspectRatio.kt */
/* JADX INFO: loaded from: classes.dex */
final class AspectRatioModifier extends InspectorValueInfo implements LayoutModifier {
    private final float aspectRatio;
    private final boolean matchHeightConstraintsFirst;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AspectRatioModifier(float f10, boolean z10, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(inspectorInfo, "inspectorInfo");
        this.aspectRatio = f10;
        this.matchHeightConstraintsFirst = z10;
        if (f10 > 0.0f) {
            return;
        }
        throw new IllegalArgumentException(("aspectRatio " + f10 + " must be > 0").toString());
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m361findSizeToXhtMw(long j10) {
        if (this.matchHeightConstraintsFirst) {
            long jM363tryMaxHeightJN0ABg$default = m363tryMaxHeightJN0ABg$default(this, j10, false, 1, null);
            IntSize.Companion companion = IntSize.Companion;
            if (!IntSize.m3831equalsimpl0(jM363tryMaxHeightJN0ABg$default, companion.m3838getZeroYbymL2g())) {
                return jM363tryMaxHeightJN0ABg$default;
            }
            long jM365tryMaxWidthJN0ABg$default = m365tryMaxWidthJN0ABg$default(this, j10, false, 1, null);
            if (!IntSize.m3831equalsimpl0(jM365tryMaxWidthJN0ABg$default, companion.m3838getZeroYbymL2g())) {
                return jM365tryMaxWidthJN0ABg$default;
            }
            long jM367tryMinHeightJN0ABg$default = m367tryMinHeightJN0ABg$default(this, j10, false, 1, null);
            if (!IntSize.m3831equalsimpl0(jM367tryMinHeightJN0ABg$default, companion.m3838getZeroYbymL2g())) {
                return jM367tryMinHeightJN0ABg$default;
            }
            long jM369tryMinWidthJN0ABg$default = m369tryMinWidthJN0ABg$default(this, j10, false, 1, null);
            if (!IntSize.m3831equalsimpl0(jM369tryMinWidthJN0ABg$default, companion.m3838getZeroYbymL2g())) {
                return jM369tryMinWidthJN0ABg$default;
            }
            long jM362tryMaxHeightJN0ABg = m362tryMaxHeightJN0ABg(j10, false);
            if (!IntSize.m3831equalsimpl0(jM362tryMaxHeightJN0ABg, companion.m3838getZeroYbymL2g())) {
                return jM362tryMaxHeightJN0ABg;
            }
            long jM364tryMaxWidthJN0ABg = m364tryMaxWidthJN0ABg(j10, false);
            if (!IntSize.m3831equalsimpl0(jM364tryMaxWidthJN0ABg, companion.m3838getZeroYbymL2g())) {
                return jM364tryMaxWidthJN0ABg;
            }
            long jM366tryMinHeightJN0ABg = m366tryMinHeightJN0ABg(j10, false);
            if (!IntSize.m3831equalsimpl0(jM366tryMinHeightJN0ABg, companion.m3838getZeroYbymL2g())) {
                return jM366tryMinHeightJN0ABg;
            }
            long jM368tryMinWidthJN0ABg = m368tryMinWidthJN0ABg(j10, false);
            if (!IntSize.m3831equalsimpl0(jM368tryMinWidthJN0ABg, companion.m3838getZeroYbymL2g())) {
                return jM368tryMinWidthJN0ABg;
            }
        } else {
            long jM365tryMaxWidthJN0ABg$default2 = m365tryMaxWidthJN0ABg$default(this, j10, false, 1, null);
            IntSize.Companion companion2 = IntSize.Companion;
            if (!IntSize.m3831equalsimpl0(jM365tryMaxWidthJN0ABg$default2, companion2.m3838getZeroYbymL2g())) {
                return jM365tryMaxWidthJN0ABg$default2;
            }
            long jM363tryMaxHeightJN0ABg$default2 = m363tryMaxHeightJN0ABg$default(this, j10, false, 1, null);
            if (!IntSize.m3831equalsimpl0(jM363tryMaxHeightJN0ABg$default2, companion2.m3838getZeroYbymL2g())) {
                return jM363tryMaxHeightJN0ABg$default2;
            }
            long jM369tryMinWidthJN0ABg$default2 = m369tryMinWidthJN0ABg$default(this, j10, false, 1, null);
            if (!IntSize.m3831equalsimpl0(jM369tryMinWidthJN0ABg$default2, companion2.m3838getZeroYbymL2g())) {
                return jM369tryMinWidthJN0ABg$default2;
            }
            long jM367tryMinHeightJN0ABg$default2 = m367tryMinHeightJN0ABg$default(this, j10, false, 1, null);
            if (!IntSize.m3831equalsimpl0(jM367tryMinHeightJN0ABg$default2, companion2.m3838getZeroYbymL2g())) {
                return jM367tryMinHeightJN0ABg$default2;
            }
            long jM364tryMaxWidthJN0ABg2 = m364tryMaxWidthJN0ABg(j10, false);
            if (!IntSize.m3831equalsimpl0(jM364tryMaxWidthJN0ABg2, companion2.m3838getZeroYbymL2g())) {
                return jM364tryMaxWidthJN0ABg2;
            }
            long jM362tryMaxHeightJN0ABg2 = m362tryMaxHeightJN0ABg(j10, false);
            if (!IntSize.m3831equalsimpl0(jM362tryMaxHeightJN0ABg2, companion2.m3838getZeroYbymL2g())) {
                return jM362tryMaxHeightJN0ABg2;
            }
            long jM368tryMinWidthJN0ABg2 = m368tryMinWidthJN0ABg(j10, false);
            if (!IntSize.m3831equalsimpl0(jM368tryMinWidthJN0ABg2, companion2.m3838getZeroYbymL2g())) {
                return jM368tryMinWidthJN0ABg2;
            }
            long jM366tryMinHeightJN0ABg2 = m366tryMinHeightJN0ABg(j10, false);
            if (!IntSize.m3831equalsimpl0(jM366tryMinHeightJN0ABg2, companion2.m3838getZeroYbymL2g())) {
                return jM366tryMinHeightJN0ABg2;
            }
        }
        return IntSize.Companion.m3838getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m362tryMaxHeightJN0ABg(long j10, boolean z10) {
        int iC;
        int iM3640getMaxHeightimpl = Constraints.m3640getMaxHeightimpl(j10);
        if (iM3640getMaxHeightimpl != Integer.MAX_VALUE && (iC = j9.c.c(iM3640getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iC, iM3640getMaxHeightimpl);
            if (!z10 || ConstraintsKt.m3656isSatisfiedBy4WqzIAM(j10, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m3838getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m363tryMaxHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return aspectRatioModifier.m362tryMaxHeightJN0ABg(j10, z10);
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m364tryMaxWidthJN0ABg(long j10, boolean z10) {
        int iC;
        int iM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(j10);
        if (iM3641getMaxWidthimpl != Integer.MAX_VALUE && (iC = j9.c.c(iM3641getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM3641getMaxWidthimpl, iC);
            if (!z10 || ConstraintsKt.m3656isSatisfiedBy4WqzIAM(j10, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m3838getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m365tryMaxWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return aspectRatioModifier.m364tryMaxWidthJN0ABg(j10, z10);
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m366tryMinHeightJN0ABg(long j10, boolean z10) {
        int iM3642getMinHeightimpl = Constraints.m3642getMinHeightimpl(j10);
        int iC = j9.c.c(iM3642getMinHeightimpl * this.aspectRatio);
        if (iC > 0) {
            long jIntSize = IntSizeKt.IntSize(iC, iM3642getMinHeightimpl);
            if (!z10 || ConstraintsKt.m3656isSatisfiedBy4WqzIAM(j10, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m3838getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m367tryMinHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return aspectRatioModifier.m366tryMinHeightJN0ABg(j10, z10);
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m368tryMinWidthJN0ABg(long j10, boolean z10) {
        int iM3643getMinWidthimpl = Constraints.m3643getMinWidthimpl(j10);
        int iC = j9.c.c(iM3643getMinWidthimpl / this.aspectRatio);
        if (iC > 0) {
            long jIntSize = IntSizeKt.IntSize(iM3643getMinWidthimpl, iC);
            if (!z10 || ConstraintsKt.m3656isSatisfiedBy4WqzIAM(j10, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m3838getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m369tryMinWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return aspectRatioModifier.m368tryMinWidthJN0ABg(j10, z10);
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
        if (this == obj) {
            return true;
        }
        AspectRatioModifier aspectRatioModifier = obj instanceof AspectRatioModifier ? (AspectRatioModifier) obj : null;
        if (aspectRatioModifier == null) {
            return false;
        }
        return ((this.aspectRatio > aspectRatioModifier.aspectRatio ? 1 : (this.aspectRatio == aspectRatioModifier.aspectRatio ? 0 : -1)) == 0) && this.matchHeightConstraintsFirst == ((AspectRatioModifier) obj).matchHeightConstraintsFirst;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.aspectRatio) * 31) + androidx.compose.foundation.e.a(this.matchHeightConstraintsFirst);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return i10 != Integer.MAX_VALUE ? j9.c.c(i10 / this.aspectRatio) : measurable.maxIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return i10 != Integer.MAX_VALUE ? j9.c.c(i10 * this.aspectRatio) : measurable.maxIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        long jM361findSizeToXhtMw = m361findSizeToXhtMw(j10);
        if (!IntSize.m3831equalsimpl0(jM361findSizeToXhtMw, IntSize.Companion.m3838getZeroYbymL2g())) {
            j10 = Constraints.Companion.m3649fixedJhjzzOo(IntSize.m3833getWidthimpl(jM361findSizeToXhtMw), IntSize.m3832getHeightimpl(jM361findSizeToXhtMw));
        }
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
        return MeasureScope.CC.p(measure, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new AspectRatioModifier$measure$1(placeableMo2987measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return i10 != Integer.MAX_VALUE ? j9.c.c(i10 / this.aspectRatio) : measurable.minIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return i10 != Integer.MAX_VALUE ? j9.c.c(i10 * this.aspectRatio) : measurable.minIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "AspectRatioModifier(aspectRatio=" + this.aspectRatio + ')';
    }
}
