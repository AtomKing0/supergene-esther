package bo.app;

import com.braze.Braze;
import com.braze.events.ContentCardsUpdatedEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class f5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f2767a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f5(Braze braze) {
        super(0);
        this.f2767a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        ((vw) this.f2767a.getExternalIEventMessenger$android_sdk_base_release()).b(ContentCardsUpdatedEvent.class, ((ci0) this.f2767a.getUdm$android_sdk_base_release()).B.a(true));
        return v8.k0.f35197a;
    }
}
