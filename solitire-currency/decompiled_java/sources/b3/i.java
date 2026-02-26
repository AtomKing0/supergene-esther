package b3;

import java.nio.ByteBuffer;
import k2.o1;
import m2.h0;

/* JADX INFO: compiled from: C2Mp3TimestampTracker.java */
/* JADX INFO: loaded from: classes2.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1984c;

    i() {
    }

    private long a(long j10) {
        return this.f1982a + Math.max(0L, ((this.f1983b - 529) * 1000000) / j10);
    }

    public long b(o1 o1Var) {
        return a(o1Var.f29361z);
    }

    public void c() {
        this.f1982a = 0L;
        this.f1983b = 0L;
        this.f1984c = false;
    }

    public long d(o1 o1Var, n2.g gVar) {
        if (this.f1983b == 0) {
            this.f1982a = gVar.f31588e;
        }
        if (this.f1984c) {
            return gVar.f31588e;
        }
        ByteBuffer byteBuffer = (ByteBuffer) a4.a.e(gVar.f31586c);
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            i10 = (i10 << 8) | (byteBuffer.get(i11) & 255);
        }
        int iM = h0.m(i10);
        if (iM != -1) {
            long jA = a(o1Var.f29361z);
            this.f1983b += (long) iM;
            return jA;
        }
        this.f1984c = true;
        this.f1983b = 0L;
        this.f1982a = gVar.f31588e;
        a4.t.i("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
        return gVar.f31588e;
    }
}
