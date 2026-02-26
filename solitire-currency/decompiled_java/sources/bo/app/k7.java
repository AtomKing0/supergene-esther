package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class k7 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3222b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k7(Braze braze, String str, z8.d dVar) {
        super(2, dVar);
        this.f3221a = braze;
        this.f3222b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new k7(this.f3221a, this.f3222b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new k7(this.f3221a, this.f3222b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        return kotlin.coroutines.jvm.internal.b.a(((ci0) this.f3221a.getUdm$android_sdk_base_release()).f2568t.a(this.f3222b));
    }
}
