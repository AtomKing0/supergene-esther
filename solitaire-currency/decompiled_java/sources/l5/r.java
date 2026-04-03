package l5;

import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: compiled from: Dependency.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0<?> f30888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f30890c;

    private r(Class<?> cls, int i10, int i11) {
        this((e0<?>) e0.b(cls), i10, i11);
    }

    private static String a(int i10) {
        if (i10 == 0) {
            return "direct";
        }
        if (i10 == 1) {
            return IronSourceConstants.EVENTS_PROVIDER;
        }
        if (i10 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i10);
    }

    @Deprecated
    public static r g(Class<?> cls) {
        return new r(cls, 0, 0);
    }

    public static r h(Class<?> cls) {
        return new r(cls, 0, 1);
    }

    public static r i(Class<?> cls) {
        return new r(cls, 1, 0);
    }

    public static r j(e0<?> e0Var) {
        return new r(e0Var, 1, 0);
    }

    public static r k(Class<?> cls) {
        return new r(cls, 1, 1);
    }

    public static r l(Class<?> cls) {
        return new r(cls, 2, 0);
    }

    public e0<?> b() {
        return this.f30888a;
    }

    public boolean c() {
        return this.f30890c == 2;
    }

    public boolean d() {
        return this.f30890c == 0;
    }

    public boolean e() {
        return this.f30889b == 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f30888a.equals(rVar.f30888a) && this.f30889b == rVar.f30889b && this.f30890c == rVar.f30890c;
    }

    public boolean f() {
        return this.f30889b == 2;
    }

    public int hashCode() {
        return ((((this.f30888a.hashCode() ^ 1000003) * 1000003) ^ this.f30889b) * 1000003) ^ this.f30890c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f30888a);
        sb.append(", type=");
        int i10 = this.f30889b;
        sb.append(i10 == 1 ? "required" : i10 == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(a(this.f30890c));
        sb.append("}");
        return sb.toString();
    }

    private r(e0<?> e0Var, int i10, int i11) {
        this.f30888a = (e0) d0.c(e0Var, "Null dependency anInterface.");
        this.f30889b = i10;
        this.f30890c = i11;
    }
}
