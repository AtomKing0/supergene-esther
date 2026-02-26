package bo.app;

import com.braze.managers.BrazeGeofenceManager;

/* JADX INFO: loaded from: classes2.dex */
public final class wa extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeGeofenceManager f4186a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa(BrazeGeofenceManager brazeGeofenceManager) {
        super(0);
        this.f4186a = brazeGeofenceManager;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Max number to register newly set to " + this.f4186a.getMaxNumToRegister() + " via server config.";
    }
}
