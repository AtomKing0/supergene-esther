package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: DateStrings.java */
/* JADX INFO: loaded from: classes3.dex */
class f {
    static String a(Context context, long j10, boolean z10, boolean z11, boolean z12) {
        String strD = d(j10);
        if (z10) {
            strD = String.format(context.getString(e4.i.f24888q), strD);
        }
        return z11 ? String.format(context.getString(e4.i.f24887p), strD) : z12 ? String.format(context.getString(e4.i.f24884m), strD) : strD;
    }

    static String b(long j10) {
        return c(j10, Locale.getDefault());
    }

    static String c(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? a0.f(locale).format(new Date(j10)) : a0.e(locale).format(new Date(j10));
    }

    static String d(long j10) {
        return i(j10) ? b(j10) : g(j10);
    }

    static String e(Context context, int i10) {
        return a0.i().get(1) == i10 ? String.format(context.getString(e4.i.f24885n), Integer.valueOf(i10)) : String.format(context.getString(e4.i.f24886o), Integer.valueOf(i10));
    }

    static String f(long j10) {
        return Build.VERSION.SDK_INT >= 24 ? a0.m(Locale.getDefault()).format(new Date(j10)) : DateUtils.formatDateTime(null, j10, 8228);
    }

    static String g(long j10) {
        return h(j10, Locale.getDefault());
    }

    static String h(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? a0.n(locale).format(new Date(j10)) : a0.e(locale).format(new Date(j10));
    }

    private static boolean i(long j10) {
        Calendar calendarI = a0.i();
        Calendar calendarK = a0.k();
        calendarK.setTimeInMillis(j10);
        return calendarI.get(1) == calendarK.get(1);
    }
}
