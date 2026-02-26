package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class m3 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3387c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(Braze braze, String str, long j10) {
        super(0);
        this.f3385a = braze;
        this.f3386b = str;
        this.f3387c = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        tf tfVar = ((ci0) this.f3385a.getUdm$android_sdk_base_release()).f2570v;
        String campaignId = this.f3386b;
        tfVar.getClass();
        kotlin.jvm.internal.t.i(campaignId, "campaignId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) tfVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new af(campaignId), 7, (Object) null);
        tfVar.f3929k.a(campaignId);
        this.f3385a.schedulePushDelivery$android_sdk_base_release(this.f3387c);
        return v8.k0.f35197a;
    }
}
