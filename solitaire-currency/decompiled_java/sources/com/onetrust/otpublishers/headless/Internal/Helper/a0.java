package com.onetrust.otpublishers.headless.Internal.Helper;

import ab.z;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTCustomConfigurator;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProxyType;
import com.onetrust.otpublishers.headless.Public.OTNetworkRequestCallback;
import ga.z;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21752a;

    public a0(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar) {
        this.f21752a = eVar;
    }

    public static void b(@NonNull SharedPreferences sharedPreferences, @NonNull JSONObject jSONObject, @NonNull com.onetrust.otpublishers.headless.Internal.Models.d dVar) {
        long j10;
        if (jSONObject.has("DomainData")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("DomainData");
            e("culture data : ", jSONObject2.toString());
            sharedPreferences.edit().putString("OTT_CULTURE_DOMAIN_DATA", jSONObject2.toString()).apply();
            if (jSONObject2.has("LastReconsentDate")) {
                String string = dVar.f21836b.getString("OTT_LAST_RE_CONSENT_DATE", String.valueOf(-1L));
                if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                    OTLogger.a("ShowBanner", 4, "Last re-consent date not initialized, it will be set once OT SDK initialized.");
                    j10 = -1;
                } else {
                    j10 = Long.parseLong(string);
                }
                if (j10 == -1) {
                    String string2 = !jSONObject2.isNull("LastReconsentDate") ? jSONObject2.get("LastReconsentDate").toString() : "";
                    OTLogger.a("ShowBanner", 4, "Initializing the last re-consent date to - " + string2);
                    if (com.onetrust.otpublishers.headless.Internal.c.q(string2) || jSONObject2.isNull("LastReconsentDate")) {
                        v.a(dVar.f21836b, "OTT_LAST_RE_CONSENT_DATE", "0");
                    } else {
                        v.a(dVar.f21836b, "OTT_LAST_RE_CONSENT_DATE", string2);
                    }
                }
            }
            sharedPreferences.edit().putBoolean("IS_IAB2_V2_TEMPLATE_FLAG", com.onetrust.otpublishers.headless.Internal.c.t(jSONObject2.optString("IabType"))).apply();
        }
    }

    public static void c(a aVar, String str, boolean z10) {
        if (z10) {
            return;
        }
        aVar.getClass();
        OTLogger.a("GoogleVendorHelper", 3, "Google Vendor list Api called ");
        ((com.onetrust.otpublishers.headless.Internal.Network.a) new z.b().c("https://geolocation.1trust.app/").a(bb.k.f()).f(new z.a().b()).d().b(com.onetrust.otpublishers.headless.Internal.Network.a.class)).a(str).i0(new q0(aVar, null));
    }

    @VisibleForTesting
    public static void d(final String str, @NonNull final a aVar) {
        String proxyDomainURLString;
        MalformedURLException e10;
        d.a("IAB template and google vendors enabled, fetching global google vendors from url : ", str, "AppDataParser", 3);
        OTNetworkRequestCallback oTNetworkRequestCallback = null;
        try {
            proxyDomainURLString = OTCustomConfigurator.getProxyDomainURLString(new OTProxyType.GoogleVendors(new URL(str)));
            if (!proxyDomainURLString.isEmpty()) {
                try {
                    OTNetworkRequestCallback oTNetworkRequestCallback2 = new OTNetworkRequestCallback() { // from class: com.onetrust.otpublishers.headless.Internal.Helper.y
                        @Override // com.onetrust.otpublishers.headless.Public.OTNetworkRequestCallback
                        public final void onCompletion(boolean z10) {
                            a0.c(aVar, str, z10);
                        }
                    };
                    str = proxyDomainURLString;
                    oTNetworkRequestCallback = oTNetworkRequestCallback2;
                } catch (MalformedURLException e11) {
                    e10 = e11;
                    OTLogger.a("AppDataParser", 6, "Error on getting google vendor list url : " + e10.getMessage());
                    str = proxyDomainURLString;
                }
            }
        } catch (MalformedURLException e12) {
            proxyDomainURLString = str;
            e10 = e12;
        }
        OTLogger.a("GoogleVendorHelper", 3, "Google Vendor list Api called ");
        ((com.onetrust.otpublishers.headless.Internal.Network.a) new z.b().c("https://geolocation.1trust.app/").a(bb.k.f()).f(new z.a().b()).d().b(com.onetrust.otpublishers.headless.Internal.Network.a.class)).a(str).i0(new q0(aVar, oTNetworkRequestCallback));
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        OTLogger.a("AppDataParser", 3, str + str2);
    }

    public static void f(@NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject, int i10, boolean z10) throws JSONException {
        if (!(jSONObject.getBoolean("IsIabPurpose") && jSONObject.getBoolean("ShowInPopup") && e0.h(jSONObject, z10)) && jSONObject.getJSONArray("FirstPartyCookies").length() <= 0) {
            return;
        }
        if (jSONArray.getJSONObject(i10).has("SubGroups")) {
            jSONArray.getJSONObject(i10).getJSONArray("SubGroups").put(jSONObject);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject);
        jSONArray.getJSONObject(i10).put("SubGroups", jSONArray2);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x021e A[Catch: JSONException -> 0x027c, TryCatch #1 {JSONException -> 0x027c, blocks: (B:35:0x00e1, B:38:0x00ed, B:39:0x00f4, B:41:0x00fa, B:43:0x010c, B:57:0x0142, B:59:0x0148, B:61:0x014e, B:62:0x0153, B:64:0x0159, B:135:0x024e, B:71:0x0173, B:73:0x0179, B:75:0x017f, B:77:0x0189, B:79:0x0195, B:134:0x024a, B:67:0x0169, B:84:0x01a6, B:86:0x01ac, B:88:0x01b2, B:89:0x01b9, B:91:0x01bf, B:99:0x01d8, B:107:0x01e9, B:109:0x01ef, B:111:0x01f5, B:113:0x01fb, B:114:0x0200, B:116:0x0206, B:123:0x021e, B:125:0x0224, B:127:0x022a, B:129:0x0234, B:131:0x0242, B:119:0x0216, B:94:0x01cf, B:44:0x0111, B:45:0x0116, B:47:0x011c, B:49:0x012a, B:136:0x025d), top: B:143:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0248 A[PHI: r10 r18
      0x0248: PHI (r10v6 int) = (r10v4 int), (r10v8 int) binds: [B:132:0x0246, B:81:0x019e] A[DONT_GENERATE, DONT_INLINE]
      0x0248: PHI (r18v5 org.json.JSONArray) = (r18v2 org.json.JSONArray), (r18v10 org.json.JSONArray) binds: [B:132:0x0246, B:81:0x019e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x024a A[Catch: JSONException -> 0x027c, PHI: r6 r18
      0x024a: PHI (r6v14 java.lang.String) = (r6v6 java.lang.String), (r6v21 java.lang.String) binds: [B:132:0x0246, B:80:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x024a: PHI (r18v4 org.json.JSONArray) = (r18v2 org.json.JSONArray), (r18v10 org.json.JSONArray) binds: [B:132:0x0246, B:80:0x019c] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {JSONException -> 0x027c, blocks: (B:35:0x00e1, B:38:0x00ed, B:39:0x00f4, B:41:0x00fa, B:43:0x010c, B:57:0x0142, B:59:0x0148, B:61:0x014e, B:62:0x0153, B:64:0x0159, B:135:0x024e, B:71:0x0173, B:73:0x0179, B:75:0x017f, B:77:0x0189, B:79:0x0195, B:134:0x024a, B:67:0x0169, B:84:0x01a6, B:86:0x01ac, B:88:0x01b2, B:89:0x01b9, B:91:0x01bf, B:99:0x01d8, B:107:0x01e9, B:109:0x01ef, B:111:0x01f5, B:113:0x01fb, B:114:0x0200, B:116:0x0206, B:123:0x021e, B:125:0x0224, B:127:0x022a, B:129:0x0234, B:131:0x0242, B:119:0x0216, B:94:0x01cf, B:44:0x0111, B:45:0x0116, B:47:0x011c, B:49:0x012a, B:136:0x025d), top: B:143:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0173 A[Catch: JSONException -> 0x027c, TryCatch #1 {JSONException -> 0x027c, blocks: (B:35:0x00e1, B:38:0x00ed, B:39:0x00f4, B:41:0x00fa, B:43:0x010c, B:57:0x0142, B:59:0x0148, B:61:0x014e, B:62:0x0153, B:64:0x0159, B:135:0x024e, B:71:0x0173, B:73:0x0179, B:75:0x017f, B:77:0x0189, B:79:0x0195, B:134:0x024a, B:67:0x0169, B:84:0x01a6, B:86:0x01ac, B:88:0x01b2, B:89:0x01b9, B:91:0x01bf, B:99:0x01d8, B:107:0x01e9, B:109:0x01ef, B:111:0x01f5, B:113:0x01fb, B:114:0x0200, B:116:0x0206, B:123:0x021e, B:125:0x0224, B:127:0x022a, B:129:0x0234, B:131:0x0242, B:119:0x0216, B:94:0x01cf, B:44:0x0111, B:45:0x0116, B:47:0x011c, B:49:0x012a, B:136:0x025d), top: B:143:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(@androidx.annotation.NonNull org.json.JSONObject r19, @androidx.annotation.NonNull android.content.Context r20, com.onetrust.otpublishers.headless.Internal.Preferences.g r21) {
        /*
            Method dump skipped, instruction units count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.a0.g(org.json.JSONObject, android.content.Context, com.onetrust.otpublishers.headless.Internal.Preferences.g):void");
    }

    public static void h(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray, @NonNull Context context) {
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        String str;
        boolean z11;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        com.onetrust.otpublishers.headless.Internal.Models.a aVar = new com.onetrust.otpublishers.headless.Internal.Models.a();
        com.onetrust.otpublishers.headless.Internal.Models.b bVar = new com.onetrust.otpublishers.headless.Internal.Models.b();
        if (jSONObject.getJSONObject("culture").getJSONObject("CommonData").has("ConsentIntegration")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("culture").getJSONObject("CommonData").getJSONObject("ConsentIntegration");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            String str2 = "";
            if (l.a(context)) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                z10 = false;
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            sharedPreferences.edit().putString("OT_CONSENT_INTEGRATION_DATA", jSONObject2.toString()).apply();
            if (jSONObject2.optString("ConsentApi") != null) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (l.a(context)) {
                    hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z11 = true;
                } else {
                    z11 = false;
                    hVar2 = null;
                }
                String string = (z11 ? hVar2 : sharedPreferences2).getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
                if (string == null) {
                    string = "";
                }
                if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                    SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    String string2 = sharedPreferences3.getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
                    if (com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                        string2 = UUID.randomUUID().toString();
                        v.a(sharedPreferences3, "OT_GENERIC_PROFILE_IDENTIFIER", string2);
                    }
                    str2 = string2;
                    v.a(z11 ? hVar2 : sharedPreferences2, "OTT_DATA_SUBJECT_IDENTIFIER", str2);
                    if (z11) {
                        sharedPreferences2 = hVar2;
                    }
                    sharedPreferences2.edit().putInt("OTT_DATA_SUBJECT_IDENTIFIER_TYPE", 1).apply();
                } else {
                    if (z11) {
                        sharedPreferences2 = hVar2;
                    }
                    String string3 = sharedPreferences2.getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
                    if (string3 != null) {
                        str2 = string3;
                    }
                }
                bVar.f21831c = str2;
                bVar.f21830b = jSONArray;
                bVar.f21829a = jSONObject2.optString("RequestInformation");
                aVar.f21827a = jSONObject2.optString("ConsentApi");
                aVar.f21828b = bVar;
                try {
                    new j0(context).c(aVar);
                    return;
                } catch (Exception unused) {
                    str = "could not construct consent logging data";
                }
            } else {
                str = "error while constructing consent payload";
            }
            OTLogger.a("AppDataParser", 4, str);
        }
    }

    public static void i(@NonNull JSONObject jSONObject, boolean z10) {
        JSONArray jSONArray = jSONObject.getJSONObject("culture").getJSONObject("DomainData").getJSONArray("Groups");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            if (!jSONArray.getJSONObject(i10).getString("Parent").isEmpty()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                String string = jSONArray.getJSONObject(i10).getString("Parent");
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    try {
                        if (string.equals(jSONArray.getJSONObject(i11).optString("CustomGroupId"))) {
                            f(jSONArray, jSONObject2, i11, z10);
                        }
                    } catch (JSONException e10) {
                        p.a(e10, new StringBuilder("error while moving subgroups with err = "), "AppDataParser", 6);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(@androidx.annotation.NonNull android.content.SharedPreferences r7, @androidx.annotation.NonNull org.json.JSONObject r8, @androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.Internal.Preferences.g r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.a0.a(android.content.SharedPreferences, org.json.JSONObject, android.content.Context, com.onetrust.otpublishers.headless.Internal.Preferences.g, boolean, boolean):void");
    }
}
