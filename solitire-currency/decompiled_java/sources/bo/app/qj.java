package bo.app;

import com.braze.enums.NotificationSubscriptionType;

/* JADX INFO: loaded from: classes2.dex */
public final class qj extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotificationSubscriptionType f3713a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qj(NotificationSubscriptionType notificationSubscriptionType) {
        super(0);
        this.f3713a = notificationSubscriptionType;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to set email notification subscription to: " + this.f3713a;
    }
}
