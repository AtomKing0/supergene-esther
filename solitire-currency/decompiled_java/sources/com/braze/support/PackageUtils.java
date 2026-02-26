package com.braze.support;

import android.content.Context;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class PackageUtils {
    public static final PackageUtils INSTANCE = new PackageUtils();
    private static String packageName;

    private PackageUtils() {
    }

    public static final String getResourcePackageName(Context context) {
        t.i(context, "context");
        String str = packageName;
        if (str != null) {
            return str;
        }
        String packageName2 = context.getPackageName();
        packageName = packageName2;
        return packageName2 == null ? "unknown.package" : packageName2;
    }
}
