package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class x5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f4243a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x5(Braze braze) {
        super(0);
        this.f4243a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f4243a, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) w5.f4166a, 6, (Object) null);
        tf tfVar = ((ci0) this.f4243a.getUdm$android_sdk_base_release()).f2570v;
        tfVar.getClass();
        tfVar.a(new j50());
        return v8.k0.f35197a;
    }
}
