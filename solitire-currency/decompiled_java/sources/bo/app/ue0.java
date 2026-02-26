package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ue0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f4012a;

    public ue0(l00 request) {
        kotlin.jvm.internal.t.i(request, "request");
        this.f4012a = request;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ue0) && kotlin.jvm.internal.t.d(this.f4012a, ((ue0) obj).f4012a);
    }

    public final int hashCode() {
        return this.f4012a.hashCode();
    }

    public final String toString() {
        return "TriggerDispatchStartedEvent(request=" + this.f4012a + ')';
    }
}
