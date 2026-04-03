package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class cc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rc f2499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2500b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(rc rcVar, String str) {
        super(0);
        this.f2499a = rcVar;
        this.f2500b = str;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Retrieving geofence id ");
        rc rcVar = this.f2499a;
        String reEligibilityId = this.f2500b;
        kotlin.jvm.internal.t.h(reEligibilityId, "reEligibilityId");
        sb.append(rcVar.a(reEligibilityId));
        sb.append(" eligibility information from local storage.");
        return sb.toString();
    }
}
