package com.braze.support;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import bo.app.yz;
import com.braze.support.BrazeLogger;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8120a = new h();

    public static final boolean a(Context context) {
        t.i(context, "context");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getPackageManager().getPackageInfo("com.google.android.gsf", PackageManager.PackageInfoFlags.of(0L));
            } else {
                context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f8120a, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) yz.f4387a, 4, (Object) null);
            return false;
        }
    }
}
