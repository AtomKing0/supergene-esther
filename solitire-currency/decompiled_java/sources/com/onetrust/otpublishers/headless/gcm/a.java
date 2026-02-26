package com.onetrust.otpublishers.headless.gcm;

import android.content.Context;
import android.content.SharedPreferences;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.e;
import com.onetrust.otpublishers.headless.Internal.Preferences.g;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.Internal.c;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.gcm.consent.OTGCMConsentStatus;
import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static OTGCMConsentStatus a(Context context, JSONObject jSONObject, String str, String str2) throws JSONException {
        boolean zHas;
        int i10;
        if (!jSONObject.has(str)) {
            return OTGCMConsentStatus.UNDEFINED;
        }
        if (!q.s(jSONObject.getString(str), "DNAC", true)) {
            String string = jSONObject.getString(str);
            if (!(string == null || string.length() == 0)) {
                String string2 = jSONObject.getString(str);
                if (c.q(str2)) {
                    zHas = false;
                } else {
                    Locale locale = Locale.ENGLISH;
                    zHas = new JSONObject(str2.toLowerCase(locale)).has(string2.toLowerCase(locale));
                }
                if (!zHas) {
                    return OTGCMConsentStatus.UNDEFINED;
                }
                JSONObject jSONObject2 = new JSONObject();
                new JSONObject();
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (l.a(context)) {
                    new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                }
                g gVar = new g(context);
                new JSONObject();
                new e(context);
                new g(context);
                try {
                    i10 = jSONObject2.has(string2) ? jSONObject2.getInt(string2) : gVar.a(string2);
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error while getting updated value of Purpose Consent "), "CustomGroupDetails", 6);
                    i10 = -1;
                }
                return i10 == 1 ? OTGCMConsentStatus.GRANTED : OTGCMConsentStatus.DENIED;
            }
        }
        return OTGCMConsentStatus.UNASSIGNED;
    }

    public static void b(@NotNull Context context, @NotNull JSONObject mobileData) {
        h hVar;
        t.i(context, "context");
        t.i(mobileData, "mobileData");
        if (!com.onetrust.otpublishers.headless.Internal.a.d(mobileData) && mobileData.has("gcmData")) {
            boolean z10 = false;
            boolean zOptBoolean = mobileData.getJSONObject("gcmData").getJSONObject(OTVendorListMode.GENERAL).optBoolean("isEnabled", false);
            OTLogger.a("OTGCM", 3, "Saving Google consent mode enabled: " + zOptBoolean);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0), "OT_ENABLE_MULTI_PROFILE")) {
                hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            sharedPreferences.edit().putBoolean("OTGCMEnabled", zOptBoolean).apply();
        }
    }
}
