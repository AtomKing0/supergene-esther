package com.google.android.gms.ads.internal.util;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzbeb;
import com.google.android.gms.internal.ads.zzbvl;
import com.google.android.gms.internal.ads.zzcea;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzdpo;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzfeo;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfui;
import com.google.android.gms.internal.ads.zzfvh;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzhfv;
import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzt {
    public static final zzfru zza = new zzf(Looper.getMainLooper());

    @GuardedBy("userAgentLock")
    private String zzh;
    private volatile String zzi;
    private final AtomicReference zzb = new AtomicReference(null);
    private final AtomicReference zzc = new AtomicReference(null);
    private final AtomicReference zzd = new AtomicReference(new Bundle());
    private final AtomicBoolean zze = new AtomicBoolean();
    private boolean zzf = true;
    private final Object zzg = new Object();
    private boolean zzj = false;
    private boolean zzk = false;
    private final Executor zzl = Executors.newSingleThreadExecutor();

    public static final boolean zzA(Context context, String str) {
        Context contextZza = zzbvl.zza(context);
        return Wrappers.packageManager(contextZza).checkPermission(str, contextZza.getPackageName()) == 0;
    }

    public static final boolean zzB(Context context) {
        try {
            return DeviceProperties.isBstar(context);
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    public static final boolean zzC(String str) {
        if (!com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzev)).booleanValue()) {
            return false;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzex);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzew);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean zzD(Context context) {
        KeyguardManager keyguardManagerZzX;
        return (context == null || (keyguardManagerZzX = zzX(context)) == null || !keyguardManagerZzX.isKeyguardLocked()) ? false : true;
    }

    public static final boolean zzE(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error loading class.", th);
            com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean zzF() {
        int iMyUid = Process.myUid();
        return iMyUid == 0 || iMyUid == 1000;
    }

    public static final boolean zzG(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
                        return !powerManager.isScreenOn();
                    }
                    return true;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean zzH(Context context) {
        try {
            Bundle bundleZzY = zzY(context);
            String string = bundleZzY.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
            if (TextUtils.isEmpty(zzZ(bundleZzY))) {
                if (!TextUtils.isEmpty(string)) {
                    return true;
                }
            }
        } catch (RemoteException unused) {
        }
        return false;
    }

    public static final boolean zzI(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static final void zzJ(View view, int i10, MotionEvent motionEvent) {
        String strZza;
        int i11;
        int iHeight;
        int iWidth;
        String str;
        zzfel zzfelVarZzD;
        zzfeo zzfeoVarZzR;
        View childAt = view;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        try {
            String packageName = view.getContext().getPackageName();
            if (childAt instanceof zzdpo) {
                childAt = ((zzdpo) childAt).getChildAt(0);
            }
            if ((childAt instanceof com.google.android.gms.ads.formats.zzj) || (childAt instanceof NativeAdView)) {
                strZza = "NATIVE";
                i11 = 1;
            } else {
                strZza = "UNKNOWN";
                i11 = 0;
            }
            if (childAt.getLocalVisibleRect(rect)) {
                iWidth = rect.width();
                iHeight = rect.height();
            } else {
                iHeight = 0;
                iWidth = 0;
            }
            com.google.android.gms.ads.internal.zzu.zzp();
            long jZzw = zzw(childAt);
            childAt.getLocationOnScreen(iArr);
            int i12 = iArr[0];
            int i13 = iArr[1];
            String str2 = "none";
            if (!(childAt instanceof zzcfm) || (zzfeoVarZzR = ((zzcfm) childAt).zzR()) == null) {
                str = "none";
            } else {
                str = zzfeoVarZzR.zzb;
                childAt.setContentDescription(str + ":" + childAt.hashCode());
            }
            if ((childAt instanceof zzcea) && (zzfelVarZzD = ((zzcea) childAt).zzD()) != null) {
                strZza = zzfel.zza(zzfelVarZzD.zzb);
                i11 = zzfelVarZzD.zze;
                str2 = zzfelVarZzD.zzE;
            }
            com.google.android.gms.ads.internal.util.client.zzm.zzi(String.format(Locale.US, "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", Integer.valueOf(childAt.hashCode()), packageName, str2, str, strZza, Integer.valueOf(i11), childAt.getClass().getName(), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(childAt.getWidth()), Integer.valueOf(childAt.getHeight()), Integer.valueOf(iWidth), Integer.valueOf(iHeight), Long.valueOf(jZzw), Integer.toString(i10, 2)));
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Failure getting view location.", e10);
        }
    }

    public static final AlertDialog.Builder zzK(Context context) {
        com.google.android.gms.ads.internal.zzu.zzq();
        return new AlertDialog.Builder(context, R.style.Theme.Material.Dialog.Alert);
    }

    public static final void zzL(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            new zzbw(context, str, (String) it.next()).zzb();
        }
    }

    public static final void zzM(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        try {
            if (((Boolean) zzbeb.zzb.zze()).booleanValue()) {
                CrashUtils.addDynamiteErrorToDropBox(context, th);
            }
        } catch (IllegalStateException unused) {
        }
    }

    public static final String zzN(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int i10 = inputStreamReader.read(cArr);
            if (i10 == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, i10);
        }
    }

    public static final int zzO(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not parse value:".concat(e10.toString()));
            return 0;
        }
    }

    @Nullable
    public static final Map zzP(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(str)) {
                map.put(str, uri.getQueryParameter(str));
            }
        }
        return map;
    }

    public static final int[] zzQ(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        return (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? zzu() : new int[]{viewFindViewById.getWidth(), viewFindViewById.getHeight()};
    }

    public static final int[] zzR(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        int[] iArrZzu = (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? zzu() : new int[]{viewFindViewById.getTop(), viewFindViewById.getBottom()};
        return new int[]{com.google.android.gms.ads.internal.client.zzay.zzb().zzb(activity, iArrZzu[0]), com.google.android.gms.ads.internal.client.zzay.zzb().zzb(activity, iArrZzu[1])};
    }

    public static final boolean zzS(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z10 = com.google.android.gms.ads.internal.zzu.zzp().zzf || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || zzn(view);
        long jZzw = zzw(view);
        if (view.getVisibility() == 0 && view.isShown() && ((powerManager == null || powerManager.isScreenOn()) && z10)) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbc)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjI)).booleanValue()) {
                    return true;
                }
                if (jZzw >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjK)).intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void zzT(Context context, Intent intent) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkc)).booleanValue()) {
            zzab(context, intent);
            return;
        }
        try {
            zzab(context, intent);
        } catch (SecurityException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("", e10);
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdUtil.startActivityWithUnknownContext");
        }
    }

    public static final void zzU(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzo(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            com.google.android.gms.ads.internal.util.client.zzm.zze("Opening " + uri.toString() + " in a new browser.");
        } catch (ActivityNotFoundException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("No browser is found.", e10);
        }
    }

    public static final int[] zzV(Activity activity) {
        int[] iArrZzQ = zzQ(activity);
        return new int[]{com.google.android.gms.ads.internal.client.zzay.zzb().zzb(activity, iArrZzQ[0]), com.google.android.gms.ads.internal.client.zzay.zzb().zzb(activity, iArrZzQ[1])};
    }

    public static final boolean zzW(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zzS(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzX(context));
    }

    @Nullable
    private static KeyguardManager zzX(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    @Nullable
    private static Bundle zzY(Context context) throws RemoteException {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e10) {
            zze.zzb("Error getting metadata", e10);
            return null;
        }
    }

    private static String zzZ(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        return !TextUtils.isEmpty(string) ? (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "" : "";
    }

    public static int zza(int i10) {
        if (i10 >= 5000) {
            return i10;
        }
        if (i10 <= 0) {
            return 60000;
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj("HTTP timeout too low: " + i10 + " milliseconds. Reverting to default timeout: 60000 milliseconds.");
        return 60000;
    }

    private static boolean zzaa(String str, AtomicReference atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern patternCompile = (Pattern) atomicReference.get();
            if (patternCompile == null || !str2.equals(patternCompile.pattern())) {
                patternCompile = Pattern.compile(str2);
                atomicReference.set(patternCompile);
            }
            return patternCompile.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    private static final void zzab(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static final String zzac(final Context context, String str) {
        String strZzq;
        String str2;
        if (str == null) {
            return zzq();
        }
        try {
            zzcg zzcgVarZza = zzcg.zza();
            if (TextUtils.isEmpty(zzcgVarZza.zza)) {
                if (ClientLibraryUtils.isPackageSide()) {
                    str2 = (String) zzcd.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzce
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Context context2 = context;
                            SharedPreferences sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                            String string = sharedPreferences.getString("user_agent", "");
                            if (!TextUtils.isEmpty(string)) {
                                zze.zza("User agent is already initialized on Google Play Services.");
                                return string;
                            }
                            zze.zza("User agent is not initialized on Google Play Services. Initializing.");
                            String defaultUserAgent = WebSettings.getDefaultUserAgent(context2);
                            SharedPreferencesUtils.publishWorldReadableSharedPreferences(context2, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
                            return defaultUserAgent;
                        }
                    });
                } else {
                    final Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                    str2 = (String) zzcd.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzcf
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            SharedPreferences sharedPreferences;
                            Context context2 = remoteContext;
                            Context context3 = context;
                            boolean z10 = false;
                            if (context2 != null) {
                                zze.zza("Attempting to read user agent from Google Play Services.");
                                sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                            } else {
                                zze.zza("Attempting to read user agent from local cache.");
                                sharedPreferences = context3.getSharedPreferences("admob_user_agent", 0);
                                z10 = true;
                            }
                            String string = sharedPreferences.getString("user_agent", "");
                            if (TextUtils.isEmpty(string)) {
                                zze.zza("Reading user agent from WebSettings");
                                string = WebSettings.getDefaultUserAgent(context3);
                                if (z10) {
                                    sharedPreferences.edit().putString("user_agent", string).apply();
                                    zze.zza("Persisting user agent.");
                                }
                            }
                            return string;
                        }
                    });
                }
                zzcgVarZza.zza = str2;
            }
            strZzq = zzcgVarZza.zza;
        } catch (Exception unused) {
            strZzq = null;
        }
        if (TextUtils.isEmpty(strZzq)) {
            strZzq = WebSettings.getDefaultUserAgent(context);
        }
        if (TextUtils.isEmpty(strZzq)) {
            strZzq = zzq();
        }
        String str3 = strZzq + " (Mobile; " + str;
        try {
            if (Wrappers.packageManager(context).isCallerInstantApp()) {
                str3 = str3 + ";aia";
            }
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdUtil.getUserAgent");
        }
        return str3.concat(")");
    }

    public static List zzd() {
        zzbbn zzbbnVar = zzbbw.zza;
        List listZzb = com.google.android.gms.ads.internal.client.zzba.zza().zzb();
        ArrayList arrayList = new ArrayList();
        Iterator it = listZzb.iterator();
        while (it.hasNext()) {
            Iterator it2 = zzfvh.zzb(zzfui.zzc(',')).zzc((String) it.next()).iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(Long.valueOf((String) it2.next()));
                } catch (NumberFormatException unused) {
                    zze.zza("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean zzn(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 != 0) goto L9
        L7:
            r2 = r0
            goto L13
        L9:
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L7
            android.app.Activity r2 = (android.app.Activity) r2
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzt.zzn(android.view.View):boolean");
    }

    public static final void zzo(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
        extras.putBinder(CustomTabsIntent.EXTRA_SESSION, null);
        extras.putString("com.android.browser.application_id", context.getPackageName());
        intent.putExtras(extras);
    }

    public static final String zzp(Context context) throws RemoteException {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzZ(zzY(context));
    }

    static final String zzq() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final String zzr() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        return str + " " + str2;
    }

    @Nullable
    public static final Integer zzs(Context context) {
        Object systemService = context.getSystemService(v8.h.f15785d);
        if (systemService instanceof DisplayManager) {
            return Integer.valueOf(((DisplayManager) systemService).getDisplays().length);
        }
        return null;
    }

    public static final DisplayMetrics zzt(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    protected static final int[] zzu() {
        return new int[]{0, 0};
    }

    public static final Map zzv(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                HashSet hashSet = new HashSet();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null) {
                    for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i10);
                        if (strOptString != null) {
                            hashSet.add(strOptString);
                        }
                    }
                    map.put(next, hashSet);
                }
            }
            return map;
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdUtil.getMapOfFileNamesToKeysFromJsonString");
            return map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.ViewParent] */
    public static final long zzw(View view) {
        float fMin = Float.MAX_VALUE;
        do {
            if (!(view instanceof View)) {
                break;
            }
            View view2 = (View) view;
            fMin = Math.min(fMin, view2.getAlpha());
            view = view2.getParent();
        } while (fMin > 0.0f);
        return Math.round((fMin >= 0.0f ? fMin : 0.0f) * 100.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final WebResourceResponse zzx(Context context, String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("User-Agent", com.google.android.gms.ads.internal.zzu.zzp().zzc(context, str));
            map.put("Cache-Control", "max-stale=3600");
            String str3 = (String) new zzbo(context).zzb(0, str2, map, null).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not fetch MRAID JS.", e10);
        }
        return null;
    }

    public static final String zzy() {
        Resources resourcesZze = com.google.android.gms.ads.internal.zzu.zzo().zze();
        return resourcesZze != null ? resourcesZze.getString(com.google.android.gms.ads.impl.R.string.f8698s7) : "Test Ad";
    }

    @Nullable
    public static final zzbr zzz(Context context) {
        try {
            Object objNewInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(objNewInstance instanceof IBinder)) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) objNewInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            return iInterfaceQueryLocalInterface instanceof zzbr ? (zzbr) iInterfaceQueryLocalInterface : new zzbp(iBinder);
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public final m zzb(final Uri uri) {
        return zzgcj.zzj(new Callable() { // from class: com.google.android.gms.ads.internal.util.zzn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfru zzfruVar = zzt.zza;
                com.google.android.gms.ads.internal.zzu.zzp();
                return zzt.zzP(uri);
            }
        }, this.zzl);
    }

    public final String zzc(Context context, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkp)).booleanValue()) {
            if (this.zzi != null) {
                return this.zzi;
            }
            this.zzi = zzac(context, str);
            return this.zzi;
        }
        synchronized (this.zzg) {
            String str2 = this.zzh;
            if (str2 != null) {
                return str2;
            }
            String strZzac = zzac(context, str);
            this.zzh = strZzac;
            return strZzac;
        }
    }

    public final void zzf(Context context, String str, boolean z10, HttpURLConnection httpURLConnection, boolean z11, int i10) {
        int iZza = zza(i10);
        com.google.android.gms.ads.internal.util.client.zzm.zzi("HTTP timeout: " + iZza + " milliseconds.");
        httpURLConnection.setConnectTimeout(iZza);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(iZza);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("User-Agent"))) {
            httpURLConnection.setRequestProperty("User-Agent", zzc(context, str));
        }
        httpURLConnection.setUseCaches(false);
    }

    final /* synthetic */ void zzg(Context context, String str, SharedPreferences sharedPreferences, String str2) {
        this.zzd.set(zzad.zzb(context, str));
    }

    public final void zzh(final Context context, @Nullable final String str, String str2, Bundle bundle, boolean z10) {
        com.google.android.gms.ads.internal.zzu.zzp();
        bundle.putString("device", zzr());
        zzbbn zzbbnVar = zzbbw.zza;
        bundle.putString("eids", TextUtils.join(",", com.google.android.gms.ads.internal.client.zzba.zza().zza()));
        if (bundle.isEmpty()) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Empty or null bundle.");
        } else {
            final String str3 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjG);
            if (!this.zze.getAndSet(true)) {
                this.zzd.set(zzad.zza(context, str3, new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.ads.internal.util.zzm
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str4) {
                        this.zza.zzg(context, str3, sharedPreferences, str4);
                    }
                }));
            }
            bundle.putAll((Bundle) this.zzd.get());
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        com.google.android.gms.ads.internal.util.client.zzf.zzx(context, str, "gmob-apps", bundle, true, new com.google.android.gms.ads.internal.util.client.zze() { // from class: com.google.android.gms.ads.internal.util.zzl
            @Override // com.google.android.gms.ads.internal.util.client.zze
            public final boolean zza(String str4) {
                zzfru zzfruVar = zzt.zza;
                com.google.android.gms.ads.internal.zzu.zzp();
                zzt.zzL(context, str, str4);
                return true;
            }
        });
    }

    public final boolean zzi(String str) {
        return zzaa(str, this.zzb, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzV));
    }

    public final boolean zzj(String str) {
        return zzaa(str, this.zzc, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzW));
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final boolean zzk(Context context) {
        if (this.zzk) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        zzbbw.zza(context);
        zzp zzpVar = null;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzq(this, zzpVar), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzq(this, zzpVar), intentFilter, 4);
        }
        this.zzk = true;
        return true;
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final boolean zzl(Context context) {
        if (this.zzj) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        zzbbw.zza(context);
        zzr zzrVar = null;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzs(this, zzrVar), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzs(this, zzrVar), intentFilter, 4);
        }
        this.zzj = true;
        return true;
    }

    public final int zzm(Context context, Uri uri) {
        int i10;
        if (context == null) {
            zze.zza("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (context instanceof Activity) {
            i10 = 0;
        } else {
            zze.zza("Chrome Custom Tabs can only work with Activity context.");
            i10 = 2;
        }
        zzbbn zzbbnVar = zzbbw.zzec;
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar);
        zzbbn zzbbnVar2 = zzbbw.zzed;
        if (true == bool.equals(com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar2))) {
            i10 = 9;
        }
        if (i10 != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return i10;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
            zzbct zzbctVar = new zzbct();
            zzbctVar.zze(new zzo(this, zzbctVar, context, uri));
            zzbctVar.zzb((Activity) context);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar2)).booleanValue()) {
            return 5;
        }
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
        customTabsIntentBuild.intent.setPackage(zzhfv.zza(context));
        customTabsIntentBuild.launchUrl(context, uri);
        return 5;
    }
}
