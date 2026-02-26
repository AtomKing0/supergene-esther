package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import h9.l;
import i9.d;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImmutableList.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PersistentList<E> extends ImmutableList<E>, PersistentCollection<E> {

    /* JADX INFO: compiled from: ImmutableList.kt */
    public interface Builder<E> extends List<E>, PersistentCollection.Builder<E>, d {
        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
        @NotNull
        PersistentList<E> build();
    }

    @Override // java.util.List
    @NotNull
    PersistentList<E> add(int i10, E e10);

    @Override // java.util.List, java.util.Collection, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentList<E> add(E e10);

    @Override // java.util.List
    @NotNull
    PersistentList<E> addAll(int i10, @NotNull Collection<? extends E> collection);

    @Override // java.util.List, java.util.Collection, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentList<E> addAll(@NotNull Collection<? extends E> collection);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    Builder<E> builder();

    @Override // java.util.List, java.util.Collection, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentList<E> clear();

    @Override // java.util.List, java.util.Collection, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentList<E> remove(E e10);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentList<E> removeAll(@NotNull l<? super E, Boolean> lVar);

    @Override // java.util.List, java.util.Collection, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentList<E> removeAll(@NotNull Collection<? extends E> collection);

    @NotNull
    PersistentList<E> removeAt(int i10);

    @Override // java.util.List, java.util.Collection, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentList<E> retainAll(@NotNull Collection<? extends E> collection);

    @Override // java.util.List
    @NotNull
    PersistentList<E> set(int i10, E e10);
}
