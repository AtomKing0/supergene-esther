package bo.app;

import com.braze.BrazeUser;
import com.ironsource.mediationsdk.impressionData.ImpressionData;

/* JADX INFO: loaded from: classes2.dex */
public final class si extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f3862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3863b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public si(BrazeUser brazeUser, String str, z8.d dVar) {
        super(2, dVar);
        this.f3862a = brazeUser;
        this.f3863b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new si(this.f3862a, this.f3863b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new si(this.f3862a, this.f3863b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f3862a.userCache;
        String str = this.f3863b;
        synchronized (uh0Var) {
            uh0Var.b(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY, str);
        }
        return v8.k0.f35197a;
    }
}
