package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class s90 extends kotlin.coroutines.jvm.internal.l implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w90 f3842b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s90(w90 w90Var, z8.d dVar) {
        super(1, dVar);
        this.f3842b = w90Var;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(z8.d dVar) {
        return new s90(this.f3842b, dVar);
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        return new s90(this.f3842b, (z8.d) obj).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        int i10 = this.f3841a;
        if (i10 == 0) {
            v8.u.b(obj);
            w90 w90Var = this.f3842b;
            this.f3841a = 1;
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
