package x3;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import com.google.common.collect.l0;
import com.google.common.collect.m0;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k2.n3;
import l3.a0;
import l3.c1;
import x3.s;

/* JADX INFO: compiled from: AdaptiveTrackSelection.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final z3.e f35900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f35901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f35902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f35903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f35904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f35905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f35906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float f35907o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final com.google.common.collect.y<C0732a> f35908p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final a4.d f35909q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f35910r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f35911s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f35912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f35913u;

    /* JADX INFO: renamed from: x3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdaptiveTrackSelection.java */
    public static final class C0732a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f35914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f35915b;

        public C0732a(long j10, long j11) {
            this.f35914a = j10;
            this.f35915b = j11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0732a)) {
                return false;
            }
            C0732a c0732a = (C0732a) obj;
            return this.f35914a == c0732a.f35914a && this.f35915b == c0732a.f35915b;
        }

        public int hashCode() {
            return (((int) this.f35914a) * 31) + ((int) this.f35915b);
        }
    }

    /* JADX INFO: compiled from: AdaptiveTrackSelection.java */
    public static class b implements s.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f35918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f35919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f35920e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f35921f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final float f35922g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final a4.d f35923h;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // x3.s.b
        public final s[] a(s.a[] aVarArr, z3.e eVar, a0.b bVar, n3 n3Var) {
            com.google.common.collect.y yVarE = a.e(aVarArr);
            s[] sVarArr = new s[aVarArr.length];
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                s.a aVar = aVarArr[i10];
                if (aVar != null) {
                    int[] iArr = aVar.f36013b;
                    if (iArr.length != 0) {
                        sVarArr[i10] = iArr.length == 1 ? new t(aVar.f36012a, iArr[0], aVar.f36014c) : b(aVar.f36012a, iArr, aVar.f36014c, eVar, (com.google.common.collect.y) yVarE.get(i10));
                    }
                }
            }
            return sVarArr;
        }

        protected a b(c1 c1Var, int[] iArr, int i10, z3.e eVar, com.google.common.collect.y<C0732a> yVar) {
            return new a(c1Var, iArr, i10, eVar, this.f35916a, this.f35917b, this.f35918c, this.f35919d, this.f35920e, this.f35921f, this.f35922g, yVar, this.f35923h);
        }

        public b(int i10, int i11, int i12, float f10) {
            this(i10, i11, i12, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f10, 0.75f, a4.d.f148a);
        }

        public b(int i10, int i11, int i12, int i13, int i14, float f10, float f11, a4.d dVar) {
            this.f35916a = i10;
            this.f35917b = i11;
            this.f35918c = i12;
            this.f35919d = i13;
            this.f35920e = i14;
            this.f35921f = f10;
            this.f35922g = f11;
            this.f35923h = dVar;
        }
    }

    protected a(c1 c1Var, int[] iArr, int i10, z3.e eVar, long j10, long j11, long j12, int i11, int i12, float f10, float f11, List<C0732a> list, a4.d dVar) {
        z3.e eVar2;
        long j13;
        super(c1Var, iArr, i10);
        if (j12 < j10) {
            a4.t.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            eVar2 = eVar;
            j13 = j10;
        } else {
            eVar2 = eVar;
            j13 = j12;
        }
        this.f35900h = eVar2;
        this.f35901i = j10 * 1000;
        this.f35902j = j11 * 1000;
        this.f35903k = j13 * 1000;
        this.f35904l = i11;
        this.f35905m = i12;
        this.f35906n = f10;
        this.f35907o = f11;
        this.f35908p = com.google.common.collect.y.m(list);
        this.f35909q = dVar;
        this.f35910r = 1.0f;
        this.f35912t = 0;
        this.f35913u = C.TIME_UNSET;
    }

    private static void d(List<y.a<C0732a>> list, long[] jArr) {
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            y.a<C0732a> aVar = list.get(i10);
            if (aVar != null) {
                aVar.a(new C0732a(j10, jArr[i10]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.google.common.collect.y<com.google.common.collect.y<C0732a>> e(s.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (s.a aVar : aVarArr) {
            if (aVar == null || aVar.f36013b.length <= 1) {
                arrayList.add(null);
            } else {
                y.a aVarK = com.google.common.collect.y.k();
                aVarK.a(new C0732a(0L, 0L));
                arrayList.add(aVarK);
            }
        }
        long[][] jArrF = f(aVarArr);
        int[] iArr = new int[jArrF.length];
        long[] jArr = new long[jArrF.length];
        for (int i10 = 0; i10 < jArrF.length; i10++) {
            long[] jArr2 = jArrF[i10];
            jArr[i10] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        d(arrayList, jArr);
        com.google.common.collect.y<Integer> yVarG = g(jArrF);
        for (int i11 = 0; i11 < yVarG.size(); i11++) {
            int iIntValue = yVarG.get(i11).intValue();
            int i12 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i12;
            jArr[iIntValue] = jArrF[iIntValue][i12];
            d(arrayList, jArr);
        }
        for (int i13 = 0; i13 < aVarArr.length; i13++) {
            if (arrayList.get(i13) != null) {
                jArr[i13] = jArr[i13] * 2;
            }
        }
        d(arrayList, jArr);
        y.a aVarK2 = com.google.common.collect.y.k();
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            y.a aVar2 = (y.a) arrayList.get(i14);
            aVarK2.a(aVar2 == null ? com.google.common.collect.y.q() : aVar2.k());
        }
        return aVarK2.k();
    }

    private static long[][] f(s.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            s.a aVar = aVarArr[i10];
            if (aVar == null) {
                jArr[i10] = new long[0];
            } else {
                jArr[i10] = new long[aVar.f36013b.length];
                int i11 = 0;
                while (true) {
                    int[] iArr = aVar.f36013b;
                    if (i11 >= iArr.length) {
                        break;
                    }
                    long j10 = aVar.f36012a.c(iArr[i11]).f29343h;
                    long[] jArr2 = jArr[i10];
                    if (j10 == -1) {
                        j10 = 0;
                    }
                    jArr2[i11] = j10;
                    i11++;
                }
                Arrays.sort(jArr[i10]);
            }
        }
        return jArr;
    }

    private static com.google.common.collect.y<Integer> g(long[][] jArr) {
        l0 l0VarE = m0.c().a().e();
        for (int i10 = 0; i10 < jArr.length; i10++) {
            long[] jArr2 = jArr[i10];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i11 = 0;
                while (true) {
                    long[] jArr3 = jArr[i10];
                    double dLog = 0.0d;
                    if (i11 >= jArr3.length) {
                        break;
                    }
                    long j10 = jArr3[i11];
                    if (j10 != -1) {
                        dLog = Math.log(j10);
                    }
                    dArr[i11] = dLog;
                    i11++;
                }
                int i12 = length - 1;
                double d10 = dArr[i12] - dArr[0];
                int i13 = 0;
                while (i13 < i12) {
                    double d11 = dArr[i13];
                    i13++;
                    l0VarE.put(Double.valueOf(d10 == 0.0d ? 1.0d : (((d11 + dArr[i13]) * 0.5d) - dArr[0]) / d10), Integer.valueOf(i10));
                }
            }
        }
        return com.google.common.collect.y.m(l0VarE.values());
    }

    @Override // x3.c, x3.s
    @CallSuper
    public void enable() {
        this.f35913u = C.TIME_UNSET;
    }

    @Override // x3.s
    public int getSelectedIndex() {
        return this.f35911s;
    }

    @Override // x3.c, x3.s
    public void onPlaybackSpeed(float f10) {
        this.f35910r = f10;
    }

    @Override // x3.c, x3.s
    @CallSuper
    public void disable() {
    }
}
