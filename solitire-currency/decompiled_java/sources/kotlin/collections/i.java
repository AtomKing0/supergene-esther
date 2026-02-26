package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractSet.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i<E> extends kotlin.collections.a<E> implements Set<E> {

    @NotNull
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: AbstractSet.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final boolean a(@NotNull Set<?> c10, @NotNull Set<?> other) {
            kotlin.jvm.internal.t.i(c10, "c");
            kotlin.jvm.internal.t.i(other, "other");
            if (c10.size() != other.size()) {
                return false;
            }
            return c10.containsAll(other);
        }

        public final int b(@NotNull Collection<?> c10) {
            kotlin.jvm.internal.t.i(c10, "c");
            Iterator<?> it = c10.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode += next != null ? next.hashCode() : 0;
            }
            return iHashCode;
        }
    }

    protected i() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return Companion.a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Companion.b(this);
    }

    @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
