package o2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: DrmInitData.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements Comparator<b>, Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f31915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f31917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f31918d;

    /* JADX INFO: compiled from: DrmInitData.java */
    class a implements Parcelable.Creator<m> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i10) {
            return new m[i10];
        }
    }

    /* JADX INFO: compiled from: DrmInitData.java */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f31919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f31920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f31921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f31922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final byte[] f31923e;

        /* JADX INFO: compiled from: DrmInitData.java */
        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i10) {
                return new b[i10];
            }
        }

        public b(UUID uuid, String str, @Nullable byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        @CheckResult
        public b a(@Nullable byte[] bArr) {
            return new b(this.f31920b, this.f31921c, this.f31922d, bArr);
        }

        public boolean b(UUID uuid) {
            return k2.i.f29126a.equals(this.f31920b) || uuid.equals(this.f31920b);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return a4.o0.c(this.f31921c, bVar.f31921c) && a4.o0.c(this.f31922d, bVar.f31922d) && a4.o0.c(this.f31920b, bVar.f31920b) && Arrays.equals(this.f31923e, bVar.f31923e);
        }

        public int hashCode() {
            if (this.f31919a == 0) {
                int iHashCode = this.f31920b.hashCode() * 31;
                String str = this.f31921c;
                this.f31919a = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f31922d.hashCode()) * 31) + Arrays.hashCode(this.f31923e);
            }
            return this.f31919a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeLong(this.f31920b.getMostSignificantBits());
            parcel.writeLong(this.f31920b.getLeastSignificantBits());
            parcel.writeString(this.f31921c);
            parcel.writeString(this.f31922d);
            parcel.writeByteArray(this.f31923e);
        }

        public b(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
            this.f31920b = (UUID) a4.a.e(uuid);
            this.f31921c = str;
            this.f31922d = (String) a4.a.e(str2);
            this.f31923e = bArr;
        }

        b(Parcel parcel) {
            this.f31920b = new UUID(parcel.readLong(), parcel.readLong());
            this.f31921c = parcel.readString();
            this.f31922d = (String) a4.o0.j(parcel.readString());
            this.f31923e = parcel.createByteArray();
        }
    }

    public m(List<b> list) {
        this(null, false, (b[]) list.toArray(new b[0]));
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        UUID uuid = k2.i.f29126a;
        return uuid.equals(bVar.f31920b) ? uuid.equals(bVar2.f31920b) ? 0 : 1 : bVar.f31920b.compareTo(bVar2.f31920b);
    }

    @CheckResult
    public m b(@Nullable String str) {
        return a4.o0.c(this.f31917c, str) ? this : new m(str, false, this.f31915a);
    }

    public b c(int i10) {
        return this.f31915a[i10];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return a4.o0.c(this.f31917c, mVar.f31917c) && Arrays.equals(this.f31915a, mVar.f31915a);
    }

    public int hashCode() {
        if (this.f31916b == 0) {
            String str = this.f31917c;
            this.f31916b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f31915a);
        }
        return this.f31916b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31917c);
        parcel.writeTypedArray(this.f31915a, 0);
    }

    public m(b... bVarArr) {
        this(null, bVarArr);
    }

    public m(@Nullable String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    private m(@Nullable String str, boolean z10, b... bVarArr) {
        this.f31917c = str;
        bVarArr = z10 ? (b[]) bVarArr.clone() : bVarArr;
        this.f31915a = bVarArr;
        this.f31918d = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    m(Parcel parcel) {
        this.f31917c = parcel.readString();
        b[] bVarArr = (b[]) a4.o0.j((b[]) parcel.createTypedArray(b.CREATOR));
        this.f31915a = bVarArr;
        this.f31918d = bVarArr.length;
    }
}
