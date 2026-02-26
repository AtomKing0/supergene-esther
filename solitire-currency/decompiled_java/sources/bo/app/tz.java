package bo.app;

import com.braze.support.BrazeLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class tz extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e00 f3975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k00 f3976k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tz(vb0 serverConfigStorageProvider, String urlBase, e00 geofenceEvent) {
        super(new b90(urlBase + "geofence/report"), serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        kotlin.jvm.internal.t.i(geofenceEvent, "geofenceEvent");
        this.f3975j = geofenceEvent;
        this.f3976k = k00.GEOFENCE_REPORT;
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
            jSONObjectB.put("geofence_event", ((ba) this.f3975j).forJsonPut());
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) sz.f3882a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f3976k;
    }
}
