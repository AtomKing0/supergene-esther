package io.sentry.android.core;

import android.os.Build;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BuildInfoProvider.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    final io.sentry.w0 f27553a;

    public w0(@NotNull io.sentry.w0 w0Var) {
        this.f27553a = (io.sentry.w0) io.sentry.util.w.c(w0Var, "The ILogger object is required.");
    }

    @Nullable
    public String a() {
        return Build.TAGS;
    }

    @Nullable
    public String b() {
        return Build.MANUFACTURER;
    }

    @Nullable
    public String c() {
        return Build.MODEL;
    }

    public int d() {
        return Build.VERSION.SDK_INT;
    }

    @Nullable
    public String e() {
        return Build.VERSION.RELEASE;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Boolean f() {
        /*
            r4 = this;
            java.lang.String r0 = "google_sdk"
            java.lang.String r1 = "generic"
            java.lang.String r2 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L99
            boolean r2 = r2.startsWith(r1)     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L14
            java.lang.String r2 = android.os.Build.DEVICE     // Catch: java.lang.Throwable -> L99
            boolean r2 = r2.startsWith(r1)     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L93
        L14:
            java.lang.String r2 = android.os.Build.FINGERPRINT     // Catch: java.lang.Throwable -> L99
            boolean r1 = r2.startsWith(r1)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L93
            java.lang.String r1 = "unknown"
            boolean r1 = r2.startsWith(r1)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L93
            java.lang.String r1 = android.os.Build.HARDWARE     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "goldfish"
            boolean r2 = r1.contains(r2)     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L93
            java.lang.String r2 = "ranchu"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L93
            java.lang.String r1 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> L99
            boolean r2 = r1.contains(r0)     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L93
            java.lang.String r2 = "Emulator"
            boolean r2 = r1.contains(r2)     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L93
            java.lang.String r2 = "Android SDK built for x86"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L93
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "Genymotion"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L93
            java.lang.String r1 = android.os.Build.PRODUCT     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "sdk_google"
            boolean r2 = r1.contains(r2)     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L93
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto L93
            java.lang.String r0 = "sdk"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto L93
            java.lang.String r0 = "sdk_x86"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto L93
            java.lang.String r0 = "vbox86p"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto L93
            java.lang.String r0 = "emulator"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto L93
            java.lang.String r0 = "simulator"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L91
            goto L93
        L91:
            r0 = 0
            goto L94
        L93:
            r0 = 1
        L94:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L99
            return r0
        L99:
            r0 = move-exception
            io.sentry.w0 r1 = r4.f27553a
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.ERROR
            java.lang.String r3 = "Error checking whether application is running in an emulator."
            r1.b(r2, r3, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.w0.f():java.lang.Boolean");
    }
}
