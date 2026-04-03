package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zn extends se0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4453d = BrazeLogger.getBrazeLogTag((Class<?>) zn.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4454c;

    public zn(JSONObject jSONObject) {
        super(jSONObject);
        this.f4454c = jSONObject.getJSONObject("data").getString("event_name");
    }

    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        if (!(g10Var instanceof yn)) {
            return false;
        }
        yn ynVar = (yn) g10Var;
        if (StringUtils.isNullOrBlank(ynVar.f4375f) || !ynVar.f4375f.equals(this.f4454c)) {
            return false;
        }
        return this.f3853a.a(g10Var);
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        JSONObject jSONObjectB = super.b();
        try {
            jSONObjectB.put("type", "custom_event_property");
            JSONObject jSONObject = jSONObjectB.getJSONObject("data");
            jSONObject.put("event_name", this.f4454c);
            jSONObjectB.put("data", jSONObject);
        } catch (JSONException e10) {
            BrazeLogger.e(f4453d, "Caught exception creating CustomEventWithPropertiesTriggerCondition Json.", e10);
        }
        return jSONObjectB;
    }
}
