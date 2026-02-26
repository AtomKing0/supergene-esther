package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21781a;

    public n0(@NonNull Context context) {
        this.f21781a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[ORIG_RETURN, RETURN] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel a(int r5) {
        /*
            r4 = this;
            r0 = 1
            java.lang.String r1 = ""
            if (r5 != r0) goto L12
            com.onetrust.otpublishers.headless.Internal.Preferences.e r5 = r4.f21781a
            android.content.SharedPreferences r5 = r5.c()
            java.lang.String r0 = "OTT_USER_CONSENT_LOCATION"
        Ld:
            java.lang.String r1 = r5.getString(r0, r1)
            goto L2a
        L12:
            r0 = 2
            if (r5 != r0) goto L1e
            com.onetrust.otpublishers.headless.Internal.Preferences.e r5 = r4.f21781a
            android.content.SharedPreferences r5 = r5.c()
            java.lang.String r0 = "OT_DATA_DOWNLOADED_GEO_LOCATION"
            goto Ld
        L1e:
            r0 = 3
            if (r5 != r0) goto L2a
            com.onetrust.otpublishers.headless.Internal.Preferences.e r5 = r4.f21781a
            android.content.SharedPreferences r5 = r5.c()
            java.lang.String r0 = "OT_CONSENTED_LOCATION"
            goto Ld
        L2a:
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r1)
            if (r5 != 0) goto L5a
            com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel r5 = new com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel
            r5.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4b
            r0.<init>(r1)     // Catch: org.json.JSONException -> L4b
            java.lang.String r1 = "country"
            java.lang.String r1 = r0.optString(r1)     // Catch: org.json.JSONException -> L4b
            r5.country = r1     // Catch: org.json.JSONException -> L4b
            java.lang.String r1 = "state"
            java.lang.String r0 = r0.optString(r1)     // Catch: org.json.JSONException -> L4b
            r5.state = r0     // Catch: org.json.JSONException -> L4b
            goto L5b
        L4b:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error in formatting ott data with err = "
            r1.<init>(r2)
            java.lang.String r2 = "GLDataHandler"
            r3 = 6
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(r0, r1, r2, r3)
            goto L5b
        L5a:
            r5 = 0
        L5b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.n0.a(int):com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel");
    }

    @Nullable
    public final OTGeolocationModel b(@NonNull String str, int i10, @NonNull String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY, str);
        jSONObject.put("state", str2);
        if (i10 == 1) {
            f.a(jSONObject, this.f21781a.c().edit(), "OTT_USER_CONSENT_LOCATION");
        } else if (i10 == 2) {
            f.a(jSONObject, this.f21781a.c().edit(), "OT_DATA_DOWNLOADED_GEO_LOCATION");
        } else if (i10 == 3) {
            f.a(jSONObject, this.f21781a.c().edit(), "OT_CONSENTED_LOCATION");
        }
        String string = jSONObject.toString();
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return null;
        }
        OTGeolocationModel oTGeolocationModel = new OTGeolocationModel();
        try {
            JSONObject jSONObject2 = new JSONObject(string);
            oTGeolocationModel.country = jSONObject2.optString(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY);
            oTGeolocationModel.state = jSONObject2.optString("state");
            return oTGeolocationModel;
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error in formatting ott data with err = "), "GLDataHandler", 6);
            return oTGeolocationModel;
        }
    }

    public final boolean c() throws JSONException {
        OTGeolocationModel oTGeolocationModelA = a(2);
        if (oTGeolocationModelA == null) {
            return false;
        }
        b(oTGeolocationModelA.country, 3, oTGeolocationModelA.state);
        OTLogger.a("GLDataHandler", 4, "Consent given location saved as country:" + oTGeolocationModelA.country + " state:" + oTGeolocationModelA.state);
        return true;
    }
}
