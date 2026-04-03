package com.moloco.sdk.internal.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import androidx.autofill.HintConstants;
import com.moloco.sdk.internal.services.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final h0 f18676b;

    public g(@NotNull Context context, @NotNull h0 deviceInfoService) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(deviceInfoService, "deviceInfoService");
        this.f18675a = context;
        this.f18676b = deviceInfoService;
    }

    @Override // com.moloco.sdk.internal.services.e
    public boolean a() {
        Object systemService = this.f18675a.getSystemService("connectivity");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            return d(connectivityManager);
        }
        return false;
    }

    @Override // com.moloco.sdk.internal.services.e
    @Nullable
    public Integer b() {
        Object systemService = this.f18675a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() == 0) {
            return null;
        }
        kotlin.jvm.internal.t.h(networkOperator, "networkOperator");
        String strSubstring = networkOperator.substring(3);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        return Integer.valueOf(Integer.parseInt(strSubstring));
    }

    @Override // com.moloco.sdk.internal.services.e
    @NotNull
    public b c() {
        Object systemService = this.f18675a.getSystemService("connectivity");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return b((ConnectivityManager) systemService);
    }

    @Override // com.moloco.sdk.internal.services.e
    @Nullable
    public Integer d() {
        Object systemService = this.f18675a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() == 0) {
            return null;
        }
        kotlin.jvm.internal.t.h(networkOperator, "networkOperator");
        String strSubstring = networkOperator.substring(0, 3);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return Integer.valueOf(Integer.parseInt(strSubstring));
    }

    @Override // com.moloco.sdk.internal.services.e
    @NotNull
    public b invoke() {
        return c();
    }

    @RequiresApi(23)
    public final b b(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        if (connectivityManager.getActiveNetwork() != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
            return networkCapabilities.hasTransport(1) ? b.c.f18414a : networkCapabilities.hasTransport(0) ? new b.a(this.f18676b.invoke().g()) : b.C0326b.f18413a;
        }
        return b.C0326b.f18413a;
    }

    @RequiresApi(24)
    public final boolean d(ConnectivityManager connectivityManager) {
        return connectivityManager.getRestrictBackgroundStatus() == 3;
    }
}
