package z2;

import a4.l0;
import a4.o0;
import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import k2.j2;
import p2.b0;
import z2.i0;

/* JADX INFO: compiled from: TsExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements p2.l {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final p2.r f37087t = new p2.r() { // from class: z2.g0
        @Override // p2.r
        public final p2.l[] createExtractors() {
            return h0.v();
        }

        @Override // p2.r
        public /* synthetic */ p2.l[] createExtractors(Uri uri, Map map) {
            return p2.q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<l0> f37090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a4.c0 f37091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseIntArray f37092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i0.c f37093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SparseArray<i0> f37094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SparseBooleanArray f37095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseBooleanArray f37096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final f0 f37097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e0 f37098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private p2.n f37099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f37100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f37101n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f37102o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f37103p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private i0 f37104q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f37105r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f37106s;

    public h0() {
        this(0);
    }

    static /* synthetic */ int j(h0 h0Var) {
        int i10 = h0Var.f37100m;
        h0Var.f37100m = i10 + 1;
        return i10;
    }

    private boolean t(p2.m mVar) throws IOException {
        byte[] bArrD = this.f37091d.d();
        if (9400 - this.f37091d.e() < 188) {
            int iA = this.f37091d.a();
            if (iA > 0) {
                System.arraycopy(bArrD, this.f37091d.e(), bArrD, 0, iA);
            }
            this.f37091d.N(bArrD, iA);
        }
        while (this.f37091d.a() < 188) {
            int iF = this.f37091d.f();
            int i10 = mVar.read(bArrD, iF, 9400 - iF);
            if (i10 == -1) {
                return false;
            }
            this.f37091d.O(iF + i10);
        }
        return true;
    }

    private int u() throws j2 {
        int iE = this.f37091d.e();
        int iF = this.f37091d.f();
        int iA = j0.a(this.f37091d.d(), iE, iF);
        this.f37091d.P(iA);
        int i10 = iA + TsExtractor.TS_PACKET_SIZE;
        if (i10 > iF) {
            int i11 = this.f37105r + (iA - iE);
            this.f37105r = i11;
            if (this.f37088a == 2 && i11 > 376) {
                throw j2.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f37105r = 0;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p2.l[] v() {
        return new p2.l[]{new h0()};
    }

    private void w(long j10) {
        if (this.f37102o) {
            return;
        }
        this.f37102o = true;
        if (this.f37097j.b() == C.TIME_UNSET) {
            this.f37099l.h(new b0.b(this.f37097j.b()));
            return;
        }
        e0 e0Var = new e0(this.f37097j.c(), this.f37097j.b(), j10, this.f37106s, this.f37089b);
        this.f37098k = e0Var;
        this.f37099l.h(e0Var.b());
    }

    private void x() {
        this.f37095h.clear();
        this.f37094g.clear();
        SparseArray<i0> sparseArrayCreateInitialPayloadReaders = this.f37093f.createInitialPayloadReaders();
        int size = sparseArrayCreateInitialPayloadReaders.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f37094g.put(sparseArrayCreateInitialPayloadReaders.keyAt(i10), sparseArrayCreateInitialPayloadReaders.valueAt(i10));
        }
        this.f37094g.put(0, new c0(new a()));
        this.f37104q = null;
    }

    private boolean y(int i10) {
        return this.f37088a == 2 || this.f37101n || !this.f37096i.get(i10, false);
    }

    @Override // p2.l
    public int a(p2.m mVar, p2.a0 a0Var) throws IOException {
        long length = mVar.getLength();
        if (this.f37101n) {
            if (((length == -1 || this.f37088a == 2) ? false : true) && !this.f37097j.d()) {
                return this.f37097j.e(mVar, a0Var, this.f37106s);
            }
            w(length);
            if (this.f37103p) {
                this.f37103p = false;
                seek(0L, 0L);
                if (mVar.getPosition() != 0) {
                    a0Var.f32443a = 0L;
                    return 1;
                }
            }
            e0 e0Var = this.f37098k;
            if (e0Var != null && e0Var.d()) {
                return this.f37098k.c(mVar, a0Var);
            }
        }
        if (!t(mVar)) {
            return -1;
        }
        int iU = u();
        int iF = this.f37091d.f();
        if (iU > iF) {
            return 0;
        }
        int iN = this.f37091d.n();
        if ((8388608 & iN) != 0) {
            this.f37091d.P(iU);
            return 0;
        }
        int i10 = ((4194304 & iN) != 0 ? 1 : 0) | 0;
        int i11 = (2096896 & iN) >> 8;
        boolean z10 = (iN & 32) != 0;
        i0 i0Var = (iN & 16) != 0 ? this.f37094g.get(i11) : null;
        if (i0Var == null) {
            this.f37091d.P(iU);
            return 0;
        }
        if (this.f37088a != 2) {
            int i12 = iN & 15;
            int i13 = this.f37092e.get(i11, i12 - 1);
            this.f37092e.put(i11, i12);
            if (i13 == i12) {
                this.f37091d.P(iU);
                return 0;
            }
            if (i12 != ((i13 + 1) & 15)) {
                i0Var.seek();
            }
        }
        if (z10) {
            int iD = this.f37091d.D();
            i10 |= (this.f37091d.D() & 64) != 0 ? 2 : 0;
            this.f37091d.Q(iD - 1);
        }
        boolean z11 = this.f37101n;
        if (y(i11)) {
            this.f37091d.O(iU);
            i0Var.a(this.f37091d, i10);
            this.f37091d.O(iF);
        }
        if (this.f37088a != 2 && !z11 && this.f37101n && length != -1) {
            this.f37103p = true;
        }
        this.f37091d.P(iU);
        return 0;
    }

    @Override // p2.l
    public void b(p2.n nVar) {
        this.f37099l = nVar;
    }

    @Override // p2.l
    public boolean c(p2.m mVar) throws IOException {
        boolean z10;
        byte[] bArrD = this.f37091d.d();
        mVar.peekFully(bArrD, 0, 940);
        for (int i10 = 0; i10 < 188; i10++) {
            int i11 = 0;
            while (true) {
                if (i11 >= 5) {
                    z10 = true;
                    break;
                }
                if (bArrD[(i11 * TsExtractor.TS_PACKET_SIZE) + i10] != 71) {
                    z10 = false;
                    break;
                }
                i11++;
            }
            if (z10) {
                mVar.skipFully(i10);
                return true;
            }
        }
        return false;
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        e0 e0Var;
        a4.a.g(this.f37088a != 2);
        int size = this.f37090c.size();
        for (int i10 = 0; i10 < size; i10++) {
            l0 l0Var = this.f37090c.get(i10);
            boolean z10 = l0Var.e() == C.TIME_UNSET;
            if (!z10) {
                long jC = l0Var.c();
                z10 = (jC == C.TIME_UNSET || jC == 0 || jC == j11) ? false : true;
            }
            if (z10) {
                l0Var.g(j11);
            }
        }
        if (j11 != 0 && (e0Var = this.f37098k) != null) {
            e0Var.h(j11);
        }
        this.f37091d.L(0);
        this.f37092e.clear();
        for (int i11 = 0; i11 < this.f37094g.size(); i11++) {
            this.f37094g.valueAt(i11).seek();
        }
        this.f37105r = 0;
    }

    public h0(int i10) {
        this(1, i10, TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public h0(int i10, int i11, int i12) {
        this(i10, new l0(0L), new j(i11), i12);
    }

    public h0(int i10, l0 l0Var, i0.c cVar, int i11) {
        this.f37093f = (i0.c) a4.a.e(cVar);
        this.f37089b = i11;
        this.f37088a = i10;
        if (i10 != 1 && i10 != 2) {
            ArrayList arrayList = new ArrayList();
            this.f37090c = arrayList;
            arrayList.add(l0Var);
        } else {
            this.f37090c = Collections.singletonList(l0Var);
        }
        this.f37091d = new a4.c0(new byte[9400], 0);
        this.f37095h = new SparseBooleanArray();
        this.f37096i = new SparseBooleanArray();
        this.f37094g = new SparseArray<>();
        this.f37092e = new SparseIntArray();
        this.f37097j = new f0(i11);
        this.f37099l = p2.n.P7;
        this.f37106s = -1;
        x();
    }

    @Override // p2.l
    public void release() {
    }

    /* JADX INFO: compiled from: TsExtractor.java */
    private class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a4.b0 f37107a = new a4.b0(new byte[4]);

        public a() {
        }

        @Override // z2.b0
        public void a(a4.c0 c0Var) {
            if (c0Var.D() == 0 && (c0Var.D() & 128) != 0) {
                c0Var.Q(6);
                int iA = c0Var.a() / 4;
                for (int i10 = 0; i10 < iA; i10++) {
                    c0Var.i(this.f37107a, 4);
                    int iH = this.f37107a.h(16);
                    this.f37107a.r(3);
                    if (iH == 0) {
                        this.f37107a.r(13);
                    } else {
                        int iH2 = this.f37107a.h(13);
                        if (h0.this.f37094g.get(iH2) == null) {
                            h0.this.f37094g.put(iH2, new c0(h0.this.new b(iH2)));
                            h0.j(h0.this);
                        }
                    }
                }
                if (h0.this.f37088a != 2) {
                    h0.this.f37094g.remove(0);
                }
            }
        }

        @Override // z2.b0
        public void b(l0 l0Var, p2.n nVar, i0.d dVar) {
        }
    }

    /* JADX INFO: compiled from: TsExtractor.java */
    private class b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a4.b0 f37109a = new a4.b0(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray<i0> f37110b = new SparseArray<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SparseIntArray f37111c = new SparseIntArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f37112d;

        public b(int i10) {
            this.f37112d = i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private z2.i0.b c(a4.c0 r13, int r14) {
            /*
                Method dump skipped, instruction units count: 206
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: z2.h0.b.c(a4.c0, int):z2.i0$b");
        }

        @Override // z2.b0
        public void a(a4.c0 c0Var) {
            l0 l0Var;
            if (c0Var.D() != 2) {
                return;
            }
            if (h0.this.f37088a == 1 || h0.this.f37088a == 2 || h0.this.f37100m == 1) {
                l0Var = (l0) h0.this.f37090c.get(0);
            } else {
                l0Var = new l0(((l0) h0.this.f37090c.get(0)).c());
                h0.this.f37090c.add(l0Var);
            }
            if ((c0Var.D() & 128) == 0) {
                return;
            }
            c0Var.Q(1);
            int iJ = c0Var.J();
            int i10 = 3;
            c0Var.Q(3);
            c0Var.i(this.f37109a, 2);
            this.f37109a.r(3);
            int i11 = 13;
            h0.this.f37106s = this.f37109a.h(13);
            c0Var.i(this.f37109a, 2);
            int i12 = 4;
            this.f37109a.r(4);
            c0Var.Q(this.f37109a.h(12));
            if (h0.this.f37088a == 2 && h0.this.f37104q == null) {
                i0.b bVar = new i0.b(21, null, null, o0.f219f);
                h0 h0Var = h0.this;
                h0Var.f37104q = h0Var.f37093f.a(21, bVar);
                if (h0.this.f37104q != null) {
                    h0.this.f37104q.b(l0Var, h0.this.f37099l, new i0.d(iJ, 21, 8192));
                }
            }
            this.f37110b.clear();
            this.f37111c.clear();
            int iA = c0Var.a();
            while (iA > 0) {
                c0Var.i(this.f37109a, 5);
                int iH = this.f37109a.h(8);
                this.f37109a.r(i10);
                int iH2 = this.f37109a.h(i11);
                this.f37109a.r(i12);
                int iH3 = this.f37109a.h(12);
                i0.b bVarC = c(c0Var, iH3);
                if (iH == 6 || iH == 5) {
                    iH = bVarC.f37139a;
                }
                iA -= iH3 + 5;
                int i13 = h0.this.f37088a == 2 ? iH : iH2;
                if (!h0.this.f37095h.get(i13)) {
                    i0 i0VarA = (h0.this.f37088a == 2 && iH == 21) ? h0.this.f37104q : h0.this.f37093f.a(iH, bVarC);
                    if (h0.this.f37088a != 2 || iH2 < this.f37111c.get(i13, 8192)) {
                        this.f37111c.put(i13, iH2);
                        this.f37110b.put(i13, i0VarA);
                    }
                }
                i10 = 3;
                i12 = 4;
                i11 = 13;
            }
            int size = this.f37111c.size();
            for (int i14 = 0; i14 < size; i14++) {
                int iKeyAt = this.f37111c.keyAt(i14);
                int iValueAt = this.f37111c.valueAt(i14);
                h0.this.f37095h.put(iKeyAt, true);
                h0.this.f37096i.put(iValueAt, true);
                i0 i0VarValueAt = this.f37110b.valueAt(i14);
                if (i0VarValueAt != null) {
                    if (i0VarValueAt != h0.this.f37104q) {
                        i0VarValueAt.b(l0Var, h0.this.f37099l, new i0.d(iJ, iKeyAt, 8192));
                    }
                    h0.this.f37094g.put(iValueAt, i0VarValueAt);
                }
            }
            if (h0.this.f37088a == 2) {
                if (h0.this.f37101n) {
                    return;
                }
                h0.this.f37099l.endTracks();
                h0.this.f37100m = 0;
                h0.this.f37101n = true;
                return;
            }
            h0.this.f37094g.remove(this.f37112d);
            h0 h0Var2 = h0.this;
            h0Var2.f37100m = h0Var2.f37088a == 1 ? 0 : h0.this.f37100m - 1;
            if (h0.this.f37100m == 0) {
                h0.this.f37099l.endTracks();
                h0.this.f37101n = true;
            }
        }

        @Override // z2.b0
        public void b(l0 l0Var, p2.n nVar, i0.d dVar) {
        }
    }
}
