package b1;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public class y extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile byte[] f1888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final v0.b f1893f;

    /* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    public y(@NonNull InputStream inputStream, @NonNull v0.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i10 = this.f1891d;
        if (i10 != -1) {
            int i11 = this.f1892e - i10;
            int i12 = this.f1890c;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f1889b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f1893f.c(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f1888a = bArr2;
                    this.f1893f.put(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f1892e - this.f1891d;
                this.f1892e = i13;
                this.f1891d = 0;
                this.f1889b = 0;
                int i14 = inputStream.read(bArr, i13, bArr.length - i13);
                int i15 = this.f1892e;
                if (i14 > 0) {
                    i15 += i14;
                }
                this.f1889b = i15;
                return i14;
            }
        }
        int i16 = inputStream.read(bArr);
        if (i16 > 0) {
            this.f1891d = -1;
            this.f1892e = 0;
            this.f1889b = i16;
        }
        return i16;
    }

    private static IOException i() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f1888a == null || inputStream == null) {
            throw i();
        }
        return (this.f1889b - this.f1892e) + inputStream.available();
    }

    public synchronized void c() {
        this.f1890c = this.f1888a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1888a != null) {
            this.f1893f.put(this.f1888a);
            this.f1888a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.f1890c = Math.max(this.f1890c, i10);
        this.f1891d = this.f1892e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f1888a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw i();
        }
        if (this.f1892e >= this.f1889b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f1888a && (bArr = this.f1888a) == null) {
            throw i();
        }
        int i10 = this.f1889b;
        int i11 = this.f1892e;
        if (i10 - i11 <= 0) {
            return -1;
        }
        this.f1892e = i11 + 1;
        return bArr[i11] & 255;
    }

    public synchronized void release() {
        if (this.f1888a != null) {
            this.f1893f.put(this.f1888a);
            this.f1888a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f1888a == null) {
            throw new IOException("Stream is closed");
        }
        int i10 = this.f1891d;
        if (-1 == i10) {
            throw new a("Mark has been invalidated, pos: " + this.f1892e + " markLimit: " + this.f1890c);
        }
        this.f1892e = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) throws IOException {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f1888a;
        if (bArr == null) {
            throw i();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw i();
        }
        int i10 = this.f1889b;
        int i11 = this.f1892e;
        if (i10 - i11 >= j10) {
            this.f1892e = (int) (((long) i11) + j10);
            return j10;
        }
        long j11 = ((long) i10) - ((long) i11);
        this.f1892e = i10;
        if (this.f1891d == -1 || j10 > this.f1890c) {
            return j11 + inputStream.skip(j10 - j11);
        }
        if (a(inputStream, bArr) == -1) {
            return j11;
        }
        int i12 = this.f1889b;
        int i13 = this.f1892e;
        if (i12 - i13 >= j10 - j11) {
            this.f1892e = (int) ((((long) i13) + j10) - j11);
            return j10;
        }
        long j12 = (j11 + ((long) i12)) - ((long) i13);
        this.f1892e = i12;
        return j12;
    }

    @VisibleForTesting
    y(@NonNull InputStream inputStream, @NonNull v0.b bVar, int i10) {
        super(inputStream);
        this.f1891d = -1;
        this.f1893f = bVar;
        this.f1888a = (byte[]) bVar.c(i10, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13;
        byte[] bArr2 = this.f1888a;
        if (bArr2 == null) {
            throw i();
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i14 = this.f1892e;
            int i15 = this.f1889b;
            if (i14 < i15) {
                int i16 = i15 - i14 >= i11 ? i11 : i15 - i14;
                System.arraycopy(bArr2, i14, bArr, i10, i16);
                this.f1892e += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.f1891d == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.f1888a && (bArr2 = this.f1888a) == null) {
                        throw i();
                    }
                    int i17 = this.f1889b;
                    int i18 = this.f1892e;
                    i13 = i17 - i18 >= i12 ? i12 : i17 - i18;
                    System.arraycopy(bArr2, i18, bArr, i10, i13);
                    this.f1892e += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            throw i();
        }
    }
}
