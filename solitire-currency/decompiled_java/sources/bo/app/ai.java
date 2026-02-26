package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;
import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes2.dex */
public final class ai extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ci f2387b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ci ciVar, z8.d dVar) {
        super(2, dVar);
        this.f2387b = ciVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new ai(this.f2387b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new ai(this.f2387b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        int i10 = this.f2386a;
        if (i10 == 0) {
            v8.u.b(obj);
            long j10 = ci.f2535n;
            this.f2386a = 1;
            if (y0.a(j10, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, ci.f2534m, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) zh.f4444a, 14, (Object) null);
        Braze.Companion.getInstance(this.f2387b.f2537a).requestImmediateDataFlush();
        return v8.k0.f35197a;
    }
}
