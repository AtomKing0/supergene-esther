package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.PeriodicWorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: PeriodicWorkRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PeriodicWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j10, TimeUnit repeatIntervalTimeUnit) {
        t.i(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        t.o(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j10, repeatIntervalTimeUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration repeatInterval) {
        t.i(repeatInterval, "repeatInterval");
        t.o(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, repeatInterval);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j10, TimeUnit repeatIntervalTimeUnit, long j11, TimeUnit flexTimeIntervalUnit) {
        t.i(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        t.i(flexTimeIntervalUnit, "flexTimeIntervalUnit");
        t.o(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, j10, repeatIntervalTimeUnit, j11, flexTimeIntervalUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration repeatInterval, Duration flexTimeInterval) {
        t.i(repeatInterval, "repeatInterval");
        t.i(flexTimeInterval, "flexTimeInterval");
        t.o(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, repeatInterval, flexTimeInterval);
    }
}
