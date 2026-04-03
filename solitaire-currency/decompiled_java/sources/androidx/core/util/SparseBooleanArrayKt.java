package androidx.core.util;

import android.util.SparseBooleanArray;
import h9.p;
import kotlin.collections.l0;
import kotlin.collections.r;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SparseBooleanArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@NotNull SparseBooleanArray sparseBooleanArray, int i10) {
        return sparseBooleanArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsKey(@NotNull SparseBooleanArray sparseBooleanArray, int i10) {
        return sparseBooleanArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsValue(@NotNull SparseBooleanArray sparseBooleanArray, boolean z10) {
        return sparseBooleanArray.indexOfValue(z10) >= 0;
    }

    public static final void forEach(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull p<? super Integer, ? super Boolean, k0> pVar) {
        int size = sparseBooleanArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.mo4invoke(Integer.valueOf(sparseBooleanArray.keyAt(i10)), Boolean.valueOf(sparseBooleanArray.valueAt(i10)));
        }
    }

    public static final boolean getOrDefault(@NotNull SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        return sparseBooleanArray.get(i10, z10);
    }

    public static final boolean getOrElse(@NotNull SparseBooleanArray sparseBooleanArray, int i10, @NotNull h9.a<Boolean> aVar) {
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : aVar.invoke().booleanValue();
    }

    public static final int getSize(@NotNull SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size() != 0;
    }

    @NotNull
    public static final l0 keyIterator(@NotNull final SparseBooleanArray sparseBooleanArray) {
        return new l0() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // kotlin.collections.l0
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseBooleanArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final SparseBooleanArray plus(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i10), sparseBooleanArray2.valueAt(i10));
        }
    }

    public static final boolean remove(@NotNull SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || z10 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i10);
        return true;
    }

    public static final void set(@NotNull SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        sparseBooleanArray.put(i10, z10);
    }

    @NotNull
    public static final r valueIterator(@NotNull final SparseBooleanArray sparseBooleanArray) {
        return new r() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // kotlin.collections.r
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseBooleanArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
