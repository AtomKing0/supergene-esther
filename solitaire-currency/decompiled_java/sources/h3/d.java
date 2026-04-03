package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.ChapterTocFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: ChapterTocFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends i {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f26434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f26435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f26436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f26437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i[] f26438f;

    /* JADX INFO: compiled from: ChapterTocFrame.java */
    class a implements Parcelable.Creator<d> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i10) {
            return new d[i10];
        }
    }

    public d(String str, boolean z10, boolean z11, String[] strArr, i[] iVarArr) {
        super(ChapterTocFrame.ID);
        this.f26434b = str;
        this.f26435c = z10;
        this.f26436d = z11;
        this.f26437e = strArr;
        this.f26438f = iVarArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f26435c == dVar.f26435c && this.f26436d == dVar.f26436d && o0.c(this.f26434b, dVar.f26434b) && Arrays.equals(this.f26437e, dVar.f26437e) && Arrays.equals(this.f26438f, dVar.f26438f);
    }

    public int hashCode() {
        int i10 = (((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (this.f26435c ? 1 : 0)) * 31) + (this.f26436d ? 1 : 0)) * 31;
        String str = this.f26434b;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26434b);
        parcel.writeByte(this.f26435c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f26436d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f26437e);
        parcel.writeInt(this.f26438f.length);
        for (i iVar : this.f26438f) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    d(Parcel parcel) {
        super(ChapterTocFrame.ID);
        this.f26434b = (String) o0.j(parcel.readString());
        this.f26435c = parcel.readByte() != 0;
        this.f26436d = parcel.readByte() != 0;
        this.f26437e = (String[]) o0.j(parcel.createStringArray());
        int i10 = parcel.readInt();
        this.f26438f = new i[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f26438f[i11] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }
}
