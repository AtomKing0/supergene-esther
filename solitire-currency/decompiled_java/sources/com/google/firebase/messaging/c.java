package com.google.firebase.messaging;

import android.R;
import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CommonNotificationBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f10372a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* JADX INFO: compiled from: CommonNotificationBuilder.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NotificationCompat.Builder f10373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10375c;

        a(NotificationCompat.Builder builder, String str, int i10) {
            this.f10373a = builder;
            this.f10374b = str;
            this.f10375c = i10;
        }
    }

    @Nullable
    private static PendingIntent a(Context context, k0 k0Var, String str, PackageManager packageManager) {
        Intent intentF = f(str, k0Var, packageManager);
        if (intentF == null) {
            return null;
        }
        intentF.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        intentF.putExtras(k0Var.y());
        if (q(k0Var)) {
            intentF.putExtra("gcm.n.analytics_data", k0Var.x());
        }
        return PendingIntent.getActivity(context, g(), intentF, l(1073741824));
    }

    @Nullable
    private static PendingIntent b(Context context, Context context2, k0 k0Var) {
        if (q(k0Var)) {
            return c(context, context2, new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS).putExtras(k0Var.x()));
        }
        return null;
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(context2.getPackageName()).putExtra(CloudMessagingReceiver.IntentKeys.WRAPPED_INTENT, intent), l(1073741824));
    }

    public static a d(Context context, Context context2, k0 k0Var, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, str);
        String strN = k0Var.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(strN)) {
            builder.setContentTitle(strN);
        }
        String strN2 = k0Var.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(strN2)) {
            builder.setContentText(strN2);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(strN2));
        }
        builder.setSmallIcon(m(packageManager, resources, packageName, k0Var.p("gcm.n.icon"), bundle));
        Uri uriN = n(packageName, k0Var, resources);
        if (uriN != null) {
            builder.setSound(uriN);
        }
        builder.setContentIntent(a(context, k0Var, packageName, packageManager));
        PendingIntent pendingIntentB = b(context, context2, k0Var);
        if (pendingIntentB != null) {
            builder.setDeleteIntent(pendingIntentB);
        }
        Integer numH = h(context2, k0Var.p("gcm.n.color"), bundle);
        if (numH != null) {
            builder.setColor(numH.intValue());
        }
        builder.setAutoCancel(!k0Var.a("gcm.n.sticky"));
        builder.setLocalOnly(k0Var.a("gcm.n.local_only"));
        String strP = k0Var.p("gcm.n.ticker");
        if (strP != null) {
            builder.setTicker(strP);
        }
        Integer numM = k0Var.m();
        if (numM != null) {
            builder.setPriority(numM.intValue());
        }
        Integer numR = k0Var.r();
        if (numR != null) {
            builder.setVisibility(numR.intValue());
        }
        Integer numL = k0Var.l();
        if (numL != null) {
            builder.setNumber(numL.intValue());
        }
        Long lJ = k0Var.j("gcm.n.event_time");
        if (lJ != null) {
            builder.setShowWhen(true);
            builder.setWhen(lJ.longValue());
        }
        long[] jArrQ = k0Var.q();
        if (jArrQ != null) {
            builder.setVibrate(jArrQ);
        }
        int[] iArrE = k0Var.e();
        if (iArrE != null) {
            builder.setLights(iArrE[0], iArrE[1], iArrE[2]);
        }
        builder.setDefaults(i(k0Var));
        return new a(builder, o(k0Var), 0);
    }

    static a e(Context context, k0 k0Var) {
        Bundle bundleJ = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, k0Var, k(context, k0Var.k(), bundleJ), bundleJ);
    }

    private static Intent f(String str, k0 k0Var, PackageManager packageManager) {
        String strP = k0Var.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(strP)) {
            Intent intent = new Intent(strP);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri uriF = k0Var.f();
        if (uriF != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(uriF);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return f10372a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i10 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i10 == 0) {
            return null;
        }
        try {
            return Integer.valueOf(ContextCompat.getColor(context, i10));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int i(k0 k0Var) {
        boolean zA = k0Var.a("gcm.n.default_sound");
        ?? r02 = zA;
        if (k0Var.a("gcm.n.default_vibrate_timings")) {
            r02 = (zA ? 1 : 0) | 2;
        }
        return k0Var.a("gcm.n.default_light_settings") ? r02 | 4 : r02;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e10);
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    @VisibleForTesting
    public static String k(Context context, String str, Bundle bundle) {
        String string;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string2)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else {
                if (notificationManager.getNotificationChannel(string2) != null) {
                    return string2;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", TypedValues.Custom.S_STRING, context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    string = "Misc";
                } else {
                    string = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", string, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i10) {
        return i10 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i10 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i10 == 0 || !p(resources, i10)) {
            try {
                i10 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e10) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e10);
            }
        }
        return (i10 == 0 || !p(resources, i10)) ? R.drawable.sym_def_app_icon : i10;
    }

    private static Uri n(String str, k0 k0Var, Resources resources) {
        String strO = k0Var.o();
        if (TextUtils.isEmpty(strO)) {
            return null;
        }
        if ("default".equals(strO) || resources.getIdentifier(strO, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + strO);
    }

    private static String o(k0 k0Var) {
        String strP = k0Var.p("gcm.n.tag");
        if (!TextUtils.isEmpty(strP)) {
            return strP;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    @TargetApi(26)
    private static boolean p(Resources resources, int i10) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i10, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i10);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i10 + ", treating it as an invalid icon");
            return false;
        }
    }

    static boolean q(@NonNull k0 k0Var) {
        return k0Var.a("google.c.a.e");
    }
}
