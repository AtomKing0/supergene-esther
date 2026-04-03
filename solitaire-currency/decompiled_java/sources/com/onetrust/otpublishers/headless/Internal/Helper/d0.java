package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21755a;

    public d0(@NonNull Context context) {
        this.f21755a = context;
    }

    @NonNull
    public final String a(@NonNull String str, @NonNull JSONArray jSONArray) {
        String str2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str3 = "SubGroups";
        JSONObject jSONObject3 = new JSONObject(str);
        OTLogger.a("WebviewConsentHelper", 3, "OTSDK consented group and status = " + str);
        JSONObject jSONObject4 = new JSONObject();
        Iterator<String> itKeys = jSONObject3.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = jSONObject3.get(next);
                int i10 = 0;
                while (i10 < jSONArray.length()) {
                    try {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i10);
                        if (jSONObject5.has(str3)) {
                            JSONArray jSONArray2 = jSONObject5.getJSONArray(str3);
                            str2 = str3;
                            try {
                                if (next.equals(jSONObject5.optString("CustomGroupId", ""))) {
                                    try {
                                        if ("COOKIE".equals(jSONObject5.getString("Type")) && !jSONObject5.getBoolean("IsIabPurpose")) {
                                            jSONObject4.put(next, obj);
                                        }
                                    } catch (JSONException e10) {
                                        e = e10;
                                        jSONObject = jSONObject3;
                                        p.a(e, new StringBuilder("Error on parsing. Error msg = "), "WebviewConsentHelper", 6);
                                        str3 = str2;
                                        jSONObject3 = jSONObject;
                                    }
                                }
                                int i11 = 0;
                                while (i11 < jSONArray2.length()) {
                                    JSONObject jSONObject6 = jSONArray2.getJSONObject(i11);
                                    jSONObject = jSONObject3;
                                    try {
                                        if (next.equals(jSONObject6.optString("CustomGroupId", "")) && "COOKIE".equals(jSONObject6.getString("Type")) && !jSONObject6.getBoolean("IsIabPurpose")) {
                                            jSONObject4.put(next, obj);
                                        }
                                        i11++;
                                        jSONObject3 = jSONObject;
                                    } catch (JSONException e11) {
                                        e = e11;
                                        p.a(e, new StringBuilder("Error on parsing. Error msg = "), "WebviewConsentHelper", 6);
                                        str3 = str2;
                                        jSONObject3 = jSONObject;
                                    }
                                }
                                jSONObject2 = jSONObject3;
                            } catch (JSONException e12) {
                                e = e12;
                                jSONObject = jSONObject3;
                                p.a(e, new StringBuilder("Error on parsing. Error msg = "), "WebviewConsentHelper", 6);
                                str3 = str2;
                                jSONObject3 = jSONObject;
                            }
                        } else {
                            str2 = str3;
                            jSONObject2 = jSONObject3;
                            if (next.equals(jSONObject5.optString("CustomGroupId", "")) && "COOKIE".equals(jSONObject5.getString("Type")) && !jSONObject5.getBoolean("IsIabPurpose")) {
                                jSONObject4.put(next, obj);
                            }
                        }
                        i10++;
                        str3 = str2;
                        jSONObject3 = jSONObject2;
                    } catch (JSONException e13) {
                        e = e13;
                        str2 = str3;
                        jSONObject = jSONObject3;
                        p.a(e, new StringBuilder("Error on parsing. Error msg = "), "WebviewConsentHelper", 6);
                        str3 = str2;
                        jSONObject3 = jSONObject;
                    }
                }
                str2 = str3;
                jSONObject = jSONObject3;
                try {
                    c(jSONObject4);
                } catch (JSONException e14) {
                    e = e14;
                    p.a(e, new StringBuilder("Error on parsing. Error msg = "), "WebviewConsentHelper", 6);
                }
            } catch (JSONException e15) {
                e = e15;
            }
            str3 = str2;
            jSONObject3 = jSONObject;
        }
        return jSONObject4.toString();
    }

    @NonNull
    public final String b(boolean z10) {
        boolean z11;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z12;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar3;
        JSONObject jSONObject = new JSONObject();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f21755a);
        try {
            JSONObject preferenceCenterData = new OTPublishersHeadlessSDK(this.f21755a).getPreferenceCenterData();
            if (preferenceCenterData == null) {
                OTLogger.a("WebviewConsentHelper", 5, "Consent for WebView: No app data found, returning empty JSON.");
            } else {
                JSONArray jSONArray = preferenceCenterData.getJSONArray("Groups");
                Context context = this.f21755a;
                boolean z13 = false;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0);
                Boolean bool = Boolean.FALSE;
                String str = "";
                if (com.onetrust.otpublishers.headless.Internal.b.a(sharedPreferences2.getString("OT_ENABLE_MULTI_PROFILE", bool.toString()))) {
                    hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z11 = true;
                } else {
                    z11 = false;
                    hVar = null;
                }
                if (z11) {
                    sharedPreferences = hVar;
                }
                jSONObject.put("groups", a(sharedPreferences.getString("OTT_CONSENT_STATUS", ""), jSONArray).replace("{", "").replace("}", "").replace("\"", ""));
                jSONObject.put("USPrivacy", defaultSharedPreferences.getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, ""));
                Context context2 = this.f21755a;
                SharedPreferences sharedPreferences3 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context2, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", bool.toString()))) {
                    hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences3, sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z12 = true;
                } else {
                    z12 = false;
                    hVar2 = null;
                }
                new com.onetrust.otpublishers.headless.gpp.c(context2);
                if (z12) {
                    sharedPreferences3 = hVar2;
                }
                jSONObject.put("gppString", sharedPreferences3.getBoolean("OT_GPP_IS_ENABLED", false) ? defaultSharedPreferences.getString(OTGppKeys.IAB_GPP_HDR_GPP_STRING, "") : "");
                if (z10) {
                    Context context3 = this.f21755a;
                    SharedPreferences sharedPreferences4 = context3.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context3, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", bool.toString()))) {
                        hVar3 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context3, sharedPreferences4, sharedPreferences4.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z13 = true;
                    } else {
                        hVar3 = null;
                    }
                    if (z13) {
                        sharedPreferences4 = hVar3;
                    }
                    long jLongValue = Long.valueOf(sharedPreferences4.getString("OTT_LAST_GIVEN_CONSENT", "0")).longValue();
                    TimeZone timeZone = TimeZone.getTimeZone("GMT");
                    SimpleDateFormat simpleDateFormatW = com.onetrust.otpublishers.headless.Internal.c.w("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    simpleDateFormatW.setTimeZone(timeZone);
                    Date date = new Date();
                    date.setTime(jLongValue);
                    jSONObject.put("consentedDate", simpleDateFormatW.format(date));
                    jSONObject.put("addtlString", defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, ""));
                    SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(this.f21755a);
                    String string = defaultSharedPreferences2.getString(OTGppKeys.IAB_GPP_TCFEU2_STRING, "");
                    if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                        string = defaultSharedPreferences2.getString("IABTCF_TCString", "");
                    }
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                        str = string;
                    }
                } else {
                    jSONObject.put("consentedDate", "");
                    jSONObject.put("addtlString", "");
                }
                jSONObject.put("tcString", str);
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error on constructing webviewConsentObject. Error msg = "), "WebviewConsentHelper", 6);
        }
        String str2 = "var OTExternalConsent = " + jSONObject.toString();
        d.a("ConsentForWebView :", str2, "WebviewConsentHelper", 3);
        return str2;
    }

    @VisibleForTesting
    public final void c(@NonNull JSONObject jSONObject) throws JSONException {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        Context context = this.f21755a;
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
        String string = sharedPreferences.getString("OTT_ALWAYS_ACTIVE_GROUPS", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return;
        }
        JSONArray jSONArrayNames = new JSONObject(string).names();
        if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayNames)) {
            return;
        }
        for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
            String string2 = jSONArrayNames.getString(i10);
            if (!string2.startsWith("ISPV2") && !string2.startsWith("ISP2V2") && !string2.startsWith("IFEV2") && !string2.startsWith("IFE2V2")) {
                jSONObject.put(string2, 1);
            }
        }
    }
}
