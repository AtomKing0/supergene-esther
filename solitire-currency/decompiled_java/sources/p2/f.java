package p2;

import a4.o0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import k2.l1;

/* JADX INFO: compiled from: DefaultExtractorInput.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z3.h f32469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f32470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f32471d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32474g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f32472e = new byte[65536];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f32468a = new byte[4096];

    static {
        l1.a("goog.exo.extractor");
    }

    public f(z3.h hVar, long j10, long j11) {
        this.f32469b = hVar;
        this.f32471d = j10;
        this.f32470c = j11;
    }

    private void c(int i10) {
        if (i10 != -1) {
            this.f32471d += (long) i10;
        }
    }

    private void d(int i10) {
        int i11 = this.f32473f + i10;
        byte[] bArr = this.f32472e;
        if (i11 > bArr.length) {
            this.f32472e = Arrays.copyOf(this.f32472e, o0.p(bArr.length * 2, 65536 + i11, i11 + 524288));
        }
    }

    private int e(byte[] bArr, int i10, int i11) {
        int i12 = this.f32474g;
        if (i12 == 0) {
            return 0;
        }
        int iMin = Math.min(i12, i11);
        System.arraycopy(this.f32472e, 0, bArr, i10, iMin);
        i(iMin);
        return iMin;
    }

    private int f(byte[] bArr, int i10, int i11, int i12, boolean z10) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i13 = this.f32469b.read(bArr, i10 + i12, i11 - i12);
        if (i13 != -1) {
            return i12 + i13;
        }
        if (i12 == 0 && z10) {
            return -1;
        }
        throw new EOFException();
    }

    private int g(int i10) {
        int iMin = Math.min(this.f32474g, i10);
        i(iMin);
        return iMin;
    }

    private void i(int i10) {
        int i11 = this.f32474g - i10;
        this.f32474g = i11;
        this.f32473f = 0;
        byte[] bArr = this.f32472e;
        byte[] bArr2 = i11 < bArr.length - 524288 ? new byte[65536 + i11] : bArr;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        this.f32472e = bArr2;
    }

    @Override // p2.m
    public boolean advancePeekPosition(int i10, boolean z10) throws IOException {
        d(i10);
        int iF = this.f32474g - this.f32473f;
        while (iF < i10) {
            iF = f(this.f32472e, this.f32473f, i10, iF, z10);
            if (iF == -1) {
                return false;
            }
            this.f32474g = this.f32473f + iF;
        }
        this.f32473f += i10;
        return true;
    }

    @Override // p2.m
    public long getLength() {
        return this.f32470c;
    }

    @Override // p2.m
    public long getPeekPosition() {
        return this.f32471d + ((long) this.f32473f);
    }

    @Override // p2.m
    public long getPosition() {
        return this.f32471d;
    }

    public boolean h(int i10, boolean z10) throws IOException {
        int iG = g(i10);
        while (iG < i10 && iG != -1) {
            iG = f(this.f32468a, -iG, Math.min(i10, this.f32468a.length + iG), iG, z10);
        }
        c(iG);
        return iG != -1;
    }

    @Override // p2.m
    public int peek(byte[] bArr, int i10, int i11) throws IOException {
        int iMin;
        d(i11);
        int i12 = this.f32474g;
        int i13 = this.f32473f;
        int i14 = i12 - i13;
        if (i14 == 0) {
            iMin = f(this.f32472e, i13, i11, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.f32474g += iMin;
        } else {
            iMin = Math.min(i11, i14);
        }
        System.arraycopy(this.f32472e, this.f32473f, bArr, i10, iMin);
        this.f32473f += iMin;
        return iMin;
    }

    @Override // p2.m
    public boolean peekFully(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        if (!advancePeekPosition(i11, z10)) {
            return false;
        }
        System.arraycopy(this.f32472e, this.f32473f - i11, bArr, i10, i11);
        return true;
    }

    @Override // p2.m, z3.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int iE = e(bArr, i10, i11);
        if (iE == 0) {
            iE = f(bArr, i10, i11, 0, true);
        }
        c(iE);
        return iE;
    }

    @Override // p2.m
    public boolean readFully(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        int iE = e(bArr, i10, i11);
        while (iE < i11 && iE != -1) {
            iE = f(bArr, i10, i11, iE, z10);
        }
        c(iE);
        return iE != -1;
    }

    @Override // p2.m
    public void resetPeekPosition() {
        this.f32473f = 0;
    }

    @Override // p2.m
    public int skip(int i10) throws IOException {
        int iG = g(i10);
        if (iG == 0) {
            byte[] bArr = this.f32468a;
            iG = f(bArr, 0, Math.min(i10, bArr.length), 0, true);
        }
        c(iG);
        return iG;
    }

    @Override // p2.m
    public void skipFully(int i10) throws IOException {
        h(i10, false);
    }

    @Override // p2.m
    public void peekFully(byte[] bArr, int i10, int i11) throws IOException {
        peekFully(bArr, i10, i11, false);
    }

    @Override // p2.m
    public void readFully(byte[] bArr, int i10, int i11) throws IOException {
        readFully(bArr, i10, i11, false);
    }

    @Override // p2.m
    public void advancePeekPosition(int i10) throws IOException {
        advancePeekPosition(i10, false);
    }
}
