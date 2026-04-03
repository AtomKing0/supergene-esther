package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class u5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3990a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u5(Braze braze) {
        super(0);
        this.f3990a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        ((ci0) this.f3990a.getUdm$android_sdk_base_release()).f2572x.initializeGeofences();
        return v8.k0.f35197a;
    }
}
