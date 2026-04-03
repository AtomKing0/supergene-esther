package bo.app;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class nm extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kn f3497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f3498b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm(kn knVar, Set set, z8.d dVar) {
        super(2, dVar);
        this.f3497a = knVar;
        this.f3498b = set;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new nm(this.f3497a, this.f3498b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new nm(this.f3497a, this.f3498b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        this.f3497a.f3273j.edit().putStringSet("test", this.f3498b).apply();
        return v8.k0.f35197a;
    }
}
