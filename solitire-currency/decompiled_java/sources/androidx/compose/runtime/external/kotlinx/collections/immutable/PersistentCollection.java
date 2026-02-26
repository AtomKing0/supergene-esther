package androidx.compose.runtime.external.kotlinx.collections.immutable;

import h9.l;
import i9.b;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImmutableCollection.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PersistentCollection<E> extends ImmutableCollection<E> {

    /* JADX INFO: compiled from: ImmutableCollection.kt */
    public interface Builder<E> extends Collection<E>, b {
        @NotNull
        PersistentCollection<E> build();
    }

    @Override // java.util.Collection
    @NotNull
    PersistentCollection<E> add(E e10);

    @Override // java.util.Collection
    @NotNull
    PersistentCollection<E> addAll(@NotNull Collection<? extends E> collection);

    @NotNull
    Builder<E> builder();

    @Override // java.util.Collection
    @NotNull
    PersistentCollection<E> clear();

    @Override // java.util.Collection
    @NotNull
    PersistentCollection<E> remove(E e10);

    @NotNull
    PersistentCollection<E> removeAll(@NotNull l<? super E, Boolean> lVar);

    @Override // java.util.Collection
    @NotNull
    PersistentCollection<E> removeAll(@NotNull Collection<? extends E> collection);

    @Override // java.util.Collection
    @NotNull
    PersistentCollection<E> retainAll(@NotNull Collection<? extends E> collection);
}
