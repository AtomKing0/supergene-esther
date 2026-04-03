package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.ChapterFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: ChapterFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends i {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f26428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f26429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f26431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f26432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i[] f26433g;

    /* JADX INFO: compiled from: ChapterFrame.java */
    class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i10) {
            return new c[i10];
        }
    }

    public c(String str, int i10, int i11, long j10, long j11, i[] iVarArr) {
        super(ChapterFrame.ID);
        this.f26428b = str;
        this.f26429c = i10;
        this.f26430d = i11;
        this.f26431e = j10;
        this.f26432f = j11;
        this.f26433g = iVarArr;
    }

    @Override // h3.i, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f26429c == cVar.f26429c && this.f26430d == cVar.f26430d && this.f26431e == cVar.f26431e && this.f26432f == cVar.f26432f && o0.c(this.f26428b, cVar.f26428b) && Arrays.equals(this.f26433g, cVar.f26433g);
    }

    public int hashCode() {
        int i10 = (((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26429c) * 31) + this.f26430d) * 31) + ((int) this.f26431e)) * 31) + ((int) this.f26432f)) * 31;
        String str = this.f26428b;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26428b);
        parcel.writeInt(this.f26429c);
        parcel.writeInt(this.f26430d);
        parcel.writeLong(this.f26431e);
        parcel.writeLong(this.f26432f);
        parcel.writeInt(this.f26433g.length);
        for (i iVar : this.f26433g) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    c(Parcel parcel) {
        super(ChapterFrame.ID);
        this.f26428b = (String) o0.j(parcel.readString());
        this.f26429c = parcel.readInt();
        this.f26430d = parcel.readInt();
        this.f26431e = parcel.readLong();
        this.f26432f = parcel.readLong();
        int i10 = parcel.readInt();
        this.f26433g = new i[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f26433g[i11] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }
}
