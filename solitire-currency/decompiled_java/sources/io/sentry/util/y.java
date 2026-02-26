package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f28378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f28379b;

    static {
        try {
            f28378a = "The Android Project".equals(System.getProperty("java.vendor"));
        } catch (Throwable unused) {
            f28378a = false;
        }
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                f28379b = Double.valueOf(property).doubleValue() >= 9.0d;
            } else {
                f28379b = false;
            }
        } catch (Throwable unused2) {
            f28379b = false;
        }
    }

    public static boolean a() {
        return f28378a;
    }

    public static boolean b() {
        return f28379b;
    }

    public static boolean c() {
        return !f28378a;
    }
}
