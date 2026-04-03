package bo.app;

import com.braze.BrazeUser;

/* JADX INFO: loaded from: classes2.dex */
public final class sj extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f3865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3866b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sj(BrazeUser brazeUser, String str, z8.d dVar) {
        super(2, dVar);
        this.f3865a = brazeUser;
        this.f3866b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new sj(this.f3865a, this.f3866b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new sj(this.f3865a, this.f3866b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f3865a.userCache;
        String str = this.f3866b;
        synchronized (uh0Var) {
            uh0Var.b("first_name", str);
        }
        return v8.k0.f35197a;
    }
}
