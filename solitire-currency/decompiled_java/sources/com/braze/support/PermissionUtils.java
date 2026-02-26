package com.braze.support;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import bo.app.a60;
import bo.app.b60;
import bo.app.c60;
import bo.app.d60;
import bo.app.e60;
import bo.app.t50;
import bo.app.u50;
import bo.app.v50;
import bo.app.w50;
import bo.app.x50;
import bo.app.y50;
import bo.app.z50;
import com.braze.support.BrazeLogger;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class PermissionUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("PermissionUtils");

    public static final int getPermissionRequestCount(Context context, String permission) {
        t.i(context, "context");
        t.i(permission, "permission");
        return context.getSharedPreferences("com.braze.support.permission_util.requested_perms", 0).getInt(permission, 0);
    }

    public static final boolean hasPermission(Context context, String permission) {
        t.i(permission, "permission");
        if (context == null) {
            return false;
        }
        try {
            return context.checkCallingOrSelfPermission(permission) == 0;
        } catch (Throwable th) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, th, false, (h9.a) new t50(permission), 8, (Object) null);
            return false;
        }
    }

    public static final void incrementPermissionRequestCount(Context context, String permission) {
        t.i(context, "context");
        t.i(permission, "permission");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.support.permission_util.requested_perms", 0);
        int i10 = sharedPreferences.getInt(permission, 0) + 1;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new u50(i10), 14, (Object) null);
        sharedPreferences.edit().putInt(permission, i10).apply();
    }

    public static final void requestPushPermissionPrompt(Activity activity) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        String str = TAG;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, str, priority, (Throwable) null, false, (h9.a) v50.f4073a, 12, (Object) null);
        if (activity == null) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) w50.f4167a, 14, (Object) null);
            return;
        }
        if (!wouldPushPermissionPromptDisplay(activity) || Build.VERSION.SDK_INT < 33) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) x50.f4244a, 14, (Object) null);
            return;
        }
        incrementPermissionRequestCount(activity, "android.permission.POST_NOTIFICATIONS");
        BrazeLogger.brazelog$default(brazeLogger, str, priority, (Throwable) null, false, (h9.a) y50.f4326a, 12, (Object) null);
        activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, IntentUtils.getRequestCode());
    }

    public static final boolean wouldPushPermissionPromptDisplay(Activity activity) {
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) z50.f4402a, 14, (Object) null);
            return false;
        }
        if (Build.VERSION.SDK_INT < 33) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) a60.f2354a, 12, (Object) null);
            return false;
        }
        int i10 = activity.getApplicationInfo().targetSdkVersion;
        if (i10 < 33) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new b60(i10), 12, (Object) null);
            return false;
        }
        if (hasPermission(activity, "android.permission.POST_NOTIFICATIONS")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) c60.f2487a, 12, (Object) null);
            return false;
        }
        int permissionRequestCount = getPermissionRequestCount(activity, "android.permission.POST_NOTIFICATIONS");
        if (permissionRequestCount >= 2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new d60(permissionRequestCount), 12, (Object) null);
            return activity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS");
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) e60.f2710a, 12, (Object) null);
        return true;
    }
}
