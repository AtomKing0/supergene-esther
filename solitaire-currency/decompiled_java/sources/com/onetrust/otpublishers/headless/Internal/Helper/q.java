package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.RequestConfiguration;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static q f21789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList<String> f21790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f21791c;

    public static synchronized q a(boolean z10) {
        if (f21789a == null) {
            f21791c = z10;
            f21789a = new q();
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("IABTCF_CmpSdkID.int", "IABTCF_CmpSdkVersion.int", "IABTCF_PolicyVersion.int", "IABTCF_gdprApplies.int", "IABTCF_PublisherCC.string", "IABTCF_PurposeOneTreatment.int", "IABTCF_TCString.string", "IABTCF_VendorConsents.string", "IABTCF_VendorLegitimateInterests.string", "IABTCF_PurposeConsents.string", "IABTCF_PurposeLegitimateInterests.string", "IABTCF_SpecialFeaturesOptIns.string", "IABTCF_PublisherConsent.string", "IABTCF_PublisherLegitimateInterests.string", "IABTCF_PublisherCustomPurposesConsents.string", "IABTCF_PublisherCustomPurposesLegitimateInterests.string", "IABTCF_PublisherRestrictions1.string", "IABTCF_PublisherRestrictions2.string", "IABTCF_PublisherRestrictions3.string", "IABTCF_PublisherRestrictions4.string", "IABTCF_PublisherRestrictions5.string", "IABTCF_PublisherRestrictions6.string", "IABTCF_PublisherRestrictions7.string", "IABTCF_PublisherRestrictions8.string", "IABTCF_PublisherRestrictions9.string", "IABTCF_PublisherRestrictions10.string", "IABTCF_PublisherRestrictions11.string"));
            f21790b = arrayList;
            arrayList.add(f21791c ? "IABTCF_UseNonStandardTexts.int" : "IABTCF_UseNonStandardStacks.int");
        }
        return f21789a;
    }

    public static String b(Context context, JSONObject jSONObject) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = null;
        try {
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (new com.onetrust.otpublishers.headless.Internal.profile.d(context).t()) {
                    hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z10 = true;
                } else {
                    hVar = null;
                    z10 = false;
                }
                new com.onetrust.otpublishers.headless.gpp.c(context);
                if (z10) {
                    sharedPreferences = hVar;
                }
                boolean z11 = sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false);
                boolean zContains = defaultSharedPreferences.contains("IABTCF_TCString");
                String str = e(jSONObject, editorEdit, z11, zContains) + "." + n(jSONObject, editorEdit, z11, zContains);
                editorEdit.putString(z11 ? OTGppKeys.IAB_GPP_TCFEU2_STRING : "IABTCF_TCString", str);
                if (z11 && zContains) {
                    editorEdit.putString("IABTCF_TCString", str);
                }
                editorEdit.apply();
                return str;
            } catch (Throwable th) {
                th = th;
                editor = editorEdit;
                if (editor != null) {
                    editor.apply();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(Integer num, Integer num2) {
        String binaryString = Integer.toBinaryString(num.intValue());
        StringBuilder sb = new StringBuilder();
        for (int iIntValue = num2.intValue() - binaryString.length(); iIntValue > 0; iIntValue--) {
            sb.append('0');
        }
        sb.append(binaryString);
        return sb.toString();
    }

    public static String d(String str) {
        int length = str.length() % 8;
        if (length > 0) {
            StringBuilder sb = new StringBuilder(str);
            for (int i10 = 8 - length; i10 > 0; i10--) {
                sb.append('0');
            }
            str = sb.toString();
        }
        int length2 = str.length() / 8;
        byte[] bArr = new byte[length2];
        for (int i11 = 0; i11 < length2; i11++) {
            int i12 = i11 * 8;
            bArr[i11] = Integer.valueOf(Integer.parseInt(str.substring(i12, i12 + 8), 2)).byteValue();
        }
        return new String(Base64.encode(bArr, 2)).replace("+", "-").replace(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, "_").replace(v8.i.f15833b, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x056a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0384 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x042e A[Catch: Exception -> 0x04ae, JSONException -> 0x04ba, TryCatch #9 {JSONException -> 0x04ba, Exception -> 0x04ae, blocks: (B:86:0x0423, B:88:0x042e, B:90:0x043f, B:91:0x0447, B:92:0x044f, B:94:0x0455, B:96:0x0469, B:98:0x046f, B:99:0x0472, B:103:0x047c, B:106:0x0496), top: B:138:0x0423 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e(org.json.JSONObject r32, android.content.SharedPreferences.Editor r33, boolean r34, boolean r35) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.q.e(org.json.JSONObject, android.content.SharedPreferences$Editor, boolean, boolean):java.lang.String");
    }

    public static JSONObject f(@NonNull Context context, @NonNull SharedPreferences sharedPreferences) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new com.onetrust.otpublishers.headless.gpp.c(context).f23791b;
        if (map.keySet().isEmpty()) {
            return jSONObject;
        }
        for (String str : map.keySet()) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str) && (str.startsWith("IABGPP_TCFEU2_") || str.equals(OTGppKeys.IAB_GPP_TCFEU2_STRING))) {
                Integer num = (Integer) map.get(str);
                if (Objects.equals(num, com.onetrust.otpublishers.headless.gpp.c.f23788d)) {
                    jSONObject.put(str, sharedPreferences.getInt(str, -1));
                } else if (Objects.equals(num, com.onetrust.otpublishers.headless.gpp.c.f23789e)) {
                    jSONObject.put(str, sharedPreferences.getString(str, ""));
                }
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0025 A[PHI: r4
      0x0025: PHI (r4v2 java.lang.String) = (r4v0 java.lang.String), (r4v1 java.lang.String) binds: [B:6:0x0023, B:9:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(android.content.Context r6) {
        /*
            android.content.SharedPreferences r6 = android.preference.PreferenceManager.getDefaultSharedPreferences(r6)
            android.content.SharedPreferences$Editor r6 = r6.edit()
            java.util.ArrayList<java.lang.String> r0 = com.onetrust.otpublishers.headless.Internal.Helper.q.f21790b
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = ""
            r2 = r1
        L11:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L37
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = ".int"
            boolean r5 = r3.endsWith(r4)
            if (r5 == 0) goto L2a
        L25:
            java.lang.String r2 = r3.replace(r4, r1)
            goto L33
        L2a:
            java.lang.String r4 = ".string"
            boolean r5 = r3.endsWith(r4)
            if (r5 == 0) goto L33
            goto L25
        L33:
            r6.remove(r2)
            goto L11
        L37:
            java.lang.String r0 = "IABTCF_UseNonStandardStacks"
            r6.remove(r0)
            java.lang.String r0 = "IABTCF_UseNonStandardTexts"
            r6.remove(r0)
            r6.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.q.g(android.content.Context):void");
    }

    public static void h(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull com.onetrust.otpublishers.headless.Internal.Preferences.a aVar) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        try {
            for (String str : f21790b) {
                if (str.endsWith(".int")) {
                    String strReplace = str.replace(".int", "");
                    jSONObject.put(strReplace.replace("IABTCF_", "IABGPP_TCFEU2_"), aVar.d(strReplace));
                } else if (str.endsWith(".string")) {
                    String strReplace2 = str.replace(".string", "");
                    jSONObject.put("IABTCF_TCString".equals(strReplace2) ? OTGppKeys.IAB_GPP_TCFEU2_STRING : strReplace2.replace("IABTCF_", "IABGPP_TCFEU2_"), aVar.e(strReplace2));
                }
            }
            boolean z10 = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            sharedPreferences.edit().putString("OT_GPP_DATA_BACKUP", jSONObject.toString()).apply();
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("copyDataFromTCFKeys failed : "), "TCF2Encoder", 6);
        }
    }

    public static void i(SharedPreferences.Editor editor) {
        editor.remove("IABTCF_PublisherRestrictions1");
        editor.remove("IABTCF_PublisherRestrictions2");
        editor.remove("IABTCF_PublisherRestrictions3");
        editor.remove("IABTCF_PublisherRestrictions4");
        editor.remove("IABTCF_PublisherRestrictions5");
        editor.remove("IABTCF_PublisherRestrictions6");
        editor.remove("IABTCF_PublisherRestrictions7");
        editor.remove("IABTCF_PublisherRestrictions8");
        editor.remove("IABTCF_PublisherRestrictions9");
        editor.remove("IABTCF_PublisherRestrictions10");
        editor.remove("IABTCF_PublisherRestrictions11");
        editor.apply();
    }

    public static void j(JSONObject jSONObject, SharedPreferences.Editor editor, String str, String str2, String str3, String str4, String str5) throws JSONException {
        int i10;
        String str6;
        editor.putInt(OTIABTCFKeys.IABTCF_GDPRAPPLIES, jSONObject.getInt("gdprApplies"));
        editor.putInt(OTIABTCFKeys.IABTCF_CMPSDKID, jSONObject.getInt("CmpId"));
        editor.putInt(OTIABTCFKeys.IABTCF_CMPSDKVERSION, jSONObject.getInt("CmpVersion"));
        editor.putInt(OTIABTCFKeys.IABTCF_POLICYVERSION, jSONObject.getInt("TcfPolicyVersion"));
        if (f21791c) {
            i10 = jSONObject.getInt("UseNonStandardStacks");
            str6 = OTIABTCFKeys.IABTCF_USENONSTANDARDTEXTS;
        } else {
            i10 = jSONObject.getInt("UseNonStandardStacks");
            str6 = OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS;
        }
        editor.putInt(str6, i10);
        editor.putString(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, str);
        editor.putString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, str2);
        editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT, str2);
        editor.putString(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, str3);
        editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS, str3);
        editor.putInt(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT, jSONObject.getInt("PurposeOneTreatment"));
        editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCC, jSONObject.getString("PublisherCC"));
        editor.putString(OTIABTCFKeys.IABTCF_VENDORCONSENTS, str4);
        editor.putString(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, str5);
    }

    public static boolean k(JSONArray jSONArray, Integer num) {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while getting Array Integer : "), "TCF2Encoder", 6);
            }
            if (jSONArray.getInt(i10) == num.intValue()) {
                return true;
            }
        }
        return false;
    }

    public static String l(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList(Arrays.asList(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"));
        for (int i10 = 0; i10 < upperCase.length(); i10++) {
            sb.append(c(Integer.valueOf(arrayList.indexOf(String.valueOf(upperCase.charAt(i10)))), 6));
        }
        return sb.toString();
    }

    public static String m(JSONArray jSONArray, Integer num) {
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        while (i10 < num.intValue()) {
            i10++;
            sb.append(k(jSONArray, Integer.valueOf(i10)) ? "1" : "0");
        }
        return sb.toString();
    }

    public static String n(JSONObject jSONObject, SharedPreferences.Editor editor, boolean z10, boolean z11) throws JSONException {
        String str;
        String str2;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(c(3, 3));
        jSONArray.put(m(jSONObject.getJSONArray("PurposesConsent"), 24));
        jSONArray.put(m(jSONObject.getJSONArray("PurposesLITransparency"), 24));
        int i10 = jSONObject.getInt("NumCustomPurposes");
        jSONArray.put(c(Integer.valueOf(i10), 6));
        if (z10) {
            str2 = OTGppKeys.IAB_GPP_PUBLISHERCUSTOMPURPOSESCONSENTS;
            str = OTGppKeys.IAB_GPP_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS;
        } else {
            str = OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS;
            str2 = OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS;
        }
        if (i10 > 0) {
            jSONArray.put(m(jSONObject.getJSONArray("CustomPurposesConsent"), Integer.valueOf(i10)));
            editor.putString(str2, jSONArray.getString(jSONArray.length() - 1));
            if (z10 && z11) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS, jSONArray.getString(jSONArray.length() - 1));
            }
            jSONArray.put(m(jSONObject.getJSONArray("CustomPurposesLITransparency"), Integer.valueOf(i10)));
            editor.putString(str, jSONArray.getString(jSONArray.length() - 1));
            if (z10 && z11) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, jSONArray.getString(jSONArray.length() - 1));
            }
        } else {
            editor.putString(str2, "");
            editor.putString(str, "");
            if (z10 && z11) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS, "");
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, "");
            }
        }
        return d(jSONArray.toString().replace(",", "").replace("\"", "").replace(v8.i.f15837d, "").replace(v8.i.f15839e, ""));
    }

    public static JSONObject o(Context context) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        JSONObject jSONObject = new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        new com.onetrust.otpublishers.headless.gpp.c(context);
        if (z10) {
            sharedPreferences = hVar;
        }
        try {
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while getting all string : "), "TCF2Encoder", 6);
        }
        if (sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false)) {
            return f(context, defaultSharedPreferences);
        }
        for (String str : f21790b) {
            if (str.endsWith(".int")) {
                String strReplace = str.replace(".int", "");
                jSONObject.put(strReplace, defaultSharedPreferences.getInt(strReplace, -1));
            } else if (str.endsWith(".string")) {
                String strReplace2 = str.replace(".string", "");
                jSONObject.put(strReplace2, defaultSharedPreferences.getString(strReplace2, ""));
            }
        }
        return jSONObject;
    }

    public static void p(@NonNull Context context) {
        int iD;
        String str;
        com.onetrust.otpublishers.headless.Internal.Preferences.a aVar = new com.onetrust.otpublishers.headless.Internal.Preferences.a(context);
        aVar.b(OTGppKeys.IAB_GPP_GDPRAPPLIES, aVar.d(OTIABTCFKeys.IABTCF_GDPRAPPLIES));
        aVar.b(OTGppKeys.IAB_GPP_CMPSDKID, aVar.d(OTIABTCFKeys.IABTCF_CMPSDKID));
        aVar.b(OTGppKeys.IAB_GPP_CMPSDKVERSION, aVar.d(OTIABTCFKeys.IABTCF_CMPSDKVERSION));
        aVar.b(OTGppKeys.IAB_GPP_POLICYVERSION, aVar.d(OTIABTCFKeys.IABTCF_POLICYVERSION));
        if (f21791c) {
            iD = aVar.d(OTIABTCFKeys.IABTCF_USENONSTANDARDTEXTS);
            str = OTGppKeys.IAB_GPP_USENONSTANDARDTEXTS;
        } else {
            iD = aVar.d(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS);
            str = OTGppKeys.IAB_GPP_USENONSTANDARDSTACKS;
        }
        aVar.b(str, iD);
        aVar.c(OTGppKeys.IAB_GPP_SPECIALFEATURESOPTINS, aVar.e(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS));
        aVar.c(OTGppKeys.IAB_GPP_TCFEU2_STRING, aVar.e("IABTCF_TCString"));
        aVar.c(OTGppKeys.IAB_GPP_PURPOSECONSENTS, aVar.e(OTIABTCFKeys.IABTCF_PURPOSECONSENTS));
        aVar.c(OTGppKeys.IAB_GPP_PUBLISHERCONSENT, aVar.e(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT));
        aVar.c(OTGppKeys.IAB_GPP_PURPOSELEGITIMATEINTERESTS, aVar.e(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS));
        aVar.c(OTGppKeys.IAB_GPP_PUBLISHERLEGITIMATEINTERESTS, aVar.e(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS));
        aVar.b(OTGppKeys.IAB_GPP_PURPOSEONETREATMENT, aVar.d(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT));
        aVar.c(OTGppKeys.IAB_GPP_PUBLISHERCC, aVar.e(OTIABTCFKeys.IABTCF_PUBLISHERCC));
        aVar.c(OTGppKeys.IAB_GPP_VENDORCONSENTS, aVar.e(OTIABTCFKeys.IABTCF_VENDORCONSENTS));
        aVar.c(OTGppKeys.IAB_GPP_VENDORLEGITIMATEINTERESTS, aVar.e(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS));
        for (int i10 = 1; i10 <= 10; i10++) {
            String str2 = OTIABTCFKeys.IABTCF_PUBLISHERRESTRICTIONS + i10;
            if (aVar.f21885a.contains(str2)) {
                aVar.c(OTGppKeys.IAB_GPP_PUBLISHERRESTRICTIONS + i10, aVar.e(str2));
            }
        }
    }
}
