package bo.app;

import com.braze.events.InAppMessageEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class n4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InAppMessageEvent f3464a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n4(InAppMessageEvent inAppMessageEvent) {
        super(0);
        this.f3464a = inAppMessageEvent;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Error reenqueueing In-App Message from event " + this.f3464a;
    }
}
