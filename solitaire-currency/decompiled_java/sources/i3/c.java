package i3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import c3.a;
import com.google.common.collect.p;
import e5.k;
import i3.c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: SlowMotionData.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a.b {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f26579a;

    /* JADX INFO: compiled from: SlowMotionData.java */
    class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, b.class.getClassLoader());
            return new c(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i10) {
            return new c[i10];
        }
    }

    /* JADX INFO: compiled from: SlowMotionData.java */
    public static final class b implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f26581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f26582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f26583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Comparator<b> f26580d = new Comparator() { // from class: i3.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.b.b((c.b) obj, (c.b) obj2);
            }
        };
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: compiled from: SlowMotionData.java */
        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i10) {
                return new b[i10];
            }
        }

        public b(long j10, long j11, int i10) {
            a4.a.a(j10 < j11);
            this.f26581a = j10;
            this.f26582b = j11;
            this.f26583c = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int b(b bVar, b bVar2) {
            return p.j().e(bVar.f26581a, bVar2.f26581a).e(bVar.f26582b, bVar2.f26582b).d(bVar.f26583c, bVar2.f26583c).i();
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
            return this.f26581a == bVar.f26581a && this.f26582b == bVar.f26582b && this.f26583c == bVar.f26583c;
        }

        public int hashCode() {
            return k.b(Long.valueOf(this.f26581a), Long.valueOf(this.f26582b), Integer.valueOf(this.f26583c));
        }

        public String toString() {
            return o0.z("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f26581a), Long.valueOf(this.f26582b), Integer.valueOf(this.f26583c));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeLong(this.f26581a);
            parcel.writeLong(this.f26582b);
            parcel.writeInt(this.f26583c);
        }
    }

    public c(List<b> list) {
        this.f26579a = list;
        a4.a.a(!a(list));
    }

    private static boolean a(List<b> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j10 = list.get(0).f26582b;
        for (int i10 = 1; i10 < list.size(); i10++) {
            if (list.get(i10).f26581a < j10) {
                return true;
            }
            j10 = list.get(i10).f26582b;
        }
        return false;
    }

    @Override // android.os.Parcelable
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
        return this.f26579a.equals(((c) obj).f26579a);
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
        return this.f26579a.hashCode();
    }

    @Override // c3.a.b
    public /* synthetic */ void i(b2.b bVar) {
        c3.b.c(this, bVar);
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f26579a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f26579a);
    }
}
