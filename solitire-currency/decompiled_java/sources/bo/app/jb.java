package bo.app;

import com.braze.enums.GeofenceTransitionType;

/* JADX INFO: loaded from: classes2.dex */
public final class jb extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GeofenceTransitionType f3145b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb(String str, GeofenceTransitionType geofenceTransitionType) {
        super(0);
        this.f3144a = str;
        this.f3145b = geofenceTransitionType;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to record geofence " + this.f3144a + " transition with transition type " + this.f3145b + '.';
    }
}
