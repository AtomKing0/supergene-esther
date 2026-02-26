package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ListImplementation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListImplementation {

    @NotNull
    public static final ListImplementation INSTANCE = new ListImplementation();

    private ListImplementation() {
    }

    public static final void checkElementIndex$runtime_release(int i10, int i11) {
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
        }
    }

    public static final void checkPositionIndex$runtime_release(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
        }
    }

    public static final void checkRangeIndexes$runtime_release(int i10, int i11, int i12) {
        if (i10 < 0 || i11 > i12) {
            throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
        }
        if (i10 <= i11) {
            return;
        }
        throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
    }

    public static final boolean orderedEquals$runtime_release(@NotNull Collection<?> c10, @NotNull Collection<?> other) {
        t.i(c10, "c");
        t.i(other, "other");
        if (c10.size() != other.size()) {
            return false;
        }
        Iterator<?> it = other.iterator();
        Iterator<?> it2 = c10.iterator();
        while (it2.hasNext()) {
            if (!t.d(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final int orderedHashCode$runtime_release(@NotNull Collection<?> c10) {
        t.i(c10, "c");
        Iterator<?> it = c10.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }
}
