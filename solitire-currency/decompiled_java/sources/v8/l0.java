package v8;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l0<T> implements l<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private h9.a<? extends T> f35198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Object f35199b;

    public l0(@NotNull h9.a<? extends T> initializer) {
        kotlin.jvm.internal.t.i(initializer, "initializer");
        this.f35198a = initializer;
        this.f35199b = g0.f35184a;
    }

    @Override // v8.l
    public T getValue() {
        if (this.f35199b == g0.f35184a) {
            h9.a<? extends T> aVar = this.f35198a;
            kotlin.jvm.internal.t.f(aVar);
            this.f35199b = aVar.invoke();
            this.f35198a = null;
        }
        return (T) this.f35199b;
    }

    @Override // v8.l
    public boolean isInitialized() {
        return this.f35199b != g0.f35184a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
