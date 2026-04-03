package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f675e;

    class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f671a = parcel.readInt();
        this.f673c = parcel.readInt();
        this.f674d = parcel.readInt();
        this.f675e = parcel.readInt();
        this.f672b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f671a);
        parcel.writeInt(this.f673c);
        parcel.writeInt(this.f674d);
        parcel.writeInt(this.f675e);
        parcel.writeInt(this.f672b);
    }
}
