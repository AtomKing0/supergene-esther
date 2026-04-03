package bo.app;

import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes2.dex */
public final class ye extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tf f4355b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ye(tf tfVar, z8.d dVar) {
        super(2, dVar);
        this.f4355b = tfVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new ye(this.f4355b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new ye(this.f4355b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        int i10 = this.f4354a;
        if (i10 == 0) {
            v8.u.b(obj);
            this.f4354a = 1;
            if (y0.a(1000L, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
        }
        tf tfVar = this.f4355b;
        tfVar.getClass();
        tfVar.a(new j50());
        return v8.k0.f35197a;
    }
}
