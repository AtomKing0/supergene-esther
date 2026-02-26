package f3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import c3.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.v8;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: VorbisComment.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class b implements a.b {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25667b;

    /* JADX INFO: compiled from: VorbisComment.java */
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

    public b(String str, String str2) {
        this.f25666a = str;
        this.f25667b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f25666a.equals(bVar.f25666a) && this.f25667b.equals(bVar.f25667b);
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
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f25666a.hashCode()) * 31) + this.f25667b.hashCode();
    }

    @Override // c3.a.b
    public void i(b2.b bVar) {
        String str = this.f25666a;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                bVar.L(this.f25667b);
                break;
            case "TITLE":
                bVar.i0(this.f25667b);
                break;
            case "DESCRIPTION":
                bVar.S(this.f25667b);
                break;
            case "ALBUMARTIST":
                bVar.K(this.f25667b);
                break;
            case "ARTIST":
                bVar.M(this.f25667b);
                break;
        }
    }

    public String toString() {
        return "VC: " + this.f25666a + v8.i.f15833b + this.f25667b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f25666a);
        parcel.writeString(this.f25667b);
    }

    protected b(Parcel parcel) {
        this.f25666a = (String) o0.j(parcel.readString());
        this.f25667b = (String) o0.j(parcel.readString());
    }
}
