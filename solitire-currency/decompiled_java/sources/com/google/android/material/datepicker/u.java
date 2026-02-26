package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: TimeSource.java */
/* JADX INFO: loaded from: classes3.dex */
class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final u f9281c = new u(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Long f9282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final TimeZone f9283b;

    private u(@Nullable Long l10, @Nullable TimeZone timeZone) {
        this.f9282a = l10;
        this.f9283b = timeZone;
    }

    static u c() {
        return f9281c;
    }

    Calendar a() {
        return b(this.f9283b);
    }

    Calendar b(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l10 = this.f9282a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}
