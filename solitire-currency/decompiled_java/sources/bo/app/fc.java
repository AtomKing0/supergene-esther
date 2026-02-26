package bo.app;

import com.braze.enums.GeofenceTransitionType;

/* JADX INFO: loaded from: classes2.dex */
public final class fc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GeofenceTransitionType f2819d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fc(long j10, int i10, String str, GeofenceTransitionType geofenceTransitionType) {
        super(0);
        this.f2816a = j10;
        this.f2817b = i10;
        this.f2818c = str;
        this.f2819d = geofenceTransitionType;
    }

    @Override // h9.a
    public final Object invoke() {
        return this.f2816a + " seconds have passed since the last time this geofence/transition combination was reported (minimum interval: " + this.f2817b + "). id:" + this.f2818c + " transition:" + this.f2819d;
    }
}
