package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class f6 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f2768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f2769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h9.a f2770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h9.a f2771d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f6(boolean z10, Braze braze, h9.a aVar, h9.a aVar2, z8.d dVar) {
        super(2, dVar);
        this.f2768a = z10;
        this.f2769b = braze;
        this.f2770c = aVar;
        this.f2771d = aVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new f6(this.f2768a, this.f2769b, this.f2770c, this.f2771d, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((f6) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) throws InterruptedException {
        a9.d.e();
        v8.u.b(obj);
        kotlinx.coroutines.j.b(null, new e6(this.f2768a, this.f2769b, this.f2770c, this.f2771d, null), 1, null);
        return v8.k0.f35197a;
    }
}
