package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.internal.StabilityInferred;
import h9.l;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: IntervalList.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface IntervalList<T> {

    /* JADX INFO: compiled from: IntervalList.kt */
    @StabilityInferred(parameters = 1)
    public static final class Interval<T> {
        public static final int $stable = 0;
        private final int size;
        private final int startIndex;
        private final T value;

        public Interval(int i10, int i11, T t10) {
            this.startIndex = i10;
            this.size = i11;
            this.value = t10;
            if (!(i10 >= 0)) {
                throw new IllegalArgumentException(("startIndex should be >= 0, but was " + i10).toString());
            }
            if (i11 > 0) {
                return;
            }
            throw new IllegalArgumentException(("size should be >0, but was " + i11).toString());
        }

        public final int getSize() {
            return this.size;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final T getValue() {
            return this.value;
        }
    }

    void forEach(int i10, int i11, @NotNull l<? super Interval<T>, k0> lVar);

    @NotNull
    Interval<T> get(int i10);

    int getSize();
}
