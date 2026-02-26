package com.king.usdk.localnotification;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class JobSchedulerService extends JobService {
    private static final String TAG = "JobSchedulerService";
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private Notifier mNotifier;

    private LocalNotificationData getNotificationFromBundle(PersistableBundle persistableBundle) {
        return new LocalNotificationData(persistableBundle.getInt("id", 0), persistableBundle.getString(NotificationSchedulerKeys.KEY_ACTIVITY_CLASS_NAME), persistableBundle.getString("title"), persistableBundle.getString("msg"), persistableBundle.getString(NotificationSchedulerKeys.KEY_TRACKING_TYPE), persistableBundle.getString(NotificationSchedulerKeys.KEY_TITLE_KEY), persistableBundle.getString(NotificationSchedulerKeys.KEY_DEEPLINK), persistableBundle.getString(NotificationSchedulerKeys.KEY_MEDIA_PATH), persistableBundle.getString(NotificationSchedulerKeys.KEY_BACKGROUND_PATH), persistableBundle.getInt(NotificationSchedulerKeys.KEY_TEXT_COLOR, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0(PersistableBundle persistableBundle, JobParameters jobParameters) {
        this.mNotifier.showNotification(getNotificationFromBundle(persistableBundle));
        jobFinished(jobParameters, false);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AndroidLogger.d(TAG, "onCreate");
        this.mNotifier = new Notifier(getApplicationContext());
        HandlerThread handlerThread = new HandlerThread("NotificationHandlerThread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mHandlerThread.quit();
        AndroidLogger.d(TAG, "onDestroy");
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        AndroidLogger.d(TAG, String.format("Got job " + jobParameters.getJobId(), new Object[0]));
        final PersistableBundle extras = jobParameters.getExtras();
        if (extras.getString("msg") == null || LocalIntentUtils.applicationInForeground(this)) {
            return true;
        }
        this.mHandler.post(new Runnable() { // from class: com.king.usdk.localnotification.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f17186a.lambda$onStartJob$0(extras, jobParameters);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
