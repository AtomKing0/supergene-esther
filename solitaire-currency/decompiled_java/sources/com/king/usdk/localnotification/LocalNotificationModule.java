package com.king.usdk.localnotification;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Keep;
import com.king.usdk.localnotification.notificationcommand.NotificationCommand;
import com.king.usdk.logger.Logger;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class LocalNotificationModule {
    private static final String TAG = "LocalNotificationModule";
    private static final BlockingQueue<NotificationCommand> sMainThreadCallbacks = new LinkedBlockingQueue();
    private static LocalNotificationModule sNotificationModuleInstance;
    private final Logger mLogger;
    private final Lock mNativeCallbackLock = new ReentrantLock();
    private long mNotificationModulePointer;
    private final NotificationScheduler mNotificationScheduler;
    private final Notifier mNotifier;

    public LocalNotificationModule(Activity activity, long j10, long j11, boolean z10) {
        Logger logger = new Logger(j11, z10);
        this.mLogger = logger;
        this.mNotificationModulePointer = j10;
        this.mNotificationScheduler = new JobScheduler(activity, logger);
        this.mNotifier = new Notifier(activity.getApplicationContext());
        sNotificationModuleInstance = this;
    }

    public static void addAndTryFlushNotificationTrackingEvent(NotificationCommand notificationCommand) {
        queueNotificationTrackingEvent(notificationCommand);
        LocalNotificationModule localNotificationModule = getInstance();
        if (localNotificationModule != null) {
            localNotificationModule.flushNotificationCache();
        }
    }

    private static LocalNotificationModule getInstance() {
        return sNotificationModuleInstance;
    }

    private static void queueNotificationTrackingEvent(NotificationCommand notificationCommand) {
        sMainThreadCallbacks.add(notificationCommand);
    }

    public void cancelAllNotifications() {
        this.mNotificationScheduler.cancelAllNotifications();
        this.mNotifier.cancelAllNotifications();
    }

    public void disconnectFromNativeSide() {
        this.mNativeCallbackLock.lock();
        try {
            this.mNotificationModulePointer = 0L;
            sNotificationModuleInstance = null;
            this.mLogger.shutdown();
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    public void flushNotificationCache() {
        this.mNativeCallbackLock.lock();
        if (this.mNotificationModulePointer == 0) {
            AndroidLogger.e(TAG, "Trying to flush the tracking queue without a Module Instance");
            this.mNativeCallbackLock.unlock();
            return;
        }
        ArrayList<NotificationCommand> arrayList = new ArrayList();
        sMainThreadCallbacks.drainTo(arrayList);
        for (NotificationCommand notificationCommand : arrayList) {
            try {
                notificationCommand.run(this.mNotificationModulePointer);
            } catch (Exception unused) {
                AndroidLogger.e(TAG, "Exception when dispatching command type " + notificationCommand.getClass().getSimpleName());
            }
        }
        this.mNativeCallbackLock.unlock();
    }

    public void handleNotificationIntent(Intent intent) {
        LocalIntentUtils.handleNotification(intent);
    }

    public void scheduleLocalNotification(int i10, long j10, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11) {
        this.mLogger.d("scheduleLocalNotification localNotificationId: " + i10 + " time to start in milliseconds: " + j10 + " trackingType: " + str3);
        this.mNotificationScheduler.scheduleLocalNotification(i10, j10, new LocalNotification(str, str2, str3, str4, str5, str6, str7, i11));
    }
}
