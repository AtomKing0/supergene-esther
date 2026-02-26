package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentOrderedSetMutableIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedSetMutableIterator<E> extends PersistentOrderedSetIterator<E> {

    @NotNull
    private final PersistentOrderedSetBuilder<E> builder;
    private int expectedModCount;

    @Nullable
    private E lastIteratedElement;
    private boolean nextWasInvoked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentOrderedSetMutableIterator(@NotNull PersistentOrderedSetBuilder<E> builder) {
        super(builder.getFirstElement$runtime_release(), builder.getHashMapBuilder$runtime_release());
        t.i(builder, "builder");
        this.builder = builder;
        this.expectedModCount = builder.getHashMapBuilder$runtime_release().getModCount$runtime_release();
    }

    private final void checkForComodification() {
        if (this.builder.getHashMapBuilder$runtime_release().getModCount$runtime_release() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkNextWasInvoked() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetIterator, java.util.Iterator
    public E next() {
        checkForComodification();
        E e10 = (E) super.next();
        this.lastIteratedElement = e10;
        this.nextWasInvoked = true;
        return e10;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetIterator, java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        t0.a(this.builder).remove(this.lastIteratedElement);
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getHashMapBuilder$runtime_release().getModCount$runtime_release();
        setIndex$runtime_release(getIndex$runtime_release() - 1);
    }
}
