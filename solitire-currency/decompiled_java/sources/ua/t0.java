package ua;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t0 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final z0 f34821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final c f34822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f34823c;

    public t0(@NotNull z0 source) {
        kotlin.jvm.internal.t.i(source, "source");
        this.f34821a = source;
        this.f34822b = new c();
    }

    @Override // ua.e
    public long E0() throws EOFException {
        byte bL;
        a0(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!K(i11)) {
                break;
            }
            bL = this.f34822b.L(i10);
            if ((bL < ((byte) 48) || bL > ((byte) 57)) && ((bL < ((byte) 97) || bL > ((byte) 102)) && (bL < ((byte) 65) || bL > ((byte) 70)))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bL, p9.b.a(p9.b.a(16)));
            kotlin.jvm.internal.t.h(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.f34822b.E0();
    }

    @Override // ua.e
    @NotNull
    public InputStream F0() {
        return new a();
    }

    @Override // ua.e
    public boolean K(long j10) {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (!(!this.f34823c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f34822b.size() < j10) {
            if (this.f34821a.read(this.f34822b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // ua.e
    @NotNull
    public String N() {
        return y(Long.MAX_VALUE);
    }

    @Override // ua.e
    @NotNull
    public byte[] P(long j10) throws EOFException {
        a0(j10);
        return this.f34822b.P(j10);
    }

    @Override // ua.e
    public short T() throws EOFException {
        a0(2L);
        return this.f34822b.T();
    }

    @Override // ua.e
    public long U() throws EOFException {
        a0(8L);
        return this.f34822b.U();
    }

    @Override // ua.e
    public long V(@NotNull x0 sink) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        long j10 = 0;
        while (this.f34821a.read(this.f34822b, 8192L) != -1) {
            long jQ = this.f34822b.q();
            if (jQ > 0) {
                j10 += jQ;
                sink.G(this.f34822b, jQ);
            }
        }
        if (this.f34822b.size() <= 0) {
            return j10;
        }
        long size = j10 + this.f34822b.size();
        c cVar = this.f34822b;
        sink.G(cVar, cVar.size());
        return size;
    }

    @Override // ua.e
    public int X(@NotNull n0 options) throws EOFException {
        kotlin.jvm.internal.t.i(options, "options");
        if (!(!this.f34823c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int iC = va.f.c(this.f34822b, options, true);
            if (iC != -2) {
                if (iC != -1) {
                    this.f34822b.skip(options.e()[iC].B());
                    return iC;
                }
            } else if (this.f34821a.read(this.f34822b, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    public long a(byte b10) {
        return c(b10, 0L, Long.MAX_VALUE);
    }

    @Override // ua.e
    public void a0(long j10) throws EOFException {
        if (!K(j10)) {
            throw new EOFException();
        }
    }

    public long c(byte b10, long j10, long j11) {
        if (!(!this.f34823c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j10 && j10 <= j11)) {
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        while (j10 < j11) {
            long jO = this.f34822b.O(b10, j10, j11);
            if (jO != -1) {
                return jO;
            }
            long size = this.f34822b.size();
            if (size >= j11 || this.f34821a.read(this.f34822b, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, size);
        }
        return -1L;
    }

    @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f34823c) {
            return;
        }
        this.f34823c = true;
        this.f34821a.close();
        this.f34822b.c();
    }

    @Override // ua.e
    @NotNull
    public String d0(long j10) throws EOFException {
        a0(j10);
        return this.f34822b.d0(j10);
    }

    @Override // ua.e
    @NotNull
    public f f0(long j10) throws EOFException {
        a0(j10);
        return this.f34822b.f0(j10);
    }

    @Override // ua.e, ua.d
    @NotNull
    public c g() {
        return this.f34822b;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f34823c;
    }

    @Override // ua.e
    @NotNull
    public byte[] l0() throws IOException {
        this.f34822b.s(this.f34821a);
        return this.f34822b.l0();
    }

    @Override // ua.e
    public boolean m0() {
        if (!this.f34823c) {
            return this.f34822b.m0() && this.f34821a.read(this.f34822b, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // ua.e
    public long p0() throws EOFException {
        byte bL;
        a0(1L);
        long j10 = 0;
        while (true) {
            long j11 = j10 + 1;
            if (!K(j11)) {
                break;
            }
            bL = this.f34822b.L(j10);
            if ((bL < ((byte) 48) || bL > ((byte) 57)) && !(j10 == 0 && bL == ((byte) 45))) {
                break;
            }
            j10 = j11;
        }
        if (j10 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a digit or '-' but was 0x");
            String string = Integer.toString(bL, p9.b.a(p9.b.a(16)));
            kotlin.jvm.internal.t.h(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.f34822b.p0();
    }

    @Override // ua.e
    @NotNull
    public e peek() {
        return k0.d(new r0(this));
    }

    @Override // ua.z0
    public long read(@NotNull c sink, long j10) {
        kotlin.jvm.internal.t.i(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (!(!this.f34823c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f34822b.size() == 0 && this.f34821a.read(this.f34822b, 8192L) == -1) {
            return -1L;
        }
        return this.f34822b.read(sink, Math.min(j10, this.f34822b.size()));
    }

    @Override // ua.e
    public byte readByte() throws EOFException {
        a0(1L);
        return this.f34822b.readByte();
    }

    @Override // ua.e
    public int readInt() throws EOFException {
        a0(4L);
        return this.f34822b.readInt();
    }

    @Override // ua.e
    public short readShort() throws EOFException {
        a0(2L);
        return this.f34822b.readShort();
    }

    @Override // ua.e
    @NotNull
    public String s0(@NotNull Charset charset) throws IOException {
        kotlin.jvm.internal.t.i(charset, "charset");
        this.f34822b.s(this.f34821a);
        return this.f34822b.s0(charset);
    }

    @Override // ua.e
    public void skip(long j10) throws EOFException {
        if (!(!this.f34823c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j10 > 0) {
            if (this.f34822b.size() == 0 && this.f34821a.read(this.f34822b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f34822b.size());
            this.f34822b.skip(jMin);
            j10 -= jMin;
        }
    }

    @Override // ua.z0
    @NotNull
    public a1 timeout() {
        return this.f34821a.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.f34821a + ')';
    }

    @Override // ua.e
    @NotNull
    public f w0() throws IOException {
        this.f34822b.s(this.f34821a);
        return this.f34822b.w0();
    }

    @Override // ua.e
    @NotNull
    public String y(long j10) throws EOFException {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j10).toString());
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        byte b10 = (byte) 10;
        long jC = c(b10, 0L, j11);
        if (jC != -1) {
            return va.f.b(this.f34822b, jC);
        }
        if (j11 < Long.MAX_VALUE && K(j11) && this.f34822b.L(j11 - 1) == ((byte) 13) && K(1 + j11) && this.f34822b.L(j11) == b10) {
            return va.f.b(this.f34822b, j11);
        }
        c cVar = new c();
        c cVar2 = this.f34822b;
        cVar2.z(cVar, 0L, Math.min(32, cVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f34822b.size(), j10) + " content=" + cVar.w0().k() + (char) 8230);
    }

    @Override // ua.e
    public int y0() throws EOFException {
        a0(4L);
        return this.f34822b.y0();
    }

    /* JADX INFO: compiled from: RealBufferedSource.kt */
    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            t0 t0Var = t0.this;
            if (t0Var.f34823c) {
                throw new IOException("closed");
            }
            return (int) Math.min(t0Var.f34822b.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            t0.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            t0 t0Var = t0.this;
            if (t0Var.f34823c) {
                throw new IOException("closed");
            }
            if (t0Var.f34822b.size() == 0) {
                t0 t0Var2 = t0.this;
                if (t0Var2.f34821a.read(t0Var2.f34822b, 8192L) == -1) {
                    return -1;
                }
            }
            return t0.this.f34822b.readByte() & 255;
        }

        @NotNull
        public String toString() {
            return t0.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(@NotNull byte[] data, int i10, int i11) throws IOException {
            kotlin.jvm.internal.t.i(data, "data");
            if (!t0.this.f34823c) {
                f1.b(data.length, i10, i11);
                if (t0.this.f34822b.size() == 0) {
                    t0 t0Var = t0.this;
                    if (t0Var.f34821a.read(t0Var.f34822b, 8192L) == -1) {
                        return -1;
                    }
                }
                return t0.this.f34822b.read(data, i10, i11);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) {
        kotlin.jvm.internal.t.i(sink, "sink");
        if (this.f34822b.size() == 0 && this.f34821a.read(this.f34822b, 8192L) == -1) {
            return -1;
        }
        return this.f34822b.read(sink);
    }
}
