package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.ConcurrentModificationException;
import kotlin.collections.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentHashSetMutableIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashSetMutableIterator<E> extends PersistentHashSetIterator<E> {

    @NotNull
    private final PersistentHashSetBuilder<E> builder;
    private int expectedModCount;

    @Nullable
    private E lastIteratedElement;
    private boolean nextWasInvoked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentHashSetMutableIterator(@NotNull PersistentHashSetBuilder<E> builder) {
        super(builder.getNode$runtime_release());
        t.i(builder, "builder");
        this.builder = builder;
        this.expectedModCount = builder.getModCount$runtime_release();
    }

    private final void checkForComodification() {
        if (this.builder.getModCount$runtime_release() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkNextWasInvoked() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    private final boolean isCollision(TrieNode<?> trieNode) {
        return trieNode.getBitmap() == 0;
    }

    private final void resetPath(int i10, TrieNode<?> trieNode, E e10, int i11) {
        if (isCollision(trieNode)) {
            int iY = p.Y(trieNode.getBuffer(), e10);
            CommonFunctionsKt.m1270assert(iY != -1);
            getPath().get(i11).reset(trieNode.getBuffer(), iY);
            setPathLastIndex(i11);
            return;
        }
        int iIndexOfCellAt$runtime_release = trieNode.indexOfCellAt$runtime_release(1 << TrieNodeKt.indexSegment(i10, i11 * 5));
        getPath().get(i11).reset(trieNode.getBuffer(), iIndexOfCellAt$runtime_release);
        Object obj = trieNode.getBuffer()[iIndexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            resetPath(i10, (TrieNode) obj, e10, i11 + 1);
        } else {
            setPathLastIndex(i11);
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public E next() {
        checkForComodification();
        E e10 = (E) super.next();
        this.lastIteratedElement = e10;
        this.nextWasInvoked = true;
        return e10;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        if (hasNext()) {
            E eCurrentElement = currentElement();
            t0.a(this.builder).remove(this.lastIteratedElement);
            resetPath(eCurrentElement != null ? eCurrentElement.hashCode() : 0, this.builder.getNode$runtime_release(), eCurrentElement, 0);
        } else {
            t0.a(this.builder).remove(this.lastIteratedElement);
        }
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime_release();
    }
}
