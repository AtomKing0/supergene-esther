package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.v8;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.e1;
import io.sentry.protocol.Device;
import io.sentry.protocol.OperatingSystem;
import io.sentry.r0;
import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DeviceInfoUtil.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class j1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile j1 f27358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final io.sentry.util.a f27359j = new io.sentry.util.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryAndroidOptions f27361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final w0 f27362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final Boolean f27363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final e1.a f27364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final e1.b f27365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final OperatingSystem f27366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final Long f27367h;

    /* JADX INFO: compiled from: DeviceInfoUtil.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27368a;

        static {
            int[] iArr = new int[r0.a.values().length];
            f27368a = iArr;
            try {
                iArr[r0.a.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27368a[r0.a.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public j1(@NotNull Context context, @NotNull SentryAndroidOptions sentryAndroidOptions) {
        this.f27360a = context;
        this.f27361b = sentryAndroidOptions;
        w0 w0Var = new w0(sentryAndroidOptions.getLogger());
        this.f27362c = w0Var;
        io.sentry.android.core.internal.util.g.a().c();
        this.f27366g = u();
        this.f27363d = w0Var.f();
        this.f27364e = e1.C(context, sentryAndroidOptions.getLogger(), w0Var);
        this.f27365f = e1.D(context, w0Var);
        ActivityManager.MemoryInfo memoryInfoO = e1.o(context, sentryAndroidOptions.getLogger());
        if (memoryInfoO != null) {
            this.f27367h = Long.valueOf(memoryInfoO.totalMem);
        } else {
            this.f27367h = null;
        }
    }

    @Nullable
    private Intent b() {
        return e1.B(this.f27360a, this.f27362c, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @Nullable
    public static Float c(@NotNull Intent intent, @NotNull SentryOptions sentryOptions) {
        try {
            int intExtra = intent.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error getting device battery level.", th);
            return null;
        }
    }

    @Nullable
    private Float d(@NotNull Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(intExtra / 10.0f);
            }
            return null;
        } catch (Throwable th) {
            this.f27361b.getLogger().b(SentryLevel.ERROR, "Error getting battery temperature.", th);
            return null;
        }
    }

    @Nullable
    private Date e() {
        try {
            return io.sentry.n.e(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e10) {
            this.f27361b.getLogger().a(SentryLevel.ERROR, e10, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }

    @Nullable
    private String f() {
        try {
            return o1.a(this.f27360a);
        } catch (Throwable th) {
            this.f27361b.getLogger().b(SentryLevel.ERROR, "Error getting installationId.", th);
            return null;
        }
    }

    @Nullable
    private File g(@Nullable File file) {
        File[] externalFilesDirs = this.f27360a.getExternalFilesDirs(null);
        if (externalFilesDirs != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : externalFilesDirs) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            this.f27361b.getLogger().c(SentryLevel.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }

    @Nullable
    private StatFs h(@Nullable File file) {
        try {
            File fileG = g(file);
            if (fileG != null) {
                return new StatFs(fileG.getPath());
            }
            return null;
        } catch (Throwable unused) {
            this.f27361b.getLogger().c(SentryLevel.INFO, "Not possible to read external files directory", new Object[0]);
            return null;
        }
    }

    @NotNull
    public static j1 i(@NotNull Context context, @NotNull SentryAndroidOptions sentryAndroidOptions) {
        if (f27358i == null) {
            io.sentry.k1 k1VarA = f27359j.a();
            try {
                if (f27358i == null) {
                    f27358i = new j1(e1.h(context), sentryAndroidOptions);
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return f27358i;
    }

    @Nullable
    private Device.DeviceOrientation k() {
        Device.DeviceOrientation deviceOrientationA;
        Throwable th;
        try {
            deviceOrientationA = io.sentry.android.core.internal.util.i.a(this.f27360a.getResources().getConfiguration().orientation);
            if (deviceOrientationA == null) {
                try {
                    this.f27361b.getLogger().c(SentryLevel.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    this.f27361b.getLogger().b(SentryLevel.ERROR, "Error getting device orientation.", th);
                    return deviceOrientationA;
                }
            }
        } catch (Throwable th3) {
            deviceOrientationA = null;
            th = th3;
        }
        return deviceOrientationA;
    }

    @NotNull
    private TimeZone n() {
        if (this.f27362c.d() >= 24) {
            LocaleList locales = this.f27360a.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                return Calendar.getInstance(locales.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }

    @Nullable
    private Long o(@NotNull StatFs statFs) {
        try {
            return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.f27361b.getLogger().b(SentryLevel.ERROR, "Error getting total external storage amount.", th);
            return null;
        }
    }

    @Nullable
    private Long p(@NotNull StatFs statFs) {
        try {
            return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.f27361b.getLogger().b(SentryLevel.ERROR, "Error getting total internal storage amount.", th);
            return null;
        }
    }

    @Nullable
    private Long r(@NotNull StatFs statFs) {
        try {
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.f27361b.getLogger().b(SentryLevel.ERROR, "Error getting unused external storage amount.", th);
            return null;
        }
    }

    @Nullable
    private Long s(@NotNull StatFs statFs) {
        try {
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.f27361b.getLogger().b(SentryLevel.ERROR, "Error getting unused internal storage amount.", th);
            return null;
        }
    }

    @Nullable
    public static Boolean t(@NotNull Intent intent, @NotNull SentryOptions sentryOptions) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z10 = true;
            if (intExtra != 1 && intExtra != 2) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error getting device charging state.", th);
            return null;
        }
    }

    @NotNull
    private OperatingSystem u() {
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setName(v8.f15653d);
        operatingSystem.setVersion(Build.VERSION.RELEASE);
        operatingSystem.setBuild(Build.DISPLAY);
        String strN = e1.n(this.f27361b.getLogger());
        if (strN != null) {
            operatingSystem.setKernelVersion(strN);
        }
        if (this.f27361b.isEnableRootCheck()) {
            operatingSystem.setRooted(Boolean.valueOf(new io.sentry.android.core.internal.util.n(this.f27360a, this.f27362c, this.f27361b.getLogger()).e()));
        }
        return operatingSystem;
    }

    private void v(@NotNull Device device, boolean z10) {
        Intent intentB = b();
        if (intentB != null) {
            device.setBatteryLevel(c(intentB, this.f27361b));
            device.setCharging(t(intentB, this.f27361b));
            device.setBatteryTemperature(d(intentB));
        }
        int i10 = a.f27368a[this.f27361b.getConnectionStatusProvider().a().ordinal()];
        device.setOnline(i10 != 1 ? i10 != 2 ? null : Boolean.TRUE : Boolean.FALSE);
        ActivityManager.MemoryInfo memoryInfoO = e1.o(this.f27360a, this.f27361b.getLogger());
        if (memoryInfoO != null && z10) {
            device.setFreeMemory(Long.valueOf(memoryInfoO.availMem));
            device.setLowMemory(Boolean.valueOf(memoryInfoO.lowMemory));
        }
        File externalFilesDir = this.f27360a.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            device.setStorageSize(p(statFs));
            device.setFreeStorage(s(statFs));
        }
        StatFs statFsH = h(externalFilesDir);
        if (statFsH != null) {
            device.setExternalStorageSize(o(statFsH));
            device.setExternalFreeStorage(r(statFsH));
        }
        if (device.getConnectionType() == null) {
            device.setConnectionType(this.f27361b.getConnectionStatusProvider().getConnectionType());
        }
    }

    @NotNull
    public Device a(boolean z10, boolean z11) {
        Device device = new Device();
        device.setManufacturer(Build.MANUFACTURER);
        device.setBrand(Build.BRAND);
        device.setFamily(e1.m(this.f27361b.getLogger()));
        device.setModel(Build.MODEL);
        device.setModelId(Build.ID);
        device.setArchs(e1.k());
        device.setOrientation(k());
        Boolean bool = this.f27363d;
        if (bool != null) {
            device.setSimulator(bool);
        }
        DisplayMetrics displayMetricsL = e1.l(this.f27360a, this.f27361b.getLogger());
        if (displayMetricsL != null) {
            device.setScreenWidthPixels(Integer.valueOf(displayMetricsL.widthPixels));
            device.setScreenHeightPixels(Integer.valueOf(displayMetricsL.heightPixels));
            device.setScreenDensity(Float.valueOf(displayMetricsL.density));
            device.setScreenDpi(Integer.valueOf(displayMetricsL.densityDpi));
        }
        device.setBootTime(e());
        device.setTimezone(n());
        if (device.getId() == null) {
            device.setId(f());
        }
        Locale locale = Locale.getDefault();
        if (device.getLocale() == null) {
            device.setLocale(locale.toString());
        }
        List<Integer> listC = io.sentry.android.core.internal.util.g.a().c();
        if (!listC.isEmpty()) {
            device.setProcessorFrequency(Double.valueOf(((Integer) Collections.max(listC)).doubleValue()));
            device.setProcessorCount(Integer.valueOf(listC.size()));
        }
        device.setMemorySize(this.f27367h);
        if (z10 && this.f27361b.isCollectAdditionalContext()) {
            v(device, z11);
        }
        return device;
    }

    @NotNull
    public OperatingSystem j() {
        return this.f27366g;
    }

    @Nullable
    public e1.a l() {
        return this.f27364e;
    }

    @Nullable
    public e1.b m() {
        return this.f27365f;
    }

    @Nullable
    public Long q() {
        return this.f27367h;
    }
}
