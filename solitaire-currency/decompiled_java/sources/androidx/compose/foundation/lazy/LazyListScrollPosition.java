package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyListScrollPosition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListScrollPosition {

    @NotNull
    private static final Companion Companion = new Companion(null);
    private boolean hadFirstNotEmptyLayout;

    @NotNull
    private final MutableState index$delegate;

    @Nullable
    private Object lastKnownFirstItemKey;

    @NotNull
    private final MutableState scrollOffset$delegate;

    /* JADX INFO: compiled from: LazyListScrollPosition.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @ExperimentalFoundationApi
        /* JADX INFO: renamed from: findLazyListIndexByKey-KXnL5Ic, reason: not valid java name */
        public final int m523findLazyListIndexByKeyKXnL5Ic(Object obj, int i10, LazyListItemProvider lazyListItemProvider) {
            Integer num;
            return obj == null ? i10 : ((i10 >= lazyListItemProvider.getItemCount() || !t.d(obj, lazyListItemProvider.getKey(i10))) && (num = lazyListItemProvider.getKeyToIndexMap().get(obj)) != null) ? DataIndex.m486constructorimpl(num.intValue()) : i10;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LazyListScrollPosition() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    private final void setScrollOffset(int i10) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i10));
    }

    /* JADX INFO: renamed from: update-AhXoVpI, reason: not valid java name */
    private final void m518updateAhXoVpI(int i10, int i11) {
        if (!(((float) i10) >= 0.0f)) {
            throw new IllegalArgumentException(("Index should be non-negative (" + i10 + ')').toString());
        }
        if (!DataIndex.m489equalsimpl0(i10, m519getIndexjQJCoq8())) {
            m521setIndexZjPyQlc(i10);
        }
        if (i11 != getScrollOffset()) {
            setScrollOffset(i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getIndex-jQJCoq8, reason: not valid java name */
    public final int m519getIndexjQJCoq8() {
        return ((DataIndex) this.index$delegate.getValue()).m496unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    /* JADX INFO: renamed from: requestPosition-AhXoVpI, reason: not valid java name */
    public final void m520requestPositionAhXoVpI(int i10, int i11) {
        m518updateAhXoVpI(i10, i11);
        this.lastKnownFirstItemKey = null;
    }

    /* JADX INFO: renamed from: setIndex-ZjPyQlc, reason: not valid java name */
    public final void m521setIndexZjPyQlc(int i10) {
        this.index$delegate.setValue(DataIndex.m484boximpl(i10));
    }

    public final void updateFromMeasureResult(@NotNull LazyListMeasureResult measureResult) {
        t.i(measureResult, "measureResult");
        LazyMeasuredItem firstVisibleItem = measureResult.getFirstVisibleItem();
        this.lastKnownFirstItemKey = firstVisibleItem != null ? firstVisibleItem.getKey() : null;
        if (this.hadFirstNotEmptyLayout || measureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleItemScrollOffset = measureResult.getFirstVisibleItemScrollOffset();
            if (!(((float) firstVisibleItemScrollOffset) >= 0.0f)) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleItemScrollOffset + ')').toString());
            }
            Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    LazyMeasuredItem firstVisibleItem2 = measureResult.getFirstVisibleItem();
                    m518updateAhXoVpI(DataIndex.m486constructorimpl(firstVisibleItem2 != null ? firstVisibleItem2.getIndex() : 0), firstVisibleItemScrollOffset);
                    k0 k0Var = k0.f35197a;
                } finally {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } finally {
                snapshotCreateNonObservableSnapshot.dispose();
            }
        }
    }

    @ExperimentalFoundationApi
    public final void updateScrollPositionIfTheFirstItemWasMoved(@NotNull LazyListItemProvider itemProvider) {
        t.i(itemProvider, "itemProvider");
        Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                m518updateAhXoVpI(Companion.m523findLazyListIndexByKeyKXnL5Ic(this.lastKnownFirstItemKey, m519getIndexjQJCoq8(), itemProvider), getScrollOffset());
                k0 k0Var = k0.f35197a;
            } finally {
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
            }
        } finally {
            snapshotCreateNonObservableSnapshot.dispose();
        }
    }

    public LazyListScrollPosition(int i10, int i11) {
        this.index$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DataIndex.m484boximpl(DataIndex.m486constructorimpl(i10)), null, 2, null);
        this.scrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i11), null, 2, null);
    }

    public /* synthetic */ LazyListScrollPosition(int i10, int i11, int i12, k kVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11);
    }
}
