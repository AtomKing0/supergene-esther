package b3;

import androidx.annotation.IntRange;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: BatchBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
final class h extends n2.g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1981k;

    public h() {
        super(2);
        this.f1981k = 32;
    }

    private boolean s(n2.g gVar) {
        ByteBuffer byteBuffer;
        if (!w()) {
            return true;
        }
        if (this.f1980j >= this.f1981k || gVar.g() != g()) {
            return false;
        }
        ByteBuffer byteBuffer2 = gVar.f31586c;
        return byteBuffer2 == null || (byteBuffer = this.f31586c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    @Override // n2.g, n2.a
    public void c() {
        super.c();
        this.f1980j = 0;
    }

    public boolean r(n2.g gVar) {
        a4.a.a(!gVar.o());
        a4.a.a(!gVar.f());
        a4.a.a(!gVar.h());
        if (!s(gVar)) {
            return false;
        }
        int i10 = this.f1980j;
        this.f1980j = i10 + 1;
        if (i10 == 0) {
            this.f31588e = gVar.f31588e;
            if (gVar.j()) {
                k(1);
            }
        }
        if (gVar.g()) {
            k(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = gVar.f31586c;
        if (byteBuffer != null) {
            m(byteBuffer.remaining());
            this.f31586c.put(byteBuffer);
        }
        this.f1979i = gVar.f31588e;
        return true;
    }

    public long t() {
        return this.f31588e;
    }

    public long u() {
        return this.f1979i;
    }

    public int v() {
        return this.f1980j;
    }

    public boolean w() {
        return this.f1980j > 0;
    }

    public void x(@IntRange(from = 1) int i10) {
        a4.a.a(i10 > 0);
        this.f1981k = i10;
    }
}
