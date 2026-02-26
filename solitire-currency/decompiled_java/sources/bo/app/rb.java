package bo.app;

import com.braze.managers.BrazeGeofenceManager;
import com.braze.models.IBrazeLocation;

/* JADX INFO: loaded from: classes2.dex */
public final class rb extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeGeofenceManager f3761a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb(BrazeGeofenceManager brazeGeofenceManager) {
        super(1);
        this.f3761a = brazeGeofenceManager;
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        IBrazeLocation location = (IBrazeLocation) obj;
        kotlin.jvm.internal.t.i(location, "location");
        this.f3761a.onLocationRequestComplete(location);
        return v8.k0.f35197a;
    }
}
