package com.ironsource;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import androidx.autofill.HintConstants;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.tasks.OnSuccessListener;
import com.ironsource.ce;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.IronSourceSharedPreferencesUtilities;
import com.ironsource.k9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.v8;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ma implements ce, ce.a {
    private static final String A = "IABTCF_TCString";
    private static final String B = "IABTCF_AddtlConsent";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f13214i = "android";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f13215j = "com.google.android.gms.permission.AD_ID";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f13216k = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f13217l = "com.google.android.gms.appset.AppSet";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f13218m = "com.google.android.gms.tasks.OnSuccessListener";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f13219n = "getAdvertisingIdInfo";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f13220o = "getClient";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f13221p = "getAppSetIdInfo";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f13222q = "addOnSuccessListener";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f13223r = "getId";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f13224s = "isLimitAdTrackingEnabled";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f13225t = "Mediation_Shared_Preferences";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f13226u = "supersonic_shared_preferen";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f13227v = "cachedUUID";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f13228w = "auid";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f13229x = "browser_user_agent";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f13230y = "browser_user_agent_time";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f13231z = "IABTCF_gdprApplies";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13232b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13233c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13234d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13235e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13236f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile String f13237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f13238h;

    class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            if (objArr == null) {
                return null;
            }
            try {
                if (objArr.length <= 0 || (obj2 = objArr[0]) == null) {
                    return null;
                }
                String string = obj2.getClass().getMethod(ma.f13223r, new Class[0]).invoke(objArr[0], new Object[0]).toString();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                ma.this.f13236f = string;
                return null;
            } catch (Exception e10) {
                i9.d().a(e10);
                return null;
            }
        }
    }

    private String L(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objN = N(context);
        return objN.getClass().getMethod(f13223r, new Class[0]).invoke(objN, new Object[0]).toString();
    }

    private void M(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objInvoke = AppSet.class.getMethod(f13220o, Context.class).invoke(AppSet.class, context);
        Object objInvoke2 = objInvoke.getClass().getMethod(f13221p, new Class[0]).invoke(objInvoke, new Object[0]);
        objInvoke2.getClass().getMethod(f13222q, OnSuccessListener.class).invoke(objInvoke2, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{OnSuccessListener.class}, new a()));
    }

    private Object N(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return AdvertisingIdClient.class.getMethod(f13219n, Context.class).invoke(AdvertisingIdClient.class, context);
    }

    private String O(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objN = N(context);
        return String.valueOf(((Boolean) objN.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(objN, new Object[0])).booleanValue());
    }

    @NotNull
    private String P(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, f13225t, f13229x, "");
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return "";
        }
    }

    private long Q(Context context) {
        try {
            return Long.parseLong(IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, f13225t, f13230y, String.valueOf(-1L)));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return -1L;
        }
    }

    @Override // com.ironsource.ce
    public String A(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, "IABTCF_TCString", null);
        } catch (Exception e10) {
            i9.d().a(e10);
            return null;
        }
    }

    @Override // com.ironsource.ce
    public boolean B(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    @Override // com.ironsource.ce
    public String C(Context context) {
        return Locale.getDefault().toString();
    }

    @Override // com.ironsource.ce
    public String D(Context context) {
        if (ja.f12717a.c()) {
            try {
                M(context);
                if (!TextUtils.isEmpty(this.f13236f)) {
                    return this.f13236f;
                }
            } catch (Exception e10) {
                i9.d().a(e10);
            }
        }
        return "";
    }

    @Override // com.ironsource.ce
    public int E(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    @Override // com.ironsource.ce
    public String F(Context context) throws Exception {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    @Override // com.ironsource.ce
    public boolean G(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        return intExtra == 2 || intExtra == 5;
    }

    @Override // com.ironsource.ce
    public String H(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, "IABTCF_AddtlConsent", null);
        } catch (Exception e10) {
            i9.d().a(e10);
            return null;
        }
    }

    @Override // com.ironsource.ce
    public int I(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    @Override // com.ironsource.ce
    public synchronized String J(Context context) {
        if (!TextUtils.isEmpty(this.f13232b)) {
            return this.f13232b;
        }
        if (IronSourceSharedPreferencesUtilities.getBooleanFromSharedPrefs(context, f13225t, ce.f11549a, true)) {
            String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, f13225t, f13227v, "");
            if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                String string = UUID.randomUUID().toString();
                this.f13232b = string;
                IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, f13225t, f13227v, string);
            } else {
                this.f13232b = stringFromSharedPrefs;
            }
        }
        return this.f13232b;
    }

    @Override // com.ironsource.ce
    public int K(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    @Override // com.ironsource.ce
    public int a() {
        return j();
    }

    @Override // com.ironsource.ce
    public String b() {
        String id = TimeZone.getDefault().getID();
        return id != null ? id : "";
    }

    @Override // com.ironsource.ce
    public boolean c() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return Environment.isExternalStorageRemovable();
            }
            return false;
        } catch (Exception e10) {
            i9.d().a(e10);
            return false;
        }
    }

    @Override // com.ironsource.ce
    public int d() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    @Override // com.ironsource.ce
    public File e(Context context) {
        return context.getExternalCacheDir();
    }

    @Override // com.ironsource.ce
    public String f(Context context) {
        if (context == null) {
            return "";
        }
        int iK = K(context);
        if (iK != 0) {
            if (iK != 1) {
                if (iK != 11) {
                    if (iK != 12) {
                        switch (iK) {
                            case 6:
                            case 8:
                                break;
                            case 7:
                            case 9:
                                break;
                            default:
                                return "none";
                        }
                    }
                }
            }
            return v8.h.D;
        }
        return v8.h.C;
    }

    @Override // com.ironsource.ce
    public String g() {
        return Build.MANUFACTURER;
    }

    @Override // com.ironsource.ce
    public float h() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    @Override // com.ironsource.ce
    public long i() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    @Override // com.ironsource.ce
    public int j() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    @Override // com.ironsource.ce
    public int k() {
        return Build.VERSION.SDK_INT;
    }

    @Override // com.ironsource.ce
    public int l(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return intentRegisterReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    @Override // com.ironsource.ce
    public float m(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        try {
            return audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return -1.0f;
        }
    }

    @Override // com.ironsource.ce
    public long n() {
        return a(Environment.getDataDirectory());
    }

    @Override // com.ironsource.ce
    public String o() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.ironsource.ce
    public int p() {
        return -(TimeZone.getDefault().getOffset(i()) / 60000);
    }

    @Override // com.ironsource.ce
    public boolean q() {
        return this.f13235e;
    }

    @Override // com.ironsource.ce
    public int r() {
        return d();
    }

    @Override // com.ironsource.ce
    public String s() {
        try {
            return this.f13234d.isEmpty() ? P(ContextProvider.getInstance().getApplicationContext()) : this.f13234d;
        } catch (Exception e10) {
            i9.d().a(e10);
            return "";
        }
    }

    @Override // com.ironsource.ce
    public File t(Context context) {
        return context.getExternalFilesDir(null);
    }

    @Override // com.ironsource.ce
    public boolean u(Context context) {
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (str.equalsIgnoreCase(f13215j)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            i9.d().a(e10);
            return false;
        }
    }

    @Override // com.ironsource.ce
    public File v(Context context) {
        return context.getFilesDir();
    }

    @Override // com.ironsource.ce
    public int w(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : 0;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra == -1 || intExtra2 == -1) {
                return -1;
            }
            return (int) ((intExtra / intExtra2) * 100.0f);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return -1;
        }
    }

    @Override // com.ironsource.ce
    public int x(Context context) {
        int I = I(context);
        int iE = E(context);
        return (((I == 0 || I == 2) && iE == 2) || ((I == 1 || I == 3) && iE == 1)) ? 2 : 1;
    }

    @Override // com.ironsource.ce
    public int y(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getIntFromDefaultSharedPrefs(context, "IABTCF_gdprApplies", -1);
        } catch (Exception e10) {
            i9.d().a(e10);
            return -1;
        }
    }

    @Override // com.ironsource.ce
    public int z(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    private long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1048576;
    }

    @Override // com.ironsource.ce
    public String b(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    @Override // com.ironsource.ce
    public boolean c(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return false;
        }
    }

    @Override // com.ironsource.ce
    public boolean d(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return false;
        }
    }

    @Override // com.ironsource.ce
    public String e() {
        return Build.MODEL;
    }

    @Override // com.ironsource.ce
    public boolean f() {
        return b("su");
    }

    @Override // com.ironsource.ce
    public boolean g(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @Override // com.ironsource.ce
    public long h(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    @Override // com.ironsource.ce
    public String i(Context context) {
        return r(context) ? "Tablet" : "Phone";
    }

    @Override // com.ironsource.ce
    public String j(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)) == null) ? "" : telephonyManager.getNetworkOperatorName();
    }

    @Override // com.ironsource.ce
    public File k(Context context) {
        return context.getCacheDir();
    }

    @Override // com.ironsource.ce
    public String l() {
        return "android";
    }

    @Override // com.ironsource.ce
    public long m() {
        if (c()) {
            return a(Environment.getExternalStorageDirectory());
        }
        return 0L;
    }

    @Override // com.ironsource.ce
    public String n(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)) == null) ? "" : telephonyManager.getNetworkCountryIso();
    }

    @Override // com.ironsource.ce
    @SuppressLint({"QueryPermissionsNeeded"})
    public List<ApplicationInfo> o(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    @Override // com.ironsource.ce
    @Nullable
    public String p(Context context) {
        String strL;
        ja jaVar = ja.f12717a;
        if (!jaVar.b()) {
            return null;
        }
        try {
            if (!jaVar.a()) {
                strL = L(context);
            } else {
                if (this.f13238h == null) {
                    String strL2 = L(context);
                    if (TextUtils.isEmpty(strL2)) {
                        return strL2;
                    }
                    this.f13238h = strL2;
                    return strL2;
                }
                strL = this.f13238h;
            }
            return strL;
        } catch (Exception e10) {
            i9.d().a(e10);
            return null;
        }
    }

    @Override // com.ironsource.ce
    public boolean q(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return false;
        }
    }

    @Override // com.ironsource.ce
    public boolean r(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }

    @Override // com.ironsource.ce
    public synchronized String s(Context context) {
        if (!TextUtils.isEmpty(this.f13233c)) {
            return this.f13233c;
        }
        if (context == null) {
            return "";
        }
        String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "supersonic_shared_preferen", "auid", "");
        this.f13233c = stringFromSharedPrefs;
        if (TextUtils.isEmpty(stringFromSharedPrefs)) {
            String string = UUID.randomUUID().toString();
            this.f13233c = string;
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "supersonic_shared_preferen", "auid", string);
        }
        return this.f13233c;
    }

    private void b(Context context, long j10) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, f13225t, f13230y, String.valueOf(j10));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Override // com.ironsource.ce
    public long a(String str) {
        return a(new File(str));
    }

    private boolean b(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i10 = 0; i10 < 8; i10++) {
                if (new File(strArr[i10] + str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            i9.d().a(e10);
            return false;
        }
    }

    @Override // com.ironsource.ce
    @Nullable
    public String a(Context context) {
        String strO;
        try {
            if (!ja.f12717a.a()) {
                strO = O(context);
            } else {
                if (this.f13237g == null) {
                    String strO2 = O(context);
                    if (TextUtils.isEmpty(strO2)) {
                        return strO2;
                    }
                    this.f13237g = strO2;
                    return strO2;
                }
                strO = this.f13237g;
            }
            return strO;
        } catch (Exception e10) {
            i9.d().a(e10);
            return null;
        }
    }

    @Override // com.ironsource.ce.a
    public void a(Context context, long j10) {
        if (context != null) {
            if (!new wt(new k9.a()).a(Q(context), j10)) {
                this.f13234d = P(context);
                this.f13235e = !r0.isEmpty();
            }
            if (this.f13234d.isEmpty()) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    this.f13234d = defaultUserAgent;
                    a(context, defaultUserAgent);
                    if (j10 > 0) {
                        b(context, System.currentTimeMillis());
                    }
                } catch (Exception e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error(e10.toString());
                }
            }
        }
    }

    private void a(Context context, String str) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, f13225t, f13229x, str);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Override // com.ironsource.ce
    public boolean a(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }
}
