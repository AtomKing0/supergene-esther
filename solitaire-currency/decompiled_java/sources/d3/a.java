package d3;

import android.os.Parcel;
import android.os.Parcelable;
import c3.a;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: AppInfoTable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0537a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24448b;

    /* JADX INFO: renamed from: d3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppInfoTable.java */
    class C0537a implements Parcelable.Creator<a> {
        C0537a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel.readInt(), (String) a4.a.e(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(int i10, String str) {
        this.f24447a = i10;
        this.f24448b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // c3.a.b
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return c3.b.a(this);
    }

    @Override // c3.a.b
    public /* synthetic */ o1 getWrappedMetadataFormat() {
        return c3.b.b(this);
    }

    @Override // c3.a.b
    public /* synthetic */ void i(b2.b bVar) {
        c3.b.c(this, bVar);
    }

    public String toString() {
        return "Ait(controlCode=" + this.f24447a + ",url=" + this.f24448b + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f24448b);
        parcel.writeInt(this.f24447a);
    }
}
