package com.onetrust.otpublishers.headless.gpp;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Helper.x;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer f23788d = 10;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f23789e = 30;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f23790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f23791b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.a f23792c;

    public c(@NonNull Context context) {
        this.f23792c = new com.onetrust.otpublishers.headless.Internal.Preferences.a(context);
        this.f23790a = context;
        d();
    }

    public final void a() {
        if (this.f23791b.isEmpty()) {
            d();
        }
        if (this.f23791b.keySet().isEmpty()) {
            return;
        }
        for (String str : this.f23791b.keySet()) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str) && str.startsWith("IABGPP_TCFEU2_")) {
                this.f23792c.a(str);
            }
        }
    }

    public final void b(@NonNull String str, @NonNull String str2, String str3) {
        OTLogger.a("GppDataStorage", 3, "Saving Gpp data to default Shared Preferences");
        OTLogger.a("OneTrust", 3, "Gpp string: " + str);
        this.f23792c.c(OTGppKeys.IAB_GPP_HDR_GPP_STRING, str);
        OTLogger.a("GppDataStorage", 3, "Gpp version: 1");
        this.f23792c.b(OTGppKeys.IAB_GPP_HDR_VERSION, 1);
        OTLogger.a("GppDataStorage", 3, "Gpp Section Ids: " + str2);
        this.f23792c.c(OTGppKeys.IAB_GPP_HDR_SECTIONS, str2);
        OTLogger.a("GppDataStorage", 3, "Gpp current region section id: " + str3);
        this.f23792c.c(OTGppKeys.IAB_GPP_GPP_SID, str3);
    }

    public final void c(@NonNull JSONObject jSONObject) {
        h hVar;
        try {
            f(jSONObject);
            Context context = this.f23790a;
            boolean z10 = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            sharedPreferences.edit().putString("OT_GPP_DATA_BACKUP", jSONObject.toString()).apply();
        } catch (JSONException e10) {
            x.a("GppDataStoragebackupAndClearDataFromGppKeys failed:", e10, "OneTrust", 6);
        }
    }

    public final void d() {
        HashMap map;
        String str;
        HashMap map2 = this.f23791b;
        Integer num = f23789e;
        map2.put(OTGppKeys.IAB_GPP_HDR_GPP_STRING, num);
        HashMap map3 = this.f23791b;
        Integer num2 = f23788d;
        map3.put(OTGppKeys.IAB_GPP_HDR_VERSION, num2);
        this.f23791b.put(OTGppKeys.IAB_GPP_HDR_SECTIONS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_GPP_SID, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_TCFEU2_STRING, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_USP1_STRING, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_US_NAT_STRING, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_CALIFORNIA_STRING, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_USVA_STRING, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_USCO_STRING, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_USCT_STRING, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_USUT_STRING, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_CMPSDKID, num2);
        this.f23791b.put(OTGppKeys.IAB_GPP_CMPSDKVERSION, num2);
        this.f23791b.put(OTGppKeys.IAB_GPP_POLICYVERSION, num2);
        this.f23791b.put(OTGppKeys.IAB_GPP_GDPRAPPLIES, num2);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHERCC, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PURPOSEONETREATMENT, num2);
        if (new com.onetrust.otpublishers.headless.Internal.Preferences.g(this.f23790a).t()) {
            map = this.f23791b;
            str = OTGppKeys.IAB_GPP_USENONSTANDARDTEXTS;
        } else {
            map = this.f23791b;
            str = OTGppKeys.IAB_GPP_USENONSTANDARDSTACKS;
        }
        map.put(str, num2);
        this.f23791b.put(OTGppKeys.IAB_GPP_VENDORCONSENTS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_VENDORLEGITIMATEINTERESTS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PURPOSECONSENTS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PURPOSELEGITIMATEINTERESTS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_SPECIALFEATURESOPTINS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHERRESTRICTIONS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHERCONSENT, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHERLEGITIMATEINTERESTS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHERCUSTOMPURPOSESCONSENTS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_1, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_2, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_3, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_4, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_5, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_6, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_7, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_8, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_9, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_10, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_11, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_USP1_VERSION, num2);
        this.f23791b.put(OTGppKeys.IAB_GPP_USP1_NOTICE, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_USP1_OPT_OUT, num);
        this.f23791b.put(OTGppKeys.IAB_GPP_USP1_LSPA_COVERED, num);
    }

    public final void e(JSONObject jSONObject) throws JSONException {
        for (String str : this.f23791b.keySet()) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                Integer num = (Integer) this.f23791b.get(str);
                if (f23788d.equals(num) && this.f23792c.f21885a.contains(str)) {
                    jSONObject.put(str, this.f23792c.d(str));
                }
                if (f23789e.equals(num) && this.f23792c.f21885a.contains(str)) {
                    jSONObject.put(str, this.f23792c.e(str));
                }
            }
        }
    }

    public final void f(JSONObject jSONObject) throws JSONException {
        for (String str : this.f23791b.keySet()) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                Integer num = (Integer) this.f23791b.get(str);
                if (f23788d.equals(num) && this.f23792c.f21885a.contains(str)) {
                    jSONObject.put(str, this.f23792c.d(str));
                }
                if (f23789e.equals(num) && this.f23792c.f21885a.contains(str)) {
                    jSONObject.put(str, this.f23792c.e(str));
                }
                this.f23792c.a(str);
            }
        }
    }

    public final void g(@NonNull JSONObject jSONObject) {
        for (String str : this.f23791b.keySet()) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                Integer num = (Integer) this.f23791b.get(str);
                if (jSONObject.has(str) && f23788d.equals(num)) {
                    this.f23792c.b(str, jSONObject.optInt(str));
                }
                if (jSONObject.has(str) && f23789e.equals(num)) {
                    this.f23792c.c(str, jSONObject.optString(str));
                }
            }
        }
    }
}
