package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class xe0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g10 f4267a;

    public xe0(e20 triggerEvent) {
        kotlin.jvm.internal.t.i(triggerEvent, "triggerEvent");
        this.f4267a = triggerEvent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof xe0) && kotlin.jvm.internal.t.d(this.f4267a, ((xe0) obj).f4267a);
    }

    public final int hashCode() {
        return this.f4267a.hashCode();
    }

    public final String toString() {
        return "TriggerEventEvent(triggerEvent=" + this.f4267a + ')';
    }
}
