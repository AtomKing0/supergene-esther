package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d10 f4189a;

    public wb0(d10 responseError) {
        kotlin.jvm.internal.t.i(responseError, "responseError");
        this.f4189a = responseError;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof wb0) && kotlin.jvm.internal.t.d(this.f4189a, ((wb0) obj).f4189a);
    }

    public final int hashCode() {
        return this.f4189a.hashCode();
    }

    public final String toString() {
        return "ServerResponseErrorEvent(responseError=" + this.f4189a + ')';
    }
}
