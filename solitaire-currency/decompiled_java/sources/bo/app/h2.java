package bo.app;

import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.IValueCallback;

/* JADX INFO: loaded from: classes2.dex */
public final class h2 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IValueCallback f2943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Braze f2944c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h2(IValueCallback iValueCallback, Braze braze, z8.d dVar) {
        super(2, dVar);
        this.f2943b = iValueCallback;
        this.f2944c = braze;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new h2(this.f2943b, this.f2944c, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new h2(this.f2943b, this.f2944c, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        int i10 = this.f2942a;
        if (i10 == 0) {
            v8.u.b(obj);
            z8.g coroutineContext = BrazeCoroutineScope.INSTANCE.getCoroutineContext();
            g2 g2Var = new g2(this.f2943b, this.f2944c, null);
            this.f2942a = 1;
            if (kotlinx.coroutines.i.g(coroutineContext, g2Var, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
        }
        return v8.k0.f35197a;
    }
}
