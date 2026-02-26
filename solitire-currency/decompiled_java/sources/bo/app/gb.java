package bo.app;

import com.braze.models.IBrazeLocation;

/* JADX INFO: loaded from: classes2.dex */
public final class gb extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBrazeLocation f2892a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb(IBrazeLocation iBrazeLocation) {
        super(0);
        this.f2892a = iBrazeLocation;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Single location request was successful, requesting Geofence refresh. Location:\n " + this.f2892a;
    }
}
