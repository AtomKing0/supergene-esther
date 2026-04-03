package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class d5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f2624a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d5(Braze braze) {
        super(0);
        this.f2624a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        if (((ci0) this.f2624a.getUdm$android_sdk_base_release()).f2556h.w()) {
            i.k.a(((ci0) this.f2624a.getUdm$android_sdk_base_release()).f2570v, ((ci0) this.f2624a.getUdm$android_sdk_base_release()).B.f3266c, ((ci0) this.f2624a.getUdm$android_sdk_base_release()).B.f3267d);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f2624a, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) c5.f2483a, 7, (Object) null);
        }
        return v8.k0.f35197a;
    }
}
