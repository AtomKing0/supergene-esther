package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class x30 implements d10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l00 f4240b;

    public x30(String str, l00 originalRequest) {
        kotlin.jvm.internal.t.i(originalRequest, "originalRequest");
        this.f4239a = str;
        this.f4240b = originalRequest;
    }

    @Override // bo.app.d10
    public final String a() {
        return this.f4239a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x30)) {
            return false;
        }
        x30 x30Var = (x30) obj;
        return kotlin.jvm.internal.t.d(this.f4239a, x30Var.f4239a) && kotlin.jvm.internal.t.d(this.f4240b, x30Var.f4240b);
    }

    public final int hashCode() {
        String str = this.f4239a;
        return this.f4240b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "InvalidApiKeyError(errorMessage=" + this.f4239a + ", originalRequest=" + this.f4240b + ')';
    }
}
