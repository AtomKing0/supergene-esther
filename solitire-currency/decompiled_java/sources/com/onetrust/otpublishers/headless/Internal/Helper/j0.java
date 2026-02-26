package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import io.sentry.protocol.ViewHierarchyNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.g f21770b;

    public j0(@NonNull Context context) {
        com.onetrust.otpublishers.headless.Internal.Preferences.e eVar = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        this.f21769a = eVar;
        this.f21770b = new com.onetrust.otpublishers.headless.Internal.Preferences.g(eVar);
    }

    public final void a() {
        try {
            if (com.onetrust.otpublishers.headless.Internal.c.q(this.f21769a.c().getString("OTT_CONSENT_LOG_DATA", ""))) {
                return;
            }
            OTLogger.a("consentLoggingDH", 4, "setting DSID to Consent payload");
            JSONObject jSONObject = new JSONObject(this.f21769a.c().getString("OTT_CONSENT_LOG_DATA", ""));
            String string = this.f21770b.f21893a.c().getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
            if (string == null) {
                string = "";
            }
            jSONObject.getJSONObject("consentPayload").put(ViewHierarchyNode.JsonKeys.IDENTIFIER, string);
            this.f21769a.c().edit().putString("OTT_CONSENT_LOG_DATA", jSONObject.toString()).apply();
            if (this.f21769a.c().getString("OT_CL_DEFAULT_PAYLOAD", "").isEmpty()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(this.f21769a.c().getString("OT_CL_DEFAULT_PAYLOAD", ""));
            jSONObject2.getJSONObject("consentPayload").put(ViewHierarchyNode.JsonKeys.IDENTIFIER, string);
            this.f21769a.c().edit().putString("OT_CL_DEFAULT_PAYLOAD", jSONObject2.toString()).apply();
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("error while setting DSID to consent payload"), "consentLoggingDH", 6);
        }
    }

    public final void b(@NonNull Context context, @NonNull String str) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        OTLogger.a("consentLoggingDH", 4, "override data subject identifier : " + str);
        JSONObject jSONObject = new JSONObject();
        String string = this.f21770b.f21893a.c().getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
        if (string == null) {
            string = "";
        }
        if (string.equals(str)) {
            return;
        }
        this.f21770b.s(str);
        a();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.f21769a.c().getString("OTT_CONSENT_LOG_DATA", ""))) {
            jSONObject = new JSONObject(this.f21769a.c().getString("OTT_CONSENT_LOG_DATA", ""));
        }
        if (jSONObject.length() > 0) {
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
            if (sharedPreferences.getInt("OTT_USER_CONSENT_STATUS", -1) == 1) {
                OTLogger.a("consentLoggingDH", 4, "Consent logging with overridden data subject identifier");
                if (jSONObject.getJSONObject("consentPayload").getJSONArray("purposes").length() > 0) {
                    new com.onetrust.otpublishers.headless.Internal.Network.n(context).f(1, jSONObject.getString("consentApi"), jSONObject.getJSONObject("consentPayload").toString());
                }
            }
        }
    }

    public final void c(@NonNull com.onetrust.otpublishers.headless.Internal.Models.a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put(ViewHierarchyNode.JsonKeys.IDENTIFIER, aVar.f21828b.f21831c);
        jSONObject.put("purposes", aVar.f21828b.f21830b);
        jSONObject.put("requestInformation", aVar.f21828b.f21829a);
        jSONObject2.put("consentApi", aVar.f21827a);
        jSONObject2.put("consentPayload", jSONObject);
        OTLogger.a("consent data", 3, "data" + jSONObject2);
        this.f21769a.c().edit().putString("OTT_CONSENT_LOG_DATA", jSONObject2.toString()).apply();
        f.a(jSONObject2, this.f21769a.c().edit(), "OT_CL_DEFAULT_PAYLOAD");
        if (this.f21769a.c().getString("OT_CL_DEFAULT_PAYLOAD", "").isEmpty()) {
            return;
        }
        String string = this.f21769a.c().getString("OT_CL_DEFAULT_PAYLOAD", "");
        String string2 = this.f21769a.c().getString("OT_CL_DEFAULT_TRANSACTION_VALUES", "");
        JSONObject jSONObject3 = new JSONObject(string);
        jSONObject3.getJSONObject("consentPayload").put("purposes", new JSONArray(string2));
        OTLogger.a("consentLoggingDH", 3, "default payload " + jSONObject3);
        f.a(jSONObject3, this.f21769a.c().edit(), "OT_CL_DEFAULT_PAYLOAD");
    }

    public final void d(@NonNull JSONObject jSONObject) {
        f.a(jSONObject, this.f21769a.c().edit(), "OTT_CONSENT_LOG_DATA");
    }
}
