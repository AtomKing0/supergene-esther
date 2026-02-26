package p0;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: StrictLineReader.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f32407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f32408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f32409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32411e;

    /* JADX INFO: compiled from: StrictLineReader.java */
    class a extends ByteArrayOutputStream {
        a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, c.this.f32408b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f32407a;
        byte[] bArr = this.f32409c;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 == -1) {
            throw new EOFException();
        }
        this.f32410d = 0;
        this.f32411e = i10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f32407a) {
            if (this.f32409c != null) {
                this.f32409c = null;
                this.f32407a.close();
            }
        }
    }

    public boolean i() {
        return this.f32411e == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String n() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f32407a
            monitor-enter(r0)
            byte[] r1 = r7.f32409c     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L7f
            int r1 = r7.f32410d     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f32411e     // Catch: java.lang.Throwable -> L87
            if (r1 < r2) goto L10
            r7.c()     // Catch: java.lang.Throwable -> L87
        L10:
            int r1 = r7.f32410d     // Catch: java.lang.Throwable -> L87
        L12:
            int r2 = r7.f32411e     // Catch: java.lang.Throwable -> L87
            r3 = 10
            if (r1 == r2) goto L41
            byte[] r2 = r7.f32409c     // Catch: java.lang.Throwable -> L87
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L87
            if (r4 != r3) goto L3e
            int r3 = r7.f32410d     // Catch: java.lang.Throwable -> L87
            if (r1 == r3) goto L2b
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L87
            r6 = 13
            if (r5 != r6) goto L2b
            goto L2c
        L2b:
            r4 = r1
        L2c:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L87
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.f32408b     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L87
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L87
            int r1 = r1 + 1
            r7.f32410d = r1     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return r5
        L3e:
            int r1 = r1 + 1
            goto L12
        L41:
            p0.c$a r1 = new p0.c$a     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f32411e     // Catch: java.lang.Throwable -> L87
            int r4 = r7.f32410d     // Catch: java.lang.Throwable -> L87
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
        L4d:
            byte[] r2 = r7.f32409c     // Catch: java.lang.Throwable -> L87
            int r4 = r7.f32410d     // Catch: java.lang.Throwable -> L87
            int r5 = r7.f32411e     // Catch: java.lang.Throwable -> L87
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L87
            r2 = -1
            r7.f32411e = r2     // Catch: java.lang.Throwable -> L87
            r7.c()     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f32410d     // Catch: java.lang.Throwable -> L87
        L5f:
            int r4 = r7.f32411e     // Catch: java.lang.Throwable -> L87
            if (r2 == r4) goto L4d
            byte[] r4 = r7.f32409c     // Catch: java.lang.Throwable -> L87
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L87
            if (r5 != r3) goto L7c
            int r3 = r7.f32410d     // Catch: java.lang.Throwable -> L87
            if (r2 == r3) goto L72
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L87
        L72:
            int r2 = r2 + 1
            r7.f32410d = r2     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return r1
        L7c:
            int r2 = r2 + 1
            goto L5f
        L7f:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
            throw r1     // Catch: java.lang.Throwable -> L87
        L87:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.c.n():java.lang.String");
    }

    public c(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(d.f32413a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f32407a = inputStream;
        this.f32408b = charset;
        this.f32409c = new byte[i10];
    }
}
