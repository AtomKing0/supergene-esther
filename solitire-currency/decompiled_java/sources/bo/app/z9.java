package bo.app;

import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class z9 {
    public final e00 a(IBrazeLocation location) {
        kotlin.jvm.internal.t.i(location, "location");
        return a(new n9(location));
    }

    public final JSONObject a(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (str != null && str.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("trigger_ids", jSONArray);
        }
        if (str2 != null && str2.length() != 0) {
            jSONObject.put(com.ironsource.ad.f11233f, str2);
        }
        if (str3 != null) {
            jSONObject.put("message_extras", str3);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) x9.f4254a, 6, (Object) null);
        }
        return jSONObject;
    }

    public static /* synthetic */ JSONObject a(z9 z9Var, String str, String str2, int i10) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return z9Var.a(str, str2, null);
    }

    public final e00 a(h9.a aVar) {
        try {
            return (e00) aVar.invoke();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) y9.f4345a, 4, (Object) null);
            return null;
        }
    }
}
