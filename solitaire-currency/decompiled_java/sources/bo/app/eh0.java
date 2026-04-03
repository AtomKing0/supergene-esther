package bo.app;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class eh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2736a;

    public eh0(List triggeredActions) {
        kotlin.jvm.internal.t.i(triggeredActions, "triggeredActions");
        this.f2736a = triggeredActions;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof eh0) && kotlin.jvm.internal.t.d(this.f2736a, ((eh0) obj).f2736a);
    }

    public final int hashCode() {
        return this.f2736a.hashCode();
    }

    public final String toString() {
        return "TriggeredActionsReceivedEvent(triggeredActions=" + this.f2736a + ')';
    }
}
