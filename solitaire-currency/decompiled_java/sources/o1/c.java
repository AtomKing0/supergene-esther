package o1;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ContentLengthInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f31791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31792b;

    private c(@NonNull InputStream inputStream, long j10) {
        super(inputStream);
        this.f31791a = j10;
    }

    private int a(int i10) throws IOException {
        if (i10 >= 0) {
            this.f31792b += i10;
        } else if (this.f31791a - ((long) this.f31792b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f31791a + ", but read: " + this.f31792b);
        }
        return i10;
    }

    @NonNull
    public static InputStream c(@NonNull InputStream inputStream, long j10) {
        return new c(inputStream, j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f31791a - ((long) this.f31792b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i10;
        i10 = super.read();
        a(i10 >= 0 ? 1 : -1);
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        return a(super.read(bArr, i10, i11));
    }
}
