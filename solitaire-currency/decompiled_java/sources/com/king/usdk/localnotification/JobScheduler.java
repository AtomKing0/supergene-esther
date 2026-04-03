package com.king.usdk.localnotification;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.annotation.Keep;
import com.king.usdk.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class JobScheduler implements NotificationScheduler {
    private final Context mContext;
    private final Logger mLogger;

    JobScheduler(Context context, Logger logger) {
        this.mContext = context;
        this.mLogger = logger;
    }

    private android.app.job.JobScheduler getSchedulerService() {
        return (android.app.job.JobScheduler) this.mContext.getSystemService("jobscheduler");
    }

    private void scheduleJob(int i10, long j10, PersistableBundle persistableBundle) {
        long jCurrentTimeMillis = System.currentTimeMillis() + j10;
        this.mLogger.d(String.format("Scheduling Job: In: %d millis, At: %d, for: %d", Long.valueOf(j10), Long.valueOf(System.currentTimeMillis()), Long.valueOf(jCurrentTimeMillis)));
        if (j10 <= 0) {
            this.mLogger.w("Job " + i10 + " can't be scheduled. I set up for the past " + (-jCurrentTimeMillis) + " millis.");
            return;
        }
        if (getSchedulerService().schedule(new JobInfo.Builder(i10, new ComponentName(this.mContext, JobSchedulerService.class.getName())).setMinimumLatency(j10).setExtras(persistableBundle).build()) <= 0) {
            this.mLogger.w("Something went wrong, Couldn't schedule the job " + i10);
            return;
        }
        this.mLogger.d("Job " + i10 + " scheduled for next " + jCurrentTimeMillis + " millis.");
    }

    @Override // com.king.usdk.localnotification.NotificationScheduler
    public void cancelAllNotifications() {
        getSchedulerService().cancelAll();
    }

    @Override // com.king.usdk.localnotification.NotificationScheduler
    public void scheduleLocalNotification(int i10, long j10, LocalNotification localNotification) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("title", localNotification.title);
        persistableBundle.putString("msg", localNotification.message);
        persistableBundle.putString(NotificationSchedulerKeys.KEY_TRACKING_TYPE, localNotification.trackingType);
        persistableBundle.putString(NotificationSchedulerKeys.KEY_TITLE_KEY, localNotification.titleKey);
        persistableBundle.putString(NotificationSchedulerKeys.KEY_DEEPLINK, localNotification.deeplink);
        persistableBundle.putString(NotificationSchedulerKeys.KEY_MEDIA_PATH, localNotification.mediaPath);
        persistableBundle.putString(NotificationSchedulerKeys.KEY_BACKGROUND_PATH, localNotification.backgroundPath);
        persistableBundle.putInt(NotificationSchedulerKeys.KEY_TEXT_COLOR, localNotification.textColor);
        persistableBundle.putString(NotificationSchedulerKeys.KEY_ACTIVITY_CLASS_NAME, this.mContext.getClass().getName());
        persistableBundle.putInt("id", i10);
        scheduleJob(i10, j10, persistableBundle);
    }
}
