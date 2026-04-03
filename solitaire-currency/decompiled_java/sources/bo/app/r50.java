package bo.app;

import com.braze.support.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r50 {
    public static d10 a(JSONObject jsonObject, l00 request) {
        kotlin.jvm.internal.t.i(jsonObject, "jsonObject");
        kotlin.jvm.internal.t.i(request, "request");
        String optionalString = JsonUtils.getOptionalString(jsonObject, "error");
        JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("auth_error");
        if (jSONObjectOptJSONObject != null) {
            return new i90(request, jSONObjectOptJSONObject.optInt("error_code", -1), JsonUtils.getOptionalString(jSONObjectOptJSONObject, "reason"), optionalString);
        }
        if (kotlin.jvm.internal.t.d(optionalString, "invalid_api_key")) {
            return new x30(optionalString, request);
        }
        if (optionalString != null) {
            return new t(optionalString, request);
        }
        return null;
    }

    public static ma0 b(JSONObject jsonObject, l00 request) {
        kotlin.jvm.internal.t.i(jsonObject, "jsonObject");
        kotlin.jvm.internal.t.i(request, "request");
        JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("optional_auth_error");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        return new ma0(request, jSONObjectOptJSONObject.optInt("error_code", -1), JsonUtils.getOptionalString(jSONObjectOptJSONObject, "reason"));
    }
}
