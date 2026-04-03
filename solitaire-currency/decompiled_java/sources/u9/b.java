package u9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Atomic.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T> extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34646a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");

    @Nullable
    private volatile Object _consensus = a.f34645a;

    private final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34646a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = a.f34645a;
        return obj2 != obj3 ? obj2 : androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u9.a0
    @Nullable
    public final Object a(@Nullable Object obj) {
        Object objC = f34646a.get(this);
        if (objC == a.f34645a) {
            objC = c(d(obj));
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(T t10, @Nullable Object obj);

    @Nullable
    public abstract Object d(T t10);
}
