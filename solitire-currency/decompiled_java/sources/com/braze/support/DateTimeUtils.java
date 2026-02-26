package com.braze.support;

import android.os.Build;
import android.os.SystemClock;
import bo.app.dp;
import bo.app.ep;
import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTimeUtils {
    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("DateTimeUtils");
    private static boolean shouldUseNetworkTimeClock = true;

    public static final Date createDate(int i10, int i11, int i12, int i13, int i14, int i15) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        gregorianCalendar.setTimeZone(UTC_TIME_ZONE);
        Date time = gregorianCalendar.getTime();
        t.h(time, "calendar.time");
        return time;
    }

    public static final String formatDate(Date date, BrazeDateFormat dateFormat, TimeZone timeZone) {
        t.i(date, "<this>");
        t.i(dateFormat, "dateFormat");
        t.i(timeZone, "timeZone");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getFormat(), Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        String str = simpleDateFormat.format(date);
        t.h(str, "simpleDateFormat.format(this)");
        return str;
    }

    public static /* synthetic */ String formatDate$default(Date date, BrazeDateFormat brazeDateFormat, TimeZone UTC_TIME_ZONE2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            UTC_TIME_ZONE2 = UTC_TIME_ZONE;
            t.h(UTC_TIME_ZONE2, "UTC_TIME_ZONE");
        }
        return formatDate(date, brazeDateFormat, UTC_TIME_ZONE2);
    }

    public static final String formatDateFromMillis(long j10, BrazeDateFormat dateFormat, TimeZone timeZone) {
        t.i(dateFormat, "dateFormat");
        t.i(timeZone, "timeZone");
        return formatDate(new Date(j10), dateFormat, timeZone);
    }

    public static /* synthetic */ String formatDateFromMillis$default(long j10, BrazeDateFormat brazeDateFormat, TimeZone timeZone, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            brazeDateFormat = BrazeDateFormat.ANDROID_LOGCAT;
        }
        if ((i10 & 2) != 0) {
            timeZone = TimeZone.getDefault();
            t.h(timeZone, "getDefault()");
        }
        return formatDateFromMillis(j10, brazeDateFormat, timeZone);
    }

    public static final String formatDateNow(BrazeDateFormat dateFormat) {
        t.i(dateFormat, "dateFormat");
        Date dateCreateDate = createDate(nowInSeconds());
        TimeZone timeZone = TimeZone.getDefault();
        t.h(timeZone, "getDefault()");
        return formatDate(dateCreateDate, dateFormat, timeZone);
    }

    public static final long getTimeFromEpochInSeconds(Date date) {
        t.i(date, "<this>");
        return TimeUnit.MILLISECONDS.toSeconds(date.getTime());
    }

    public static final long nowInMilliseconds() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (Build.VERSION.SDK_INT < 33 || !shouldUseNetworkTimeClock) {
                return jCurrentTimeMillis;
            }
            long jMillis = SystemClock.currentNetworkTimeClock().millis();
            return jMillis < 1691768838316L ? jCurrentTimeMillis : jMillis;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) e10, false, (h9.a) dp.f2670a, 8, (Object) null);
            shouldUseNetworkTimeClock = false;
            return jCurrentTimeMillis;
        }
    }

    public static final long nowInSeconds() {
        return TimeUnit.MILLISECONDS.toSeconds(nowInMilliseconds());
    }

    public static final double nowInSecondsPrecise() {
        return nowInMilliseconds() / 1000.0d;
    }

    public static final Date parseDate(String str, BrazeDateFormat dateFormat) throws Exception {
        t.i(str, "<this>");
        t.i(dateFormat, "dateFormat");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getFormat(), Locale.US);
        simpleDateFormat.setTimeZone(UTC_TIME_ZONE);
        try {
            Date date = simpleDateFormat.parse(str);
            t.f(date);
            return date;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new ep(str), 8, (Object) null);
            throw e10;
        }
    }

    public static final Date createDate(long j10) {
        return new Date(j10 * 1000);
    }
}
