package x3;

import a4.o0;
import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import com.google.common.collect.s0;
import com.google.common.collect.y;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import k2.b3;
import k2.d3;
import k2.h;
import k2.n3;
import k2.o1;
import l3.a0;
import l3.c1;
import l3.e1;
import x3.a;
import x3.m;
import x3.s;
import x3.u;
import x3.z;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final s0<Integer> f35946k = s0.b(new Comparator() { // from class: x3.f
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return m.P((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final s0<Integer> f35947l = s0.b(new Comparator() { // from class: x3.g
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return m.Q((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f35948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Context f35949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s.b f35950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f35951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private d f35952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private f f35953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private m2.e f35954j;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    static final class b extends h<b> implements Comparable<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f35955e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f35956f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private final String f35957g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final d f35958h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f35959i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f35960j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f35961k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f35962l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final boolean f35963m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f35964n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final int f35965o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final boolean f35966p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final int f35967q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final int f35968r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final int f35969s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final int f35970t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f35971u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final boolean f35972v;

        public b(int i10, c1 c1Var, int i11, d dVar, int i12, boolean z10, e5.p<o1> pVar) {
            int i13;
            int iD;
            int iD2;
            super(i10, c1Var, i11);
            this.f35958h = dVar;
            this.f35957g = m.T(this.f35997d.f29338c);
            this.f35959i = m.L(i12, false);
            int i14 = 0;
            while (true) {
                i13 = Integer.MAX_VALUE;
                if (i14 >= dVar.f36041n.size()) {
                    iD = 0;
                    i14 = Integer.MAX_VALUE;
                    break;
                } else {
                    iD = m.D(this.f35997d, dVar.f36041n.get(i14), false);
                    if (iD > 0) {
                        break;
                    } else {
                        i14++;
                    }
                }
            }
            this.f35961k = i14;
            this.f35960j = iD;
            this.f35962l = m.H(this.f35997d.f29340e, dVar.f36042o);
            o1 o1Var = this.f35997d;
            int i15 = o1Var.f29340e;
            this.f35963m = i15 == 0 || (i15 & 1) != 0;
            this.f35966p = (o1Var.f29339d & 1) != 0;
            int i16 = o1Var.f29360y;
            this.f35967q = i16;
            this.f35968r = o1Var.f29361z;
            int i17 = o1Var.f29343h;
            this.f35969s = i17;
            this.f35956f = (i17 == -1 || i17 <= dVar.f36044q) && (i16 == -1 || i16 <= dVar.f36043p) && pVar.apply(o1Var);
            String[] strArrC0 = o0.c0();
            int i18 = 0;
            while (true) {
                if (i18 >= strArrC0.length) {
                    iD2 = 0;
                    i18 = Integer.MAX_VALUE;
                    break;
                } else {
                    iD2 = m.D(this.f35997d, strArrC0[i18], false);
                    if (iD2 > 0) {
                        break;
                    } else {
                        i18++;
                    }
                }
            }
            this.f35964n = i18;
            this.f35965o = iD2;
            int i19 = 0;
            while (true) {
                if (i19 < dVar.f36045r.size()) {
                    String str = this.f35997d.f29347l;
                    if (str != null && str.equals(dVar.f36045r.get(i19))) {
                        i13 = i19;
                        break;
                    }
                    i19++;
                } else {
                    break;
                }
            }
            this.f35970t = i13;
            this.f35971u = b3.e(i12) == 128;
            this.f35972v = b3.g(i12) == 64;
            this.f35955e = g(i12, z10);
        }

        public static int d(List<b> list, List<b> list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static com.google.common.collect.y<b> f(int i10, c1 c1Var, d dVar, int[] iArr, boolean z10, e5.p<o1> pVar) {
            y.a aVarK = com.google.common.collect.y.k();
            for (int i11 = 0; i11 < c1Var.f30482a; i11++) {
                aVarK.a(new b(i10, c1Var, i11, dVar, iArr[i11], z10, pVar));
            }
            return aVarK.k();
        }

        private int g(int i10, boolean z10) {
            if (!m.L(i10, this.f35958h.N)) {
                return 0;
            }
            if (!this.f35956f && !this.f35958h.H) {
                return 0;
            }
            if (m.L(i10, false) && this.f35956f && this.f35997d.f29343h != -1) {
                d dVar = this.f35958h;
                if (!dVar.f36051x && !dVar.f36050w && (dVar.P || !z10)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // x3.m.h
        public int a() {
            return this.f35955e;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            s0 s0VarG = (this.f35956f && this.f35959i) ? m.f35946k : m.f35946k.g();
            com.google.common.collect.p pVarF = com.google.common.collect.p.j().g(this.f35959i, bVar.f35959i).f(Integer.valueOf(this.f35961k), Integer.valueOf(bVar.f35961k), s0.d().g()).d(this.f35960j, bVar.f35960j).d(this.f35962l, bVar.f35962l).g(this.f35966p, bVar.f35966p).g(this.f35963m, bVar.f35963m).f(Integer.valueOf(this.f35964n), Integer.valueOf(bVar.f35964n), s0.d().g()).d(this.f35965o, bVar.f35965o).g(this.f35956f, bVar.f35956f).f(Integer.valueOf(this.f35970t), Integer.valueOf(bVar.f35970t), s0.d().g()).f(Integer.valueOf(this.f35969s), Integer.valueOf(bVar.f35969s), this.f35958h.f36050w ? m.f35946k.g() : m.f35947l).g(this.f35971u, bVar.f35971u).g(this.f35972v, bVar.f35972v).f(Integer.valueOf(this.f35967q), Integer.valueOf(bVar.f35967q), s0VarG).f(Integer.valueOf(this.f35968r), Integer.valueOf(bVar.f35968r), s0VarG);
            Integer numValueOf = Integer.valueOf(this.f35969s);
            Integer numValueOf2 = Integer.valueOf(bVar.f35969s);
            if (!o0.c(this.f35957g, bVar.f35957g)) {
                s0VarG = m.f35947l;
            }
            return pVarF.f(numValueOf, numValueOf2, s0VarG).i();
        }

        @Override // x3.m.h
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean c(b bVar) {
            int i10;
            String str;
            int i11;
            d dVar = this.f35958h;
            if ((dVar.K || ((i11 = this.f35997d.f29360y) != -1 && i11 == bVar.f35997d.f29360y)) && (dVar.I || ((str = this.f35997d.f29347l) != null && TextUtils.equals(str, bVar.f35997d.f29347l)))) {
                d dVar2 = this.f35958h;
                if ((dVar2.J || ((i10 = this.f35997d.f29361z) != -1 && i10 == bVar.f35997d.f29361z)) && (dVar2.L || (this.f35971u == bVar.f35971u && this.f35972v == bVar.f35972v))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    private static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f35973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f35974b;

        public c(o1 o1Var, int i10) {
            this.f35973a = (o1Var.f29339d & 1) != 0;
            this.f35974b = m.L(i10, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return com.google.common.collect.p.j().g(this.f35974b, cVar.f35974b).g(this.f35973a, cVar.f35973a).i();
        }
    }

    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class d extends z {
        public static final d S;

        @Deprecated
        public static final d T;
        public static final h.a<d> U;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final boolean K;
        public final boolean L;
        public final boolean M;
        public final boolean N;
        public final boolean O;
        public final boolean P;
        private final SparseArray<Map<e1, e>> Q;
        private final SparseBooleanArray R;

        static {
            d dVarA = new a().A();
            S = dVarA;
            T = dVarA;
            U = new h.a() { // from class: x3.n
                @Override // k2.h.a
                public final k2.h fromBundle(Bundle bundle) {
                    return m.d.p(bundle);
                }
            };
        }

        private static boolean g(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i10)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean h(SparseArray<Map<e1, e>> sparseArray, SparseArray<Map<e1, e>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i10));
                if (iIndexOfKey < 0 || !i(sparseArray.valueAt(i10), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean i(Map<e1, e> map, Map<e1, e> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<e1, e> entry : map.entrySet()) {
                e1 key = entry.getKey();
                if (!map2.containsKey(key) || !o0.c(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public static d k(Context context) {
            return new a(context).A();
        }

        private static int[] l(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i10 = 0; i10 < sparseBooleanArray.size(); i10++) {
                iArr[i10] = sparseBooleanArray.keyAt(i10);
            }
            return iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d p(Bundle bundle) {
            return new a(bundle).A();
        }

        private static void q(Bundle bundle, SparseArray<Map<e1, e>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                int iKeyAt = sparseArray.keyAt(i10);
                for (Map.Entry<e1, e> entry : sparseArray.valueAt(i10).entrySet()) {
                    e value = entry.getValue();
                    if (value != null) {
                        sparseArray2.put(arrayList2.size(), value);
                    }
                    arrayList2.add(entry.getKey());
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
                bundle.putIntArray(z.c(1010), g5.e.k(arrayList));
                bundle.putParcelableArrayList(z.c(1011), a4.c.d(arrayList2));
                bundle.putSparseParcelableArray(z.c(1012), a4.c.e(sparseArray2));
            }
        }

        @Override // x3.z
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.D == dVar.D && this.E == dVar.E && this.F == dVar.F && this.G == dVar.G && this.H == dVar.H && this.I == dVar.I && this.J == dVar.J && this.K == dVar.K && this.L == dVar.L && this.M == dVar.M && this.N == dVar.N && this.O == dVar.O && this.P == dVar.P && g(this.R, dVar.R) && h(this.Q, dVar.Q);
        }

        @Override // x3.z
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + (this.J ? 1 : 0)) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 31) + (this.N ? 1 : 0)) * 31) + (this.O ? 1 : 0)) * 31) + (this.P ? 1 : 0);
        }

        @Override // x3.z
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a();
        }

        public boolean m(int i10) {
            return this.R.get(i10);
        }

        @Nullable
        @Deprecated
        public e n(int i10, e1 e1Var) {
            Map<e1, e> map = this.Q.get(i10);
            if (map != null) {
                return map.get(e1Var);
            }
            return null;
        }

        @Deprecated
        public boolean o(int i10, e1 e1Var) {
            Map<e1, e> map = this.Q.get(i10);
            return map != null && map.containsKey(e1Var);
        }

        @Override // x3.z, k2.h
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(z.c(1000), this.D);
            bundle.putBoolean(z.c(1001), this.E);
            bundle.putBoolean(z.c(1002), this.F);
            bundle.putBoolean(z.c(1014), this.G);
            bundle.putBoolean(z.c(1003), this.H);
            bundle.putBoolean(z.c(1004), this.I);
            bundle.putBoolean(z.c(1005), this.J);
            bundle.putBoolean(z.c(1006), this.K);
            bundle.putBoolean(z.c(1015), this.L);
            bundle.putBoolean(z.c(1016), this.M);
            bundle.putBoolean(z.c(1007), this.N);
            bundle.putBoolean(z.c(1008), this.O);
            bundle.putBoolean(z.c(1009), this.P);
            q(bundle, this.Q);
            bundle.putIntArray(z.c(1013), l(this.R));
            return bundle;
        }

        /* JADX INFO: compiled from: DefaultTrackSelector.java */
        public static final class a extends z.a {
            private boolean A;
            private boolean B;
            private boolean C;
            private boolean D;
            private boolean E;
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private final SparseArray<Map<e1, e>> N;
            private final SparseBooleanArray O;

            private static SparseArray<Map<e1, e>> d0(SparseArray<Map<e1, e>> sparseArray) {
                SparseArray<Map<e1, e>> sparseArray2 = new SparseArray<>();
                for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                    sparseArray2.put(sparseArray.keyAt(i10), new HashMap(sparseArray.valueAt(i10)));
                }
                return sparseArray2;
            }

            private void e0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }

            private SparseBooleanArray f0(@Nullable int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i10 : iArr) {
                    sparseBooleanArray.append(i10, true);
                }
                return sparseBooleanArray;
            }

            /* JADX WARN: Multi-variable type inference failed */
            private void x0(Bundle bundle) {
                int[] intArray = bundle.getIntArray(z.c(1010));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(z.c(1011));
                com.google.common.collect.y yVarQ = parcelableArrayList == null ? com.google.common.collect.y.q() : a4.c.b(e1.f30516e, parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(z.c(1012));
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : a4.c.c(e.f35975e, sparseParcelableArray);
                if (intArray == null || intArray.length != yVarQ.size()) {
                    return;
                }
                for (int i10 = 0; i10 < intArray.length; i10++) {
                    w0(intArray[i10], (e1) yVarQ.get(i10), (e) sparseArray.get(i10));
                }
            }

            @Override // x3.z.a
            /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
            public a K(int i10, int i11, boolean z10) {
                super.K(i10, i11, z10);
                return this;
            }

            @Override // x3.z.a
            /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
            public a L(Context context, boolean z10) {
                super.L(context, z10);
                return this;
            }

            @Override // x3.z.a
            /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
            public d A() {
                return new d(this);
            }

            @Override // x3.z.a
            /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
            public a B(int i10) {
                super.B(i10);
                return this;
            }

            protected a g0(z zVar) {
                super.E(zVar);
                return this;
            }

            public a h0(boolean z10) {
                this.H = z10;
                return this;
            }

            public a i0(boolean z10) {
                this.I = z10;
                return this;
            }

            public a j0(boolean z10) {
                this.F = z10;
                return this;
            }

            public a k0(boolean z10) {
                this.G = z10;
                return this;
            }

            public a l0(boolean z10) {
                this.M = z10;
                return this;
            }

            public a m0(boolean z10) {
                this.D = z10;
                return this;
            }

            public a n0(boolean z10) {
                this.B = z10;
                return this;
            }

            public a o0(boolean z10) {
                this.C = z10;
                return this;
            }

            public a p0(boolean z10) {
                this.J = z10;
                return this;
            }

            public a q0(boolean z10) {
                this.E = z10;
                return this;
            }

            public a r0(boolean z10) {
                this.K = z10;
                return this;
            }

            public a s0(boolean z10) {
                this.A = z10;
                return this;
            }

            @Override // x3.z.a
            /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
            public a F(int i10) {
                super.F(i10);
                return this;
            }

            @Override // x3.z.a
            /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
            public a G(x xVar) {
                super.G(xVar);
                return this;
            }

            @Override // x3.z.a
            /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
            public a H(Context context) {
                super.H(context);
                return this;
            }

            @Deprecated
            public a w0(int i10, e1 e1Var, @Nullable e eVar) {
                Map<e1, e> map = this.N.get(i10);
                if (map == null) {
                    map = new HashMap<>();
                    this.N.put(i10, map);
                }
                if (map.containsKey(e1Var) && o0.c(map.get(e1Var), eVar)) {
                    return this;
                }
                map.put(e1Var, eVar);
                return this;
            }

            @Override // x3.z.a
            /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
            public a J(int i10, boolean z10) {
                super.J(i10, z10);
                return this;
            }

            public a z0(boolean z10) {
                this.L = z10;
                return this;
            }

            @Deprecated
            public a() {
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                e0();
            }

            public a(Context context) {
                super(context);
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                e0();
            }

            private a(d dVar) {
                super(dVar);
                this.A = dVar.D;
                this.B = dVar.E;
                this.C = dVar.F;
                this.D = dVar.G;
                this.E = dVar.H;
                this.F = dVar.I;
                this.G = dVar.J;
                this.H = dVar.K;
                this.I = dVar.L;
                this.J = dVar.M;
                this.K = dVar.N;
                this.L = dVar.O;
                this.M = dVar.P;
                this.N = d0(dVar.Q);
                this.O = dVar.R.clone();
            }

            private a(Bundle bundle) {
                super(bundle);
                e0();
                d dVar = d.S;
                s0(bundle.getBoolean(z.c(1000), dVar.D));
                n0(bundle.getBoolean(z.c(1001), dVar.E));
                o0(bundle.getBoolean(z.c(1002), dVar.F));
                m0(bundle.getBoolean(z.c(1014), dVar.G));
                q0(bundle.getBoolean(z.c(1003), dVar.H));
                j0(bundle.getBoolean(z.c(1004), dVar.I));
                k0(bundle.getBoolean(z.c(1005), dVar.J));
                h0(bundle.getBoolean(z.c(1006), dVar.K));
                i0(bundle.getBoolean(z.c(1015), dVar.L));
                p0(bundle.getBoolean(z.c(1016), dVar.M));
                r0(bundle.getBoolean(z.c(1007), dVar.N));
                z0(bundle.getBoolean(z.c(1008), dVar.O));
                l0(bundle.getBoolean(z.c(1009), dVar.P));
                this.N = new SparseArray<>();
                x0(bundle);
                this.O = f0(bundle.getIntArray(z.c(1013)));
            }
        }

        private d(a aVar) {
            super(aVar);
            this.D = aVar.A;
            this.E = aVar.B;
            this.F = aVar.C;
            this.G = aVar.D;
            this.H = aVar.E;
            this.I = aVar.F;
            this.J = aVar.G;
            this.K = aVar.H;
            this.L = aVar.I;
            this.M = aVar.J;
            this.N = aVar.K;
            this.O = aVar.L;
            this.P = aVar.M;
            this.Q = aVar.N;
            this.R = aVar.O;
        }
    }

    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class e implements k2.h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h.a<e> f35975e = new h.a() { // from class: x3.o
            @Override // k2.h.a
            public final k2.h fromBundle(Bundle bundle) {
                return m.e.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f35977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35979d;

        public e(int i10, int[] iArr, int i11) {
            this.f35976a = i10;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f35977b = iArrCopyOf;
            this.f35978c = iArr.length;
            this.f35979d = i11;
            Arrays.sort(iArrCopyOf);
        }

        private static String b(int i10) {
            return Integer.toString(i10, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e c(Bundle bundle) {
            boolean z10 = false;
            int i10 = bundle.getInt(b(0), -1);
            int[] intArray = bundle.getIntArray(b(1));
            int i11 = bundle.getInt(b(2), -1);
            if (i10 >= 0 && i11 >= 0) {
                z10 = true;
            }
            a4.a.a(z10);
            a4.a.e(intArray);
            return new e(i10, intArray, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f35976a == eVar.f35976a && Arrays.equals(this.f35977b, eVar.f35977b) && this.f35979d == eVar.f35979d;
        }

        public int hashCode() {
            return (((this.f35976a * 31) + Arrays.hashCode(this.f35977b)) * 31) + this.f35979d;
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(b(0), this.f35976a);
            bundle.putIntArray(b(1), this.f35977b);
            bundle.putInt(b(2), this.f35979d);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    @RequiresApi(32)
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Spatializer f35980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f35981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Handler f35982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Spatializer.OnSpatializerStateChangedListener f35983d;

        /* JADX INFO: compiled from: DefaultTrackSelector.java */
        class a implements Spatializer.OnSpatializerStateChangedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ m f35984a;

            a(f fVar, m mVar) {
                this.f35984a = mVar;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z10) {
                this.f35984a.S();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z10) {
                this.f35984a.S();
            }
        }

        private f(Spatializer spatializer) {
            this.f35980a = spatializer;
            this.f35981b = spatializer.getImmersiveAudioLevel() != 0;
        }

        @Nullable
        public static f g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new f(audioManager.getSpatializer());
        }

        public boolean a(m2.e eVar, o1 o1Var) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(o0.D((MimeTypes.AUDIO_E_AC3_JOC.equals(o1Var.f29347l) && o1Var.f29360y == 16) ? 12 : o1Var.f29360y));
            int i10 = o1Var.f29361z;
            if (i10 != -1) {
                channelMask.setSampleRate(i10);
            }
            return this.f35980a.canBeSpatialized(eVar.b().f31257a, channelMask.build());
        }

        public void b(m mVar, Looper looper) {
            if (this.f35983d == null && this.f35982c == null) {
                this.f35983d = new a(this, mVar);
                Handler handler = new Handler(looper);
                this.f35982c = handler;
                Spatializer spatializer = this.f35980a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new androidx.emoji2.text.b(handler), this.f35983d);
            }
        }

        public boolean c() {
            return this.f35980a.isAvailable();
        }

        public boolean d() {
            return this.f35980a.isEnabled();
        }

        public boolean e() {
            return this.f35981b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f35983d;
            if (onSpatializerStateChangedListener == null || this.f35982c == null) {
                return;
            }
            this.f35980a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            ((Handler) o0.j(this.f35982c)).removeCallbacksAndMessages(null);
            this.f35982c = null;
            this.f35983d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    static final class g extends h<g> implements Comparable<g> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f35985e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f35986f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f35987g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f35988h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f35989i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f35990j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f35991k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f35992l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final boolean f35993m;

        public g(int i10, c1 c1Var, int i11, d dVar, int i12, @Nullable String str) {
            int iD;
            super(i10, c1Var, i11);
            int i13 = 0;
            this.f35986f = m.L(i12, false);
            int i14 = this.f35997d.f29339d & (~dVar.f36048u);
            this.f35987g = (i14 & 1) != 0;
            this.f35988h = (i14 & 2) != 0;
            com.google.common.collect.y<String> yVarR = dVar.f36046s.isEmpty() ? com.google.common.collect.y.r("") : dVar.f36046s;
            int i15 = 0;
            while (true) {
                if (i15 >= yVarR.size()) {
                    i15 = Integer.MAX_VALUE;
                    iD = 0;
                    break;
                } else {
                    iD = m.D(this.f35997d, yVarR.get(i15), dVar.f36049v);
                    if (iD > 0) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            this.f35989i = i15;
            this.f35990j = iD;
            int iH = m.H(this.f35997d.f29340e, dVar.f36047t);
            this.f35991k = iH;
            this.f35993m = (this.f35997d.f29340e & 1088) != 0;
            int iD2 = m.D(this.f35997d, str, m.T(str) == null);
            this.f35992l = iD2;
            boolean z10 = iD > 0 || (dVar.f36046s.isEmpty() && iH > 0) || this.f35987g || (this.f35988h && iD2 > 0);
            if (m.L(i12, dVar.N) && z10) {
                i13 = 1;
            }
            this.f35985e = i13;
        }

        public static int d(List<g> list, List<g> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static com.google.common.collect.y<g> f(int i10, c1 c1Var, d dVar, int[] iArr, @Nullable String str) {
            y.a aVarK = com.google.common.collect.y.k();
            for (int i11 = 0; i11 < c1Var.f30482a; i11++) {
                aVarK.a(new g(i10, c1Var, i11, dVar, iArr[i11], str));
            }
            return aVarK.k();
        }

        @Override // x3.m.h
        public int a() {
            return this.f35985e;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            com.google.common.collect.p pVarD = com.google.common.collect.p.j().g(this.f35986f, gVar.f35986f).f(Integer.valueOf(this.f35989i), Integer.valueOf(gVar.f35989i), s0.d().g()).d(this.f35990j, gVar.f35990j).d(this.f35991k, gVar.f35991k).g(this.f35987g, gVar.f35987g).f(Boolean.valueOf(this.f35988h), Boolean.valueOf(gVar.f35988h), this.f35990j == 0 ? s0.d() : s0.d().g()).d(this.f35992l, gVar.f35992l);
            if (this.f35991k == 0) {
                pVarD = pVarD.h(this.f35993m, gVar.f35993m);
            }
            return pVarD.i();
        }

        @Override // x3.m.h
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean c(g gVar) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    static abstract class h<T extends h<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c1 f35995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o1 f35997d;

        /* JADX INFO: compiled from: DefaultTrackSelector.java */
        public interface a<T extends h<T>> {
            List<T> a(int i10, c1 c1Var, int[] iArr);
        }

        public h(int i10, c1 c1Var, int i11) {
            this.f35994a = i10;
            this.f35995b = c1Var;
            this.f35996c = i11;
            this.f35997d = c1Var.c(i11);
        }

        public abstract int a();

        public abstract boolean c(T t10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    static final class i extends h<i> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f35998e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final d f35999f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f36000g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f36001h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f36002i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f36003j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f36004k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f36005l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final boolean f36006m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final boolean f36007n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final int f36008o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final boolean f36009p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final boolean f36010q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final int f36011r;

        /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0079  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public i(int r5, l3.c1 r6, int r7, x3.m.d r8, int r9, int r10, boolean r11) {
            /*
                Method dump skipped, instruction units count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: x3.m.i.<init>(int, l3.c1, int, x3.m$d, int, int, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int f(i iVar, i iVar2) {
            com.google.common.collect.p pVarG = com.google.common.collect.p.j().g(iVar.f36001h, iVar2.f36001h).d(iVar.f36005l, iVar2.f36005l).g(iVar.f36006m, iVar2.f36006m).g(iVar.f35998e, iVar2.f35998e).g(iVar.f36000g, iVar2.f36000g).f(Integer.valueOf(iVar.f36004k), Integer.valueOf(iVar2.f36004k), s0.d().g()).g(iVar.f36009p, iVar2.f36009p).g(iVar.f36010q, iVar2.f36010q);
            if (iVar.f36009p && iVar.f36010q) {
                pVarG = pVarG.d(iVar.f36011r, iVar2.f36011r);
            }
            return pVarG.i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int g(i iVar, i iVar2) {
            s0 s0VarG = (iVar.f35998e && iVar.f36001h) ? m.f35946k : m.f35946k.g();
            return com.google.common.collect.p.j().f(Integer.valueOf(iVar.f36002i), Integer.valueOf(iVar2.f36002i), iVar.f35999f.f36050w ? m.f35946k.g() : m.f35947l).f(Integer.valueOf(iVar.f36003j), Integer.valueOf(iVar2.f36003j), s0VarG).f(Integer.valueOf(iVar.f36002i), Integer.valueOf(iVar2.f36002i), s0VarG).i();
        }

        public static int h(List<i> list, List<i> list2) {
            return com.google.common.collect.p.j().f((i) Collections.max(list, new Comparator() { // from class: x3.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.f((m.i) obj, (m.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: x3.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.f((m.i) obj, (m.i) obj2);
                }
            }), new Comparator() { // from class: x3.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.f((m.i) obj, (m.i) obj2);
                }
            }).d(list.size(), list2.size()).f((i) Collections.max(list, new Comparator() { // from class: x3.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.g((m.i) obj, (m.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: x3.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.g((m.i) obj, (m.i) obj2);
                }
            }), new Comparator() { // from class: x3.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.g((m.i) obj, (m.i) obj2);
                }
            }).i();
        }

        public static com.google.common.collect.y<i> i(int i10, c1 c1Var, d dVar, int[] iArr, int i11) {
            int iE = m.E(c1Var, dVar.f36036i, dVar.f36037j, dVar.f36038k);
            y.a aVarK = com.google.common.collect.y.k();
            for (int i12 = 0; i12 < c1Var.f30482a; i12++) {
                int iF = c1Var.c(i12).f();
                aVarK.a(new i(i10, c1Var, i12, dVar, iArr[i12], i11, iE == Integer.MAX_VALUE || (iF != -1 && iF <= iE)));
            }
            return aVarK.k();
        }

        private int j(int i10, int i11) {
            if ((this.f35997d.f29340e & 16384) != 0 || !m.L(i10, this.f35999f.N)) {
                return 0;
            }
            if (!this.f35998e && !this.f35999f.D) {
                return 0;
            }
            if (m.L(i10, false) && this.f36000g && this.f35998e && this.f35997d.f29343h != -1) {
                d dVar = this.f35999f;
                if (!dVar.f36051x && !dVar.f36050w && (i10 & i11) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // x3.m.h
        public int a() {
            return this.f36008o;
        }

        @Override // x3.m.h
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean c(i iVar) {
            return (this.f36007n || o0.c(this.f35997d.f29347l, iVar.f35997d.f29347l)) && (this.f35999f.G || (this.f36009p == iVar.f36009p && this.f36010q == iVar.f36010q));
        }
    }

    public m(Context context) {
        this(context, new a.b());
    }

    private static void A(u.a aVar, d dVar, s.a[] aVarArr) {
        int iD = aVar.d();
        for (int i10 = 0; i10 < iD; i10++) {
            e1 e1VarF = aVar.f(i10);
            if (dVar.o(i10, e1VarF)) {
                e eVarN = dVar.n(i10, e1VarF);
                aVarArr[i10] = (eVarN == null || eVarN.f35977b.length == 0) ? null : new s.a(e1VarF.b(eVarN.f35976a), eVarN.f35977b, eVarN.f35979d);
            }
        }
    }

    private static void B(u.a aVar, z zVar, s.a[] aVarArr) {
        int iD = aVar.d();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < iD; i10++) {
            C(aVar.f(i10), zVar, map);
        }
        C(aVar.h(), zVar, map);
        for (int i11 = 0; i11 < iD; i11++) {
            x xVar = (x) map.get(Integer.valueOf(aVar.e(i11)));
            if (xVar != null) {
                aVarArr[i11] = (xVar.f36027b.isEmpty() || aVar.f(i11).c(xVar.f36026a) == -1) ? null : new s.a(xVar.f36026a, g5.e.k(xVar.f36027b));
            }
        }
    }

    private static void C(e1 e1Var, z zVar, Map<Integer, x> map) {
        x xVar;
        for (int i10 = 0; i10 < e1Var.f30517a; i10++) {
            x xVar2 = zVar.f36052y.get(e1Var.b(i10));
            if (xVar2 != null && ((xVar = map.get(Integer.valueOf(xVar2.b()))) == null || (xVar.f36027b.isEmpty() && !xVar2.f36027b.isEmpty()))) {
                map.put(Integer.valueOf(xVar2.b()), xVar2);
            }
        }
    }

    protected static int D(o1 o1Var, @Nullable String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(o1Var.f29338c)) {
            return 4;
        }
        String strT = T(str);
        String strT2 = T(o1Var.f29338c);
        if (strT2 == null || strT == null) {
            return (z10 && strT2 == null) ? 1 : 0;
        }
        if (strT2.startsWith(strT) || strT.startsWith(strT2)) {
            return 3;
        }
        return o0.I0(strT2, "-")[0].equals(o0.I0(strT, "-")[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E(c1 c1Var, int i10, int i11, boolean z10) {
        int i12;
        int i13 = Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE && i11 != Integer.MAX_VALUE) {
            for (int i14 = 0; i14 < c1Var.f30482a; i14++) {
                o1 o1VarC = c1Var.c(i14);
                int i15 = o1VarC.f29352q;
                if (i15 > 0 && (i12 = o1VarC.f29353r) > 0) {
                    Point pointF = F(z10, i10, i11, i15, i12);
                    int i16 = o1VarC.f29352q;
                    int i17 = o1VarC.f29353r;
                    int i18 = i16 * i17;
                    if (i16 >= ((int) (pointF.x * 0.98f)) && i17 >= ((int) (pointF.y * 0.98f)) && i18 < i13) {
                        i13 = i18;
                    }
                }
            }
        }
        return i13;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Point F(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L10
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L8
            r1 = r3
            goto L9
        L8:
            r1 = r0
        L9:
            if (r4 <= r5) goto Lc
            goto Ld
        Lc:
            r3 = r0
        Ld:
            if (r1 == r3) goto L10
            goto L13
        L10:
            r2 = r5
            r5 = r4
            r4 = r2
        L13:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L23
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = a4.o0.l(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = a4.o0.l(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.m.F(boolean, int, int, int, int):android.graphics.Point");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(int i10, int i11) {
        if (i10 == 0 || i10 != i11) {
            return Integer.bitCount(i10 & i11);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(o1 o1Var) {
        boolean z10;
        f fVar;
        f fVar2;
        synchronized (this.f35948d) {
            z10 = !this.f35952h.M || this.f35951g || o1Var.f29360y <= 2 || (K(o1Var) && (o0.f214a < 32 || (fVar2 = this.f35953i) == null || !fVar2.e())) || (o0.f214a >= 32 && (fVar = this.f35953i) != null && fVar.e() && this.f35953i.c() && this.f35953i.d() && this.f35953i.a(this.f35954j, o1Var));
        }
        return z10;
    }

    private static boolean K(o1 o1Var) {
        String str = o1Var.f29347l;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
        }
        return false;
    }

    protected static boolean L(int i10, boolean z10) {
        int iF = b3.f(i10);
        return iF == 4 || (z10 && iF == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List M(d dVar, boolean z10, int i10, c1 c1Var, int[] iArr) {
        return b.f(i10, c1Var, dVar, iArr, z10, new e5.p() { // from class: x3.l
            @Override // e5.p
            public final boolean apply(Object obj) {
                return this.f35945a.J((o1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List N(d dVar, String str, int i10, c1 c1Var, int[] iArr) {
        return g.f(i10, c1Var, dVar, iArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List O(d dVar, int[] iArr, int i10, c1 c1Var, int[] iArr2) {
        return i.i(i10, c1Var, dVar, iArr2, iArr[i10]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int P(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Q(Integer num, Integer num2) {
        return 0;
    }

    private static void R(u.a aVar, int[][][] iArr, d3[] d3VarArr, s[] sVarArr) {
        boolean z10;
        boolean z11 = false;
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < aVar.d(); i12++) {
            int iE = aVar.e(i12);
            s sVar = sVarArr[i12];
            if ((iE == 1 || iE == 2) && sVar != null && U(iArr[i12], aVar.f(i12), sVar)) {
                if (iE == 1) {
                    if (i11 != -1) {
                        z10 = false;
                        break;
                    }
                    i11 = i12;
                } else {
                    if (i10 != -1) {
                        z10 = false;
                        break;
                    }
                    i10 = i12;
                }
            }
        }
        z10 = true;
        if (i11 != -1 && i10 != -1) {
            z11 = true;
        }
        if (z10 && z11) {
            d3 d3Var = new d3(true);
            d3VarArr[i11] = d3Var;
            d3VarArr[i10] = d3Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        boolean z10;
        f fVar;
        synchronized (this.f35948d) {
            z10 = this.f35952h.M && !this.f35951g && o0.f214a >= 32 && (fVar = this.f35953i) != null && fVar.e();
        }
        if (z10) {
            d();
        }
    }

    @Nullable
    protected static String T(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    private static boolean U(int[][] iArr, e1 e1Var, s sVar) {
        if (sVar == null) {
            return false;
        }
        int iC = e1Var.c(sVar.getTrackGroup());
        for (int i10 = 0; i10 < sVar.length(); i10++) {
            if (b3.h(iArr[iC][sVar.getIndexInTrackGroup(i10)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private <T extends h<T>> Pair<s.a, Integer> Z(int i10, u.a aVar, int[][][] iArr, h.a<T> aVar2, Comparator<List<T>> comparator) {
        int i11;
        RandomAccess randomAccessR;
        u.a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        int iD = aVar.d();
        int i12 = 0;
        while (i12 < iD) {
            if (i10 == aVar3.e(i12)) {
                e1 e1VarF = aVar3.f(i12);
                for (int i13 = 0; i13 < e1VarF.f30517a; i13++) {
                    c1 c1VarB = e1VarF.b(i13);
                    List<T> listA = aVar2.a(i12, c1VarB, iArr[i12][i13]);
                    boolean[] zArr = new boolean[c1VarB.f30482a];
                    int i14 = 0;
                    while (i14 < c1VarB.f30482a) {
                        T t10 = listA.get(i14);
                        int iA = t10.a();
                        if (zArr[i14] || iA == 0) {
                            i11 = iD;
                        } else {
                            if (iA == 1) {
                                randomAccessR = com.google.common.collect.y.r(t10);
                                i11 = iD;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(t10);
                                int i15 = i14 + 1;
                                while (i15 < c1VarB.f30482a) {
                                    T t11 = listA.get(i15);
                                    int i16 = iD;
                                    if (t11.a() == 2 && t10.c(t11)) {
                                        arrayList2.add(t11);
                                        zArr[i15] = true;
                                    }
                                    i15++;
                                    iD = i16;
                                }
                                i11 = iD;
                                randomAccessR = arrayList2;
                            }
                            arrayList.add(randomAccessR);
                        }
                        i14++;
                        iD = i11;
                    }
                }
            }
            i12++;
            aVar3 = aVar;
            iD = iD;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i17 = 0; i17 < list.size(); i17++) {
            iArr2[i17] = ((h) list.get(i17)).f35996c;
        }
        h hVar = (h) list.get(0);
        return Pair.create(new s.a(hVar.f35995b, iArr2), Integer.valueOf(hVar.f35994a));
    }

    private void b0(d dVar) {
        boolean z10;
        a4.a.e(dVar);
        synchronized (this.f35948d) {
            z10 = !this.f35952h.equals(dVar);
            this.f35952h = dVar;
        }
        if (z10) {
            if (dVar.M && this.f35949e == null) {
                a4.t.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            d();
        }
    }

    @Override // x3.b0
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public d b() {
        d dVar;
        synchronized (this.f35948d) {
            dVar = this.f35952h;
        }
        return dVar;
    }

    protected s.a[] V(u.a aVar, int[][][] iArr, int[] iArr2, d dVar) throws k2.q {
        String str;
        int iD = aVar.d();
        s.a[] aVarArr = new s.a[iD];
        Pair<s.a, Integer> pairA0 = a0(aVar, iArr, iArr2, dVar);
        if (pairA0 != null) {
            aVarArr[((Integer) pairA0.second).intValue()] = (s.a) pairA0.first;
        }
        Pair<s.a, Integer> pairW = W(aVar, iArr, iArr2, dVar);
        if (pairW != null) {
            aVarArr[((Integer) pairW.second).intValue()] = (s.a) pairW.first;
        }
        if (pairW == null) {
            str = null;
        } else {
            Object obj = pairW.first;
            str = ((s.a) obj).f36012a.c(((s.a) obj).f36013b[0]).f29338c;
        }
        Pair<s.a, Integer> pairY = Y(aVar, iArr, dVar, str);
        if (pairY != null) {
            aVarArr[((Integer) pairY.second).intValue()] = (s.a) pairY.first;
        }
        for (int i10 = 0; i10 < iD; i10++) {
            int iE = aVar.e(i10);
            if (iE != 2 && iE != 1 && iE != 3) {
                aVarArr[i10] = X(iE, aVar.f(i10), iArr[i10], dVar);
            }
        }
        return aVarArr;
    }

    @Nullable
    protected Pair<s.a, Integer> W(u.a aVar, int[][][] iArr, int[] iArr2, final d dVar) throws k2.q {
        final boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 < aVar.d()) {
                if (2 == aVar.e(i10) && aVar.f(i10).f30517a > 0) {
                    z10 = true;
                    break;
                }
                i10++;
            } else {
                break;
            }
        }
        return Z(1, aVar, iArr, new h.a() { // from class: x3.j
            @Override // x3.m.h.a
            public final List a(int i11, c1 c1Var, int[] iArr3) {
                return this.f35942a.M(dVar, z10, i11, c1Var, iArr3);
            }
        }, new Comparator() { // from class: x3.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.b.d((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    protected s.a X(int i10, e1 e1Var, int[][] iArr, d dVar) throws k2.q {
        c1 c1Var = null;
        c cVar = null;
        int i11 = 0;
        for (int i12 = 0; i12 < e1Var.f30517a; i12++) {
            c1 c1VarB = e1Var.b(i12);
            int[] iArr2 = iArr[i12];
            for (int i13 = 0; i13 < c1VarB.f30482a; i13++) {
                if (L(iArr2[i13], dVar.N)) {
                    c cVar2 = new c(c1VarB.c(i13), iArr2[i13]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        c1Var = c1VarB;
                        i11 = i13;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (c1Var == null) {
            return null;
        }
        return new s.a(c1Var, i11);
    }

    @Nullable
    protected Pair<s.a, Integer> Y(u.a aVar, int[][][] iArr, final d dVar, @Nullable final String str) throws k2.q {
        return Z(3, aVar, iArr, new h.a() { // from class: x3.d
            @Override // x3.m.h.a
            public final List a(int i10, c1 c1Var, int[] iArr2) {
                return m.N(dVar, str, i10, c1Var, iArr2);
            }
        }, new Comparator() { // from class: x3.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.g.d((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    protected Pair<s.a, Integer> a0(u.a aVar, int[][][] iArr, final int[] iArr2, final d dVar) throws k2.q {
        return Z(2, aVar, iArr, new h.a() { // from class: x3.h
            @Override // x3.m.h.a
            public final List a(int i10, c1 c1Var, int[] iArr3) {
                return m.O(dVar, iArr2, i10, c1Var, iArr3);
            }
        }, new Comparator() { // from class: x3.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.i.h((List) obj, (List) obj2);
            }
        });
    }

    @Override // x3.b0
    public boolean e() {
        return true;
    }

    @Override // x3.b0
    public void g() {
        f fVar;
        synchronized (this.f35948d) {
            if (o0.f214a >= 32 && (fVar = this.f35953i) != null) {
                fVar.f();
            }
        }
        super.g();
    }

    @Override // x3.b0
    public void i(m2.e eVar) {
        boolean z10;
        synchronized (this.f35948d) {
            z10 = !this.f35954j.equals(eVar);
            this.f35954j = eVar;
        }
        if (z10) {
            S();
        }
    }

    @Override // x3.b0
    public void j(z zVar) {
        if (zVar instanceof d) {
            b0((d) zVar);
        }
        b0(new d.a().g0(zVar).A());
    }

    @Override // x3.u
    protected final Pair<d3[], s[]> n(u.a aVar, int[][][] iArr, int[] iArr2, a0.b bVar, n3 n3Var) throws k2.q {
        d dVar;
        f fVar;
        synchronized (this.f35948d) {
            dVar = this.f35952h;
            if (dVar.M && o0.f214a >= 32 && (fVar = this.f35953i) != null) {
                fVar.b(this, (Looper) a4.a.i(Looper.myLooper()));
            }
        }
        int iD = aVar.d();
        s.a[] aVarArrV = V(aVar, iArr, iArr2, dVar);
        B(aVar, dVar, aVarArrV);
        A(aVar, dVar, aVarArrV);
        for (int i10 = 0; i10 < iD; i10++) {
            int iE = aVar.e(i10);
            if (dVar.m(i10) || dVar.f36053z.contains(Integer.valueOf(iE))) {
                aVarArrV[i10] = null;
            }
        }
        s[] sVarArrA = this.f35950f.a(aVarArrV, a(), bVar, n3Var);
        d3[] d3VarArr = new d3[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            boolean z10 = true;
            if ((dVar.m(i11) || dVar.f36053z.contains(Integer.valueOf(aVar.e(i11)))) || (aVar.e(i11) != -2 && sVarArrA[i11] == null)) {
                z10 = false;
            }
            d3VarArr[i11] = z10 ? d3.f29074b : null;
        }
        if (dVar.O) {
            R(aVar, iArr, d3VarArr, sVarArrA);
        }
        return Pair.create(d3VarArr, sVarArrA);
    }

    public m(Context context, s.b bVar) {
        this(context, d.k(context), bVar);
    }

    public m(Context context, z zVar, s.b bVar) {
        this(zVar, bVar, context);
    }

    private m(z zVar, s.b bVar, @Nullable Context context) {
        this.f35948d = new Object();
        this.f35949e = context != null ? context.getApplicationContext() : null;
        this.f35950f = bVar;
        if (zVar instanceof d) {
            this.f35952h = (d) zVar;
        } else {
            this.f35952h = (context == null ? d.S : d.k(context)).a().g0(zVar).A();
        }
        this.f35954j = m2.e.f31249g;
        boolean z10 = context != null && o0.r0(context);
        this.f35951g = z10;
        if (!z10 && context != null && o0.f214a >= 32) {
            this.f35953i = f.g(context);
        }
        if (this.f35952h.M && context == null) {
            a4.t.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
