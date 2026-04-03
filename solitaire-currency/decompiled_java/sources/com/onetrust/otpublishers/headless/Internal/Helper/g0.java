package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.OTCCPAGeolocationConstants;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f21764c;

    public g0(@NonNull Context context) {
        this.f21762a = context;
        this.f21764c = PreferenceManager.getDefaultSharedPreferences(context);
        this.f21763b = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
    }

    public static boolean c(@NonNull OTGeolocationModel oTGeolocationModel, @NonNull String str) {
        String str2 = oTGeolocationModel.country;
        String str3 = oTGeolocationModel.state;
        OTLogger.a("IABCCPA_Consent", 3, "bannerLoaded country = " + str2 + " state = " + str3);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            OTLogger.a("IABCCPA_Consent", 4, "Initialized location for CCPA = " + str);
            if ((OTCCPAGeolocationConstants.CA.equalsIgnoreCase(str) && (!"US".equalsIgnoreCase(str2) || !"CA".equalsIgnoreCase(str3))) || (OTCCPAGeolocationConstants.US.equalsIgnoreCase(str) && !"US".equalsIgnoreCase(str2))) {
                return false;
            }
        }
        return true;
    }

    public final void a() {
        if (this.f21764c.contains(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING)) {
            this.f21764c.edit().remove(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING).apply();
            OTLogger.a("IABCCPA_Consent", 4, "CCPA String deleted");
        }
    }

    public final void b(@NonNull JSONObject jSONObject) {
        OTGeolocationModel oTGeolocationModel;
        String str;
        boolean zHas;
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        String strOptString = jSONObject.optString("parentCCPACategory", "");
        String strOptString2 = jSONObject.optString("ccpaGeo", "");
        boolean zOptBoolean = jSONObject.optBoolean("ccpaLspa", false);
        boolean zOptBoolean2 = jSONObject.optBoolean("ccpaExpNotice", false);
        boolean zOptBoolean3 = jSONObject.optBoolean("computeCCPA", false);
        this.f21763b.c().edit().putBoolean("OT_COMPUTE_CCPA_REGION", zOptBoolean3).apply();
        if (!zOptBoolean3) {
            f();
            String string = this.f21763b.c().getString("OT_DATA_DOWNLOADED_GEO_LOCATION", "");
            if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                str = "Compute CCPA disabled for this template from OneTrust UI";
            } else {
                Context context = this.f21762a;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (l.a(context)) {
                    new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                }
                if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                    oTGeolocationModel = null;
                } else {
                    oTGeolocationModel = new OTGeolocationModel();
                    try {
                        JSONObject jSONObject2 = new JSONObject(string);
                        oTGeolocationModel.country = jSONObject2.optString(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY);
                        oTGeolocationModel.state = jSONObject2.optString("state");
                    } catch (JSONException e10) {
                        p.a(e10, new StringBuilder("error in formatting ott data with err = "), "GLDataHandler", 6);
                    }
                }
                if (!"all".equalsIgnoreCase(strOptString2) && (com.onetrust.otpublishers.headless.Internal.c.q(strOptString2) || oTGeolocationModel == null || !oTGeolocationModel.compareLocation(strOptString2))) {
                    str = "CCPA string not updated for location " + strOptString2 + " as user's location " + string + " is out of ccpa configured region";
                }
            }
            OTLogger.a("OneTrust", 5, str);
        } else if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
            String string2 = this.f21763b.c().getString("OT_UI_VALID_GROUP_IDS", "");
            if (com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                zHas = false;
            } else {
                Locale locale = Locale.ENGLISH;
                zHas = new JSONObject(string2.toLowerCase(locale)).has(strOptString.toLowerCase(locale));
            }
            if (zHas) {
                Context context2 = this.f21762a;
                SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (h.a(Boolean.FALSE, context2.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0), "OT_ENABLE_MULTI_PROFILE")) {
                    hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z10 = true;
                } else {
                    z10 = false;
                    hVar = null;
                }
                new com.onetrust.otpublishers.headless.gpp.c(context2);
                if (z10) {
                    sharedPreferences2 = hVar;
                }
                String str2 = sharedPreferences2.getBoolean("OT_GPP_IS_ENABLED", false) ? OTGppKeys.IAB_GPP_USP1_STRING : OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING;
                if (!this.f21764c.contains(str2)) {
                    this.f21764c.edit().putString(str2, "1---").apply();
                    OTLogger.a("IABCCPA_Consent", 4, "CCPA initialized? = " + this.f21764c.contains(str2));
                }
                SharedPreferences.Editor editorEdit = this.f21763b.c().edit();
                editorEdit.putString("OT_CCPA_CATEGORY_ID", strOptString);
                editorEdit.putString("OTT_CCPA_GEOLOCATIONS", strOptString2);
                editorEdit.putBoolean("OTT_EXPLICIT_NOTICE", zOptBoolean2);
                editorEdit.putBoolean("OTT_AGREEMENT_TERMS_APPLIES", zOptBoolean);
                editorEdit.apply();
                d(new com.onetrust.otpublishers.headless.Internal.Preferences.g(this.f21762a).a(strOptString) == 1, false);
            } else {
                OTLogger.a("OneTrust", 5, "Invalid CCPA configuration. Please assign SDKs to the CCPA category or its subgroups.");
            }
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(e())) {
            return;
        }
        new JSONArray();
        String strE = e();
        try {
            JSONObject jSONObject3 = new JSONObject(this.f21763b.c().getString("OTT_PARENT_GROUPS", ""));
            if (jSONObject3.has(strE)) {
                this.f21763b.c().edit().putString("OTT_CCPA_CUSTOM_GROUP_IDS", jSONObject3.getJSONArray(strE).toString()).apply();
            }
        } catch (JSONException e11) {
            p.a(e11, new StringBuilder("Error when CCPA subgroups are fetched, err : "), "IABCCPA_Consent", 6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x031a A[Catch: JSONException -> 0x036c, TryCatch #2 {JSONException -> 0x036c, blocks: (B:101:0x0276, B:102:0x0281, B:104:0x0287, B:106:0x02c1, B:108:0x02ce, B:111:0x02d9, B:113:0x02e1, B:115:0x02e7, B:127:0x031a, B:129:0x032e, B:133:0x0350, B:132:0x0345, B:122:0x0302, B:124:0x0313, B:134:0x0356), top: B:162:0x0276 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0345 A[Catch: JSONException -> 0x036c, TryCatch #2 {JSONException -> 0x036c, blocks: (B:101:0x0276, B:102:0x0281, B:104:0x0287, B:106:0x02c1, B:108:0x02ce, B:111:0x02d9, B:113:0x02e1, B:115:0x02e7, B:127:0x031a, B:129:0x032e, B:133:0x0350, B:132:0x0345, B:122:0x0302, B:124:0x0313, B:134:0x0356), top: B:162:0x0276 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0247  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(boolean r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 969
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.g0.d(boolean, boolean):boolean");
    }

    @NonNull
    public final String e() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f21762a;
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
        return sharedPreferences.getString("OT_CCPA_CATEGORY_ID", "");
    }

    public final void f() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        Context context = this.f21762a;
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
        if (!sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false)) {
            this.f21764c.edit().remove(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING).apply();
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f21762a);
        if (defaultSharedPreferences.contains(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING)) {
            defaultSharedPreferences.edit().remove(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING).apply();
        }
    }
}
