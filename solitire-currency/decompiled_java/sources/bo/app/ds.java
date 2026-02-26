package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f2679a;

    public ds(l00 request) {
        kotlin.jvm.internal.t.i(request, "request");
        this.f2679a = request;
        request.b();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ds) && kotlin.jvm.internal.t.d(this.f2679a, ((ds) obj).f2679a);
    }

    public final int hashCode() {
        return this.f2679a.hashCode();
    }

    public final String toString() {
        return "DispatchFailedEvent(request=" + this.f2679a + ')';
    }
}
