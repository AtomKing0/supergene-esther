package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: MlltFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends i {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f26455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f26456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f26458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f26459f;

    /* JADX INFO: compiled from: MlltFrame.java */
    class a implements Parcelable.Creator<k> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i10) {
            return new k[i10];
        }
    }

    public k(int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        super(MlltFrame.ID);
        this.f26455b = i10;
        this.f26456c = i11;
        this.f26457d = i12;
        this.f26458e = iArr;
        this.f26459f = iArr2;
    }

    @Override // h3.i, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f26455b == kVar.f26455b && this.f26456c == kVar.f26456c && this.f26457d == kVar.f26457d && Arrays.equals(this.f26458e, kVar.f26458e) && Arrays.equals(this.f26459f, kVar.f26459f);
    }

    public int hashCode() {
        return ((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26455b) * 31) + this.f26456c) * 31) + this.f26457d) * 31) + Arrays.hashCode(this.f26458e)) * 31) + Arrays.hashCode(this.f26459f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f26455b);
        parcel.writeInt(this.f26456c);
        parcel.writeInt(this.f26457d);
        parcel.writeIntArray(this.f26458e);
        parcel.writeIntArray(this.f26459f);
    }

    k(Parcel parcel) {
        super(MlltFrame.ID);
        this.f26455b = parcel.readInt();
        this.f26456c = parcel.readInt();
        this.f26457d = parcel.readInt();
        this.f26458e = (int[]) o0.j(parcel.createIntArray());
        this.f26459f = (int[]) o0.j(parcel.createIntArray());
    }
}
