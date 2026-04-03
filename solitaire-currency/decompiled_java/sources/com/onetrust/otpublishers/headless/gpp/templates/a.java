package com.onetrust.otpublishers.headless.gpp.templates;

import android.content.Context;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f23802a;

    public a(@NonNull Context context) {
        this.f23802a = context;
    }

    public final void a() {
        try {
            com.onetrust.otpublishers.headless.gpp.e eVar = new com.onetrust.otpublishers.headless.gpp.e(this.f23802a);
            boolean z10 = true;
            if (!(!eVar.e("CPRA")) && eVar.e("CCPA")) {
                z10 = false;
            }
            if (z10) {
                String strB = b();
                OTLogger.a("OneTrust", 4, "Gpp - California/CPRA String : " + strB);
                if (com.onetrust.otpublishers.headless.Internal.c.q(strB)) {
                    return;
                }
                new com.onetrust.otpublishers.headless.Internal.Preferences.a(this.f23802a).c(OTGppKeys.IAB_GPP_CALIFORNIA_STRING, strB);
            }
        } catch (Exception e10) {
            OTLogger.a("OneTrust", 6, "compute California/CPRA String failed:" + e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x022a  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.gpp.templates.a.b():java.lang.String");
    }
}
