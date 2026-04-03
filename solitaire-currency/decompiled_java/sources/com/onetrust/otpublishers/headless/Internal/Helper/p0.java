package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import io.sentry.protocol.ViewHierarchyNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p0 {
    @NonNull
    @VisibleForTesting
    public static JSONArray b(@NonNull JSONObject jSONObject, @NonNull String str) {
        JSONArray jSONArray = new JSONArray();
        if (jSONObject.has("purposeID")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", jSONObject.getString("purposeID"));
                jSONObject2.put("TransactionType", str);
                jSONArray.put(jSONObject2);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on getting Google Ad purposeID. Error = "), "GoogleAdInfo", 6);
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094 A[Catch: Exception -> 0x0098, TRY_LEAVE, TryCatch #0 {Exception -> 0x0098, blocks: (B:3:0x000a, B:6:0x0027, B:11:0x003b, B:13:0x0045, B:16:0x004c, B:23:0x0084, B:26:0x0094, B:17:0x0062, B:19:0x0068, B:22:0x006f, B:24:0x008d), top: B:31:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.content.Context r12, org.json.JSONObject r13) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.String r0 = "OT_IS_LIMIT_AD_TRACKING_ENABLED"
            java.lang.String r1 = "Getting AdvertisingIdClient info in BG thread"
            java.lang.String r2 = "GoogleAdInfo"
            r3 = 4
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r2, r3, r1)
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r1 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r12)     // Catch: java.lang.Exception -> L98
            boolean r1 = r1.isLimitAdTrackingEnabled()     // Catch: java.lang.Exception -> L98
            java.lang.String r4 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r5 = 0
            android.content.SharedPreferences r4 = r12.getSharedPreferences(r4, r5)     // Catch: java.lang.Exception -> L98
            com.onetrust.otpublishers.headless.Internal.profile.d r6 = new com.onetrust.otpublishers.headless.Internal.profile.d     // Catch: java.lang.Exception -> L98
            r6.<init>(r12)     // Catch: java.lang.Exception -> L98
            boolean r6 = r6.t()     // Catch: java.lang.Exception -> L98
            java.lang.String r7 = ""
            r8 = 1
            if (r6 == 0) goto L34
            java.lang.String r6 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r6 = r4.getString(r6, r7)     // Catch: java.lang.Exception -> L98
            com.onetrust.otpublishers.headless.Internal.Preferences.h r9 = new com.onetrust.otpublishers.headless.Internal.Preferences.h     // Catch: java.lang.Exception -> L98
            r9.<init>(r12, r4, r6)     // Catch: java.lang.Exception -> L98
            r6 = r8
            goto L36
        L34:
            r9 = 0
            r6 = r5
        L36:
            if (r6 == 0) goto L3a
            r10 = r9
            goto L3b
        L3a:
            r10 = r4
        L3b:
            java.lang.String r7 = r10.getString(r0, r7)     // Catch: java.lang.Exception -> L98
            boolean r10 = com.onetrust.otpublishers.headless.Internal.c.q(r7)     // Catch: java.lang.Exception -> L98
            if (r10 == 0) goto L62
            java.lang.String r5 = java.lang.Boolean.toString(r1)     // Catch: java.lang.Exception -> L98
            if (r6 == 0) goto L4c
            r4 = r9
        L4c:
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Exception -> L98
            android.content.SharedPreferences$Editor r0 = r4.putString(r0, r5)     // Catch: java.lang.Exception -> L98
            r0.apply()     // Catch: java.lang.Exception -> L98
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L98
            java.lang.String r4 = "Saving Google Ad isLimitAdTrackingEnabled, value = "
            r0.<init>(r4)     // Catch: java.lang.Exception -> L98
            r0.append(r1)     // Catch: java.lang.Exception -> L98
            goto L84
        L62:
            boolean r7 = java.lang.Boolean.parseBoolean(r7)     // Catch: java.lang.Exception -> L98
            if (r7 == r1) goto L8d
            java.lang.String r5 = java.lang.Boolean.toString(r1)     // Catch: java.lang.Exception -> L98
            if (r6 == 0) goto L6f
            r4 = r9
        L6f:
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Exception -> L98
            android.content.SharedPreferences$Editor r0 = r4.putString(r0, r5)     // Catch: java.lang.Exception -> L98
            r0.apply()     // Catch: java.lang.Exception -> L98
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L98
            java.lang.String r4 = "Updating Google Ad isLimitAdTrackingEnabled, value = "
            r0.<init>(r4)     // Catch: java.lang.Exception -> L98
            r0.append(r1)     // Catch: java.lang.Exception -> L98
        L84:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L98
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r2, r3, r0)     // Catch: java.lang.Exception -> L98
            r5 = r8
            goto L92
        L8d:
            java.lang.String r0 = "Google Ad isLimitAdTrackingEnabled status not changed."
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r2, r3, r0)     // Catch: java.lang.Exception -> L98
        L92:
            if (r5 == 0) goto La4
            d(r12, r13, r1)     // Catch: java.lang.Exception -> L98
            goto La4
        L98:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "Error on saveAndConsentLogGooglePermissionState. Error = "
            r13.<init>(r0)
            r0 = 6
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(r12, r13, r2, r0)
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.p0.c(android.content.Context, org.json.JSONObject):void");
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @VisibleForTesting
    public static void d(@NonNull Context context, @NonNull JSONObject jSONObject, boolean z10) throws Throwable {
        boolean z11;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        JSONObject jSONObject2;
        String str;
        String str2;
        String strOptString;
        String strOptString2;
        boolean z12;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        int i10 = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z11 = true;
        } else {
            z11 = false;
            hVar = null;
        }
        if (z11) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_CULTURE_COMMON_DATA", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            jSONObject2 = new JSONObject();
        } else {
            try {
                jSONObject2 = new JSONObject(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while returning common data, err: "), "OneTrust", 6);
                jSONObject2 = new JSONObject();
            }
        }
        String str3 = z10 ? "OPT_OUT" : "CONFIRMED";
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        if (jSONObject2.has("ConsentIntegration")) {
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("ConsentIntegration");
            if (jSONObjectOptJSONObject != null) {
                strOptString2 = jSONObjectOptJSONObject.optString("RequestInformation");
                strOptString = jSONObjectOptJSONObject.optString("ConsentApi");
            } else {
                strOptString = null;
                strOptString2 = null;
            }
            try {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                str = "OTT_DEFAULT_USER";
                try {
                    if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                        hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z12 = true;
                    } else {
                        z12 = false;
                        hVar2 = null;
                    }
                    if (z12) {
                        sharedPreferences2 = hVar2;
                    }
                    String string2 = sharedPreferences2.getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
                    if (string2 == null) {
                        string2 = "";
                    }
                    jSONObject3.put(ViewHierarchyNode.JsonKeys.IDENTIFIER, string2);
                    jSONObject3.put("purposes", b(jSONObject, str3));
                    jSONObject3.put("requestInformation", strOptString2);
                    jSONObject4.put("consentApi", strOptString);
                    jSONObject4.put("consentPayload", jSONObject3);
                    str2 = "GoogleAdInfo";
                } catch (JSONException e11) {
                    e = e11;
                    str2 = "GoogleAdInfo";
                    p.a(e, new StringBuilder("Error in creating Google Ad CL payload :"), str2, 6);
                }
            } catch (JSONException e12) {
                e = e12;
                str = "OTT_DEFAULT_USER";
            }
            i10 = 0;
        } else {
            str = "OTT_DEFAULT_USER";
            str2 = "GoogleAdInfo";
        }
        SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", i10);
        if (h.a(Boolean.FALSE, context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat(str), i10), "OT_ENABLE_MULTI_PROFILE")) {
            SharedPreferences sharedPreferences4 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new com.onetrust.otpublishers.headless.Internal.profile.d(context).n(sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", "")), 0);
            sharedPreferences3.edit();
            sharedPreferences4.edit();
        }
        try {
            new com.onetrust.otpublishers.headless.Internal.Network.n(context).f(3, jSONObject4.getString("consentApi"), jSONObject4.getJSONObject("consentPayload").toString());
            OTLogger.a(str2, 4, "GoogleAd consent obj" + jSONObject4.getJSONObject("consentPayload").toString());
        } catch (JSONException e13) {
            p.a(e13, new StringBuilder("Error while logging consent for GoogleAd."), str2, 6);
        }
    }

    public final void e(@NonNull final Context context, @NonNull final JSONObject jSONObject) {
        new Thread(new Runnable() { // from class: com.onetrust.otpublishers.headless.Internal.Helper.o0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f21786a.c(context, jSONObject);
            }
        }).start();
    }
}
