package bo.app;

import com.braze.support.BrazeLogger;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ba0 extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k00 f2437j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba0(vb0 serverConfigStorageProvider, String urlBase, String str) {
        super(new b90(urlBase + "debugger/init", true), str, serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        this.f2437j = k00.SDK_DEBUGGER_INIT;
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
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) aa0.f2364a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f2437j;
    }

    @Override // bo.app.tg, bo.app.l00
    public final void a(HashMap existingHeaders) {
        kotlin.jvm.internal.t.i(existingHeaders, "existingHeaders");
        super.a(existingHeaders);
        existingHeaders.put("X-Braze-Rec-Auth-Code", this.f3942c.r());
    }

    @Override // bo.app.tg, bo.app.b10
    public final void a(v00 internalPublisher, v00 externalPublisher, d10 responseError) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(externalPublisher, "externalPublisher");
        kotlin.jvm.internal.t.i(responseError, "responseError");
        super.a(internalPublisher, externalPublisher, responseError);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, true, (h9.a) new z90(responseError), 3, (Object) null);
        ((vw) internalPublisher).b(x90.class, new x90(new r90()));
    }
}
