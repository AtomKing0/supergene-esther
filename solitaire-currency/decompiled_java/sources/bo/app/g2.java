package bo.app;

import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.events.IValueCallback;

/* JADX INFO: loaded from: classes2.dex */
public final class g2 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IValueCallback f2853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f2854b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(IValueCallback iValueCallback, Braze braze, z8.d dVar) {
        super(2, dVar);
        this.f2853a = iValueCallback;
        this.f2854b = braze;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new g2(this.f2853a, this.f2854b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new g2(this.f2853a, this.f2854b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        IValueCallback iValueCallback = this.f2853a;
        BrazeUser brazeUser = this.f2854b.brazeUser;
        if (brazeUser == null) {
            kotlin.jvm.internal.t.A("brazeUser");
            brazeUser = null;
        }
        iValueCallback.onSuccess(brazeUser);
        return v8.k0.f35197a;
    }
}
