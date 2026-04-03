package bo.app;

import com.braze.BrazeUser;
import com.braze.enums.NotificationSubscriptionType;

/* JADX INFO: loaded from: classes2.dex */
public final class nk extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f3494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NotificationSubscriptionType f3495b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nk(BrazeUser brazeUser, NotificationSubscriptionType notificationSubscriptionType, z8.d dVar) {
        super(2, dVar);
        this.f3494a = brazeUser;
        this.f3495b = notificationSubscriptionType;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new nk(this.f3494a, this.f3495b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new nk(this.f3494a, this.f3495b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        this.f3494a.userCache.a(this.f3495b);
        return v8.k0.f35197a;
    }
}
