package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentHashMapBuilderContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public class PersistentHashMapBuilderBaseIterator<K, V, T> extends PersistentHashMapBaseIterator<K, V, T> {

    @NotNull
    private final PersistentHashMapBuilder<K, V> builder;
    private int expectedModCount;

    @Nullable
    private K lastIteratedKey;
    private boolean nextWasInvoked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentHashMapBuilderBaseIterator(@NotNull PersistentHashMapBuilder<K, V> builder, @NotNull TrieNodeBaseIterator<K, V, T>[] path) {
        super(builder.getNode$runtime_release(), path);
        t.i(builder, "builder");
        t.i(path, "path");
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

    private final void resetPath(int i10, TrieNode<?, ?> trieNode, K k10, int i11) {
        int i12 = i11 * 5;
        if (i12 > 30) {
            getPath()[i11].reset(trieNode.getBuffer$runtime_release(), trieNode.getBuffer$runtime_release().length, 0);
            while (!t.d(getPath()[i11].currentKey(), k10)) {
                getPath()[i11].moveToNextKey();
            }
            setPathLastIndex(i11);
            return;
        }
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i12);
        if (trieNode.hasEntryAt$runtime_release(iIndexSegment)) {
            getPath()[i11].reset(trieNode.getBuffer$runtime_release(), trieNode.entryCount$runtime_release() * 2, trieNode.entryKeyIndex$runtime_release(iIndexSegment));
            setPathLastIndex(i11);
        } else {
            int iNodeIndex$runtime_release = trieNode.nodeIndex$runtime_release(iIndexSegment);
            TrieNode<?, ?> trieNodeNodeAtIndex$runtime_release = trieNode.nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
            getPath()[i11].reset(trieNode.getBuffer$runtime_release(), trieNode.entryCount$runtime_release() * 2, iNodeIndex$runtime_release);
            resetPath(i10, trieNodeNodeAtIndex$runtime_release, k10, i11 + 1);
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public T next() {
        checkForComodification();
        this.lastIteratedKey = currentKey();
        this.nextWasInvoked = true;
        return (T) super.next();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        if (hasNext()) {
            K kCurrentKey = currentKey();
            t0.d(this.builder).remove(this.lastIteratedKey);
            resetPath(kCurrentKey != null ? kCurrentKey.hashCode() : 0, this.builder.getNode$runtime_release(), kCurrentKey, 0);
        } else {
            t0.d(this.builder).remove(this.lastIteratedKey);
        }
        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime_release();
    }

    public final void setValue(K k10, V v10) {
        if (this.builder.containsKey(k10)) {
            if (hasNext()) {
                K kCurrentKey = currentKey();
                this.builder.put(k10, v10);
                resetPath(kCurrentKey != null ? kCurrentKey.hashCode() : 0, this.builder.getNode$runtime_release(), kCurrentKey, 0);
            } else {
                this.builder.put(k10, v10);
            }
            this.expectedModCount = this.builder.getModCount$runtime_release();
        }
    }
}
