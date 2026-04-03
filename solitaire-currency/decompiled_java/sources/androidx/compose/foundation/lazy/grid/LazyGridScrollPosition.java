package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.collections.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyGridScrollPosition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridScrollPosition {

    @NotNull
    private static final Companion Companion = new Companion(null);
    private boolean hadFirstNotEmptyLayout;

    @NotNull
    private final MutableState index$delegate;

    @Nullable
    private Object lastKnownFirstItemKey;

    @NotNull
    private final MutableState scrollOffset$delegate;

    /* JADX INFO: compiled from: LazyGridScrollPosition.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: findLazyGridIndexByKey-Cw5TLFk, reason: not valid java name */
        public final int m582findLazyGridIndexByKeyCw5TLFk(Object obj, int i10, LazyGridItemProvider lazyGridItemProvider) {
            Integer num;
            return obj == null ? i10 : ((i10 >= lazyGridItemProvider.getItemCount() || !t.d(obj, lazyGridItemProvider.getKey(i10))) && (num = lazyGridItemProvider.getKeyToIndexMap().get(obj)) != null) ? ItemIndex.m541constructorimpl(num.intValue()) : i10;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LazyGridScrollPosition() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    /* JADX INFO: renamed from: setIndex-YGsSkvE, reason: not valid java name */
    private final void m577setIndexYGsSkvE(int i10) {
        this.index$delegate.setValue(ItemIndex.m539boximpl(i10));
    }

    private final void setScrollOffset(int i10) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i10));
    }

    /* JADX INFO: renamed from: update-yO3Fmg4, reason: not valid java name */
    private final void m578updateyO3Fmg4(int i10, int i11) {
        if (!(((float) i10) >= 0.0f)) {
            throw new IllegalArgumentException(("Index should be non-negative (" + i10 + ')').toString());
        }
        if (!ItemIndex.m544equalsimpl0(i10, m579getIndexVZbfaAc())) {
            m577setIndexYGsSkvE(i10);
        }
        if (i11 != getScrollOffset()) {
            setScrollOffset(i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getIndex-VZbfaAc, reason: not valid java name */
    public final int m579getIndexVZbfaAc() {
        return ((ItemIndex) this.index$delegate.getValue()).m551unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    /* JADX INFO: renamed from: requestPosition-yO3Fmg4, reason: not valid java name */
    public final void m580requestPositionyO3Fmg4(int i10, int i11) {
        m578updateyO3Fmg4(i10, i11);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateFromMeasureResult(@NotNull LazyGridMeasureResult measureResult) {
        LazyMeasuredItem[] items;
        LazyMeasuredItem lazyMeasuredItem;
        LazyMeasuredItem[] items2;
        LazyMeasuredItem lazyMeasuredItem2;
        t.i(measureResult, "measureResult");
        LazyMeasuredLine firstVisibleLine = measureResult.getFirstVisibleLine();
        this.lastKnownFirstItemKey = (firstVisibleLine == null || (items2 = firstVisibleLine.getItems()) == null || (lazyMeasuredItem2 = (LazyMeasuredItem) p.O(items2)) == null) ? null : lazyMeasuredItem2.getKey();
        if (this.hadFirstNotEmptyLayout || measureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleLineScrollOffset = measureResult.getFirstVisibleLineScrollOffset();
            int iM585getIndexVZbfaAc = 0;
            if (!(((float) firstVisibleLineScrollOffset) >= 0.0f)) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleLineScrollOffset + ')').toString());
            }
            Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    LazyMeasuredLine firstVisibleLine2 = measureResult.getFirstVisibleLine();
                    if (firstVisibleLine2 != null && (items = firstVisibleLine2.getItems()) != null && (lazyMeasuredItem = (LazyMeasuredItem) p.O(items)) != null) {
                        iM585getIndexVZbfaAc = lazyMeasuredItem.m585getIndexVZbfaAc();
                    }
                    m578updateyO3Fmg4(ItemIndex.m541constructorimpl(iM585getIndexVZbfaAc), firstVisibleLineScrollOffset);
                    k0 k0Var = k0.f35197a;
                } finally {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } finally {
                snapshotCreateNonObservableSnapshot.dispose();
            }
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved(@NotNull LazyGridItemProvider itemProvider) {
        t.i(itemProvider, "itemProvider");
        Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                m578updateyO3Fmg4(Companion.m582findLazyGridIndexByKeyCw5TLFk(this.lastKnownFirstItemKey, m579getIndexVZbfaAc(), itemProvider), getScrollOffset());
                k0 k0Var = k0.f35197a;
            } finally {
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
            }
        } finally {
            snapshotCreateNonObservableSnapshot.dispose();
        }
    }

    public LazyGridScrollPosition(int i10, int i11) {
        this.index$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ItemIndex.m539boximpl(ItemIndex.m541constructorimpl(i10)), null, 2, null);
        this.scrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i11), null, 2, null);
    }

    public /* synthetic */ LazyGridScrollPosition(int i10, int i11, int i12, k kVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11);
    }
}
