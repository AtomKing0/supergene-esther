package i3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import c3.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import g5.g;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: MotionPhotoMetadata.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements a.b {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f26574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f26575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f26576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f26577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f26578e;

    /* JADX INFO: compiled from: MotionPhotoMetadata.java */
    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f26574a == bVar.f26574a && this.f26575b == bVar.f26575b && this.f26576c == bVar.f26576c && this.f26577d == bVar.f26577d && this.f26578e == bVar.f26578e;
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
        return ((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + g.b(this.f26574a)) * 31) + g.b(this.f26575b)) * 31) + g.b(this.f26576c)) * 31) + g.b(this.f26577d)) * 31) + g.b(this.f26578e);
    }

    @Override // c3.a.b
    public /* synthetic */ void i(b2.b bVar) {
        c3.b.c(this, bVar);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f26574a + ", photoSize=" + this.f26575b + ", photoPresentationTimestampUs=" + this.f26576c + ", videoStartPosition=" + this.f26577d + ", videoSize=" + this.f26578e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f26574a);
        parcel.writeLong(this.f26575b);
        parcel.writeLong(this.f26576c);
        parcel.writeLong(this.f26577d);
        parcel.writeLong(this.f26578e);
    }

    public b(long j10, long j11, long j12, long j13, long j14) {
        this.f26574a = j10;
        this.f26575b = j11;
        this.f26576c = j12;
        this.f26577d = j13;
        this.f26578e = j14;
    }

    private b(Parcel parcel) {
        this.f26574a = parcel.readLong();
        this.f26575b = parcel.readLong();
        this.f26576c = parcel.readLong();
        this.f26577d = parcel.readLong();
        this.f26578e = parcel.readLong();
    }
}
