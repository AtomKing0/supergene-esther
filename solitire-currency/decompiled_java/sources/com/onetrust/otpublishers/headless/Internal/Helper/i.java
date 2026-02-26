package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.g f21765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f21766b;

    public i(@NonNull Context context) {
        this.f21766b = context;
        this.f21765a = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
    }

    @VisibleForTesting
    public final void a(@Nullable String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                n0 n0Var = new n0(this.f21766b);
                n0Var.b(jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY), 1, jSONObject.optString("state"));
                n0Var.b(jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY), 3, jSONObject.optString("state"));
                OTLogger.a("OTSDKMigration", 2, "Saving Consent given location from Web SDK, country : " + jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY) + "state : " + jSONObject.optString("state"));
            } catch (Exception e10) {
                j.a(e10, new StringBuilder("Error while migrating consent given location, err : "), "OTSDKMigration", 3);
            }
        }
    }

    public final void b(@NonNull JSONObject jSONObject) {
        int i10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        this.f21765a.h(1);
        JSONObject jSONObject2 = new JSONObject();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f21766b);
        SharedPreferences sharedPreferences = this.f21766b.getSharedPreferences("com.onetrust.otpublisherssdk.Internal.preference", 0);
        String string = defaultSharedPreferences.getString("optanonCookieConsentGroups", "");
        String string2 = defaultSharedPreferences.getString("completeOptanonCookie", "");
        String string3 = defaultSharedPreferences.getString("OTuserConsentGivenLocation", "");
        int i11 = sharedPreferences.getInt("OT_BANNER_SHOWN_TO_USER", -1);
        String string4 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, "");
        String string5 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, "");
        String string6 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, "");
        String string7 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_VENDORCONSENTS, "");
        String string8 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, "");
        try {
            JSONObject jSONObject3 = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : new JSONObject();
            JSONArray jSONArray = new JSONArray(new JSONTokener(string2).nextValue().toString());
            int i12 = 0;
            while (true) {
                if (i12 >= jSONArray.length()) {
                    break;
                }
                if (jSONArray.getJSONObject(i12).optString("name", "").equals("OptanonAlertBoxClosed")) {
                    jSONObject2 = jSONArray.getJSONObject(i12);
                    break;
                }
                i12++;
            }
            d(jSONObject2);
            a(string3);
            Context context = this.f21766b;
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.b.a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
                z10 = false;
            }
            if (z10) {
                sharedPreferences2 = hVar;
            }
            if (sharedPreferences2.getInt("OneTrustBannerShownToUser", -1) < 1 && i11 == 1) {
                com.onetrust.otpublishers.headless.Internal.c.c(this.f21766b, 1);
            }
            JSONArray jSONArrayNames = jSONObject3.names();
            if (jSONArrayNames != null) {
                for (int i13 = 0; i13 < jSONArrayNames.length(); i13++) {
                    jSONObject.put(jSONArrayNames.getString(i13), Integer.parseInt(jSONObject3.getString(jSONArrayNames.getString(i13))));
                }
            }
            i10 = 6;
            try {
                c(jSONObject, string4, string5, string6, string7, string8, jSONObject2);
                if (this.f21765a.f21893a.c().getInt("OT_MIGRATION_STATUS", 5) != 6) {
                    this.f21765a.h(3);
                }
            } catch (JSONException e10) {
                e = e10;
                this.f21765a.h(2);
                p.a(e, new StringBuilder("error while syncing data from Web SDK, err: "), "OneTrust", i10);
            }
        } catch (JSONException e11) {
            e = e11;
            i10 = 6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0241 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0212 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(@androidx.annotation.NonNull org.json.JSONObject r19, @androidx.annotation.Nullable java.lang.String r20, @androidx.annotation.Nullable java.lang.String r21, @androidx.annotation.Nullable java.lang.String r22, @androidx.annotation.Nullable java.lang.String r23, @androidx.annotation.Nullable java.lang.String r24, @androidx.annotation.NonNull org.json.JSONObject r25) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.i.c(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(@androidx.annotation.NonNull org.json.JSONObject r7) throws org.json.JSONException {
        /*
            r6 = this;
            java.lang.String r0 = "value"
            boolean r1 = r7.has(r0)
            if (r1 == 0) goto L5e
            java.lang.String r7 = r7.getString(r0)
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r7)
            if (r0 != 0) goto L5e
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "yyyy-MM-dd'T'HH:mm:ss"
            r0.<init>(r1)
            java.lang.String r1 = "UTC"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            java.lang.String r1 = "OTSDKMigration"
            r2 = -1
            if (r7 == 0) goto L4a
            java.util.Date r7 = r0.parse(r7)     // Catch: java.text.ParseException -> L33
            if (r7 == 0) goto L4a
            long r4 = r7.getTime()     // Catch: java.text.ParseException -> L33
            goto L4b
        L33:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Error while migrating consent given time, err : "
            r0.<init>(r4)
            java.lang.String r7 = r7.getMessage()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r0 = 6
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r1, r0, r7)
        L4a:
            r4 = r2
        L4b:
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L58
            com.onetrust.otpublishers.headless.Internal.Preferences.g r7 = r6.f21765a
            java.lang.String r0 = java.lang.String.valueOf(r4)
            r7.w(r0)
        L58:
            java.lang.String r7 = "Saving Consent given time from WebSDK"
            r0 = 2
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r1, r0, r7)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.i.d(org.json.JSONObject):void");
    }
}
