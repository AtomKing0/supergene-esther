package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import k2.b2;

/* JADX INFO: compiled from: ApicFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends i {
    public static final Parcelable.Creator<a> CREATOR = new C0570a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f26423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f26424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f26426e;

    /* JADX INFO: renamed from: h3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApicFrame.java */
    class C0570a implements Parcelable.Creator<a> {
        C0570a() {
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

    public a(String str, @Nullable String str2, int i10, byte[] bArr) {
        super(ApicFrame.ID);
        this.f26423b = str;
        this.f26424c = str2;
        this.f26425d = i10;
        this.f26426e = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f26425d == aVar.f26425d && o0.c(this.f26423b, aVar.f26423b) && o0.c(this.f26424c, aVar.f26424c) && Arrays.equals(this.f26426e, aVar.f26426e);
    }

    public int hashCode() {
        int i10 = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26425d) * 31;
        String str = this.f26423b;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f26424c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f26426e);
    }

    @Override // h3.i, c3.a.b
    public void i(b2.b bVar) {
        bVar.G(this.f26426e, this.f26425d);
    }

    @Override // h3.i
    public String toString() {
        return this.f26451a + ": mimeType=" + this.f26423b + ", description=" + this.f26424c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26423b);
        parcel.writeString(this.f26424c);
        parcel.writeInt(this.f26425d);
        parcel.writeByteArray(this.f26426e);
    }

    a(Parcel parcel) {
        super(ApicFrame.ID);
        this.f26423b = (String) o0.j(parcel.readString());
        this.f26424c = parcel.readString();
        this.f26425d = parcel.readInt();
        this.f26426e = (byte[]) o0.j(parcel.createByteArray());
    }
}
