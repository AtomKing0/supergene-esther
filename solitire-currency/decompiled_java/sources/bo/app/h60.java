package bo.app;

import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h60 implements f10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2958a;

    public h60(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.isNull("product_id")) {
            return;
        }
        this.f2958a = jSONObjectOptJSONObject.optString("product_id", null);
    }

    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        if (!(g10Var instanceof i60)) {
            return false;
        }
        if (StringUtils.isNullOrBlank(this.f2958a)) {
            return true;
        }
        i60 i60Var = (i60) g10Var;
        return !StringUtils.isNullOrBlank(i60Var.f3028f) && i60Var.f3028f.equals(this.f2958a);
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "purchase");
            if (this.f2958a == null) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("product_id", this.f2958a);
            jSONObject.putOpt("data", jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
