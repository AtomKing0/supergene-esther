package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21754a;

    public c(@NonNull Context context) {
        this.f21754a = context;
    }

    @NonNull
    public static String c(@NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        String strOptString = jSONObject.optString("CustomGroupId");
        try {
            if (!(jSONObject.optString("Type").equalsIgnoreCase("IAB2_STACK") || jSONObject.optString("Type").equalsIgnoreCase("IAB2V2_STACK")) && jSONObject.getBoolean("IsIabPurpose")) {
                map.put(strOptString, jSONObject.optString("Type", ""));
            }
            n(map, jSONObject, map2);
            if (!map2.isEmpty()) {
                for (Map.Entry entry : map2.entrySet()) {
                    HashMap map3 = new HashMap();
                    map3.put((String) entry.getKey(), (String) entry.getValue());
                    String str = (String) entry.getKey();
                    JSONObject vendorsByPurpose = !map3.isEmpty() ? oTPublishersHeadlessSDK.getOtVendorUtils().getVendorsByPurpose(map3, oTPublishersHeadlessSDK.getVendorListUI(OTVendorListMode.IAB)) : null;
                    jSONObject2.put(str, vendorsByPurpose != null ? String.valueOf(vendorsByPurpose.length()) : "");
                }
            }
            JSONObject vendorsByPurpose2 = map.isEmpty() ? null : oTPublishersHeadlessSDK.getOtVendorUtils().getVendorsByPurpose(map, oTPublishersHeadlessSDK.getVendorListUI(OTVendorListMode.IAB));
            return vendorsByPurpose2 != null ? String.valueOf(vendorsByPurpose2.length()) : "";
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error in parsing vendor list link on setCategoriesForVendorList, returning empty string."), "IABHelper", 6);
            return "";
        }
    }

    @NonNull
    public static Date d(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar) {
        Date date = new Date();
        Date date2 = new Date(date.getTime() - (date.getTime() % com.vungle.ads.internal.signals.b.TWENTY_FOUR_HOURS_MILLIS));
        SharedPreferences.Editor editorEdit = eVar.c().edit();
        editorEdit.putString("OT_IAB_TCStr_LastUpdated", date2.toString());
        editorEdit.putLong("OT_IAB_TC_STR_LAST_UPDATED_IN_MILLISECONDS", date2.getTime()).apply();
        OTLogger.a("IABHelper", 3, "Tc string updating date timestamp = " + date2.getTime());
        return date2;
    }

    @NonNull
    public static Date e(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, @Nullable Date date) {
        SharedPreferences.Editor editorEdit = eVar.c().edit();
        editorEdit.putString("OT_IAB_TCStr_Created", date.toString());
        editorEdit.putLong("OT_IAB_TC_STR_CREATED_IN_MILLISECONDS", date.getTime()).apply();
        OTLogger.a("IABHelper", 3, "Tc string Created date timestamp = " + date.getTime());
        return date;
    }

    public static JSONArray g(@NonNull JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < jSONObject.length(); i10++) {
            try {
                if (jSONObject.getInt(jSONObject.names().get(i10).toString()) != 0) {
                    jSONArray.put(Integer.parseInt(jSONObject.names().get(i10).toString()));
                }
            } catch (Exception e10) {
                j.a(e10, new StringBuilder("error in getting purpose ids : "), "IABHelper", 6);
            }
        }
        OTLogger.a("IABHelper", 3, "purposes consent " + jSONArray.toString());
        return jSONArray;
    }

    public static void j(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, @NonNull JSONObject jSONObject) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(eVar.c().getString("OT_IAB_DEFAULT_AVL", ""))) {
            f.a(jSONObject, eVar.c().edit(), "OT_IAB_DEFAULT_AVL");
        }
    }

    public static void k(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, boolean z10, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull JSONObject jSONObject3, @NonNull String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        JSONArray jSONArray;
        String str5;
        boolean z11;
        boolean z12;
        int i10;
        int i11;
        String str6 = "IABHelper";
        if (jSONObject3.length() > 0) {
            OTLogger.a("IABHelper", 3, "domain id contains overridden vendors");
            JSONArray jSONArrayNames = jSONObject3.names();
            if (jSONArrayNames != null) {
                int i12 = 0;
                while (i12 < jSONArrayNames.length()) {
                    String string = jSONArrayNames.getString(i12);
                    if (jSONObject2.has(string)) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(string);
                        if (jSONObject4.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE)) {
                            JSONObject jSONObject5 = jSONObject2.getJSONObject(string);
                            boolean z13 = true;
                            if (jSONObject4.has("disabledCP") && jSONObject5.has("purposes")) {
                                JSONArray jSONArray2 = jSONObject4.getJSONArray("disabledCP");
                                JSONArray jSONArray3 = jSONObject5.getJSONArray("purposes");
                                jSONArray = jSONArrayNames;
                                int i13 = 0;
                                z11 = false;
                                while (i13 < jSONArray2.length()) {
                                    int i14 = jSONArray2.getInt(i13);
                                    String str7 = str6;
                                    JSONArray jSONArray4 = jSONArray2;
                                    int i15 = 0;
                                    while (true) {
                                        if (i15 >= jSONArray3.length()) {
                                            i11 = -1;
                                            i15 = -1;
                                            break;
                                        } else {
                                            if (i14 == jSONArray3.getInt(i15)) {
                                                i11 = -1;
                                                break;
                                            }
                                            i15++;
                                        }
                                    }
                                    if (i15 > i11) {
                                        jSONArray3.remove(i15);
                                        z11 = true;
                                    }
                                    i13++;
                                    jSONArray2 = jSONArray4;
                                    str6 = str7;
                                }
                                str5 = str6;
                                if (z11) {
                                    jSONObject5.put("purposes", jSONArray3);
                                }
                            } else {
                                jSONArray = jSONArrayNames;
                                str5 = str6;
                                z11 = false;
                            }
                            if (jSONObject4.has("disabledLIP") && jSONObject5.has("legIntPurposes")) {
                                JSONArray jSONArray5 = jSONObject4.getJSONArray("disabledLIP");
                                JSONArray jSONArray6 = jSONObject5.getJSONArray("legIntPurposes");
                                int i16 = 0;
                                z12 = false;
                                while (i16 < jSONArray5.length()) {
                                    int i17 = jSONArray5.getInt(i16);
                                    JSONArray jSONArray7 = jSONArray5;
                                    int i18 = 0;
                                    while (true) {
                                        if (i18 >= jSONArray6.length()) {
                                            i10 = -1;
                                            break;
                                        } else {
                                            if (i17 == jSONArray6.getInt(i18)) {
                                                i10 = i18;
                                                break;
                                            }
                                            i18++;
                                        }
                                    }
                                    if (i10 > -1) {
                                        jSONArray6.remove(i10);
                                        z12 = true;
                                    }
                                    i16++;
                                    jSONArray5 = jSONArray7;
                                }
                                if (z12) {
                                    jSONObject5.put("legIntPurposes", jSONArray6);
                                }
                            } else {
                                z12 = false;
                            }
                            if (!z11 && !z12) {
                                z13 = false;
                            }
                            if (z13) {
                                jSONObject2.put(string, jSONObject5);
                            }
                        } else {
                            jSONObject2.remove(string);
                            jSONArray = jSONArrayNames;
                            str5 = str6;
                        }
                    } else {
                        jSONArray = jSONArrayNames;
                        str5 = str6;
                    }
                    i12++;
                    jSONArrayNames = jSONArray;
                    str6 = str5;
                }
                str4 = str6;
                q(jSONObject2, jSONObject, jSONObject3, str, z10);
            } else {
                str4 = "IABHelper";
            }
            str2 = str4;
            OTLogger.a(str2, 4, "IAB TCF Active Vendor list, applied overridden  vendors rules : " + jSONObject2.length() + " " + jSONObject2);
            str3 = "IAB TCF Active Vendor list,  applied toggle state";
        } else {
            str2 = "IABHelper";
            OTLogger.a(str2, 3, "domain id using global vendor list");
            q(jSONObject2, jSONObject, jSONObject3, str, z10);
            str3 = "IAB TCF Active Vendor list : " + jSONObject2.length() + " " + jSONObject2.toString();
        }
        OTLogger.a(str2, 4, str3);
        eVar.c().edit().putString("OT_IAB_ACTIVE_VENDORLIST", jSONObject2.toString()).apply();
        j(eVar, jSONObject2);
    }

    public static void m(@NonNull String str, @NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, @NonNull JSONObject jSONObject, @NonNull String str2, boolean z10) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            if (jSONObject.getInt("consent") == 1) {
                jSONArray.put(Integer.parseInt(str2));
            }
        } else {
            if (jSONObject.getInt(OTVendorUtils.LEGITIMATE_CONSENT_TYPE) != 1) {
                if (!(jSONObject.getJSONArray("purposes").length() == 0 && jSONObject.getJSONArray("legIntPurposes").length() == 0 && jSONObject.getJSONArray("specialPurposes").length() > 0 && z10)) {
                    return;
                }
            }
            jSONArray2.put(Integer.parseInt(str2));
        }
    }

    public static void n(@NonNull HashMap map, @NonNull JSONObject jSONObject, @NonNull HashMap map2) throws JSONException {
        if (jSONObject.has("SubGroups")) {
            JSONArray jSONArray = jSONObject.getJSONArray("SubGroups");
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                if (jSONObject2.getBoolean("IsIabPurpose")) {
                    map.put(jSONObject2.getString("CustomGroupId"), jSONObject2.getString("Type"));
                    map2.put(jSONObject2.getString("CustomGroupId"), jSONObject2.getString("Type"));
                }
            }
        }
    }

    public static void o(@NonNull JSONObject jSONObject, @NonNull String str) {
        OTLogger.a("IABHelper", 4, str);
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                try {
                    String string = jSONArrayNames.getString(i10);
                    OTLogger.a("IABHelper", 4, string + ": " + jSONObject.getString(string));
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("error while logging IAB encoder details : "), "IABHelper", 5);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae A[PHI: r10 r12 r13
      0x00ae: PHI (r10v2 org.json.JSONObject) = (r10v1 org.json.JSONObject), (r10v4 org.json.JSONObject) binds: [B:51:0x00ac, B:35:0x007a] A[DONT_GENERATE, DONT_INLINE]
      0x00ae: PHI (r12v2 java.lang.String) = (r12v1 java.lang.String), (r12v3 java.lang.String) binds: [B:51:0x00ac, B:35:0x007a] A[DONT_GENERATE, DONT_INLINE]
      0x00ae: PHI (r13v1 org.json.JSONArray) = (r13v0 org.json.JSONArray), (r13v3 org.json.JSONArray) binds: [B:51:0x00ac, B:35:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void p(@androidx.annotation.NonNull org.json.JSONObject r16, @androidx.annotation.NonNull org.json.JSONObject r17) throws org.json.JSONException {
        /*
            r0 = r17
            int r1 = r16.length()
            if (r1 <= 0) goto Lbf
            r1 = 3
            java.lang.String r2 = "domain id contains publisher restriction."
            java.lang.String r3 = "IABHelper"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r3, r1, r2)
            org.json.JSONArray r1 = r16.names()
            if (r1 == 0) goto Lbf
            r3 = 0
        L17:
            int r4 = r1.length()
            if (r3 >= r4) goto Lbf
            java.lang.String r4 = r1.getString(r3)
            r5 = r16
            org.json.JSONObject r6 = r5.getJSONObject(r4)
            int r7 = r6.length()
            if (r7 != 0) goto L2f
            goto Lbb
        L2f:
            org.json.JSONArray r7 = r6.names()
            if (r7 != 0) goto L37
            goto Lbb
        L37:
            r8 = 0
        L38:
            int r9 = r7.length()
            if (r8 >= r9) goto Lbb
            java.lang.String r9 = r7.getString(r8)
            int r10 = r6.getInt(r9)
            if (r10 != 0) goto L4a
            goto Lb7
        L4a:
            r11 = -1
            r12 = 1
            if (r10 != r12) goto L7d
            boolean r10 = r0.has(r9)
            if (r10 == 0) goto Lb7
            org.json.JSONObject r10 = r0.getJSONObject(r9)
            java.lang.String r12 = "purposes"
            boolean r13 = r10.has(r12)
            if (r13 == 0) goto Lb7
            org.json.JSONArray r13 = r10.getJSONArray(r12)
            int r14 = java.lang.Integer.parseInt(r4)
            r15 = 0
        L69:
            int r2 = r13.length()
            if (r15 >= r2) goto L79
            int r2 = r13.getInt(r15)
            if (r14 != r2) goto L76
            goto L7a
        L76:
            int r15 = r15 + 1
            goto L69
        L79:
            r15 = r11
        L7a:
            if (r15 != r11) goto Lb7
            goto Lae
        L7d:
            r2 = 2
            if (r10 != r2) goto Lb7
            boolean r2 = r0.has(r9)
            if (r2 == 0) goto Lb7
            org.json.JSONObject r10 = r0.getJSONObject(r9)
            java.lang.String r12 = "legIntPurposes"
            boolean r2 = r10.has(r12)
            if (r2 == 0) goto Lb7
            org.json.JSONArray r13 = r10.getJSONArray(r12)
            int r2 = java.lang.Integer.parseInt(r4)
            r14 = 0
        L9b:
            int r15 = r13.length()
            if (r14 >= r15) goto Lab
            int r15 = r13.getInt(r14)
            if (r2 != r15) goto La8
            goto Lac
        La8:
            int r14 = r14 + 1
            goto L9b
        Lab:
            r14 = r11
        Lac:
            if (r14 != r11) goto Lb7
        Lae:
            r13.put(r4)
            r10.put(r12, r13)
            r0.put(r9, r10)
        Lb7:
            int r8 = r8 + 1
            goto L38
        Lbb:
            int r3 = r3 + 1
            goto L17
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.c.p(org.json.JSONObject, org.json.JSONObject):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[PHI: r7
      0x0098: PHI (r7v25 ??) = (r7v30 ??), (r7v31 ??) binds: [B:34:0x00d8, B:21:0x0096] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122 A[PHI: r7
      0x0122: PHI (r7v10 ??) = (r7v42 ??), (r7v43 ??), (r7v44 ??) binds: [B:68:0x0178, B:64:0x0167, B:50:0x0120] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017b A[PHI: r7
      0x017b: PHI (r7v8 ??) = (r7v48 ??), (r7v49 ??), (r7v50 ??) binds: [B:68:0x0178, B:64:0x0167, B:50:0x0120] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r15v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22, types: [int] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [int] */
    /* JADX WARN: Type inference failed for: r8v17, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void q(@androidx.annotation.NonNull org.json.JSONObject r16, @androidx.annotation.NonNull org.json.JSONObject r17, @androidx.annotation.NonNull org.json.JSONObject r18, @androidx.annotation.NonNull java.lang.String r19, boolean r20) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.c.q(org.json.JSONObject, org.json.JSONObject, org.json.JSONObject, java.lang.String, boolean):void");
    }

    @NonNull
    public static String s(@NonNull String str) {
        try {
            return str.contains("_") ? str.split("_")[1] : "";
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("error while getting the iab group id "), "IABHelper", 6);
            return "";
        }
    }

    public static JSONArray t(@NonNull JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < jSONObject.length(); i10++) {
            try {
                if (jSONObject.getInt(jSONObject.names().get(i10).toString()) != 0) {
                    jSONArray.put(Integer.parseInt(jSONObject.names().get(i10).toString()));
                }
            } catch (Exception e10) {
                j.a(e10, new StringBuilder("error in getting legInt ids : "), "IABHelper", 6);
            }
        }
        OTLogger.a("IABHelper", 3, "legInt consent " + jSONArray.toString());
        return jSONArray;
    }

    public static JSONArray w(@NonNull JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < jSONObject.length(); i10++) {
            try {
                if (jSONObject.getInt(jSONObject.names().get(i10).toString()) != 0) {
                    jSONArray.put(Integer.parseInt(jSONObject.names().get(i10).toString()));
                }
            } catch (Exception e10) {
                j.a(e10, new StringBuilder("error in getting specialFeatureOptIns ids : "), "IABHelper", 6);
            }
        }
        OTLogger.a("IABHelper", 3, "specialFeatureOptIns consent " + jSONArray.toString());
        return jSONArray;
    }

    @VisibleForTesting
    public static int x(@Nullable String str) {
        OTLogger.a("IABHelper", 3, "active vendorList = " + str);
        int i10 = 0;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return 0;
        }
        JSONArray jSONArrayNames = new JSONObject(str).names();
        if (jSONArrayNames != null) {
            int i11 = 0;
            while (i10 < jSONArrayNames.length()) {
                int i12 = Integer.parseInt(jSONArrayNames.getString(i10));
                if (i12 > i11) {
                    i11 = i12;
                }
                i10++;
            }
            i10 = i11;
        }
        OTLogger.a("IABHelper", 4, "maximumVendorId = " + i10);
        return i10;
    }

    @NonNull
    public static String y(@NonNull JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (!jSONObject.has("Language") || jSONObject.isNull("Language")) {
            return "en";
        }
        try {
            jSONObject2 = jSONObject.getJSONObject("Language");
        } catch (JSONException e10) {
            n.a(e10, new StringBuilder("Error while getting lang, err"), "IABHelper", 6);
        }
        String strOptString = com.onetrust.otpublishers.headless.Internal.c.q(jSONObject2.optString("Culture")) ? "en" : jSONObject2.optString("Culture");
        return (strOptString.length() <= 2 || !strOptString.contains("-")) ? strOptString : strOptString.split("-")[0].toLowerCase(Locale.ENGLISH);
    }

    public final int a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, boolean z10, JSONObject jSONObject) {
        boolean zA;
        String string = eVar.c().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        try {
            zA = new com.onetrust.otpublishers.headless.Internal.Models.d(this.f21754a).a(jSONObject);
        } catch (JSONException e10) {
            x.a("error on checking reconsent for IAB status, ", e10, "IABHelper", 3);
            zA = false;
        }
        boolean zEqualsIgnoreCase = AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equalsIgnoreCase(str3);
        try {
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                return zEqualsIgnoreCase ? 1 : 0;
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.getJSONObject(str2).has(str)) {
                return !zA ? jSONObject2.getJSONObject(str2).getInt(str) : zEqualsIgnoreCase ? 1 : 0;
            }
            if (z10) {
                return zEqualsIgnoreCase ? 1 : 0;
            }
            return -1;
        } catch (JSONException e11) {
            x.a("unable to get iab consent status", e11, "IABHelper", 3);
            return zEqualsIgnoreCase ? 1 : 0;
        }
    }

    public final String b() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        String str;
        Context context = this.f21754a;
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
        String string = sharedPreferences.getString("OT_IAB_ACTIVE_VENDORLIST", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            str = "Vendor List is empty";
        } else {
            str = "Saved IAB Active Vendor List : " + string;
        }
        OTLogger.a("IABHelper", 3, str);
        return string;
    }

    public final JSONArray f(@NonNull String str) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        Context context = this.f21754a;
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
        String string = sharedPreferences.getString("OTT_CULTURE_DOMAIN_DATA", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while returning culture domain data, err: "), "OneTrust", 6);
                jSONObject = new JSONObject();
            }
        }
        try {
            boolean zE = b0.e(jSONObject);
            JSONObject jSONObject2 = new JSONObject(b());
            for (int i10 = 0; i10 < jSONObject2.length(); i10++) {
                String string2 = jSONObject2.names().get(i10).toString();
                m(str, jSONArray, jSONArray2, jSONObject2.getJSONObject(string2), string2, zE);
            }
        } catch (Exception e11) {
            j.a(e11, new StringBuilder("error in getting vendor ids : "), "IABHelper", 6);
        }
        OTLogger.a("IABHelper", 3, "vendor consent " + jSONArray.toString() + "vendor legInt " + jSONArray2.toString());
        return com.onetrust.otpublishers.headless.Internal.c.q(str) ? jSONArray : jSONArray2;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x033d A[Catch: Exception -> 0x040f, TryCatch #1 {Exception -> 0x040f, blocks: (B:75:0x021d, B:78:0x0263, B:86:0x0293, B:90:0x02aa, B:113:0x031d, B:117:0x032f, B:119:0x033d, B:124:0x0350, B:126:0x0366, B:128:0x0376, B:131:0x037e, B:133:0x0387, B:135:0x0398, B:137:0x03c1, B:138:0x03c4, B:140:0x03dc, B:143:0x03e9, B:134:0x0390, B:93:0x02b1, B:94:0x02bb, B:96:0x02cd, B:101:0x02ee, B:103:0x02f6, B:105:0x0302, B:106:0x0306, B:108:0x030c, B:100:0x02e9, B:99:0x02d4, B:81:0x026a, B:84:0x027d), top: B:167:0x021d, inners: #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0366 A[Catch: Exception -> 0x040f, TryCatch #1 {Exception -> 0x040f, blocks: (B:75:0x021d, B:78:0x0263, B:86:0x0293, B:90:0x02aa, B:113:0x031d, B:117:0x032f, B:119:0x033d, B:124:0x0350, B:126:0x0366, B:128:0x0376, B:131:0x037e, B:133:0x0387, B:135:0x0398, B:137:0x03c1, B:138:0x03c4, B:140:0x03dc, B:143:0x03e9, B:134:0x0390, B:93:0x02b1, B:94:0x02bb, B:96:0x02cd, B:101:0x02ee, B:103:0x02f6, B:105:0x0302, B:106:0x0306, B:108:0x030c, B:100:0x02e9, B:99:0x02d4, B:81:0x026a, B:84:0x027d), top: B:167:0x021d, inners: #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0387 A[Catch: Exception -> 0x040f, TryCatch #1 {Exception -> 0x040f, blocks: (B:75:0x021d, B:78:0x0263, B:86:0x0293, B:90:0x02aa, B:113:0x031d, B:117:0x032f, B:119:0x033d, B:124:0x0350, B:126:0x0366, B:128:0x0376, B:131:0x037e, B:133:0x0387, B:135:0x0398, B:137:0x03c1, B:138:0x03c4, B:140:0x03dc, B:143:0x03e9, B:134:0x0390, B:93:0x02b1, B:94:0x02bb, B:96:0x02cd, B:101:0x02ee, B:103:0x02f6, B:105:0x0302, B:106:0x0306, B:108:0x030c, B:100:0x02e9, B:99:0x02d4, B:81:0x026a, B:84:0x027d), top: B:167:0x021d, inners: #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0390 A[Catch: Exception -> 0x040f, TryCatch #1 {Exception -> 0x040f, blocks: (B:75:0x021d, B:78:0x0263, B:86:0x0293, B:90:0x02aa, B:113:0x031d, B:117:0x032f, B:119:0x033d, B:124:0x0350, B:126:0x0366, B:128:0x0376, B:131:0x037e, B:133:0x0387, B:135:0x0398, B:137:0x03c1, B:138:0x03c4, B:140:0x03dc, B:143:0x03e9, B:134:0x0390, B:93:0x02b1, B:94:0x02bb, B:96:0x02cd, B:101:0x02ee, B:103:0x02f6, B:105:0x0302, B:106:0x0306, B:108:0x030c, B:100:0x02e9, B:99:0x02d4, B:81:0x026a, B:84:0x027d), top: B:167:0x021d, inners: #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03c1 A[Catch: Exception -> 0x040f, TryCatch #1 {Exception -> 0x040f, blocks: (B:75:0x021d, B:78:0x0263, B:86:0x0293, B:90:0x02aa, B:113:0x031d, B:117:0x032f, B:119:0x033d, B:124:0x0350, B:126:0x0366, B:128:0x0376, B:131:0x037e, B:133:0x0387, B:135:0x0398, B:137:0x03c1, B:138:0x03c4, B:140:0x03dc, B:143:0x03e9, B:134:0x0390, B:93:0x02b1, B:94:0x02bb, B:96:0x02cd, B:101:0x02ee, B:103:0x02f6, B:105:0x0302, B:106:0x0306, B:108:0x030c, B:100:0x02e9, B:99:0x02d4, B:81:0x026a, B:84:0x027d), top: B:167:0x021d, inners: #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x015c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013d A[Catch: Exception -> 0x041d, TryCatch #4 {Exception -> 0x041d, blocks: (B:26:0x00c2, B:30:0x00d3, B:32:0x00df, B:42:0x0108, B:43:0x010f, B:52:0x013d, B:53:0x015c, B:47:0x011a, B:54:0x0161, B:56:0x0171, B:58:0x0177, B:60:0x0183, B:62:0x0189, B:64:0x0194, B:66:0x01ad, B:68:0x01c4, B:70:0x01ce, B:71:0x01d2, B:65:0x019c, B:35:0x00e8), top: B:172:0x00c2, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0171 A[Catch: Exception -> 0x041d, TryCatch #4 {Exception -> 0x041d, blocks: (B:26:0x00c2, B:30:0x00d3, B:32:0x00df, B:42:0x0108, B:43:0x010f, B:52:0x013d, B:53:0x015c, B:47:0x011a, B:54:0x0161, B:56:0x0171, B:58:0x0177, B:60:0x0183, B:62:0x0189, B:64:0x0194, B:66:0x01ad, B:68:0x01c4, B:70:0x01ce, B:71:0x01d2, B:65:0x019c, B:35:0x00e8), top: B:172:0x00c2, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019c A[Catch: Exception -> 0x041d, TryCatch #4 {Exception -> 0x041d, blocks: (B:26:0x00c2, B:30:0x00d3, B:32:0x00df, B:42:0x0108, B:43:0x010f, B:52:0x013d, B:53:0x015c, B:47:0x011a, B:54:0x0161, B:56:0x0171, B:58:0x0177, B:60:0x0183, B:62:0x0189, B:64:0x0194, B:66:0x01ad, B:68:0x01c4, B:70:0x01ce, B:71:0x01d2, B:65:0x019c, B:35:0x00e8), top: B:172:0x00c2, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c4 A[Catch: Exception -> 0x041d, TryCatch #4 {Exception -> 0x041d, blocks: (B:26:0x00c2, B:30:0x00d3, B:32:0x00df, B:42:0x0108, B:43:0x010f, B:52:0x013d, B:53:0x015c, B:47:0x011a, B:54:0x0161, B:56:0x0171, B:58:0x0177, B:60:0x0183, B:62:0x0189, B:64:0x0194, B:66:0x01ad, B:68:0x01c4, B:70:0x01ce, B:71:0x01d2, B:65:0x019c, B:35:0x00e8), top: B:172:0x00c2, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0293 A[Catch: Exception -> 0x040f, TryCatch #1 {Exception -> 0x040f, blocks: (B:75:0x021d, B:78:0x0263, B:86:0x0293, B:90:0x02aa, B:113:0x031d, B:117:0x032f, B:119:0x033d, B:124:0x0350, B:126:0x0366, B:128:0x0376, B:131:0x037e, B:133:0x0387, B:135:0x0398, B:137:0x03c1, B:138:0x03c4, B:140:0x03dc, B:143:0x03e9, B:134:0x0390, B:93:0x02b1, B:94:0x02bb, B:96:0x02cd, B:101:0x02ee, B:103:0x02f6, B:105:0x0302, B:106:0x0306, B:108:0x030c, B:100:0x02e9, B:99:0x02d4, B:81:0x026a, B:84:0x027d), top: B:167:0x021d, inners: #2, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(@androidx.annotation.NonNull android.content.Context r29, @androidx.annotation.NonNull java.lang.String r30) {
        /*
            Method dump skipped, instruction units count: 1078
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.c.h(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a0 A[Catch: Exception -> 0x0294, TryCatch #4 {Exception -> 0x0294, blocks: (B:14:0x00a0, B:15:0x00ac, B:17:0x00c1, B:19:0x00cb, B:20:0x00cf, B:23:0x00d9, B:12:0x0099, B:10:0x007c, B:7:0x0073), top: B:54:0x0073, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1 A[Catch: Exception -> 0x0294, TryCatch #4 {Exception -> 0x0294, blocks: (B:14:0x00a0, B:15:0x00ac, B:17:0x00c1, B:19:0x00cb, B:20:0x00cf, B:23:0x00d9, B:12:0x0099, B:10:0x007c, B:7:0x0073), top: B:54:0x0073, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01f8 A[Catch: Exception -> 0x0292, TryCatch #5 {Exception -> 0x0292, blocks: (B:25:0x0172, B:27:0x01f8, B:31:0x020a), top: B:56:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0209  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(@androidx.annotation.NonNull android.content.Context r25, boolean r26) {
        /*
            Method dump skipped, instruction units count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.c.i(android.content.Context, boolean):void");
    }

    @VisibleForTesting
    public final void l(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.g gVar, @NonNull JSONArray jSONArray) {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = new OTPublishersHeadlessSDK(this.f21754a);
        JSONObject jSONObject = new JSONObject();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                jSONObject.put(jSONObject2.getString("CustomGroupId"), c(oTPublishersHeadlessSDK, jSONObject2, jSONObject));
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on parsing vendor count for categories : "), "IAB2V2Flow", 6);
            }
        }
        JSONObject vendorListUI = oTPublishersHeadlessSDK.getVendorListUI(OTVendorListMode.IAB);
        if (vendorListUI != null) {
            try {
                jSONObject.put("activeIabVendorsCount", String.valueOf(vendorListUI.length()));
            } catch (JSONException e11) {
                p.a(e11, new StringBuilder("Error on setting active vendors count : "), "IAB2V2Flow", 6);
            }
        }
        gVar.i(jSONObject);
    }

    public final void r(boolean z10) {
        OTLogger.a("OneTrust", 3, "create default tc string : " + z10);
        if (z10) {
            Context context = this.f21754a;
            new c(context).i(context, true);
            new com.onetrust.otpublishers.headless.gpp.d(this.f21754a).d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u() {
        Object[] objArr;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        boolean z10;
        String string;
        int i10 = 0;
        String[] strArrSplit = new String[0];
        String string2 = PreferenceManager.getDefaultSharedPreferences(this.f21754a).getString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, "");
        if (string2 != null && !com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
            strArrSplit = string2.substring(string2.lastIndexOf("~") + 1).split("\\.");
        }
        if (strArrSplit.length > 0) {
            Context context = this.f21754a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (l.a(context)) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                objArr = true;
            } else {
                objArr = false;
                hVar = null;
            }
            if (objArr != false) {
                sharedPreferences = hVar;
            }
            try {
                string = sharedPreferences.getString("OT_GOOGLE_ACTIVE_VENDOR_LIST", null);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while getting culture data json on getActiveGoogleVendors, err: "), "OneTrust", 6);
            }
            JSONObject jSONObject = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : null;
            if (jSONObject != null) {
                int i11 = 0;
                while (i11 < jSONObject.length()) {
                    try {
                        String string3 = jSONObject.names().get(i11).toString();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(string3);
                        if (jSONObject2.length() > 0 && jSONObject2.getInt("consent") != -1) {
                            jSONObject2.put("consent", Arrays.asList(strArrSplit).contains(string3) ? 1 : 0);
                            jSONObject.put(string3, jSONObject2);
                            Context context2 = this.f21754a;
                            SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", i10);
                            if (com.onetrust.otpublishers.headless.Internal.b.a(context2.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), i10).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                                hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                                z10 = true;
                            } else {
                                hVar2 = null;
                                z10 = false;
                            }
                            if (z10) {
                                sharedPreferences2 = hVar2;
                            }
                            sharedPreferences2.edit().putString("OT_GOOGLE_ACTIVE_VENDOR_LIST", jSONObject.toString()).apply();
                        }
                        i11++;
                        i10 = 0;
                    } catch (JSONException e11) {
                        p.a(e11, new StringBuilder("Saved active google vendor list not found."), "IABHelper", 3);
                        return;
                    }
                }
            }
        }
    }

    @Nullable
    public final String v(@NonNull String str) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f21754a;
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
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("OT_IAB_PURPOSE_TYPES", ""));
            if (jSONObject.has(str)) {
                OTLogger.a("IABHelper", 3, "IAB type of " + str + ": " + jSONObject.getString(str));
                return jSONObject.getString(str);
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while getting IAB type of updated group : "), "IABHelper", 6);
        }
        return "";
    }

    public final boolean z(@NonNull String str) {
        boolean z10 = false;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(v(str)) && (v(str).equals("purposes") || v(str).equals("special_feature_opt_ins"))) {
            z10 = true;
        }
        OTLogger.a("IABHelper", 3, "IAB group " + str + " : " + z10);
        return z10;
    }
}
