package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class v70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f4077a;

    public v70(l00 request) {
        kotlin.jvm.internal.t.i(request, "request");
        this.f4077a = request;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v70) && kotlin.jvm.internal.t.d(this.f4077a, ((v70) obj).f4077a);
    }

    public final int hashCode() {
        return this.f4077a.hashCode();
    }

    public final String toString() {
        return "RequestDispatchCompletedEvent(request=" + this.f4077a + ')';
    }
}
