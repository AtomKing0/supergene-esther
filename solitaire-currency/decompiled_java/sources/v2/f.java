package v2;

import a4.c0;
import java.io.IOException;
import p2.m;

/* JADX INFO: compiled from: Sniffer.java */
/* JADX INFO: loaded from: classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f35097a = new c0(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f35098b;

    private long a(m mVar) throws IOException {
        int i10 = 0;
        mVar.peekFully(this.f35097a.d(), 0, 1);
        int i11 = this.f35097a.d()[0] & 255;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((i11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = i11 & (~i12);
        mVar.peekFully(this.f35097a.d(), 1, i13);
        while (i10 < i13) {
            i10++;
            i14 = (this.f35097a.d()[i10] & 255) + (i14 << 8);
        }
        this.f35098b += i13 + 1;
        return i14;
    }

    public boolean b(m mVar) throws IOException {
        long length = mVar.getLength();
        long j10 = 1024;
        if (length != -1 && length <= 1024) {
            j10 = length;
        }
        int i10 = (int) j10;
        mVar.peekFully(this.f35097a.d(), 0, 4);
        long jF = this.f35097a.F();
        this.f35098b = 4;
        while (jF != 440786851) {
            int i11 = this.f35098b + 1;
            this.f35098b = i11;
            if (i11 == i10) {
                return false;
            }
            mVar.peekFully(this.f35097a.d(), 0, 1);
            jF = ((jF << 8) & (-256)) | ((long) (this.f35097a.d()[0] & 255));
        }
        long jA = a(mVar);
        long j11 = this.f35098b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j11 + jA >= length) {
            return false;
        }
        while (true) {
            int i12 = this.f35098b;
            long j12 = j11 + jA;
            if (i12 >= j12) {
                return ((long) i12) == j12;
            }
            if (a(mVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(mVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                break;
            }
            if (jA2 != 0) {
                int i13 = (int) jA2;
                mVar.advancePeekPosition(i13);
                this.f35098b += i13;
            }
        }
        return false;
    }
}
