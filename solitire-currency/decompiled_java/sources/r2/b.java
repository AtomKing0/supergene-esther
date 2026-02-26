package r2;

import a4.c0;
import a4.t;
import a4.x;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.extractor.avi.AviExtractor;
import com.google.common.collect.i1;
import java.io.IOException;
import java.util.ArrayList;
import k2.j2;
import k2.o1;
import p2.a0;
import p2.b0;
import p2.e0;
import p2.j;
import p2.l;
import p2.m;
import p2.n;

/* JADX INFO: compiled from: AviExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33259c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private r2.c f33261e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f33264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private e f33265i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f33269m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f33270n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f33257a = new c0(12);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f33258b = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n f33260d = new j();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e[] f33263g = new e[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f33267k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f33268l = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f33266j = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f33262f = C.TIME_UNSET;

    /* JADX INFO: renamed from: r2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AviExtractor.java */
    private class C0664b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f33271a;

        public C0664b(long j10) {
            this.f33271a = j10;
        }

        @Override // p2.b0
        public long getDurationUs() {
            return this.f33271a;
        }

        @Override // p2.b0
        public b0.a getSeekPoints(long j10) {
            b0.a aVarI = b.this.f33263g[0].i(j10);
            for (int i10 = 1; i10 < b.this.f33263g.length; i10++) {
                b0.a aVarI2 = b.this.f33263g[i10].i(j10);
                if (aVarI2.f32444a.f32450b < aVarI.f32444a.f32450b) {
                    aVarI = aVarI2;
                }
            }
            return aVarI;
        }

        @Override // p2.b0
        public boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: AviExtractor.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f33273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f33274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f33275c;

        private c() {
        }

        public void a(c0 c0Var) {
            this.f33273a = c0Var.q();
            this.f33274b = c0Var.q();
            this.f33275c = 0;
        }

        public void b(c0 c0Var) throws j2 {
            a(c0Var);
            if (this.f33273a == 1414744396) {
                this.f33275c = c0Var.q();
                return;
            }
            throw j2.a("LIST expected, found: " + this.f33273a, null);
        }
    }

    private static void e(m mVar) throws IOException {
        if ((mVar.getPosition() & 1) == 1) {
            mVar.skipFully(1);
        }
    }

    @Nullable
    private e f(int i10) {
        for (e eVar : this.f33263g) {
            if (eVar.j(i10)) {
                return eVar;
            }
        }
        return null;
    }

    private void g(c0 c0Var) throws IOException {
        f fVarC = f.c(AviExtractor.FOURCC_hdrl, c0Var);
        if (fVarC.getType() != 1819436136) {
            throw j2.a("Unexpected header list type " + fVarC.getType(), null);
        }
        r2.c cVar = (r2.c) fVarC.b(r2.c.class);
        if (cVar == null) {
            throw j2.a("AviHeader not found", null);
        }
        this.f33261e = cVar;
        this.f33262f = ((long) cVar.f33278c) * ((long) cVar.f33276a);
        ArrayList arrayList = new ArrayList();
        i1<r2.a> it = fVarC.f33298a.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            r2.a next = it.next();
            if (next.getType() == 1819440243) {
                int i11 = i10 + 1;
                e eVarJ = j((f) next, i10);
                if (eVarJ != null) {
                    arrayList.add(eVarJ);
                }
                i10 = i11;
            }
        }
        this.f33263g = (e[]) arrayList.toArray(new e[0]);
        this.f33260d.endTracks();
    }

    private void h(c0 c0Var) {
        long jI = i(c0Var);
        while (c0Var.a() >= 16) {
            int iQ = c0Var.q();
            int iQ2 = c0Var.q();
            long jQ = ((long) c0Var.q()) + jI;
            c0Var.q();
            e eVarF = f(iQ);
            if (eVarF != null) {
                if ((iQ2 & 16) == 16) {
                    eVarF.b(jQ);
                }
                eVarF.k();
            }
        }
        for (e eVar : this.f33263g) {
            eVar.c();
        }
        this.f33270n = true;
        this.f33260d.h(new C0664b(this.f33262f));
    }

    private long i(c0 c0Var) {
        if (c0Var.a() < 16) {
            return 0L;
        }
        int iE = c0Var.e();
        c0Var.Q(8);
        long jQ = c0Var.q();
        long j10 = this.f33267k;
        long j11 = jQ <= j10 ? j10 + 8 : 0L;
        c0Var.P(iE);
        return j11;
    }

    @Nullable
    private e j(f fVar, int i10) {
        d dVar = (d) fVar.b(d.class);
        g gVar = (g) fVar.b(g.class);
        if (dVar == null) {
            t.i("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (gVar == null) {
            t.i("AviExtractor", "Missing Stream Format");
            return null;
        }
        long jA = dVar.a();
        o1 o1Var = gVar.f33300a;
        o1.b bVarB = o1Var.b();
        bVarB.R(i10);
        int i11 = dVar.f33285f;
        if (i11 != 0) {
            bVarB.W(i11);
        }
        h hVar = (h) fVar.b(h.class);
        if (hVar != null) {
            bVarB.U(hVar.f33301a);
        }
        int i12 = x.i(o1Var.f29347l);
        if (i12 != 1 && i12 != 2) {
            return null;
        }
        e0 e0VarTrack = this.f33260d.track(i10, i12);
        e0VarTrack.f(bVarB.E());
        e eVar = new e(i10, i12, jA, dVar.f33284e, e0VarTrack);
        this.f33262f = jA;
        return eVar;
    }

    private int k(m mVar) throws IOException {
        if (mVar.getPosition() >= this.f33268l) {
            return -1;
        }
        e eVar = this.f33265i;
        if (eVar == null) {
            e(mVar);
            mVar.peekFully(this.f33257a.d(), 0, 12);
            this.f33257a.P(0);
            int iQ = this.f33257a.q();
            if (iQ == 1414744396) {
                this.f33257a.P(8);
                mVar.skipFully(this.f33257a.q() != 1769369453 ? 8 : 12);
                mVar.resetPeekPosition();
                return 0;
            }
            int iQ2 = this.f33257a.q();
            if (iQ == 1263424842) {
                this.f33264h = mVar.getPosition() + ((long) iQ2) + 8;
                return 0;
            }
            mVar.skipFully(8);
            mVar.resetPeekPosition();
            e eVarF = f(iQ);
            if (eVarF == null) {
                this.f33264h = mVar.getPosition() + ((long) iQ2);
                return 0;
            }
            eVarF.n(iQ2);
            this.f33265i = eVarF;
        } else if (eVar.m(mVar)) {
            this.f33265i = null;
        }
        return 0;
    }

    private boolean l(m mVar, a0 a0Var) throws IOException {
        boolean z10;
        if (this.f33264h != -1) {
            long position = mVar.getPosition();
            long j10 = this.f33264h;
            if (j10 < position || j10 > 262144 + position) {
                a0Var.f32443a = j10;
                z10 = true;
            } else {
                mVar.skipFully((int) (j10 - position));
                z10 = false;
            }
        } else {
            z10 = false;
        }
        this.f33264h = -1L;
        return z10;
    }

    @Override // p2.l
    public int a(m mVar, a0 a0Var) throws IOException {
        if (l(mVar, a0Var)) {
            return 1;
        }
        switch (this.f33259c) {
            case 0:
                if (!c(mVar)) {
                    throw j2.a("AVI Header List not found", null);
                }
                mVar.skipFully(12);
                this.f33259c = 1;
                return 0;
            case 1:
                mVar.readFully(this.f33257a.d(), 0, 12);
                this.f33257a.P(0);
                this.f33258b.b(this.f33257a);
                c cVar = this.f33258b;
                if (cVar.f33275c == 1819436136) {
                    this.f33266j = cVar.f33274b;
                    this.f33259c = 2;
                    return 0;
                }
                throw j2.a("hdrl expected, found: " + this.f33258b.f33275c, null);
            case 2:
                int i10 = this.f33266j - 4;
                c0 c0Var = new c0(i10);
                mVar.readFully(c0Var.d(), 0, i10);
                g(c0Var);
                this.f33259c = 3;
                return 0;
            case 3:
                if (this.f33267k != -1) {
                    long position = mVar.getPosition();
                    long j10 = this.f33267k;
                    if (position != j10) {
                        this.f33264h = j10;
                        return 0;
                    }
                }
                mVar.peekFully(this.f33257a.d(), 0, 12);
                mVar.resetPeekPosition();
                this.f33257a.P(0);
                this.f33258b.a(this.f33257a);
                int iQ = this.f33257a.q();
                int i11 = this.f33258b.f33273a;
                if (i11 == 1179011410) {
                    mVar.skipFully(12);
                    return 0;
                }
                if (i11 != 1414744396 || iQ != 1769369453) {
                    this.f33264h = mVar.getPosition() + ((long) this.f33258b.f33274b) + 8;
                    return 0;
                }
                long position2 = mVar.getPosition();
                this.f33267k = position2;
                this.f33268l = position2 + ((long) this.f33258b.f33274b) + 8;
                if (!this.f33270n) {
                    if (((r2.c) a4.a.e(this.f33261e)).a()) {
                        this.f33259c = 4;
                        this.f33264h = this.f33268l;
                        return 0;
                    }
                    this.f33260d.h(new b0.b(this.f33262f));
                    this.f33270n = true;
                }
                this.f33264h = mVar.getPosition() + 12;
                this.f33259c = 6;
                return 0;
            case 4:
                mVar.readFully(this.f33257a.d(), 0, 8);
                this.f33257a.P(0);
                int iQ2 = this.f33257a.q();
                int iQ3 = this.f33257a.q();
                if (iQ2 == 829973609) {
                    this.f33259c = 5;
                    this.f33269m = iQ3;
                } else {
                    this.f33264h = mVar.getPosition() + ((long) iQ3);
                }
                return 0;
            case 5:
                c0 c0Var2 = new c0(this.f33269m);
                mVar.readFully(c0Var2.d(), 0, this.f33269m);
                h(c0Var2);
                this.f33259c = 6;
                this.f33264h = this.f33267k;
                return 0;
            case 6:
                return k(mVar);
            default:
                throw new AssertionError();
        }
    }

    @Override // p2.l
    public void b(n nVar) {
        this.f33259c = 0;
        this.f33260d = nVar;
        this.f33264h = -1L;
    }

    @Override // p2.l
    public boolean c(m mVar) throws IOException {
        mVar.peekFully(this.f33257a.d(), 0, 12);
        this.f33257a.P(0);
        if (this.f33257a.q() != 1179011410) {
            return false;
        }
        this.f33257a.Q(4);
        return this.f33257a.q() == 541677121;
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        this.f33264h = -1L;
        this.f33265i = null;
        for (e eVar : this.f33263g) {
            eVar.o(j10);
        }
        if (j10 != 0) {
            this.f33259c = 6;
        } else if (this.f33263g.length == 0) {
            this.f33259c = 0;
        } else {
            this.f33259c = 3;
        }
    }

    @Override // p2.l
    public void release() {
    }
}
