package androidx.core.util;

import android.util.SparseArray;
import h9.p;
import java.util.Iterator;
import kotlin.collections.l0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SparseArray.kt */
    public static final class C10191<T> implements Iterator<T>, i9.a {
        final /* synthetic */ SparseArray<T> $this_valueIterator;
        private int index;

        C10191(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> sparseArray = this.$this_valueIterator;
            int i10 = this.index;
            this.index = i10 + 1;
            return sparseArray.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    public static final <T> boolean contains(@NotNull SparseArray<T> sparseArray, int i10) {
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static final <T> boolean containsKey(@NotNull SparseArray<T> sparseArray, int i10) {
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static final <T> boolean containsValue(@NotNull SparseArray<T> sparseArray, T t10) {
        return sparseArray.indexOfValue(t10) >= 0;
    }

    public static final <T> void forEach(@NotNull SparseArray<T> sparseArray, @NotNull p<? super Integer, ? super T, k0> pVar) {
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.mo4invoke(Integer.valueOf(sparseArray.keyAt(i10)), sparseArray.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArray<T> sparseArray, int i10, T t10) {
        T t11 = sparseArray.get(i10);
        return t11 == null ? t10 : t11;
    }

    public static final <T> T getOrElse(@NotNull SparseArray<T> sparseArray, int i10, @NotNull h9.a<? extends T> aVar) {
        T t10 = sparseArray.get(i10);
        return t10 == null ? aVar.invoke() : t10;
    }

    public static final <T> int getSize(@NotNull SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@NotNull SparseArray<T> sparseArray) {
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArray<T> sparseArray) {
        return sparseArray.size() != 0;
    }

    @NotNull
    public static final <T> l0 keyIterator(@NotNull final SparseArray<T> sparseArray) {
        return new l0() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // kotlin.collections.l0
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final <T> SparseArray<T> plus(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.put(sparseArray2.keyAt(i10), sparseArray2.valueAt(i10));
        }
    }

    public static final <T> boolean remove(@NotNull SparseArray<T> sparseArray, int i10, T t10) {
        int iIndexOfKey = sparseArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || !t.d(t10, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(@NotNull SparseArray<T> sparseArray, int i10, T t10) {
        sparseArray.put(i10, t10);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArray<T> sparseArray) {
        return new C10191(sparseArray);
    }
}
