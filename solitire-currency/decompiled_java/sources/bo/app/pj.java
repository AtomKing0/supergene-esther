package bo.app;

import com.braze.BrazeUser;
import com.braze.enums.NotificationSubscriptionType;

/* JADX INFO: loaded from: classes2.dex */
public final class pj extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f3633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NotificationSubscriptionType f3634b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pj(BrazeUser brazeUser, NotificationSubscriptionType notificationSubscriptionType, z8.d dVar) {
        super(2, dVar);
        this.f3633a = brazeUser;
        this.f3634b = notificationSubscriptionType;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new pj(this.f3633a, this.f3634b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new pj(this.f3633a, this.f3634b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f3633a.userCache;
        NotificationSubscriptionType notificationSubscriptionType = this.f3634b;
        synchronized (uh0Var) {
            uh0Var.b("email_subscribe", notificationSubscriptionType != null ? notificationSubscriptionType.forJsonPut() : null);
        }
        return v8.k0.f35197a;
    }
}
