package m3;

import a4.o0;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Arrays;
import k2.h;
import m3.c;

/* JADX INFO: compiled from: AdPlaybackState.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f31432g = new c(null, new a[0], 0, C.TIME_UNSET, 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f31433h = new a(0).j(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h.a<c> f31434i = new h.a() { // from class: m3.a
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return c.b(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f31435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f31436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f31437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f31438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f31439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a[] f31440f;

    /* JADX INFO: compiled from: AdPlaybackState.java */
    public static final class a implements h {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final h.a<a> f31441i = new h.a() { // from class: m3.b
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return c.a.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f31442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri[] f31445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f31446e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long[] f31447f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f31448g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f31449h;

        public a(long j10) {
            this(j10, -1, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        @CheckResult
        private static long[] b(long[] jArr, int i10) {
            int length = jArr.length;
            int iMax = Math.max(i10, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, C.TIME_UNSET);
            return jArrCopyOf;
        }

        @CheckResult
        private static int[] c(int[] iArr, int i10) {
            int length = iArr.length;
            int iMax = Math.max(i10, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a d(Bundle bundle) {
            long j10 = bundle.getLong(h(0));
            int i10 = bundle.getInt(h(1), -1);
            int i11 = bundle.getInt(h(7), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(h(2));
            int[] intArray = bundle.getIntArray(h(3));
            long[] longArray = bundle.getLongArray(h(4));
            long j11 = bundle.getLong(h(5));
            boolean z10 = bundle.getBoolean(h(6));
            if (intArray == null) {
                intArray = new int[0];
            }
            return new a(j10, i10, i11, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j11, z10);
        }

        private static String h(int i10) {
            return Integer.toString(i10, 36);
        }

        public int e() {
            return f(-1);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f31442a == aVar.f31442a && this.f31443b == aVar.f31443b && this.f31444c == aVar.f31444c && Arrays.equals(this.f31445d, aVar.f31445d) && Arrays.equals(this.f31446e, aVar.f31446e) && Arrays.equals(this.f31447f, aVar.f31447f) && this.f31448g == aVar.f31448g && this.f31449h == aVar.f31449h;
        }

        public int f(@IntRange(from = -1) int i10) {
            int i11;
            int i12 = i10 + 1;
            while (true) {
                int[] iArr = this.f31446e;
                if (i12 >= iArr.length || this.f31449h || (i11 = iArr[i12]) == 0 || i11 == 1) {
                    break;
                }
                i12++;
            }
            return i12;
        }

        public boolean g() {
            if (this.f31443b == -1) {
                return true;
            }
            for (int i10 = 0; i10 < this.f31443b; i10++) {
                int i11 = this.f31446e[i10];
                if (i11 == 0 || i11 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i10 = ((this.f31443b * 31) + this.f31444c) * 31;
            long j10 = this.f31442a;
            int iHashCode = (((((((i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + Arrays.hashCode(this.f31445d)) * 31) + Arrays.hashCode(this.f31446e)) * 31) + Arrays.hashCode(this.f31447f)) * 31;
            long j11 = this.f31448g;
            return ((iHashCode + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f31449h ? 1 : 0);
        }

        public boolean i() {
            return this.f31443b == -1 || e() < this.f31443b;
        }

        @CheckResult
        public a j(int i10) {
            int[] iArrC = c(this.f31446e, i10);
            long[] jArrB = b(this.f31447f, i10);
            return new a(this.f31442a, i10, this.f31444c, iArrC, (Uri[]) Arrays.copyOf(this.f31445d, i10), jArrB, this.f31448g, this.f31449h);
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(h(0), this.f31442a);
            bundle.putInt(h(1), this.f31443b);
            bundle.putInt(h(7), this.f31444c);
            bundle.putParcelableArrayList(h(2), new ArrayList<>(Arrays.asList(this.f31445d)));
            bundle.putIntArray(h(3), this.f31446e);
            bundle.putLongArray(h(4), this.f31447f);
            bundle.putLong(h(5), this.f31448g);
            bundle.putBoolean(h(6), this.f31449h);
            return bundle;
        }

        private a(long j10, int i10, int i11, int[] iArr, Uri[] uriArr, long[] jArr, long j11, boolean z10) {
            a4.a.a(iArr.length == uriArr.length);
            this.f31442a = j10;
            this.f31443b = i10;
            this.f31444c = i11;
            this.f31446e = iArr;
            this.f31445d = uriArr;
            this.f31447f = jArr;
            this.f31448g = j11;
            this.f31449h = z10;
        }
    }

    private c(@Nullable Object obj, a[] aVarArr, long j10, long j11, int i10) {
        this.f31435a = obj;
        this.f31437c = j10;
        this.f31438d = j11;
        this.f31436b = aVarArr.length + i10;
        this.f31440f = aVarArr;
        this.f31439e = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c b(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(g(1));
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
                aVarArr2[i10] = (a) a.f31441i.fromBundle((Bundle) parcelableArrayList.get(i10));
            }
            aVarArr = aVarArr2;
        }
        return new c(null, aVarArr, bundle.getLong(g(2), 0L), bundle.getLong(g(3), C.TIME_UNSET), bundle.getInt(g(4)));
    }

    private boolean f(long j10, long j11, int i10) {
        if (j10 == Long.MIN_VALUE) {
            return false;
        }
        long j12 = c(i10).f31442a;
        return j12 == Long.MIN_VALUE ? j11 == C.TIME_UNSET || j10 < j11 : j10 < j12;
    }

    private static String g(int i10) {
        return Integer.toString(i10, 36);
    }

    public a c(@IntRange(from = 0) int i10) {
        int i11 = this.f31439e;
        return i10 < i11 ? f31433h : this.f31440f[i10 - i11];
    }

    public int d(long j10, long j11) {
        if (j10 == Long.MIN_VALUE) {
            return -1;
        }
        if (j11 != C.TIME_UNSET && j10 >= j11) {
            return -1;
        }
        int i10 = this.f31439e;
        while (i10 < this.f31436b && ((c(i10).f31442a != Long.MIN_VALUE && c(i10).f31442a <= j10) || !c(i10).i())) {
            i10++;
        }
        if (i10 < this.f31436b) {
            return i10;
        }
        return -1;
    }

    public int e(long j10, long j11) {
        int i10 = this.f31436b - 1;
        while (i10 >= 0 && f(j10, j11, i10)) {
            i10--;
        }
        if (i10 < 0 || !c(i10).g()) {
            return -1;
        }
        return i10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return o0.c(this.f31435a, cVar.f31435a) && this.f31436b == cVar.f31436b && this.f31437c == cVar.f31437c && this.f31438d == cVar.f31438d && this.f31439e == cVar.f31439e && Arrays.equals(this.f31440f, cVar.f31440f);
    }

    public int hashCode() {
        int i10 = this.f31436b * 31;
        Object obj = this.f31435a;
        return ((((((((i10 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f31437c)) * 31) + ((int) this.f31438d)) * 31) + this.f31439e) * 31) + Arrays.hashCode(this.f31440f);
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (a aVar : this.f31440f) {
            arrayList.add(aVar.toBundle());
        }
        bundle.putParcelableArrayList(g(1), arrayList);
        bundle.putLong(g(2), this.f31437c);
        bundle.putLong(g(3), this.f31438d);
        bundle.putInt(g(4), this.f31439e);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f31435a);
        sb.append(", adResumePositionUs=");
        sb.append(this.f31437c);
        sb.append(", adGroups=[");
        for (int i10 = 0; i10 < this.f31440f.length; i10++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f31440f[i10].f31442a);
            sb.append(", ads=[");
            for (int i11 = 0; i11 < this.f31440f[i10].f31446e.length; i11++) {
                sb.append("ad(state=");
                int i12 = this.f31440f[i10].f31446e[i11];
                if (i12 == 0) {
                    sb.append('_');
                } else if (i12 == 1) {
                    sb.append('R');
                } else if (i12 == 2) {
                    sb.append('S');
                } else if (i12 == 3) {
                    sb.append('P');
                } else if (i12 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f31440f[i10].f31447f[i11]);
                sb.append(')');
                if (i11 < this.f31440f[i10].f31446e.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i10 < this.f31440f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
