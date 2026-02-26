package ua;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final d f34762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Deflater f34763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34764c;

    public g(@NotNull d sink, @NotNull Deflater deflater) {
        kotlin.jvm.internal.t.i(sink, "sink");
        kotlin.jvm.internal.t.i(deflater, "deflater");
        this.f34762a = sink;
        this.f34763b = deflater;
    }

    @IgnoreJRERequirement
    private final void a(boolean z10) throws IOException {
        u0 u0VarO0;
        int iDeflate;
        c cVarG = this.f34762a.g();
        while (true) {
            u0VarO0 = cVarG.O0(1);
            if (z10) {
                Deflater deflater = this.f34763b;
                byte[] bArr = u0VarO0.f34826a;
                int i10 = u0VarO0.f34828c;
                iDeflate = deflater.deflate(bArr, i10, 8192 - i10, 2);
            } else {
                Deflater deflater2 = this.f34763b;
                byte[] bArr2 = u0VarO0.f34826a;
                int i11 = u0VarO0.f34828c;
                iDeflate = deflater2.deflate(bArr2, i11, 8192 - i11);
            }
            if (iDeflate > 0) {
                u0VarO0.f34828c += iDeflate;
                cVarG.L0(cVarG.size() + ((long) iDeflate));
                this.f34762a.w();
            } else if (this.f34763b.needsInput()) {
                break;
            }
        }
        if (u0VarO0.f34827b == u0VarO0.f34828c) {
            cVarG.f34738a = u0VarO0.b();
            v0.b(u0VarO0);
        }
    }

    @Override // ua.x0
    public void G(@NotNull c source, long j10) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        f1.b(source.size(), 0L, j10);
        while (j10 > 0) {
            u0 u0Var = source.f34738a;
            kotlin.jvm.internal.t.f(u0Var);
            int iMin = (int) Math.min(j10, u0Var.f34828c - u0Var.f34827b);
            this.f34763b.setInput(u0Var.f34826a, u0Var.f34827b, iMin);
            a(false);
            long j11 = iMin;
            source.L0(source.size() - j11);
            int i10 = u0Var.f34827b + iMin;
            u0Var.f34827b = i10;
            if (i10 == u0Var.f34828c) {
                source.f34738a = u0Var.b();
                v0.b(u0Var);
            }
            j10 -= j11;
        }
    }

    public final void c() throws IOException {
        this.f34763b.finish();
        a(false);
    }

    @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f34764c) {
            return;
        }
        try {
            c();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f34763b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f34762a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f34764c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // ua.x0, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f34762a.flush();
    }

    @Override // ua.x0
    @NotNull
    public a1 timeout() {
        return this.f34762a.timeout();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.f34762a + ')';
    }
}
