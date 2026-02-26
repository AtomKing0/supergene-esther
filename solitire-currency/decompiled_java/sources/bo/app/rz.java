package bo.app;

import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class rz extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e00 f3812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k00 f3813k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rz(vb0 serverConfigStorageProvider, String urlBase, IBrazeLocation location) {
        super(new b90(urlBase + "geofence/request"), serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        kotlin.jvm.internal.t.i(location, "location");
        this.f3812j = ba.f2429g.a(location);
        this.f3813k = k00.GEOFENCE_REFRESH;
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
            e00 e00Var = this.f3812j;
            if (e00Var != null) {
                jSONObjectB.put("location_event", ((ba) e00Var).forJsonPut());
            }
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) qz.f3736a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f3813k;
    }
}
