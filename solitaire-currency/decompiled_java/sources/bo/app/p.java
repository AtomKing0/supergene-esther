package bo.app;

import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f3595b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, z8.d dVar) {
        super(2, dVar);
        this.f3595b = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new p(this.f3595b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new p(this.f3595b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        int i10 = this.f3594a;
        if (i10 == 0) {
            v8.u.b(obj);
            b2 b2Var = this.f3595b.f3671c;
            this.f3594a = 1;
            if (b2Var.z(this) == objE) {
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
