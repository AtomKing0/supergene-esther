package bo.app;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class sm extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kn f3868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f3869b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sm(kn knVar, Set set, z8.d dVar) {
        super(2, dVar);
        this.f3868a = knVar;
        this.f3869b = set;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new sm(this.f3868a, this.f3869b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new sm(this.f3868a, this.f3869b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        this.f3868a.f3273j.edit().putStringSet("expired", this.f3869b).apply();
        return v8.k0.f35197a;
    }
}
