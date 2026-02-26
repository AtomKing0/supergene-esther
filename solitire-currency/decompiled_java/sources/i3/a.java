package i3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import c3.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: MdtaMetadataEntry.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0571a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f26571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f26572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26573d;

    /* JADX INFO: renamed from: i3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MdtaMetadataEntry.java */
    class C0571a implements Parcelable.Creator<a> {
        C0571a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    /* synthetic */ a(Parcel parcel, C0571a c0571a) {
        this(parcel);
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
        return this.f26570a.equals(aVar.f26570a) && Arrays.equals(this.f26571b, aVar.f26571b) && this.f26572c == aVar.f26572c && this.f26573d == aVar.f26573d;
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
        return ((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26570a.hashCode()) * 31) + Arrays.hashCode(this.f26571b)) * 31) + this.f26572c) * 31) + this.f26573d;
    }

    @Override // c3.a.b
    public /* synthetic */ void i(b2.b bVar) {
        c3.b.c(this, bVar);
    }

    public String toString() {
        return "mdta: key=" + this.f26570a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26570a);
        parcel.writeByteArray(this.f26571b);
        parcel.writeInt(this.f26572c);
        parcel.writeInt(this.f26573d);
    }

    public a(String str, byte[] bArr, int i10, int i11) {
        this.f26570a = str;
        this.f26571b = bArr;
        this.f26572c = i10;
        this.f26573d = i11;
    }

    private a(Parcel parcel) {
        this.f26570a = (String) o0.j(parcel.readString());
        this.f26571b = (byte[]) o0.j(parcel.createByteArray());
        this.f26572c = parcel.readInt();
        this.f26573d = parcel.readInt();
    }
}
