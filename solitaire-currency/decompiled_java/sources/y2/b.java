package y2;

import a4.c0;
import a4.o0;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p2.b0;
import p2.m;
import p2.s;
import p2.t;
import p2.u;
import p2.v;
import y2.i;

/* JADX INFO: compiled from: FlacReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private v f36447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private a f36448o;

    /* JADX INFO: compiled from: FlacReader.java */
    private static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private v f36449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private v.a f36450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f36451c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f36452d = -1;

        public a(v vVar, v.a aVar) {
            this.f36449a = vVar;
            this.f36450b = aVar;
        }

        @Override // y2.g
        public long a(m mVar) {
            long j10 = this.f36452d;
            if (j10 < 0) {
                return -1L;
            }
            long j11 = -(j10 + 2);
            this.f36452d = -1L;
            return j11;
        }

        public void b(long j10) {
            this.f36451c = j10;
        }

        @Override // y2.g
        public b0 createSeekMap() {
            a4.a.g(this.f36451c != -1);
            return new u(this.f36449a, this.f36451c);
        }

        @Override // y2.g
        public void startSeek(long j10) {
            long[] jArr = this.f36450b.f32544a;
            this.f36452d = jArr[o0.i(jArr, j10, true, true)];
        }
    }

    b() {
    }

    private int n(c0 c0Var) {
        int i10 = (c0Var.d()[2] & 255) >> 4;
        if (i10 == 6 || i10 == 7) {
            c0Var.Q(4);
            c0Var.K();
        }
        int iJ = s.j(c0Var, i10);
        c0Var.P(0);
        return iJ;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(c0 c0Var) {
        return c0Var.a() >= 5 && c0Var.D() == 127 && c0Var.F() == 1179402563;
    }

    @Override // y2.i
    protected long f(c0 c0Var) {
        if (o(c0Var.d())) {
            return n(c0Var);
        }
        return -1L;
    }

    @Override // y2.i
    protected boolean h(c0 c0Var, long j10, i.b bVar) {
        byte[] bArrD = c0Var.d();
        v vVar = this.f36447n;
        if (vVar == null) {
            v vVar2 = new v(bArrD, 17);
            this.f36447n = vVar2;
            bVar.f36489a = vVar2.g(Arrays.copyOfRange(bArrD, 9, c0Var.f()), null);
            return true;
        }
        if ((bArrD[0] & 127) == 3) {
            v.a aVarF = t.f(c0Var);
            v vVarB = vVar.b(aVarF);
            this.f36447n = vVarB;
            this.f36448o = new a(vVarB, aVarF);
            return true;
        }
        if (!o(bArrD)) {
            return true;
        }
        a aVar = this.f36448o;
        if (aVar != null) {
            aVar.b(j10);
            bVar.f36490b = this.f36448o;
        }
        a4.a.e(bVar.f36489a);
        return false;
    }

    @Override // y2.i
    protected void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f36447n = null;
            this.f36448o = null;
        }
    }
}
