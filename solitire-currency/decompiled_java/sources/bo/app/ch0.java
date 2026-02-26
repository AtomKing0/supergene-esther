package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ch0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g10 f2532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k10 f2533b;

    public ch0(g10 originalTriggerEvent, md0 failedTriggeredAction) {
        kotlin.jvm.internal.t.i(originalTriggerEvent, "originalTriggerEvent");
        kotlin.jvm.internal.t.i(failedTriggeredAction, "failedTriggeredAction");
        this.f2532a = originalTriggerEvent;
        this.f2533b = failedTriggeredAction;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ch0)) {
            return false;
        }
        ch0 ch0Var = (ch0) obj;
        return kotlin.jvm.internal.t.d(this.f2532a, ch0Var.f2532a) && kotlin.jvm.internal.t.d(this.f2533b, ch0Var.f2533b);
    }

    public final int hashCode() {
        return this.f2533b.hashCode() + (this.f2532a.hashCode() * 31);
    }

    public final String toString() {
        return "TriggeredActionRetryEvent(originalTriggerEvent=" + this.f2532a + ", failedTriggeredAction=" + this.f2533b + ')';
    }
}
