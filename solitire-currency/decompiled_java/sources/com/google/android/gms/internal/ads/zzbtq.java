package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbtq implements zzbts {

    @VisibleForTesting
    public static zzbts zza;

    @VisibleForTesting
    static zzbts zzb;

    @VisibleForTesting
    static zzbts zzc;

    @VisibleForTesting
    static Boolean zzd;
    private static final Object zze = new Object();
    private final Object zzf;
    private final Context zzg;
    private final WeakHashMap zzh;
    private final ExecutorService zzi;
    private final VersionInfoParcel zzj;
    private final PackageInfo zzk;
    private final String zzl;
    private final String zzm;
    private final AtomicBoolean zzn;
    private boolean zzo;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected zzbtq(android.content.Context r3, com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.zzf = r0
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r0.<init>()
            r2.zzh = r0
            com.google.android.gms.internal.ads.zzfrt.zza()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.unconfigurableExecutorService(r0)
            r2.zzi = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r2.zzn = r0
            android.content.Context r0 = r3.getApplicationContext()
            if (r0 == 0) goto L2f
            android.content.Context r3 = r3.getApplicationContext()
        L2f:
            r2.zzg = r3
            r2.zzj = r4
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzgX
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r0 = 0
            if (r4 == 0) goto L61
            android.os.Handler r4 = com.google.android.gms.ads.internal.util.client.zzf.zza
            if (r3 == 0) goto L61
            android.content.pm.ApplicationInfo r4 = r3.getApplicationInfo()
            if (r4 != 0) goto L51
            goto L61
        L51:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r4 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            java.lang.String r3 = r3.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            r1 = 0
            android.content.pm.PackageInfo r3 = r4.getPackageInfo(r3, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            goto L62
        L61:
            r3 = r0
        L62:
            r2.zzk = r3
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzgV
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r4.zza(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            java.lang.String r1 = "unknown"
            if (r4 == 0) goto L81
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getCountry()
            goto L82
        L81:
            r4 = r1
        L82:
            r2.zzl = r4
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto Lb1
            android.content.Context r3 = r2.zzg
            android.os.Handler r4 = com.google.android.gms.ads.internal.util.client.zzf.zza
            if (r3 != 0) goto L9b
            goto Lb2
        L9b:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lb2
            java.lang.String r4 = "com.android.vending"
            r1 = 128(0x80, float:1.8E-43)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lb2
            if (r3 != 0) goto Laa
            goto Lb2
        Laa:
            int r3 = r3.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lb2
            java.lang.String r0 = java.lang.Integer.toString(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lb2
            goto Lb2
        Lb1:
            r0 = r1
        Lb2:
            r2.zzm = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtq.<init>(android.content.Context, com.google.android.gms.ads.internal.util.client.VersionInfoParcel):void");
    }

    public static zzbts zza(Context context) {
        synchronized (zze) {
            if (zza == null) {
                if (zzl()) {
                    zza = new zzbtq(context, VersionInfoParcel.forPackage());
                } else {
                    zza = new zzbtr();
                }
            }
        }
        return zza;
    }

    public static zzbts zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            if (zzc == null) {
                boolean z10 = false;
                if (((Boolean) zzbdk.zzc.zze()).booleanValue()) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgQ)).booleanValue() || ((Boolean) zzbdk.zza.zze()).booleanValue()) {
                        z10 = true;
                    }
                }
                if (zzl()) {
                    zzbtq zzbtqVar = new zzbtq(context, versionInfoParcel);
                    zzbtqVar.zzk();
                    zzbtqVar.zzj();
                    zzc = zzbtqVar;
                } else if (z10) {
                    zzbtq zzbtqVar2 = new zzbtq(context, versionInfoParcel, true);
                    zzbtqVar2.zzk();
                    zzbtqVar2.zzj();
                    zzc = zzbtqVar2;
                } else {
                    zzc = new zzbtr();
                }
            }
        }
        return zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:10:0x002b, B:11:0x0037, B:12:0x003e), top: B:18:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbts zzc(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbtq.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzbts r1 = com.google.android.gms.internal.ads.zzbtq.zzb     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto L3e
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgR     // Catch: java.lang.Throwable -> L42
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L42
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L37
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgQ     // Catch: java.lang.Throwable -> L42
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L42
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto L37
            com.google.android.gms.internal.ads.zzbtq r1 = new com.google.android.gms.internal.ads.zzbtq     // Catch: java.lang.Throwable -> L42
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = com.google.android.gms.ads.internal.util.client.VersionInfoParcel.forPackage()     // Catch: java.lang.Throwable -> L42
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L42
            com.google.android.gms.internal.ads.zzbtq.zzb = r1     // Catch: java.lang.Throwable -> L42
            goto L3e
        L37:
            com.google.android.gms.internal.ads.zzbtr r3 = new com.google.android.gms.internal.ads.zzbtr     // Catch: java.lang.Throwable -> L42
            r3.<init>()     // Catch: java.lang.Throwable -> L42
            com.google.android.gms.internal.ads.zzbtq.zzb = r3     // Catch: java.lang.Throwable -> L42
        L3e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            com.google.android.gms.internal.ads.zzbts r3 = com.google.android.gms.internal.ads.zzbtq.zzb
            return r3
        L42:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtq.zzc(android.content.Context):com.google.android.gms.internal.ads.zzbts");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[Catch: all -> 0x003e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:10:0x002b, B:11:0x0033, B:12:0x003a), top: B:18:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbts zzd(android.content.Context r3, com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbtq.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzbts r1 = com.google.android.gms.internal.ads.zzbtq.zzb     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto L3a
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgR     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L3e
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L3e
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L33
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgQ     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L3e
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L3e
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto L33
            com.google.android.gms.internal.ads.zzbtq r1 = new com.google.android.gms.internal.ads.zzbtq     // Catch: java.lang.Throwable -> L3e
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.internal.ads.zzbtq.zzb = r1     // Catch: java.lang.Throwable -> L3e
            goto L3a
        L33:
            com.google.android.gms.internal.ads.zzbtr r3 = new com.google.android.gms.internal.ads.zzbtr     // Catch: java.lang.Throwable -> L3e
            r3.<init>()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.internal.ads.zzbtq.zzb = r3     // Catch: java.lang.Throwable -> L3e
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.internal.ads.zzbts r3 = com.google.android.gms.internal.ads.zzbtq.zzb
            return r3
        L3e:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtq.zzd(android.content.Context, com.google.android.gms.ads.internal.util.client.VersionInfoParcel):com.google.android.gms.internal.ads.zzbts");
    }

    public static String zze(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzf(Throwable th) {
        return zzfvj.zzc(com.google.android.gms.ads.internal.util.client.zzf.zzg(zze(th)));
    }

    private final void zzj() {
        Thread.setDefaultUncaughtExceptionHandler(new zzbto(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final void zzk() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread == null) {
            return;
        }
        synchronized (this.zzf) {
            this.zzh.put(thread, Boolean.TRUE);
        }
        thread.setUncaughtExceptionHandler(new zzbtp(this, thread.getUncaughtExceptionHandler()));
    }

    private static boolean zzl() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlO)).booleanValue()) {
            if (((Boolean) zzbeb.zze.zze()).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgQ)).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        synchronized (zze) {
            if (zzd == null) {
                zzd = Boolean.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlL)).intValue());
            }
        }
        if (zzd.booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgQ)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    protected final void zzg(Thread thread, Throwable th) {
        if (th != null) {
            boolean zZzp = false;
            boolean zEquals = false;
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    zZzp |= com.google.android.gms.ads.internal.util.client.zzf.zzp(stackTraceElement.getClassName());
                    zEquals |= zzbtq.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (!zZzp || zEquals) {
                return;
            }
            if (!this.zzo) {
                zzh(th, "");
            }
            if (this.zzn.getAndSet(true) || !((Boolean) zzbdk.zzc.zze()).booleanValue()) {
                return;
            }
            zzbbg.zzc(this.zzg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbts
    public final void zzh(Throwable th, String str) {
        if (this.zzo) {
            return;
        }
        zzi(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzbts
    public final void zzi(Throwable th, String str, float f10) {
        Throwable th2;
        String packageName;
        PackageInfo packageInfo;
        ActivityManager.MemoryInfo memoryInfoZzc;
        if (this.zzo) {
            return;
        }
        Handler handler = com.google.android.gms.ads.internal.util.client.zzf.zza;
        boolean zIsCallerInstantApp = false;
        if (((Boolean) zzbeb.zzf.zze()).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                linkedList.push(cause);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th3 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th3.getStackTrace();
                boolean z10 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbY)).booleanValue() && stackTrace != null && stackTrace.length == 0 && com.google.android.gms.ads.internal.util.client.zzf.zzp(th3.getClass().getName());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (com.google.android.gms.ads.internal.util.client.zzf.zzp(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z10 = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z10) {
                    th2 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th2 != null) {
            String name = th.getClass().getName();
            String strZze = zze(th);
            String strZzf = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhV)).booleanValue() ? zzf(th) : "";
            double d10 = f10;
            double dRandom = Math.random();
            int i10 = f10 > 0.0f ? (int) (1.0f / f10) : 1;
            if (dRandom < d10) {
                ArrayList<String> arrayList2 = new ArrayList();
                try {
                    zIsCallerInstantApp = Wrappers.packageManager(this.zzg).isCallerInstantApp();
                } catch (Throwable th4) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("Error fetching instant app info", th4);
                }
                try {
                    packageName = this.zzg.getPackageName();
                } catch (Throwable unused) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Cannot obtain package name, proceeding.");
                    packageName = "unknown";
                }
                Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(zIsCallerInstantApp)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE);
                int i11 = Build.VERSION.SDK_INT;
                Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("api", String.valueOf(i11));
                String str2 = Build.MANUFACTURER;
                String str3 = Build.MODEL;
                if (!str3.startsWith(str2)) {
                    str3 = str2 + " " + str3;
                }
                Uri.Builder builderAppendQueryParameter3 = builderAppendQueryParameter2.appendQueryParameter("device", str3).appendQueryParameter("js", this.zzj.afmaVersion).appendQueryParameter("appid", packageName).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", strZze).appendQueryParameter("eids", TextUtils.join(",", com.google.android.gms.ads.internal.client.zzba.zza().zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "661295874").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i10)).appendQueryParameter("pb_tm", String.valueOf(zzbeb.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzg))).appendQueryParameter("lite", true != this.zzj.isLiteSdk ? "0" : "1");
                if (!TextUtils.isEmpty(strZzf)) {
                    builderAppendQueryParameter3.appendQueryParameter("hash", strZzf);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgW)).booleanValue() && (memoryInfoZzc = com.google.android.gms.ads.internal.util.client.zzf.zzc(this.zzg)) != null) {
                    builderAppendQueryParameter3.appendQueryParameter("available_memory", Long.toString(memoryInfoZzc.availMem));
                    builderAppendQueryParameter3.appendQueryParameter("total_memory", Long.toString(memoryInfoZzc.totalMem));
                    builderAppendQueryParameter3.appendQueryParameter("is_low_memory", true == memoryInfoZzc.lowMemory ? "1" : "0");
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgV)).booleanValue()) {
                    if (!TextUtils.isEmpty(this.zzl)) {
                        builderAppendQueryParameter3.appendQueryParameter("countrycode", this.zzl);
                    }
                    if (!TextUtils.isEmpty(this.zzm)) {
                        builderAppendQueryParameter3.appendQueryParameter("psv", this.zzm);
                    }
                    Context context = this.zzg;
                    if (i11 >= 26) {
                        packageInfo = WebView.getCurrentWebViewPackage();
                    } else if (context == null) {
                        packageInfo = null;
                    } else {
                        try {
                            packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.webview", 128);
                        } catch (PackageManager.NameNotFoundException unused2) {
                            packageInfo = null;
                        }
                    }
                    if (packageInfo != null) {
                        builderAppendQueryParameter3.appendQueryParameter("wvvc", Integer.toString(packageInfo.versionCode));
                        builderAppendQueryParameter3.appendQueryParameter("wvvn", packageInfo.versionName);
                        builderAppendQueryParameter3.appendQueryParameter("wvpn", packageInfo.packageName);
                    }
                }
                PackageInfo packageInfo2 = this.zzk;
                if (packageInfo2 != null) {
                    builderAppendQueryParameter3.appendQueryParameter("appvc", String.valueOf(packageInfo2.versionCode));
                    builderAppendQueryParameter3.appendQueryParameter("appvn", this.zzk.versionName);
                }
                arrayList2.add(builderAppendQueryParameter3.toString());
                for (final String str4 : arrayList2) {
                    final com.google.android.gms.ads.internal.util.client.zzr zzrVar = new com.google.android.gms.ads.internal.util.client.zzr(null);
                    this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbtn
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzrVar.zza(str4);
                        }
                    });
                }
            }
        }
    }

    protected zzbtq(Context context, VersionInfoParcel versionInfoParcel, boolean z10) {
        this(context, versionInfoParcel);
        this.zzo = true;
    }
}
