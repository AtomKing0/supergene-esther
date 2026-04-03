package bo.app;

import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb0 implements IPutIntoJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc0 f4421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f4422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Double f4423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f4424d;

    public zb0(cc0 sessionId, double d10, Double d11, boolean z10) {
        kotlin.jvm.internal.t.i(sessionId, "sessionId");
        this.f4421a = sessionId;
        this.f4422b = d10;
        a(d11);
        this.f4424d = z10;
    }

    public void a(Double d10) {
        this.f4423c = d10;
    }

    public final long b() {
        Double dC = c();
        if (dC == null) {
            return -1L;
        }
        double dDoubleValue = dC.doubleValue();
        long j10 = (long) (dDoubleValue - this.f4422b);
        if (j10 < 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new xb0(dDoubleValue, this), 6, (Object) null);
        }
        return j10;
    }

    public Double c() {
        return this.f4423c;
    }

    public final boolean d() {
        return this.f4424d;
    }

    public String toString() {
        return "\nSession(sessionId=" + this.f4421a + ", startTime=" + this.f4422b + ", endTime=" + c() + ", isSealed=" + this.f4424d + ", duration=" + b() + ')';
    }

    @Override // com.braze.models.IPutIntoJson
    public final JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("session_id", this.f4421a);
            jSONObject.put("start_time", this.f4422b);
            jSONObject.put("is_sealed", this.f4424d);
            if (c() != null) {
                jSONObject.put("end_time", c());
            }
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) yb0.f4349a, 4, (Object) null);
        }
        return jSONObject;
    }

    public zb0(JSONObject sessionData) throws JSONException {
        kotlin.jvm.internal.t.i(sessionData, "sessionData");
        String string = sessionData.getString("session_id");
        kotlin.jvm.internal.t.h(string, "sessionData.getString(SESSION_ID_KEY)");
        this.f4421a = bc0.a(string);
        this.f4422b = sessionData.getDouble("start_time");
        this.f4424d = sessionData.getBoolean("is_sealed");
        a(JsonUtils.getDoubleOrNull(sessionData, "end_time"));
    }
}
