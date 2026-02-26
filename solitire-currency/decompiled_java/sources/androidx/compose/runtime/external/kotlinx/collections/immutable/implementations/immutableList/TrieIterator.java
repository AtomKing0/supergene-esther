package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TrieIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrieIterator<E> extends AbstractListIterator<E> {
    private int height;
    private boolean isInRightEdge;

    @NotNull
    private Object[] path;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public TrieIterator(@NotNull Object[] root, int i10, int i11, int i12) {
        super(i10, i11);
        t.i(root, "root");
        this.height = i12;
        Object[] objArr = new Object[i12];
        this.path = objArr;
        ?? r52 = i10 == i11 ? 1 : 0;
        this.isInRightEdge = r52;
        objArr[0] = root;
        fillPath(i10 - r52, 1);
    }

    private final E elementAtCurrentIndex() {
        int index = getIndex() & 31;
        Object obj = this.path[this.height - 1];
        if (obj != null) {
            return (E) ((Object[]) obj)[index];
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
    }

    private final void fillPath(int i10, int i11) {
        int i12 = (this.height - i11) * 5;
        while (i11 < this.height) {
            Object[] objArr = this.path;
            Object obj = objArr[i11 - 1];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr[i11] = ((Object[]) obj)[UtilsKt.indexSegment(i10, i12)];
            i12 -= 5;
            i11++;
        }
    }

    private final void fillPathIfNeeded(int i10) {
        int i11 = 0;
        while (UtilsKt.indexSegment(getIndex(), i11) == i10) {
            i11 += 5;
        }
        if (i11 > 0) {
            fillPath(getIndex(), ((this.height - 1) - (i11 / 5)) + 1);
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E eElementAtCurrentIndex = elementAtCurrentIndex();
        setIndex(getIndex() + 1);
        if (getIndex() == getSize()) {
            this.isInRightEdge = true;
            return eElementAtCurrentIndex;
        }
        fillPathIfNeeded(0);
        return eElementAtCurrentIndex;
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        setIndex(getIndex() - 1);
        if (this.isInRightEdge) {
            this.isInRightEdge = false;
            return elementAtCurrentIndex();
        }
        fillPathIfNeeded(31);
        return elementAtCurrentIndex();
    }

    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final void reset$runtime_release(@NotNull Object[] root, int i10, int i11, int i12) {
        t.i(root, "root");
        setIndex(i10);
        setSize(i11);
        this.height = i12;
        if (this.path.length < i12) {
            this.path = new Object[i12];
        }
        this.path[0] = root;
        ?? r02 = i10 == i11 ? 1 : 0;
        this.isInRightEdge = r02;
        fillPath(i10 - r02, 1);
    }
}
