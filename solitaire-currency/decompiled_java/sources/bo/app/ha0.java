package bo.app;

import com.braze.support.BrazeLogger;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ha0 extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f2965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k00 f2966k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha0(vb0 serverConfigStorageProvider, String urlBase, String str, List logs) {
        super(new b90(urlBase + "debugger/log", true), str, serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        kotlin.jvm.internal.t.i(logs, "logs");
        this.f2965j = logs;
        this.f2966k = k00.SDK_DEBUGGER_LOG;
    }

    @Override // bo.app.tg, bo.app.l00
    public final void a(HashMap existingHeaders) {
        kotlin.jvm.internal.t.i(existingHeaders, "existingHeaders");
        super.a(existingHeaders);
        existingHeaders.put("X-Braze-Rec-Auth-Code", this.f3942c.r());
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
            JSONArray jSONArray = new JSONArray();
            for (ea0 ea0Var : this.f2965j) {
                ea0Var.getClass();
                jSONArray.put(new JSONObject().put("log", ea0Var.f2718a).put("time", ea0Var.f2719b));
            }
            jSONObjectB.put("data", new JSONArray().put(new JSONObject().put("type", "sdk_event_log").put("data", jSONArray)));
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e10, true, (h9.a<String>) ga0.f2891a);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f2966k;
    }

    @Override // bo.app.l00
    public final boolean a() {
        return this.f2965j.isEmpty();
    }

    @Override // bo.app.tg, bo.app.b10
    public final void a(v00 internalPublisher, v00 externalPublisher, d10 responseError) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(externalPublisher, "externalPublisher");
        kotlin.jvm.internal.t.i(responseError, "responseError");
        super.a(internalPublisher, externalPublisher, responseError);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, true, (h9.a) new fa0(responseError), 3, (Object) null);
        ((vw) internalPublisher).b(x90.class, new x90(new r90()));
    }
}
