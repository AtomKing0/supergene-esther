package g3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import c3.a;
import java.util.Arrays;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: IcyInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a.b {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f25877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f25878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f25879c;

    /* JADX INFO: compiled from: IcyInfo.java */
    class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i10) {
            return new c[i10];
        }
    }

    public c(byte[] bArr, @Nullable String str, @Nullable String str2) {
        this.f25877a = bArr;
        this.f25878b = str;
        this.f25879c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f25877a, ((c) obj).f25877a);
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
        return Arrays.hashCode(this.f25877a);
    }

    @Override // c3.a.b
    public void i(b2.b bVar) {
        String str = this.f25878b;
        if (str != null) {
            bVar.i0(str);
        }
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f25878b, this.f25879c, Integer.valueOf(this.f25877a.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByteArray(this.f25877a);
        parcel.writeString(this.f25878b);
        parcel.writeString(this.f25879c);
    }

    c(Parcel parcel) {
        this.f25877a = (byte[]) a4.a.e(parcel.createByteArray());
        this.f25878b = parcel.readString();
        this.f25879c = parcel.readString();
    }
}
