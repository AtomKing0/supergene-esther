package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import h9.l;
import h9.p;
import h9.q;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyList.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends v implements p<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> {
    final /* synthetic */ LazyListBeyondBoundsInfo $beyondBoundsInfo;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyListItemProvider $itemProvider;
    final /* synthetic */ OverscrollEffect $overscrollEffect;
    final /* synthetic */ LazyListItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyList.kt */
    static final class AnonymousClass2 extends v implements q<Integer, Integer, l<? super Placeable.PlacementScope, ? extends k0>, MeasureResult> {
        final /* synthetic */ long $containerConstraints;
        final /* synthetic */ LazyLayoutMeasureScope $this_null;
        final /* synthetic */ int $totalHorizontalPadding;
        final /* synthetic */ int $totalVerticalPadding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j10, int i10, int i11) {
            super(3);
            this.$this_null = lazyLayoutMeasureScope;
            this.$containerConstraints = j10;
            this.$totalHorizontalPadding = i10;
            this.$totalVerticalPadding = i11;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, l<? super Placeable.PlacementScope, ? extends k0> lVar) {
            return invoke(num.intValue(), num2.intValue(), (l<? super Placeable.PlacementScope, k0>) lVar);
        }

        @NotNull
        public final MeasureResult invoke(int i10, int i11, @NotNull l<? super Placeable.PlacementScope, k0> placement) {
            t.i(placement, "placement");
            return this.$this_null.layout(ConstraintsKt.m3655constrainWidthK40F9xA(this.$containerConstraints, i10 + this.$totalHorizontalPadding), ConstraintsKt.m3654constrainHeightK40F9xA(this.$containerConstraints, i11 + this.$totalVerticalPadding), r0.g(), placement);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(boolean z10, PaddingValues paddingValues, boolean z11, LazyListState lazyListState, LazyListItemProvider lazyListItemProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2, OverscrollEffect overscrollEffect) {
        super(2);
        this.$isVertical = z10;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z11;
        this.$state = lazyListState;
        this.$itemProvider = lazyListItemProvider;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyListItemPlacementAnimator;
        this.$beyondBoundsInfo = lazyListBeyondBoundsInfo;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
        this.$overscrollEffect = overscrollEffect;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ LazyListMeasureResult mo4invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
        return m512invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyListMeasureResult m512invoke0kLqBqw(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, long j10) {
        float fMo353getSpacingD9Ej5fM;
        long jIntOffset;
        t.i(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m181checkScrollableContainerConstraintsK40F9xA(j10, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        int iMo290roundToPx0680j_4 = this.$isVertical ? lazyLayoutMeasureScope.mo290roundToPx0680j_4(this.$contentPadding.mo380calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo290roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int iMo290roundToPx0680j_42 = this.$isVertical ? lazyLayoutMeasureScope.mo290roundToPx0680j_4(this.$contentPadding.mo381calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo290roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int iMo290roundToPx0680j_43 = lazyLayoutMeasureScope.mo290roundToPx0680j_4(this.$contentPadding.mo382calculateTopPaddingD9Ej5fM());
        int iMo290roundToPx0680j_44 = lazyLayoutMeasureScope.mo290roundToPx0680j_4(this.$contentPadding.mo379calculateBottomPaddingD9Ej5fM());
        int i10 = iMo290roundToPx0680j_43 + iMo290roundToPx0680j_44;
        int i11 = iMo290roundToPx0680j_4 + iMo290roundToPx0680j_42;
        boolean z10 = this.$isVertical;
        int i12 = z10 ? i10 : i11;
        int i13 = (!z10 || this.$reverseLayout) ? (z10 && this.$reverseLayout) ? iMo290roundToPx0680j_44 : (z10 || this.$reverseLayout) ? iMo290roundToPx0680j_42 : iMo290roundToPx0680j_4 : iMo290roundToPx0680j_43;
        final int i14 = i12 - i13;
        long jM3657offsetNN6EwU = ConstraintsKt.m3657offsetNN6EwU(j10, -i11, -i10);
        this.$state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.$itemProvider);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        this.$itemProvider.getItemScope().m503setMaxWidth0680j_4(lazyLayoutMeasureScope.mo293toDpu2uoSUM(Constraints.m3641getMaxWidthimpl(jM3657offsetNN6EwU)));
        this.$itemProvider.getItemScope().m502setMaxHeight0680j_4(lazyLayoutMeasureScope.mo293toDpu2uoSUM(Constraints.m3640getMaxHeightimpl(jM3657offsetNN6EwU)));
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            fMo353getSpacingD9Ej5fM = vertical.mo353getSpacingD9Ej5fM();
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            fMo353getSpacingD9Ej5fM = horizontal.mo353getSpacingD9Ej5fM();
        }
        final int iMo290roundToPx0680j_45 = lazyLayoutMeasureScope.mo290roundToPx0680j_4(fMo353getSpacingD9Ej5fM);
        final int itemCount = this.$itemProvider.getItemCount();
        int iM3640getMaxHeightimpl = this.$isVertical ? Constraints.m3640getMaxHeightimpl(j10) - i10 : Constraints.m3641getMaxWidthimpl(j10) - i11;
        if (!this.$reverseLayout || iM3640getMaxHeightimpl > 0) {
            jIntOffset = IntOffsetKt.IntOffset(iMo290roundToPx0680j_4, iMo290roundToPx0680j_43);
        } else {
            boolean z11 = this.$isVertical;
            if (!z11) {
                iMo290roundToPx0680j_4 += iM3640getMaxHeightimpl;
            }
            if (z11) {
                iMo290roundToPx0680j_43 += iM3640getMaxHeightimpl;
            }
            jIntOffset = IntOffsetKt.IntOffset(iMo290roundToPx0680j_4, iMo290roundToPx0680j_43);
        }
        final long j11 = jIntOffset;
        final boolean z12 = this.$isVertical;
        LazyListItemProvider lazyListItemProvider = this.$itemProvider;
        final Alignment.Horizontal horizontal2 = this.$horizontalAlignment;
        final Alignment.Vertical vertical2 = this.$verticalAlignment;
        final boolean z13 = this.$reverseLayout;
        final LazyListItemPlacementAnimator lazyListItemPlacementAnimator = this.$placementAnimator;
        final int i15 = i13;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(jM3657offsetNN6EwU, z12, lazyListItemProvider, lazyLayoutMeasureScope, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
            @Override // androidx.compose.foundation.lazy.MeasuredItemFactory
            @NotNull
            /* JADX INFO: renamed from: createItem-HK0c1C0, reason: not valid java name */
            public final LazyMeasuredItem mo513createItemHK0c1C0(int i16, @NotNull Object key, @NotNull Placeable[] placeables) {
                t.i(key, "key");
                t.i(placeables, "placeables");
                return new LazyMeasuredItem(i16, placeables, z12, horizontal2, vertical2, lazyLayoutMeasureScope.getLayoutDirection(), z13, i15, i14, lazyListItemPlacementAnimator, i16 == itemCount + (-1) ? 0 : iMo290roundToPx0680j_45, j11, key, null);
            }
        }, null);
        this.$state.m525setPremeasureConstraintsBRTryo0$foundation_release(lazyMeasuredItemProvider.m527getChildConstraintsmsEJaDk());
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.$state;
        Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                int iM486constructorimpl = DataIndex.m486constructorimpl(lazyListState.getFirstVisibleItemIndex());
                int firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
                k0 k0Var = k0.f35197a;
                snapshotCreateNonObservableSnapshot.dispose();
                LazyListMeasureResult lazyListMeasureResultM515measureLazyList7Xnphek = LazyListMeasureKt.m515measureLazyList7Xnphek(itemCount, lazyMeasuredItemProvider, iM3640getMaxHeightimpl, i13, i14, iM486constructorimpl, firstVisibleItemScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), jM3657offsetNN6EwU, this.$isVertical, this.$itemProvider.getHeaderIndexes(), this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$placementAnimator, this.$beyondBoundsInfo, new AnonymousClass2(lazyLayoutMeasureScope, j10, i11, i10));
                LazyListState lazyListState2 = this.$state;
                OverscrollEffect overscrollEffect = this.$overscrollEffect;
                lazyListState2.applyMeasureResult$foundation_release(lazyListMeasureResultM515measureLazyList7Xnphek);
                LazyListKt.refreshOverscrollInfo(overscrollEffect, lazyListMeasureResultM515measureLazyList7Xnphek);
                return lazyListMeasureResultM515measureLazyList7Xnphek;
            } finally {
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
            }
        } catch (Throwable th) {
            snapshotCreateNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
