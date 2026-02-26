package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class h6 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f2953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Braze f2954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h9.p f2956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h9.a f2957g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h6(boolean z10, Braze braze, Object obj, h9.p pVar, h9.a aVar, z8.d dVar) {
        super(2, dVar);
        this.f2953c = z10;
        this.f2954d = braze;
        this.f2955e = obj;
        this.f2956f = pVar;
        this.f2957g = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        h6 h6Var = new h6(this.f2953c, this.f2954d, this.f2955e, this.f2956f, this.f2957g, dVar);
        h6Var.f2952b = obj;
        return h6Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((h6) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        int i10 = this.f2951a;
        if (i10 == 0) {
            v8.u.b(obj);
            kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.f2952b;
            if (this.f2953c && this.f2954d.udm == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new g6(this.f2957g), 6, (Object) null);
                return this.f2955e;
            }
            h9.p pVar = this.f2956f;
            this.f2951a = 1;
            obj = pVar.mo4invoke(o0Var, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
        }
        return obj;
    }
}
