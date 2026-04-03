package bo.app;

import com.braze.BrazeUser;

/* JADX INFO: loaded from: classes2.dex */
public final class jj extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f3163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3164b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jj(BrazeUser brazeUser, String str, z8.d dVar) {
        super(2, dVar);
        this.f3163a = brazeUser;
        this.f3164b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new jj(this.f3163a, this.f3164b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new jj(this.f3163a, this.f3164b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f3163a.userCache;
        String dateString = this.f3164b;
        synchronized (uh0Var) {
            kotlin.jvm.internal.t.i(dateString, "dateString");
            uh0Var.b("dob", dateString);
        }
        return v8.k0.f35197a;
    }
}
