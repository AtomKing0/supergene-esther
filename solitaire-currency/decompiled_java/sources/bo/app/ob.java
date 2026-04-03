package bo.app;

import com.braze.managers.BrazeGeofenceManager;

/* JADX INFO: loaded from: classes2.dex */
public final class ob extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeGeofenceManager f3553a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ob(BrazeGeofenceManager brazeGeofenceManager) {
        super(0);
        this.f3553a = brazeGeofenceManager;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Added " + this.f3553a.getBrazeGeofences().size() + " new geofences to local storage.";
    }
}
