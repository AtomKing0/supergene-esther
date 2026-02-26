package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class i90 implements d10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f3035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3038d;

    public i90(l00 originalRequest, int i10, String str, String str2) {
        kotlin.jvm.internal.t.i(originalRequest, "originalRequest");
        this.f3035a = originalRequest;
        this.f3036b = i10;
        this.f3037c = str;
        this.f3038d = str2;
    }

    @Override // bo.app.d10
    public final String a() {
        return this.f3038d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i90)) {
            return false;
        }
        i90 i90Var = (i90) obj;
        return kotlin.jvm.internal.t.d(this.f3035a, i90Var.f3035a) && this.f3036b == i90Var.f3036b && kotlin.jvm.internal.t.d(this.f3037c, i90Var.f3037c) && kotlin.jvm.internal.t.d(this.f3038d, i90Var.f3038d);
    }

    public final int hashCode() {
        int iHashCode = (this.f3036b + (this.f3035a.hashCode() * 31)) * 31;
        String str = this.f3037c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f3038d;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{code = ");
        sb.append(this.f3036b);
        sb.append(", reason = ");
        sb.append(this.f3037c);
        sb.append(", message = ");
        return h1.a(sb, this.f3038d, '}');
    }
}
