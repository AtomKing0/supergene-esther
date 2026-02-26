package io.sentry;

import androidx.media3.common.C;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DateUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class n {
    public static long a(@NotNull Date date) {
        return i(date.getTime());
    }

    public static double b(@NotNull Date date) {
        return j(date.getTime());
    }

    @NotNull
    public static BigDecimal c(@NotNull Double d10) {
        return BigDecimal.valueOf(d10.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    @NotNull
    public static Date d() {
        return Calendar.getInstance(io.sentry.vendor.gson.internal.bind.util.a.f28413a).getTime();
    }

    @NotNull
    public static Date e(long j10) {
        Calendar calendar = Calendar.getInstance(io.sentry.vendor.gson.internal.bind.util.a.f28413a);
        calendar.setTimeInMillis(j10);
        return calendar.getTime();
    }

    @NotNull
    public static Date f(@NotNull String str) throws IllegalArgumentException {
        try {
            return io.sentry.vendor.gson.internal.bind.util.a.f(str, new ParsePosition(0));
        } catch (ParseException unused) {
            throw new IllegalArgumentException("timestamp is not ISO format " + str);
        }
    }

    @NotNull
    public static Date g(@NotNull String str) throws IllegalArgumentException {
        try {
            return e(new BigDecimal(str).setScale(3, RoundingMode.DOWN).movePointRight(3).longValue());
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("timestamp is not millis format " + str);
        }
    }

    @NotNull
    public static String h(@NotNull Date date) {
        return io.sentry.vendor.gson.internal.bind.util.a.b(date, true);
    }

    public static long i(long j10) {
        return j10 * 1000000;
    }

    public static double j(double d10) {
        return d10 / 1000.0d;
    }

    public static Date k(long j10) {
        return e(Double.valueOf(l(Double.valueOf(j10).doubleValue())).longValue());
    }

    public static double l(double d10) {
        return d10 / 1000000.0d;
    }

    public static double m(long j10) {
        return Double.valueOf(j10).doubleValue() / 1.0E9d;
    }

    public static long n(@NotNull long j10) {
        return j10 * C.NANOS_PER_SECOND;
    }

    @Nullable
    public static Date o(@Nullable n5 n5Var) {
        if (n5Var == null) {
            return null;
        }
        return p(n5Var);
    }

    @NotNull
    public static Date p(@NotNull n5 n5Var) {
        return k(n5Var.g());
    }
}
