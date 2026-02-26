package bo.app;

import com.braze.models.IPutIntoJson;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k50 implements IPutIntoJson, u00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f3215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f3216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i50 f3217d;

    public k50(String str, Boolean bool, Boolean bool2, i50 i50Var) {
        this.f3214a = str;
        this.f3215b = bool;
        this.f3216c = bool2;
        this.f3217d = i50Var;
    }

    public final boolean b() {
        return this.f3215b != null;
    }

    public final boolean c() {
        return this.f3216c != null;
    }

    @Override // bo.app.u00
    public final boolean isEmpty() throws JSONException {
        i50 i50Var;
        JSONObject jSONObjectForJsonPut = forJsonPut();
        if (jSONObjectForJsonPut.length() == 0) {
            return true;
        }
        if (this.f3215b == null && this.f3216c == null && (i50Var = this.f3217d) != null) {
            return !i50Var.f3022b;
        }
        if (jSONObjectForJsonPut.length() == 1) {
            return jSONObjectForJsonPut.has("user_id");
        }
        return false;
    }

    @Override // com.braze.models.IPutIntoJson
    public final JSONObject forJsonPut() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f3214a;
        if (str != null && str.length() != 0) {
            jSONObject.put("user_id", this.f3214a);
        }
        Boolean bool = this.f3215b;
        if (bool != null) {
            jSONObject.put("feed", bool.booleanValue());
        }
        Boolean bool2 = this.f3216c;
        if (bool2 != null) {
            jSONObject.put("triggers", bool2.booleanValue());
        }
        i50 i50Var = this.f3217d;
        if (i50Var != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("config_time", i50Var.f3021a);
            jSONObject.put("config", jSONObject2);
        }
        return jSONObject;
    }
}
