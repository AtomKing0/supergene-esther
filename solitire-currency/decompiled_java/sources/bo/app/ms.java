package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class ms extends kotlin.coroutines.jvm.internal.l implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xs f3447a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ms(xs xsVar, z8.d dVar) {
        super(1, dVar);
        this.f3447a = xsVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(z8.d dVar) {
        return new ms(this.f3447a, dVar);
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        return new ms(this.f3447a, (z8.d) obj).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3447a, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ls.f3346a, 7, (Object) null);
        this.f3447a.a();
        return v8.k0.f35197a;
    }
}
