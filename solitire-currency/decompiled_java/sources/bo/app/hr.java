package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.pm.PackageInfoCompat;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class hr implements o00 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final br f2993f = new br();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BrazeConfigurationProvider f2995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f2997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PackageInfo f2998e;

    public hr(Context context, BrazeConfigurationProvider configurationProvider) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
        this.f2994a = context;
        this.f2995b = configurationProvider;
        PackageInfo packageInfoC = c();
        this.f2996c = packageInfoC != null ? packageInfoC.versionName : null;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.managers.device_data_provider", 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f2997d = sharedPreferences;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final bo.app.nq a() {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.hr.a():bo.app.nq");
    }

    public final String b() {
        PackageInfo packageInfoC = c();
        if (packageInfoC == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) dr.f2678a, 7, (Object) null);
            return null;
        }
        return (Build.VERSION.SDK_INT >= 28 ? packageInfoC.getLongVersionCode() : PackageInfoCompat.getLongVersionCode(packageInfoC)) + ".0.0.0";
    }

    public final PackageInfo c() {
        PackageInfo packageInfo = this.f2998e;
        if (packageInfo != null) {
            return packageInfo;
        }
        String packageName = this.f2994a.getPackageName();
        try {
            PackageInfo packageInfo2 = Build.VERSION.SDK_INT >= 33 ? this.f2994a.getPackageManager().getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0L)) : this.f2994a.getPackageManager().getPackageInfo(packageName, 0);
            this.f2998e = packageInfo2;
            return packageInfo2;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new gr(packageName), 4, (Object) null);
            ApplicationInfo applicationInfo = this.f2994a.getApplicationInfo();
            PackageInfo packageArchiveInfo = Build.VERSION.SDK_INT >= 33 ? this.f2994a.getPackageManager().getPackageArchiveInfo(applicationInfo.sourceDir, PackageManager.PackageInfoFlags.of(0L)) : this.f2994a.getPackageManager().getPackageArchiveInfo(applicationInfo.sourceDir, 0);
            this.f2998e = packageArchiveInfo;
            return packageArchiveInfo;
        }
    }
}
