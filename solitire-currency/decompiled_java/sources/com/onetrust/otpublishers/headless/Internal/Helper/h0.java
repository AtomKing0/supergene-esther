package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class h0 {
    @VisibleForTesting
    public static int a(@NonNull JSONObject jSONObject, int i10, @NonNull JSONObject jSONObject2, boolean z10, @Nullable c cVar, @Nullable com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, JSONObject jSONObject3) throws JSONException {
        JSONArray jSONArray = jSONObject2.getJSONArray("SubGroups");
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < jSONArray.length(); i13++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i13);
            if (jSONObject4.optString("Status", "").startsWith("always")) {
                i12++;
                i11++;
            } else {
                String strOptString = jSONObject4.optString("CustomGroupId", "-1");
                int i14 = (!z10 || cVar == null || eVar == null) ? jSONObject.has(strOptString) ? jSONObject.getInt(strOptString) : -1 : cVar.a(c.s(strOptString), "purposeLegitimateInterests", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, eVar, false, jSONObject3);
                if (i14 == 0) {
                    return 0;
                }
                if (i14 < 0) {
                    i12++;
                }
            }
        }
        if (i11 > 0) {
            if (i11 == jSONArray.length()) {
                return i10;
            }
            return 1;
        }
        if (i12 == jSONArray.length()) {
            return i10;
        }
        return 1;
    }

    public static void b(int i10, int i11, @NonNull String str, @NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("purposeLegitimateInterests")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("purposeLegitimateInterests");
            if (i10 < 0 || i10 == i11) {
                return;
            }
            jSONObject2.put(c.s(str), i11);
            jSONObject.put("purposeLegitimateInterests", jSONObject2);
            OTLogger.a("OneTrust", 3, "setting LI status of " + str + " to " + i11 + "as per status configured for its subgroups");
        }
    }

    public static void c(@NonNull String str, boolean z10, @Nullable JSONObject jSONObject, @NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, @NonNull Context context) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        JSONObject jSONObject2;
        try {
            JSONObject jSONObject3 = new JSONObject(eVar.c().getString("OTT_CONSENT_STATUS", JsonUtils.EMPTY_JSON));
            JSONArray jSONArray = new JSONObject(str).getJSONArray("Groups");
            boolean zG = g(jSONObject);
            boolean z11 = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (new com.onetrust.otpublishers.headless.Internal.profile.d(context).t()) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z11 = true;
            } else {
                hVar = null;
            }
            if (z11) {
                sharedPreferences = hVar;
            }
            String string = sharedPreferences.getString("OTT_CULTURE_DOMAIN_DATA", "");
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                jSONObject2 = new JSONObject();
            } else {
                try {
                    jSONObject2 = new JSONObject(string);
                } catch (JSONException e10) {
                    OTLogger.a("OneTrust", 6, "error while returning culture domain data, err: " + e10.getMessage());
                    jSONObject2 = new JSONObject();
                }
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                e(jSONArray, jSONObject3, context, jSONObject2);
                if (z10 && zG) {
                    d(jSONArray, new c(context), eVar, jSONObject2);
                }
            }
            eVar.c().edit().putString("OTT_CONSENT_STATUS", jSONObject3.toString()).apply();
        } catch (JSONException e11) {
            n.a(e11, new StringBuilder("error while setting default status of parent category,err: "), "OneTrust", 6);
        }
    }

    public static void d(@NonNull JSONArray jSONArray, @NonNull c cVar, @NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, JSONObject jSONObject) {
        try {
            String string = eVar.c().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                jSONObject2 = new JSONObject(string);
            }
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                if (jSONObject3.has("SubGroups")) {
                    String strOptString = jSONObject3.optString("CustomGroupId", "-1");
                    int iA = cVar.a(c.s(strOptString), "purposeLegitimateInterests", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, eVar, false, jSONObject);
                    b(iA, a(new JSONObject(), iA, jSONObject3, true, cVar, eVar, jSONObject), strOptString, jSONObject2);
                }
            }
            eVar.c().edit().putString("OTT_IAB_CONSENTABLE_PURPOSES", jSONObject2.toString()).apply();
        } catch (JSONException e10) {
            n.a(e10, new StringBuilder("error while setting default LI status of parent category,err: "), "OneTrust", 6);
        }
    }

    public static void e(@NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject, @NonNull Context context, JSONObject jSONObject2) {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                if (jSONObject3.has("SubGroups") && jSONObject3.has("CustomGroupId") && !jSONObject3.getString("Status").contains("always")) {
                    String string = jSONObject3.getString("CustomGroupId");
                    int i11 = jSONObject.getInt(string);
                    f(jSONObject, string, a(jSONObject, i11, jSONObject3, false, null, null, jSONObject2), i11, context);
                }
            } catch (JSONException e10) {
                n.a(e10, new StringBuilder("error while setting default consent status of parent category,err: "), "OneTrust", 6);
                return;
            }
        }
    }

    public static void f(@NonNull JSONObject jSONObject, @NonNull String str, int i10, int i11, @NonNull Context context) throws JSONException {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        if (i11 < 0 || i11 == i10) {
            return;
        }
        jSONObject.put(str, i10);
        OTLogger.a("OneTrust", 3, "setting consent status of " + str + " to " + i10 + "as per status configured for its subgroups");
        OTLogger.a("OTT_CONSENT_STATUS", 3, "Updating SDK status of the parent category.");
        o oVar = new o(context);
        boolean z10 = false;
        if (oVar.g(str, i10 == 1)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            oVar.h(sharedPreferences.getString("OT_INTERNAL_SDK_STATUS_MAP", ""));
        }
    }

    public static boolean g(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.getBoolean("PAllowLI");
        }
        return false;
    }
}
