package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.f5;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.a f21811b = new com.onetrust.otpublishers.headless.Internal.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f21813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f21814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f21815f;

    public w(@NonNull Context context) {
        this.f21812c = context;
        this.f21810a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        e();
    }

    public static void i(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        String strOptString;
        if (jSONObject2.has(str)) {
            jSONObject.put("userConsentStatus", jSONObject2.optJSONObject(str).optString("userConsentStatus"));
            strOptString = jSONObject2.optJSONObject(str).optString("transactionType");
        } else {
            strOptString = "OPT_OUT";
            jSONObject.put("userConsentStatus", "OPT_OUT");
        }
        jSONObject.put("transactionType", strOptString);
    }

    public final int a(@NonNull String str, @NonNull String str2) {
        int iA = u.a(this.f21815f, str.trim() + str2.trim());
        OTLogger.a("UCPurposesDataHandler", 4, "UCP: Consent Status for Topic id " + str + " : " + iA);
        return iA;
    }

    public final int b(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        int iA = u.a(this.f21814e, str.trim() + str2.trim() + str3.trim());
        OTLogger.a("UCPurposesDataHandler", 4, "UCP: Consent Status for Custom Preference Options id " + str + " : " + iA);
        return iA;
    }

    public final JSONArray c(@NonNull String str) {
        String string = this.f21810a.c().getString("OT_UC_PURPOSES_CUSTOM_PREF_SERVER_DATA", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (int i10 = 0; i10 < jSONObject.length(); i10++) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(jSONObject.names().get(i10).toString());
                if (str.equals(jSONObject2.optString("purposeId"))) {
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in fetching CP data by purpose  :"), "UCPurposesDataHandler", 6);
        }
        OTLogger.a("UCPurposesDataHandler", 3, "Custom Prefs by PurposeId :" + jSONArray);
        return jSONArray;
    }

    public final JSONArray d(@NonNull JSONArray jSONArray, @NonNull String str, @NonNull JSONObject jSONObject, @Nullable JSONArray jSONArray2, int i10) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(jSONObject.names().get(i10).toString());
        OTLogger.a("UCPurposesDataHandler", 3, "purposeObject :" + jSONObject2);
        String string = jSONObject.names().get(i10).toString();
        JSONArray jSONArrayS = s(string);
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        for (int i11 = 0; i11 < jSONArrayS.length(); i11++) {
            JSONObject jSONObject4 = jSONArrayS.getJSONObject(i11);
            if (string.equals(jSONObject4.optString("purposeId"))) {
                jSONObject3.put("name", str);
                jSONArray4.put(jSONObject4);
                jSONObject3.put("options", jSONArray4);
            } else {
                JSONObject jSONObject5 = new JSONObject();
                JSONArray jSONArray5 = new JSONArray();
                jSONObject2.put("topics", jSONArray5);
                jSONObject3 = jSONObject5;
                jSONArray3 = jSONArray5;
            }
        }
        if (jSONObject3.length() > 0) {
            jSONArray3.put(jSONObject3);
        }
        jSONObject2.put("topics", jSONArray3);
        JSONArray jSONArrayC = c(string);
        JSONArray jSONArray6 = new JSONArray();
        JSONArray jSONArrayN = jSONArray2;
        for (int i12 = 0; i12 < jSONArrayC.length(); i12++) {
            JSONObject jSONObject6 = jSONArrayC.getJSONObject(i12);
            String strOptString = jSONObject6.optString("id");
            JSONArray jSONArray7 = new JSONArray();
            if (string.equals(jSONObject6.optString("purposeId"))) {
                if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                    strOptString = jSONObject6.optString("id");
                    jSONArrayN = n(strOptString);
                }
                if (jSONArrayN != null) {
                    for (int i13 = 0; i13 < jSONArrayN.length(); i13++) {
                        JSONObject jSONObject7 = jSONArrayN.getJSONObject(i13);
                        if (strOptString != null && strOptString.equals(jSONObject7.optString("customPreferenceId"))) {
                            jSONArray7.put(jSONObject7);
                            jSONObject6.put("customPreferenceOptions", jSONArray7);
                        }
                    }
                }
                jSONArray6.put(jSONObject6);
                jSONObject2.put("customPreferences", jSONArray6);
            } else {
                jSONArray6 = new JSONArray();
            }
        }
        jSONObject2.put("customPreferences", jSONArray6);
        jSONArray.put(jSONObject2);
        return jSONArrayN;
    }

    public final void e() {
        String string = this.f21810a.c().getString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", JsonUtils.EMPTY_JSON);
        String string2 = this.f21810a.c().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", JsonUtils.EMPTY_JSON);
        String string3 = this.f21810a.c().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", JsonUtils.EMPTY_JSON);
        try {
            this.f21813d = new JSONObject(string);
            this.f21814e = new JSONObject(string2);
            this.f21815f = new JSONObject(string3);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in initializing user state object :"), "UCPurposesDataHandler", 6);
        }
    }

    public final void f(int i10, @NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
        String strOptString = jSONObject2.optString("id");
        if (jSONObject2.has("customPreferences")) {
            JSONArray jSONArray2 = jSONObject2.getJSONArray("customPreferences");
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = jSONArray2.getJSONObject(i11);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("id", jSONObject3, jSONObject4);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("name", jSONObject3, jSONObject4);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("description", jSONObject3, jSONObject4);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("selectionType", jSONObject3, jSONObject4);
                jSONObject3.put("selectionType", "MULTI_CHOICE");
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("displayAs", jSONObject3, jSONObject4);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("required", jSONObject3, jSONObject4);
                jSONObject3.put("purposeId", strOptString);
                jSONObject.put(jSONObject4.optString("id"), jSONObject3);
            }
            OTLogger.a("UCPurposesDataHandler", 3, "customPrefObjectToSave :" + jSONObject);
            this.f21810a.c().edit().putString("OT_UC_PURPOSES_CUSTOM_PREF_SERVER_DATA", String.valueOf(jSONObject)).apply();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003f A[Catch: JSONException -> 0x0046, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0046, blocks: (B:3:0x0004, B:5:0x000c, B:7:0x001e, B:8:0x003f), top: B:14:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(@androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.NonNull java.lang.String r5, @androidx.annotation.NonNull java.lang.String r6, boolean r7) {
        /*
            r3 = this;
            java.lang.String r0 = "UCPurposesDataHandler"
            java.lang.String r1 = "Updated Custom Preference options: "
            org.json.JSONObject r2 = r3.f21814e     // Catch: org.json.JSONException -> L46
            boolean r2 = r2.has(r5)     // Catch: org.json.JSONException -> L46
            if (r2 == 0) goto L3f
            org.json.JSONObject r2 = r3.f21814e     // Catch: org.json.JSONException -> L46
            org.json.JSONObject r5 = r2.optJSONObject(r5)     // Catch: org.json.JSONException -> L46
            java.lang.String r2 = "customPreferenceId"
            java.lang.String r2 = r5.optString(r2)     // Catch: org.json.JSONException -> L46
            boolean r5 = com.onetrust.otpublishers.headless.Internal.Helper.u.c(r7, r5, r4, r2)     // Catch: org.json.JSONException -> L46
            if (r5 == 0) goto L3f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L46
            r5.<init>(r1)     // Catch: org.json.JSONException -> L46
            r5.append(r6)     // Catch: org.json.JSONException -> L46
            java.lang.String r6 = " of Custom Preference Id: "
            r5.append(r6)     // Catch: org.json.JSONException -> L46
            r5.append(r4)     // Catch: org.json.JSONException -> L46
            java.lang.String r4 = " with status: "
            r5.append(r4)     // Catch: org.json.JSONException -> L46
            r5.append(r7)     // Catch: org.json.JSONException -> L46
            java.lang.String r4 = r5.toString()     // Catch: org.json.JSONException -> L46
            r5 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r5, r4)     // Catch: org.json.JSONException -> L46
            goto L52
        L3f:
            java.lang.String r4 = "Invalid id passed to update custom preference options"
            r5 = 5
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r5, r4)     // Catch: org.json.JSONException -> L46
            goto L52
        L46:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Error in updating consent for CP options :"
            r5.<init>(r6)
            r6 = 6
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(r4, r5, r0, r6)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.w.g(java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    public final void h(@NonNull String str, @NonNull String str2, boolean z10) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (this.f21814e.has(str2) && (jSONObjectOptJSONObject = this.f21814e.optJSONObject(str2)) != null) {
                u.c(z10, jSONObjectOptJSONObject, str, jSONObjectOptJSONObject.optString("customPreferenceId"));
            }
            OTLogger.a("UCPurposesDataHandler", 3, "Updated CustomPref options object : " + this.f21814e.optJSONObject(str2));
            u.b(this.f21810a, this.f21813d, this.f21815f, this.f21814e);
            r(this.f21814e);
            e();
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in updating consent for CP options :"), "UCPurposesDataHandler", 6);
        }
    }

    public final void j(@NonNull String str, boolean z10) {
        boolean z11;
        try {
            JSONObject jSONObjectOptJSONObject = this.f21813d.optJSONObject(str);
            String str2 = "ACTIVE";
            if (this.f21813d.has(str)) {
                if (!z10) {
                    str2 = "OPT_OUT";
                }
                jSONObjectOptJSONObject.put("userConsentStatus", str2);
                z11 = true;
            } else {
                OTLogger.a("UCPurposesDataHandler", 5, "Invalid ID passed to update UCP Consent values");
                z11 = false;
            }
            if (z11) {
                OTLogger.a("UCPurposesDataHandler", 3, "Updated purpose id: " + str + " with status: " + z10);
                if (z10) {
                    return;
                }
                p(str, this.f21810a.c().getString("OT_UCP_PURPOSE_RELATION_DATA", JsonUtils.EMPTY_JSON));
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in updating consent for purposes :"), "UCPurposesDataHandler", 6);
        }
    }

    public final void k(@NonNull JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayNames;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject.has(OTVendorListMode.GENERAL)) {
            jSONObject2.put(OTVendorListMode.GENERAL, jSONObject.getJSONObject(OTVendorListMode.GENERAL));
        }
        if (jSONObject.has("description")) {
            jSONObject2.put("description", jSONObject.getJSONObject("description"));
        }
        if (jSONObject.has("title")) {
            jSONObject2.put("title", jSONObject.getJSONObject("title"));
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BUTTONS)) {
            jSONObject2.put(OTUXParamsKeys.OT_UX_BUTTONS, jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_BUTTONS));
        }
        this.f21810a.c().edit().putString("OT_UC_PURPOSES_UI_SERVER_DATA", String.valueOf(jSONObject2)).apply();
        OTLogger.a("UCPurposesDataHandler", 3, "Saved server UCPurpose UI Data :" + this.f21810a.c().getString("OT_UC_PURPOSES_UI_SERVER_DATA", ""));
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("purposes");
        JSONObject jSONObject4 = this.f21813d;
        if (jSONArrayOptJSONArray != null) {
            int i10 = 0;
            while (i10 < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObject5 = new JSONObject();
                JSONObject jSONObject6 = jSONArrayOptJSONArray.getJSONObject(i10);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("id", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("version", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("label", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("description", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("status", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("newVersionAvailable", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("purposeType", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("consentLifeSpan", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("externalReference", jSONObject5, jSONObject6);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b(f5.f12053t, jSONObject5, jSONObject6);
                i(jSONObject6.optString("id"), jSONObject5, this.f21813d);
                jSONObject5.put("defaultConsentStatus", "OPT_OUT");
                jSONObject4.put(jSONObject6.optString("id"), jSONObject5);
                i10++;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
            }
            this.f21810a.c().edit().putString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", String.valueOf(jSONObject4)).apply();
            OTLogger.a("UCPurposesDataHandler", 3, "Saved UC Purpose Server Data :" + this.f21810a.c().getString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", ""));
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("purposes");
        JSONObject jSONObject7 = new JSONObject();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                try {
                    o(i11, jSONArrayOptJSONArray2, jSONObject7);
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error in saving topics data :"), "UCPurposesDataHandler", 6);
                }
                OTLogger.a("UCPurposesDataHandler", 3, "Saved server Topic Data :" + this.f21810a.c().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", ""));
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("purposes");
            JSONObject jSONObject8 = new JSONObject();
            if (jSONArrayOptJSONArray3 != null) {
                for (int i12 = 0; i12 < jSONArrayOptJSONArray3.length(); i12++) {
                    f(i12, jSONArrayOptJSONArray3, jSONObject8);
                }
                OTLogger.a("UCPurposesDataHandler", 3, "Saved server Custom Pref Data :" + this.f21810a.c().getString("OT_UC_PURPOSES_CUSTOM_PREF_SERVER_DATA", ""));
            }
        } catch (JSONException e11) {
            p.a(e11, new StringBuilder("Error in saving custom pref data :"), "UCPurposesDataHandler", 6);
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("purposes");
        JSONObject jSONObject9 = this.f21814e;
        if (jSONArrayOptJSONArray4 != null) {
            for (int i13 = 0; i13 < jSONArrayOptJSONArray4.length(); i13++) {
                try {
                    JSONObject jSONObject10 = jSONArrayOptJSONArray4.getJSONObject(i13);
                    String strOptString = jSONObject10.optString("id");
                    if (jSONObject10.has("customPreferences")) {
                        JSONArray jSONArray = jSONObject10.getJSONArray("customPreferences");
                        for (int i14 = 0; i14 < jSONArray.length(); i14++) {
                            l(jSONObject9, jSONArray, i14, strOptString);
                        }
                    }
                } catch (JSONException e12) {
                    p.a(e12, new StringBuilder("Error in saving CP options data :"), "UCPurposesDataHandler", 6);
                }
                OTLogger.a("UCPurposesDataHandler", 3, "Saved server Custom Pref options Data :" + this.f21810a.c().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", ""));
            }
        }
        e();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("purposes");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i15 = 0; i15 < jSONArrayOptJSONArray5.length(); i15++) {
                try {
                    m(jSONArrayOptJSONArray5.getJSONObject(i15), jSONObject3);
                } catch (JSONException e13) {
                    n.a(e13, new StringBuilder("UCP: error while creating broadcasting object:"), "UCPurposesDataHandler", 6);
                }
            }
        }
        f.a(jSONObject3, this.f21810a.c().edit(), "OT_UCP_PURPOSE_RELATION_DATA");
        Context context = this.f21812c;
        if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject3) || (jSONArrayNames = jSONObject3.names()) == null) {
            return;
        }
        for (int i16 = 0; i16 < jSONArrayNames.length(); i16++) {
            try {
                String string = jSONArrayNames.getString(i16);
                JSONObject jSONObject11 = jSONObject3.getJSONObject(string);
                OTLogger.a("OTConsentChanges", 4, "UCP: Sending " + string + " broadcast, value = " + jSONObject11);
                Intent intent = new Intent(string);
                intent.putExtra(OTBroadcastServiceKeys.UCP_EVENT_STATUS, jSONObject11.toString());
                intent.setPackage(context.getApplicationContext().getPackageName());
                context.sendBroadcast(intent);
            } catch (JSONException e14) {
                n.a(e14, new StringBuilder("UCP: Failed to broadcast UCP consent changes,"), "OTConsentChanges", 6);
                return;
            }
        }
    }

    public final void l(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray, int i10, @NonNull String str) throws JSONException {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
        String strOptString = jSONObject2.optString("id");
        if (jSONObject2.has("customPreferenceOptions")) {
            JSONArray jSONArray2 = jSONObject2.getJSONArray("customPreferenceOptions");
            OTLogger.a("UCPurposesDataHandler", 3, "customPrefArraylength() optionsArray :" + jSONArray2.length());
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = jSONArray2.getJSONObject(i11);
                String str2 = jSONObject4.optString("id") + str + strOptString;
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("id", jSONObject3, jSONObject4);
                this.f21811b.getClass();
                com.onetrust.otpublishers.headless.Internal.a.b("label", jSONObject3, jSONObject4);
                jSONObject3.put("customPreferenceId", strOptString);
                jSONObject3.put("purposeOptionsId", str2);
                jSONObject3.put("purposeId", str);
                i(str2, jSONObject3, this.f21814e);
                jSONObject.put(str2, jSONObject3);
            }
            this.f21810a.c().edit().putString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", String.valueOf(jSONObject)).apply();
        }
    }

    public final void m(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        String strOptString = jSONObject.optString("id");
        jSONObject3.put("status", u(strOptString));
        if (jSONObject.has("topics")) {
            JSONArray jSONArray = jSONObject.getJSONObject("topics").getJSONArray("options");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String strOptString2 = jSONArray.getJSONObject(i10).optString("id", "");
                int iA = a(strOptString2, strOptString);
                if (iA == -1) {
                    iA = 0;
                }
                jSONObject4.put(strOptString2, iA);
            }
        }
        jSONObject3.put("topics", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        if (jSONObject.has("customPreferences")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("customPreferences");
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                JSONObject jSONObject6 = jSONArray2.getJSONObject(i11);
                String string = jSONObject6.getString("id");
                JSONArray jSONArray3 = jSONObject6.getJSONArray("customPreferenceOptions");
                JSONObject jSONObject7 = new JSONObject();
                for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                    String string2 = jSONArray3.getJSONObject(i12).getString("id");
                    int iB = b(string2, strOptString, string);
                    if (iB == -1) {
                        iB = 0;
                    }
                    jSONObject7.put(string2, iB);
                }
                jSONObject5.put(string, jSONObject7);
            }
        }
        jSONObject3.put("custom_preferences", jSONObject5);
        jSONObject2.put(strOptString, jSONObject3);
    }

    public final JSONArray n(@NonNull String str) {
        String string = this.f21810a.c().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (int i10 = 0; i10 < jSONObject.length(); i10++) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(jSONObject.names().get(i10).toString());
                if (str.equals(jSONObject2.optString("customPreferenceId"))) {
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in fetching CP options data by purposeCPId  :"), "UCPurposesDataHandler", 6);
        }
        OTLogger.a("UCPurposesDataHandler", 3, "Options by Purpose and CustomPrefId :" + jSONArray);
        return jSONArray;
    }

    public final void o(int i10, @NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
        String strOptString = jSONObject2.optString("id");
        if (jSONObject2.has("topics")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("topics");
            if (jSONObject3.has("options")) {
                JSONArray jSONArray2 = jSONObject3.getJSONArray("options");
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = jSONArray2.getJSONObject(i11);
                    this.f21811b.getClass();
                    com.onetrust.otpublishers.headless.Internal.a.b("id", jSONObject4, jSONObject5);
                    this.f21811b.getClass();
                    com.onetrust.otpublishers.headless.Internal.a.b("name", jSONObject4, jSONObject5);
                    this.f21811b.getClass();
                    com.onetrust.otpublishers.headless.Internal.a.b("integrationKey", jSONObject4, jSONObject5);
                    jSONObject4.put("purposeId", strOptString);
                    jSONObject4.put("purposeTopicId", jSONObject5.optString("id") + strOptString);
                    i(jSONObject5.optString("id") + strOptString, jSONObject4, this.f21815f);
                    jSONObject.put(jSONObject5.optString("id") + strOptString, jSONObject4);
                }
                this.f21810a.c().edit().putString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", String.valueOf(jSONObject)).apply();
            }
        }
    }

    public final void p(@NonNull String str, @NonNull String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject(str2);
        if (jSONObject.has(str)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            if (jSONObject2.has("topics") && !com.onetrust.otpublishers.headless.Internal.a.d(jSONObject2.getJSONObject("topics"))) {
                JSONArray jSONArrayNames = jSONObject2.getJSONObject("topics").names();
                for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                    String string = jSONArrayNames.getString(i10);
                    t(string.trim() + str.trim(), string, false);
                }
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("custom_preferences");
            if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject3)) {
                return;
            }
            for (int i11 = 0; i11 < jSONObject3.length(); i11++) {
                String string2 = jSONObject3.names().getString(i11);
                JSONObject jSONObject4 = jSONObject3.getJSONObject(string2);
                for (int i12 = 0; i12 < jSONObject4.length(); i12++) {
                    String string3 = jSONObject4.names().getString(i12);
                    g(string2, string3.trim() + str.trim() + string2.trim(), string3, false);
                }
            }
        }
    }

    public final void q(@NonNull String str, @NonNull String str2, boolean z10) {
        try {
            if (this.f21815f.has(str)) {
                JSONObject jSONObjectOptJSONObject = this.f21815f.optJSONObject(str);
                u.c(z10, jSONObjectOptJSONObject, str2, jSONObjectOptJSONObject.optString("id"));
            }
            OTLogger.a("UCPurposesDataHandler", 3, "Updated topic object : " + this.f21815f.optJSONObject(str));
            u.b(this.f21810a, this.f21813d, this.f21815f, this.f21814e);
            r(this.f21815f);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in updating consent for topics :"), "UCPurposesDataHandler", 6);
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        SharedPreferences.Editor editorEdit;
        String strValueOf;
        String str;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(itKeys.next());
            if (jSONObjectOptJSONObject != null) {
                try {
                    jSONObjectOptJSONObject.put("transactionType", jSONObjectOptJSONObject.optString("userConsentStatus"));
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error while updating previous selection to latest selection :"), "UCPurposesDataHandler", 6);
                }
            }
        }
        if (jSONObject.equals(this.f21813d)) {
            editorEdit = this.f21810a.c().edit();
            strValueOf = String.valueOf(this.f21813d);
            str = "OT_UC_PURPOSES_PURPOSE_SERVER_DATA";
        } else if (jSONObject.equals(this.f21815f)) {
            editorEdit = this.f21810a.c().edit();
            strValueOf = String.valueOf(this.f21815f);
            str = "OT_UC_PURPOSES_TOPIC_SERVER_DATA";
        } else {
            if (!jSONObject.equals(this.f21814e)) {
                return;
            }
            editorEdit = this.f21810a.c().edit();
            strValueOf = String.valueOf(this.f21814e);
            str = "OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA";
        }
        editorEdit.putString(str, strValueOf).apply();
    }

    public final JSONArray s(@NonNull String str) {
        String string = this.f21810a.c().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (int i10 = 0; i10 < jSONObject.length(); i10++) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(jSONObject.names().get(i10).toString());
                if (str.equals(jSONObject2.optString("purposeId"))) {
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in fetching topics data by purpose :"), "UCPurposesDataHandler", 6);
        }
        OTLogger.a("UCPurposesDataHandler", 3, "Topics by PurposeId :" + jSONArray);
        return jSONArray;
    }

    public final void t(@NonNull String str, @NonNull String str2, boolean z10) {
        try {
            if (this.f21815f.has(str)) {
                JSONObject jSONObjectOptJSONObject = this.f21815f.optJSONObject(str);
                u.c(z10, jSONObjectOptJSONObject, str2, jSONObjectOptJSONObject.optString("id"));
                OTLogger.a("UCPurposesDataHandler", 3, "Updated topic id: " + str2 + " with status: " + z10);
            } else {
                OTLogger.a("UCPurposesDataHandler", 5, "Invalid id passed to update topics");
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in updating consent for topics :"), "UCPurposesDataHandler", 6);
        }
    }

    public final int u(@NonNull String str) {
        int iA = u.a(this.f21813d, str);
        OTLogger.a("UCPurposesDataHandler", 4, "UCP: Consent Status for Purpose id " + str + " : " + iA);
        return iA;
    }
}
