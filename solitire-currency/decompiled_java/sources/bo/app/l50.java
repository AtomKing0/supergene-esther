package bo.app;

import com.braze.models.IPutIntoJson;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l50 implements IPutIntoJson, u00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f3305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONArray f3306b;

    public l50(JSONObject userObject) {
        kotlin.jvm.internal.t.i(userObject, "userObject");
        this.f3305a = userObject;
        this.f3306b = new JSONArray().put(userObject);
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        JSONArray jsonArrayForJsonPut = this.f3306b;
        kotlin.jvm.internal.t.h(jsonArrayForJsonPut, "jsonArrayForJsonPut");
        return jsonArrayForJsonPut;
    }

    @Override // bo.app.u00
    public final boolean isEmpty() {
        if (this.f3305a.length() == 0) {
            return true;
        }
        return this.f3305a.length() == 1 && this.f3305a.has("user_id");
    }
}
