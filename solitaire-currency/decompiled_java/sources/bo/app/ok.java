package bo.app;

import com.braze.enums.NotificationSubscriptionType;

/* JADX INFO: loaded from: classes2.dex */
public final class ok extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotificationSubscriptionType f3570a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ok(NotificationSubscriptionType notificationSubscriptionType) {
        super(0);
        this.f3570a = notificationSubscriptionType;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to set push notification subscription to: " + this.f3570a;
    }
}
