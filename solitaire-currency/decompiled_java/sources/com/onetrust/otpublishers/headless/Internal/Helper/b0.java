package com.onetrust.otpublishers.headless.Internal.Helper;

import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d0  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(@androidx.annotation.NonNull android.content.Context r21, int r22, @androidx.annotation.NonNull org.json.JSONObject r23) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.b0.a(android.content.Context, int, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c A[PHI: r1
      0x001c: PHI (r1v3 java.lang.String) = (r1v2 java.lang.String), (r1v10 java.lang.String) binds: [B:8:0x001a, B:5:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(@androidx.annotation.NonNull android.content.Context r1, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e r2, @androidx.annotation.NonNull org.json.JSONObject r3) {
        /*
            com.onetrust.otpublishers.headless.Internal.Preferences.g r0 = new com.onetrust.otpublishers.headless.Internal.Preferences.g
            r0.<init>(r1)
            boolean r1 = r0.v()
            if (r1 == 0) goto L14
            java.lang.String r1 = "Iab2V2Data"
            boolean r0 = r3.has(r1)
            if (r0 == 0) goto L21
            goto L1c
        L14:
            java.lang.String r1 = "IabV2Data"
            boolean r0 = r3.has(r1)
            if (r0 == 0) goto L21
        L1c:
            org.json.JSONObject r1 = r3.optJSONObject(r1)
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 == 0) goto L45
            java.lang.String r3 = "vendorListVersion"
            boolean r0 = r1.has(r3)
            if (r0 == 0) goto L45
            java.lang.String r1 = r1.optString(r3)
            int r1 = java.lang.Integer.parseInt(r1)
            android.content.SharedPreferences r2 = r2.c()
            android.content.SharedPreferences$Editor r2 = r2.edit()
            java.lang.String r3 = "OT_DOMAIN_DATA_IAB_VENDOR_LIST_VERSION"
            android.content.SharedPreferences$Editor r1 = r2.putInt(r3, r1)
            r1.apply()
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.b0.b(android.content.Context, com.onetrust.otpublishers.headless.Internal.Preferences.e, org.json.JSONObject):void");
    }

    public static void c(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.g gVar, @NonNull JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject6 = jSONArray.getJSONObject(i10);
            if (jSONObject6.getBoolean("IsIabPurpose")) {
                String strS = c.s(jSONObject6.optString("CustomGroupId", "-1"));
                String string = jSONObject6.getString("Type");
                String string2 = jSONObject6.getString("GroupName");
                if (string.equals("IAB2_PURPOSE") || string.equals("IAB2V2_PURPOSE")) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("id", strS);
                    jSONObject7.put("name", string2);
                    jSONObject4.put(strS, jSONObject7);
                }
                if (string.equals("IAB2_FEATURE") || string.equals("IAB2V2_FEATURE")) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("id", strS);
                    jSONObject8.put("name", string2);
                    jSONObject2.put(strS, jSONObject8);
                }
                if (string.equals("IAB2_SPL_PURPOSE") || string.equals("IAB2V2_SPL_PURPOSE")) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("id", strS);
                    jSONObject9.put("name", string2);
                    jSONObject5.put(strS, jSONObject9);
                }
                if (string.equals("IAB2_SPL_FEATURE") || string.equals("IAB2V2_SPL_FEATURE")) {
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put("id", strS);
                    jSONObject10.put("name", string2);
                    jSONObject3.put(strS, jSONObject10);
                }
            }
        }
        jSONObject.put("features", jSONObject2);
        jSONObject.put("purposes", jSONObject4);
        jSONObject.put("specialFeatures", jSONObject3);
        jSONObject.put("specialPurposes", jSONObject5);
        gVar.u(jSONObject.toString());
    }

    public static void d(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        String str2;
        OTLogger.a("VendorUtils", 2, "getting details of " + str + "from GVL");
        JSONArray jSONArray = new JSONArray();
        if (str.equals("legIntPurposes") || str.equals("flexiblePurposes")) {
            OTLogger.a("VendorUtils", 2, "contains legIntPurposes/flexiblePurposes details");
            str2 = "purposes";
        } else {
            str2 = str;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject.has(str2)) {
            jSONObject3 = jSONObject.getJSONObject(str2);
        }
        JSONArray jSONArray2 = new JSONArray();
        if (jSONObject2.has(str)) {
            jSONArray2 = jSONObject2.getJSONArray(str);
        }
        for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
            String string = jSONArray2.get(i10).toString();
            if (jSONObject3.has(string)) {
                jSONArray.put(jSONObject3.get(string));
            }
        }
        jSONObject2.put(str, jSONArray);
    }

    public static boolean e(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("LegIntSettings") || !jSONObject.getJSONObject("LegIntSettings").has("PAllowLI")) {
            return true;
        }
        return jSONObject.getJSONObject("LegIntSettings").getBoolean("PAllowLI");
    }
}
