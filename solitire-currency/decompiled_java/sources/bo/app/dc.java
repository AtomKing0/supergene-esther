package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class dc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rc f2641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2642c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(long j10, rc rcVar, String str) {
        super(0);
        this.f2640a = j10;
        this.f2641b = rcVar;
        this.f2642c = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Geofence report suppressed since only " + this.f2640a + " seconds have passed since the last time geofences were reported globally (minimum interval: " + this.f2641b.f3770h + "). id:" + this.f2642c;
    }
}
