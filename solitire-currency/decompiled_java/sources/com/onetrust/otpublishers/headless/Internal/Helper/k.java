package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    @NonNull
    public static JSONArray a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("Groups");
        return jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray : new JSONArray();
    }

    public static void b(@NonNull Context context, @NonNull JSONObject jSONObject) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject) || !jSONObject.has(OTVendorListMode.GENERAL)) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(OTVendorListMode.GENERAL);
        if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObjectOptJSONObject)) {
            return;
        }
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("useRTL");
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        sharedPreferences.edit().putBoolean("OT_USE_RTL", zOptBoolean).apply();
        OTLogger.a("OTTemplateUtils", 3, "saveUseRTLFlag: " + zOptBoolean);
    }

    public static void c(@NonNull JSONArray jSONArray, SharedPreferences sharedPreferences) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                jSONObject.put(jSONArray.optJSONObject(i10).optString("CustomGroupId"), jSONArray.optJSONObject(i10).optString("Type"));
                if (jSONArray.optJSONObject(i10).has("SubGroups") && (jSONArrayOptJSONArray = jSONArray.optJSONObject(i10).optJSONArray("SubGroups")) != null) {
                    for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                        jSONObject.put(jSONArrayOptJSONArray.optJSONObject(i11).optString("CustomGroupId"), jSONArrayOptJSONArray.optJSONObject(i11).optString("Type"));
                    }
                }
            }
            OTLogger.a("OTTemplateUtils", 3, "Groups configured: " + jSONObject);
            sharedPreferences.edit().putString("OT_GROUP_ID_OBJECT", jSONObject.toString()).apply();
        } catch (JSONException e10) {
            x.a("Error while saving groups in template,err: ", e10, "OTTemplateUtils", 6);
        }
    }

    public static boolean d(@NonNull Context context) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(OTGppKeys.IAB_GPP_TCFEU2_STRING, "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            string = defaultSharedPreferences.getString("IABTCF_TCString", "");
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(com.onetrust.otpublishers.headless.Internal.c.q(string) ? "" : string)) {
            return true;
        }
        return sharedPreferences.getBoolean("OT_SAVED_TC_STRING_TYPE_DEFAULT", false);
    }

    public static boolean e(@NonNull Context context) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        return sharedPreferences.getBoolean("OT_USE_RTL", false);
    }
}
