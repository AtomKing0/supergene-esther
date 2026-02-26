package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class w {
    @NotNull
    public static final PackageInfo a(@NotNull Context context) throws PackageManager.NameNotFoundException {
        kotlin.jvm.internal.t.i(context, "<this>");
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
            kotlin.jvm.internal.t.h(packageInfo, "{\n        packageManager…ageInfoFlags.of(0))\n    }");
            return packageInfo;
        }
        PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        kotlin.jvm.internal.t.h(packageInfo2, "{\n        packageManager…nfo(packageName, 0)\n    }");
        return packageInfo2;
    }
}
