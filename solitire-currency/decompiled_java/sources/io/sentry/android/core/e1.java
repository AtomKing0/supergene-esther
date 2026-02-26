package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.util.a;
import io.sentry.protocol.App;
import io.sentry.util.r;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContextUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final io.sentry.util.r<Boolean> f27148a = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.android.core.y0
        @Override // io.sentry.util.r.a
        public final Object a() {
            return e1.u();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    @NotNull
    private static final io.sentry.android.core.util.a<PackageInfo> f27149b = new io.sentry.android.core.util.a<>(new a.InterfaceC0581a() { // from class: io.sentry.android.core.z0
        @Override // io.sentry.android.core.util.a.InterfaceC0581a
        public final Object a(Context context) {
            return e1.v(context);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final io.sentry.android.core.util.a<PackageInfo> f27150c = new io.sentry.android.core.util.a<>(new a.InterfaceC0581a() { // from class: io.sentry.android.core.a1
        @Override // io.sentry.android.core.util.a.InterfaceC0581a
        public final Object a(Context context) {
            return e1.w(context);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final io.sentry.android.core.util.a<String> f27151d = new io.sentry.android.core.util.a<>(new a.InterfaceC0581a() { // from class: io.sentry.android.core.b1
        @Override // io.sentry.android.core.util.a.InterfaceC0581a
        public final Object a(Context context) {
            return e1.x(context);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    @NotNull
    private static final io.sentry.android.core.util.a<ApplicationInfo> f27152e = new io.sentry.android.core.util.a<>(new a.InterfaceC0581a() { // from class: io.sentry.android.core.c1
        @Override // io.sentry.android.core.util.a.InterfaceC0581a
        public final Object a(Context context) {
            return e1.y(context);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final io.sentry.android.core.util.a<ApplicationInfo> f27153f = new io.sentry.android.core.util.a<>(new a.InterfaceC0581a() { // from class: io.sentry.android.core.d1
        @Override // io.sentry.android.core.util.a.InterfaceC0581a
        public final Object a(Context context) {
            return e1.z(context);
        }
    });

    /* JADX INFO: compiled from: ContextUtils.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f27155b;

        public a(boolean z10, @Nullable String str) {
            this.f27154a = z10;
            this.f27155b = str;
        }

        @NotNull
        public Map<String, String> a() {
            HashMap map = new HashMap();
            map.put("isSideLoaded", String.valueOf(this.f27154a));
            String str = this.f27155b;
            if (str != null) {
                map.put("installerStore", str);
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: ContextUtils.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f27157b;

        public b(boolean z10, String[] strArr) {
            this.f27156a = z10;
            this.f27157b = strArr;
        }

        @Nullable
        public String[] a() {
            return this.f27157b;
        }

        public boolean b() {
            return this.f27156a;
        }
    }

    @Nullable
    static Intent A(@NotNull Context context, @NotNull SentryOptions sentryOptions, @Nullable BroadcastReceiver broadcastReceiver, @NotNull IntentFilter intentFilter) {
        return B(context, new w0(sentryOptions.getLogger()), broadcastReceiver, intentFilter);
    }

    @SuppressLint({"NewApi", "UnspecifiedRegisterReceiverFlag"})
    @Nullable
    static Intent B(@NotNull Context context, @NotNull w0 w0Var, @Nullable BroadcastReceiver broadcastReceiver, @NotNull IntentFilter intentFilter) {
        return w0Var.d() >= 33 ? context.registerReceiver(broadcastReceiver, intentFilter, 4) : context.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Nullable
    static a C(@NotNull Context context, @NotNull io.sentry.w0 w0Var, @NotNull w0 w0Var2) {
        String str;
        try {
            PackageInfo packageInfoQ = q(context, w0Var2);
            PackageManager packageManager = context.getPackageManager();
            if (packageInfoQ != null && packageManager != null) {
                str = packageInfoQ.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    return new a(installerPackageName == null, installerPackageName);
                } catch (IllegalArgumentException unused) {
                    w0Var.c(SentryLevel.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
        }
        return null;
    }

    @Nullable
    static b D(@NotNull Context context, @NotNull w0 w0Var) {
        Bundle bundle;
        ApplicationInfo applicationInfoI = i(context, w0Var);
        PackageInfo packageInfoQ = q(context, w0Var);
        if (packageInfoQ == null) {
            return null;
        }
        return new b((applicationInfoI == null || (bundle = applicationInfoI.metaData) == null) ? false : bundle.getBoolean("com.android.vending.splits.required"), packageInfoQ.splitNames);
    }

    static void E(@NotNull PackageInfo packageInfo, @NotNull w0 w0Var, @Nullable j1 j1Var, @NotNull App app) {
        app.setAppIdentifier(packageInfo.packageName);
        app.setAppVersion(packageInfo.versionName);
        app.setAppBuild(r(packageInfo, w0Var));
        HashMap map = new HashMap();
        String[] strArr = packageInfo.requestedPermissions;
        int[] iArr = packageInfo.requestedPermissionsFlags;
        if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                String str = strArr[i10];
                map.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i10] & 2) == 2 ? "granted" : "not_granted");
            }
        }
        app.setPermissions(map);
        if (j1Var != null) {
            try {
                b bVarM = j1Var.m();
                if (bVarM != null) {
                    app.setSplitApks(Boolean.valueOf(bVarM.b()));
                    if (bVarM.a() != null) {
                        app.setSplitNames(Arrays.asList(bVarM.a()));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @ApiStatus.Internal
    public static boolean g(@NotNull Context context) {
        if (!context.getPackageName().endsWith(".test")) {
            return false;
        }
        try {
            Iterator<ActivityManager.AppTask> it = ((ActivityManager) context.getSystemService("activity")).getAppTasks().iterator();
            while (it.hasNext()) {
                ComponentName component = it.next().getTaskInfo().baseIntent.getComponent();
                if (component != null && component.getClassName().equals("androidx.compose.ui.tooling.PreviewActivity")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @NotNull
    public static Context h(@NotNull Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    @SuppressLint({"NewApi"})
    @Nullable
    static ApplicationInfo i(@NotNull Context context, @NotNull w0 w0Var) {
        return w0Var.d() >= 33 ? f27152e.a(context) : f27153f.a(context);
    }

    @Nullable
    static String j(@NotNull Context context) {
        return f27151d.a(context);
    }

    @NotNull
    static String[] k() {
        return Build.SUPPORTED_ABIS;
    }

    @Nullable
    static DisplayMetrics l(@NotNull Context context, @NotNull io.sentry.w0 w0Var) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Error getting DisplayMetrics.", th);
            return null;
        }
    }

    @Nullable
    static String m(@NotNull io.sentry.w0 w0Var) {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    @Nullable
    static String n(@NotNull io.sentry.w0 w0Var) {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                return line;
            } finally {
            }
        } catch (IOException e10) {
            w0Var.b(SentryLevel.ERROR, "Exception while attempting to read kernel information", e10);
            return property;
        }
    }

    @Nullable
    static ActivityManager.MemoryInfo o(@NotNull Context context, @NotNull io.sentry.w0 w0Var) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            w0Var.c(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    @Nullable
    static PackageInfo p(@NotNull Context context, int i10, @NotNull io.sentry.w0 w0Var, @NotNull w0 w0Var2) {
        try {
            return w0Var2.d() >= 33 ? context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(i10)) : context.getPackageManager().getPackageInfo(context.getPackageName(), i10);
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    @Nullable
    static PackageInfo q(@NotNull Context context, @NotNull w0 w0Var) {
        return w0Var.d() >= 33 ? f27149b.a(context) : f27150c.a(context);
    }

    @SuppressLint({"NewApi"})
    @NotNull
    static String r(@NotNull PackageInfo packageInfo, @NotNull w0 w0Var) {
        return w0Var.d() >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : s(packageInfo);
    }

    @NotNull
    private static String s(@NotNull PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    @ApiStatus.Internal
    public static boolean t() {
        return f27148a.a().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean u() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return Boolean.valueOf(runningAppProcessInfo.importance == 100);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PackageInfo v(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PackageInfo w(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String x(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i10 = applicationInfo.labelRes;
            if (i10 != 0) {
                return context.getString(i10);
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            return charSequence != null ? charSequence.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ApplicationInfo y(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ApplicationInfo z(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable unused) {
            return null;
        }
    }
}
