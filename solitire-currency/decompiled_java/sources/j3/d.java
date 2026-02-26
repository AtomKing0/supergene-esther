package j3;

import a4.c0;
import a4.l0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SpliceInsertCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends j3.b {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f28635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f28636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f28637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f28638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f28639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f28640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f28641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<b> f28642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f28643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f28644j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f28645k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f28646l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f28647m;

    /* JADX INFO: compiled from: SpliceInsertCommand.java */
    class a implements Parcelable.Creator<d> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i10) {
            return new d[i10];
        }
    }

    /* JADX INFO: compiled from: SpliceInsertCommand.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f28648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f28649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f28650c;

        /* synthetic */ b(int i10, long j10, long j11, a aVar) {
            this(i10, j10, j11);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f28648a);
            parcel.writeLong(this.f28649b);
            parcel.writeLong(this.f28650c);
        }

        private b(int i10, long j10, long j11) {
            this.f28648a = i10;
            this.f28649b = j10;
            this.f28650c = j11;
        }
    }

    /* synthetic */ d(Parcel parcel, a aVar) {
        this(parcel);
    }

    static d a(c0 c0Var, long j10, l0 l0Var) {
        List list;
        boolean z10;
        boolean z11;
        long j11;
        boolean z12;
        long j12;
        int iJ;
        int iD;
        int iD2;
        boolean z13;
        boolean z14;
        long jF;
        long jF2 = c0Var.F();
        boolean z15 = (c0Var.D() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z15) {
            list = listEmptyList;
            z10 = false;
            z11 = false;
            j11 = C.TIME_UNSET;
            z12 = false;
            j12 = C.TIME_UNSET;
            iJ = 0;
            iD = 0;
            iD2 = 0;
            z13 = false;
        } else {
            int iD3 = c0Var.D();
            boolean z16 = (iD3 & 128) != 0;
            boolean z17 = (iD3 & 64) != 0;
            boolean z18 = (iD3 & 32) != 0;
            boolean z19 = (iD3 & 16) != 0;
            long jB = (!z17 || z19) ? C.TIME_UNSET : g.b(c0Var, j10);
            if (!z17) {
                int iD4 = c0Var.D();
                ArrayList arrayList = new ArrayList(iD4);
                for (int i10 = 0; i10 < iD4; i10++) {
                    int iD5 = c0Var.D();
                    long jB2 = !z19 ? g.b(c0Var, j10) : C.TIME_UNSET;
                    arrayList.add(new b(iD5, jB2, l0Var.b(jB2), null));
                }
                listEmptyList = arrayList;
            }
            if (z18) {
                long jD = c0Var.D();
                boolean z20 = (128 & jD) != 0;
                jF = ((((jD & 1) << 32) | c0Var.F()) * 1000) / 90;
                z14 = z20;
            } else {
                z14 = false;
                jF = C.TIME_UNSET;
            }
            iJ = c0Var.J();
            z13 = z17;
            iD = c0Var.D();
            iD2 = c0Var.D();
            list = listEmptyList;
            long j13 = jB;
            z12 = z14;
            j12 = jF;
            z11 = z19;
            z10 = z16;
            j11 = j13;
        }
        return new d(jF2, z15, z10, z13, z11, j11, l0Var.b(j11), list, z12, j12, iJ, iD, iD2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f28635a);
        parcel.writeByte(this.f28636b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f28637c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f28638d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f28639e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f28640f);
        parcel.writeLong(this.f28641g);
        int size = this.f28642h.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f28642h.get(i11).b(parcel);
        }
        parcel.writeByte(this.f28643i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f28644j);
        parcel.writeInt(this.f28645k);
        parcel.writeInt(this.f28646l);
        parcel.writeInt(this.f28647m);
    }

    private d(long j10, boolean z10, boolean z11, boolean z12, boolean z13, long j11, long j12, List<b> list, boolean z14, long j13, int i10, int i11, int i12) {
        this.f28635a = j10;
        this.f28636b = z10;
        this.f28637c = z11;
        this.f28638d = z12;
        this.f28639e = z13;
        this.f28640f = j11;
        this.f28641g = j12;
        this.f28642h = Collections.unmodifiableList(list);
        this.f28643i = z14;
        this.f28644j = j13;
        this.f28645k = i10;
        this.f28646l = i11;
        this.f28647m = i12;
    }

    private d(Parcel parcel) {
        this.f28635a = parcel.readLong();
        this.f28636b = parcel.readByte() == 1;
        this.f28637c = parcel.readByte() == 1;
        this.f28638d = parcel.readByte() == 1;
        this.f28639e = parcel.readByte() == 1;
        this.f28640f = parcel.readLong();
        this.f28641g = parcel.readLong();
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(b.a(parcel));
        }
        this.f28642h = Collections.unmodifiableList(arrayList);
        this.f28643i = parcel.readByte() == 1;
        this.f28644j = parcel.readLong();
        this.f28645k = parcel.readInt();
        this.f28646l = parcel.readInt();
        this.f28647m = parcel.readInt();
    }
}
