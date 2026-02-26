package i3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import c3.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: SmtaMetadataEntry.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements a.b {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f26584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f26585b;

    /* JADX INFO: compiled from: SmtaMetadataEntry.java */
    class a implements Parcelable.Creator<e> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i10) {
            return new e[i10];
        }
    }

    /* synthetic */ e(Parcel parcel, a aVar) {
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
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f26584a == eVar.f26584a && this.f26585b == eVar.f26585b;
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
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + g5.c.a(this.f26584a)) * 31) + this.f26585b;
    }

    @Override // c3.a.b
    public /* synthetic */ void i(b2.b bVar) {
        c3.b.c(this, bVar);
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f26584a + ", svcTemporalLayerCount=" + this.f26585b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f26584a);
        parcel.writeInt(this.f26585b);
    }

    public e(float f10, int i10) {
        this.f26584a = f10;
        this.f26585b = i10;
    }

    private e(Parcel parcel) {
        this.f26584a = parcel.readFloat();
        this.f26585b = parcel.readInt();
    }
}
