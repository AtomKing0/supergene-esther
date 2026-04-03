package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f3530a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, z8.d dVar) {
        super(2, dVar);
        this.f3530a = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new o(this.f3530a, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new o(this.f3530a, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        this.f3530a.f3669a.getSharedPreferences("persistent.com.appboy.storage.sdk_enabled_cache", 0);
        return v8.k0.f35197a;
    }
}
