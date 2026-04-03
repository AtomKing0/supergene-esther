package androidx.collection;

import h9.p;
import i9.a;
import java.util.Iterator;
import kotlin.collections.l0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SparseArray.kt */
    public static final class C07751<T> implements Iterator<T>, a {
        final /* synthetic */ SparseArrayCompat $this_valueIterator;
        private int index;

        C07751(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
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
            SparseArrayCompat sparseArrayCompat = this.$this_valueIterator;
            int i10 = this.index;
            this.index = i10 + 1;
            return (T) sparseArrayCompat.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    public static final <T> boolean contains(@NotNull SparseArrayCompat<T> receiver$0, int i10) {
        t.j(receiver$0, "receiver$0");
        return receiver$0.containsKey(i10);
    }

    public static final <T> void forEach(@NotNull SparseArrayCompat<T> receiver$0, @NotNull p<? super Integer, ? super T, k0> action) {
        t.j(receiver$0, "receiver$0");
        t.j(action, "action");
        int size = receiver$0.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo4invoke(Integer.valueOf(receiver$0.keyAt(i10)), receiver$0.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArrayCompat<T> receiver$0, int i10, T t10) {
        t.j(receiver$0, "receiver$0");
        return receiver$0.get(i10, t10);
    }

    public static final <T> T getOrElse(@NotNull SparseArrayCompat<T> receiver$0, int i10, @NotNull h9.a<? extends T> defaultValue) {
        t.j(receiver$0, "receiver$0");
        t.j(defaultValue, "defaultValue");
        T t10 = receiver$0.get(i10);
        return t10 != null ? t10 : defaultValue.invoke();
    }

    public static final <T> int getSize(@NotNull SparseArrayCompat<T> receiver$0) {
        t.j(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArrayCompat<T> receiver$0) {
        t.j(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    @NotNull
    public static final <T> l0 keyIterator(@NotNull final SparseArrayCompat<T> receiver$0) {
        t.j(receiver$0, "receiver$0");
        return new l0() { // from class: androidx.collection.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.l0
            public int nextInt() {
                SparseArrayCompat sparseArrayCompat = receiver$0;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseArrayCompat.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final <T> SparseArrayCompat<T> plus(@NotNull SparseArrayCompat<T> receiver$0, @NotNull SparseArrayCompat<T> other) {
        t.j(receiver$0, "receiver$0");
        t.j(other, "other");
        SparseArrayCompat<T> sparseArrayCompat = new SparseArrayCompat<>(receiver$0.size() + other.size());
        sparseArrayCompat.putAll(receiver$0);
        sparseArrayCompat.putAll(other);
        return sparseArrayCompat;
    }

    public static final <T> boolean remove(@NotNull SparseArrayCompat<T> receiver$0, int i10, T t10) {
        t.j(receiver$0, "receiver$0");
        return receiver$0.remove(i10, t10);
    }

    public static final <T> void set(@NotNull SparseArrayCompat<T> receiver$0, int i10, T t10) {
        t.j(receiver$0, "receiver$0");
        receiver$0.put(i10, t10);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArrayCompat<T> receiver$0) {
        t.j(receiver$0, "receiver$0");
        return new C07751(receiver$0);
    }
}
