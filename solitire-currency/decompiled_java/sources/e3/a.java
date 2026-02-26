package e3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import c3.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: EventMessage.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f24733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f24735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final o1 f24729g = new o1.b().e0(MimeTypes.APPLICATION_ID3).E();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final o1 f24730h = new o1.b().e0(MimeTypes.APPLICATION_SCTE35).E();
    public static final Parcelable.Creator<a> CREATOR = new C0543a();

    /* JADX INFO: renamed from: e3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventMessage.java */
    class C0543a implements Parcelable.Creator<a> {
        C0543a() {
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

    public a(String str, String str2, long j10, long j11, byte[] bArr) {
        this.f24731a = str;
        this.f24732b = str2;
        this.f24733c = j10;
        this.f24734d = j11;
        this.f24735e = bArr;
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
        return this.f24733c == aVar.f24733c && this.f24734d == aVar.f24734d && o0.c(this.f24731a, aVar.f24731a) && o0.c(this.f24732b, aVar.f24732b) && Arrays.equals(this.f24735e, aVar.f24735e);
    }

    @Override // c3.a.b
    @Nullable
    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.f24735e;
        }
        return null;
    }

    @Override // c3.a.b
    @Nullable
    public o1 getWrappedMetadataFormat() {
        String str = this.f24731a;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f24730h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f24729g;
            default:
                return null;
        }
    }

    public int hashCode() {
        if (this.f24736f == 0) {
            String str = this.f24731a;
            int iHashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f24732b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j10 = this.f24733c;
            int i10 = (((iHashCode + iHashCode2) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f24734d;
            this.f24736f = ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.f24735e);
        }
        return this.f24736f;
    }

    @Override // c3.a.b
    public /* synthetic */ void i(b2.b bVar) {
        c3.b.c(this, bVar);
    }

    public String toString() {
        return "EMSG: scheme=" + this.f24731a + ", id=" + this.f24734d + ", durationMs=" + this.f24733c + ", value=" + this.f24732b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f24731a);
        parcel.writeString(this.f24732b);
        parcel.writeLong(this.f24733c);
        parcel.writeLong(this.f24734d);
        parcel.writeByteArray(this.f24735e);
    }

    a(Parcel parcel) {
        this.f24731a = (String) o0.j(parcel.readString());
        this.f24732b = (String) o0.j(parcel.readString());
        this.f24733c = parcel.readLong();
        this.f24734d = parcel.readLong();
        this.f24735e = (byte[]) o0.j(parcel.createByteArray());
    }
}
