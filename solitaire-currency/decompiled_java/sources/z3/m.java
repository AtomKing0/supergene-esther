package z3;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DataSourceInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f37448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f37449b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f37453f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37451d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37452e = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f37450c = new byte[1];

    public m(k kVar, o oVar) {
        this.f37448a = kVar;
        this.f37449b = oVar;
    }

    private void a() throws IOException {
        if (this.f37451d) {
            return;
        }
        this.f37448a.a(this.f37449b);
        this.f37451d = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f37452e) {
            return;
        }
        this.f37448a.close();
        this.f37452e = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f37450c) == -1) {
            return -1;
        }
        return this.f37450c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        a4.a.g(!this.f37452e);
        a();
        int i12 = this.f37448a.read(bArr, i10, i11);
        if (i12 == -1) {
            return -1;
        }
        this.f37453f += (long) i12;
        return i12;
    }
}
