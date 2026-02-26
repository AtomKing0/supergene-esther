package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class e6 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Braze f2707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h9.a f2708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h9.a f2709e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e6(boolean z10, Braze braze, h9.a aVar, h9.a aVar2, z8.d dVar) {
        super(2, dVar);
        this.f2706b = z10;
        this.f2707c = braze;
        this.f2708d = aVar;
        this.f2709e = aVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        e6 e6Var = new e6(this.f2706b, this.f2707c, this.f2708d, this.f2709e, dVar);
        e6Var.f2705a = obj;
        return e6Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((e6) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.f2705a;
        if (this.f2706b && this.f2707c.udm == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new d6(this.f2709e), 6, (Object) null);
            return v8.k0.f35197a;
        }
        this.f2708d.invoke();
        return v8.k0.f35197a;
    }
}
