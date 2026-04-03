package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f21756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f21757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.g f21758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21759d;

    public e(@NonNull Context context) {
        this.f21757b = context;
        this.f21758c = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
        this.f21759d = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        this.f21756a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean d(@Nullable String str, int i10, @NonNull JSONObject jSONObject, int i11, @NonNull String str2) throws JSONException {
        int iOptInt = jSONObject.optInt(str2, -1);
        if (iOptInt < 0) {
            return false;
        }
        int i12 = (str == null || com.onetrust.otpublishers.headless.Internal.c.q(str) || i11 <= 0 || i11 > i10) ? 0 : Integer.parseInt(String.valueOf(str.charAt(i11 - 1)));
        if (i12 == iOptInt) {
            return false;
        }
        jSONObject.put(str2, i12);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:8:0x0025, B:10:0x0031, B:15:0x0053, B:17:0x0059, B:14:0x004e, B:13:0x0038), top: B:28:0x0025, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r7 = this;
            java.lang.String r0 = "OneTrust"
            android.content.Context r1 = r7.f21757b
            java.lang.String r2 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r3 = 0
            android.content.SharedPreferences r2 = r1.getSharedPreferences(r2, r3)
            boolean r4 = com.onetrust.otpublishers.headless.Internal.Helper.l.a(r1)
            java.lang.String r5 = ""
            if (r4 == 0) goto L20
            java.lang.String r4 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r4 = r2.getString(r4, r5)
            com.onetrust.otpublishers.headless.Internal.Preferences.h r6 = new com.onetrust.otpublishers.headless.Internal.Preferences.h
            r6.<init>(r1, r2, r4)
            r1 = 1
            goto L22
        L20:
            r6 = 0
            r1 = r3
        L22:
            if (r1 == 0) goto L25
            r2 = r6
        L25:
            java.lang.String r1 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r1 = r2.getString(r1, r5)     // Catch: java.lang.Exception -> L5e
            boolean r2 = com.onetrust.otpublishers.headless.Internal.c.q(r1)     // Catch: java.lang.Exception -> L5e
            if (r2 != 0) goto L4e
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5e
            r2.<init>(r1)     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5e
            goto L53
        L37:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5e
            java.lang.String r4 = "error while returning culture domain data, err: "
            r2.<init>(r4)     // Catch: java.lang.Exception -> L5e
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Exception -> L5e
            r2.append(r1)     // Catch: java.lang.Exception -> L5e
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> L5e
            r2 = 6
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r2, r1)     // Catch: java.lang.Exception -> L5e
        L4e:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5e
            r2.<init>()     // Catch: java.lang.Exception -> L5e
        L53:
            int r1 = r2.length()     // Catch: java.lang.Exception -> L5e
            if (r1 <= 0) goto L6a
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Exception -> L5e
            goto L6a
        L5e:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "empty data as SDK not yet initialized "
            r2.<init>(r4)
            r4 = 3
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(r1, r2, r0, r4)
        L6a:
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r5)
            if (r0 == 0) goto L71
            return
        L71:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r5)
            com.onetrust.otpublishers.headless.Internal.Models.d r1 = new com.onetrust.otpublishers.headless.Internal.Models.d
            android.content.Context r2 = r7.f21757b
            r1.<init>(r2)
            boolean r1 = r1.a(r0)
            if (r1 == 0) goto L98
            com.onetrust.otpublishers.headless.Internal.Helper.t r1 = new com.onetrust.otpublishers.headless.Internal.Helper.t
            android.content.Context r2 = r7.f21757b
            r1.<init>(r2)
            java.lang.String r2 = "Groups"
            org.json.JSONArray r0 = r0.getJSONArray(r2)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r1.j(r0, r2, r3)
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.e.a():void");
    }

    public final void b(@Nullable String str, @Nullable String str2) throws JSONException {
        int length = !com.onetrust.otpublishers.headless.Internal.c.q(str) ? str.length() : -1;
        int length2 = com.onetrust.otpublishers.headless.Internal.c.q(str2) ? -1 : str2.length();
        String string = this.f21758c.f21893a.c().getString("OT_IAB_ACTIVE_VENDORLIST", null);
        JSONObject jSONObject = com.onetrust.otpublishers.headless.Internal.c.q(string) ? null : new JSONObject(string);
        if (jSONObject == null) {
            OTLogger.a("IABTCStringParser", 4, "Empty vendor array, not updating the vendor status. Vendor status will be updated once vendor details fetched.");
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        boolean z10 = false;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            int i10 = jSONObject2.getInt("id");
            boolean zD = d(str, length, jSONObject2, i10, "consent");
            boolean zD2 = d(str2, length2, jSONObject2, i10, OTVendorUtils.LEGITIMATE_CONSENT_TYPE);
            if (zD || zD2) {
                jSONObject.put(next, jSONObject2);
                z10 = true;
            }
        }
        if (z10) {
            f.a(jSONObject, this.f21759d.c().edit(), "OT_IAB_ACTIVE_VENDORLIST");
        }
    }

    public final void c(@Nullable String str, @Nullable String str2, @Nullable String str3) throws JSONException {
        int length = -1;
        int length2 = (str == null || com.onetrust.otpublishers.headless.Internal.c.q(str)) ? -1 : str.length();
        int length3 = (str2 == null || com.onetrust.otpublishers.headless.Internal.c.q(str2)) ? -1 : str2.length();
        if (str3 != null && !com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            length = str3.length();
        }
        String string = this.f21758c.f21893a.c().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        JSONObject jSONObject = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        int i10 = 1;
        while (true) {
            int i11 = 0;
            if (i10 > 11) {
                break;
            }
            String strValueOf = String.valueOf(i10);
            if (str != null && !com.onetrust.otpublishers.headless.Internal.c.q(str) && i10 > 0 && i10 <= length2) {
                i11 = Integer.parseInt(String.valueOf(str.charAt(i10 - 1)));
            }
            jSONObject2.put(strValueOf, i11);
            i10++;
        }
        int i12 = 2;
        while (i12 <= 11) {
            jSONObject3.put(String.valueOf(i12), (str2 == null || com.onetrust.otpublishers.headless.Internal.c.q(str2) || i12 <= 0 || i12 > length3) ? 0 : Integer.parseInt(String.valueOf(str2.charAt(i12 - 1))));
            i12++;
        }
        int i13 = 1;
        while (i13 <= 2) {
            jSONObject4.put(String.valueOf(i13), (str3 == null || com.onetrust.otpublishers.headless.Internal.c.q(str3) || i13 <= 0 || i13 > length) ? 0 : Integer.parseInt(String.valueOf(str3.charAt(i13 - 1))));
            i13++;
        }
        jSONObject.put("purposes", jSONObject2);
        jSONObject.put("purposeLegitimateInterests", jSONObject3);
        jSONObject.put("special_feature_opt_ins", jSONObject4);
        f.a(jSONObject, this.f21759d.c().edit(), "OTT_IAB_CONSENTABLE_PURPOSES");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instruction units count: 1336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.e.e():void");
    }
}
