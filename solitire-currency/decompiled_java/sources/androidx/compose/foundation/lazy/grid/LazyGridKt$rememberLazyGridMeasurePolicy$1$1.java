package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import h9.l;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: LazyGrid.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends v implements p<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyGridItemProvider $itemProvider;
    final /* synthetic */ OverscrollEffect $overscrollEffect;
    final /* synthetic */ LazyGridItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ p<Density, Constraints, List<Integer>> $slotSizesSums;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGrid.kt */
    static final class AnonymousClass1 extends v implements l<LineIndex, ArrayList<s<? extends Integer, ? extends Constraints>>> {
        final /* synthetic */ LazyMeasuredLineProvider $measuredLineProvider;
        final /* synthetic */ LazyGridSpanLayoutProvider $spanLayoutProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, LazyMeasuredLineProvider lazyMeasuredLineProvider) {
            super(1);
            this.$spanLayoutProvider = lazyGridSpanLayoutProvider;
            this.$measuredLineProvider = lazyMeasuredLineProvider;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ ArrayList<s<? extends Integer, ? extends Constraints>> invoke(LineIndex lineIndex) {
            return m568invokebKFJvoY(lineIndex.m603unboximpl());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-bKFJvoY, reason: not valid java name */
        public final ArrayList<s<Integer, Constraints>> m568invokebKFJvoY(int i10) {
            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.$spanLayoutProvider.getLineConfiguration(i10);
            int iM541constructorimpl = ItemIndex.m541constructorimpl(lineConfiguration.getFirstItemIndex());
            ArrayList<s<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
            List<GridItemSpan> spans = lineConfiguration.getSpans();
            LazyMeasuredLineProvider lazyMeasuredLineProvider = this.$measuredLineProvider;
            int size = spans.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int iM535getCurrentLineSpanimpl = GridItemSpan.m535getCurrentLineSpanimpl(spans.get(i12).m538unboximpl());
                arrayList.add(y.a(Integer.valueOf(iM541constructorimpl), lazyMeasuredLineProvider.getChildConstraints$foundation_release().mo4invoke(Integer.valueOf(i11), Integer.valueOf(iM535getCurrentLineSpanimpl))));
                iM541constructorimpl = ItemIndex.m541constructorimpl(iM541constructorimpl + 1);
                i11 += iM535getCurrentLineSpanimpl;
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGrid.kt */
    static final class AnonymousClass3 extends v implements q<Integer, Integer, l<? super Placeable.PlacementScope, ? extends k0>, MeasureResult> {
        final /* synthetic */ long $containerConstraints;
        final /* synthetic */ LazyLayoutMeasureScope $this_null;
        final /* synthetic */ int $totalHorizontalPadding;
        final /* synthetic */ int $totalVerticalPadding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j10, int i10, int i11) {
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
    /* JADX WARN: Multi-variable type inference failed */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1(boolean z10, PaddingValues paddingValues, boolean z11, LazyGridState lazyGridState, LazyGridItemProvider lazyGridItemProvider, p<? super Density, ? super Constraints, ? extends List<Integer>> pVar, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, OverscrollEffect overscrollEffect) {
        super(2);
        this.$isVertical = z10;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z11;
        this.$state = lazyGridState;
        this.$itemProvider = lazyGridItemProvider;
        this.$slotSizesSums = pVar;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyGridItemPlacementAnimator;
        this.$overscrollEffect = overscrollEffect;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ LazyGridMeasureResult mo4invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
        return m567invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyGridMeasureResult m567invoke0kLqBqw(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, long j10) {
        float fMo353getSpacingD9Ej5fM;
        float fMo353getSpacingD9Ej5fM2;
        long jIntOffset;
        int firstVisibleItemScrollOffset;
        int iM583getLineIndexOfItem_Ze7BM;
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
        LazyGridSpanLayoutProvider spanLayoutProvider = this.$itemProvider.getSpanLayoutProvider();
        final List<Integer> listMo4invoke = this.$slotSizesSums.mo4invoke(lazyLayoutMeasureScope, Constraints.m3629boximpl(j10));
        spanLayoutProvider.setSlotsPerLine(listMo4invoke.size());
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        this.$state.setSlotsPerLine$foundation_release(listMo4invoke.size());
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
        int iMo290roundToPx0680j_45 = lazyLayoutMeasureScope.mo290roundToPx0680j_4(fMo353getSpacingD9Ej5fM);
        if (this.$isVertical) {
            Arrangement.Horizontal horizontal2 = this.$horizontalArrangement;
            fMo353getSpacingD9Ej5fM2 = horizontal2 != null ? horizontal2.mo353getSpacingD9Ej5fM() : Dp.m3673constructorimpl(0);
        } else {
            Arrangement.Vertical vertical2 = this.$verticalArrangement;
            fMo353getSpacingD9Ej5fM2 = vertical2 != null ? vertical2.mo353getSpacingD9Ej5fM() : Dp.m3673constructorimpl(0);
        }
        final int iMo290roundToPx0680j_46 = lazyLayoutMeasureScope.mo290roundToPx0680j_4(fMo353getSpacingD9Ej5fM2);
        int itemCount = this.$itemProvider.getItemCount();
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
        LazyGridItemProvider lazyGridItemProvider = this.$itemProvider;
        final boolean z12 = this.$isVertical;
        final boolean z13 = this.$reverseLayout;
        final LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator = this.$placementAnimator;
        final int i15 = i13;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(lazyGridItemProvider, lazyLayoutMeasureScope, iMo290roundToPx0680j_45, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
            @Override // androidx.compose.foundation.lazy.grid.MeasuredItemFactory
            @NotNull
            /* JADX INFO: renamed from: createItem-PU_OBEw, reason: not valid java name */
            public final LazyMeasuredItem mo569createItemPU_OBEw(int i16, @NotNull Object key, int i17, int i18, @NotNull Placeable[] placeables) {
                t.i(key, "key");
                t.i(placeables, "placeables");
                return new LazyMeasuredItem(i16, key, z12, i17, i18, z13, lazyLayoutMeasureScope.getLayoutDirection(), i15, i14, placeables, lazyGridItemPlacementAnimator, j11, null);
            }
        });
        final boolean z14 = this.$isVertical;
        LazyMeasuredLineProvider lazyMeasuredLineProvider = new LazyMeasuredLineProvider(z14, listMo4invoke, iMo290roundToPx0680j_46, itemCount, iMo290roundToPx0680j_45, lazyMeasuredItemProvider, spanLayoutProvider, new MeasuredLineFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
            @Override // androidx.compose.foundation.lazy.grid.MeasuredLineFactory
            @NotNull
            /* JADX INFO: renamed from: createLine-H9FfpSk, reason: not valid java name */
            public final LazyMeasuredLine mo570createLineH9FfpSk(int i16, @NotNull LazyMeasuredItem[] items, @NotNull List<GridItemSpan> spans, int i17) {
                t.i(items, "items");
                t.i(spans, "spans");
                return new LazyMeasuredLine(i16, items, spans, z14, listMo4invoke.size(), lazyLayoutMeasureScope.getLayoutDirection(), i17, iMo290roundToPx0680j_46, null);
            }
        });
        this.$state.setPrefetchInfoRetriever$foundation_release(new AnonymousClass1(spanLayoutProvider, lazyMeasuredLineProvider));
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.$state;
        Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                if (lazyGridState.getFirstVisibleItemIndex() < itemCount || itemCount <= 0) {
                    int iM583getLineIndexOfItem_Ze7BM2 = spanLayoutProvider.m583getLineIndexOfItem_Ze7BM(lazyGridState.getFirstVisibleItemIndex());
                    firstVisibleItemScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                    iM583getLineIndexOfItem_Ze7BM = iM583getLineIndexOfItem_Ze7BM2;
                } else {
                    iM583getLineIndexOfItem_Ze7BM = spanLayoutProvider.m583getLineIndexOfItem_Ze7BM(itemCount - 1);
                    firstVisibleItemScrollOffset = 0;
                }
                k0 k0Var = k0.f35197a;
                snapshotCreateNonObservableSnapshot.dispose();
                LazyGridMeasureResult lazyGridMeasureResultM571measureLazyGridzIfe3eg = LazyGridMeasureKt.m571measureLazyGridzIfe3eg(itemCount, lazyMeasuredLineProvider, lazyMeasuredItemProvider, iM3640getMaxHeightimpl, listMo4invoke.size(), i13, i14, iM583getLineIndexOfItem_Ze7BM, firstVisibleItemScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), jM3657offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$placementAnimator, new AnonymousClass3(lazyLayoutMeasureScope, j10, i11, i10));
                LazyGridState lazyGridState2 = this.$state;
                OverscrollEffect overscrollEffect = this.$overscrollEffect;
                lazyGridState2.applyMeasureResult$foundation_release(lazyGridMeasureResultM571measureLazyGridzIfe3eg);
                LazyGridKt.refreshOverscrollInfo(overscrollEffect, lazyGridMeasureResultM571measureLazyGridzIfe3eg);
                return lazyGridMeasureResultM571measureLazyGridzIfe3eg;
            } finally {
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
            }
        } catch (Throwable th) {
            snapshotCreateNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
