package bo.app;

import com.braze.enums.GeofenceTransitionType;

/* JADX INFO: loaded from: classes2.dex */
public final class gc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GeofenceTransitionType f2895b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc(String str, GeofenceTransitionType geofenceTransitionType) {
        super(0);
        this.f2894a = str;
        this.f2895b = geofenceTransitionType;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Geofence report eligible since this geofence/transition combination has never been reported.id:" + this.f2894a + " transition:" + this.f2895b;
    }
}
