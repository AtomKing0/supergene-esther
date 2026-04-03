package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: InternalFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends i {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f26452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f26453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f26454d;

    /* JADX INFO: compiled from: InternalFrame.java */
    class a implements Parcelable.Creator<j> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i10) {
            return new j[i10];
        }
    }

    public j(String str, String str2, String str3) {
        super(InternalFrame.ID);
        this.f26452b = str;
        this.f26453c = str2;
        this.f26454d = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return o0.c(this.f26453c, jVar.f26453c) && o0.c(this.f26452b, jVar.f26452b) && o0.c(this.f26454d, jVar.f26454d);
    }

    public int hashCode() {
        String str = this.f26452b;
        int iHashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f26453c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f26454d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // h3.i
    public String toString() {
        return this.f26451a + ": domain=" + this.f26452b + ", description=" + this.f26453c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26451a);
        parcel.writeString(this.f26452b);
        parcel.writeString(this.f26454d);
    }

    j(Parcel parcel) {
        super(InternalFrame.ID);
        this.f26452b = (String) o0.j(parcel.readString());
        this.f26453c = (String) o0.j(parcel.readString());
        this.f26454d = (String) o0.j(parcel.readString());
    }
}
