package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class u {
    public static int a(@NonNull JSONObject jSONObject, @NonNull String str) {
        if (!jSONObject.has(str)) {
            return -1;
        }
        String strOptString = jSONObject.optJSONObject(str).optString("userConsentStatus");
        return ("ACTIVE".equalsIgnoreCase(strOptString) || "OPT_IN".equalsIgnoreCase(strOptString)) ? 1 : 0;
    }

    public static void b(com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull JSONObject jSONObject3) {
        SharedPreferences.Editor editorEdit = eVar.c().edit();
        editorEdit.putString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", String.valueOf(jSONObject));
        editorEdit.putString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", String.valueOf(jSONObject2));
        editorEdit.putString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", String.valueOf(jSONObject3));
        editorEdit.apply();
    }

    public static boolean c(boolean z10, @NonNull JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str.equalsIgnoreCase(str2)) {
            jSONObject.put("userConsentStatus", z10 ? "OPT_IN" : "OPT_OUT");
            return true;
        }
        OTLogger.a("UCPurposesDataHandler", 5, "Invalid ID passed to update UCP Consent values");
        return false;
    }
}
