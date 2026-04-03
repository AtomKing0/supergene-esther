package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import i9.a;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashSetIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public class PersistentHashSetIterator<E> implements Iterator<E>, a {
    private boolean hasNext;

    @NotNull
    private final List<TrieNodeIterator<E>> path;
    private int pathLastIndex;

    public PersistentHashSetIterator(@NotNull TrieNode<E> node) {
        t.i(node, "node");
        List<TrieNodeIterator<E>> listQ = v.q(new TrieNodeIterator());
        this.path = listQ;
        this.hasNext = true;
        TrieNodeIterator.reset$default(listQ.get(0), node.getBuffer(), 0, 2, null);
        this.pathLastIndex = 0;
        ensureNextElementIsReady();
    }

    private final void ensureNextElementIsReady() {
        if (this.path.get(this.pathLastIndex).hasNextElement()) {
            return;
        }
        for (int i10 = this.pathLastIndex; -1 < i10; i10--) {
            int iMoveToNextNodeWithData = moveToNextNodeWithData(i10);
            if (iMoveToNextNodeWithData == -1 && this.path.get(i10).hasNextCell()) {
                this.path.get(i10).moveToNextCell();
                iMoveToNextNodeWithData = moveToNextNodeWithData(i10);
            }
            if (iMoveToNextNodeWithData != -1) {
                this.pathLastIndex = iMoveToNextNodeWithData;
                return;
            }
            if (i10 > 0) {
                this.path.get(i10 - 1).moveToNextCell();
            }
            this.path.get(i10).reset(TrieNode.Companion.getEMPTY$runtime_release().getBuffer(), 0);
        }
        this.hasNext = false;
    }

    private final int moveToNextNodeWithData(int i10) {
        if (this.path.get(i10).hasNextElement()) {
            return i10;
        }
        if (!this.path.get(i10).hasNextNode()) {
            return -1;
        }
        TrieNode<? extends E> trieNodeCurrentNode = this.path.get(i10).currentNode();
        int i11 = i10 + 1;
        if (i11 == this.path.size()) {
            this.path.add(new TrieNodeIterator<>());
        }
        TrieNodeIterator.reset$default(this.path.get(i11), trieNodeCurrentNode.getBuffer(), 0, 2, null);
        return moveToNextNodeWithData(i11);
    }

    protected final E currentElement() {
        CommonFunctionsKt.m1270assert(hasNext());
        return this.path.get(this.pathLastIndex).currentElement();
    }

    @NotNull
    protected final List<TrieNodeIterator<E>> getPath() {
        return this.path;
    }

    protected final int getPathLastIndex() {
        return this.pathLastIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public E next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        E eNextElement = this.path.get(this.pathLastIndex).nextElement();
        ensureNextElementIsReady();
        return eNextElement;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected final void setPathLastIndex(int i10) {
        this.pathLastIndex = i10;
    }

    private static /* synthetic */ void getHasNext$annotations() {
    }
}
