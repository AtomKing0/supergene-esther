package com.onetrust.otpublishers.headless.Internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Helper.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static JSONObject a(JSONObject jSONObject, String str) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.getJSONObject(str);
            }
            return null;
        } catch (JSONException e10) {
            x.a("getObject failed: ", e10, "JSONUtils", 6);
            return null;
        }
    }

    public static void b(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        if (jSONObject2.has(str)) {
            try {
                jSONObject.put(str, jSONObject2.optString(str));
            } catch (JSONException e10) {
                StringBuilder sb = new StringBuilder("Error in parsing data. key = ");
                sb.append(str);
                sb.append("Error message : ");
                p.a(e10, sb, "JSONUtils", 6);
            }
        }
    }

    public static boolean c(@Nullable JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static boolean d(@Nullable JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }
}
