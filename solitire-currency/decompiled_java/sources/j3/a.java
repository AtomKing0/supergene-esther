package j3;

import a4.c0;
import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PrivateCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new C0593a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f28629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f28630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f28631c;

    /* JADX INFO: renamed from: j3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PrivateCommand.java */
    class C0593a implements Parcelable.Creator<a> {
        C0593a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    /* synthetic */ a(Parcel parcel, C0593a c0593a) {
        this(parcel);
    }

    static a a(c0 c0Var, int i10, long j10) {
        long jF = c0Var.F();
        int i11 = i10 - 4;
        byte[] bArr = new byte[i11];
        c0Var.j(bArr, 0, i11);
        return new a(jF, bArr, j10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f28629a);
        parcel.writeLong(this.f28630b);
        parcel.writeByteArray(this.f28631c);
    }

    private a(long j10, byte[] bArr, long j11) {
        this.f28629a = j11;
        this.f28630b = j10;
        this.f28631c = bArr;
    }

    private a(Parcel parcel) {
        this.f28629a = parcel.readLong();
        this.f28630b = parcel.readLong();
        this.f28631c = (byte[]) o0.j(parcel.createByteArray());
    }
}
