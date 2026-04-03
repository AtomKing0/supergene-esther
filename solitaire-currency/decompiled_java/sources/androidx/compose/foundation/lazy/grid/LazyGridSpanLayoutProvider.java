package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridSpanLayoutProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridSpanLayoutProvider {

    @NotNull
    private final ArrayList<Bucket> buckets;

    @NotNull
    private final List<Integer> cachedBucket;
    private int cachedBucketIndex;

    @NotNull
    private final LazyGridItemsSnapshot itemsSnapshot;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;

    @NotNull
    private List<GridItemSpan> previousDefaultSpans;
    private int slotsPerLine;

    /* JADX INFO: compiled from: LazyGridSpanLayoutProvider.kt */
    private static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {

        @NotNull
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxCurrentLineSpan(int i10) {
            maxCurrentLineSpan = i10;
        }

        public void setMaxLineSpan(int i10) {
            maxLineSpan = i10;
        }
    }

    /* JADX INFO: compiled from: LazyGridSpanLayoutProvider.kt */
    @StabilityInferred(parameters = 0)
    public static final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;

        @NotNull
        private final List<GridItemSpan> spans;

        public LineConfiguration(int i10, @NotNull List<GridItemSpan> spans) {
            t.i(spans, "spans");
            this.firstItemIndex = i10;
            this.spans = spans;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        @NotNull
        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }
    }

    public LazyGridSpanLayoutProvider(@NotNull LazyGridItemsSnapshot itemsSnapshot) {
        t.i(itemsSnapshot, "itemsSnapshot");
        this.itemsSnapshot = itemsSnapshot;
        ArrayList<Bucket> arrayList = new ArrayList<>();
        int i10 = 0;
        arrayList.add(new Bucket(i10, i10, 2, null));
        this.buckets = arrayList;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = v.l();
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.slotsPerLine))) + 1;
    }

    private final List<GridItemSpan> getDefaultSpans(int i10) {
        if (i10 == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(GridItemSpan.m531boximpl(LazyGridSpanKt.GridItemSpan(1)));
        }
        this.previousDefaultSpans = arrayList;
        return arrayList;
    }

    private final void invalidateCache() {
        this.buckets.clear();
        int i10 = 0;
        this.buckets.add(new Bucket(i10, i10, 2, null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    private final int spanOf(int i10, int i11) {
        LazyGridItemsSnapshot lazyGridItemsSnapshot = this.itemsSnapshot;
        LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = LazyGridItemSpanScopeImpl.INSTANCE;
        lazyGridItemSpanScopeImpl.setMaxCurrentLineSpan(i11);
        lazyGridItemSpanScopeImpl.setMaxLineSpan(this.slotsPerLine);
        return o.n(GridItemSpan.m535getCurrentLineSpanimpl(lazyGridItemsSnapshot.m566getSpan_orMbw(lazyGridItemSpanScopeImpl, i10)), 1, this.slotsPerLine);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LineConfiguration getLineConfiguration(int r12) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.getLineConfiguration(int):androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration");
    }

    /* JADX INFO: renamed from: getLineIndexOfItem--_Ze7BM, reason: not valid java name */
    public final int m583getLineIndexOfItem_Ze7BM(int i10) {
        int i11 = 0;
        if (getTotalSize() <= 0) {
            return LineIndex.m593constructorimpl(0);
        }
        if (!(i10 < getTotalSize())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!this.itemsSnapshot.getHasCustomSpans()) {
            return LineIndex.m593constructorimpl(i10 / this.slotsPerLine);
        }
        int iJ = v.j(this.buckets, 0, 0, new LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1(i10), 3, null);
        int i12 = 2;
        if (iJ < 0) {
            iJ = (-iJ) - 2;
        }
        int bucketSize = getBucketSize() * iJ;
        int firstItemIndex = this.buckets.get(iJ).getFirstItemIndex();
        if (!(firstItemIndex <= i10)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i13 = 0;
        while (firstItemIndex < i10) {
            int i14 = firstItemIndex + 1;
            int iSpanOf = spanOf(firstItemIndex, this.slotsPerLine - i13);
            i13 += iSpanOf;
            int i15 = this.slotsPerLine;
            if (i13 >= i15) {
                if (i13 == i15) {
                    bucketSize++;
                    i13 = 0;
                } else {
                    bucketSize++;
                    i13 = iSpanOf;
                }
            }
            if (bucketSize % getBucketSize() == 0 && bucketSize / getBucketSize() >= this.buckets.size()) {
                this.buckets.add(new Bucket(i14 - (i13 > 0 ? 1 : 0), i11, i12, null));
            }
            firstItemIndex = i14;
        }
        if (i13 + spanOf(i10, this.slotsPerLine - i13) > this.slotsPerLine) {
            bucketSize++;
        }
        return LineIndex.m593constructorimpl(bucketSize);
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final int getTotalSize() {
        return this.itemsSnapshot.getItemsCount();
    }

    public final void setSlotsPerLine(int i10) {
        if (i10 != this.slotsPerLine) {
            this.slotsPerLine = i10;
            invalidateCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: LazyGridSpanLayoutProvider.kt */
    static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public Bucket(int i10, int i11) {
            this.firstItemIndex = i10;
            this.firstItemKnownSpan = i11;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }

        public /* synthetic */ Bucket(int i10, int i11, int i12, k kVar) {
            this(i10, (i12 & 2) != 0 ? 0 : i11);
        }
    }
}
