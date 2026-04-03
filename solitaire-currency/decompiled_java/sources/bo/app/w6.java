package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class w6 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f4168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4169b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w6(Braze braze, boolean z10) {
        super(0);
        this.f4168a = braze;
        this.f4169b = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        ((ci0) this.f4168a.getUdm$android_sdk_base_release()).f2570v.getClass();
        ((ci0) this.f4168a.getUdm$android_sdk_base_release()).f2562n.a(this.f4169b);
        Braze braze = this.f4168a;
        if (braze.imageLoader != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) braze, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new v6(this.f4169b), 7, (Object) null);
            this.f4168a.getImageLoader().setOffline(this.f4169b);
        }
        return v8.k0.f35197a;
    }
}
