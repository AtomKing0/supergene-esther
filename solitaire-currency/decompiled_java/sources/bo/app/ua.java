package bo.app;

import com.braze.managers.BrazeGeofenceManager;

/* JADX INFO: loaded from: classes2.dex */
public final class ua extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeGeofenceManager f4002a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua(BrazeGeofenceManager brazeGeofenceManager) {
        super(0);
        this.f4002a = brazeGeofenceManager;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Geofences enabled status newly set to " + this.f4002a.isGeofencesEnabled() + " during server config update.";
    }
}
