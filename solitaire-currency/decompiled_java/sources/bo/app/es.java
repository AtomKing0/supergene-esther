package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class es {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f2749a;

    public es(l00 request) {
        kotlin.jvm.internal.t.i(request, "request");
        this.f2749a = request;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof es) && kotlin.jvm.internal.t.d(this.f2749a, ((es) obj).f2749a);
    }

    public final int hashCode() {
        return this.f2749a.hashCode();
    }

    public final String toString() {
        return "DispatchSucceededEvent(request=" + this.f2749a + ')';
    }
}
