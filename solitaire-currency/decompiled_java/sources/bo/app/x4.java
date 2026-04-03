package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class x4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f4241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4242b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x4(Braze braze, String str) {
        super(0);
        this.f4241a = braze;
        this.f4242b = str;
    }

    @Override // h9.a
    public final Object invoke() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this.f4241a, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new v4(this.f4242b), 6, (Object) null);
        String str = this.f4242b;
        if (str == null || p9.q.z(str)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this.f4241a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) w4.f4165a, 6, (Object) null);
        } else {
            z00 z00Var = this.f4241a.registrationDataProvider;
            if (z00Var == null) {
                kotlin.jvm.internal.t.A("registrationDataProvider");
                z00Var = null;
            }
            ((i70) z00Var).a(this.f4242b);
            ((ci0) this.f4241a.getUdm$android_sdk_base_release()).j().c();
            this.f4241a.requestImmediateDataFlush();
        }
        return v8.k0.f35197a;
    }
}
