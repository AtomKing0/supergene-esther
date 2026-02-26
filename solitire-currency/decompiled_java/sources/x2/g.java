package x2;

import a4.c0;
import a4.l0;
import a4.o0;
import a4.t;
import a4.y;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import k2.j2;
import k2.o1;
import o2.m;
import p2.a0;
import p2.b0;
import p2.e0;
import p2.x;
import x2.a;

/* JADX INFO: compiled from: FragmentedMp4Extractor.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements p2.l {
    public static final p2.r I = new p2.r() { // from class: x2.f
        @Override // p2.r
        public final p2.l[] createExtractors() {
            return g.k();
        }

        @Override // p2.r
        public /* synthetic */ p2.l[] createExtractors(Uri uri, Map map) {
            return p2.q.a(this, uri, map);
        }
    };
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final o1 K = new o1.b().e0(MimeTypes.APPLICATION_EMSG).E();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private p2.n E;
    private e0[] F;
    private e0[] G;
    private boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final o f35775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<o1> f35776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray<b> f35777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c0 f35778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c0 f35779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c0 f35780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f35781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c0 f35782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final l0 f35783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final e3.c f35784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final c0 f35785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ArrayDeque<a.C0730a> f35786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ArrayDeque<a> f35787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private final e0 f35788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f35789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f35790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f35791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f35792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private c0 f35793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f35794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f35795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f35796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f35797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f35798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private b f35799z;

    /* JADX INFO: compiled from: FragmentedMp4Extractor.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f35800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f35801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35802c;

        public a(long j10, boolean z10, int i10) {
            this.f35800a = j10;
            this.f35801b = z10;
            this.f35802c = i10;
        }
    }

    /* JADX INFO: compiled from: FragmentedMp4Extractor.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f35803a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r f35806d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f35807e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f35808f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f35809g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f35810h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f35811i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f35814l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f35804b = new q();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f35805c = new c0();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final c0 f35812j = new c0(1);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c0 f35813k = new c0();

        public b(e0 e0Var, r rVar, c cVar) {
            this.f35803a = e0Var;
            this.f35806d = rVar;
            this.f35807e = cVar;
            j(rVar, cVar);
        }

        public int c() {
            int i10 = !this.f35814l ? this.f35806d.f35898g[this.f35808f] : this.f35804b.f35884k[this.f35808f] ? 1 : 0;
            return g() != null ? i10 | 1073741824 : i10;
        }

        public long d() {
            return !this.f35814l ? this.f35806d.f35894c[this.f35808f] : this.f35804b.f35880g[this.f35810h];
        }

        public long e() {
            return !this.f35814l ? this.f35806d.f35897f[this.f35808f] : this.f35804b.c(this.f35808f);
        }

        public int f() {
            return !this.f35814l ? this.f35806d.f35895d[this.f35808f] : this.f35804b.f35882i[this.f35808f];
        }

        @Nullable
        public p g() {
            if (!this.f35814l) {
                return null;
            }
            int i10 = ((c) o0.j(this.f35804b.f35874a)).f35763a;
            p pVarA = this.f35804b.f35887n;
            if (pVarA == null) {
                pVarA = this.f35806d.f35892a.a(i10);
            }
            if (pVarA == null || !pVarA.f35869a) {
                return null;
            }
            return pVarA;
        }

        public boolean h() {
            this.f35808f++;
            if (!this.f35814l) {
                return false;
            }
            int i10 = this.f35809g + 1;
            this.f35809g = i10;
            int[] iArr = this.f35804b.f35881h;
            int i11 = this.f35810h;
            if (i10 != iArr[i11]) {
                return true;
            }
            this.f35810h = i11 + 1;
            this.f35809g = 0;
            return false;
        }

        public int i(int i10, int i11) {
            c0 c0Var;
            p pVarG = g();
            if (pVarG == null) {
                return 0;
            }
            int length = pVarG.f35872d;
            if (length != 0) {
                c0Var = this.f35804b.f35888o;
            } else {
                byte[] bArr = (byte[]) o0.j(pVarG.f35873e);
                this.f35813k.N(bArr, bArr.length);
                c0 c0Var2 = this.f35813k;
                length = bArr.length;
                c0Var = c0Var2;
            }
            boolean zG = this.f35804b.g(this.f35808f);
            boolean z10 = zG || i11 != 0;
            this.f35812j.d()[0] = (byte) ((z10 ? 128 : 0) | length);
            this.f35812j.P(0);
            this.f35803a.b(this.f35812j, 1, 1);
            this.f35803a.b(c0Var, length, 1);
            if (!z10) {
                return length + 1;
            }
            if (!zG) {
                this.f35805c.L(8);
                byte[] bArrD = this.f35805c.d();
                bArrD[0] = 0;
                bArrD[1] = 1;
                bArrD[2] = (byte) ((i11 >> 8) & 255);
                bArrD[3] = (byte) (i11 & 255);
                bArrD[4] = (byte) ((i10 >> 24) & 255);
                bArrD[5] = (byte) ((i10 >> 16) & 255);
                bArrD[6] = (byte) ((i10 >> 8) & 255);
                bArrD[7] = (byte) (i10 & 255);
                this.f35803a.b(this.f35805c, 8, 1);
                return length + 1 + 8;
            }
            c0 c0Var3 = this.f35804b.f35888o;
            int iJ = c0Var3.J();
            c0Var3.Q(-2);
            int i12 = (iJ * 6) + 2;
            if (i11 != 0) {
                this.f35805c.L(i12);
                byte[] bArrD2 = this.f35805c.d();
                c0Var3.j(bArrD2, 0, i12);
                int i13 = (((bArrD2[2] & 255) << 8) | (bArrD2[3] & 255)) + i11;
                bArrD2[2] = (byte) ((i13 >> 8) & 255);
                bArrD2[3] = (byte) (i13 & 255);
                c0Var3 = this.f35805c;
            }
            this.f35803a.b(c0Var3, i12, 1);
            return length + 1 + i12;
        }

        public void j(r rVar, c cVar) {
            this.f35806d = rVar;
            this.f35807e = cVar;
            this.f35803a.f(rVar.f35892a.f35863f);
            k();
        }

        public void k() {
            this.f35804b.f();
            this.f35808f = 0;
            this.f35810h = 0;
            this.f35809g = 0;
            this.f35811i = 0;
            this.f35814l = false;
        }

        public void l(long j10) {
            int i10 = this.f35808f;
            while (true) {
                q qVar = this.f35804b;
                if (i10 >= qVar.f35879f || qVar.c(i10) >= j10) {
                    return;
                }
                if (this.f35804b.f35884k[i10]) {
                    this.f35811i = i10;
                }
                i10++;
            }
        }

        public void m() {
            p pVarG = g();
            if (pVarG == null) {
                return;
            }
            c0 c0Var = this.f35804b.f35888o;
            int i10 = pVarG.f35872d;
            if (i10 != 0) {
                c0Var.Q(i10);
            }
            if (this.f35804b.g(this.f35808f)) {
                c0Var.Q(c0Var.J() * 6);
            }
        }

        public void n(o2.m mVar) {
            p pVarA = this.f35806d.f35892a.a(((c) o0.j(this.f35804b.f35874a)).f35763a);
            this.f35803a.f(this.f35806d.f35892a.f35863f.b().M(mVar.b(pVarA != null ? pVarA.f35870b : null)).E());
        }
    }

    public g() {
        this(0);
    }

    private static long A(c0 c0Var) {
        c0Var.P(8);
        return x2.a.c(c0Var.n()) == 1 ? c0Var.I() : c0Var.F();
    }

    @Nullable
    private static b B(c0 c0Var, SparseArray<b> sparseArray, boolean z10) {
        c0Var.P(8);
        int iB = x2.a.b(c0Var.n());
        b bVarValueAt = z10 ? sparseArray.valueAt(0) : sparseArray.get(c0Var.n());
        if (bVarValueAt == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jI = c0Var.I();
            q qVar = bVarValueAt.f35804b;
            qVar.f35876c = jI;
            qVar.f35877d = jI;
        }
        c cVar = bVarValueAt.f35807e;
        bVarValueAt.f35804b.f35874a = new c((iB & 2) != 0 ? c0Var.n() - 1 : cVar.f35763a, (iB & 8) != 0 ? c0Var.n() : cVar.f35764b, (iB & 16) != 0 ? c0Var.n() : cVar.f35765c, (iB & 32) != 0 ? c0Var.n() : cVar.f35766d);
        return bVarValueAt;
    }

    private static void C(a.C0730a c0730a, SparseArray<b> sparseArray, boolean z10, int i10, byte[] bArr) throws j2 {
        b bVarB = B(((a.b) a4.a.e(c0730a.g(Atom.TYPE_tfhd))).f35733b, sparseArray, z10);
        if (bVarB == null) {
            return;
        }
        q qVar = bVarB.f35804b;
        long j10 = qVar.f35890q;
        boolean z11 = qVar.f35891r;
        bVarB.k();
        bVarB.f35814l = true;
        a.b bVarG = c0730a.g(Atom.TYPE_tfdt);
        if (bVarG == null || (i10 & 2) != 0) {
            qVar.f35890q = j10;
            qVar.f35891r = z11;
        } else {
            qVar.f35890q = A(bVarG.f35733b);
            qVar.f35891r = true;
        }
        F(c0730a, bVarB, i10);
        p pVarA = bVarB.f35806d.f35892a.a(((c) a4.a.e(qVar.f35874a)).f35763a);
        a.b bVarG2 = c0730a.g(Atom.TYPE_saiz);
        if (bVarG2 != null) {
            v((p) a4.a.e(pVarA), bVarG2.f35733b, qVar);
        }
        a.b bVarG3 = c0730a.g(Atom.TYPE_saio);
        if (bVarG3 != null) {
            u(bVarG3.f35733b, qVar);
        }
        a.b bVarG4 = c0730a.g(Atom.TYPE_senc);
        if (bVarG4 != null) {
            y(bVarG4.f35733b, qVar);
        }
        w(c0730a, pVarA != null ? pVarA.f35870b : null, qVar);
        int size = c0730a.f35731c.size();
        for (int i11 = 0; i11 < size; i11++) {
            a.b bVar = c0730a.f35731c.get(i11);
            if (bVar.f35729a == 1970628964) {
                G(bVar.f35733b, qVar, bArr);
            }
        }
    }

    private static Pair<Integer, c> D(c0 c0Var) {
        c0Var.P(12);
        return Pair.create(Integer.valueOf(c0Var.n()), new c(c0Var.n() - 1, c0Var.n(), c0Var.n(), c0Var.n()));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int E(x2.g.b r34, int r35, int r36, a4.c0 r37, int r38) throws k2.j2 {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.g.E(x2.g$b, int, int, a4.c0, int):int");
    }

    private static void F(a.C0730a c0730a, b bVar, int i10) throws j2 {
        List<a.b> list = c0730a.f35731c;
        int size = list.size();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            a.b bVar2 = list.get(i13);
            if (bVar2.f35729a == 1953658222) {
                c0 c0Var = bVar2.f35733b;
                c0Var.P(12);
                int iH = c0Var.H();
                if (iH > 0) {
                    i12 += iH;
                    i11++;
                }
            }
        }
        bVar.f35810h = 0;
        bVar.f35809g = 0;
        bVar.f35808f = 0;
        bVar.f35804b.e(i11, i12);
        int i14 = 0;
        int iE = 0;
        for (int i15 = 0; i15 < size; i15++) {
            a.b bVar3 = list.get(i15);
            if (bVar3.f35729a == 1953658222) {
                iE = E(bVar, i14, i10, bVar3.f35733b, iE);
                i14++;
            }
        }
    }

    private static void G(c0 c0Var, q qVar, byte[] bArr) throws j2 {
        c0Var.P(8);
        c0Var.j(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            x(c0Var, 16, qVar);
        }
    }

    private void H(long j10) throws j2 {
        while (!this.f35786m.isEmpty() && this.f35786m.peek().f35730b == j10) {
            m(this.f35786m.pop());
        }
        f();
    }

    private boolean I(p2.m mVar) throws IOException {
        if (this.f35792s == 0) {
            if (!mVar.readFully(this.f35785l.d(), 0, 8, true)) {
                return false;
            }
            this.f35792s = 8;
            this.f35785l.P(0);
            this.f35791r = this.f35785l.F();
            this.f35790q = this.f35785l.n();
        }
        long j10 = this.f35791r;
        if (j10 == 1) {
            mVar.readFully(this.f35785l.d(), 8, 8);
            this.f35792s += 8;
            this.f35791r = this.f35785l.I();
        } else if (j10 == 0) {
            long length = mVar.getLength();
            if (length == -1 && !this.f35786m.isEmpty()) {
                length = this.f35786m.peek().f35730b;
            }
            if (length != -1) {
                this.f35791r = (length - mVar.getPosition()) + ((long) this.f35792s);
            }
        }
        if (this.f35791r < this.f35792s) {
            throw j2.c("Atom size less than header length (unsupported).");
        }
        long position = mVar.getPosition() - ((long) this.f35792s);
        int i10 = this.f35790q;
        if ((i10 == 1836019558 || i10 == 1835295092) && !this.H) {
            this.E.h(new b0.b(this.f35797x, position));
            this.H = true;
        }
        if (this.f35790q == 1836019558) {
            int size = this.f35777d.size();
            for (int i11 = 0; i11 < size; i11++) {
                q qVar = this.f35777d.valueAt(i11).f35804b;
                qVar.f35875b = position;
                qVar.f35877d = position;
                qVar.f35876c = position;
            }
        }
        int i12 = this.f35790q;
        if (i12 == 1835295092) {
            this.f35799z = null;
            this.f35794u = position + this.f35791r;
            this.f35789p = 2;
            return true;
        }
        if (M(i12)) {
            long position2 = (mVar.getPosition() + this.f35791r) - 8;
            this.f35786m.push(new a.C0730a(this.f35790q, position2));
            if (this.f35791r == this.f35792s) {
                H(position2);
            } else {
                f();
            }
        } else if (N(this.f35790q)) {
            if (this.f35792s != 8) {
                throw j2.c("Leaf atom defines extended atom size (unsupported).");
            }
            long j11 = this.f35791r;
            if (j11 > 2147483647L) {
                throw j2.c("Leaf atom with length > 2147483647 (unsupported).");
            }
            c0 c0Var = new c0((int) j11);
            System.arraycopy(this.f35785l.d(), 0, c0Var.d(), 0, 8);
            this.f35793t = c0Var;
            this.f35789p = 1;
        } else {
            if (this.f35791r > 2147483647L) {
                throw j2.c("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f35793t = null;
            this.f35789p = 1;
        }
        return true;
    }

    private void J(p2.m mVar) throws IOException {
        int i10 = ((int) this.f35791r) - this.f35792s;
        c0 c0Var = this.f35793t;
        if (c0Var != null) {
            mVar.readFully(c0Var.d(), 8, i10);
            o(new a.b(this.f35790q, c0Var), mVar.getPosition());
        } else {
            mVar.skipFully(i10);
        }
        H(mVar.getPosition());
    }

    private void K(p2.m mVar) throws IOException {
        int size = this.f35777d.size();
        long j10 = Long.MAX_VALUE;
        b bVarValueAt = null;
        for (int i10 = 0; i10 < size; i10++) {
            q qVar = this.f35777d.valueAt(i10).f35804b;
            if (qVar.f35889p) {
                long j11 = qVar.f35877d;
                if (j11 < j10) {
                    bVarValueAt = this.f35777d.valueAt(i10);
                    j10 = j11;
                }
            }
        }
        if (bVarValueAt == null) {
            this.f35789p = 3;
            return;
        }
        int position = (int) (j10 - mVar.getPosition());
        if (position < 0) {
            throw j2.a("Offset to encryption data was negative.", null);
        }
        mVar.skipFully(position);
        bVarValueAt.f35804b.b(mVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean L(p2.m mVar) throws IOException {
        int iC;
        b bVarI = this.f35799z;
        Throwable th = null;
        if (bVarI == null) {
            bVarI = i(this.f35777d);
            if (bVarI == null) {
                int position = (int) (this.f35794u - mVar.getPosition());
                if (position < 0) {
                    throw j2.a("Offset to end of mdat was negative.", null);
                }
                mVar.skipFully(position);
                f();
                return false;
            }
            int iD = (int) (bVarI.d() - mVar.getPosition());
            if (iD < 0) {
                t.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iD = 0;
            }
            mVar.skipFully(iD);
            this.f35799z = bVarI;
        }
        int i10 = 4;
        int i11 = 1;
        if (this.f35789p == 3) {
            int iF = bVarI.f();
            this.A = iF;
            if (bVarI.f35808f < bVarI.f35811i) {
                mVar.skipFully(iF);
                bVarI.m();
                if (!bVarI.h()) {
                    this.f35799z = null;
                }
                this.f35789p = 3;
                return true;
            }
            if (bVarI.f35806d.f35892a.f35864g == 1) {
                this.A = iF - 8;
                mVar.skipFully(8);
            }
            if (MimeTypes.AUDIO_AC4.equals(bVarI.f35806d.f35892a.f35863f.f29347l)) {
                this.B = bVarI.i(this.A, 7);
                m2.c.a(this.A, this.f35782i);
                bVarI.f35803a.e(this.f35782i, 7);
                this.B += 7;
            } else {
                this.B = bVarI.i(this.A, 0);
            }
            this.A += this.B;
            this.f35789p = 4;
            this.C = 0;
        }
        o oVar = bVarI.f35806d.f35892a;
        e0 e0Var = bVarI.f35803a;
        long jE = bVarI.e();
        l0 l0Var = this.f35783j;
        if (l0Var != null) {
            jE = l0Var.a(jE);
        }
        long j10 = jE;
        if (oVar.f35867j == 0) {
            while (true) {
                int i12 = this.B;
                int i13 = this.A;
                if (i12 >= i13) {
                    break;
                }
                this.B += e0Var.c(mVar, i13 - i12, false);
            }
        } else {
            byte[] bArrD = this.f35779f.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i14 = oVar.f35867j;
            int i15 = i14 + 1;
            int i16 = 4 - i14;
            while (this.B < this.A) {
                int i17 = this.C;
                if (i17 == 0) {
                    mVar.readFully(bArrD, i16, i15);
                    this.f35779f.P(0);
                    int iN = this.f35779f.n();
                    if (iN < i11) {
                        throw j2.a("Invalid NAL length", th);
                    }
                    this.C = iN - 1;
                    this.f35778e.P(0);
                    e0Var.e(this.f35778e, i10);
                    e0Var.e(this.f35779f, i11);
                    this.D = (this.G.length <= 0 || !y.g(oVar.f35863f.f29347l, bArrD[i10])) ? 0 : i11;
                    this.B += 5;
                    this.A += i16;
                } else {
                    if (this.D) {
                        this.f35780g.L(i17);
                        mVar.readFully(this.f35780g.d(), 0, this.C);
                        e0Var.e(this.f35780g, this.C);
                        iC = this.C;
                        int iQ = y.q(this.f35780g.d(), this.f35780g.f());
                        this.f35780g.P("video/hevc".equals(oVar.f35863f.f29347l) ? 1 : 0);
                        this.f35780g.O(iQ);
                        p2.c.a(j10, this.f35780g, this.G);
                    } else {
                        iC = e0Var.c(mVar, i17, false);
                    }
                    this.B += iC;
                    this.C -= iC;
                    th = null;
                    i10 = 4;
                    i11 = 1;
                }
            }
        }
        int iC2 = bVarI.c();
        p pVarG = bVarI.g();
        e0Var.a(j10, iC2, this.A, 0, pVarG != null ? pVarG.f35871c : null);
        r(j10);
        if (!bVarI.h()) {
            this.f35799z = null;
        }
        this.f35789p = 3;
        return true;
    }

    private static boolean M(int i10) {
        return i10 == 1836019574 || i10 == 1953653099 || i10 == 1835297121 || i10 == 1835626086 || i10 == 1937007212 || i10 == 1836019558 || i10 == 1953653094 || i10 == 1836475768 || i10 == 1701082227;
    }

    private static boolean N(int i10) {
        return i10 == 1751411826 || i10 == 1835296868 || i10 == 1836476516 || i10 == 1936286840 || i10 == 1937011556 || i10 == 1937011827 || i10 == 1668576371 || i10 == 1937011555 || i10 == 1937011578 || i10 == 1937013298 || i10 == 1937007471 || i10 == 1668232756 || i10 == 1937011571 || i10 == 1952867444 || i10 == 1952868452 || i10 == 1953196132 || i10 == 1953654136 || i10 == 1953658222 || i10 == 1886614376 || i10 == 1935763834 || i10 == 1935763823 || i10 == 1936027235 || i10 == 1970628964 || i10 == 1935828848 || i10 == 1936158820 || i10 == 1701606260 || i10 == 1835362404 || i10 == 1701671783;
    }

    private static int e(int i10) throws j2 {
        if (i10 >= 0) {
            return i10;
        }
        throw j2.a("Unexpected negative value: " + i10, null);
    }

    private void f() {
        this.f35789p = 0;
        this.f35792s = 0;
    }

    private c g(SparseArray<c> sparseArray, int i10) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (c) a4.a.e(sparseArray.get(i10));
    }

    @Nullable
    private static o2.m h(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            a.b bVar = list.get(i10);
            if (bVar.f35729a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrD = bVar.f35733b.d();
                UUID uuidF = l.f(bArrD);
                if (uuidF == null) {
                    t.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new m.b(uuidF, MimeTypes.VIDEO_MP4, bArrD));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new o2.m(arrayList);
    }

    @Nullable
    private static b i(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j10 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            b bVarValueAt = sparseArray.valueAt(i10);
            if ((bVarValueAt.f35814l || bVarValueAt.f35808f != bVarValueAt.f35806d.f35893b) && (!bVarValueAt.f35814l || bVarValueAt.f35810h != bVarValueAt.f35804b.f35878e)) {
                long jD = bVarValueAt.d();
                if (jD < j10) {
                    bVar = bVarValueAt;
                    j10 = jD;
                }
            }
        }
        return bVar;
    }

    private void j() {
        int i10;
        e0[] e0VarArr = new e0[2];
        this.F = e0VarArr;
        e0 e0Var = this.f35788o;
        int i11 = 0;
        if (e0Var != null) {
            e0VarArr[0] = e0Var;
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i12 = 100;
        if ((this.f35774a & 4) != 0) {
            e0VarArr[i10] = this.E.track(100, 5);
            i12 = 101;
            i10++;
        }
        e0[] e0VarArr2 = (e0[]) o0.A0(this.F, i10);
        this.F = e0VarArr2;
        for (e0 e0Var2 : e0VarArr2) {
            e0Var2.f(K);
        }
        this.G = new e0[this.f35776c.size()];
        while (i11 < this.G.length) {
            e0 e0VarTrack = this.E.track(i12, 3);
            e0VarTrack.f(this.f35776c.get(i11));
            this.G[i11] = e0VarTrack;
            i11++;
            i12++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p2.l[] k() {
        return new p2.l[]{new g()};
    }

    private void m(a.C0730a c0730a) throws j2 {
        int i10 = c0730a.f35729a;
        if (i10 == 1836019574) {
            q(c0730a);
        } else if (i10 == 1836019558) {
            p(c0730a);
        } else {
            if (this.f35786m.isEmpty()) {
                return;
            }
            this.f35786m.peek().d(c0730a);
        }
    }

    private void n(c0 c0Var) {
        long jF0;
        String str;
        long jF02;
        String str2;
        long jF;
        long jA;
        if (this.F.length == 0) {
            return;
        }
        c0Var.P(8);
        int iC = x2.a.c(c0Var.n());
        if (iC == 0) {
            String str3 = (String) a4.a.e(c0Var.x());
            String str4 = (String) a4.a.e(c0Var.x());
            long jF2 = c0Var.F();
            jF0 = o0.F0(c0Var.F(), 1000000L, jF2);
            long j10 = this.f35798y;
            long j11 = j10 != C.TIME_UNSET ? j10 + jF0 : -9223372036854775807L;
            str = str3;
            jF02 = o0.F0(c0Var.F(), 1000L, jF2);
            str2 = str4;
            jF = c0Var.F();
            jA = j11;
        } else {
            if (iC != 1) {
                t.i("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iC);
                return;
            }
            long jF3 = c0Var.F();
            jA = o0.F0(c0Var.I(), 1000000L, jF3);
            long jF03 = o0.F0(c0Var.F(), 1000L, jF3);
            long jF4 = c0Var.F();
            str = (String) a4.a.e(c0Var.x());
            jF02 = jF03;
            jF = jF4;
            str2 = (String) a4.a.e(c0Var.x());
            jF0 = -9223372036854775807L;
        }
        byte[] bArr = new byte[c0Var.a()];
        c0Var.j(bArr, 0, c0Var.a());
        c0 c0Var2 = new c0(this.f35784k.a(new e3.a(str, str2, jF02, jF, bArr)));
        int iA = c0Var2.a();
        for (e0 e0Var : this.F) {
            c0Var2.P(0);
            e0Var.e(c0Var2, iA);
        }
        if (jA == C.TIME_UNSET) {
            this.f35787n.addLast(new a(jF0, true, iA));
            this.f35795v += iA;
            return;
        }
        if (!this.f35787n.isEmpty()) {
            this.f35787n.addLast(new a(jA, false, iA));
            this.f35795v += iA;
            return;
        }
        l0 l0Var = this.f35783j;
        if (l0Var != null) {
            jA = l0Var.a(jA);
        }
        for (e0 e0Var2 : this.F) {
            e0Var2.a(jA, 1, iA, 0, null);
        }
    }

    private void o(a.b bVar, long j10) throws j2 {
        if (!this.f35786m.isEmpty()) {
            this.f35786m.peek().e(bVar);
            return;
        }
        int i10 = bVar.f35729a;
        if (i10 != 1936286840) {
            if (i10 == 1701671783) {
                n(bVar.f35733b);
            }
        } else {
            Pair<Long, p2.d> pairZ = z(bVar.f35733b, j10);
            this.f35798y = ((Long) pairZ.first).longValue();
            this.E.h((b0) pairZ.second);
            this.H = true;
        }
    }

    private void p(a.C0730a c0730a) throws j2 {
        t(c0730a, this.f35777d, this.f35775b != null, this.f35774a, this.f35781h);
        o2.m mVarH = h(c0730a.f35731c);
        if (mVarH != null) {
            int size = this.f35777d.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f35777d.valueAt(i10).n(mVarH);
            }
        }
        if (this.f35796w != C.TIME_UNSET) {
            int size2 = this.f35777d.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f35777d.valueAt(i11).l(this.f35796w);
            }
            this.f35796w = C.TIME_UNSET;
        }
    }

    private void q(a.C0730a c0730a) throws j2 {
        int i10 = 0;
        a4.a.h(this.f35775b == null, "Unexpected moov box.");
        o2.m mVarH = h(c0730a.f35731c);
        a.C0730a c0730a2 = (a.C0730a) a4.a.e(c0730a.f(Atom.TYPE_mvex));
        SparseArray<c> sparseArray = new SparseArray<>();
        int size = c0730a2.f35731c.size();
        long jS = -9223372036854775807L;
        for (int i11 = 0; i11 < size; i11++) {
            a.b bVar = c0730a2.f35731c.get(i11);
            int i12 = bVar.f35729a;
            if (i12 == 1953654136) {
                Pair<Integer, c> pairD = D(bVar.f35733b);
                sparseArray.put(((Integer) pairD.first).intValue(), (c) pairD.second);
            } else if (i12 == 1835362404) {
                jS = s(bVar.f35733b);
            }
        }
        List<r> listA = x2.b.A(c0730a, new x(), jS, mVarH, (this.f35774a & 16) != 0, false, new e5.g() { // from class: x2.e
            @Override // e5.g
            public final Object apply(Object obj) {
                return this.f35773a.l((o) obj);
            }
        });
        int size2 = listA.size();
        if (this.f35777d.size() != 0) {
            a4.a.g(this.f35777d.size() == size2);
            while (i10 < size2) {
                r rVar = listA.get(i10);
                o oVar = rVar.f35892a;
                this.f35777d.get(oVar.f35858a).j(rVar, g(sparseArray, oVar.f35858a));
                i10++;
            }
            return;
        }
        while (i10 < size2) {
            r rVar2 = listA.get(i10);
            o oVar2 = rVar2.f35892a;
            this.f35777d.put(oVar2.f35858a, new b(this.E.track(i10, oVar2.f35859b), rVar2, g(sparseArray, oVar2.f35858a)));
            this.f35797x = Math.max(this.f35797x, oVar2.f35862e);
            i10++;
        }
        this.E.endTracks();
    }

    private void r(long j10) {
        while (!this.f35787n.isEmpty()) {
            a aVarRemoveFirst = this.f35787n.removeFirst();
            this.f35795v -= aVarRemoveFirst.f35802c;
            long jA = aVarRemoveFirst.f35800a;
            if (aVarRemoveFirst.f35801b) {
                jA += j10;
            }
            l0 l0Var = this.f35783j;
            if (l0Var != null) {
                jA = l0Var.a(jA);
            }
            for (e0 e0Var : this.F) {
                e0Var.a(jA, 1, aVarRemoveFirst.f35802c, this.f35795v, null);
            }
        }
    }

    private static long s(c0 c0Var) {
        c0Var.P(8);
        return x2.a.c(c0Var.n()) == 0 ? c0Var.F() : c0Var.I();
    }

    private static void t(a.C0730a c0730a, SparseArray<b> sparseArray, boolean z10, int i10, byte[] bArr) throws j2 {
        int size = c0730a.f35732d.size();
        for (int i11 = 0; i11 < size; i11++) {
            a.C0730a c0730a2 = c0730a.f35732d.get(i11);
            if (c0730a2.f35729a == 1953653094) {
                C(c0730a2, sparseArray, z10, i10, bArr);
            }
        }
    }

    private static void u(c0 c0Var, q qVar) throws j2 {
        c0Var.P(8);
        int iN = c0Var.n();
        if ((x2.a.b(iN) & 1) == 1) {
            c0Var.Q(8);
        }
        int iH = c0Var.H();
        if (iH == 1) {
            qVar.f35877d += x2.a.c(iN) == 0 ? c0Var.F() : c0Var.I();
        } else {
            throw j2.a("Unexpected saio entry count: " + iH, null);
        }
    }

    private static void v(p pVar, c0 c0Var, q qVar) throws j2 {
        int i10;
        int i11 = pVar.f35872d;
        c0Var.P(8);
        if ((x2.a.b(c0Var.n()) & 1) == 1) {
            c0Var.Q(8);
        }
        int iD = c0Var.D();
        int iH = c0Var.H();
        if (iH > qVar.f35879f) {
            throw j2.a("Saiz sample count " + iH + " is greater than fragment sample count" + qVar.f35879f, null);
        }
        if (iD == 0) {
            boolean[] zArr = qVar.f35886m;
            i10 = 0;
            for (int i12 = 0; i12 < iH; i12++) {
                int iD2 = c0Var.D();
                i10 += iD2;
                zArr[i12] = iD2 > i11;
            }
        } else {
            i10 = (iD * iH) + 0;
            Arrays.fill(qVar.f35886m, 0, iH, iD > i11);
        }
        Arrays.fill(qVar.f35886m, iH, qVar.f35879f, false);
        if (i10 > 0) {
            qVar.d(i10);
        }
    }

    private static void w(a.C0730a c0730a, @Nullable String str, q qVar) throws j2 {
        byte[] bArr = null;
        c0 c0Var = null;
        c0 c0Var2 = null;
        for (int i10 = 0; i10 < c0730a.f35731c.size(); i10++) {
            a.b bVar = c0730a.f35731c.get(i10);
            c0 c0Var3 = bVar.f35733b;
            int i11 = bVar.f35729a;
            if (i11 == 1935828848) {
                c0Var3.P(12);
                if (c0Var3.n() == 1936025959) {
                    c0Var = c0Var3;
                }
            } else if (i11 == 1936158820) {
                c0Var3.P(12);
                if (c0Var3.n() == 1936025959) {
                    c0Var2 = c0Var3;
                }
            }
        }
        if (c0Var == null || c0Var2 == null) {
            return;
        }
        c0Var.P(8);
        int iC = x2.a.c(c0Var.n());
        c0Var.Q(4);
        if (iC == 1) {
            c0Var.Q(4);
        }
        if (c0Var.n() != 1) {
            throw j2.c("Entry count in sbgp != 1 (unsupported).");
        }
        c0Var2.P(8);
        int iC2 = x2.a.c(c0Var2.n());
        c0Var2.Q(4);
        if (iC2 == 1) {
            if (c0Var2.F() == 0) {
                throw j2.c("Variable length description in sgpd found (unsupported)");
            }
        } else if (iC2 >= 2) {
            c0Var2.Q(4);
        }
        if (c0Var2.F() != 1) {
            throw j2.c("Entry count in sgpd != 1 (unsupported).");
        }
        c0Var2.Q(1);
        int iD = c0Var2.D();
        int i12 = (iD & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        int i13 = iD & 15;
        boolean z10 = c0Var2.D() == 1;
        if (z10) {
            int iD2 = c0Var2.D();
            byte[] bArr2 = new byte[16];
            c0Var2.j(bArr2, 0, 16);
            if (iD2 == 0) {
                int iD3 = c0Var2.D();
                bArr = new byte[iD3];
                c0Var2.j(bArr, 0, iD3);
            }
            qVar.f35885l = true;
            qVar.f35887n = new p(z10, str, iD2, bArr2, i12, i13, bArr);
        }
    }

    private static void x(c0 c0Var, int i10, q qVar) throws j2 {
        c0Var.P(i10 + 8);
        int iB = x2.a.b(c0Var.n());
        if ((iB & 1) != 0) {
            throw j2.c("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z10 = (iB & 2) != 0;
        int iH = c0Var.H();
        if (iH == 0) {
            Arrays.fill(qVar.f35886m, 0, qVar.f35879f, false);
            return;
        }
        if (iH == qVar.f35879f) {
            Arrays.fill(qVar.f35886m, 0, iH, z10);
            qVar.d(c0Var.a());
            qVar.a(c0Var);
        } else {
            throw j2.a("Senc sample count " + iH + " is different from fragment sample count" + qVar.f35879f, null);
        }
    }

    private static void y(c0 c0Var, q qVar) throws j2 {
        x(c0Var, 0, qVar);
    }

    private static Pair<Long, p2.d> z(c0 c0Var, long j10) throws j2 {
        long jI;
        long jI2;
        c0Var.P(8);
        int iC = x2.a.c(c0Var.n());
        c0Var.Q(4);
        long jF = c0Var.F();
        if (iC == 0) {
            jI = c0Var.F();
            jI2 = c0Var.F();
        } else {
            jI = c0Var.I();
            jI2 = c0Var.I();
        }
        long j11 = jI;
        long j12 = j10 + jI2;
        long jF0 = o0.F0(j11, 1000000L, jF);
        c0Var.Q(2);
        int iJ = c0Var.J();
        int[] iArr = new int[iJ];
        long[] jArr = new long[iJ];
        long[] jArr2 = new long[iJ];
        long[] jArr3 = new long[iJ];
        long j13 = jF0;
        int i10 = 0;
        long j14 = j11;
        while (i10 < iJ) {
            int iN = c0Var.n();
            if ((iN & Integer.MIN_VALUE) != 0) {
                throw j2.a("Unhandled indirect reference", null);
            }
            long jF2 = c0Var.F();
            iArr[i10] = iN & Integer.MAX_VALUE;
            jArr[i10] = j12;
            jArr3[i10] = j13;
            long j15 = j14 + jF2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i11 = iJ;
            int[] iArr2 = iArr;
            long jF02 = o0.F0(j15, 1000000L, jF);
            jArr4[i10] = jF02 - jArr5[i10];
            c0Var.Q(4);
            j12 += (long) iArr2[i10];
            i10++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iJ = i11;
            j14 = j15;
            j13 = jF02;
        }
        return Pair.create(Long.valueOf(jF0), new p2.d(iArr, jArr, jArr2, jArr3));
    }

    @Override // p2.l
    public int a(p2.m mVar, a0 a0Var) throws IOException {
        while (true) {
            int i10 = this.f35789p;
            if (i10 != 0) {
                if (i10 == 1) {
                    J(mVar);
                } else if (i10 == 2) {
                    K(mVar);
                } else if (L(mVar)) {
                    return 0;
                }
            } else if (!I(mVar)) {
                return -1;
            }
        }
    }

    @Override // p2.l
    public void b(p2.n nVar) {
        this.E = nVar;
        f();
        j();
        o oVar = this.f35775b;
        if (oVar != null) {
            this.f35777d.put(0, new b(nVar.track(0, oVar.f35859b), new r(this.f35775b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.E.endTracks();
        }
    }

    @Override // p2.l
    public boolean c(p2.m mVar) throws IOException {
        return n.b(mVar);
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        int size = this.f35777d.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f35777d.valueAt(i10).k();
        }
        this.f35787n.clear();
        this.f35795v = 0;
        this.f35796w = j11;
        this.f35786m.clear();
        f();
    }

    public g(int i10) {
        this(i10, null);
    }

    public g(int i10, @Nullable l0 l0Var) {
        this(i10, l0Var, null, Collections.emptyList());
    }

    public g(int i10, @Nullable l0 l0Var, @Nullable o oVar, List<o1> list) {
        this(i10, l0Var, oVar, list, null);
    }

    public g(int i10, @Nullable l0 l0Var, @Nullable o oVar, List<o1> list, @Nullable e0 e0Var) {
        this.f35774a = i10;
        this.f35783j = l0Var;
        this.f35775b = oVar;
        this.f35776c = Collections.unmodifiableList(list);
        this.f35788o = e0Var;
        this.f35784k = new e3.c();
        this.f35785l = new c0(16);
        this.f35778e = new c0(y.f258a);
        this.f35779f = new c0(5);
        this.f35780g = new c0();
        byte[] bArr = new byte[16];
        this.f35781h = bArr;
        this.f35782i = new c0(bArr);
        this.f35786m = new ArrayDeque<>();
        this.f35787n = new ArrayDeque<>();
        this.f35777d = new SparseArray<>();
        this.f35797x = C.TIME_UNSET;
        this.f35796w = C.TIME_UNSET;
        this.f35798y = C.TIME_UNSET;
        this.E = p2.n.P7;
        this.F = new e0[0];
        this.G = new e0[0];
    }

    @Override // p2.l
    public void release() {
    }

    @Nullable
    protected o l(@Nullable o oVar) {
        return oVar;
    }
}
