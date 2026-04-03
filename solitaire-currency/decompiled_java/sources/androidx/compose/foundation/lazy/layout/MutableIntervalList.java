package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: IntervalList.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
public final class MutableIntervalList<T> implements IntervalList<T> {
    public static final int $stable = 8;

    @NotNull
    private final MutableVector<IntervalList.Interval<T>> intervals = new MutableVector<>(new IntervalList.Interval[16], 0);

    @Nullable
    private IntervalList.Interval<T> lastInterval;
    private int size;

    private final void checkIndexBounds(int i10) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < getSize()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i10 + ", size " + getSize());
    }

    private final boolean contains(IntervalList.Interval<T> interval, int i10) {
        return i10 < interval.getStartIndex() + interval.getSize() && interval.getStartIndex() <= i10;
    }

    private final IntervalList.Interval<T> getIntervalForIndex(int i10) {
        IntervalList.Interval<T> interval = this.lastInterval;
        if (interval != null && contains(interval, i10)) {
            return interval;
        }
        MutableVector<IntervalList.Interval<T>> mutableVector = this.intervals;
        IntervalList.Interval<T> interval2 = mutableVector.getContent()[IntervalListKt.binarySearch(mutableVector, i10)];
        this.lastInterval = interval2;
        return interval2;
    }

    public final void addInterval(int i10, T t10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("size should be >=0, but was " + i10).toString());
        }
        if (i10 == 0) {
            return;
        }
        IntervalList.Interval<T> interval = new IntervalList.Interval<>(getSize(), i10, t10);
        this.size = getSize() + i10;
        this.intervals.add(interval);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public void forEach(int i10, int i11, @NotNull l<? super IntervalList.Interval<T>, k0> block) {
        t.i(block, "block");
        checkIndexBounds(i10);
        checkIndexBounds(i11);
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("toIndex (" + i11 + ") should be not smaller than fromIndex (" + i10 + ')').toString());
        }
        int iBinarySearch = IntervalListKt.binarySearch(this.intervals, i10);
        int startIndex = this.intervals.getContent()[iBinarySearch].getStartIndex();
        while (startIndex <= i11) {
            IntervalList.Interval<T> interval = this.intervals.getContent()[iBinarySearch];
            block.invoke(interval);
            startIndex += interval.getSize();
            iBinarySearch++;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    @NotNull
    public IntervalList.Interval<T> get(int i10) {
        checkIndexBounds(i10);
        return getIntervalForIndex(i10);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public int getSize() {
        return this.size;
    }
}
