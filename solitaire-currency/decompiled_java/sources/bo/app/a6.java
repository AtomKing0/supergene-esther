package bo.app;

import com.braze.Braze;
import com.braze.location.IBrazeLocationApi;

/* JADX INFO: loaded from: classes2.dex */
public final class a6 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f2353a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a6(Braze braze) {
        super(0);
        this.f2353a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        zd zdVar = ((ci0) this.f2353a.getUdm$android_sdk_base_release()).f2573y;
        sd sdVar = zdVar.f4431b;
        yd manualLocationUpdateCallback = new yd(zdVar);
        sdVar.getClass();
        kotlin.jvm.internal.t.i(manualLocationUpdateCallback, "manualLocationUpdateCallback");
        IBrazeLocationApi iBrazeLocationApi = sdVar.f3849a;
        if (iBrazeLocationApi != null) {
            iBrazeLocationApi.requestSingleLocationUpdate(manualLocationUpdateCallback);
        }
        return v8.k0.f35197a;
    }
}
