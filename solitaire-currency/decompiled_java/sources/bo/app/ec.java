package bo.app;

import com.braze.enums.GeofenceTransitionType;

/* JADX INFO: loaded from: classes2.dex */
public final class ec extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GeofenceTransitionType f2725d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ec(long j10, int i10, String str, GeofenceTransitionType geofenceTransitionType) {
        super(0);
        this.f2722a = j10;
        this.f2723b = i10;
        this.f2724c = str;
        this.f2725d = geofenceTransitionType;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Geofence report suppressed since only " + this.f2722a + " seconds have passed since the last time this geofence/transition combination was reported (minimum interval: " + this.f2723b + "). id:" + this.f2724c + " transition:" + this.f2725d;
    }
}
