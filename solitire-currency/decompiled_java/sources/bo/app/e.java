package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y9.d f2693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f2695c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, z8.d dVar) {
        super(2, dVar);
        this.f2695c = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new e(this.f2695c, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new e(this.f2695c, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        y9.d dVar;
        Object objE = a9.d.e();
        int i10 = this.f2694b;
        if (i10 == 0) {
            v8.u.b(obj);
            y9.d dVar2 = this.f2695c.f2760a;
            this.f2693a = dVar2;
            this.f2694b = 1;
            if (dVar2.a(this) == objE) {
                return objE;
            }
            dVar = dVar2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = this.f2693a;
            v8.u.b(obj);
        }
        try {
            return v8.k0.f35197a;
        } finally {
            dVar.release();
        }
    }
}
