package bo.app;

import com.braze.Braze;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.support.BrazeLogger;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f3738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3739c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(Braze braze, String str, String str2) {
        super(0);
        this.f3737a = str;
        this.f3738b = braze;
        this.f3739c = str2;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        if (p9.q.z(this.f3737a)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3738b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new q0(this.f3739c, this.f3737a), 6, (Object) null);
        } else {
            ((ci0) this.f3738b.getUdm$android_sdk_base_release()).B.a(new dm(this.f3737a), this.f3739c);
            ((vw) this.f3738b.getExternalIEventMessenger$android_sdk_base_release()).b(ContentCardsUpdatedEvent.class, ((ci0) this.f3738b.getUdm$android_sdk_base_release()).B.a(true));
        }
        return v8.k0.f35197a;
    }
}
