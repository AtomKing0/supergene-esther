package com.braze.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import bo.app.v30;
import bo.app.w30;
import com.braze.support.BrazeLogger;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.t;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils {
    public static final IntentUtils INSTANCE = new IntentUtils();
    private static final l random$delegate = n.b(p.f35203c, w30.f4164a);

    private IntentUtils() {
    }

    public static final void addComponentAndSendBroadcast(Context context, Intent intent) {
        t.i(context, "context");
        t.i(intent, "intent");
        List<ResolveInfo> listQueryBroadcastReceivers = Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().queryBroadcastReceivers(intent, PackageManager.ResolveInfoFlags.of(0L)) : context.getPackageManager().queryBroadcastReceivers(intent, 0);
        t.h(listQueryBroadcastReceivers, "if (Build.VERSION.SDK_IN…vers(intent, 0)\n        }");
        for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
            Intent intent2 = new Intent(intent);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent2.setComponent(componentName);
            context.sendBroadcast(intent2);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new v30(componentName, intent2), 6, (Object) null);
        }
    }

    public static final int getImmutablePendingIntentFlags() {
        return AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    }

    public static final int getMutablePendingIntentFlags() {
        return Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    private final Random getRandom() {
        return (Random) random$delegate.getValue();
    }

    public static final int getRequestCode() {
        return INSTANCE.getRandom().nextInt(1073741823) + 100000;
    }
}
