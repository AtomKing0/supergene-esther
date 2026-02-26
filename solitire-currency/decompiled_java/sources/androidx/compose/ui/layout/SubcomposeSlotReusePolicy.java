package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.collections.a0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SubcomposeSlotReusePolicy {

    /* JADX INFO: compiled from: SubcomposeLayout.kt */
    @StabilityInferred(parameters = 0)
    public static final class SlotIdsSet implements Collection<Object>, i9.a {
        public static final int $stable = 8;

        @NotNull
        private final Set<Object> set;

        /* JADX WARN: Multi-variable type inference failed */
        public SlotIdsSet() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // java.util.Collection
        /* JADX INFO: renamed from: add$ui_release, reason: merged with bridge method [inline-methods] */
        public final boolean add(@Nullable Object obj) {
            return this.set.add(obj);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final void clear() {
            this.set.clear();
        }

        @Override // java.util.Collection
        public boolean contains(@Nullable Object obj) {
            return this.set.contains(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(@NotNull Collection<? extends Object> elements) {
            t.i(elements, "elements");
            return this.set.containsAll(elements);
        }

        public int getSize() {
            return this.set.size();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<Object> iterator() {
            return this.set.iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(@Nullable Object obj) {
            return this.set.remove(obj);
        }

        @Override // java.util.Collection
        public final boolean removeAll(@NotNull Collection<? extends Object> slotIds) {
            t.i(slotIds, "slotIds");
            return this.set.remove(slotIds);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Object> predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final boolean retainAll(@NotNull Collection<? extends Object> slotIds) {
            t.i(slotIds, "slotIds");
            return this.set.retainAll(slotIds);
        }

        @Override // java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return kotlin.jvm.internal.j.a(this);
        }

        public SlotIdsSet(@NotNull Set<Object> set) {
            t.i(set, "set");
            this.set = set;
        }

        public final boolean removeAll(@NotNull h9.l<Object, Boolean> predicate) {
            t.i(predicate, "predicate");
            return a0.H(this.set, predicate);
        }

        public final boolean retainAll(@NotNull h9.l<Object, Boolean> predicate) {
            t.i(predicate, "predicate");
            return a0.Q(this.set, predicate);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] array) {
            t.i(array, "array");
            return (T[]) kotlin.jvm.internal.j.b(this, array);
        }

        public /* synthetic */ SlotIdsSet(Set set, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? new LinkedHashSet() : set);
        }
    }

    boolean areCompatible(@Nullable Object obj, @Nullable Object obj2);

    void getSlotsToRetain(@NotNull SlotIdsSet slotIdsSet);
}
