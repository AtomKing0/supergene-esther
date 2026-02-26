package bo.app;

import com.braze.Braze;
import com.braze.events.InAppMessageEvent;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class o4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InAppMessageEvent f3541b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o4(Braze braze, InAppMessageEvent inAppMessageEvent) {
        super(0);
        this.f3540a = braze;
        this.f3541b = inAppMessageEvent;
    }

    @Override // h9.a
    public final Object invoke() {
        cg0 cg0Var = ((ci0) this.f3540a.getUdm$android_sdk_base_release()).f2571w;
        k10 action = this.f3541b.getTriggerAction();
        cg0Var.getClass();
        kotlin.jvm.internal.t.i(action, "action");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, cg0.f2514q, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new nf0(action), 14, (Object) null);
        long j10 = cg0Var.f2526l;
        cg0Var.f2526l = cg0Var.f2527m;
        cg0Var.f2527m = j10;
        BrazeLogger.brazelog$default(brazeLogger, (Object) cg0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new kf0(j10), 7, (Object) null);
        cg0Var.f2526l = 0L;
        cg0Var.f2522h.b(action);
        return v8.k0.f35197a;
    }
}
