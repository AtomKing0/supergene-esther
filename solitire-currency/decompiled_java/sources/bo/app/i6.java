package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class i6 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f3023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f3024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h9.p f3026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h9.a f3027e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i6(boolean z10, Braze braze, Object obj, h9.p pVar, h9.a aVar, z8.d dVar) {
        super(2, dVar);
        this.f3023a = z10;
        this.f3024b = braze;
        this.f3025c = obj;
        this.f3026d = pVar;
        this.f3027e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new i6(this.f3023a, this.f3024b, this.f3025c, this.f3026d, this.f3027e, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((i6) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        return kotlinx.coroutines.j.b(null, new h6(this.f3023a, this.f3024b, this.f3025c, this.f3026d, this.f3027e, null), 1, null);
    }
}
