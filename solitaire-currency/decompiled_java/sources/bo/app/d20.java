package bo.app;

import com.braze.support.StringUtils;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d20 implements f10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f2615b = new HashSet();

    public d20(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        this.f2614a = jSONObject2.getString("id");
        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(OTUXParamsKeys.OT_UX_BUTTONS);
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                this.f2615b.add(jSONArrayOptJSONArray.getString(i10));
            }
        }
    }

    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        if (g10Var instanceof e20) {
            e20 e20Var = (e20) g10Var;
            if (!StringUtils.isNullOrBlank(e20Var.f2698e) && e20Var.f2698e.equals(this.f2614a)) {
                return this.f2615b.size() > 0 ? !StringUtils.isNullOrBlank(e20Var.f2699f) && this.f2615b.contains(e20Var.f2699f) : StringUtils.isNullOrBlank(e20Var.f2699f);
            }
        }
        return false;
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "iam_click");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", this.f2614a);
            if (this.f2615b.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f2615b.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject2.put(OTUXParamsKeys.OT_UX_BUTTONS, jSONArray);
            }
            jSONObject.put("data", jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
