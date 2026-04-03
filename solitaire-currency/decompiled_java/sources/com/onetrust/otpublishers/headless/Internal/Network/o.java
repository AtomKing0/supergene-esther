package com.onetrust.otpublishers.headless.Internal.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class o {
    public static boolean a(@NonNull Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z10 = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        OTLogger.a("NWUtils", 4, "isConnected = " + z10);
        return z10;
    }
}
