package bo.app;

import com.braze.events.InAppMessageEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class b6 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InAppMessageEvent f2417a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b6(InAppMessageEvent inAppMessageEvent) {
        super(0);
        this.f2417a = inAppMessageEvent;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Error retrying In-App Message from event " + this.f2417a;
    }
}
