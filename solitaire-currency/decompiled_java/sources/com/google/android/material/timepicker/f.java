package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: TimeModel.java */
/* JADX INFO: loaded from: classes3.dex */
class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f9911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f9912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f9913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f9915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f9916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f9917g;

    /* JADX INFO: compiled from: TimeModel.java */
    class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    public f() {
        this(0);
    }

    @Nullable
    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, "%02d");
    }

    @Nullable
    public static String b(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int c(int i10) {
        return i10 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f9914d == fVar.f9914d && this.f9915e == fVar.f9915e && this.f9913c == fVar.f9913c && this.f9916f == fVar.f9916f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9913c), Integer.valueOf(this.f9914d), Integer.valueOf(this.f9915e), Integer.valueOf(this.f9916f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f9914d);
        parcel.writeInt(this.f9915e);
        parcel.writeInt(this.f9916f);
        parcel.writeInt(this.f9913c);
    }

    public f(int i10) {
        this(0, 0, 10, i10);
    }

    public f(int i10, int i11, int i12, int i13) {
        this.f9914d = i10;
        this.f9915e = i11;
        this.f9916f = i12;
        this.f9913c = i13;
        this.f9917g = c(i10);
        this.f9911a = new c(59);
        this.f9912b = new c(i13 == 1 ? 23 : 12);
    }

    protected f(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
