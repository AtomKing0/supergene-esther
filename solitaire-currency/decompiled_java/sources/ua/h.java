package ua;

import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FileHandle.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f34765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f34766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34767c;

    /* JADX INFO: compiled from: FileHandle.kt */
    private static final class a implements z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final h f34768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f34769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f34770c;

        public a(@NotNull h fileHandle, long j10) {
            kotlin.jvm.internal.t.i(fileHandle, "fileHandle");
            this.f34768a = fileHandle;
            this.f34769b = j10;
        }

        @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f34770c) {
                return;
            }
            this.f34770c = true;
            synchronized (this.f34768a) {
                h hVar = this.f34768a;
                hVar.f34767c--;
                if (this.f34768a.f34767c == 0 && this.f34768a.f34766b) {
                    v8.k0 k0Var = v8.k0.f35197a;
                    this.f34768a.q();
                }
            }
        }

        @Override // ua.z0
        public long read(@NotNull c sink, long j10) throws IOException {
            kotlin.jvm.internal.t.i(sink, "sink");
            if (!(!this.f34770c)) {
                throw new IllegalStateException("closed".toString());
            }
            long jB = this.f34768a.B(this.f34769b, sink, j10);
            if (jB != -1) {
                this.f34769b += jB;
            }
            return jB;
        }

        @Override // ua.z0
        @NotNull
        public a1 timeout() {
            return a1.f34734e;
        }
    }

    public h(boolean z10) {
        this.f34765a = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long B(long j10, c cVar, long j11) throws IOException {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        }
        long j12 = j10 + j11;
        long j13 = j10;
        while (true) {
            if (j13 >= j12) {
                break;
            }
            u0 u0VarO0 = cVar.O0(1);
            int iX = x(j13, u0VarO0.f34826a, u0VarO0.f34828c, (int) Math.min(j12 - j13, 8192 - r9));
            if (iX == -1) {
                if (u0VarO0.f34827b == u0VarO0.f34828c) {
                    cVar.f34738a = u0VarO0.b();
                    v0.b(u0VarO0);
                }
                if (j10 == j13) {
                    return -1L;
                }
            } else {
                u0VarO0.f34828c += iX;
                long j14 = iX;
                j13 += j14;
                cVar.L0(cVar.size() + j14);
            }
        }
        return j13 - j10;
    }

    @NotNull
    public final z0 J(long j10) throws IOException {
        synchronized (this) {
            if (!(!this.f34766b)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f34767c++;
        }
        return new a(this, j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            if (this.f34766b) {
                return;
            }
            this.f34766b = true;
            if (this.f34767c != 0) {
                return;
            }
            v8.k0 k0Var = v8.k0.f35197a;
            q();
        }
    }

    protected abstract void q() throws IOException;

    public final long size() throws IOException {
        synchronized (this) {
            if (!(!this.f34766b)) {
                throw new IllegalStateException("closed".toString());
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
        return z();
    }

    protected abstract int x(long j10, @NotNull byte[] bArr, int i10, int i11) throws IOException;

    protected abstract long z() throws IOException;
}
