package bo.app;

import com.braze.models.BrazeGeofence;

/* JADX INFO: loaded from: classes2.dex */
public final class nb extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeGeofence f3477a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nb(BrazeGeofence brazeGeofence) {
        super(0);
        this.f3477a = brazeGeofence;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Adding new geofence to local storage: " + this.f3477a;
    }
}
