package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ma0 implements d10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f3402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3404c;

    public ma0(l00 originalRequest, int i10, String str) {
        kotlin.jvm.internal.t.i(originalRequest, "originalRequest");
        this.f3402a = originalRequest;
        this.f3403b = i10;
        this.f3404c = str;
    }

    @Override // bo.app.d10
    public final String a() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ma0)) {
            return false;
        }
        ma0 ma0Var = (ma0) obj;
        return kotlin.jvm.internal.t.d(this.f3402a, ma0Var.f3402a) && this.f3403b == ma0Var.f3403b && kotlin.jvm.internal.t.d(this.f3404c, ma0Var.f3404c);
    }

    public final int hashCode() {
        int iHashCode = (this.f3403b + (this.f3402a.hashCode() * 31)) * 31;
        String str = this.f3404c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{code = ");
        sb.append(this.f3403b);
        sb.append(", reason = ");
        return h1.a(sb, this.f3404c, '}');
    }
}
