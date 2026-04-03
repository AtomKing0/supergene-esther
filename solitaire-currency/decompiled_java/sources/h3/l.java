package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: PrivFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends i {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f26460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f26461c;

    /* JADX INFO: compiled from: PrivFrame.java */
    class a implements Parcelable.Creator<l> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i10) {
            return new l[i10];
        }
    }

    public l(String str, byte[] bArr) {
        super(PrivFrame.ID);
        this.f26460b = str;
        this.f26461c = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return o0.c(this.f26460b, lVar.f26460b) && Arrays.equals(this.f26461c, lVar.f26461c);
    }

    public int hashCode() {
        String str = this.f26460b;
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f26461c);
    }

    @Override // h3.i
    public String toString() {
        return this.f26451a + ": owner=" + this.f26460b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26460b);
        parcel.writeByteArray(this.f26461c);
    }

    l(Parcel parcel) {
        super(PrivFrame.ID);
        this.f26460b = (String) o0.j(parcel.readString());
        this.f26461c = (byte[]) o0.j(parcel.createByteArray());
    }
}
