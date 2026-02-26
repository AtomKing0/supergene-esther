package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class gm extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kn f2918a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm(kn knVar, z8.d dVar) {
        super(2, dVar);
        this.f2918a = knVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new gm(this.f2918a, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new gm(this.f2918a, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        this.f2918a.f3273j.edit().putStringSet("expired", this.f2918a.f3270g).apply();
        return v8.k0.f35197a;
    }
}
