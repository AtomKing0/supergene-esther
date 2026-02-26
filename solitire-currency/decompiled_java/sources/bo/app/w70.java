package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f4171a;

    public w70(l00 request) {
        kotlin.jvm.internal.t.i(request, "request");
        this.f4171a = request;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w70) && kotlin.jvm.internal.t.d(this.f4171a, ((w70) obj).f4171a);
    }

    public final int hashCode() {
        return this.f4171a.hashCode();
    }

    public final String toString() {
        return "RequestDispatchStartedEvent(request=" + this.f4171a + ')';
    }
}
