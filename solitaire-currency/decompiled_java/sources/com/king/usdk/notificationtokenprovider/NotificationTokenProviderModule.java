package com.king.usdk.notificationtokenprovider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.Keep;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.king.usdk.logger.Logger;
import i5.e;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class NotificationTokenProviderModule {
    private static final String NotificationPermission = "android.permission.POST_NOTIFICATIONS";
    private static final String TAG = "NotificationTokenProviderModule";
    private Activity mActivity;
    private Context mContext;
    private final Logger mLogger;
    private final ReentrantLock mNativeCallbackLock = new ReentrantLock();
    private long mNotificationTokenProviderModulePointer;

    public NotificationTokenProviderModule(Activity activity, long j10, long j11, boolean z10) {
        this.mNotificationTokenProviderModulePointer = 0L;
        this.mActivity = activity;
        this.mContext = activity.getApplicationContext();
        this.mLogger = new Logger(j10, z10);
        this.mNotificationTokenProviderModulePointer = j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableNotification$0(Task task) {
        if (task.isSuccessful()) {
            notifyOnDeviceIdRegistered((String) task.getResult(), ContextCompat.checkSelfPermission(this.mContext, NotificationPermission) == 0);
        } else {
            this.mLogger.w("Failed to obtain device token");
            onPromotionDebugLog(0L, "NotificationTokenProviderModule.enableNotification", "Failed to obtain device token");
        }
    }

    private void notifyOnDeviceIdRegistered(String str, boolean z10) {
        this.mLogger.d("Notifications enabled with token: " + str);
        this.mNativeCallbackLock.lock();
        try {
            long j10 = this.mNotificationTokenProviderModulePointer;
            if (j10 != 0) {
                NotificationTokenProviderNativeCodeCallbacks.onDeviceIdRegistered(j10, str, z10);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    private void onPromotionDebugLog(long j10, String str, String str2) {
        this.mNativeCallbackLock.lock();
        try {
            long j11 = this.mNotificationTokenProviderModulePointer;
            if (j11 != 0) {
                NotificationTokenProviderNativeCodeCallbacks.onPromotionDebugLog(j11, j10, str, str2);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    public void disconnectFromNativeSide() {
        this.mNativeCallbackLock.lock();
        try {
            this.mNotificationTokenProviderModulePointer = 0L;
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    public void enableNotification() {
        if (!isPushNotificationSupported()) {
            onPromotionDebugLog(0L, "NotificationTokenProviderModule.enableNotification", "Push not supported");
            return;
        }
        if (e.p(this.mContext) == null) {
            this.mLogger.e("Failed to initialize Firebase in supposedly supported device");
            onPromotionDebugLog(0L, "NotificationTokenProviderModule.enableNotification", "Failed to initialize Firebase in supposedly supported device");
            return;
        }
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: o6.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f32041a.lambda$enableNotification$0(task);
            }
        });
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this.mContext, NotificationPermission) == 0 || ActivityCompat.shouldShowRequestPermissionRationale(this.mActivity, NotificationPermission)) {
            return;
        }
        ActivityCompat.requestPermissions(this.mActivity, new String[]{NotificationPermission}, 0);
    }

    public boolean isPushNotificationSupported() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.mContext) == 0;
    }

    public boolean isPushNotificationsEnabled() {
        return NotificationManagerCompat.from(this.mContext).areNotificationsEnabled();
    }

    public void showNotificationSettingsDialog() {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", this.mContext.getPackageName());
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", this.mContext.getPackageName());
            intent.putExtra("app_uid", this.mContext.getApplicationInfo().uid);
        }
        intent.setFlags(268435456);
        this.mContext.startActivity(intent);
    }
}
