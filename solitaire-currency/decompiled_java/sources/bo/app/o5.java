package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class o5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3544b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o5(Braze braze, boolean z10) {
        super(0);
        this.f3543a = braze;
        this.f3544b = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        ((ci0) this.f3543a.getUdm$android_sdk_base_release()).f2572x.requestGeofenceRefresh(this.f3544b);
        return v8.k0.f35197a;
    }
}
