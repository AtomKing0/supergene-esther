package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: CommentFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends i {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f26439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f26440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f26441d;

    /* JADX INFO: compiled from: CommentFrame.java */
    class a implements Parcelable.Creator<e> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i10) {
            return new e[i10];
        }
    }

    public e(String str, String str2, String str3) {
        super(CommentFrame.ID);
        this.f26439b = str;
        this.f26440c = str2;
        this.f26441d = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return o0.c(this.f26440c, eVar.f26440c) && o0.c(this.f26439b, eVar.f26439b) && o0.c(this.f26441d, eVar.f26441d);
    }

    public int hashCode() {
        String str = this.f26439b;
        int iHashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f26440c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f26441d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // h3.i
    public String toString() {
        return this.f26451a + ": language=" + this.f26439b + ", description=" + this.f26440c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26451a);
        parcel.writeString(this.f26439b);
        parcel.writeString(this.f26441d);
    }

    e(Parcel parcel) {
        super(CommentFrame.ID);
        this.f26439b = (String) o0.j(parcel.readString());
        this.f26440c = (String) o0.j(parcel.readString());
        this.f26441d = (String) o0.j(parcel.readString());
    }
}
