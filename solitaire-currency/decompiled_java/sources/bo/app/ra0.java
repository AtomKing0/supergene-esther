package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ra0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3760b;

    public ra0(int i10, int i11) {
        this.f3759a = i10;
        this.f3760b = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ra0)) {
            return false;
        }
        ra0 ra0Var = (ra0) obj;
        return this.f3759a == ra0Var.f3759a && this.f3760b == ra0Var.f3760b;
    }

    public final int hashCode() {
        return this.f3760b + (this.f3759a * 31);
    }

    public final String toString() {
        return "RateLimitEndpointConfig(capacity=" + this.f3759a + ", refillRate=" + this.f3760b + ')';
    }
}
