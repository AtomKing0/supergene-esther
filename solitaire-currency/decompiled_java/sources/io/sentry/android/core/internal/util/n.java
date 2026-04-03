package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import io.sentry.SentryLevel;
import io.sentry.android.core.w0;
import java.io.File;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RootChecker.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Charset f27320g = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f27322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String[] f27324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String[] f27325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final Runtime f27326f;

    public n(@NotNull Context context, @NotNull w0 w0Var, @NotNull io.sentry.w0 w0Var2) {
        this(context, w0Var, w0Var2, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    private boolean a() {
        for (String str : this.f27324d) {
            try {
            } catch (RuntimeException e10) {
                this.f27323c.a(SentryLevel.ERROR, e10, "Error when trying to check if root file %s exists.", str);
            }
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private boolean b(@NotNull io.sentry.w0 w0Var) {
        w0 w0Var2 = new w0(w0Var);
        PackageManager packageManager = this.f27321a.getPackageManager();
        if (packageManager != null) {
            for (String str : this.f27325e) {
                try {
                    if (w0Var2.d() >= 33) {
                        packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
                        return true;
                    }
                    packageManager.getPackageInfo(str, 0);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean c() {
        /*
            r6 = this;
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = r6.f27326f     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            java.lang.Process r2 = r3.exec(r0)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            java.io.InputStream r4 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            java.nio.charset.Charset r5 = io.sentry.android.core.internal.util.n.f27320g     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            java.lang.String r3 = r0.readLine()     // Catch: java.lang.Throwable -> L30
            if (r3 == 0) goto L28
            r3 = 1
            goto L29
        L28:
            r3 = r1
        L29:
            r0.close()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
            r2.destroy()
            return r3
        L30:
            r3 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L35
            goto L39
        L35:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
        L39:
            throw r3     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L4a
        L3a:
            r0 = move-exception
            io.sentry.w0 r3 = r6.f27323c     // Catch: java.lang.Throwable -> L59
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.DEBUG     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = "Error when trying to check if SU exists."
            r3.b(r4, r5, r0)     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L58
        L46:
            r2.destroy()
            goto L58
        L4a:
            io.sentry.w0 r0 = r6.f27323c     // Catch: java.lang.Throwable -> L59
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.DEBUG     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = "SU isn't found on this Device."
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L59
            r0.c(r3, r4, r5)     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L58
            goto L46
        L58:
            return r1
        L59:
            r0 = move-exception
            if (r2 == 0) goto L5f
            r2.destroy()
        L5f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.util.n.c():boolean");
    }

    private boolean d() {
        String strA = this.f27322b.a();
        return strA != null && strA.contains("test-keys");
    }

    public boolean e() {
        return d() || a() || c() || b(this.f27323c);
    }

    n(@NotNull Context context, @NotNull w0 w0Var, @NotNull io.sentry.w0 w0Var2, @NotNull String[] strArr, @NotNull String[] strArr2, @NotNull Runtime runtime) {
        this.f27321a = (Context) io.sentry.util.w.c(context, "The application context is required.");
        this.f27322b = (w0) io.sentry.util.w.c(w0Var, "The BuildInfoProvider is required.");
        this.f27323c = (io.sentry.w0) io.sentry.util.w.c(w0Var2, "The Logger is required.");
        this.f27324d = (String[]) io.sentry.util.w.c(strArr, "The root Files are required.");
        this.f27325e = (String[]) io.sentry.util.w.c(strArr2, "The root packages are required.");
        this.f27326f = (Runtime) io.sentry.util.w.c(runtime, "The Runtime is required.");
    }
}
