package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class Alarms {
    private static final String TAG = Logger.tagWithPrefix("Alarms");

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static void setExact(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
            alarmManager.setExact(i10, j10, pendingIntent);
        }
    }

    private Alarms() {
    }

    public static void cancelAlarm(@NonNull Context context, @NonNull WorkDatabase workDatabase, @NonNull WorkGenerationalId workGenerationalId) {
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(workGenerationalId);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, workGenerationalId, systemIdInfo.systemId);
            Logger.get().debug(TAG, "Removing SystemIdInfo for workSpecId (" + workGenerationalId + ")");
            systemIdInfoDao.removeSystemIdInfo(workGenerationalId);
        }
    }

    private static void cancelExactAlarm(@NonNull Context context, @NonNull WorkGenerationalId workGenerationalId, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i10, CommandHandler.createDelayMetIntent(context, workGenerationalId), 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        Logger.get().debug(TAG, "Cancelling existing alarm with (workSpecId, systemId) (" + workGenerationalId + ", " + i10 + ")");
        alarmManager.cancel(service);
    }

    public static void setAlarm(@NonNull Context context, @NonNull WorkDatabase workDatabase, @NonNull WorkGenerationalId workGenerationalId, long j10) {
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(workGenerationalId);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, workGenerationalId, systemIdInfo.systemId);
            setExactAlarm(context, workGenerationalId, systemIdInfo.systemId, j10);
        } else {
            int iNextAlarmManagerId = new IdGenerator(workDatabase).nextAlarmManagerId();
            systemIdInfoDao.insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(workGenerationalId, iNextAlarmManagerId));
            setExactAlarm(context, workGenerationalId, iNextAlarmManagerId, j10);
        }
    }

    private static void setExactAlarm(@NonNull Context context, @NonNull WorkGenerationalId workGenerationalId, int i10, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i10, CommandHandler.createDelayMetIntent(context, workGenerationalId), 201326592);
        if (alarmManager != null) {
            Api19Impl.setExact(alarmManager, 0, j10, service);
        }
    }
}
