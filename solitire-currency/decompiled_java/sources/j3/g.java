package j3;

import a4.c0;
import a4.l0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: TimeSignalCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f28665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f28666b;

    /* JADX INFO: compiled from: TimeSignalCommand.java */
    class a implements Parcelable.Creator<g> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i10) {
            return new g[i10];
        }
    }

    /* synthetic */ g(long j10, long j11, a aVar) {
        this(j10, j11);
    }

    static g a(c0 c0Var, long j10, l0 l0Var) {
        long jB = b(c0Var, j10);
        return new g(jB, l0Var.b(jB));
    }

    static long b(c0 c0Var, long j10) {
        long jD = c0Var.D();
        return (128 & jD) != 0 ? 8589934591L & ((((jD & 1) << 32) | c0Var.F()) + j10) : C.TIME_UNSET;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f28665a);
        parcel.writeLong(this.f28666b);
    }

    private g(long j10, long j11) {
        this.f28665a = j10;
        this.f28666b = j11;
    }
}
