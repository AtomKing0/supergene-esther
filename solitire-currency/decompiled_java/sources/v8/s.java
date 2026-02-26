package v8;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f35206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f35207b;

    public s(A a10, B b10) {
        this.f35206a = a10;
        this.f35207b = b10;
    }

    public final A a() {
        return this.f35206a;
    }

    public final B b() {
        return this.f35207b;
    }

    public final A c() {
        return this.f35206a;
    }

    public final B d() {
        return this.f35207b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.t.d(this.f35206a, sVar.f35206a) && kotlin.jvm.internal.t.d(this.f35207b, sVar.f35207b);
    }

    public int hashCode() {
        A a10 = this.f35206a;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f35207b;
        return iHashCode + (b10 != null ? b10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return '(' + this.f35206a + ", " + this.f35207b + ')';
    }
}
