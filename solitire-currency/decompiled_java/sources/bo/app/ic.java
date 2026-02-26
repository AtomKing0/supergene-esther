package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ic extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rc f3043b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ic(long j10, rc rcVar) {
        super(0);
        this.f3042a = j10;
        this.f3043b = rcVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Geofence request suppressed since only " + this.f3042a + " seconds have passed since the last time geofences were requested (minimum interval: " + this.f3043b.f3769g + ").";
    }
}
