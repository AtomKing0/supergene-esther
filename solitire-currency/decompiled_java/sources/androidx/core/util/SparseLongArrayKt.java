package androidx.core.util;

import android.util.SparseLongArray;
import h9.p;
import kotlin.collections.l0;
import kotlin.collections.m0;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SparseLongArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseLongArrayKt {
    public static final boolean contains(@NotNull SparseLongArray sparseLongArray, int i10) {
        return sparseLongArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsKey(@NotNull SparseLongArray sparseLongArray, int i10) {
        return sparseLongArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsValue(@NotNull SparseLongArray sparseLongArray, long j10) {
        return sparseLongArray.indexOfValue(j10) >= 0;
    }

    public static final void forEach(@NotNull SparseLongArray sparseLongArray, @NotNull p<? super Integer, ? super Long, k0> pVar) {
        int size = sparseLongArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.mo4invoke(Integer.valueOf(sparseLongArray.keyAt(i10)), Long.valueOf(sparseLongArray.valueAt(i10)));
        }
    }

    public static final long getOrDefault(@NotNull SparseLongArray sparseLongArray, int i10, long j10) {
        return sparseLongArray.get(i10, j10);
    }

    public static final long getOrElse(@NotNull SparseLongArray sparseLongArray, int i10, @NotNull h9.a<Long> aVar) {
        int iIndexOfKey = sparseLongArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : aVar.invoke().longValue();
    }

    public static final int getSize(@NotNull SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseLongArray sparseLongArray) {
        return sparseLongArray.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull SparseLongArray sparseLongArray) {
        return sparseLongArray.size() != 0;
    }

    @NotNull
    public static final l0 keyIterator(@NotNull final SparseLongArray sparseLongArray) {
        return new l0() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.l0
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseLongArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i10), sparseLongArray2.valueAt(i10));
        }
    }

    public static final boolean remove(@NotNull SparseLongArray sparseLongArray, int i10, long j10) {
        int iIndexOfKey = sparseLongArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || j10 != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(@NotNull SparseLongArray sparseLongArray, int i10, long j10) {
        sparseLongArray.put(i10, j10);
    }

    @NotNull
    public static final m0 valueIterator(@NotNull final SparseLongArray sparseLongArray) {
        return new m0() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.m0
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseLongArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
