package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: UtcDates.java */
/* JADX INFO: loaded from: classes3.dex */
class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AtomicReference<u> f9154a = new AtomicReference<>();

    static long a(long j10) {
        Calendar calendarK = k();
        calendarK.setTimeInMillis(j10);
        return c(calendarK).getTimeInMillis();
    }

    @TargetApi(24)
    private static DateFormat b(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(j());
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return instanceForSkeleton;
    }

    static Calendar c(Calendar calendar) {
        Calendar calendarL = l(calendar);
        Calendar calendarK = k();
        calendarK.set(calendarL.get(1), calendarL.get(2), calendarL.get(5));
        return calendarK;
    }

    private static java.text.DateFormat d(int i10, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i10, locale);
        dateInstance.setTimeZone(h());
        return dateInstance;
    }

    static java.text.DateFormat e(Locale locale) {
        return d(0, locale);
    }

    @TargetApi(24)
    static DateFormat f(Locale locale) {
        return b("MMMMEEEEd", locale);
    }

    static u g() {
        u uVar = f9154a.get();
        return uVar == null ? u.c() : uVar;
    }

    private static TimeZone h() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar i() {
        Calendar calendarA = g().a();
        calendarA.set(11, 0);
        calendarA.set(12, 0);
        calendarA.set(13, 0);
        calendarA.set(14, 0);
        calendarA.setTimeZone(h());
        return calendarA;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone j() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar k() {
        return l(null);
    }

    static Calendar l(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(h());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @TargetApi(24)
    static DateFormat m(Locale locale) {
        return b("yMMMM", locale);
    }

    @TargetApi(24)
    static DateFormat n(Locale locale) {
        return b("yMMMMEEEEd", locale);
    }
}
