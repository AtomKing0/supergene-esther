package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f21768b;

    public i0(@NonNull Context context) {
        this.f21767a = context;
        this.f21768b = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context).c();
    }

    public final void a(@NonNull JSONObject jSONObject, boolean z10) {
        String string = this.f21768b.getString("OTT_CONSENT_LOG_DATA", "");
        String string2 = this.f21768b.getString("OT_CL_DEFAULT_PAYLOAD", "");
        String str = "consentLogging not initialized.";
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            if (!z10 || !new OTPublishersHeadlessSDK(this.f21767a).shouldShowBanner()) {
                try {
                    JSONObject jSONObject2 = new JSONObject(string);
                    if (b(jSONObject2, jSONObject, z10)) {
                        new j0(this.f21767a).d(jSONObject2);
                        String string3 = jSONObject2.getString("consentApi");
                        String string4 = jSONObject2.getJSONObject("consentPayload").toString();
                        OTLogger.a("ConsentLogging", 4, "payloadObj" + string4);
                        OTLogger.a("ConsentLogging", 4, "consent obj" + jSONObject2);
                        new com.onetrust.otpublishers.headless.Internal.Network.n(this.f21767a).f(1, string3, string4);
                        return;
                    }
                    return;
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("error in reading old consent data. error - "), "ConsentLogging", 6);
                    return;
                }
            }
            try {
                if (com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                    OTLogger.a("ConsentLogging", 5, "consentLogging not initialized.");
                } else {
                    JSONObject jSONObject3 = new JSONObject(string2);
                    OTLogger.a("ConsentLogging", 4, "payloadObj default" + jSONObject3.getJSONObject("consentPayload"));
                    OTLogger.a("ConsentLogging", 4, "consent obj default" + jSONObject3);
                    new com.onetrust.otpublishers.headless.Internal.Network.n(this.f21767a).f(1, jSONObject3.getString("consentApi"), jSONObject3.getJSONObject("consentPayload").toString());
                }
                return;
            } catch (JSONException e11) {
                str = "Error while logging consent for default values." + e11.getMessage();
            }
        }
        OTLogger.a("ConsentLogging", 5, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(@androidx.annotation.NonNull org.json.JSONObject r20, @androidx.annotation.NonNull org.json.JSONObject r21, boolean r22) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.i0.b(org.json.JSONObject, org.json.JSONObject, boolean):boolean");
    }
}
