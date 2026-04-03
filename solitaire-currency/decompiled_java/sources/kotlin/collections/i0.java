package kotlin.collections;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IndexedValue.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f29778b;

    public i0(int i10, T t10) {
        this.f29777a = i10;
        this.f29778b = t10;
    }

    public final int a() {
        return this.f29777a;
    }

    public final T b() {
        return this.f29778b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f29777a == i0Var.f29777a && kotlin.jvm.internal.t.d(this.f29778b, i0Var.f29778b);
    }

    public int hashCode() {
        int i10 = this.f29777a * 31;
        T t10 = this.f29778b;
        return i10 + (t10 == null ? 0 : t10.hashCode());
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.f29777a + ", value=" + this.f29778b + ')';
    }
}
