package bo.app;

import java.io.BufferedReader;
import r9.r;

/* JADX INFO: loaded from: classes2.dex */
public final class rt extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BufferedReader f3804c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt(BufferedReader bufferedReader, z8.d dVar) {
        super(2, dVar);
        this.f3804c = bufferedReader;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        rt rtVar = new rt(this.f3804c, dVar);
        rtVar.f3803b = obj;
        return rtVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        rt rtVar = new rt(this.f3804c, (z8.d) obj2);
        rtVar.f3803b = (r) obj;
        return rtVar.invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        r rVar;
        Object objE = a9.d.e();
        int i10 = this.f3802a;
        if (i10 == 0) {
            v8.u.b(obj);
            rVar = (r) this.f3803b;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            rVar = (r) this.f3803b;
            v8.u.b(obj);
        }
        while (kotlinx.coroutines.p0.h(rVar)) {
            kotlinx.coroutines.k0 k0VarB = kotlinx.coroutines.e1.b();
            qt qtVar = new qt(this.f3804c, rVar, null);
            this.f3803b = rVar;
            this.f3802a = 1;
            if (kotlinx.coroutines.i.g(k0VarB, qtVar, this) == objE) {
                return objE;
            }
        }
        return v8.k0.f35197a;
    }
}
