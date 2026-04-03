package bo.app;

import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l60 implements f10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3309a;

    public l60(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.isNull("campaign_id")) {
            return;
        }
        this.f3309a = jSONObjectOptJSONObject.optString("campaign_id", null);
    }

    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        if (!(g10Var instanceof m60)) {
            return false;
        }
        if (StringUtils.isNullOrBlank(this.f3309a)) {
            return true;
        }
        m60 m60Var = (m60) g10Var;
        return !StringUtils.isNullOrBlank(m60Var.f3393e) && m60Var.f3393e.equals(this.f3309a);
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "push_click");
            if (this.f3309a == null) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("campaign_id", this.f3309a);
            jSONObject.putOpt("data", jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
