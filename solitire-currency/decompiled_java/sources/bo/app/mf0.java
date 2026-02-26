package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class mf0 extends kotlin.coroutines.jvm.internal.l implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f3417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cg0 f3418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g10 f3419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f3420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f3421e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mf0(k10 k10Var, cg0 cg0Var, g10 g10Var, long j10, long j11, z8.d dVar) {
        super(1, dVar);
        this.f3417a = k10Var;
        this.f3418b = cg0Var;
        this.f3419c = g10Var;
        this.f3420d = j10;
        this.f3421e = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(z8.d dVar) {
        return new mf0(this.f3417a, this.f3418b, this.f3419c, this.f3420d, this.f3421e, dVar);
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        return ((mf0) create((z8.d) obj)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, cg0.f2514q, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new lf0(this.f3421e), 14, (Object) null);
        k10 k10Var = this.f3417a;
        cg0 cg0Var = this.f3418b;
        k10Var.a(cg0Var.f2515a, cg0Var.f2517c, this.f3419c, this.f3420d);
        return v8.k0.f35197a;
    }
}
