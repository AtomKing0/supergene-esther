package l3;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k2.n3;
import k2.w1;
import l3.a0;

/* JADX INFO: compiled from: MergingMediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends f<Integer> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final w1 f30560v = new w1.c().d("MergingMediaSource").a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f30561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f30562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final a0[] f30563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n3[] f30564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ArrayList<a0> f30565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final h f30566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Map<Object, Long> f30567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.google.common.collect.l0<Object, c> f30568r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f30569s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long[][] f30570t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private b f30571u;

    /* JADX INFO: compiled from: MergingMediaSource.java */
    private static final class a extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f30572d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long[] f30573e;

        public a(n3 n3Var, Map<Object, Long> map) {
            super(n3Var);
            int iT = n3Var.t();
            this.f30573e = new long[n3Var.t()];
            n3.d dVar = new n3.d();
            for (int i10 = 0; i10 < iT; i10++) {
                this.f30573e[i10] = n3Var.r(i10, dVar).f29326n;
            }
            int iM = n3Var.m();
            this.f30572d = new long[iM];
            n3.b bVar = new n3.b();
            for (int i11 = 0; i11 < iM; i11++) {
                n3Var.k(i11, bVar, true);
                long jLongValue = ((Long) a4.a.e(map.get(bVar.f29299b))).longValue();
                long[] jArr = this.f30572d;
                jLongValue = jLongValue == Long.MIN_VALUE ? bVar.f29301d : jLongValue;
                jArr[i11] = jLongValue;
                long j10 = bVar.f29301d;
                if (j10 != C.TIME_UNSET) {
                    long[] jArr2 = this.f30573e;
                    int i12 = bVar.f29300c;
                    jArr2[i12] = jArr2[i12] - (j10 - jLongValue);
                }
            }
        }

        @Override // l3.r, k2.n3
        public n3.b k(int i10, n3.b bVar, boolean z10) {
            super.k(i10, bVar, z10);
            bVar.f29301d = this.f30572d[i10];
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        @Override // l3.r, k2.n3
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public k2.n3.d s(int r5, k2.n3.d r6, long r7) {
            /*
                r4 = this;
                super.s(r5, r6, r7)
                long[] r7 = r4.f30573e
                r0 = r7[r5]
                r6.f29326n = r0
                r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r5 == 0) goto L1e
                long r2 = r6.f29325m
                int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r5 != 0) goto L19
                goto L1e
            L19:
                long r7 = java.lang.Math.min(r2, r0)
                goto L20
            L1e:
                long r7 = r6.f29325m
            L20:
                r6.f29325m = r7
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: l3.i0.a.s(int, k2.n3$d, long):k2.n3$d");
        }
    }

    /* JADX INFO: compiled from: MergingMediaSource.java */
    public static final class b extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30574a;

        public b(int i10) {
            this.f30574a = i10;
        }
    }

    public i0(a0... a0VarArr) {
        this(false, a0VarArr);
    }

    private void C() {
        n3.b bVar = new n3.b();
        for (int i10 = 0; i10 < this.f30569s; i10++) {
            long j10 = -this.f30564n[0].j(i10, bVar).q();
            int i11 = 1;
            while (true) {
                n3[] n3VarArr = this.f30564n;
                if (i11 < n3VarArr.length) {
                    this.f30570t[i10][i11] = j10 - (-n3VarArr[i11].j(i10, bVar).q());
                    i11++;
                }
            }
        }
    }

    private void F() {
        n3[] n3VarArr;
        n3.b bVar = new n3.b();
        for (int i10 = 0; i10 < this.f30569s; i10++) {
            int i11 = 0;
            long j10 = Long.MIN_VALUE;
            while (true) {
                n3VarArr = this.f30564n;
                if (i11 >= n3VarArr.length) {
                    break;
                }
                long jM = n3VarArr[i11].j(i10, bVar).m();
                if (jM != C.TIME_UNSET) {
                    long j11 = jM + this.f30570t[i10][i11];
                    if (j10 == Long.MIN_VALUE || j11 < j10) {
                        j10 = j11;
                    }
                }
                i11++;
            }
            Object objQ = n3VarArr[0].q(i10);
            this.f30567q.put(objQ, Long.valueOf(j10));
            Iterator<c> it = this.f30568r.get(objQ).iterator();
            while (it.hasNext()) {
                it.next().l(0L, j10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l3.f
    @Nullable
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a0.b w(Integer num, a0.b bVar) {
        if (num.intValue() == 0) {
            return bVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l3.f
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public void z(Integer num, a0 a0Var, n3 n3Var) {
        if (this.f30571u != null) {
            return;
        }
        if (this.f30569s == -1) {
            this.f30569s = n3Var.m();
        } else if (n3Var.m() != this.f30569s) {
            this.f30571u = new b(0);
            return;
        }
        if (this.f30570t.length == 0) {
            this.f30570t = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f30569s, this.f30564n.length);
        }
        this.f30565o.remove(a0Var);
        this.f30564n[num.intValue()] = n3Var;
        if (this.f30565o.isEmpty()) {
            if (this.f30561k) {
                C();
            }
            n3 aVar = this.f30564n[0];
            if (this.f30562l) {
                F();
                aVar = new a(aVar, this.f30567q);
            }
            t(aVar);
        }
    }

    @Override // l3.a0
    public void e(x xVar) {
        if (this.f30562l) {
            c cVar = (c) xVar;
            Iterator<Map.Entry<Object, c>> it = this.f30568r.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Object, c> next = it.next();
                if (next.getValue().equals(cVar)) {
                    this.f30568r.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            xVar = cVar.f30468a;
        }
        h0 h0Var = (h0) xVar;
        int i10 = 0;
        while (true) {
            a0[] a0VarArr = this.f30563m;
            if (i10 >= a0VarArr.length) {
                return;
            }
            a0VarArr[i10].e(h0Var.e(i10));
            i10++;
        }
    }

    @Override // l3.a0
    public w1 getMediaItem() {
        a0[] a0VarArr = this.f30563m;
        return a0VarArr.length > 0 ? a0VarArr[0].getMediaItem() : f30560v;
    }

    @Override // l3.a0
    public x j(a0.b bVar, z3.b bVar2, long j10) {
        int length = this.f30563m.length;
        x[] xVarArr = new x[length];
        int iF = this.f30564n[0].f(bVar.f30778a);
        for (int i10 = 0; i10 < length; i10++) {
            xVarArr[i10] = this.f30563m[i10].j(bVar.c(this.f30564n[i10].q(iF)), bVar2, j10 - this.f30570t[iF][i10]);
        }
        h0 h0Var = new h0(this.f30566p, this.f30570t[iF], xVarArr);
        if (!this.f30562l) {
            return h0Var;
        }
        c cVar = new c(h0Var, true, 0L, ((Long) a4.a.e(this.f30567q.get(bVar.f30778a))).longValue());
        this.f30568r.put(bVar.f30778a, cVar);
        return cVar;
    }

    @Override // l3.f, l3.a0
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        b bVar = this.f30571u;
        if (bVar != null) {
            throw bVar;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // l3.f, l3.a
    protected void s(@Nullable z3.m0 m0Var) {
        super.s(m0Var);
        for (int i10 = 0; i10 < this.f30563m.length; i10++) {
            B(Integer.valueOf(i10), this.f30563m[i10]);
        }
    }

    @Override // l3.f, l3.a
    protected void u() {
        super.u();
        Arrays.fill(this.f30564n, (Object) null);
        this.f30569s = -1;
        this.f30571u = null;
        this.f30565o.clear();
        Collections.addAll(this.f30565o, this.f30563m);
    }

    public i0(boolean z10, a0... a0VarArr) {
        this(z10, false, a0VarArr);
    }

    public i0(boolean z10, boolean z11, a0... a0VarArr) {
        this(z10, z11, new i(), a0VarArr);
    }

    public i0(boolean z10, boolean z11, h hVar, a0... a0VarArr) {
        this.f30561k = z10;
        this.f30562l = z11;
        this.f30563m = a0VarArr;
        this.f30566p = hVar;
        this.f30565o = new ArrayList<>(Arrays.asList(a0VarArr));
        this.f30569s = -1;
        this.f30564n = new n3[a0VarArr.length];
        this.f30570t = new long[0][];
        this.f30567q = new HashMap();
        this.f30568r = com.google.common.collect.m0.a().a().e();
    }
}
