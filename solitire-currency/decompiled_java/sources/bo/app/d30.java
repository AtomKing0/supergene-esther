package bo.app;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class d30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g10 f2617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k10 f2618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IInAppMessage f2619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2620d;

    public d30(g10 triggerEvent, k10 triggeredAction, IInAppMessage inAppMessage, String str) {
        kotlin.jvm.internal.t.i(triggerEvent, "triggerEvent");
        kotlin.jvm.internal.t.i(triggeredAction, "triggeredAction");
        kotlin.jvm.internal.t.i(inAppMessage, "inAppMessage");
        this.f2617a = triggerEvent;
        this.f2618b = triggeredAction;
        this.f2619c = inAppMessage;
        this.f2620d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d30)) {
            return false;
        }
        d30 d30Var = (d30) obj;
        return kotlin.jvm.internal.t.d(this.f2617a, d30Var.f2617a) && kotlin.jvm.internal.t.d(this.f2618b, d30Var.f2618b) && kotlin.jvm.internal.t.d(this.f2619c, d30Var.f2619c) && kotlin.jvm.internal.t.d(this.f2620d, d30Var.f2620d);
    }

    public final int hashCode() {
        int iHashCode = (this.f2619c.hashCode() + ((this.f2618b.hashCode() + (this.f2617a.hashCode() * 31)) * 31)) * 31;
        String str = this.f2620d;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return p9.j.f("\n             " + JsonUtils.getPrettyPrintedString(this.f2619c.forJsonPut()) + "\n             Triggered Action Id: " + ((bh0) this.f2618b).f2452a + "\n             Trigger Event: " + this.f2617a + "\n             User Id: " + this.f2620d + "\n        ");
    }
}
