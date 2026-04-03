package kotlin.collections;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j0<T> implements Iterable<i0<? extends T>>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.a<Iterator<T>> f29781a;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(@NotNull h9.a<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.t.i(iteratorFactory, "iteratorFactory");
        this.f29781a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<i0<T>> iterator() {
        return new k0(this.f29781a.invoke());
    }
}
