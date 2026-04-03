package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class sq {
    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        sq sqVar = zq.f4469f;
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject2.opt(next);
            Object objOpt2 = jSONObject.opt(next);
            if (objOpt != null) {
                try {
                    if (objOpt instanceof JSONObject) {
                        if (objOpt2 == null || !JsonUtils.areJsonObjectsEqual((JSONObject) objOpt, (JSONObject) objOpt2)) {
                            jSONObject3.put(next, objOpt);
                        }
                    } else if (!kotlin.jvm.internal.t.d(objOpt, objOpt2)) {
                        jSONObject3.put(next, objOpt);
                    }
                } catch (JSONException e10) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) sqVar, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) oq.f3577a, 4, (Object) null);
                    return null;
                }
            }
        }
        return jSONObject3;
    }
}
