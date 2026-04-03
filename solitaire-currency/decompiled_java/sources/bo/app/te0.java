package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class te0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f3917a;

    public te0(l00 request) {
        kotlin.jvm.internal.t.i(request, "request");
        this.f3917a = request;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof te0) && kotlin.jvm.internal.t.d(this.f3917a, ((te0) obj).f3917a);
    }

    public final int hashCode() {
        return this.f3917a.hashCode();
    }

    public final String toString() {
        return "TriggerDispatchCompletedEvent(request=" + this.f3917a + ')';
    }
}
