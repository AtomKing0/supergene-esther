package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import h9.l;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.o;
import kotlin.collections.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SmallPersistentVector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final SmallPersistentVector EMPTY = new SmallPersistentVector(new Object[0]);

    @NotNull
    private final Object[] buffer;

    /* JADX INFO: compiled from: SmallPersistentVector.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final SmallPersistentVector getEMPTY() {
            return SmallPersistentVector.EMPTY;
        }
    }

    public SmallPersistentVector(@NotNull Object[] buffer) {
        t.i(buffer, "buffer");
        this.buffer = buffer;
        CommonFunctionsKt.m1270assert(buffer.length <= 32);
    }

    private final Object[] bufferOfSize(int i10) {
        return new Object[i10];
    }

    @Override // kotlin.collections.c, java.util.List
    public E get(int i10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        return (E) this.buffer[i10];
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.buffer.length;
    }

    @Override // kotlin.collections.c, java.util.List
    public int indexOf(Object obj) {
        return p.Y(this.buffer, obj);
    }

    @Override // kotlin.collections.c, java.util.List
    public int lastIndexOf(Object obj) {
        return p.g0(this.buffer, obj);
    }

    @Override // kotlin.collections.c, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i10) {
        ListImplementation.checkPositionIndex$runtime_release(i10, size());
        return new BufferIterator(this.buffer, i10, size());
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    @NotNull
    public PersistentList<E> removeAt(int i10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        if (size() == 1) {
            return EMPTY;
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() - 1);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        o.i(this.buffer, objArrCopyOf, i10, i10 + 1, size());
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // kotlin.collections.c, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    @NotNull
    public PersistentList<E> set(int i10, E e10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i10] = e10;
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> add(E e10) {
        if (size() >= 32) {
            return new PersistentVector(this.buffer, UtilsKt.presizedBufferWith(e10), size() + 1, 0);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() + 1);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[size()] = e10;
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> addAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        if (size() + elements.size() > 32) {
            PersistentList.Builder<E> builder = builder();
            builder.addAll(elements);
            return builder.build();
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() + elements.size());
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        int size = size();
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            objArrCopyOf[size] = it.next();
            size++;
        }
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList.Builder<E> builder() {
        return new PersistentVectorBuilder(this, null, this.buffer, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> removeAll(@NotNull l<? super E, Boolean> predicate) {
        t.i(predicate, "predicate");
        Object[] objArrCopyOf = this.buffer;
        int size = size();
        int size2 = size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size2; i10++) {
            Object obj = this.buffer[i10];
            if (predicate.invoke(obj).booleanValue()) {
                if (!z10) {
                    Object[] objArr = this.buffer;
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    t.h(objArrCopyOf, "copyOf(this, size)");
                    z10 = true;
                    size = i10;
                }
            } else if (z10) {
                objArrCopyOf[size] = obj;
                size++;
            }
        }
        return size == size() ? this : size == 0 ? EMPTY : new SmallPersistentVector(o.p(objArrCopyOf, 0, size));
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    @NotNull
    public PersistentList<E> add(int i10, E e10) {
        ListImplementation.checkPositionIndex$runtime_release(i10, size());
        if (i10 == size()) {
            return add((Object) e10);
        }
        if (size() < 32) {
            Object[] objArrBufferOfSize = bufferOfSize(size() + 1);
            o.m(this.buffer, objArrBufferOfSize, 0, 0, i10, 6, null);
            o.i(this.buffer, objArrBufferOfSize, i10 + 1, i10, size());
            objArrBufferOfSize[i10] = e10;
            return new SmallPersistentVector(objArrBufferOfSize);
        }
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        o.i(this.buffer, objArrCopyOf, i10 + 1, i10, size() - 1);
        objArrCopyOf[i10] = e10;
        return new PersistentVector(objArrCopyOf, UtilsKt.presizedBufferWith(this.buffer[31]), size() + 1, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    @NotNull
    public PersistentList<E> addAll(int i10, @NotNull Collection<? extends E> c10) {
        t.i(c10, "c");
        ListImplementation.checkPositionIndex$runtime_release(i10, size());
        if (size() + c10.size() <= 32) {
            Object[] objArrBufferOfSize = bufferOfSize(size() + c10.size());
            o.m(this.buffer, objArrBufferOfSize, 0, 0, i10, 6, null);
            o.i(this.buffer, objArrBufferOfSize, c10.size() + i10, i10, size());
            Iterator<? extends E> it = c10.iterator();
            while (it.hasNext()) {
                objArrBufferOfSize[i10] = it.next();
                i10++;
            }
            return new SmallPersistentVector(objArrBufferOfSize);
        }
        PersistentList.Builder<E> builder = builder();
        builder.addAll(i10, c10);
        return builder.build();
    }
}
