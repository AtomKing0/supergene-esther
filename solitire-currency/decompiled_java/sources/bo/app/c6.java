package bo.app;

import com.braze.Braze;
import com.braze.events.InAppMessageEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class c6 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f2485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InAppMessageEvent f2486b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c6(Braze braze, InAppMessageEvent inAppMessageEvent) {
        super(0);
        this.f2485a = braze;
        this.f2486b = inAppMessageEvent;
    }

    @Override // h9.a
    public final Object invoke() {
        ((ci0) this.f2485a.getUdm$android_sdk_base_release()).f2571w.a(this.f2486b.getTriggerEvent(), this.f2486b.getTriggerAction());
        return v8.k0.f35197a;
    }
}
