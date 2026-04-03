package v8;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class x<A, B, C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f35219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f35220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C f35221c;

    public x(A a10, B b10, C c10) {
        this.f35219a = a10;
        this.f35220b = b10;
        this.f35221c = c10;
    }

    public final A a() {
        return this.f35219a;
    }

    public final B b() {
        return this.f35220b;
    }

    public final C c() {
        return this.f35221c;
    }

    public final A d() {
        return this.f35219a;
    }

    public final B e() {
        return this.f35220b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kotlin.jvm.internal.t.d(this.f35219a, xVar.f35219a) && kotlin.jvm.internal.t.d(this.f35220b, xVar.f35220b) && kotlin.jvm.internal.t.d(this.f35221c, xVar.f35221c);
    }

    public final C f() {
        return this.f35221c;
    }

    public int hashCode() {
        A a10 = this.f35219a;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f35220b;
        int iHashCode2 = (iHashCode + (b10 == null ? 0 : b10.hashCode())) * 31;
        C c10 = this.f35221c;
        return iHashCode2 + (c10 != null ? c10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return '(' + this.f35219a + ", " + this.f35220b + ", " + this.f35221c + ')';
    }
}
