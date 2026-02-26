package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21751a;

    public a(@NonNull Context context) {
        this.f21751a = context;
    }

    @Nullable
    public static String a(@NonNull SharedPreferences sharedPreferences, @NonNull JSONObject jSONObject) throws JSONException {
        String string = null;
        if (jSONObject.has("GoogleData")) {
            String string2 = jSONObject.getString("GoogleData");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                JSONObject jSONObject2 = new JSONObject(string2);
                if (jSONObject2.has("googleVendorListUrl")) {
                    string = jSONObject2.getString("googleVendorListUrl");
                }
            }
            v.a(sharedPreferences, "OT_GOOGLE_VENDOR_DATA", string2);
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[Catch: JSONException -> 0x00f5, TryCatch #0 {JSONException -> 0x00f5, blocks: (B:3:0x0009, B:5:0x000f, B:8:0x0027, B:12:0x0039, B:19:0x0068, B:21:0x0073, B:23:0x0079, B:24:0x007d, B:26:0x0083, B:27:0x0087, B:31:0x0094, B:34:0x00a1, B:36:0x00a7, B:38:0x00b1, B:40:0x00bd, B:41:0x00c0, B:42:0x00c3, B:44:0x00c9, B:46:0x00cf, B:49:0x00df, B:51:0x00ee, B:50:0x00eb, B:18:0x0063, B:17:0x004c, B:14:0x0045), top: B:58:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9 A[Catch: JSONException -> 0x00f5, LOOP:1: B:44:0x00c9->B:52:0x00f1, LOOP_START, PHI: r5
      0x00c9: PHI (r5v2 int) = (r5v1 int), (r5v3 int) binds: [B:43:0x00c7, B:52:0x00f1] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {JSONException -> 0x00f5, blocks: (B:3:0x0009, B:5:0x000f, B:8:0x0027, B:12:0x0039, B:19:0x0068, B:21:0x0073, B:23:0x0079, B:24:0x007d, B:26:0x0083, B:27:0x0087, B:31:0x0094, B:34:0x00a1, B:36:0x00a7, B:38:0x00b1, B:40:0x00bd, B:41:0x00c0, B:42:0x00c3, B:44:0x00c9, B:46:0x00cf, B:49:0x00df, B:51:0x00ee, B:50:0x00eb, B:18:0x0063, B:17:0x004c, B:14:0x0045), top: B:58:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e r10, @androidx.annotation.NonNull org.json.JSONObject r11, @androidx.annotation.NonNull org.json.JSONObject r12) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.a.b(android.content.Context, com.onetrust.otpublishers.headless.Internal.Preferences.e, org.json.JSONObject, org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(@androidx.annotation.NonNull android.content.Context r18, @androidx.annotation.Nullable java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.a.c(android.content.Context, java.lang.String):void");
    }

    public static void d(@NonNull SharedPreferences sharedPreferences, @NonNull com.onetrust.otpublishers.headless.Internal.Preferences.g gVar, boolean z10) {
        gVar.getClass();
        JSONObject jSONObject = null;
        try {
            String string = gVar.f21893a.c().getString("OT_GOOGLE_ACTIVE_VENDOR_LIST", null);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                jSONObject = new JSONObject(string);
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while getting culture data json on getActiveGoogleVendors, err: "), "OneTrust", 6);
        }
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = z10 ? "1" : "0";
                JSONArray jSONArrayNames = jSONObject.names();
                if (jSONArrayNames != null) {
                    for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                        String string2 = jSONArrayNames.getString(i10);
                        JSONObject jSONObject3 = jSONObject.getJSONObject(string2);
                        if (jSONObject2.has(string2)) {
                            jSONObject3.put("consent", jSONObject2.getJSONObject(string2).getInt("consent"));
                        } else {
                            jSONObject3.put("consent", str);
                        }
                        jSONObject.put(string2, jSONObject3);
                    }
                }
                sharedPreferences.edit().putString("OT_GOOGLE_ACTIVE_VENDOR_LIST", jSONObject.toString()).apply();
            } catch (JSONException e11) {
                p.a(e11, new StringBuilder("Error in updating google vendor status. Error message : "), "GoogleVendorHelper", 6);
            }
        }
    }

    @VisibleForTesting
    public static void e(@NonNull SharedPreferences sharedPreferences, @Nullable String str, @NonNull String str2) {
        v.a(sharedPreferences, str2, str);
    }
}
