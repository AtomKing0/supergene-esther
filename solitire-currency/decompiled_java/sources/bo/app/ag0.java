package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ag0 extends kotlin.coroutines.jvm.internal.l implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f2377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cg0 f2378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g10 f2379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f2380d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag0(k10 k10Var, cg0 cg0Var, g10 g10Var, long j10, z8.d dVar) {
        super(1, dVar);
        this.f2377a = k10Var;
        this.f2378b = cg0Var;
        this.f2379c = g10Var;
        this.f2380d = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(z8.d dVar) {
        return new ag0(this.f2377a, this.f2378b, this.f2379c, this.f2380d, dVar);
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        return ((ag0) create((z8.d) obj)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        k10 k10Var = this.f2377a;
        cg0 cg0Var = this.f2378b;
        k10Var.a(cg0Var.f2515a, cg0Var.f2517c, this.f2379c, this.f2380d);
        return v8.k0.f35197a;
    }
}
