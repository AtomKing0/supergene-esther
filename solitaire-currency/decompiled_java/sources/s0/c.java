package s0;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: BufferedOutputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final OutputStream f33443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f33444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private v0.b f33445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33446d;

    public c(@NonNull OutputStream outputStream, @NonNull v0.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws IOException {
        int i10 = this.f33446d;
        if (i10 > 0) {
            this.f33443a.write(this.f33444b, 0, i10);
            this.f33446d = 0;
        }
    }

    private void c() throws IOException {
        if (this.f33446d == this.f33444b.length) {
            a();
        }
    }

    private void release() {
        byte[] bArr = this.f33444b;
        if (bArr != null) {
            this.f33445c.put(bArr);
            this.f33444b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f33443a.close();
            release();
        } catch (Throwable th) {
            this.f33443a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f33443a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f33444b;
        int i11 = this.f33446d;
        this.f33446d = i11 + 1;
        bArr[i11] = (byte) i10;
        c();
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, v0.b bVar, int i10) {
        this.f33443a = outputStream;
        this.f33445c = bVar;
        this.f33444b = (byte[]) bVar.c(i10, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f33446d;
            if (i15 == 0 && i13 >= this.f33444b.length) {
                this.f33443a.write(bArr, i14, i13);
                return;
            }
            int iMin = Math.min(i13, this.f33444b.length - i15);
            System.arraycopy(bArr, i14, this.f33444b, this.f33446d, iMin);
            this.f33446d += iMin;
            i12 += iMin;
            c();
        } while (i12 < i11);
    }
}
