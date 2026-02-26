package com.braze.support;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import bo.app.yl;
import bo.app.z40;
import bo.app.zl;
import com.braze.support.BrazeLogger;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8114a = new c();

    public static final z40 a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return z40.NONE;
        }
        int iMin = Math.min(networkCapabilities.getLinkDownstreamBandwidthKbps(), networkCapabilities.getLinkUpstreamBandwidthKbps());
        return iMin > 14000 ? z40.GREAT : iMin > 4000 ? z40.GOOD : z40.BAD;
    }

    public static final z40 a(Intent intent, ConnectivityManager connectivityManager) {
        t.i(intent, "intent");
        t.i(connectivityManager, "connectivityManager");
        String action = intent.getAction();
        if (t.d("android.net.conn.CONNECTIVITY_CHANGE", action)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                if (activeNetworkInfo != null && !booleanExtra) {
                    int type = activeNetworkInfo.getType();
                    if (type != 0) {
                        if (type == 1 || type == 6) {
                            return z40.GREAT;
                        }
                        if (type != 9) {
                            return z40.NONE;
                        }
                        return z40.GOOD;
                    }
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype == 3) {
                        return z40.GOOD;
                    }
                    if (subtype != 13 && subtype != 20) {
                        return z40.BAD;
                    }
                    return z40.GREAT;
                }
                return z40.NONE;
            } catch (SecurityException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f8114a, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) zl.f4451a, 4, (Object) null);
                return z40.NONE;
            }
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f8114a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new yl(action), 6, (Object) null);
        return z40.NONE;
    }
}
