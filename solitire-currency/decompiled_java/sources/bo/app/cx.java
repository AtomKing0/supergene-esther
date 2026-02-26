package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class cx extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h9.a f2605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ex f2606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f2607d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx(h9.a aVar, ex exVar, String str, z8.d dVar) {
        super(2, dVar);
        this.f2605b = aVar;
        this.f2606c = exVar;
        this.f2607d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        cx cxVar = new cx(this.f2605b, this.f2606c, this.f2607d, dVar);
        cxVar.f2604a = obj;
        return cxVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((cx) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.f2604a;
        try {
            this.f2605b.invoke();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new bx(this.f2607d), 4, (Object) null);
            this.f2606c.a(e10);
        }
        return v8.k0.f35197a;
    }
}
