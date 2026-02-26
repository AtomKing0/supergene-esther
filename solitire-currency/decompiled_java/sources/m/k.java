package m;

import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExifUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
final class k extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final InputStream f31109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31110b = 1073741824;

    public k(@NotNull InputStream inputStream) {
        this.f31109a = inputStream;
    }

    private final int a(int i10) {
        if (i10 == -1) {
            this.f31110b = 0;
        }
        return i10;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f31110b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f31109a.close();
    }

    @Override // java.io.InputStream
    public int read() {
        return a(this.f31109a.read());
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        return this.f31109a.skip(j10);
    }

    @Override // java.io.InputStream
    public int read(@NotNull byte[] bArr) {
        return a(this.f31109a.read(bArr));
    }

    @Override // java.io.InputStream
    public int read(@NotNull byte[] bArr, int i10, int i11) {
        return a(this.f31109a.read(bArr, i10, i11));
    }
}
