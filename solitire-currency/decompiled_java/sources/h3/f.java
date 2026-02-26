package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.GeobFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: GeobFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends i {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f26442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f26443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f26444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f26445e;

    /* JADX INFO: compiled from: GeobFrame.java */
    class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super(GeobFrame.ID);
        this.f26442b = str;
        this.f26443c = str2;
        this.f26444d = str3;
        this.f26445e = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return o0.c(this.f26442b, fVar.f26442b) && o0.c(this.f26443c, fVar.f26443c) && o0.c(this.f26444d, fVar.f26444d) && Arrays.equals(this.f26445e, fVar.f26445e);
    }

    public int hashCode() {
        String str = this.f26442b;
        int iHashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f26443c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f26444d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f26445e);
    }

    @Override // h3.i
    public String toString() {
        return this.f26451a + ": mimeType=" + this.f26442b + ", filename=" + this.f26443c + ", description=" + this.f26444d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26442b);
        parcel.writeString(this.f26443c);
        parcel.writeString(this.f26444d);
        parcel.writeByteArray(this.f26445e);
    }

    f(Parcel parcel) {
        super(GeobFrame.ID);
        this.f26442b = (String) o0.j(parcel.readString());
        this.f26443c = (String) o0.j(parcel.readString());
        this.f26444d = (String) o0.j(parcel.readString());
        this.f26445e = (byte[]) o0.j(parcel.createByteArray());
    }
}
