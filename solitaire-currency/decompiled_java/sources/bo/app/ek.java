package bo.app;

import com.braze.BrazeUser;

/* JADX INFO: loaded from: classes2.dex */
public final class ek extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f2740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2741b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ek(BrazeUser brazeUser, String str, z8.d dVar) {
        super(2, dVar);
        this.f2740a = brazeUser;
        this.f2741b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new ek(this.f2740a, this.f2741b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new ek(this.f2740a, this.f2741b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f2740a.userCache;
        String str = this.f2741b;
        synchronized (uh0Var) {
            uh0Var.b("last_name", str);
        }
        return v8.k0.f35197a;
    }
}
