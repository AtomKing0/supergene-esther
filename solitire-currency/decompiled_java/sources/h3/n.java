package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: UrlLinkFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends i {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f26464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f26465c;

    /* JADX INFO: compiled from: UrlLinkFrame.java */
    class a implements Parcelable.Creator<n> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i10) {
            return new n[i10];
        }
    }

    public n(String str, @Nullable String str2, String str3) {
        super(str);
        this.f26464b = str2;
        this.f26465c = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.f26451a.equals(nVar.f26451a) && o0.c(this.f26464b, nVar.f26464b) && o0.c(this.f26465c, nVar.f26465c);
    }

    public int hashCode() {
        int iHashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26451a.hashCode()) * 31;
        String str = this.f26464b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f26465c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // h3.i
    public String toString() {
        return this.f26451a + ": url=" + this.f26465c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26451a);
        parcel.writeString(this.f26464b);
        parcel.writeString(this.f26465c);
    }

    n(Parcel parcel) {
        super((String) o0.j(parcel.readString()));
        this.f26464b = parcel.readString();
        this.f26465c = (String) o0.j(parcel.readString());
    }
}
