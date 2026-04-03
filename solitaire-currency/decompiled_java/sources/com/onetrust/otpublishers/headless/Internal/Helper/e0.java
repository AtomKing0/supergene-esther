package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 {
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(@androidx.annotation.NonNull android.content.Context r12) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.e0.a(android.content.Context):void");
    }

    public static void b(Context context, String str) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("info")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("info");
                if (jSONObject2.has("lastLaunch")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("lastLaunch");
                    boolean z10 = false;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                        hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z10 = true;
                    } else {
                        hVar = null;
                    }
                    String strOptString = jSONObject3.optString("date");
                    if (z10) {
                        sharedPreferences = hVar;
                    }
                    sharedPreferences.edit().putString("OT_SDK_API_FETCH_TIMESTAMP", strOptString).apply();
                    OTLogger.a("AppDataUtils", 3, "saveAPIFetchTimeStamp: value = " + strOptString);
                }
            }
        } catch (JSONException e10) {
            x.a("saveAPIFetchTimeStamp :", e10, "AppDataUtils", 6);
        }
    }

    @RequiresApi(api = 19)
    public static void c(SharedPreferences sharedPreferences, boolean z10, @NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, boolean z11) {
        if (!z10 || !z11 || com.onetrust.otpublishers.headless.Internal.a.c(jSONArray)) {
            OTLogger.a("OneTrust", 3, "No changes in purpose toggle configurations found");
            return;
        }
        String string = sharedPreferences.getString("OTT_CONSENT_STATUS", JsonUtils.EMPTY_JSON);
        String string2 = sharedPreferences.getString("OTT_INTERNAL_PURPOSE_GROUP_MAP", JsonUtils.EMPTY_JSON);
        String string3 = sharedPreferences.getString("OTT_CONSENTABLE_PARENT_GROUPS", JsonUtils.EMPTY_JSON);
        String string4 = sharedPreferences.getString("OTT_CONSENT_LOG_DATA", JsonUtils.EMPTY_JSON);
        String string5 = sharedPreferences.getString("OT_CL_DEFAULT_PAYLOAD", JsonUtils.EMPTY_JSON);
        try {
            JSONObject jSONObject = new JSONObject(string);
            JSONObject jSONObject2 = new JSONObject(string2);
            JSONArray jSONArray3 = new JSONArray(string3);
            JSONObject jSONObject3 = new JSONObject(string4);
            JSONObject jSONObject4 = new JSONObject(string5);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string6 = jSONArray.getString(i10);
                if (jSONObject2.has(string6)) {
                    String string7 = jSONObject2.getString(string6);
                    jSONObject2.remove(string6);
                    if (jSONObject.has(string7)) {
                        jSONObject.remove(string7);
                    }
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        if (string7.equals(jSONArray3.getString(i11))) {
                            jSONArray3.remove(i11);
                        }
                    }
                }
                e(string6, jSONObject3, jSONObject4);
            }
            for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                String string8 = jSONArray.getString(i12);
                if (jSONObject2.has(string8)) {
                    String string9 = jSONObject2.getString(string8);
                    jSONObject2.remove(string8);
                    if (jSONObject.has(string9)) {
                        jSONObject.remove(string9);
                    }
                    for (int i13 = 0; i13 < jSONArray3.length(); i13++) {
                        if (string9.equals(jSONArray3.getString(i13))) {
                            jSONArray3.remove(i13);
                        }
                    }
                }
                f(jSONObject3, string8);
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("OTT_CONSENT_STATUS", jSONObject.toString());
            editorEdit.putString("OTT_INTERNAL_PURPOSE_GROUP_MAP", jSONObject2.toString());
            editorEdit.putString("OTT_PARENT_GROUPS", jSONArray3.toString());
            editorEdit.putString("OTT_CONSENT_LOG_DATA", jSONObject3.toString());
            editorEdit.putString("OT_CL_DEFAULT_PAYLOAD", jSONObject4.toString());
            editorEdit.apply();
        } catch (JSONException e10) {
            n.a(e10, new StringBuilder("exception while removing no toggle purposes from saved Data "), "OneTrust", 6);
        }
    }

    public static void d(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, @NonNull String str) {
        eVar.c().edit().putString("OT_TEMPLATE_TYPE", str).apply();
    }

    @RequiresApi(api = 19)
    public static void e(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            if (jSONObject.has("consentPayload")) {
                jSONArray = jSONObject.getJSONObject("consentPayload").getJSONArray("purposes");
            }
            if (jSONObject2.has("consentPayload")) {
                jSONArray2 = jSONObject2.getJSONObject("consentPayload").getJSONArray("purposes");
            }
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                Locale locale = Locale.ENGLISH;
                if (str.toLowerCase(locale).equals(jSONArray.getJSONObject(i10).getString("Id").toLowerCase(locale))) {
                    jSONArray.remove(i10);
                }
                if (str.toLowerCase(locale).equals(jSONArray2.getJSONObject(i10).getString("Id").toLowerCase(locale))) {
                    jSONArray2.remove(i10);
                }
            }
        } catch (JSONException e10) {
            n.a(e10, new StringBuilder("exception while removing no toggle purposes from saved Consent data"), "OneTrust", 6);
        }
    }

    @VisibleForTesting
    public static void f(@NonNull JSONObject jSONObject, @NonNull String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (jSONObject.has("consentPayload")) {
                jSONArray = jSONObject.getJSONObject("consentPayload").getJSONArray("purposes");
            }
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                if (str.equalsIgnoreCase(jSONArray.getJSONObject(i10).getString("Id"))) {
                    jSONArray.getJSONObject(i10).put("TransactionType", "OPT_OUT");
                }
            }
        } catch (JSONException e10) {
            n.a(e10, new StringBuilder("exception while changing no  LI toggle purposes from saved Consent data"), "OneTrust", 6);
        }
    }

    public static boolean g(@NonNull String str) {
        return "IAB2".equalsIgnoreCase(str) || "IAB2V2".equalsIgnoreCase(str);
    }

    public static boolean h(@NonNull JSONObject jSONObject, boolean z10) {
        if (jSONObject.optBoolean("IsIabPurpose") && jSONObject.optString("Status", "").contains("always")) {
            return true;
        }
        return !z10 ? jSONObject.optBoolean("HasConsentOptOut") : jSONObject.optBoolean("HasConsentOptOut") || jSONObject.optBoolean("HasLegIntOptOut");
    }
}
