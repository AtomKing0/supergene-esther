package y2;

import a4.c0;
import java.io.IOException;
import k2.j2;
import p2.m;
import p2.o;

/* JADX INFO: compiled from: OggPageHeader.java */
/* JADX INFO: loaded from: classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f36464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f36465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f36466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f36467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f36471j = new int[255];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final c0 f36472k = new c0(255);

    f() {
    }

    public boolean a(m mVar, boolean z10) throws IOException {
        b();
        this.f36472k.L(27);
        if (!o.b(mVar, this.f36472k.d(), 0, 27, z10) || this.f36472k.F() != 1332176723) {
            return false;
        }
        int iD = this.f36472k.D();
        this.f36462a = iD;
        if (iD != 0) {
            if (z10) {
                return false;
            }
            throw j2.c("unsupported bit stream revision");
        }
        this.f36463b = this.f36472k.D();
        this.f36464c = this.f36472k.r();
        this.f36465d = this.f36472k.t();
        this.f36466e = this.f36472k.t();
        this.f36467f = this.f36472k.t();
        int iD2 = this.f36472k.D();
        this.f36468g = iD2;
        this.f36469h = iD2 + 27;
        this.f36472k.L(iD2);
        if (!o.b(mVar, this.f36472k.d(), 0, this.f36468g, z10)) {
            return false;
        }
        for (int i10 = 0; i10 < this.f36468g; i10++) {
            this.f36471j[i10] = this.f36472k.D();
            this.f36470i += this.f36471j[i10];
        }
        return true;
    }

    public void b() {
        this.f36462a = 0;
        this.f36463b = 0;
        this.f36464c = 0L;
        this.f36465d = 0L;
        this.f36466e = 0L;
        this.f36467f = 0L;
        this.f36468g = 0;
        this.f36469h = 0;
        this.f36470i = 0;
    }

    public boolean c(m mVar) throws IOException {
        return d(mVar, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.skip(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(p2.m r9, long r10) throws java.io.IOException {
        /*
            r8 = this;
            long r0 = r9.getPosition()
            long r2 = r9.getPeekPosition()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            a4.a.a(r0)
            a4.c0 r0 = r8.f36472k
            r3 = 4
            r0.L(r3)
        L1a:
            r4 = -1
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L2b
            long r4 = r9.getPosition()
            r6 = 4
            long r4 = r4 + r6
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 >= 0) goto L51
        L2b:
            a4.c0 r4 = r8.f36472k
            byte[] r4 = r4.d()
            boolean r4 = p2.o.b(r9, r4, r1, r3, r2)
            if (r4 == 0) goto L51
            a4.c0 r0 = r8.f36472k
            r0.P(r1)
            a4.c0 r0 = r8.f36472k
            long r4 = r0.F()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L4d
            r9.resetPeekPosition()
            return r2
        L4d:
            r9.skipFully(r2)
            goto L1a
        L51:
            if (r0 == 0) goto L5b
            long r3 = r9.getPosition()
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 >= 0) goto L63
        L5b:
            int r3 = r9.skip(r2)
            r4 = -1
            if (r3 == r4) goto L63
            goto L51
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.f.d(p2.m, long):boolean");
    }
}
