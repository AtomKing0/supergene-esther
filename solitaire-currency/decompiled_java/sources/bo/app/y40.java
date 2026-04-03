package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class y40 implements d10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f4323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w00 f4324b;

    public y40(l00 originalRequest, w00 connectionResult) {
        kotlin.jvm.internal.t.i(originalRequest, "originalRequest");
        kotlin.jvm.internal.t.i(connectionResult, "connectionResult");
        this.f4323a = originalRequest;
        this.f4324b = connectionResult;
    }

    @Override // bo.app.d10
    public final String a() {
        return "An error occurred during request processing, resulting in no valid response being received. Check the error log for more details.";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y40)) {
            return false;
        }
        y40 y40Var = (y40) obj;
        return kotlin.jvm.internal.t.d(this.f4323a, y40Var.f4323a) && kotlin.jvm.internal.t.d("An error occurred during request processing, resulting in no valid response being received. Check the error log for more details.", "An error occurred during request processing, resulting in no valid response being received. Check the error log for more details.") && kotlin.jvm.internal.t.d(this.f4324b, y40Var.f4324b);
    }

    public final int hashCode() {
        return this.f4324b.hashCode() + (((this.f4323a.hashCode() * 31) - 525898564) * 31);
    }

    public final String toString() {
        return "NetworkCommunicationFailureResponseError(originalRequest=" + this.f4323a + ", errorMessage=An error occurred during request processing, resulting in no valid response being received. Check the error log for more details., connectionResult=" + this.f4324b + ')';
    }
}
