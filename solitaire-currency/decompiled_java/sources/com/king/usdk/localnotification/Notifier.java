package com.king.usdk.localnotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.king.usdk.localnotification.notificationcommand.Debug;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Notifier {
    private static final String CHANNEL_ID = "king-notification";
    private static final String ICON_COLOR_KEY = "com.king.notification.icon.small.color";
    private static final String ICON_LARGE_KEY = "com.king.notification.icon.large";
    private static final String ICON_SMALL_KEY = "com.king.notification.icon.small";
    public static final int LOCAL_NOTIFICATION = 1;
    public static final String NOTIFICATION_DISCARDED_ACTION = "com.king.usdk.localnotification.NOTIFICATION_DISCARDED";
    public static final String NOTIFICATION_KEY = "NOTIFICATION";
    private static final String TAG = "Notifier";
    private final Context mContext;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17185a;

        a(int i10) {
            this.f17185a = i10 << 1;
        }

        int a() {
            return this.f17185a + 1;
        }

        int b() {
            return this.f17185a;
        }
    }

    public Notifier(Context context) {
        this.mContext = context;
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = this.mContext.getString(d.f17198b);
            String string2 = this.mContext.getString(d.f17197a);
            NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, string, 3);
            notificationChannel.setDescription(string2);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private int getIconColorFromMetaData() {
        return getResourceIdFromMetaData(ICON_COLOR_KEY);
    }

    private Bitmap getLargeIconBitmap() {
        int largeIconId = getLargeIconId();
        if (largeIconId != 0) {
            return BitmapFactory.decodeResource(this.mContext.getResources(), largeIconId);
        }
        return null;
    }

    private int getLargeIconId() {
        int resourceIdFromMetaData = getResourceIdFromMetaData(ICON_LARGE_KEY);
        return resourceIdFromMetaData == 0 ? this.mContext.getApplicationInfo().icon : resourceIdFromMetaData;
    }

    private Intent getOpenGameIntent(Class<?> cls, int i10, LocalNotificationData localNotificationData) {
        Intent intent = new Intent(this.mContext, cls);
        intent.setFlags(603979776);
        intent.putExtra(NOTIFICATION_KEY, 1);
        intent.putExtra("msg", localNotificationData.message);
        intent.putExtra(NotificationSchedulerKeys.KEY_TITLE_KEY, localNotificationData.titleKey);
        intent.putExtra(NotificationSchedulerKeys.KEY_TRACKING_TYPE, localNotificationData.trackingType);
        intent.putExtra("id", i10);
        intent.putExtra(NotificationSchedulerKeys.KEY_DEEPLINK, localNotificationData.deeplink);
        return intent;
    }

    private int getResourceIdFromMetaData(String str) {
        try {
            return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData.getInt(str);
        } catch (PackageManager.NameNotFoundException unused) {
            AndroidLogger.i(TAG, "Parameter " + str + " Not found.");
            return 0;
        }
    }

    private Intent getResultIntent(int i10, String str, LocalNotificationData localNotificationData) {
        try {
            return getOpenGameIntent(Class.forName(str), i10, localNotificationData);
        } catch (Exception unused) {
            AndroidLogger.i(TAG, "Could not find class name. LocalNotificationData ignored.");
            LocalNotificationModule.addAndTryFlushNotificationTrackingEvent(new Debug(0L, "Notifier.getResultIntent", "Could not find class name " + str + ". LocalNotificationData ignored."));
            return null;
        }
    }

    private int getSmallIconId() {
        int resourceIdFromMetaData = getResourceIdFromMetaData(ICON_SMALL_KEY);
        return resourceIdFromMetaData == 0 ? this.mContext.getApplicationInfo().icon : resourceIdFromMetaData;
    }

    private boolean hasVibratePermission() {
        return this.mContext.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0;
    }

    private boolean isIconColorInMetaData() {
        return isValueInMetaData(ICON_COLOR_KEY);
    }

    private boolean isValueInMetaData(String str) {
        try {
            return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData.containsKey(str);
        } catch (PackageManager.NameNotFoundException unused) {
            AndroidLogger.i(TAG, "Parameter " + str + " Not found.");
            return false;
        }
    }

    private Bitmap loadImage(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0047: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:72), block:B:19:0x0047 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap loadImageFromURL(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r2 = 1
            r1.setDoInput(r2)     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L46
            r1.connect()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L46
            java.io.InputStream r2 = r1.getInputStream()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L46
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L46
            r1.disconnect()
            return r7
        L1f:
            r2 = move-exception
            goto L25
        L21:
            r7 = move-exception
            goto L48
        L23:
            r2 = move-exception
            r1 = r0
        L25:
            java.lang.String r3 = com.king.usdk.localnotification.Notifier.TAG     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
            r4.<init>()     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "Image "
            r4.append(r5)     // Catch: java.lang.Throwable -> L46
            r4.append(r7)     // Catch: java.lang.Throwable -> L46
            java.lang.String r7 = " can't be loaded"
            r4.append(r7)     // Catch: java.lang.Throwable -> L46
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L46
            com.king.usdk.localnotification.AndroidLogger.ex(r3, r7, r2)     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto L45
            r1.disconnect()
        L45:
            return r0
        L46:
            r7 = move-exception
            r0 = r1
        L48:
            if (r0 == 0) goto L4d
            r0.disconnect()
        L4d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.usdk.localnotification.Notifier.loadImageFromURL(java.lang.String):android.graphics.Bitmap");
    }

    public void cancelAllNotifications() {
        ((NotificationManager) this.mContext.getSystemService("notification")).cancelAll();
    }

    RemoteViews createRemoteView(int i10, LocalNotificationData localNotificationData) {
        String str = new SimpleDateFormat("hh:mm").format(new Date());
        RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), i10);
        remoteViews.setTextViewText(b.f17194f, localNotificationData.title);
        remoteViews.setTextViewText(b.f17193e, str);
        remoteViews.setTextViewText(b.f17192d, localNotificationData.message);
        return remoteViews;
    }

    int getNotificationType() {
        return !hasVibratePermission() ? -3 : -1;
    }

    void setBackGround(RemoteViews remoteViews, Bitmap bitmap, int i10) {
        remoteViews.setImageViewBitmap(b.f17189a, bitmap);
        remoteViews.setTextColor(b.f17194f, i10);
        remoteViews.setTextColor(b.f17193e, i10);
        remoteViews.setTextColor(b.f17192d, i10);
    }

    void setRemoteViews(NotificationCompat.Builder builder, LocalNotificationData localNotificationData, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        RemoteViews remoteViewsCreateRemoteView;
        RemoteViews remoteViewsCreateRemoteView2 = createRemoteView(c.f17196b, localNotificationData);
        if (bitmap2 != null) {
            remoteViewsCreateRemoteView = createRemoteView(c.f17195a, localNotificationData);
            remoteViewsCreateRemoteView.setImageViewBitmap(b.f17191c, bitmap2);
        } else {
            remoteViewsCreateRemoteView = null;
        }
        if (bitmap != null) {
            int i10 = b.f17190b;
            remoteViewsCreateRemoteView2.setImageViewBitmap(i10, bitmap);
            if (remoteViewsCreateRemoteView != null) {
                remoteViewsCreateRemoteView.setImageViewBitmap(i10, bitmap);
            }
        }
        setBackGround(remoteViewsCreateRemoteView2, bitmap3, localNotificationData.textColor);
        builder.setCustomContentView(remoteViewsCreateRemoteView2);
        if (remoteViewsCreateRemoteView != null) {
            remoteViewsCreateRemoteView2 = remoteViewsCreateRemoteView;
        }
        builder.setCustomBigContentView(remoteViewsCreateRemoteView2);
    }

    public void showNotification(LocalNotificationData localNotificationData) {
        createChannel();
        NotificationCompat.Builder defaults = new NotificationCompat.Builder(this.mContext, CHANNEL_ID).setAutoCancel(true).setContentTitle(localNotificationData.title).setContentText(localNotificationData.message).setDefaults(getNotificationType());
        a aVar = new a(localNotificationData.notificationId);
        Intent resultIntent = getResultIntent(aVar.b(), localNotificationData.activityClassName, localNotificationData);
        if (resultIntent == null) {
            AndroidLogger.d(Notifier.class.getSimpleName(), "Result Intent Null, could not show Notification");
            LocalNotificationModule.addAndTryFlushNotificationTrackingEvent(new Debug(0L, "Notifier.showNotification", "Result Intent Null, could not show Notification"));
            return;
        }
        defaults.setContentIntent(PendingIntent.getActivity(this.mContext.getApplicationContext(), aVar.b(), resultIntent, 201326592));
        Intent resultIntent2 = getResultIntent(aVar.a(), LocalNotificationBroadcastReceiver.class.getName(), localNotificationData);
        if (resultIntent2 == null) {
            AndroidLogger.d(Notifier.class.getSimpleName(), "Discarded Intent Null, could not show Notification");
            LocalNotificationModule.addAndTryFlushNotificationTrackingEvent(new Debug(0L, "Notifier.showNotification", "Discarded Intent Null, could not show Notification"));
            return;
        }
        resultIntent2.setFlags(0);
        resultIntent2.setAction(NOTIFICATION_DISCARDED_ACTION);
        defaults.setDeleteIntent(PendingIntent.getBroadcast(this.mContext.getApplicationContext(), aVar.a(), resultIntent2, 201326592));
        int smallIconId = getSmallIconId();
        if (smallIconId != 0) {
            defaults.setSmallIcon(smallIconId);
        }
        if (isIconColorInMetaData()) {
            defaults.setColor(getIconColorFromMetaData());
        }
        Bitmap largeIconBitmap = getLargeIconBitmap();
        if (largeIconBitmap != null) {
            defaults.setLargeIcon(largeIconBitmap);
        }
        Bitmap bitmapLoadImage = loadImage(localNotificationData.mediaPath);
        Bitmap bitmapLoadImage2 = loadImage(localNotificationData.backgroundPath);
        if (bitmapLoadImage2 != null) {
            setRemoteViews(defaults, localNotificationData, largeIconBitmap, bitmapLoadImage, bitmapLoadImage2);
        } else if (bitmapLoadImage != null) {
            defaults.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmapLoadImage).setSummaryText(localNotificationData.message));
        } else {
            defaults.setStyle(new NotificationCompat.BigTextStyle().bigText(localNotificationData.message));
        }
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (notificationManager == null) {
            LocalNotificationModule.addAndTryFlushNotificationTrackingEvent(new Debug(0L, "Notifier.showNotification", "Notification Manager Null, could not show Notification"));
            return;
        }
        AndroidLogger.i(TAG, "NotificationManager.Notify notificationId: " + localNotificationData.notificationId + " TrackingType:'" + localNotificationData.trackingType + "'");
        notificationManager.notify(localNotificationData.notificationId, defaults.build());
    }
}
