package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s50 extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f3819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d10 f3820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ma0 f3821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dm f3822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InAppMessageBase f3823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f3824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fb0 f3825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f3826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONArray f3827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONArray f3829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f3830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r90 f3831o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s50(l00 request, w00 connectionResult, h00 brazeManager) {
        dm dmVar;
        Exception e10;
        fb0 fb0Var;
        super(request, connectionResult);
        kotlin.jvm.internal.t.i(request, "request");
        kotlin.jvm.internal.t.i(connectionResult, "connectionResult");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        JSONObject jSONObjectA = connectionResult.a();
        jSONObjectA = jSONObjectA == null ? new JSONObject() : jSONObjectA;
        this.f3819c = jSONObjectA;
        d10 d10VarA = r50.a(jSONObjectA, request);
        this.f3820d = d10VarA;
        this.f3821e = r50.b(jSONObjectA, request);
        this.f3827k = jSONObjectA.optJSONArray("feature_flags");
        this.f3829m = jSONObjectA.optJSONArray("feed");
        this.f3830n = jSONObjectA.optLong("last_sync_at", -1L);
        if (d10VarA == null && (request instanceof mn)) {
            try {
                dmVar = new dm(jSONObjectA);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (h9.a) new n50(this), 4, (Object) null);
                dmVar = null;
            }
        } else {
            dmVar = null;
        }
        this.f3822f = dmVar;
        ArrayList arrayListA = ng0.f3487a.a(this.f3819c.optJSONArray("triggers"), brazeManager);
        this.f3824h = arrayListA;
        if (arrayListA != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new o50(this), 6, (Object) null);
        }
        JSONObject jSONObjectOptJSONObject = this.f3819c.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            try {
                fb0Var = new fb0(jSONObjectOptJSONObject);
            } catch (Exception e12) {
                e10 = e12;
                fb0Var = null;
            }
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new p50(jSONObjectOptJSONObject), 6, (Object) null);
            } catch (Exception e13) {
                e10 = e13;
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new q50(jSONObjectOptJSONObject), 4, (Object) null);
            }
        } else {
            fb0Var = null;
        }
        this.f3825i = fb0Var;
        this.f3823g = ng0.a(this.f3819c.optJSONObject("templated_message"), brazeManager);
        JSONArray jSONArrayOptJSONArray = this.f3819c.optJSONArray("geofences");
        this.f3826j = jSONArrayOptJSONArray != null ? com.braze.support.g.a(jSONArrayOptJSONArray) : null;
        this.f3828l = request instanceof hs ? JsonUtils.getOptionalString(this.f3819c, "mite") : null;
        this.f3831o = request instanceof ba0 ? w90.f4175k.a(this.f3819c, true) : null;
    }
}
