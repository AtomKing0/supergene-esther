package com.ironsource;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.v8;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class s8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14795a = "NETWORK_TYPE_WIFI";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14796b = "NETWORK_TYPE_UNKNOWN";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14797c = "NETWORK_TYPE_GPRS";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f14798d = "NETWORK_TYPE_EDGE";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f14799e = "NETWORK_TYPE_UMTS";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f14800f = "NETWORK_TYPE_CDMA";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f14801g = "NETWORK_TYPE_EVDO_0";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f14802h = "NETWORK_TYPE_EVDO_A";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f14803i = "NETWORK_TYPE_1xRTT";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f14804j = "NETWORK_TYPE_HSDPA";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f14805k = "NETWORK_TYPE_HSUPA";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f14806l = "NETWORK_TYPE_HSPA";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f14807m = "NETWORK_TYPE_IDEN";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f14808n = "NETWORK_TYPE_EVDO_B";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f14809o = "NETWORK_TYPE_LTE";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f14810p = "NETWORK_TYPE_EHRPD";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f14811q = "NETWORK_TYPE_HSPAP";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f14812r = "NETWORK_TYPE_GSM";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f14813s = "NETWORK_TYPE_TD_SCDMA";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f14814t = "NETWORK_TYPE_IWLAN";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f14815u = "NETWORK_TYPE_LTE_CA";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f14816v = "NETWORK_TYPE_NR";

    @SuppressLint({"MissingPermission"})
    public static Network a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetwork();
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return null;
        }
    }

    public static String b(Context context) {
        return a(a(context), context);
    }

    private static String c(Context context) {
        String strA = r8.a(context);
        return TextUtils.isEmpty(strA) ? "none" : strA;
    }

    public static String d(Context context) {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return f14796b;
        }
        if (networkCapabilities.hasTransport(1)) {
            return f14795a;
        }
        if (networkCapabilities.hasTransport(0) && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            return a(activeNetworkInfo.getSubtype());
        }
        return f14796b;
    }

    public static boolean e(Context context) {
        return b(context, a(context)).equals("vpn");
    }

    private static String a(int i10) {
        switch (i10) {
            case 1:
                return f14797c;
            case 2:
                return f14798d;
            case 3:
                return f14799e;
            case 4:
                return f14800f;
            case 5:
                return f14801g;
            case 6:
                return f14802h;
            case 7:
                return f14803i;
            case 8:
                return f14804j;
            case 9:
                return f14805k;
            case 10:
                return f14806l;
            case 11:
                return f14807m;
            case 12:
                return f14808n;
            case 13:
                return f14809o;
            case 14:
                return f14810p;
            case 15:
                return f14811q;
            case 16:
                return f14812r;
            case 17:
                return f14813s;
            case 18:
                return f14814t;
            case 19:
                return f14815u;
            case 20:
                return f14816v;
            default:
                return f14796b;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static String b(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (network != null && context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null) {
                    return "";
                }
                if (networkCapabilities.hasTransport(1)) {
                    return r8.f14655b;
                }
                if (networkCapabilities.hasTransport(0)) {
                    return r8.f14660g;
                }
                if (networkCapabilities.hasTransport(4)) {
                    return "vpn";
                }
                if (networkCapabilities.hasTransport(3)) {
                    return r8.f14658e;
                }
                if (networkCapabilities.hasTransport(5)) {
                    return r8.f14661h;
                }
                if (networkCapabilities.hasTransport(6)) {
                    return r8.f14662i;
                }
                if (networkCapabilities.hasTransport(2)) {
                    return r8.f14657d;
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }
        return "";
    }

    @SuppressLint({"MissingPermission"})
    public static String a(Network network, Context context) {
        if (context == null) {
            return "none";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (network == null || connectivityManager == null) {
            return "none";
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return c(context);
            }
            return networkCapabilities.hasTransport(1) ? r8.f14655b : networkCapabilities.hasTransport(0) ? r8.f14654a : c(context);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return "none";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static JSONObject a(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (network != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) != null) {
                    jSONObject.put("networkCapabilities", networkCapabilities.toString());
                    jSONObject.put("downloadSpeed", networkCapabilities.getLinkDownstreamBandwidthKbps());
                    jSONObject.put("uploadSpeed", networkCapabilities.getLinkUpstreamBandwidthKbps());
                    jSONObject.put(v8.i.f15870v, e(context));
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }
        return jSONObject;
    }
}
