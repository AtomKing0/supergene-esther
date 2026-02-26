package bo.app;

import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g90 implements IPutIntoJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k70 f2888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2889g;

    public g90(JSONObject json) {
        kotlin.jvm.internal.t.i(json, "json");
        this.f2883a = json.optLong("start_time", -1L);
        this.f2884b = json.optLong("end_time", -1L);
        this.f2885c = json.optInt("priority", 0);
        this.f2889g = json.optInt("min_seconds_since_last_trigger", -1);
        this.f2886d = json.optInt("delay", 0);
        this.f2887e = json.optInt("timeout", -1);
        this.f2888f = new k70(json);
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            JSONObject jSONObject = (JSONObject) this.f2888f.forJsonPut();
            if (jSONObject == null) {
                return null;
            }
            jSONObject.put("start_time", this.f2883a);
            jSONObject.put("end_time", this.f2884b);
            jSONObject.put("priority", this.f2885c);
            jSONObject.put("min_seconds_since_last_trigger", this.f2889g);
            jSONObject.put("timeout", this.f2887e);
            jSONObject.put("delay", this.f2886d);
            return jSONObject;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) f90.f2787a, 4, (Object) null);
            return null;
        }
    }
}
