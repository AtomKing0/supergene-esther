package bo.app;

import com.braze.BrazeUser;

/* JADX INFO: loaded from: classes2.dex */
public final class xi extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f4274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4276c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xi(BrazeUser brazeUser, String str, Object obj, z8.d dVar) {
        super(2, dVar);
        this.f4274a = brazeUser;
        this.f4275b = str;
        this.f4276c = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new xi(this.f4274a, this.f4275b, this.f4276c, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((xi) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f4274a.userCache;
        String key = this.f4275b;
        Object value = this.f4276c;
        synchronized (uh0Var) {
            kotlin.jvm.internal.t.i(key, "key");
            kotlin.jvm.internal.t.i(value, "value");
            uh0Var.a(key, value);
        }
        return v8.k0.f35197a;
    }
}
