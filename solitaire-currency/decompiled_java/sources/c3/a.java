package c3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.Arrays;
import java.util.List;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: Metadata.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0151a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f4492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4493b;

    /* JADX INFO: renamed from: c3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Metadata.java */
    class C0151a implements Parcelable.Creator<a> {
        C0151a() {
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

    /* JADX INFO: compiled from: Metadata.java */
    public interface b extends Parcelable {
        @Nullable
        byte[] getWrappedMetadataBytes();

        @Nullable
        o1 getWrappedMetadataFormat();

        void i(b2.b bVar);
    }

    public a(b... bVarArr) {
        this(C.TIME_UNSET, bVarArr);
    }

    public a a(b... bVarArr) {
        return bVarArr.length == 0 ? this : new a(this.f4493b, (b[]) o0.z0(this.f4492a, bVarArr));
    }

    public a b(@Nullable a aVar) {
        return aVar == null ? this : a(aVar.f4492a);
    }

    public a c(long j10) {
        return this.f4493b == j10 ? this : new a(j10, this.f4492a);
    }

    public b d(int i10) {
        return this.f4492a[i10];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f4492a.length;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return Arrays.equals(this.f4492a, aVar.f4492a) && this.f4493b == aVar.f4493b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f4492a) * 31) + g5.g.b(this.f4493b);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.f4492a));
        if (this.f4493b == C.TIME_UNSET) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f4493b;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f4492a.length);
        for (b bVar : this.f4492a) {
            parcel.writeParcelable(bVar, 0);
        }
        parcel.writeLong(this.f4493b);
    }

    public a(long j10, b... bVarArr) {
        this.f4493b = j10;
        this.f4492a = bVarArr;
    }

    public a(List<? extends b> list) {
        this((b[]) list.toArray(new b[0]));
    }

    public a(long j10, List<? extends b> list) {
        this(j10, (b[]) list.toArray(new b[0]));
    }

    a(Parcel parcel) {
        this.f4492a = new b[parcel.readInt()];
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f4492a;
            if (i10 < bVarArr.length) {
                bVarArr[i10] = (b) parcel.readParcelable(b.class.getClassLoader());
                i10++;
            } else {
                this.f4493b = parcel.readLong();
                return;
            }
        }
    }
}
