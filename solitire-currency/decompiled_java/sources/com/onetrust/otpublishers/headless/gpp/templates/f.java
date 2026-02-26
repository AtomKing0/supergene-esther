package com.onetrust.otpublishers.headless.gpp.templates;

import android.content.Context;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f23807a;

    public f(@NonNull Context context) {
        this.f23807a = context;
    }

    @NonNull
    public static StringBuilder a(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull com.onetrust.otpublishers.headless.gpp.e eVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (jSONObject.optBoolean("sensitiveDataProcessApplicable")) {
            iA = eVar.a(jSONObject2.optString("race"));
            iA3 = eVar.a(jSONObject2.optString("religion"));
            iA4 = eVar.a(jSONObject2.optString("health"));
            iA5 = eVar.a(jSONObject2.optString("sexualOrientation"));
            iA6 = eVar.a(jSONObject2.optString("immigration"));
            iA7 = eVar.a(jSONObject2.optString("genetic"));
            iA8 = eVar.a(jSONObject2.optString("biometric"));
            iA2 = eVar.a(jSONObject2.optString("geolocation"));
        } else {
            iA = 0;
            iA2 = 0;
            iA3 = 0;
            iA4 = 0;
            iA5 = 0;
            iA6 = 0;
            iA7 = 0;
            iA8 = 0;
        }
        HashMap map = new HashMap();
        map.put("sdp1", Integer.valueOf(iA));
        map.put("sdp2", Integer.valueOf(iA3));
        map.put("sdp3", Integer.valueOf(iA4));
        map.put("sdp4", Integer.valueOf(iA5));
        map.put("sdp5", Integer.valueOf(iA6));
        map.put("sdp6", Integer.valueOf(iA7));
        map.put("sdp7", Integer.valueOf(iA8));
        map.put("sdp8", Integer.valueOf(iA2));
        return com.onetrust.otpublishers.headless.gpp.e.c(map, new String[]{"sdp1", "sdp2", "sdp3", "sdp4", "sdp5", "sdp6", "sdp7", "sdp8"});
    }

    public final void b() {
        try {
            if (new com.onetrust.otpublishers.headless.gpp.e(this.f23807a).e("CDPA")) {
                return;
            }
            String strC = c();
            OTLogger.a("OneTrust", 4, "Gpp - CDPA (Virginia) String : " + strC);
            if (com.onetrust.otpublishers.headless.Internal.c.q(strC)) {
                return;
            }
            new com.onetrust.otpublishers.headless.Internal.Preferences.a(this.f23807a).c(OTGppKeys.IAB_GPP_USVA_STRING, strC);
        } catch (Exception e10) {
            OTLogger.a("OneTrust", 6, "computeVirginiaString failed:" + e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.gpp.templates.f.c():java.lang.String");
    }
}
