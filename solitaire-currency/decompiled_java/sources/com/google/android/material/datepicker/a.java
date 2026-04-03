package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: CalendarConstraints.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0210a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final o f9140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final o f9141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final c f9142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private o f9143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9146g;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CalendarConstraints.java */
    class C0210a implements Parcelable.Creator<a> {
        C0210a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(@NonNull Parcel parcel) {
            return new a((o) parcel.readParcelable(o.class.getClassLoader()), (o) parcel.readParcelable(o.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (o) parcel.readParcelable(o.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    /* JADX INFO: compiled from: CalendarConstraints.java */
    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f9147f = a0.a(o.c(1900, 0).f9260f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final long f9148g = a0.a(o.c(2100, 11).f9260f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f9149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f9150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f9151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9152d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f9153e;

        b(@NonNull a aVar) {
            this.f9149a = f9147f;
            this.f9150b = f9148g;
            this.f9153e = g.a(Long.MIN_VALUE);
            this.f9149a = aVar.f9140a.f9260f;
            this.f9150b = aVar.f9141b.f9260f;
            this.f9151c = Long.valueOf(aVar.f9143d.f9260f);
            this.f9152d = aVar.f9144e;
            this.f9153e = aVar.f9142c;
        }

        @NonNull
        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f9153e);
            o oVarD = o.d(this.f9149a);
            o oVarD2 = o.d(this.f9150b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l10 = this.f9151c;
            return new a(oVarD, oVarD2, cVar, l10 == null ? null : o.d(l10.longValue()), this.f9152d, null);
        }

        @NonNull
        public b b(long j10) {
            this.f9151c = Long.valueOf(j10);
            return this;
        }
    }

    /* JADX INFO: compiled from: CalendarConstraints.java */
    public interface c extends Parcelable {
        boolean z(long j10);
    }

    /* synthetic */ a(o oVar, o oVar2, c cVar, o oVar3, int i10, C0210a c0210a) {
        this(oVar, oVar2, cVar, oVar3, i10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f9140a.equals(aVar.f9140a) && this.f9141b.equals(aVar.f9141b) && ObjectsCompat.equals(this.f9143d, aVar.f9143d) && this.f9144e == aVar.f9144e && this.f9142c.equals(aVar.f9142c);
    }

    o f(o oVar) {
        return oVar.compareTo(this.f9140a) < 0 ? this.f9140a : oVar.compareTo(this.f9141b) > 0 ? this.f9141b : oVar;
    }

    public c g() {
        return this.f9142c;
    }

    @NonNull
    o h() {
        return this.f9141b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9140a, this.f9141b, this.f9143d, Integer.valueOf(this.f9144e), this.f9142c});
    }

    int j() {
        return this.f9144e;
    }

    int k() {
        return this.f9146g;
    }

    @Nullable
    o l() {
        return this.f9143d;
    }

    @NonNull
    o m() {
        return this.f9140a;
    }

    int n() {
        return this.f9145f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f9140a, 0);
        parcel.writeParcelable(this.f9141b, 0);
        parcel.writeParcelable(this.f9143d, 0);
        parcel.writeParcelable(this.f9142c, 0);
        parcel.writeInt(this.f9144e);
    }

    private a(@NonNull o oVar, @NonNull o oVar2, @NonNull c cVar, @Nullable o oVar3, int i10) {
        Objects.requireNonNull(oVar, "start cannot be null");
        Objects.requireNonNull(oVar2, "end cannot be null");
        Objects.requireNonNull(cVar, "validator cannot be null");
        this.f9140a = oVar;
        this.f9141b = oVar2;
        this.f9143d = oVar3;
        this.f9144e = i10;
        this.f9142c = cVar;
        if (oVar3 != null && oVar.compareTo(oVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (oVar3 != null && oVar3.compareTo(oVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i10 < 0 || i10 > a0.k().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f9146g = oVar.m(oVar2) + 1;
        this.f9145f = (oVar2.f9257c - oVar.f9257c) + 1;
    }
}
