package f3;

import a4.c0;
import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import c3.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import e5.e;
import java.util.Arrays;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: PictureFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0552a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f25660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f25662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f25663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f25664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f25665h;

    /* JADX INFO: renamed from: f3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PictureFrame.java */
    class C0552a implements Parcelable.Creator<a> {
        C0552a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(int i10, String str, String str2, int i11, int i12, int i13, int i14, byte[] bArr) {
        this.f25658a = i10;
        this.f25659b = str;
        this.f25660c = str2;
        this.f25661d = i11;
        this.f25662e = i12;
        this.f25663f = i13;
        this.f25664g = i14;
        this.f25665h = bArr;
    }

    public static a a(c0 c0Var) {
        int iN = c0Var.n();
        String strB = c0Var.B(c0Var.n(), e.f25138a);
        String strA = c0Var.A(c0Var.n());
        int iN2 = c0Var.n();
        int iN3 = c0Var.n();
        int iN4 = c0Var.n();
        int iN5 = c0Var.n();
        int iN6 = c0Var.n();
        byte[] bArr = new byte[iN6];
        c0Var.j(bArr, 0, iN6);
        return new a(iN, strB, strA, iN2, iN3, iN4, iN5, bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f25658a == aVar.f25658a && this.f25659b.equals(aVar.f25659b) && this.f25660c.equals(aVar.f25660c) && this.f25661d == aVar.f25661d && this.f25662e == aVar.f25662e && this.f25663f == aVar.f25663f && this.f25664g == aVar.f25664g && Arrays.equals(this.f25665h, aVar.f25665h);
    }

    @Override // c3.a.b
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return c3.b.a(this);
    }

    @Override // c3.a.b
    public /* synthetic */ o1 getWrappedMetadataFormat() {
        return c3.b.b(this);
    }

    public int hashCode() {
        return ((((((((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f25658a) * 31) + this.f25659b.hashCode()) * 31) + this.f25660c.hashCode()) * 31) + this.f25661d) * 31) + this.f25662e) * 31) + this.f25663f) * 31) + this.f25664g) * 31) + Arrays.hashCode(this.f25665h);
    }

    @Override // c3.a.b
    public void i(b2.b bVar) {
        bVar.G(this.f25665h, this.f25658a);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f25659b + ", description=" + this.f25660c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f25658a);
        parcel.writeString(this.f25659b);
        parcel.writeString(this.f25660c);
        parcel.writeInt(this.f25661d);
        parcel.writeInt(this.f25662e);
        parcel.writeInt(this.f25663f);
        parcel.writeInt(this.f25664g);
        parcel.writeByteArray(this.f25665h);
    }

    a(Parcel parcel) {
        this.f25658a = parcel.readInt();
        this.f25659b = (String) o0.j(parcel.readString());
        this.f25660c = (String) o0.j(parcel.readString());
        this.f25661d = parcel.readInt();
        this.f25662e = parcel.readInt();
        this.f25663f = parcel.readInt();
        this.f25664g = parcel.readInt();
        this.f25665h = (byte[]) o0.j(parcel.createByteArray());
    }
}
