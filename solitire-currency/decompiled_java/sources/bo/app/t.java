package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements d10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l00 f3884b;

    public t(String str, l00 originalRequest) {
        kotlin.jvm.internal.t.i(originalRequest, "originalRequest");
        this.f3883a = str;
        this.f3884b = originalRequest;
    }

    @Override // bo.app.d10
    public final String a() {
        return this.f3883a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return kotlin.jvm.internal.t.d(this.f3883a, tVar.f3883a) && kotlin.jvm.internal.t.d(this.f3884b, tVar.f3884b);
    }

    public final int hashCode() {
        String str = this.f3883a;
        return this.f3884b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "BasicResponseError(errorMessage=" + this.f3883a + ", originalRequest=" + this.f3884b + ')';
    }
}
