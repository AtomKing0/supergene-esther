package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: Month.java */
/* JADX INFO: loaded from: classes3.dex */
final class o implements Comparable<o>, Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Calendar f9255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f9256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f9257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f9258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f9259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f9260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f9261g;

    /* JADX INFO: compiled from: Month.java */
    class a implements Parcelable.Creator<o> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o createFromParcel(@NonNull Parcel parcel) {
            return o.c(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public o[] newArray(int i10) {
            return new o[i10];
        }
    }

    private o(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = a0.c(calendar);
        this.f9255a = calendarC;
        this.f9256b = calendarC.get(2);
        this.f9257c = calendarC.get(1);
        this.f9258d = calendarC.getMaximum(7);
        this.f9259e = calendarC.getActualMaximum(5);
        this.f9260f = calendarC.getTimeInMillis();
    }

    @NonNull
    static o c(int i10, int i11) {
        Calendar calendarK = a0.k();
        calendarK.set(1, i10);
        calendarK.set(2, i11);
        return new o(calendarK);
    }

    @NonNull
    static o d(long j10) {
        Calendar calendarK = a0.k();
        calendarK.setTimeInMillis(j10);
        return new o(calendarK);
    }

    @NonNull
    static o e() {
        return new o(a0.i());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull o oVar) {
        return this.f9255a.compareTo(oVar.f9255a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f9256b == oVar.f9256b && this.f9257c == oVar.f9257c;
    }

    int f(int i10) {
        int i11 = this.f9255a.get(7);
        if (i10 <= 0) {
            i10 = this.f9255a.getFirstDayOfWeek();
        }
        int i12 = i11 - i10;
        return i12 < 0 ? i12 + this.f9258d : i12;
    }

    long g(int i10) {
        Calendar calendarC = a0.c(this.f9255a);
        calendarC.set(5, i10);
        return calendarC.getTimeInMillis();
    }

    int h(long j10) {
        Calendar calendarC = a0.c(this.f9255a);
        calendarC.setTimeInMillis(j10);
        return calendarC.get(5);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9256b), Integer.valueOf(this.f9257c)});
    }

    @NonNull
    String j() {
        if (this.f9261g == null) {
            this.f9261g = f.f(this.f9255a.getTimeInMillis());
        }
        return this.f9261g;
    }

    long k() {
        return this.f9255a.getTimeInMillis();
    }

    @NonNull
    o l(int i10) {
        Calendar calendarC = a0.c(this.f9255a);
        calendarC.add(2, i10);
        return new o(calendarC);
    }

    int m(@NonNull o oVar) {
        if (this.f9255a instanceof GregorianCalendar) {
            return ((oVar.f9257c - this.f9257c) * 12) + (oVar.f9256b - this.f9256b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeInt(this.f9257c);
        parcel.writeInt(this.f9256b);
    }
}
