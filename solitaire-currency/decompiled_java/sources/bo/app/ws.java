package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ws extends kotlin.jvm.internal.q implements h9.l {
    public ws(Object obj) {
        super(1, obj, xs.class, "ingestDustMessages", "ingestDustMessages(Lcom/braze/models/dust/IDustMessage;)V", 0);
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        t00 p02 = (t00) obj;
        kotlin.jvm.internal.t.i(p02, "p0");
        xs xsVar = (xs) this.receiver;
        xsVar.getClass();
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) xsVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new rs(p02), 7, (Object) null);
        int iA = p02.a();
        if (ps.f3659a[gc0.a(iA)] == 1) {
            ((vw) xsVar.f4298b).b(am.class, new am());
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) xsVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ss(iA), 6, (Object) null);
        }
        return v8.k0.f35197a;
    }
}
