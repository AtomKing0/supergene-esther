package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import com.applovin.impl.c5;
import com.applovin.impl.e4;
import com.applovin.impl.f6;
import com.applovin.impl.i4;
import com.applovin.impl.k0;
import com.applovin.impl.l2;
import com.applovin.impl.l4;
import com.applovin.impl.m0;
import com.applovin.impl.n4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t;
import com.applovin.impl.v1;
import com.applovin.impl.w1;
import com.applovin.impl.w4;
import com.applovin.impl.w6;
import com.applovin.impl.y6;
import com.applovin.impl.z6;
import com.applovin.impl.z7;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.ad;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import io.sentry.protocol.App;
import io.sentry.protocol.Device;
import io.sentry.protocol.Geo;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f7141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f7142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final AtomicReference f7143l = new AtomicReference();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final AtomicReference f7144m = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f7146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f7148d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f7150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f7152h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f7149e = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicReference f7153i = new AtomicReference();

    class a implements c5.a {
        a() {
        }

        @Override // com.applovin.impl.c5.a
        public void a(t.a aVar) {
            k.f7143l.set(aVar);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7156b;

        public b(String str, int i10) {
            this.f7155a = str;
            this.f7156b = i10;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7157a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7158b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f7159c = null;
    }

    protected k(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f7145a = jVar;
        this.f7146b = jVar.I();
        this.f7147c = j.n();
        this.f7148d = A();
        this.f7150f = z();
    }

    private Map A() {
        HashMap map = new HashMap(35);
        map.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put(Device.JsonKeys.BRAND, Build.MANUFACTURER);
        map.put("brand_name", Build.BRAND);
        map.put("hardware", Build.HARDWARE);
        map.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        map.put("aida", Boolean.valueOf(com.applovin.impl.t.a()));
        map.put(Device.JsonKeys.LOCALE, Locale.getDefault().toString());
        map.put("model", Build.MODEL);
        map.put("os", Build.VERSION.RELEASE);
        map.put("platform", x());
        map.put("revision", Build.DEVICE);
        map.put("tz_offset", Double.valueOf(B()));
        map.put("gy", Boolean.valueOf(r()));
        map.put(Geo.JsonKeys.COUNTRY_CODE, k());
        map.put("mcc", v());
        map.put("mnc", w());
        map.put(ad.f11277y0, i());
        map.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.f7147c)));
        map.put("pc", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        map.put("hdr", P());
        map.put("supported_abis", L());
        DisplayMetrics displayMetrics = this.f7147c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map.put("adns", Float.valueOf(displayMetrics.density));
            map.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            map.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            map.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            k0.a aVarA = com.applovin.impl.k0.a(this.f7147c, this.f7145a);
            if (aVarA != null) {
                map.put("tl_cr", Integer.valueOf(aVarA.c()));
                map.put("tr_cr", Integer.valueOf(aVarA.d()));
                map.put("bl_cr", Integer.valueOf(aVarA.a()));
                map.put("br_cr", Integer.valueOf(aVarA.b()));
            }
        }
        map.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        map.put("tbalsi_ms", Long.valueOf(this.f7145a.H() - j.m()));
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(e4.e(this.f7147c)), map);
        CollectionUtils.putStringIfValid("process_name", z6.b(this.f7147c), map);
        CollectionUtils.putBooleanIfValid("is_main_process", z6.g(this.f7147c), map);
        try {
            PackageInfo packageInfo = this.f7147c.getPackageManager().getPackageInfo("com.android.vending", 0);
            map.put("ps_version", packageInfo.versionName);
            map.put("ps_version_code", Integer.valueOf(packageInfo.versionCode));
        } catch (Throwable unused) {
            map.put("ps_version", "");
            map.put("ps_version_code", -1);
        }
        CollectionUtils.putBooleanIfValid("play_store_disabled", w6.a(this.f7147c), map);
        a(map);
        return map;
    }

    private double B() {
        return Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d) / 10.0d;
    }

    public static String F() {
        return f7142k;
    }

    private Map I() {
        return z6.a(a((Map) null, true, false));
    }

    private JSONArray L() {
        if (com.applovin.impl.k0.d()) {
            return CollectionUtils.toJSONArray(Build.SUPPORTED_ABIS);
        }
        JSONArray jSONArray = new JSONArray();
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI);
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI2);
        return jSONArray;
    }

    private boolean M() {
        try {
            if (!b()) {
                if (!c()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean N() {
        ConnectivityManager connectivityManager;
        if (com.applovin.impl.k0.f() && (connectivityManager = (ConnectivityManager) this.f7147c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.f7145a.I();
                if (n.a()) {
                    this.f7145a.I().a("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    private boolean O() {
        boolean z10 = this.f7147c.getResources().getConfiguration().keyboard == 2;
        PackageManager packageManager = this.f7147c.getPackageManager();
        return z10 && (packageManager.hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE") || packageManager.hasSystemFeature("android.hardware.type.pc"));
    }

    private Boolean P() {
        if (com.applovin.impl.k0.g()) {
            return Boolean.valueOf(this.f7147c.getResources().getConfiguration().isScreenHdr());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        this.f7153i.set(p());
    }

    private boolean c() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i10 = 0; i10 < 9; i10++) {
            if (new File(c(strArr[i10])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long d() {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.k.d():long");
    }

    private String g() {
        int orientation = AppLovinSdkUtils.getOrientation(this.f7147c);
        return orientation == 1 ? v8.h.D : orientation == 2 ? v8.h.C : "none";
    }

    private c h() {
        c cVar = new c();
        Intent intentRegisterReceiver = this.f7147c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.f7158b = -1;
        } else {
            cVar.f7158b = (int) ((intExtra / intExtra2) * 100.0f);
        }
        cVar.f7157a = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        cVar.f7159c = Boolean.valueOf(Settings.Global.getInt(this.f7147c.getContentResolver(), "stay_on_while_plugged_in", -1) > 0);
        return cVar;
    }

    private String i() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f7147c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!n.a()) {
                return "";
            }
            this.f7146b.a("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private String k() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f7147c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String l() {
        ActivityInfo activityInfo;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://"));
        ResolveInfo resolveInfoResolveActivity = this.f7147c.getPackageManager().resolveActivity(intent, 65536);
        if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
            f7142k = activityInfo.packageName;
        }
        return f7142k;
    }

    private String m() {
        Point pointB = com.applovin.impl.k0.b(this.f7147c);
        int i10 = pointB.x;
        int i11 = pointB.y;
        int iC = z6.c(this.f7147c);
        return ((i10 <= i11 || !(iC == 0 || iC == 2)) && (i11 <= i10 || !(iC == 1 || iC == 3))) ? b(iC) : a(iC);
    }

    private String o() {
        if (!com.applovin.impl.k0.f()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.f7147c.getResources().getConfiguration().getLocales();
            for (int i10 = 0; i10 < locales.size(); i10++) {
                sb.append(locales.get(i10));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private Integer p() {
        if (((AudioManager) this.f7147c.getSystemService("audio")) == null) {
            return null;
        }
        try {
            return Integer.valueOf((int) (r0.getStreamVolume(3) * ((Float) this.f7145a.a(l4.K3)).floatValue()));
        } catch (Throwable th) {
            this.f7145a.I();
            if (n.a()) {
                this.f7145a.I().a("DataCollector", "Unable to collect device volume", th);
            }
            return null;
        }
    }

    private float q() {
        try {
            return Settings.System.getFloat(this.f7147c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e10) {
            if (!n.a()) {
                return -1.0f;
            }
            this.f7146b.a("DataCollector", "Error collecting font scale", e10);
            return -1.0f;
        }
    }

    private boolean r() {
        SensorManager sensorManager = (SensorManager) this.f7147c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private Map s() {
        HashMap map = new HashMap();
        CollectionUtils.putIntegerIfValid(OTIABTCFKeys.IABTCF_GDPRAPPLIES, this.f7145a.k0().g(), map);
        CollectionUtils.putStringIfValid("IABTCF_TCString", this.f7145a.k0().k(), map);
        CollectionUtils.putStringIfValid(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, this.f7145a.k0().c(), map);
        return map;
    }

    private Boolean t() {
        AudioManager audioManager = (AudioManager) this.f7147c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isMusicActive());
    }

    private Boolean u() {
        AudioManager audioManager = (AudioManager) this.f7147c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isSpeakerphoneOn());
    }

    private String v() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f7147c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!n.a()) {
                return "";
            }
            this.f7146b.a("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String w() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f7147c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!n.a()) {
                return "";
            }
            this.f7146b.a("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    private String y() {
        AudioManager audioManager = (AudioManager) this.f7147c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (com.applovin.impl.k0.e()) {
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                sb.append(audioDeviceInfo.getType());
                sb.append(",");
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append(3);
                sb.append(",");
            }
            if (audioManager.isBluetoothScoOn()) {
                sb.append(7);
                sb.append(",");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append(8);
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string) && n.a()) {
            this.f7146b.a("DataCollector", "No sound outputs detected");
        }
        return string;
    }

    private Map z() {
        PackageInfo packageInfo;
        HashMap map = new HashMap();
        PackageManager packageManager = this.f7147c.getPackageManager();
        ApplicationInfo applicationInfo = this.f7147c.getApplicationInfo();
        long jLastModified = new File(applicationInfo.sourceDir).lastModified();
        try {
            packageInfo = packageManager.getPackageInfo(this.f7147c.getPackageName(), 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        String strA = a(applicationInfo.packageName, packageManager, this.f7145a);
        map.put(App.JsonKeys.APP_NAME, packageManager.getApplicationLabel(applicationInfo));
        map.put(App.JsonKeys.APP_VERSION, packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        if (strA == null) {
            strA = "";
        }
        map.put("installer_name", strA);
        map.put("tg", y6.a(this.f7145a));
        map.put("debug", Boolean.valueOf(z6.c(this.f7145a)));
        map.put("ia", Long.valueOf(jLastModified));
        map.put("alts_ms", Long.valueOf(j.m()));
        map.put("j8", Boolean.valueOf(j.y0()));
        map.put("ps_tpg", Boolean.valueOf(e4.d(this.f7147c)));
        map.put("ps_apg", Boolean.valueOf(e4.b(this.f7147c)));
        map.put("ps_capg", Boolean.valueOf(e4.c(this.f7147c)));
        map.put("ps_aipg", Boolean.valueOf(e4.a(this.f7147c)));
        j jVar = this.f7145a;
        n4 n4Var = n4.f6384f;
        Long l10 = (Long) jVar.a(n4Var);
        if (l10 != null) {
            map.put("ia_v2", l10);
        } else {
            this.f7145a.b(n4Var, Long.valueOf(jLastModified));
        }
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("omid_sdk_version", this.f7145a.W().c());
        CollectionUtils.putStringIfValid("ad_review_sdk_version", com.applovin.impl.h.b(), map);
        map.put("api_did", this.f7145a.a(l4.f5630f));
        map.put("first_install_v3_ms", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : "");
        map.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        if (com.applovin.impl.k0.f()) {
            map.put("min_sdk", Integer.valueOf(applicationInfo.minSdkVersion));
        }
        if (this.f7145a.A0()) {
            map.put("unity_version", z6.a(this.f7145a.g0()));
        }
        return map;
    }

    public Map C() {
        Map map = CollectionUtils.map(this.f7150f);
        String str = StringUtils.isValidString(f7141j) ? f7141j : this.f7147c.getApplicationInfo().packageName;
        map.put(v8.h.V, str);
        map.put("vz", StringUtils.toShortSHA1Hash(str));
        map.put("first_install", Boolean.valueOf(this.f7145a.v0()));
        map.put("first_install_v2", Boolean.valueOf(!this.f7145a.s0()));
        map.put("test_ads", Boolean.valueOf(this.f7151g));
        map.put("test_mode", Integer.valueOf(this.f7145a.l0().c() ? 1 : 0));
        map.put("muted", Boolean.valueOf(this.f7145a.g0().isMuted()));
        if (((Boolean) this.f7145a.a(l4.f5690m3)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.f7145a.p0().c(), map);
        }
        if (((Boolean) this.f7145a.a(l4.f5714p3)).booleanValue()) {
            map.put("compass_random_token", this.f7145a.s());
        }
        if (((Boolean) this.f7145a.a(l4.f5730r3)).booleanValue()) {
            map.put("applovin_random_token", this.f7145a.a0());
        }
        map.putAll(s());
        if (this.f7145a.Z() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.f7145a.Z().a(), map);
        }
        CollectionUtils.putStringIfValid("template_browser_package_name", (String) this.f7145a.i0().a(n4.L, null), map);
        return map;
    }

    public b D() {
        return (b) f7144m.get();
    }

    protected String E() {
        String strEncodeToString = Base64.encodeToString(new JSONObject(I()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.f7145a.a(l4.H4)).booleanValue() ? i4.b(strEncodeToString, z6.a(this.f7145a), i4.a.a(((Integer) this.f7145a.a(l4.I4)).intValue()), this.f7145a.b0(), this.f7145a) : strEncodeToString;
    }

    public Long G() {
        return this.f7152h;
    }

    public String H() {
        ActivityManager activityManager = (ActivityManager) this.f7147c.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        return activityManager.getDeviceConfigurationInfo().getGlEsVersion();
    }

    public Map J() {
        return CollectionUtils.map(this.f7150f);
    }

    public Map K() {
        return CollectionUtils.map(this.f7148d);
    }

    public boolean Q() {
        return this.f7151g;
    }

    public void S() {
        r5 r5VarJ0 = this.f7145a.j0();
        c5 c5Var = new c5(this.f7145a, new a());
        r5.b bVar = r5.b.OTHER;
        r5VarJ0.a((w4) c5Var, bVar);
        this.f7145a.j0().a((w4) new f6(this.f7145a, true, "setDeviceVolume", new Runnable() { // from class: com.applovin.impl.sdk.x0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7378a.R();
            }
        }), bVar);
    }

    public void T() {
        synchronized (this.f7149e) {
            a(this.f7148d);
        }
    }

    public Map e() {
        HashMap map = new HashMap();
        map.put("sc", this.f7145a.a(l4.f5678l));
        map.put("sc2", this.f7145a.a(l4.f5686m));
        map.put("sc3", this.f7145a.a(l4.f5694n));
        map.put("server_installed_at", this.f7145a.a(l4.f5702o));
        CollectionUtils.putStringIfValid("persisted_data", (String) this.f7145a.a(n4.D), map);
        return map;
    }

    public t.a f() {
        t.a aVarB = com.applovin.impl.t.b(this.f7147c);
        if (aVarB == null) {
            return new t.a();
        }
        if (((Boolean) this.f7145a.a(l4.f5674k3)).booleanValue()) {
            if (aVarB.c() && !((Boolean) this.f7145a.a(l4.f5666j3)).booleanValue()) {
                aVarB.a("");
            }
            f7143l.set(aVarB);
        } else {
            aVarB = new t.a();
        }
        List<String> testDeviceAdvertisingIds = this.f7145a.G() != null ? this.f7145a.G().getTestDeviceAdvertisingIds() : null;
        if (testDeviceAdvertisingIds != null) {
            String strA = aVarB.a();
            if (StringUtils.isValidString(strA)) {
                this.f7151g = testDeviceAdvertisingIds.contains(strA);
            }
            b bVarD = D();
            String str = bVarD != null ? bVarD.f7155a : null;
            if (StringUtils.isValidString(str)) {
                this.f7151g = testDeviceAdvertisingIds.contains(str) | this.f7151g;
            }
        } else {
            this.f7151g = false;
        }
        return aVarB;
    }

    public Map j() {
        HashMap map = new HashMap();
        CollectionUtils.putLongIfValid("network_throughput_kbps", G(), map);
        m0.d dVarA = this.f7145a.u().a();
        if (dVarA != null) {
            map.put("lrm_ts_ms", String.valueOf(dVarA.c()));
            map.put("lrm_url", dVarA.d());
            map.put("lrm_ct_ms", String.valueOf(dVarA.a()));
            map.put("lrm_rs", String.valueOf(dVarA.b()));
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public Map n() {
        return a(false);
    }

    public String x() {
        return AppLovinSdkUtils.isFireOS(this.f7147c) ? "fireos" : "android";
    }

    private String a(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "unknown" : v8.h.D : "landscape_left" : "portrait_upside_down" : "landscape_right";
    }

    private String b(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "unknown" : "landscape_left" : "portrait_upside_down" : "landscape_right" : v8.h.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        try {
            String strE = E();
            if (StringUtils.isValidString(strE)) {
                this.f7145a.I();
                if (n.a()) {
                    this.f7145a.I().a("DataCollector", "Successfully retrieved bid token");
                }
                l2.a(appLovinBidTokenCollectionListener, strE);
                return;
            }
            this.f7145a.I();
            if (n.a()) {
                this.f7145a.I().b("DataCollector", "Empty bid token");
            }
            l2.b(appLovinBidTokenCollectionListener, "Empty bid token");
        } catch (Throwable th) {
            if (n.a()) {
                this.f7146b.a("DataCollector", "Failed to collect bid token", th);
            }
            this.f7145a.A().a("DataCollector", "collectBidToken", th);
            l2.b(appLovinBidTokenCollectionListener, "Failed to collect bid token");
        }
    }

    public void a(Long l10) {
        this.f7152h = l10;
    }

    private String c(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = str.charAt(i10);
            for (int i11 = 9; i11 >= 0; i11--) {
                cArr[i10] = (char) (cArr[i10] ^ iArr[i11]);
            }
        }
        return new String(cArr);
    }

    protected void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        this.f7145a.j0().a((w4) new f6(this.f7145a, ((Boolean) this.f7145a.a(l4.f5775x3)).booleanValue(), "DataCollector", new Runnable() { // from class: com.applovin.impl.sdk.y0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7383a.b(appLovinBidTokenCollectionListener);
            }
        }), r5.b.CORE);
    }

    public Map a(Map map, boolean z10, boolean z11) {
        HashMap map2 = new HashMap(64);
        Map mapA = a(z10);
        Map mapC = C();
        Map mapJ = j();
        Map mapD0 = this.f7145a.d0();
        if (z11) {
            map2.put("device_info", mapA);
            map2.put("app_info", mapC);
            if (mapJ != null) {
                map2.put("connection_info", mapJ);
            }
            if (map != null) {
                map2.put("ad_info", map);
            }
            if (!CollectionUtils.isEmpty(mapD0)) {
                map2.put("segments", mapD0);
            }
        } else {
            map2.putAll(mapA);
            map2.putAll(mapC);
            if (mapJ != null) {
                map2.putAll(mapJ);
            }
            if (map != null) {
                map2.putAll(map);
            }
            if (!CollectionUtils.isEmpty(mapD0)) {
                map2.putAll(mapD0);
            }
        }
        map2.put("accept", "custom_size,launch_app,video");
        map2.put("format", "json");
        CollectionUtils.putStringIfValid("mediation_provider", this.f7145a.O(), map2);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.f7145a.z(), map2);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.f7145a.a(l4.f5761v3), map2);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.f7145a.m0()), map2);
        if (!((Boolean) this.f7145a.a(l4.F4)).booleanValue()) {
            map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f7145a.b0());
        }
        map2.putAll(e());
        if (((Boolean) this.f7145a.a(l4.f5643g4)).booleanValue()) {
            w1 w1VarE = this.f7145a.E();
            map2.put("li", Long.valueOf(w1VarE.b(v1.f7555e)));
            map2.put("si", Long.valueOf(w1VarE.b(v1.f7558h)));
            map2.put("mad", Long.valueOf(w1VarE.b(v1.f7556f)));
            map2.put("msad", Long.valueOf(w1VarE.b(v1.f7559i)));
            map2.put("pf", Long.valueOf(w1VarE.b(v1.f7563m)));
            map2.put("mpf", Long.valueOf(w1VarE.b(v1.f7570t)));
            map2.put("gpf", Long.valueOf(w1VarE.b(v1.f7564n)));
            map2.put("asoac", Long.valueOf(w1VarE.b(v1.f7568r)));
        }
        map2.put("rid", UUID.randomUUID().toString());
        return map2;
    }

    private int b(String str) {
        try {
            return Settings.Secure.getInt(this.f7147c.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains(c("lz}$blpz"));
    }

    public Map a(boolean z10) {
        Map map;
        synchronized (this.f7149e) {
            map = CollectionUtils.map(this.f7148d);
        }
        return a(map, z10);
    }

    private void a(Map map) {
        if (((Boolean) this.f7145a.a(l4.E3)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(d()));
        }
        if (((Boolean) this.f7145a.a(l4.F3)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(q()));
        }
        if (((Boolean) this.f7145a.a(l4.M3)).booleanValue() && z6.d(this.f7145a)) {
            z7.a(this.f7145a);
        }
        if (((Boolean) this.f7145a.a(l4.X3)).booleanValue()) {
            z7.b(this.f7145a);
        }
        if (((Boolean) this.f7145a.a(l4.L3)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f7145a.a(l4.H3)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(N()));
        }
        map.put("is_pc", Boolean.valueOf(O()));
        if (((Boolean) this.f7145a.a(l4.Z3)).booleanValue()) {
            CollectionUtils.putStringIfValid("oglv", H(), map);
        }
        if (((Boolean) this.f7145a.a(l4.Y5)).booleanValue()) {
            CollectionUtils.putStringIfValid("dbpn", l(), map);
        }
    }

    private Map a(Map map, boolean z10) {
        t.a aVarF;
        PowerManager powerManager;
        Map map2 = CollectionUtils.map(map);
        Point pointB = com.applovin.impl.k0.b(this.f7147c);
        map2.put("dx", Integer.valueOf(pointB.x));
        map2.put("dy", Integer.valueOf(pointB.y));
        DisplayMetrics displayMetrics = this.f7147c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map2.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow(pointB.x, 2.0d) + Math.pow(pointB.y, 2.0d)) / ((double) displayMetrics.xdpi)));
        }
        map2.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.f7147c)));
        if (z10) {
            aVarF = (t.a) f7143l.get();
            if (aVarF != null) {
                S();
            } else if (z6.h()) {
                aVarF = new t.a();
                map2.put("inc", Boolean.TRUE);
            } else {
                aVarF = f();
            }
        } else {
            aVarF = f();
        }
        String strA = aVarF.a();
        if (StringUtils.isValidString(strA)) {
            map2.put("idfa", strA);
        }
        map2.put("dnt", Boolean.valueOf(aVarF.c()));
        map2.put("dnt_code", aVarF.b().b());
        b bVar = (b) f7144m.get();
        if (((Boolean) this.f7145a.a(l4.f5682l3)).booleanValue() && bVar != null) {
            map2.put("idfv", bVar.f7155a);
            map2.put("idfv_scope", Integer.valueOf(bVar.f7156b));
        }
        Boolean boolB = com.applovin.impl.l0.b().b(this.f7147c);
        if (boolB != null) {
            map2.put("huc", boolB);
        }
        Boolean boolB2 = com.applovin.impl.l0.c().b(this.f7147c);
        if (boolB2 != null) {
            map2.put("aru", boolB2);
        }
        Boolean boolB3 = com.applovin.impl.l0.a().b(this.f7147c);
        if (boolB3 != null) {
            map2.put("dns", boolB3);
        }
        if (((Boolean) this.f7145a.a(l4.f5782y3)).booleanValue()) {
            c cVarH = h();
            CollectionUtils.putIntegerIfValid("act", Integer.valueOf(cVarH.f7157a), map2);
            CollectionUtils.putIntegerIfValid("acm", Integer.valueOf(cVarH.f7158b), map2);
            CollectionUtils.putBooleanIfValid("sowpie", cVarH.f7159c, map2);
        }
        if (((Boolean) this.f7145a.a(l4.G3)).booleanValue()) {
            map2.put("mtl", Integer.valueOf(this.f7145a.f0().getLastTrimMemoryLevel()));
        }
        if (((Boolean) this.f7145a.a(l4.J3)).booleanValue()) {
            map2.put("adr", Boolean.valueOf(M()));
        }
        Integer numP = z10 ? (Integer) this.f7153i.get() : p();
        if (numP != null) {
            map2.put("volume", numP);
        }
        CollectionUtils.putBooleanIfValid("ma", t(), map2);
        CollectionUtils.putBooleanIfValid("spo", u(), map2);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(!this.f7145a.f0().isApplicationPaused()), map2);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.f7145a.f0().getAppEnteredForegroundTimeMillis()), map2);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.f7145a.f0().getAppEnteredBackgroundTimeMillis()), map2);
        try {
            map2.put("sb", Integer.valueOf((int) ((Settings.System.getInt(this.f7147c.getContentResolver(), "screen_brightness") / 255.0f) * 100.0f)));
        } catch (Settings.SettingNotFoundException e10) {
            if (n.a()) {
                this.f7146b.a("DataCollector", "Unable to collect screen brightness", e10);
            }
        }
        if (((Boolean) this.f7145a.a(l4.M3)).booleanValue() && z6.d(this.f7145a)) {
            z7.a(this.f7145a);
            String strA2 = z7.a();
            if (StringUtils.isValidString(strA2)) {
                map2.put(ad.U, strA2);
            }
        }
        if (((Boolean) this.f7145a.a(l4.X3)).booleanValue()) {
            z7.b(this.f7145a);
            CollectionUtils.putIntegerIfValid("wvvc", Integer.valueOf(z7.d()), map2);
            CollectionUtils.putStringIfValid("wvv", z7.c(), map2);
            CollectionUtils.putStringIfValid("wvpn", z7.b(), map2);
        }
        if (((Boolean) this.f7145a.a(l4.A3)).booleanValue()) {
            try {
                map2.put(ad.C0, Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                map2.put("tds", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            } catch (Throwable th) {
                map2.put(ad.C0, -1);
                map2.put("tds", -1);
                if (n.a()) {
                    this.f7146b.a("DataCollector", "Unable to collect total & free space.", th);
                }
            }
        }
        if (((Boolean) this.f7145a.a(l4.B3)).booleanValue()) {
            ActivityManager.MemoryInfo memoryInfoA = z6.a((ActivityManager) this.f7147c.getSystemService("activity"));
            if (memoryInfoA != null) {
                map2.put("fm", Long.valueOf(memoryInfoA.availMem));
                map2.put("tm", Long.valueOf(memoryInfoA.totalMem));
                map2.put("lmt", Long.valueOf(memoryInfoA.threshold));
                map2.put("lm", Boolean.valueOf(memoryInfoA.lowMemory));
            } else {
                map2.put("fm", -1);
                map2.put("tm", -1);
                map2.put("lmt", -1);
            }
        }
        if (((Boolean) this.f7145a.a(l4.C3)).booleanValue() && com.applovin.impl.k0.a("android.permission.READ_PHONE_STATE", this.f7147c) && com.applovin.impl.k0.f()) {
            map2.put("rat", Integer.valueOf(((TelephonyManager) this.f7147c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getDataNetworkType()));
        }
        if (((Boolean) this.f7145a.a(l4.f5789z3)).booleanValue()) {
            String strY = y();
            if (!TextUtils.isEmpty(strY)) {
                map2.put("so", strY);
            }
        }
        map2.put("device_orientation", m());
        map2.put("orientation_lock", g());
        if (((Boolean) this.f7145a.a(l4.D3)).booleanValue()) {
            map2.put("vs", Boolean.valueOf(z6.j()));
        }
        if (com.applovin.impl.k0.d() && (powerManager = (PowerManager) this.f7147c.getSystemService("power")) != null) {
            map2.put(ad.H0, Integer.valueOf(powerManager.isPowerSaveMode() ? 1 : 0));
        }
        if (((Boolean) this.f7145a.a(l4.O3)).booleanValue() && this.f7145a.e0() != null) {
            map2.put("da", Float.valueOf(this.f7145a.e0().a()));
        }
        if (((Boolean) this.f7145a.a(l4.P3)).booleanValue() && this.f7145a.e0() != null) {
            map2.put("dm", Float.valueOf(this.f7145a.e0().b()));
        }
        map2.put("mute_switch", Integer.valueOf(this.f7145a.p().a()));
        map2.put("network", com.applovin.impl.n0.g(this.f7145a));
        String strO = o();
        if (StringUtils.isValidString(strO)) {
            map2.put("kb", strO);
        }
        ArrayService arrayServiceO = this.f7145a.o();
        if (arrayServiceO.isAppHubInstalled()) {
            if (arrayServiceO.getIsDirectDownloadEnabled() != null) {
                map2.put("ah_dd_enabled", arrayServiceO.getIsDirectDownloadEnabled());
            }
            map2.put("ah_sdk_version_code", Long.valueOf(arrayServiceO.getAppHubVersionCode()));
            map2.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceO.getRandomUserToken()));
            map2.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceO.getAppHubPackageName()));
        }
        return map2;
    }

    public static void a(t.a aVar) {
        f7143l.set(aVar);
    }

    public static void a(b bVar) {
        f7144m.set(bVar);
    }

    public static void a(String str, j jVar) {
        String strA = a(j.n().getApplicationInfo().packageName, j.n().getPackageManager(), jVar);
        List listC = jVar.c(l4.f5621d6);
        if (!StringUtils.isValidString(strA) || listC.contains(strA)) {
            f7141j = str;
        }
    }

    private boolean a(String str) {
        return b(str) == 1;
    }

    private static String a(String str, PackageManager packageManager, j jVar) {
        try {
            if (((Boolean) jVar.a(l4.f5627e4)).booleanValue() && com.applovin.impl.k0.b()) {
                return packageManager.getInstallSourceInfo(str).getInstallingPackageName();
            }
            return packageManager.getInstallerPackageName(str);
        } catch (Throwable th) {
            jVar.A().a("DataCollector", "getInstallerName", th);
            return null;
        }
    }
}
