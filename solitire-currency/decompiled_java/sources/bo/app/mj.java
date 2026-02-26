package bo.app;

import com.braze.BrazeUser;

/* JADX INFO: loaded from: classes2.dex */
public final class mj extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f3430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3431b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mj(BrazeUser brazeUser, String str, z8.d dVar) {
        super(2, dVar);
        this.f3430a = brazeUser;
        this.f3431b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new mj(this.f3430a, this.f3431b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new mj(this.f3430a, this.f3431b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f3430a.userCache;
        String str = this.f3431b;
        synchronized (uh0Var) {
            uh0Var.b("email", str);
        }
        return v8.k0.f35197a;
    }
}
