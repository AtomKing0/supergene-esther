package b9;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnumEntries.kt */
/* JADX INFO: loaded from: classes5.dex */
final class c<T extends Enum<T>> extends kotlin.collections.c<T> implements a<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final T[] f2276a;

    public c(@NotNull T[] entries) {
        t.i(entries, "entries");
        this.f2276a = entries;
    }

    public boolean a(@NotNull T element) {
        t.i(element, "element");
        return ((Enum) p.T(this.f2276a, element.ordinal())) == element;
    }

    @Override // kotlin.collections.c, java.util.List
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T get(int i10) {
        kotlin.collections.c.Companion.b(i10, this.f2276a.length);
        return this.f2276a[i10];
    }

    @Override // kotlin.collections.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return a((Enum) obj);
        }
        return false;
    }

    public int e(@NotNull T element) {
        t.i(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) p.T(this.f2276a, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    public int f(@NotNull T element) {
        t.i(element, "element");
        return indexOf(element);
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.f2276a.length;
    }

    @Override // kotlin.collections.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return e((Enum) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return f((Enum) obj);
        }
        return -1;
    }
}
