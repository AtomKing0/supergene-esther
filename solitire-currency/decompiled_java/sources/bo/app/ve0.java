package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ve0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e00 f4113b;

    public ve0(String campaignId, e00 pushClickEvent) {
        kotlin.jvm.internal.t.i(campaignId, "campaignId");
        kotlin.jvm.internal.t.i(pushClickEvent, "pushClickEvent");
        this.f4112a = campaignId;
        this.f4113b = pushClickEvent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ve0)) {
            return false;
        }
        ve0 ve0Var = (ve0) obj;
        return kotlin.jvm.internal.t.d(this.f4112a, ve0Var.f4112a) && kotlin.jvm.internal.t.d(this.f4113b, ve0Var.f4113b);
    }

    public final int hashCode() {
        return this.f4113b.hashCode() + (this.f4112a.hashCode() * 31);
    }

    public final String toString() {
        return "TriggerEligiblePushClickEvent(campaignId=" + this.f4112a + ", pushClickEvent=" + this.f4113b + ')';
    }
}
