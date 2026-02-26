package s0;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ExifOrientationStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f33450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f33451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f33452e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f33453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f33454b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f33450c = bArr;
        int length = bArr.length;
        f33451d = length;
        f33452e = length + 2;
    }

    public g(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 >= -1 && i10 <= 8) {
            this.f33453a = (byte) i10;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10;
        int i11 = this.f33454b;
        int i12 = (i11 < 2 || i11 > (i10 = f33452e)) ? super.read() : i11 == i10 ? this.f33453a : f33450c[i11 - 2] & 255;
        if (i12 != -1) {
            this.f33454b++;
        }
        return i12;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long jSkip = super.skip(j10);
        if (jSkip > 0) {
            this.f33454b = (int) (((long) this.f33454b) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f33454b;
        int i14 = f33452e;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.f33453a;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int iMin = Math.min(i14 - i13, i11);
            System.arraycopy(f33450c, this.f33454b - 2, bArr, i10, iMin);
            i12 = iMin;
        }
        if (i12 > 0) {
            this.f33454b += i12;
        }
        return i12;
    }
}
