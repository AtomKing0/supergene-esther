package bo.app;

import com.braze.Braze;
import com.braze.events.FeedUpdatedEvent;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class j5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3121a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j5(Braze braze) {
        super(0);
        this.f3121a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        v00 externalIEventMessenger$android_sdk_base_release = this.f3121a.getExternalIEventMessenger$android_sdk_base_release();
        xy xyVar = ((ci0) this.f3121a.getUdm$android_sdk_base_release()).A;
        vw vwVar = (vw) externalIEventMessenger$android_sdk_base_release;
        vwVar.b(FeedUpdatedEvent.class, xyVar.a(new JSONArray(xyVar.f4308b.getString("cards", "[]")), xyVar.f4308b.getString("uid", ""), true, xyVar.f4308b.getLong("cards_timestamp", -1L)));
        return v8.k0.f35197a;
    }
}
