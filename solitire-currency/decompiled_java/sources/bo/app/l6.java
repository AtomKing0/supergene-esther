package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class l6 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3308b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l6(Braze braze, long j10) {
        super(0);
        this.f3307a = braze;
        this.f3308b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        ((ci0) this.f3307a.getUdm$android_sdk_base_release()).f2570v.a(this.f3308b);
        return v8.k0.f35197a;
    }
}
