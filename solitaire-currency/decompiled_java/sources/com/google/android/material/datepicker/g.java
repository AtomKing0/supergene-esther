package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.a;
import java.util.Arrays;

/* JADX INFO: compiled from: DateValidatorPointForward.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements a.c {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9173a;

    /* JADX INFO: compiled from: DateValidatorPointForward.java */
    class a implements Parcelable.Creator<g> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(@NonNull Parcel parcel) {
            return new g(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i10) {
            return new g[i10];
        }
    }

    /* synthetic */ g(long j10, a aVar) {
        this(j10);
    }

    @NonNull
    public static g a(long j10) {
        return new g(j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f9173a == ((g) obj).f9173a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f9173a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeLong(this.f9173a);
    }

    @Override // com.google.android.material.datepicker.a.c
    public boolean z(long j10) {
        return j10 >= this.f9173a;
    }

    private g(long j10) {
        this.f9173a = j10;
    }
}
