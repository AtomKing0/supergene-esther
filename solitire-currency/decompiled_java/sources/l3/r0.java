package l3;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import l3.t0;
import p2.e0;
import z3.b;

/* JADX INFO: compiled from: SampleDataQueue.java */
/* JADX INFO: loaded from: classes2.dex */
class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z3.b f30677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a4.c0 f30679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f30680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f30681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f30682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f30683g;

    /* JADX INFO: compiled from: SampleDataQueue.java */
    private static final class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f30685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public z3.a f30686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public a f30687d;

        public a(long j10, int i10) {
            c(j10, i10);
        }

        public a a() {
            this.f30686c = null;
            a aVar = this.f30687d;
            this.f30687d = null;
            return aVar;
        }

        public void b(z3.a aVar, a aVar2) {
            this.f30686c = aVar;
            this.f30687d = aVar2;
        }

        public void c(long j10, int i10) {
            a4.a.g(this.f30686c == null);
            this.f30684a = j10;
            this.f30685b = j10 + ((long) i10);
        }

        public int d(long j10) {
            return ((int) (j10 - this.f30684a)) + this.f30686c.f37363b;
        }

        @Override // z3.b.a
        public z3.a getAllocation() {
            return (z3.a) a4.a.e(this.f30686c);
        }

        @Override // z3.b.a
        @Nullable
        public b.a next() {
            a aVar = this.f30687d;
            if (aVar == null || aVar.f30686c == null) {
                return null;
            }
            return aVar;
        }
    }

    public r0(z3.b bVar) {
        this.f30677a = bVar;
        int individualAllocationLength = bVar.getIndividualAllocationLength();
        this.f30678b = individualAllocationLength;
        this.f30679c = new a4.c0(32);
        a aVar = new a(0L, individualAllocationLength);
        this.f30680d = aVar;
        this.f30681e = aVar;
        this.f30682f = aVar;
    }

    private void a(a aVar) {
        if (aVar.f30686c == null) {
            return;
        }
        this.f30677a.b(aVar);
        aVar.a();
    }

    private static a c(a aVar, long j10) {
        while (j10 >= aVar.f30685b) {
            aVar = aVar.f30687d;
        }
        return aVar;
    }

    private void f(int i10) {
        long j10 = this.f30683g + ((long) i10);
        this.f30683g = j10;
        a aVar = this.f30682f;
        if (j10 == aVar.f30685b) {
            this.f30682f = aVar.f30687d;
        }
    }

    private int g(int i10) {
        a aVar = this.f30682f;
        if (aVar.f30686c == null) {
            aVar.b(this.f30677a.allocate(), new a(this.f30682f.f30685b, this.f30678b));
        }
        return Math.min(i10, (int) (this.f30682f.f30685b - this.f30683g));
    }

    private static a h(a aVar, long j10, ByteBuffer byteBuffer, int i10) {
        a aVarC = c(aVar, j10);
        while (i10 > 0) {
            int iMin = Math.min(i10, (int) (aVarC.f30685b - j10));
            byteBuffer.put(aVarC.f30686c.f37362a, aVarC.d(j10), iMin);
            i10 -= iMin;
            j10 += (long) iMin;
            if (j10 == aVarC.f30685b) {
                aVarC = aVarC.f30687d;
            }
        }
        return aVarC;
    }

    private static a i(a aVar, long j10, byte[] bArr, int i10) {
        a aVarC = c(aVar, j10);
        int i11 = i10;
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (aVarC.f30685b - j10));
            System.arraycopy(aVarC.f30686c.f37362a, aVarC.d(j10), bArr, i10 - i11, iMin);
            i11 -= iMin;
            j10 += (long) iMin;
            if (j10 == aVarC.f30685b) {
                aVarC = aVarC.f30687d;
            }
        }
        return aVarC;
    }

    private static a j(a aVar, n2.g gVar, t0.b bVar, a4.c0 c0Var) {
        long j10 = bVar.f30728b;
        int iJ = 1;
        c0Var.L(1);
        a aVarI = i(aVar, j10, c0Var.d(), 1);
        long j11 = j10 + 1;
        byte b10 = c0Var.d()[0];
        boolean z10 = (b10 & 128) != 0;
        int i10 = b10 & 127;
        n2.c cVar = gVar.f31585b;
        byte[] bArr = cVar.f31561a;
        if (bArr == null) {
            cVar.f31561a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarI2 = i(aVarI, j11, cVar.f31561a, i10);
        long j12 = j11 + ((long) i10);
        if (z10) {
            c0Var.L(2);
            aVarI2 = i(aVarI2, j12, c0Var.d(), 2);
            j12 += 2;
            iJ = c0Var.J();
        }
        int i11 = iJ;
        int[] iArr = cVar.f31564d;
        if (iArr == null || iArr.length < i11) {
            iArr = new int[i11];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cVar.f31565e;
        if (iArr3 == null || iArr3.length < i11) {
            iArr3 = new int[i11];
        }
        int[] iArr4 = iArr3;
        if (z10) {
            int i12 = i11 * 6;
            c0Var.L(i12);
            aVarI2 = i(aVarI2, j12, c0Var.d(), i12);
            j12 += (long) i12;
            c0Var.P(0);
            for (int i13 = 0; i13 < i11; i13++) {
                iArr2[i13] = c0Var.J();
                iArr4[i13] = c0Var.H();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f30727a - ((int) (j12 - bVar.f30728b));
        }
        e0.a aVar2 = (e0.a) a4.o0.j(bVar.f30729c);
        cVar.c(i11, iArr2, iArr4, aVar2.f32465b, cVar.f31561a, aVar2.f32464a, aVar2.f32466c, aVar2.f32467d);
        long j13 = bVar.f30728b;
        int i14 = (int) (j12 - j13);
        bVar.f30728b = j13 + ((long) i14);
        bVar.f30727a -= i14;
        return aVarI2;
    }

    private static a k(a aVar, n2.g gVar, t0.b bVar, a4.c0 c0Var) {
        if (gVar.o()) {
            aVar = j(aVar, gVar, bVar, c0Var);
        }
        if (!gVar.f()) {
            gVar.m(bVar.f30727a);
            return h(aVar, bVar.f30728b, gVar.f31586c, bVar.f30727a);
        }
        c0Var.L(4);
        a aVarI = i(aVar, bVar.f30728b, c0Var.d(), 4);
        int iH = c0Var.H();
        bVar.f30728b += 4;
        bVar.f30727a -= 4;
        gVar.m(iH);
        a aVarH = h(aVarI, bVar.f30728b, gVar.f31586c, iH);
        bVar.f30728b += (long) iH;
        int i10 = bVar.f30727a - iH;
        bVar.f30727a = i10;
        gVar.q(i10);
        return h(aVarH, bVar.f30728b, gVar.f31589f, bVar.f30727a);
    }

    public void b(long j10) {
        a aVar;
        if (j10 == -1) {
            return;
        }
        while (true) {
            aVar = this.f30680d;
            if (j10 < aVar.f30685b) {
                break;
            }
            this.f30677a.a(aVar.f30686c);
            this.f30680d = this.f30680d.a();
        }
        if (this.f30681e.f30684a < aVar.f30684a) {
            this.f30681e = aVar;
        }
    }

    public long d() {
        return this.f30683g;
    }

    public void e(n2.g gVar, t0.b bVar) {
        k(this.f30681e, gVar, bVar, this.f30679c);
    }

    public void l(n2.g gVar, t0.b bVar) {
        this.f30681e = k(this.f30681e, gVar, bVar, this.f30679c);
    }

    public void m() {
        a(this.f30680d);
        this.f30680d.c(0L, this.f30678b);
        a aVar = this.f30680d;
        this.f30681e = aVar;
        this.f30682f = aVar;
        this.f30683g = 0L;
        this.f30677a.trim();
    }

    public void n() {
        this.f30681e = this.f30680d;
    }

    public int o(z3.h hVar, int i10, boolean z10) throws IOException {
        int iG = g(i10);
        a aVar = this.f30682f;
        int i11 = hVar.read(aVar.f30686c.f37362a, aVar.d(this.f30683g), iG);
        if (i11 != -1) {
            f(i11);
            return i11;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    public void p(a4.c0 c0Var, int i10) {
        while (i10 > 0) {
            int iG = g(i10);
            a aVar = this.f30682f;
            c0Var.j(aVar.f30686c.f37362a, aVar.d(this.f30683g), iG);
            i10 -= iG;
            f(iG);
        }
    }
}
