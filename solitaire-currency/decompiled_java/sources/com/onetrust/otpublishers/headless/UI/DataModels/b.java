package com.onetrust.otpublishers.headless.UI.DataModels;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<d> f22064f = new ArrayList<>();

    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public final b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final b[] newArray(int i10) {
            return new b[i10];
        }
    }

    public b() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "OTConsentPreferencesCustomPreferencesModel{Id='" + this.f22059a + "', Name='" + this.f22060b + "', Description='" + this.f22061c + "', SelectionType='" + this.f22062d + "', Required='" + this.f22063e + "', otConsentPreferencesOptionsModels=" + this.f22064f + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f22059a);
        parcel.writeString(this.f22060b);
        parcel.writeString(this.f22061c);
        parcel.writeString(this.f22062d);
        parcel.writeString(this.f22063e);
    }

    public b(Parcel parcel) {
        this.f22059a = parcel.readString();
        this.f22060b = parcel.readString();
        this.f22061c = parcel.readString();
        this.f22062d = parcel.readString();
        this.f22063e = parcel.readString();
    }
}
