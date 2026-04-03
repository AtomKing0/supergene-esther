package androidx.compose.runtime.collection;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: MutableVector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MutableVectorKt {
    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int i10) {
        t.o(0, "T?");
        return new MutableVector<>(new Object[i10], 0);
    }

    public static /* synthetic */ MutableVector MutableVector$default(int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 16;
        }
        t.o(0, "T?");
        return new MutableVector(new Object[i10], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i10) {
        int size = list.size();
        if (i10 < 0 || i10 >= size) {
            throw new IndexOutOfBoundsException("Index " + i10 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i10, int i11) {
        int size = list.size();
        if (i10 > i11) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i10 + ") is greater than toIndex (" + i11 + ").");
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i10 + ") is less than 0.");
        }
        if (i11 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i11 + ") is more than than the list size (" + size + ')');
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf(T... elements) {
        t.i(elements, "elements");
        return new MutableVector<>(elements, elements.length);
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int i10, l<? super Integer, ? extends T> init) {
        t.i(init, "init");
        t.o(0, "T");
        Object[] objArr = new Object[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = init.invoke(Integer.valueOf(i11));
        }
        return new MutableVector<>(objArr, i10);
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf() {
        t.o(0, "T?");
        return new MutableVector<>(new Object[16], 0);
    }
}
