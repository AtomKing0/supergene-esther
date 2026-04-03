package g3;

import a4.o0;
import a4.t;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import c3.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.List;
import java.util.Map;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: IcyHeaders.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements a.b {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f25872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f25873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f25874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f25875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f25876f;

    /* JADX INFO: compiled from: IcyHeaders.java */
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

    public b(int i10, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z10, int i11) {
        a4.a.a(i11 == -1 || i11 > 0);
        this.f25871a = i10;
        this.f25872b = str;
        this.f25873c = str2;
        this.f25874d = str3;
        this.f25875e = z10;
        this.f25876f = i11;
    }

    @Nullable
    public static b a(Map<String, List<String>> map) {
        boolean z10;
        int i10;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i11;
        List<String> list = map.get("icy-br");
        boolean z11 = true;
        int i12 = -1;
        if (list != null) {
            String str4 = list.get(0);
            try {
                i11 = Integer.parseInt(str4) * 1000;
                if (i11 > 0) {
                    z10 = true;
                } else {
                    try {
                        t.i("IcyHeaders", "Invalid bitrate: " + str4);
                        z10 = false;
                        i11 = -1;
                    } catch (NumberFormatException unused) {
                        t.i("IcyHeaders", "Invalid bitrate header: " + str4);
                        z10 = false;
                    }
                }
            } catch (NumberFormatException unused2) {
                i11 = -1;
            }
            i10 = i11;
        } else {
            z10 = false;
            i10 = -1;
        }
        List<String> list2 = map.get("icy-genre");
        if (list2 != null) {
            str = list2.get(0);
            z10 = true;
        } else {
            str = null;
        }
        List<String> list3 = map.get("icy-name");
        if (list3 != null) {
            str2 = list3.get(0);
            z10 = true;
        } else {
            str2 = null;
        }
        List<String> list4 = map.get("icy-url");
        if (list4 != null) {
            str3 = list4.get(0);
            z10 = true;
        } else {
            str3 = null;
        }
        List<String> list5 = map.get("icy-pub");
        if (list5 != null) {
            zEquals = list5.get(0).equals("1");
            z10 = true;
        } else {
            zEquals = false;
        }
        List<String> list6 = map.get("icy-metaint");
        if (list6 != null) {
            String str5 = list6.get(0);
            try {
                int i13 = Integer.parseInt(str5);
                if (i13 > 0) {
                    i12 = i13;
                } else {
                    try {
                        t.i("IcyHeaders", "Invalid metadata interval: " + str5);
                        z11 = z10;
                    } catch (NumberFormatException unused3) {
                        i12 = i13;
                        t.i("IcyHeaders", "Invalid metadata interval: " + str5);
                    }
                }
                z10 = z11;
            } catch (NumberFormatException unused4) {
            }
        }
        if (z10) {
            return new b(i10, str, str2, str3, zEquals, i12);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f25871a == bVar.f25871a && o0.c(this.f25872b, bVar.f25872b) && o0.c(this.f25873c, bVar.f25873c) && o0.c(this.f25874d, bVar.f25874d) && this.f25875e == bVar.f25875e && this.f25876f == bVar.f25876f;
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
        int i10 = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f25871a) * 31;
        String str = this.f25872b;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f25873c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f25874d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f25875e ? 1 : 0)) * 31) + this.f25876f;
    }

    @Override // c3.a.b
    public void i(b2.b bVar) {
        String str = this.f25873c;
        if (str != null) {
            bVar.g0(str);
        }
        String str2 = this.f25872b;
        if (str2 != null) {
            bVar.X(str2);
        }
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f25873c + "\", genre=\"" + this.f25872b + "\", bitrate=" + this.f25871a + ", metadataInterval=" + this.f25876f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f25871a);
        parcel.writeString(this.f25872b);
        parcel.writeString(this.f25873c);
        parcel.writeString(this.f25874d);
        o0.Q0(parcel, this.f25875e);
        parcel.writeInt(this.f25876f);
    }

    b(Parcel parcel) {
        this.f25871a = parcel.readInt();
        this.f25872b = parcel.readString();
        this.f25873c = parcel.readString();
        this.f25874d = parcel.readString();
        this.f25875e = o0.D0(parcel);
        this.f25876f = parcel.readInt();
    }
}
