package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class hc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rc f2970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2971c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hc(long j10, rc rcVar, String str) {
        super(0);
        this.f2969a = j10;
        this.f2970b = rcVar;
        this.f2971c = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Geofence report eligible since " + this.f2969a + " seconds have passed since the last time geofences were reported globally (minimum interval: " + this.f2970b.f3770h + "). id:" + this.f2971c;
    }
}
