package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f29872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final h9.l<Throwable, v8.k0> f29873b;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(@Nullable Object obj, @NotNull h9.l<? super Throwable, v8.k0> lVar) {
        this.f29872a = obj;
        this.f29873b = lVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return kotlin.jvm.internal.t.d(this.f29872a, d0Var.f29872a) && kotlin.jvm.internal.t.d(this.f29873b, d0Var.f29873b);
    }

    public int hashCode() {
        Object obj = this.f29872a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f29873b.hashCode();
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f29872a + ", onCancellation=" + this.f29873b + ')';
    }
}
