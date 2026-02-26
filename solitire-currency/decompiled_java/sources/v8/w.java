package v8;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
final class w<T> implements l<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private h9.a<? extends T> f35216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile Object f35217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Object f35218c;

    public w(@NotNull h9.a<? extends T> initializer, @Nullable Object obj) {
        kotlin.jvm.internal.t.i(initializer, "initializer");
        this.f35216a = initializer;
        this.f35217b = g0.f35184a;
        this.f35218c = obj == null ? this : obj;
    }

    @Override // v8.l
    public T getValue() {
        T tInvoke;
        T t10 = (T) this.f35217b;
        g0 g0Var = g0.f35184a;
        if (t10 != g0Var) {
            return t10;
        }
        synchronized (this.f35218c) {
            tInvoke = (T) this.f35217b;
            if (tInvoke == g0Var) {
                h9.a<? extends T> aVar = this.f35216a;
                kotlin.jvm.internal.t.f(aVar);
                tInvoke = aVar.invoke();
                this.f35217b = tInvoke;
                this.f35216a = null;
            }
        }
        return tInvoke;
    }

    @Override // v8.l
    public boolean isInitialized() {
        return this.f35217b != g0.f35184a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ w(h9.a aVar, Object obj, int i10, kotlin.jvm.internal.k kVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }
}
