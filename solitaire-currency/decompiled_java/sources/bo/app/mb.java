package bo.app;

import com.braze.managers.BrazeGeofenceManager;

/* JADX INFO: loaded from: classes2.dex */
public final class mb extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeGeofenceManager f3405a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb(BrazeGeofenceManager brazeGeofenceManager) {
        super(0);
        this.f3405a = brazeGeofenceManager;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Reached maximum number of new geofences: " + this.f3405a.getMaxNumToRegister();
    }
}
