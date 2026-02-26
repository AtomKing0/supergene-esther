package com.onetrust.otpublishers.headless.gpp.templates;

import android.content.Context;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f23806a;

    public e(@NonNull Context context) {
        this.f23806a = context;
    }

    public final void a() {
        try {
            if (new com.onetrust.otpublishers.headless.gpp.e(this.f23806a).e("UCPA")) {
                return;
            }
            String strB = b();
            OTLogger.a("OneTrust", 4, "Gpp - UCPA (Utah) String : " + strB);
            if (com.onetrust.otpublishers.headless.Internal.c.q(strB)) {
                return;
            }
            new com.onetrust.otpublishers.headless.Internal.Preferences.a(this.f23806a).c(OTGppKeys.IAB_GPP_USUT_STRING, strB);
        } catch (Exception e10) {
            OTLogger.a("OneTrust", 6, "computeUtahString failed:" + e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.gpp.templates.e.b():java.lang.String");
    }
}
