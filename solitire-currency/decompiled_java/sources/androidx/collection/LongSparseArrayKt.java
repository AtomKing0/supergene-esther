package androidx.collection;

import h9.p;
import i9.a;
import java.util.Iterator;
import kotlin.collections.m0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LongSparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LongSparseArray.kt */
    public static final class C07741<T> implements Iterator<T>, a {
        final /* synthetic */ LongSparseArray $this_valueIterator;
        private int index;

        C07741(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
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
            LongSparseArray longSparseArray = this.$this_valueIterator;
            int i10 = this.index;
            this.index = i10 + 1;
            return (T) longSparseArray.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    public static final <T> boolean contains(@NotNull LongSparseArray<T> receiver$0, long j10) {
        t.j(receiver$0, "receiver$0");
        return receiver$0.containsKey(j10);
    }

    public static final <T> void forEach(@NotNull LongSparseArray<T> receiver$0, @NotNull p<? super Long, ? super T, k0> action) {
        t.j(receiver$0, "receiver$0");
        t.j(action, "action");
        int size = receiver$0.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo4invoke(Long.valueOf(receiver$0.keyAt(i10)), receiver$0.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> receiver$0, long j10, T t10) {
        t.j(receiver$0, "receiver$0");
        return receiver$0.get(j10, t10);
    }

    public static final <T> T getOrElse(@NotNull LongSparseArray<T> receiver$0, long j10, @NotNull h9.a<? extends T> defaultValue) {
        t.j(receiver$0, "receiver$0");
        t.j(defaultValue, "defaultValue");
        T t10 = receiver$0.get(j10);
        return t10 != null ? t10 : defaultValue.invoke();
    }

    public static final <T> int getSize(@NotNull LongSparseArray<T> receiver$0) {
        t.j(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> receiver$0) {
        t.j(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    @NotNull
    public static final <T> m0 keyIterator(@NotNull final LongSparseArray<T> receiver$0) {
        t.j(receiver$0, "receiver$0");
        return new m0() { // from class: androidx.collection.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.m0
            public long nextLong() {
                LongSparseArray longSparseArray = receiver$0;
                int i10 = this.index;
                this.index = i10 + 1;
                return longSparseArray.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> receiver$0, @NotNull LongSparseArray<T> other) {
        t.j(receiver$0, "receiver$0");
        t.j(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(receiver$0.size() + other.size());
        longSparseArray.putAll(receiver$0);
        longSparseArray.putAll(other);
        return longSparseArray;
    }

    public static final <T> boolean remove(@NotNull LongSparseArray<T> receiver$0, long j10, T t10) {
        t.j(receiver$0, "receiver$0");
        return receiver$0.remove(j10, t10);
    }

    public static final <T> void set(@NotNull LongSparseArray<T> receiver$0, long j10, T t10) {
        t.j(receiver$0, "receiver$0");
        receiver$0.put(j10, t10);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> receiver$0) {
        t.j(receiver$0, "receiver$0");
        return new C07741(receiver$0);
    }
}
