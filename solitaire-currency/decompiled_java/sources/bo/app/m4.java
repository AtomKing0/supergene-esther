package bo.app;

import com.braze.Braze;
import com.braze.enums.GeofenceTransitionType;

/* JADX INFO: loaded from: classes2.dex */
public final class m4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GeofenceTransitionType f3390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Braze f3391c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m4(String str, GeofenceTransitionType geofenceTransitionType, Braze braze) {
        super(0);
        this.f3389a = str;
        this.f3390b = geofenceTransitionType;
        this.f3391c = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        String str = this.f3389a;
        if (str != null && !p9.q.z(str) && this.f3390b != null) {
            ((ci0) this.f3391c.getUdm$android_sdk_base_release()).f2572x.postGeofenceReport(this.f3389a, this.f3390b);
        }
        return v8.k0.f35197a;
    }
}
