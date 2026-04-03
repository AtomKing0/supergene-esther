package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollingLayoutModifier implements LayoutModifier {
    private final boolean isReversed;
    private final boolean isVertical;

    @NotNull
    private final OverscrollEffect overscrollEffect;

    @NotNull
    private final ScrollState scrollerState;

    public ScrollingLayoutModifier(@NotNull ScrollState scrollerState, boolean z10, boolean z11, @NotNull OverscrollEffect overscrollEffect) {
        t.i(scrollerState, "scrollerState");
        t.i(overscrollEffect, "overscrollEffect");
        this.scrollerState = scrollerState;
        this.isReversed = z10;
        this.isVertical = z11;
        this.overscrollEffect = overscrollEffect;
    }

    public static /* synthetic */ ScrollingLayoutModifier copy$default(ScrollingLayoutModifier scrollingLayoutModifier, ScrollState scrollState, boolean z10, boolean z11, OverscrollEffect overscrollEffect, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            scrollState = scrollingLayoutModifier.scrollerState;
        }
        if ((i10 & 2) != 0) {
            z10 = scrollingLayoutModifier.isReversed;
        }
        if ((i10 & 4) != 0) {
            z11 = scrollingLayoutModifier.isVertical;
        }
        if ((i10 & 8) != 0) {
            overscrollEffect = scrollingLayoutModifier.overscrollEffect;
        }
        return scrollingLayoutModifier.copy(scrollState, z10, z11, overscrollEffect);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @NotNull
    public final ScrollState component1() {
        return this.scrollerState;
    }

    public final boolean component2() {
        return this.isReversed;
    }

    public final boolean component3() {
        return this.isVertical;
    }

    @NotNull
    public final OverscrollEffect component4() {
        return this.overscrollEffect;
    }

    @NotNull
    public final ScrollingLayoutModifier copy(@NotNull ScrollState scrollerState, boolean z10, boolean z11, @NotNull OverscrollEffect overscrollEffect) {
        t.i(scrollerState, "scrollerState");
        t.i(overscrollEffect, "overscrollEffect");
        return new ScrollingLayoutModifier(scrollerState, z10, z11, overscrollEffect);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollingLayoutModifier)) {
            return false;
        }
        ScrollingLayoutModifier scrollingLayoutModifier = (ScrollingLayoutModifier) obj;
        return t.d(this.scrollerState, scrollingLayoutModifier.scrollerState) && this.isReversed == scrollingLayoutModifier.isReversed && this.isVertical == scrollingLayoutModifier.isVertical && t.d(this.overscrollEffect, scrollingLayoutModifier.overscrollEffect);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    @NotNull
    public final ScrollState getScrollerState() {
        return this.scrollerState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.scrollerState.hashCode() * 31;
        boolean z10 = this.isReversed;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int i10 = (iHashCode + r12) * 31;
        boolean z11 = this.isVertical;
        return ((i10 + (z11 ? 1 : z11)) * 31) + this.overscrollEffect.hashCode();
    }

    public final boolean isReversed() {
        return this.isReversed;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return measurable.maxIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return measurable.maxIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        CheckScrollableContainerConstraintsKt.m181checkScrollableContainerConstraintsK40F9xA(j10, this.isVertical ? Orientation.Vertical : Orientation.Horizontal);
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(Constraints.m3632copyZbe2FdA$default(j10, 0, this.isVertical ? Constraints.m3641getMaxWidthimpl(j10) : Integer.MAX_VALUE, 0, this.isVertical ? Integer.MAX_VALUE : Constraints.m3640getMaxHeightimpl(j10), 5, null));
        int iJ = n9.o.j(placeableMo2987measureBRTryo0.getWidth(), Constraints.m3641getMaxWidthimpl(j10));
        int iJ2 = n9.o.j(placeableMo2987measureBRTryo0.getHeight(), Constraints.m3640getMaxHeightimpl(j10));
        int height = placeableMo2987measureBRTryo0.getHeight() - iJ2;
        int width = placeableMo2987measureBRTryo0.getWidth() - iJ;
        if (!this.isVertical) {
            height = width;
        }
        this.overscrollEffect.setEnabled(height != 0);
        return MeasureScope.CC.p(measure, iJ, iJ2, null, new ScrollingLayoutModifier$measure$1(this, height, placeableMo2987measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return measurable.minIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return measurable.minIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "ScrollingLayoutModifier(scrollerState=" + this.scrollerState + ", isReversed=" + this.isReversed + ", isVertical=" + this.isVertical + ", overscrollEffect=" + this.overscrollEffect + ')';
    }
}
