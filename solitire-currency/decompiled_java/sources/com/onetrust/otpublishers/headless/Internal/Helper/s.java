package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f21800c;

    public s(@NonNull Context context) {
        this.f21798a = context;
        this.f21799b = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        this.f21800c = new w(context);
    }

    @VisibleForTesting
    public static void d(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, @NonNull JSONObject jSONObject3, @NonNull JSONObject jSONObject4) throws JSONException {
        if ((!(jSONObject.optString("userConsentStatus").equals("ACTIVE") && jSONObject.optString("transactionType").equals("OPT_OUT")) && jSONObject.optString("userConsentStatus").equals("ACTIVE") && jSONObject.optString("transactionType").equals("ACTIVE")) ? !jSONObject4.optString("userConsentStatus").equals(jSONObject4.optString("transactionType")) : false) {
            jSONObject2.put("TransactionType", "CHANGE_PREFERENCES");
            jSONObject3.put("OptionId", jSONObject4.optString("id"));
            jSONObject3.put("TransactionType", jSONObject4.optString("userConsentStatus").equals("OPT_IN") ? "OPT_IN" : "OPT_OUT");
            jSONArray.put(jSONObject3);
            return;
        }
        if (!jSONObject.optString("userConsentStatus").equals("ACTIVE") || jSONObject2.getString("TransactionType").equals("CHANGE_PREFERENCES")) {
            return;
        }
        jSONObject2.put("TransactionType", "CONFIRMED");
        if (jSONObject4.getString("userConsentStatus").equals("OPT_IN")) {
            jSONArray2.put(jSONObject4.optString("id"));
        }
    }

    public static void e(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull JSONObject jSONObject3, @NonNull String str, @NonNull JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject4 = jSONObject;
        int i10 = 0;
        while (i10 < jSONObject.length()) {
            JSONObject jSONObject5 = new JSONObject();
            JSONObject jSONObjectOptJSONObject = jSONObject4.optJSONObject(jSONObject4.getJSONObject(jSONObject.names().get(i10).toString()).optString("purposeTopicId"));
            String strOptString = jSONObjectOptJSONObject.optString("id");
            if (jSONObjectOptJSONObject.optString("purposeId").equals(str)) {
                String str2 = "OPT_IN";
                if ((jSONObject3.optString("userConsentStatus").equals("ACTIVE") && jSONObject3.optString("transactionType").equals("OPT_OUT") && jSONObjectOptJSONObject.optString("transactionType").equals("OPT_IN")) || (jSONObject3.optString("userConsentStatus").equals("ACTIVE") && jSONObject3.optString("transactionType").equals("OPT_OUT") && jSONObjectOptJSONObject.optString("userConsentStatus").equals("OPT_IN"))) {
                    jSONObject5.put("TopicId", strOptString);
                    jSONObject2.put("TransactionType", "CONFIRMED");
                } else if (jSONObject3.optString("userConsentStatus").equals("ACTIVE") && jSONObject3.optString("transactionType").equals("ACTIVE") && jSONObjectOptJSONObject.optString("userConsentStatus").equals("OPT_IN")) {
                    if (!jSONObjectOptJSONObject.optString("userConsentStatus").equals(jSONObjectOptJSONObject.optString("transactionType"))) {
                        jSONObject5.put("TopicId", strOptString);
                        jSONObject5.put("TransactionType", str2);
                        jSONObject2.put("TransactionType", "CHANGE_PREFERENCES");
                    }
                } else if (jSONObject3.optString("userConsentStatus").equals("ACTIVE") && jSONObject3.optString("transactionType").equals("ACTIVE") && jSONObjectOptJSONObject.optString("userConsentStatus").equals("OPT_OUT") && !jSONObjectOptJSONObject.optString("userConsentStatus").equals(jSONObjectOptJSONObject.optString("transactionType"))) {
                    str2 = "OPT_OUT";
                    jSONObject5.put("TopicId", strOptString);
                    jSONObject5.put("TransactionType", str2);
                    jSONObject2.put("TransactionType", "CHANGE_PREFERENCES");
                }
                if (!jSONObject5.toString().equals(JsonUtils.EMPTY_JSON)) {
                    jSONArray.put(jSONObject5);
                }
            }
            i10++;
            jSONObject4 = jSONObject;
        }
        jSONObject2.put("Preferences", jSONArray);
    }

    public final JSONArray a() {
        String string = this.f21799b.c().getString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", "");
        String string2 = this.f21799b.c().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", "");
        String string3 = this.f21799b.c().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", "");
        JSONArray jSONArray = new JSONArray();
        try {
            c(jSONArray, new JSONObject(string), new JSONObject(string2), new JSONObject(string3));
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in fetching saved ucp data :"), "UCPConsentLoggingData", 6);
        }
        OTLogger.a("UCPConsentLoggingData", 3, "UCP consent payload :" + jSONArray);
        return jSONArray;
    }

    public final void b(@NonNull String str, int i10) {
        JSONArray jSONArrayNames;
        StringBuilder sb;
        JSONArray jSONArrayNames2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayNames3 = jSONObject.names();
            if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayNames3)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < jSONArrayNames3.length(); i12++) {
                String string = jSONArrayNames3.getString(i12);
                boolean zG = g(string, jSONObject.getJSONObject(string), jSONObject2);
                if (zG && !z10) {
                    z10 = zG;
                }
            }
            if (z10) {
                Context context = this.f21798a;
                if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObject2) && (jSONArrayNames2 = jSONObject2.names()) != null) {
                    while (i11 < jSONArrayNames2.length()) {
                        try {
                            String string2 = jSONArrayNames2.getString(i11);
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(string2);
                            OTLogger.a("OTConsentChanges", 4, "UCP: Sending " + string2 + " broadcast, value = " + jSONObject3);
                            Intent intent = new Intent(string2);
                            intent.putExtra(OTBroadcastServiceKeys.UCP_EVENT_STATUS, jSONObject3.toString());
                            intent.setPackage(context.getApplicationContext().getPackageName());
                            context.sendBroadcast(intent);
                            i11++;
                        } catch (JSONException e10) {
                            sb = new StringBuilder("UCP: Failed to broadcast UCP consent changes,");
                            sb.append(e10.toString());
                            OTLogger.a("OTConsentChanges", 6, sb.toString());
                        }
                    }
                }
            } else if (i10 != 1) {
                Context context2 = this.f21798a;
                if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObject) && (jSONArrayNames = jSONObject.names()) != null) {
                    while (i11 < jSONArrayNames.length()) {
                        try {
                            String string3 = jSONArrayNames.getString(i11);
                            JSONObject jSONObject4 = jSONObject.getJSONObject(string3);
                            OTLogger.a("OTConsentChanges", 4, "UCP: Sending " + string3 + " broadcast, value = " + jSONObject4);
                            Intent intent2 = new Intent(string3);
                            intent2.putExtra(OTBroadcastServiceKeys.UCP_EVENT_STATUS, jSONObject4.toString());
                            intent2.setPackage(context2.getApplicationContext().getPackageName());
                            context2.sendBroadcast(intent2);
                            i11++;
                        } catch (JSONException e11) {
                            sb = new StringBuilder("UCP: Failed to broadcast UCP consent changes,");
                            sb.append(e11.toString());
                            OTLogger.a("OTConsentChanges", 6, sb.toString());
                        }
                    }
                }
            }
            this.f21799b.c().edit().putString("OT_UCP_PURPOSE_RELATION_DATA", jSONObject.toString()).apply();
        } catch (JSONException e12) {
            n.a(e12, new StringBuilder("failed to trigger broadcast for UC Purposes,"), "OneTrust", 6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r15v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final void c(@NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull JSONObject jSONObject3) {
        ?? r82;
        String str;
        String str2;
        JSONArray jSONArray2;
        ?? r15;
        ?? r12;
        ?? r92;
        ?? r83;
        ?? r23;
        ?? r18;
        int i10;
        char c10;
        String strOptString;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        s sVar = this;
        JSONObject jSONObject8 = jSONObject;
        String str3 = "TransactionType";
        String str4 = "id";
        JSONArray jSONArrayC = null;
        ?? OptJSONObject = 0;
        ?? r93 = 0;
        while (r93 < jSONObject.length()) {
            ?? jSONObject9 = new JSONObject();
            try {
                String strOptString2 = jSONObject8.getJSONObject(jSONObject.names().get(r93 == true ? 1 : 0).toString()).optString(str4);
                OptJSONObject = jSONObject8.optJSONObject(strOptString2);
                Objects.requireNonNull(OptJSONObject);
                String strOptString3 = OptJSONObject.optString(str4);
                jSONObject9.put(str4, strOptString3);
                jSONObject9.put(str3, OptJSONObject.optString("userConsentStatus").equals("ACTIVE") ? "CONFIRMED" : "OPT_OUT");
                try {
                    e(jSONObject3, jSONObject9, OptJSONObject, strOptString3, new JSONArray());
                    jSONArrayC = sVar.f21800c.c(strOptString2);
                    r82 = OptJSONObject;
                } catch (JSONException e10) {
                    e = e10;
                    p.a(e, new StringBuilder("Error in constructing UCP purpose object :"), "UCPConsentLoggingData", 6);
                    r82 = OptJSONObject;
                }
            } catch (JSONException e11) {
                e = e11;
            }
            JSONArray jSONArray5 = new JSONArray();
            if (jSONArrayC != null) {
                int i11 = 0;
                r82 = r82;
                r93 = r93;
                ?? r122 = jSONArray5;
                jSONObject9 = jSONObject9;
                while (i11 < jSONArrayC.length()) {
                    try {
                        strOptString = jSONArrayC.getJSONObject(i11).optString(str4);
                        JSONArray jSONArrayN = sVar.f21800c.n(strOptString);
                        jSONArray3 = new JSONArray();
                        jSONArray4 = new JSONArray();
                        jSONObject4 = new JSONObject();
                        str = str3;
                        try {
                            jSONObject5 = new JSONObject();
                            str2 = str4;
                            int i12 = 0;
                            while (i12 < jSONArrayN.length()) {
                                try {
                                    jSONObject6 = jSONArrayN.getJSONObject(i12);
                                    jSONObject7 = new JSONObject();
                                    jSONArray2 = jSONArrayC;
                                } catch (JSONException e12) {
                                    e = e12;
                                    jSONArray2 = jSONArrayC;
                                    r83 = r82;
                                    r92 = r93;
                                    r12 = r122;
                                    r15 = jSONObject9;
                                    r23 = r83;
                                    r18 = r92;
                                    i10 = i11;
                                    r82 = r12;
                                    r93 = r15;
                                    c10 = 6;
                                    p.a(e, new StringBuilder("Error in constructing UCP consent payload :"), "UCPConsentLoggingData", 6);
                                    i11 = i10 + 1;
                                    sVar = this;
                                    r122 = r82;
                                    jSONObject9 = r93;
                                    str3 = str;
                                    str4 = str2;
                                    r93 = r18;
                                    jSONArrayC = jSONArray2;
                                    r82 = r23;
                                }
                                try {
                                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(jSONObject6.optString("purposeOptionsId"));
                                    JSONArray jSONArray6 = jSONArrayN;
                                    ?? r10 = r82;
                                    i10 = i11;
                                    ?? r11 = jSONObject9;
                                    r23 = r82;
                                    r82 = r122;
                                    r18 = r93 == true ? 1 : 0;
                                    r93 = jSONObject9;
                                    try {
                                        d(r10, r11, jSONArray3, jSONArray4, jSONObject7, jSONObjectOptJSONObject);
                                        i12++;
                                        r122 = r82;
                                        jSONObject9 = r93;
                                        r93 = r18 == true ? 1 : 0;
                                        jSONArrayC = jSONArray2;
                                        jSONArrayN = jSONArray6;
                                        i11 = i10;
                                        r82 = r23;
                                    } catch (JSONException e13) {
                                        e = e13;
                                        c10 = 6;
                                        p.a(e, new StringBuilder("Error in constructing UCP consent payload :"), "UCPConsentLoggingData", 6);
                                        i11 = i10 + 1;
                                        sVar = this;
                                        r122 = r82;
                                        jSONObject9 = r93;
                                        str3 = str;
                                        str4 = str2;
                                        r93 = r18;
                                        jSONArrayC = jSONArray2;
                                        r82 = r23;
                                    }
                                } catch (JSONException e14) {
                                    e = e14;
                                    r83 = r82;
                                    r92 = r93;
                                    r12 = r122;
                                    r15 = jSONObject9;
                                    r23 = r83;
                                    r18 = r92;
                                    i10 = i11;
                                    r82 = r12;
                                    r93 = r15;
                                    c10 = 6;
                                    p.a(e, new StringBuilder("Error in constructing UCP consent payload :"), "UCPConsentLoggingData", 6);
                                    i11 = i10 + 1;
                                    sVar = this;
                                    r122 = r82;
                                    jSONObject9 = r93;
                                    str3 = str;
                                    str4 = str2;
                                    r93 = r18;
                                    jSONArrayC = jSONArray2;
                                    r82 = r23;
                                }
                            }
                            jSONArray2 = jSONArrayC;
                            r23 = r82;
                            r18 = r93 == true ? 1 : 0;
                            i10 = i11;
                            r82 = r122;
                            r93 = jSONObject9;
                        } catch (JSONException e15) {
                            e = e15;
                            str2 = str4;
                            jSONArray2 = jSONArrayC;
                            r83 = r82;
                            r92 = r93;
                            r12 = r122;
                            r15 = jSONObject9;
                            r23 = r83;
                            r18 = r92;
                            i10 = i11;
                            r82 = r12;
                            r93 = r15;
                            c10 = 6;
                            p.a(e, new StringBuilder("Error in constructing UCP consent payload :"), "UCPConsentLoggingData", 6);
                            i11 = i10 + 1;
                            sVar = this;
                            r122 = r82;
                            jSONObject9 = r93;
                            str3 = str;
                            str4 = str2;
                            r93 = r18;
                            jSONArrayC = jSONArray2;
                            r82 = r23;
                        }
                    } catch (JSONException e16) {
                        e = e16;
                        str = str3;
                    }
                    if (jSONArray3.length() > 0) {
                        jSONObject4.put("Id", strOptString);
                        jSONObject4.put("Choices", jSONArray3);
                    } else {
                        if (jSONArray4.length() > 0) {
                            jSONObject5.put("Id", strOptString);
                            jSONObject5.put("Options", jSONArray4);
                            jSONObject4 = jSONObject5;
                        }
                        r93.put("CustomPreferences", r82);
                        c10 = 6;
                        i11 = i10 + 1;
                        sVar = this;
                        r122 = r82;
                        jSONObject9 = r93;
                        str3 = str;
                        str4 = str2;
                        r93 = r18;
                        jSONArrayC = jSONArray2;
                        r82 = r23;
                    }
                    r82.put(jSONObject4);
                    r93.put("CustomPreferences", r82);
                    c10 = 6;
                    i11 = i10 + 1;
                    sVar = this;
                    r122 = r82;
                    jSONObject9 = r93;
                    str3 = str;
                    str4 = str2;
                    r93 = r18;
                    jSONArrayC = jSONArray2;
                    r82 = r23;
                }
            }
            jSONArray.put(jSONObject9);
            sVar = this;
            jSONObject8 = jSONObject;
            str3 = str3;
            str4 = str4;
            jSONArrayC = jSONArrayC;
            OptJSONObject = r82;
            r93 = (r93 == true ? 1 : 0) + 1;
        }
    }

    public final boolean f(@NonNull String str, @NonNull String str2, @NonNull JSONObject jSONObject, boolean z10) throws JSONException {
        for (int i10 = 0; i10 < jSONObject.length(); i10++) {
            String string = jSONObject.names().getString(i10);
            int i11 = jSONObject.getInt(string);
            int iB = this.f21800c.b(string, str, str2);
            if (i11 != iB) {
                jSONObject.put(string, iB);
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean g(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        boolean zF;
        int i10 = jSONObject.getInt("status");
        int iU = this.f21800c.u(str);
        if (i10 != iU) {
            jSONObject.put("status", iU);
            zF = true;
        } else {
            zF = false;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("topics");
        if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObject3)) {
            JSONArray jSONArrayNames = jSONObject3.names();
            for (int i11 = 0; i11 < jSONObject3.length(); i11++) {
                String string = jSONArrayNames.getString(i11);
                int i12 = jSONObject3.getInt(string);
                int iA = this.f21800c.a(string, str);
                if (i12 != iA) {
                    jSONObject3.put(string, iA);
                    zF = true;
                }
            }
        }
        JSONObject jSONObject4 = jSONObject.getJSONObject("custom_preferences");
        if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObject4)) {
            for (int i13 = 0; i13 < jSONObject4.length(); i13++) {
                String string2 = jSONObject4.names().getString(i13);
                zF = f(str, string2, jSONObject4.getJSONObject(string2), zF);
            }
        }
        if (zF) {
            jSONObject2.put(str, jSONObject);
        }
        return zF;
    }
}
