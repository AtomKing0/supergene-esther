package bo.app;

import com.braze.support.BrazeLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class hs extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k00 f2999j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hs(vb0 serverConfigStorageProvider, String urlBase, String str) {
        super(new b90(urlBase + "dust/config"), str, serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        this.f2999j = k00.DUST_CONFIG;
    }

    @Override // bo.app.l00
    public final boolean a() {
        return false;
    }

    @Override // bo.app.tg, bo.app.l00
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        if (jSONObjectB == null) {
            return null;
        }
        try {
            String str = this.f3941b;
            if (str != null && !p9.q.z(str)) {
                jSONObjectB.put("user_id", this.f3941b);
            }
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) gs.f2924a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f2999j;
    }
}
