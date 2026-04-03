package j3;

import a4.c0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SpliceScheduleCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends j3.b {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f28651a;

    /* JADX INFO: compiled from: SpliceScheduleCommand.java */
    class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    /* JADX INFO: compiled from: SpliceScheduleCommand.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f28652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f28653b;

        /* synthetic */ b(int i10, long j10, a aVar) {
            this(i10, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.f28652a);
            parcel.writeLong(this.f28653b);
        }

        private b(int i10, long j10) {
            this.f28652a = i10;
            this.f28653b = j10;
        }
    }

    /* synthetic */ f(Parcel parcel, a aVar) {
        this(parcel);
    }

    static f a(c0 c0Var) {
        int iD = c0Var.D();
        ArrayList arrayList = new ArrayList(iD);
        for (int i10 = 0; i10 < iD; i10++) {
            arrayList.add(c.e(c0Var));
        }
        return new f(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int size = this.f28651a.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f28651a.get(i11).f(parcel);
        }
    }

    private f(List<c> list) {
        this.f28651a = Collections.unmodifiableList(list);
    }

    private f(Parcel parcel) {
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(c.d(parcel));
        }
        this.f28651a = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: compiled from: SpliceScheduleCommand.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f28654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f28655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f28656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f28657d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f28658e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<b> f28659f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f28660g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f28661h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f28662i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f28663j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f28664k;

        private c(long j10, boolean z10, boolean z11, boolean z12, List<b> list, long j11, boolean z13, long j12, int i10, int i11, int i12) {
            this.f28654a = j10;
            this.f28655b = z10;
            this.f28656c = z11;
            this.f28657d = z12;
            this.f28659f = Collections.unmodifiableList(list);
            this.f28658e = j11;
            this.f28660g = z13;
            this.f28661h = j12;
            this.f28662i = i10;
            this.f28663j = i11;
            this.f28664k = i12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c e(c0 c0Var) {
            ArrayList arrayList;
            boolean z10;
            long j10;
            boolean z11;
            long j11;
            int i10;
            int i11;
            int iD;
            boolean z12;
            boolean z13;
            long jF;
            long jF2 = c0Var.F();
            boolean z14 = (c0Var.D() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z14) {
                arrayList = arrayList2;
                z10 = false;
                j10 = C.TIME_UNSET;
                z11 = false;
                j11 = C.TIME_UNSET;
                i10 = 0;
                i11 = 0;
                iD = 0;
                z12 = false;
            } else {
                int iD2 = c0Var.D();
                boolean z15 = (iD2 & 128) != 0;
                boolean z16 = (iD2 & 64) != 0;
                boolean z17 = (iD2 & 32) != 0;
                long jF3 = z16 ? c0Var.F() : C.TIME_UNSET;
                if (!z16) {
                    int iD3 = c0Var.D();
                    ArrayList arrayList3 = new ArrayList(iD3);
                    for (int i12 = 0; i12 < iD3; i12++) {
                        arrayList3.add(new b(c0Var.D(), c0Var.F(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z17) {
                    long jD = c0Var.D();
                    boolean z18 = (128 & jD) != 0;
                    jF = ((((jD & 1) << 32) | c0Var.F()) * 1000) / 90;
                    z13 = z18;
                } else {
                    z13 = false;
                    jF = C.TIME_UNSET;
                }
                int iJ = c0Var.J();
                int iD4 = c0Var.D();
                z12 = z16;
                iD = c0Var.D();
                j11 = jF;
                arrayList = arrayList2;
                long j12 = jF3;
                i10 = iJ;
                i11 = iD4;
                j10 = j12;
                boolean z19 = z15;
                z11 = z13;
                z10 = z19;
            }
            return new c(jF2, z14, z10, z12, arrayList, j10, z11, j11, i10, i11, iD);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(Parcel parcel) {
            parcel.writeLong(this.f28654a);
            parcel.writeByte(this.f28655b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f28656c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f28657d ? (byte) 1 : (byte) 0);
            int size = this.f28659f.size();
            parcel.writeInt(size);
            for (int i10 = 0; i10 < size; i10++) {
                this.f28659f.get(i10).d(parcel);
            }
            parcel.writeLong(this.f28658e);
            parcel.writeByte(this.f28660g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f28661h);
            parcel.writeInt(this.f28662i);
            parcel.writeInt(this.f28663j);
            parcel.writeInt(this.f28664k);
        }

        private c(Parcel parcel) {
            this.f28654a = parcel.readLong();
            this.f28655b = parcel.readByte() == 1;
            this.f28656c = parcel.readByte() == 1;
            this.f28657d = parcel.readByte() == 1;
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(b.c(parcel));
            }
            this.f28659f = Collections.unmodifiableList(arrayList);
            this.f28658e = parcel.readLong();
            this.f28660g = parcel.readByte() == 1;
            this.f28661h = parcel.readLong();
            this.f28662i = parcel.readInt();
            this.f28663j = parcel.readInt();
            this.f28664k = parcel.readInt();
        }
    }
}
