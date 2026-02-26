package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class l90 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w90 f3319b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l90(w90 w90Var, z8.d dVar) {
        super(2, dVar);
        this.f3319b = w90Var;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new l90(this.f3319b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new l90(this.f3319b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        int i10 = this.f3318a;
        if (i10 == 0) {
            v8.u.b(obj);
            w90 w90Var = this.f3319b;
            this.f3318a = 1;
            if (w90Var.a() == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
        }
        return v8.k0.f35197a;
    }
}
