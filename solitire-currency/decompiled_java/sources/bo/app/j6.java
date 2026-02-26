package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class j6 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Braze f3128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h9.p f3130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h9.a f3131f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j6(boolean z10, Braze braze, Object obj, h9.p pVar, h9.a aVar, z8.d dVar) {
        super(2, dVar);
        this.f3127b = z10;
        this.f3128c = braze;
        this.f3129d = obj;
        this.f3130e = pVar;
        this.f3131f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new j6(this.f3127b, this.f3128c, this.f3129d, this.f3130e, this.f3131f, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((j6) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        int i10 = this.f3126a;
        if (i10 == 0) {
            v8.u.b(obj);
            kotlinx.coroutines.v0 v0VarB = kotlinx.coroutines.k.b(qa0.f3696a, null, null, new i6(this.f3127b, this.f3128c, this.f3129d, this.f3130e, this.f3131f, null), 3, null);
            this.f3126a = 1;
            obj = v0VarB.i0(this);
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
