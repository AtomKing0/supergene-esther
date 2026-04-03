package com.onetrust.otpublishers.headless.Internal.Log;

import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void a() {
        OTLogger.e("***********************************", "DEVICE LOGS -***********************************");
        OTLogger.e("MODEL", Build.MODEL);
        OTLogger.e("Manufacture", Build.MANUFACTURER);
        OTLogger.e("SDK", Build.VERSION.SDK);
        OTLogger.e("BRAND", Build.BRAND);
        OTLogger.e("Version Code", Build.VERSION.RELEASE);
        OTLogger.e("***********************************", "SDK LOGS -***********************************");
    }
}
