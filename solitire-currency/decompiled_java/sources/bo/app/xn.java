package bo.app;

import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class xn implements f10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4291a;

    public xn(JSONObject jSONObject) {
        this.f4291a = jSONObject.getJSONObject("data").getString("event_name");
    }

    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        if (!(g10Var instanceof yn)) {
            return false;
        }
        yn ynVar = (yn) g10Var;
        return !StringUtils.isNullOrBlank(ynVar.f4375f) && ynVar.f4375f.equals(this.f4291a);
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "custom_event");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event_name", this.f4291a);
            jSONObject.put("data", jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
