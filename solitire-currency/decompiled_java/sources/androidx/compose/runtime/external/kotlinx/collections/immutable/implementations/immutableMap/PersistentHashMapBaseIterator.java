package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import i9.a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, a {
    private boolean hasNext;

    @NotNull
    private final TrieNodeBaseIterator<K, V, T>[] path;
    private int pathLastIndex;

    public PersistentHashMapBaseIterator(@NotNull TrieNode<K, V> node, @NotNull TrieNodeBaseIterator<K, V, T>[] path) {
        t.i(node, "node");
        t.i(path, "path");
        this.path = path;
        this.hasNext = true;
        path[0].reset(node.getBuffer$runtime_release(), node.entryCount$runtime_release() * 2);
        this.pathLastIndex = 0;
        ensureNextEntryIsReady();
    }

    private final void checkHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void ensureNextEntryIsReady() {
        if (this.path[this.pathLastIndex].hasNextKey()) {
            return;
        }
        for (int i10 = this.pathLastIndex; -1 < i10; i10--) {
            int iMoveToNextNodeWithData = moveToNextNodeWithData(i10);
            if (iMoveToNextNodeWithData == -1 && this.path[i10].hasNextNode()) {
                this.path[i10].moveToNextNode();
                iMoveToNextNodeWithData = moveToNextNodeWithData(i10);
            }
            if (iMoveToNextNodeWithData != -1) {
                this.pathLastIndex = iMoveToNextNodeWithData;
                return;
            }
            if (i10 > 0) {
                this.path[i10 - 1].moveToNextNode();
            }
            this.path[i10].reset(TrieNode.Companion.getEMPTY$runtime_release().getBuffer$runtime_release(), 0);
        }
        this.hasNext = false;
    }

    private final int moveToNextNodeWithData(int i10) {
        if (this.path[i10].hasNextKey()) {
            return i10;
        }
        if (!this.path[i10].hasNextNode()) {
            return -1;
        }
        TrieNode<? extends K, ? extends V> trieNodeCurrentNode = this.path[i10].currentNode();
        if (i10 == 6) {
            this.path[i10 + 1].reset(trieNodeCurrentNode.getBuffer$runtime_release(), trieNodeCurrentNode.getBuffer$runtime_release().length);
        } else {
            this.path[i10 + 1].reset(trieNodeCurrentNode.getBuffer$runtime_release(), trieNodeCurrentNode.entryCount$runtime_release() * 2);
        }
        return moveToNextNodeWithData(i10 + 1);
    }

    protected final K currentKey() {
        checkHasNext();
        return this.path[this.pathLastIndex].currentKey();
    }

    @NotNull
    protected final TrieNodeBaseIterator<K, V, T>[] getPath() {
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
    public T next() {
        checkHasNext();
        T next = this.path[this.pathLastIndex].next();
        ensureNextEntryIsReady();
        return next;
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
