package androidx.compose.foundation.lazy;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyListBeyondBoundsInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListBeyondBoundsInfo {

    @NotNull
    private final MutableVector<Interval> beyondBoundsItems = new MutableVector<>(new Interval[16], 0);

    /* JADX INFO: compiled from: LazyListBeyondBoundsInfo.kt */
    public static final class Interval {
        private final int end;
        private final int start;

        public Interval(int i10, int i11) {
            this.start = i10;
            this.end = i11;
            if (!(i10 >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i11 >= i10)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        public static /* synthetic */ Interval copy$default(Interval interval, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = interval.start;
            }
            if ((i12 & 2) != 0) {
                i11 = interval.end;
            }
            return interval.copy(i10, i11);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        @NotNull
        public final Interval copy(int i10, int i11) {
            return new Interval(i10, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.start == interval.start && this.end == interval.end;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (this.start * 31) + this.end;
        }

        @NotNull
        public String toString() {
            return "Interval(start=" + this.start + ", end=" + this.end + ')';
        }
    }

    @NotNull
    public final Interval addInterval(int i10, int i11) {
        Interval interval = new Interval(i10, i11);
        this.beyondBoundsItems.add(interval);
        return interval;
    }

    public final int getEnd() {
        int end = this.beyondBoundsItems.first().getEnd();
        MutableVector<Interval> mutableVector = this.beyondBoundsItems;
        int size = mutableVector.getSize();
        if (size > 0) {
            Interval[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                Interval interval = content[i10];
                if (interval.getEnd() > end) {
                    end = interval.getEnd();
                }
                i10++;
            } while (i10 < size);
        }
        return end;
    }

    public final int getStart() {
        int start = this.beyondBoundsItems.first().getStart();
        MutableVector<Interval> mutableVector = this.beyondBoundsItems;
        int size = mutableVector.getSize();
        if (size > 0) {
            Interval[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                Interval interval = content[i10];
                if (interval.getStart() < start) {
                    start = interval.getStart();
                }
                i10++;
            } while (i10 < size);
        }
        if (start >= 0) {
            return start;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final boolean hasIntervals() {
        return this.beyondBoundsItems.isNotEmpty();
    }

    public final void removeInterval(@NotNull Interval interval) {
        t.i(interval, "interval");
        this.beyondBoundsItems.remove(interval);
    }
}
