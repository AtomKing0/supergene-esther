package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import h9.l;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.a0;
import kotlin.collections.o;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import o9.g;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.s;

/* JADX INFO: compiled from: extensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExtensionsKt {
    @NotNull
    public static final <K, V> PersistentMap<K, V> immutableHashMapOf(@NotNull s<? extends K, ? extends V>... pairs) {
        t.i(pairs, "pairs");
        return persistentHashMapOf((s[]) Arrays.copyOf(pairs, pairs.length));
    }

    @NotNull
    public static final <E> PersistentSet<E> immutableHashSetOf(@NotNull E... elements) {
        t.i(elements, "elements");
        return persistentHashSetOf(Arrays.copyOf(elements, elements.length));
    }

    @NotNull
    public static final <E> PersistentList<E> immutableListOf(@NotNull E... elements) {
        t.i(elements, "elements");
        return persistentListOf(Arrays.copyOf(elements, elements.length));
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> immutableMapOf(@NotNull s<? extends K, ? extends V>... pairs) {
        t.i(pairs, "pairs");
        return persistentMapOf((s[]) Arrays.copyOf(pairs, pairs.length));
    }

    @NotNull
    public static final <E> PersistentSet<E> immutableSetOf(@NotNull E... elements) {
        t.i(elements, "elements");
        return persistentSetOf(Arrays.copyOf(elements, elements.length));
    }

    @NotNull
    public static final <E> PersistentSet<E> intersect(@NotNull PersistentSet<? extends E> persistentSet, @NotNull Iterable<? extends E> elements) {
        t.i(persistentSet, "<this>");
        t.i(elements, "elements");
        if (elements instanceof Collection) {
            return persistentSet.retainAll((Collection<? extends Object>) elements);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        a0.R(builder, elements);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> PersistentCollection<E> minus(@NotNull PersistentCollection<? extends E> persistentCollection, E e10) {
        t.i(persistentCollection, "<this>");
        return persistentCollection.remove((Object) e10);
    }

    @NotNull
    public static final <T> PersistentSet<T> mutate(@NotNull PersistentSet<? extends T> persistentSet, @NotNull l<? super Set<T>, k0> mutator) {
        t.i(persistentSet, "<this>");
        t.i(mutator, "mutator");
        PersistentSet.Builder<? extends T> builder = persistentSet.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> persistentHashMapOf(@NotNull s<? extends K, ? extends V>... pairs) {
        t.i(pairs, "pairs");
        PersistentMap.Builder<K, V> builder = PersistentHashMap.Companion.emptyOf$runtime_release().builder();
        r0.r(builder, pairs);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> persistentHashSetOf(@NotNull E... elements) {
        t.i(elements, "elements");
        return PersistentHashSet.Companion.emptyOf$runtime_release().addAll((Collection) o.c(elements));
    }

    @NotNull
    public static final <E> PersistentList<E> persistentListOf(@NotNull E... elements) {
        t.i(elements, "elements");
        return UtilsKt.persistentVectorOf().addAll((Collection) o.c(elements));
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> persistentMapOf(@NotNull s<? extends K, ? extends V>... pairs) {
        t.i(pairs, "pairs");
        PersistentMap.Builder<K, V> builder = PersistentOrderedMap.Companion.emptyOf$runtime_release().builder();
        r0.r(builder, pairs);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> persistentSetOf(@NotNull E... elements) {
        t.i(elements, "elements");
        return PersistentOrderedSet.Companion.emptyOf$runtime_release().addAll((Collection) o.c(elements));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> PersistentCollection<E> plus(@NotNull PersistentCollection<? extends E> persistentCollection, E e10) {
        t.i(persistentCollection, "<this>");
        return persistentCollection.add((Object) e10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> PersistentMap<K, V> putAll(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Map<? extends K, ? extends V> map) {
        t.i(persistentMap, "<this>");
        t.i(map, "map");
        return persistentMap.putAll((Map<? extends Object, ? extends Object>) map);
    }

    @NotNull
    public static final <T> ImmutableList<T> toImmutableList(@NotNull Iterable<? extends T> iterable) {
        t.i(iterable, "<this>");
        ImmutableList<T> immutableList = iterable instanceof ImmutableList ? (ImmutableList) iterable : null;
        return immutableList == null ? toPersistentList(iterable) : immutableList;
    }

    @NotNull
    public static final <K, V> ImmutableMap<K, V> toImmutableMap(@NotNull Map<K, ? extends V> map) {
        t.i(map, "<this>");
        ImmutableMap<K, V> immutableMap = map instanceof ImmutableMap ? (ImmutableMap) map : null;
        if (immutableMap != null) {
            return immutableMap;
        }
        PersistentMap.Builder builder = map instanceof PersistentMap.Builder ? (PersistentMap.Builder) map : null;
        PersistentMap<K, V> persistentMapBuild = builder != null ? builder.build() : null;
        return persistentMapBuild != null ? persistentMapBuild : persistentMapOf().putAll((Map) map);
    }

    @NotNull
    public static final <T> ImmutableSet<T> toImmutableSet(@NotNull Iterable<? extends T> iterable) {
        t.i(iterable, "<this>");
        ImmutableSet<T> immutableSet = iterable instanceof ImmutableSet ? (ImmutableSet) iterable : null;
        if (immutableSet != null) {
            return immutableSet;
        }
        PersistentSet.Builder builder = iterable instanceof PersistentSet.Builder ? (PersistentSet.Builder) iterable : null;
        PersistentSet persistentSetBuild = builder != null ? builder.build() : null;
        return persistentSetBuild != null ? persistentSetBuild : plus(persistentSetOf(), (Iterable) iterable);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> toPersistentHashMap(@NotNull Map<K, ? extends V> map) {
        t.i(map, "<this>");
        PersistentHashMap persistentHashMap = map instanceof PersistentHashMap ? (PersistentHashMap) map : null;
        if (persistentHashMap != null) {
            return persistentHashMap;
        }
        PersistentHashMapBuilder persistentHashMapBuilder = map instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) map : null;
        PersistentHashMap<K, V> persistentHashMapBuild = persistentHashMapBuilder != null ? persistentHashMapBuilder.build() : null;
        return persistentHashMapBuild != null ? persistentHashMapBuild : PersistentHashMap.Companion.emptyOf$runtime_release().putAll((Map) map);
    }

    @NotNull
    public static final <T> PersistentSet<T> toPersistentHashSet(@NotNull Iterable<? extends T> iterable) {
        t.i(iterable, "<this>");
        PersistentHashSet persistentHashSet = iterable instanceof PersistentHashSet ? (PersistentHashSet) iterable : null;
        if (persistentHashSet != null) {
            return persistentHashSet;
        }
        PersistentHashSetBuilder persistentHashSetBuilder = iterable instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) iterable : null;
        PersistentHashSet persistentHashSetBuild = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        return persistentHashSetBuild != null ? persistentHashSetBuild : plus(PersistentHashSet.Companion.emptyOf$runtime_release(), (Iterable) iterable);
    }

    @NotNull
    public static final <T> PersistentList<T> toPersistentList(@NotNull Iterable<? extends T> iterable) {
        t.i(iterable, "<this>");
        PersistentList<T> persistentList = iterable instanceof PersistentList ? (PersistentList) iterable : null;
        if (persistentList != null) {
            return persistentList;
        }
        PersistentList.Builder builder = iterable instanceof PersistentList.Builder ? (PersistentList.Builder) iterable : null;
        PersistentList<T> persistentListBuild = builder != null ? builder.build() : null;
        return persistentListBuild == null ? plus(persistentListOf(), (Iterable) iterable) : persistentListBuild;
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> toPersistentMap(@NotNull Map<K, ? extends V> map) {
        t.i(map, "<this>");
        PersistentOrderedMap persistentOrderedMap = map instanceof PersistentOrderedMap ? (PersistentOrderedMap) map : null;
        if (persistentOrderedMap != null) {
            return persistentOrderedMap;
        }
        PersistentOrderedMapBuilder persistentOrderedMapBuilder = map instanceof PersistentOrderedMapBuilder ? (PersistentOrderedMapBuilder) map : null;
        PersistentMap<K, V> persistentMapBuild = persistentOrderedMapBuilder != null ? persistentOrderedMapBuilder.build() : null;
        return persistentMapBuild == null ? PersistentOrderedMap.Companion.emptyOf$runtime_release().putAll((Map) map) : persistentMapBuild;
    }

    @NotNull
    public static final <T> PersistentSet<T> toPersistentSet(@NotNull Iterable<? extends T> iterable) {
        t.i(iterable, "<this>");
        PersistentOrderedSet persistentOrderedSet = iterable instanceof PersistentOrderedSet ? (PersistentOrderedSet) iterable : null;
        if (persistentOrderedSet != null) {
            return persistentOrderedSet;
        }
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = iterable instanceof PersistentOrderedSetBuilder ? (PersistentOrderedSetBuilder) iterable : null;
        PersistentSet<T> persistentSetBuild = persistentOrderedSetBuilder != null ? persistentOrderedSetBuilder.build() : null;
        return persistentSetBuild == null ? plus(PersistentOrderedSet.Companion.emptyOf$runtime_release(), (Iterable) iterable) : persistentSetBuild;
    }

    @NotNull
    public static final <E> PersistentList<E> immutableListOf() {
        return persistentListOf();
    }

    @NotNull
    public static final <E> PersistentSet<E> immutableSetOf() {
        return persistentSetOf();
    }

    @NotNull
    public static final <E> PersistentCollection<E> minus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull Iterable<? extends E> elements) {
        t.i(persistentCollection, "<this>");
        t.i(elements, "elements");
        if (elements instanceof Collection) {
            return persistentCollection.removeAll((Collection<? extends Object>) elements);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        a0.I(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <T> PersistentList<T> mutate(@NotNull PersistentList<? extends T> persistentList, @NotNull l<? super List<T>, k0> mutator) {
        t.i(persistentList, "<this>");
        t.i(mutator, "mutator");
        PersistentList.Builder<? extends T> builder = persistentList.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> persistentHashSetOf() {
        return PersistentHashSet.Companion.emptyOf$runtime_release();
    }

    @NotNull
    public static final <E> PersistentList<E> persistentListOf() {
        return UtilsKt.persistentVectorOf();
    }

    @NotNull
    public static final <E> PersistentSet<E> persistentSetOf() {
        return PersistentOrderedSet.Companion.emptyOf$runtime_release();
    }

    @NotNull
    public static final <E> PersistentCollection<E> plus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull Iterable<? extends E> elements) {
        t.i(persistentCollection, "<this>");
        t.i(elements, "elements");
        if (elements instanceof Collection) {
            return persistentCollection.addAll((Collection<? extends Object>) elements);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        a0.B(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> putAll(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Iterable<? extends s<? extends K, ? extends V>> pairs) {
        t.i(persistentMap, "<this>");
        t.i(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        r0.p(builder, pairs);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentCollection<E> minus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull E[] elements) {
        t.i(persistentCollection, "<this>");
        t.i(elements, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        a0.K(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> mutate(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull l<? super Map<K, V>, k0> mutator) {
        t.i(persistentMap, "<this>");
        t.i(mutator, "mutator");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentCollection<E> plus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull E[] elements) {
        t.i(persistentCollection, "<this>");
        t.i(elements, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        a0.D(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <T> ImmutableList<T> toImmutableList(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        return toPersistentList(gVar);
    }

    @NotNull
    public static final <E> PersistentCollection<E> minus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull g<? extends E> elements) {
        t.i(persistentCollection, "<this>");
        t.i(elements, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        a0.J(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentCollection<E> plus(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull g<? extends E> elements) {
        t.i(persistentCollection, "<this>");
        t.i(elements, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        a0.C(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final ImmutableList<Character> toImmutableList(@NotNull CharSequence charSequence) {
        t.i(charSequence, "<this>");
        return toPersistentList(charSequence);
    }

    @NotNull
    public static final <T> ImmutableSet<T> toImmutableSet(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        return toPersistentSet(gVar);
    }

    @NotNull
    public static final <T> PersistentSet<T> toPersistentHashSet(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        return plus(persistentHashSetOf(), (g) gVar);
    }

    @NotNull
    public static final <T> PersistentList<T> toPersistentList(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        return plus(persistentListOf(), (g) gVar);
    }

    @NotNull
    public static final <T> PersistentSet<T> toPersistentSet(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        return plus(persistentSetOf(), (g) gVar);
    }

    @NotNull
    public static final <E> PersistentSet<E> intersect(@NotNull PersistentCollection<? extends E> persistentCollection, @NotNull Iterable<? extends E> elements) {
        t.i(persistentCollection, "<this>");
        t.i(elements, "elements");
        return intersect(toPersistentSet(persistentCollection), (Iterable) elements);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> PersistentList<E> minus(@NotNull PersistentList<? extends E> persistentList, E e10) {
        t.i(persistentList, "<this>");
        return persistentList.remove((Object) e10);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> persistentHashMapOf() {
        return PersistentHashMap.Companion.emptyOf$runtime_release();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> persistentMapOf() {
        return PersistentOrderedMap.Companion.emptyOf$runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> PersistentList<E> plus(@NotNull PersistentList<? extends E> persistentList, E e10) {
        t.i(persistentList, "<this>");
        return persistentList.add((Object) e10);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> putAll(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull s<? extends K, ? extends V>[] pairs) {
        t.i(persistentMap, "<this>");
        t.i(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        r0.r(builder, pairs);
        return builder.build();
    }

    @NotNull
    public static final PersistentSet<Character> toImmutableSet(@NotNull CharSequence charSequence) {
        t.i(charSequence, "<this>");
        return toPersistentSet(charSequence);
    }

    @NotNull
    public static final PersistentSet<Character> toPersistentHashSet(@NotNull CharSequence charSequence) {
        t.i(charSequence, "<this>");
        PersistentSet.Builder builder = persistentHashSetOf().builder();
        p9.t.i1(charSequence, builder);
        return builder.build();
    }

    @NotNull
    public static final PersistentList<Character> toPersistentList(@NotNull CharSequence charSequence) {
        t.i(charSequence, "<this>");
        PersistentList.Builder builder = persistentListOf().builder();
        p9.t.i1(charSequence, builder);
        return builder.build();
    }

    @NotNull
    public static final PersistentSet<Character> toPersistentSet(@NotNull CharSequence charSequence) {
        t.i(charSequence, "<this>");
        PersistentSet.Builder builder = persistentSetOf().builder();
        p9.t.i1(charSequence, builder);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentList<E> minus(@NotNull PersistentList<? extends E> persistentList, @NotNull Iterable<? extends E> elements) {
        t.i(persistentList, "<this>");
        t.i(elements, "elements");
        if (elements instanceof Collection) {
            return persistentList.removeAll((Collection<? extends Object>) elements);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        a0.I(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentList<E> plus(@NotNull PersistentList<? extends E> persistentList, @NotNull Iterable<? extends E> elements) {
        t.i(persistentList, "<this>");
        t.i(elements, "elements");
        if (elements instanceof Collection) {
            return persistentList.addAll((Collection<? extends Object>) elements);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        a0.B(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> putAll(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull g<? extends s<? extends K, ? extends V>> pairs) {
        t.i(persistentMap, "<this>");
        t.i(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        r0.q(builder, pairs);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> PersistentSet<E> minus(@NotNull PersistentSet<? extends E> persistentSet, E e10) {
        t.i(persistentSet, "<this>");
        return persistentSet.remove((Object) e10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> PersistentSet<E> plus(@NotNull PersistentSet<? extends E> persistentSet, E e10) {
        t.i(persistentSet, "<this>");
        return persistentSet.add((Object) e10);
    }

    @NotNull
    public static final <E> PersistentSet<E> minus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull Iterable<? extends E> elements) {
        t.i(persistentSet, "<this>");
        t.i(elements, "elements");
        if (elements instanceof Collection) {
            return persistentSet.removeAll((Collection<? extends Object>) elements);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        a0.I(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> plus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull Iterable<? extends E> elements) {
        t.i(persistentSet, "<this>");
        t.i(elements, "elements");
        if (elements instanceof Collection) {
            return persistentSet.addAll((Collection<? extends Object>) elements);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        a0.B(builder, elements);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> PersistentMap<K, V> minus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, K k10) {
        t.i(persistentMap, "<this>");
        return persistentMap.remove((Object) k10);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull s<? extends K, ? extends V> pair) {
        t.i(persistentMap, "<this>");
        t.i(pair, "pair");
        return persistentMap.put((Object) pair.c(), (Object) pair.d());
    }

    @NotNull
    public static final <E> PersistentList<E> minus(@NotNull PersistentList<? extends E> persistentList, @NotNull E[] elements) {
        t.i(persistentList, "<this>");
        t.i(elements, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        a0.K(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Iterable<? extends s<? extends K, ? extends V>> pairs) {
        t.i(persistentMap, "<this>");
        t.i(pairs, "pairs");
        return putAll(persistentMap, pairs);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull s<? extends K, ? extends V>[] pairs) {
        t.i(persistentMap, "<this>");
        t.i(pairs, "pairs");
        return putAll(persistentMap, pairs);
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull g<? extends s<? extends K, ? extends V>> pairs) {
        t.i(persistentMap, "<this>");
        t.i(pairs, "pairs");
        return putAll(persistentMap, pairs);
    }

    @NotNull
    public static final <E> PersistentList<E> minus(@NotNull PersistentList<? extends E> persistentList, @NotNull g<? extends E> elements) {
        t.i(persistentList, "<this>");
        t.i(elements, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        a0.J(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> plus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Map<? extends K, ? extends V> map) {
        t.i(persistentMap, "<this>");
        t.i(map, "map");
        return putAll(persistentMap, map);
    }

    @NotNull
    public static final <E> PersistentList<E> plus(@NotNull PersistentList<? extends E> persistentList, @NotNull E[] elements) {
        t.i(persistentList, "<this>");
        t.i(elements, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        a0.D(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> minus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull E[] elements) {
        t.i(persistentSet, "<this>");
        t.i(elements, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        a0.K(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentList<E> plus(@NotNull PersistentList<? extends E> persistentList, @NotNull g<? extends E> elements) {
        t.i(persistentList, "<this>");
        t.i(elements, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        a0.C(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> minus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull g<? extends E> elements) {
        t.i(persistentSet, "<this>");
        t.i(elements, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        a0.J(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> plus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull E[] elements) {
        t.i(persistentSet, "<this>");
        t.i(elements, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        a0.D(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> minus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull Iterable<? extends K> keys) {
        t.i(persistentMap, "<this>");
        t.i(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        a0.I(builder.keySet(), keys);
        return builder.build();
    }

    @NotNull
    public static final <E> PersistentSet<E> plus(@NotNull PersistentSet<? extends E> persistentSet, @NotNull g<? extends E> elements) {
        t.i(persistentSet, "<this>");
        t.i(elements, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        a0.C(builder, elements);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> minus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull K[] keys) {
        t.i(persistentMap, "<this>");
        t.i(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        a0.K(builder.keySet(), keys);
        return builder.build();
    }

    @NotNull
    public static final <K, V> PersistentMap<K, V> minus(@NotNull PersistentMap<? extends K, ? extends V> persistentMap, @NotNull g<? extends K> keys) {
        t.i(persistentMap, "<this>");
        t.i(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        a0.J(builder.keySet(), keys);
        return builder.build();
    }
}
