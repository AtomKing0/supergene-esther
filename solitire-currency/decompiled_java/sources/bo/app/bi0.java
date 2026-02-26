package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class bi0 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ci0 f2459b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi0(ci0 ci0Var, z8.d dVar) {
        super(2, dVar);
        this.f2459b = ci0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        bi0 bi0Var = new bi0(this.f2459b, dVar);
        bi0Var.f2458a = obj;
        return bi0Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        bi0 bi0Var = new bi0(this.f2459b, (z8.d) obj2);
        bi0Var.f2458a = (kotlinx.coroutines.o0) obj;
        return bi0Var.invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.f2458a;
        try {
            if (this.f2459b.x().f2760a.b() == 0) {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) o0Var, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) vh0.f4118a, 6, (Object) null);
                uh0 uh0VarX = this.f2459b.x();
                uh0VarX.getClass();
                kotlinx.coroutines.j.b(null, new e(uh0VarX, null), 1, null);
                BrazeLogger.brazelog$default(brazeLogger, (Object) o0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) wh0.f4210a, 7, (Object) null);
            }
            if (this.f2459b.j().f2760a.b() == 0) {
                BrazeLogger brazeLogger2 = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger2, (Object) o0Var, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) xh0.f4273a, 6, (Object) null);
                zq zqVarJ = this.f2459b.j();
                zqVarJ.getClass();
                kotlinx.coroutines.j.b(null, new e(zqVarJ, null), 1, null);
                BrazeLogger.brazelog$default(brazeLogger2, (Object) o0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) yh0.f4367a, 7, (Object) null);
            }
            this.f2459b.E.b();
            this.f2459b.f2559k.a();
            ci ciVar = this.f2459b.f2563o;
            ciVar.getClass();
            try {
                nh nhVar = ciVar.f2546j;
                if (nhVar != null) {
                    ciVar.f2537a.unregisterReceiver(nhVar);
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) ciVar, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) yh.f4366a, 4, (Object) null);
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, BrazeLogger.Priority.W, (Throwable) e11, false, (h9.a) zh0.f4445a, 4, (Object) null);
        }
        try {
            this.f2459b.f2562n.c();
        } catch (Exception e12) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, BrazeLogger.Priority.W, (Throwable) e12, false, (h9.a) ai0.f2388a, 4, (Object) null);
        }
        return v8.k0.f35197a;
    }
}
