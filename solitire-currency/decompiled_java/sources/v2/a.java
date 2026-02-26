package v2;

import java.io.IOException;
import java.util.ArrayDeque;
import k2.j2;
import p2.m;

/* JADX INFO: compiled from: DefaultEbmlReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f35026a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque<b> f35027b = new ArrayDeque<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f35028c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v2.b f35029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f35030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f35031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f35032g;

    /* JADX INFO: compiled from: DefaultEbmlReader.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f35034b;

        private b(int i10, long j10) {
            this.f35033a = i10;
            this.f35034b = j10;
        }
    }

    private long c(m mVar) throws IOException {
        mVar.resetPeekPosition();
        while (true) {
            mVar.peekFully(this.f35026a, 0, 4);
            int iC = g.c(this.f35026a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) g.a(this.f35026a, iC, false);
                if (this.f35029d.isLevel1Element(iA)) {
                    mVar.skipFully(iC);
                    return iA;
                }
            }
            mVar.skipFully(1);
        }
    }

    private double d(m mVar, int i10) throws IOException {
        return i10 == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(mVar, i10));
    }

    private long e(m mVar, int i10) throws IOException {
        mVar.readFully(this.f35026a, 0, i10);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = (j10 << 8) | ((long) (this.f35026a[i11] & 255));
        }
        return j10;
    }

    private static String f(m mVar, int i10) throws IOException {
        if (i10 == 0) {
            return "";
        }
        byte[] bArr = new byte[i10];
        mVar.readFully(bArr, 0, i10);
        while (i10 > 0 && bArr[i10 - 1] == 0) {
            i10--;
        }
        return new String(bArr, 0, i10);
    }

    @Override // v2.c
    public boolean a(m mVar) throws IOException {
        a4.a.i(this.f35029d);
        while (true) {
            b bVarPeek = this.f35027b.peek();
            if (bVarPeek != null && mVar.getPosition() >= bVarPeek.f35034b) {
                this.f35029d.endMasterElement(this.f35027b.pop().f35033a);
                return true;
            }
            if (this.f35030e == 0) {
                long jD = this.f35028c.d(mVar, true, false, 4);
                if (jD == -2) {
                    jD = c(mVar);
                }
                if (jD == -1) {
                    return false;
                }
                this.f35031f = (int) jD;
                this.f35030e = 1;
            }
            if (this.f35030e == 1) {
                this.f35032g = this.f35028c.d(mVar, false, true, 8);
                this.f35030e = 2;
            }
            int elementType = this.f35029d.getElementType(this.f35031f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = mVar.getPosition();
                    this.f35027b.push(new b(this.f35031f, this.f35032g + position));
                    this.f35029d.startMasterElement(this.f35031f, position, this.f35032g);
                    this.f35030e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j10 = this.f35032g;
                    if (j10 <= 8) {
                        this.f35029d.integerElement(this.f35031f, e(mVar, (int) j10));
                        this.f35030e = 0;
                        return true;
                    }
                    throw j2.a("Invalid integer size: " + this.f35032g, null);
                }
                if (elementType == 3) {
                    long j11 = this.f35032g;
                    if (j11 <= 2147483647L) {
                        this.f35029d.stringElement(this.f35031f, f(mVar, (int) j11));
                        this.f35030e = 0;
                        return true;
                    }
                    throw j2.a("String element size: " + this.f35032g, null);
                }
                if (elementType == 4) {
                    this.f35029d.a(this.f35031f, (int) this.f35032g, mVar);
                    this.f35030e = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw j2.a("Invalid element type " + elementType, null);
                }
                long j12 = this.f35032g;
                if (j12 == 4 || j12 == 8) {
                    this.f35029d.floatElement(this.f35031f, d(mVar, (int) j12));
                    this.f35030e = 0;
                    return true;
                }
                throw j2.a("Invalid float size: " + this.f35032g, null);
            }
            mVar.skipFully((int) this.f35032g);
            this.f35030e = 0;
        }
    }

    @Override // v2.c
    public void b(v2.b bVar) {
        this.f35029d = bVar;
    }

    @Override // v2.c
    public void reset() {
        this.f35030e = 0;
        this.f35027b.clear();
        this.f35028c.e();
    }
}
