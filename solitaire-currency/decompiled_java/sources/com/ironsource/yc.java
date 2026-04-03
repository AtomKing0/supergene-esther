package com.ironsource;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.v8;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import io.sentry.protocol.Request;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class yc implements Runnable {
    public static final String M = "sdkVersion";
    public static final String N = "AdvIdOptOutReason";
    private static final int O = 15;
    private static final int P = 840;
    private static final int Q = -720;
    private Context K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16273a = getClass().getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16274b = "bundleId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16275c = "advertisingId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16276d = v8.i.M;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f16277e = "appKey";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16278f = "deviceOS";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f16279g = "osVersion";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f16280h = v8.i.f15868t;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f16281i = v8.i.f15869u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f16282j = "language";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f16283k = v8.i.f15851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f16284l = v8.i.f15853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f16285m = v8.i.f15865r;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f16286n = "externalFreeMemory";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f16287o = "internalFreeMemory";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f16288p = "battery";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f16289q = "gmtMinutesOffset";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f16290r = v8.i.W;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f16291s = JsonStorageKeyNames.SESSION_ID_KEY;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f16292t = "pluginType";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f16293u = "pluginVersion";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f16294v = "plugin_fw_v";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f16295w = "jb";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f16296x = "advertisingIdType";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final String f16297y = ad.I0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final String f16298z = "firstSession";
    private final String A = "mcc";
    private final String B = "mnc";
    private final String C = "icc";
    private final String D = "tz";
    private final String E = "auid";
    private final String F = "userLat";
    private final String G = "publisherAPI";
    private final String H = "missingDependencies";
    private final String I = "missingManifest";
    private final String J = Request.JsonKeys.OTHER;
    private final ce L = el.N().f();

    private yc() {
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "missingDependencies" : !ja.f12717a.b() ? "publisherAPI" : !this.L.u(this.K) ? "missingManifest" : Boolean.parseBoolean(str) ? "userLat" : Request.JsonKeys.OTHER;
    }

    private String b() {
        try {
            String str = Build.VERSION.RELEASE;
            return "" + Build.VERSION.SDK_INT + "(" + str + ")";
        } catch (Exception e10) {
            i9.d().a(e10);
            return "";
        }
    }

    private String c() {
        return com.ironsource.mediationsdk.p.m().n();
    }

    private int d() {
        try {
            Intent intentRegisterReceiver = this.K.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : 0;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra == -1 || intExtra2 == -1) {
                return -1;
            }
            return (int) ((intExtra / intExtra2) * 100.0f);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f16273a + ":getBatteryLevel()", e10);
            return -1;
        }
    }

    private String e() {
        try {
            return this.K.getPackageName();
        } catch (Exception e10) {
            i9.d().a(e10);
            return "";
        }
    }

    private String f() {
        try {
            return Build.MODEL;
        } catch (Exception e10) {
            i9.d().a(e10);
            return "";
        }
    }

    private String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception e10) {
            i9.d().a(e10);
            return "";
        }
    }

    private String h() {
        return v8.f15653d;
    }

    private long i() {
        if (!s()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1048576;
    }

    private int j() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round(((timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15) * 15;
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f16273a + ":getGmtMinutesOffset()", e10);
            return 0;
        }
    }

    private long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1048576;
        } catch (Exception e10) {
            i9.d().a(e10);
            return -1L;
        }
    }

    private String l() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e10) {
            i9.d().a(e10);
            return "";
        }
    }

    private String m() {
        return com.ironsource.mediationsdk.p.m().q();
    }

    private String n() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.K.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager == null) {
                return "";
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            return !networkOperatorName.equals("") ? networkOperatorName : "";
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f16273a + ":getMobileCarrier()", e10);
            return "";
        }
    }

    private String o() {
        try {
            return ConfigFile.getConfigFile().getPluginFrameworkVersion();
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e10);
            return "";
        }
    }

    private String p() {
        try {
            return ConfigFile.getConfigFile().getPluginType();
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e10);
            return "";
        }
    }

    private String q() {
        try {
            return ConfigFile.getConfigFile().getPluginVersion();
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e10);
            return "";
        }
    }

    private String r() {
        return IronSourceUtils.getSDKVersion();
    }

    private boolean s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e10) {
            i9.d().a(e10);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            xc.a().a(a());
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "Thread name = " + getClass().getSimpleName(), e10);
        }
    }

    public yc(Context context) {
        this.K = context.getApplicationContext();
    }

    private Map<String, Object> a() {
        boolean z10;
        String str;
        HashMap map = new HashMap();
        map.put(JsonStorageKeyNames.SESSION_ID_KEY, IronSourceUtils.getSessionId());
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            map.put("bundleId", strE);
            String strB = v3.b(this.K, strE);
            if (!TextUtils.isEmpty(strB)) {
                map.put(v8.i.W, strB);
            }
        }
        map.put("appKey", c());
        String strP = this.L.p(this.K);
        String strA = this.L.a(this.K);
        boolean z11 = false;
        if (TextUtils.isEmpty(strP)) {
            strP = this.L.J(this.K);
            z10 = true;
            str = !TextUtils.isEmpty(strP) ? IronSourceConstants.TYPE_UUID : "";
        } else {
            str = IronSourceConstants.TYPE_GAID;
            z10 = false;
        }
        if (!TextUtils.isEmpty(strP)) {
            map.put("advertisingId", strP);
            map.put("advertisingIdType", str);
        }
        if (!TextUtils.isEmpty(strA)) {
            z11 = Boolean.parseBoolean(strA);
            map.put(v8.i.M, Boolean.valueOf(z11));
        }
        if (z10 || z11) {
            map.put(N, a(strA));
        }
        map.put("deviceOS", h());
        if (!TextUtils.isEmpty(b())) {
            map.put("osVersion", b());
        }
        String connectionType = IronSourceUtils.getConnectionType(this.K);
        if (!TextUtils.isEmpty(connectionType)) {
            map.put(v8.i.f15868t, connectionType);
        }
        String strD = s8.d(this.K);
        if (!TextUtils.isEmpty(strD)) {
            map.put(v8.i.f15869u, strD);
        }
        map.put("sdkVersion", r());
        String strL = l();
        if (!TextUtils.isEmpty(strL)) {
            map.put("language", strL);
        }
        String strG = g();
        if (!TextUtils.isEmpty(strG)) {
            map.put(v8.i.f15851k, strG);
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF)) {
            map.put(v8.i.f15853l, strF);
        }
        String strN = n();
        if (!TextUtils.isEmpty(strN)) {
            map.put(v8.i.f15865r, strN);
        }
        map.put("internalFreeMemory", Long.valueOf(k()));
        map.put("externalFreeMemory", Long.valueOf(i()));
        map.put("battery", Integer.valueOf(d()));
        int iJ = j();
        if (a(iJ)) {
            map.put("gmtMinutesOffset", Integer.valueOf(iJ));
        }
        String strP2 = p();
        if (!TextUtils.isEmpty(strP2)) {
            map.put("pluginType", strP2);
        }
        String strQ = q();
        if (!TextUtils.isEmpty(strQ)) {
            map.put("pluginVersion", strQ);
        }
        String strO = o();
        if (!TextUtils.isEmpty(strO)) {
            map.put("plugin_fw_v", strO);
        }
        String strValueOf = String.valueOf(this.L.f());
        if (!TextUtils.isEmpty(strValueOf)) {
            map.put("jb", strValueOf);
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            map.put(ad.I0, strM);
        }
        String strValueOf2 = String.valueOf(IronSourceUtils.getFirstSession(this.K));
        if (!TextUtils.isEmpty(strValueOf2)) {
            map.put("firstSession", strValueOf2);
        }
        String strS = this.L.s(this.K);
        if (!TextUtils.isEmpty(strS)) {
            map.put("auid", strS);
        }
        map.put("mcc", Integer.valueOf(r8.b(this.K)));
        map.put("mnc", Integer.valueOf(r8.c(this.K)));
        String strN2 = this.L.n(this.K);
        if (!TextUtils.isEmpty(strN2)) {
            map.put("icc", strN2);
        }
        String strB2 = this.L.b();
        if (!TextUtils.isEmpty(strB2)) {
            map.put("tz", strB2);
        }
        IronLog.INTERNAL.verbose("collecting data for events: " + map);
        return map;
    }

    private boolean a(int i10) {
        return i10 <= P && i10 >= Q && i10 % 15 == 0;
    }
}
