package bo.app;

import com.braze.Braze;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.ValidationUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class u2 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f3982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BrazeProperties f3983c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u2(String str, Braze braze, BrazeProperties brazeProperties) {
        super(0);
        this.f3981a = str;
        this.f3982b = braze;
        this.f3983c = brazeProperties;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Object, java.lang.String] */
    @Override // h9.a
    public final Object invoke() {
        kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        ?? r12 = this.f3981a;
        n0Var.f29834a = r12;
        if (ValidationUtils.isValidLogCustomEventInput(r12, ((ci0) this.f3982b.getUdm$android_sdk_base_release()).f2556h)) {
            BrazeProperties brazeProperties = this.f3983c;
            if (brazeProperties == null || !brazeProperties.isInvalid()) {
                ?? eventName = ValidationUtils.ensureBrazeFieldLength((String) n0Var.f29834a);
                n0Var.f29834a = eventName;
                z9 z9Var = ba.f2429g;
                BrazeProperties brazeProperties2 = this.f3983c;
                z9Var.getClass();
                kotlin.jvm.internal.t.i(eventName, "eventName");
                e00 e00VarA = z9Var.a(new y8(eventName, brazeProperties2));
                if (e00VarA != null) {
                    if (this.f3982b.isEphemeralEventKey((String) n0Var.f29834a) ? ((ci0) this.f3982b.getUdm$android_sdk_base_release()).f2556h.y() : ((ci0) this.f3982b.getUdm$android_sdk_base_release()).f2570v.a(e00VarA)) {
                        ((ci0) this.f3982b.getUdm$android_sdk_base_release()).f2571w.b(new yn((String) n0Var.f29834a, this.f3983c, e00VarA));
                    }
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3982b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new t2(n0Var), 6, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3982b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new s2(n0Var), 6, (Object) null);
        }
        return v8.k0.f35197a;
    }
}
