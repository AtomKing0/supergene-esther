package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class x70 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y70 f4247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z80 f4248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a80 f4249c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x70(y70 y70Var, z80 z80Var, a80 a80Var, z8.d dVar) {
        super(2, dVar);
        this.f4247a = y70Var;
        this.f4248b = z80Var;
        this.f4249c = a80Var;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new x70(this.f4247a, this.f4248b, this.f4249c, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((x70) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        this.f4247a.a(this.f4248b, this.f4249c);
        return v8.k0.f35197a;
    }
}
