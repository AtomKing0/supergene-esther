package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class o3 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3538b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o3(Braze braze, String str) {
        super(0);
        this.f3537a = braze;
        this.f3538b = str;
    }

    @Override // h9.a
    public final Object invoke() {
        tf tfVar = ((ci0) this.f3537a.getUdm$android_sdk_base_release()).f2570v;
        String campaignId = this.f3538b;
        tfVar.getClass();
        kotlin.jvm.internal.t.i(campaignId, "campaignId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) tfVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) bf.f2446a, 7, (Object) null);
        tfVar.f3928j.a(campaignId);
        return v8.k0.f35197a;
    }
}
