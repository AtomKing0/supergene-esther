package ua;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RealBufferedSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s0 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final x0 f34818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final c f34819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f34820c;

    public s0(@NotNull x0 sink) {
        kotlin.jvm.internal.t.i(sink, "sink");
        this.f34818a = sink;
        this.f34819b = new c();
    }

    @Override // ua.d
    @NotNull
    public d E(@NotNull String string) {
        kotlin.jvm.internal.t.i(string, "string");
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.E(string);
        return w();
    }

    @Override // ua.x0
    public void G(@NotNull c source, long j10) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.G(source, j10);
        w();
    }

    @Override // ua.d
    @NotNull
    public d I(@NotNull f byteString) {
        kotlin.jvm.internal.t.i(byteString, "byteString");
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.I(byteString);
        return w();
    }

    @NotNull
    public d a(int i10) {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.W0(i10);
        return w();
    }

    @Override // ua.d
    @NotNull
    public d b0(long j10) {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.b0(j10);
        return w();
    }

    @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f34820c) {
            return;
        }
        try {
            if (this.f34819b.size() > 0) {
                x0 x0Var = this.f34818a;
                c cVar = this.f34819b;
                x0Var.G(cVar, cVar.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f34818a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f34820c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // ua.d, ua.x0, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f34819b.size() > 0) {
            x0 x0Var = this.f34818a;
            c cVar = this.f34819b;
            x0Var.G(cVar, cVar.size());
        }
        this.f34818a.flush();
    }

    @Override // ua.d
    @NotNull
    public c g() {
        return this.f34819b;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f34820c;
    }

    @Override // ua.d
    @NotNull
    public d o() throws IOException {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = this.f34819b.size();
        if (size > 0) {
            this.f34818a.G(this.f34819b, size);
        }
        return this;
    }

    @Override // ua.d
    public long s(@NotNull z0 source) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        long j10 = 0;
        while (true) {
            long j11 = source.read(this.f34819b, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            w();
        }
    }

    @Override // ua.x0
    @NotNull
    public a1 timeout() {
        return this.f34818a.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.f34818a + ')';
    }

    @Override // ua.d
    @NotNull
    public d v0(long j10) {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.v0(j10);
        return w();
    }

    @Override // ua.d
    @NotNull
    public d w() throws IOException {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jQ = this.f34819b.q();
        if (jQ > 0) {
            this.f34818a.G(this.f34819b, jQ);
        }
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f34819b.write(source);
        w();
        return iWrite;
    }

    @Override // ua.d
    @NotNull
    public d writeByte(int i10) {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.writeByte(i10);
        return w();
    }

    @Override // ua.d
    @NotNull
    public d writeInt(int i10) {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.writeInt(i10);
        return w();
    }

    @Override // ua.d
    @NotNull
    public d writeShort(int i10) {
        if (!(!this.f34820c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f34819b.writeShort(i10);
        return w();
    }

    @Override // ua.d
    @NotNull
    public d write(@NotNull byte[] source) {
        kotlin.jvm.internal.t.i(source, "source");
        if (!this.f34820c) {
            this.f34819b.write(source);
            return w();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // ua.d
    @NotNull
    public d write(@NotNull byte[] source, int i10, int i11) {
        kotlin.jvm.internal.t.i(source, "source");
        if (!this.f34820c) {
            this.f34819b.write(source, i10, i11);
            return w();
        }
        throw new IllegalStateException("closed".toString());
    }
}
