package bo.app;

import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes2.dex */
public final class q8 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Number f3690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h9.l f3691d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q8(Number number, h9.l lVar, z8.d dVar) {
        super(2, dVar);
        this.f3690c = number;
        this.f3691d = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        q8 q8Var = new q8(this.f3690c, this.f3691d, dVar);
        q8Var.f3689b = obj;
        return q8Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((q8) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlinx.coroutines.o0 o0Var;
        Object objE = a9.d.e();
        int i10 = this.f3688a;
        if (i10 == 0) {
            v8.u.b(obj);
            o0Var = (kotlinx.coroutines.o0) this.f3689b;
            long jLongValue = this.f3690c.longValue();
            this.f3689b = o0Var;
            this.f3688a = 1;
            if (y0.a(jLongValue, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return v8.k0.f35197a;
            }
            o0Var = (kotlinx.coroutines.o0) this.f3689b;
            v8.u.b(obj);
        }
        if (kotlinx.coroutines.p0.h(o0Var)) {
            h9.l lVar = this.f3691d;
            this.f3689b = null;
            this.f3688a = 2;
            if (lVar.invoke(this) == objE) {
                return objE;
            }
        }
        return v8.k0.f35197a;
    }
}
