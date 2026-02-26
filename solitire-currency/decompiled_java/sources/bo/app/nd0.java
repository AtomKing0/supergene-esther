package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class nd0 implements f10 {
    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        return g10Var instanceof od0;
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "test");
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
