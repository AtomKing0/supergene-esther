package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u60 extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f3993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f3994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k00 f3995l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u60(vb0 serverConfigStorageProvider, String urlBase, String str, ArrayList pushDeliveryEvents) {
        super(new b90(urlBase + "push/delivery_events"), str, serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        kotlin.jvm.internal.t.i(pushDeliveryEvents, "pushDeliveryEvents");
        this.f3993j = pushDeliveryEvents;
        this.f3994k = pushDeliveryEvents.isEmpty();
        this.f3995l = k00.PUSH_DELIVERY_EVENTS;
    }

    @Override // bo.app.l00
    public final boolean a() {
        return this.f3994k;
    }

    @Override // bo.app.tg, bo.app.l00
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        if (jSONObjectB == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (o60 o60Var : this.f3993j) {
                o60Var.a(this.f3941b);
                jSONArray.put(o60Var.forJsonPut());
            }
            jSONObjectB.put("events", jSONArray);
            String str = this.f3941b;
            if (str != null && !p9.q.z(str)) {
                jSONObjectB.put("user_id", this.f3941b);
            }
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) t60.f3897a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f3995l;
    }
}
