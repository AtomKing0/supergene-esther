package v8;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
final class v<T> implements l<T>, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f35211d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<v<?>, Object> f35212e = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private volatile h9.a<? extends T> f35213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile Object f35214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Object f35215c;

    /* JADX INFO: compiled from: LazyJVM.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public v(@NotNull h9.a<? extends T> initializer) {
        kotlin.jvm.internal.t.i(initializer, "initializer");
        this.f35213a = initializer;
        g0 g0Var = g0.f35184a;
        this.f35214b = g0Var;
        this.f35215c = g0Var;
    }

    @Override // v8.l
    public T getValue() {
        T t10 = (T) this.f35214b;
        g0 g0Var = g0.f35184a;
        if (t10 != g0Var) {
            return t10;
        }
        h9.a<? extends T> aVar = this.f35213a;
        if (aVar != null) {
            T tInvoke = aVar.invoke();
            if (androidx.concurrent.futures.a.a(f35212e, this, g0Var, tInvoke)) {
                this.f35213a = null;
                return tInvoke;
            }
        }
        return (T) this.f35214b;
    }

    @Override // v8.l
    public boolean isInitialized() {
        return this.f35214b != g0.f35184a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
