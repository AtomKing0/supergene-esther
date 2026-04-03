package ua;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a extends a1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final C0708a f34722i = new C0708a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f34723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f34724k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private static a f34725l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f34726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private a f34727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f34728h;

    /* JADX INFO: renamed from: ua.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class C0708a {
        private C0708a() {
        }

        public /* synthetic */ C0708a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(a aVar) {
            synchronized (a.class) {
                if (!aVar.f34726f) {
                    return false;
                }
                aVar.f34726f = false;
                for (a aVar2 = a.f34725l; aVar2 != null; aVar2 = aVar2.f34727g) {
                    if (aVar2.f34727g == aVar) {
                        aVar2.f34727g = aVar.f34727g;
                        aVar.f34727g = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(a aVar, long j10, boolean z10) {
            synchronized (a.class) {
                if (!(!aVar.f34726f)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                aVar.f34726f = true;
                if (a.f34725l == null) {
                    a.f34725l = new a();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j10 != 0 && z10) {
                    aVar.f34728h = Math.min(j10, aVar.c() - jNanoTime) + jNanoTime;
                } else if (j10 != 0) {
                    aVar.f34728h = j10 + jNanoTime;
                } else {
                    if (!z10) {
                        throw new AssertionError();
                    }
                    aVar.f34728h = aVar.c();
                }
                long jW = aVar.w(jNanoTime);
                a aVar2 = a.f34725l;
                kotlin.jvm.internal.t.f(aVar2);
                while (aVar2.f34727g != null) {
                    a aVar3 = aVar2.f34727g;
                    kotlin.jvm.internal.t.f(aVar3);
                    if (jW < aVar3.w(jNanoTime)) {
                        break;
                    }
                    aVar2 = aVar2.f34727g;
                    kotlin.jvm.internal.t.f(aVar2);
                }
                aVar.f34727g = aVar2.f34727g;
                aVar2.f34727g = aVar;
                if (aVar2 == a.f34725l) {
                    a.class.notify();
                }
                v8.k0 k0Var = v8.k0.f35197a;
            }
        }

        @Nullable
        public final a c() throws InterruptedException {
            a aVar = a.f34725l;
            kotlin.jvm.internal.t.f(aVar);
            a aVar2 = aVar.f34727g;
            if (aVar2 == null) {
                long jNanoTime = System.nanoTime();
                a.class.wait(a.f34723j);
                a aVar3 = a.f34725l;
                kotlin.jvm.internal.t.f(aVar3);
                if (aVar3.f34727g != null || System.nanoTime() - jNanoTime < a.f34724k) {
                    return null;
                }
                return a.f34725l;
            }
            long jW = aVar2.w(System.nanoTime());
            if (jW > 0) {
                long j10 = jW / 1000000;
                a.class.wait(j10, (int) (jW - (1000000 * j10)));
                return null;
            }
            a aVar4 = a.f34725l;
            kotlin.jvm.internal.t.f(aVar4);
            aVar4.f34727g = aVar2.f34727g;
            aVar2.f34727g = null;
            return aVar2;
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a aVarC;
            while (true) {
                try {
                    synchronized (a.class) {
                        aVarC = a.f34722i.c();
                        if (aVarC == a.f34725l) {
                            a.f34725l = null;
                            return;
                        }
                        v8.k0 k0Var = v8.k0.f35197a;
                    }
                    if (aVarC != null) {
                        aVarC.z();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class c implements x0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x0 f34730b;

        c(x0 x0Var) {
            this.f34730b = x0Var;
        }

        @Override // ua.x0
        public void G(@NotNull ua.c source, long j10) throws IOException {
            kotlin.jvm.internal.t.i(source, "source");
            f1.b(source.size(), 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                u0 u0Var = source.f34738a;
                kotlin.jvm.internal.t.f(u0Var);
                while (true) {
                    if (j11 >= 65536) {
                        break;
                    }
                    j11 += (long) (u0Var.f34828c - u0Var.f34827b);
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    } else {
                        u0Var = u0Var.f34831f;
                        kotlin.jvm.internal.t.f(u0Var);
                    }
                }
                a aVar = a.this;
                x0 x0Var = this.f34730b;
                aVar.t();
                try {
                    x0Var.G(source, j11);
                    v8.k0 k0Var = v8.k0.f35197a;
                    if (aVar.u()) {
                        throw aVar.n(null);
                    }
                    j10 -= j11;
                } catch (IOException e10) {
                    if (!aVar.u()) {
                        throw e10;
                    }
                    throw aVar.n(e10);
                } finally {
                    aVar.u();
                }
            }
        }

        @Override // ua.x0
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a timeout() {
            return a.this;
        }

        @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a aVar = a.this;
            x0 x0Var = this.f34730b;
            aVar.t();
            try {
                x0Var.close();
                v8.k0 k0Var = v8.k0.f35197a;
                if (aVar.u()) {
                    throw aVar.n(null);
                }
            } catch (IOException e10) {
                if (!aVar.u()) {
                    throw e10;
                }
                throw aVar.n(e10);
            } finally {
                aVar.u();
            }
        }

        @Override // ua.x0, java.io.Flushable
        public void flush() throws IOException {
            a aVar = a.this;
            x0 x0Var = this.f34730b;
            aVar.t();
            try {
                x0Var.flush();
                v8.k0 k0Var = v8.k0.f35197a;
                if (aVar.u()) {
                    throw aVar.n(null);
                }
            } catch (IOException e10) {
                if (!aVar.u()) {
                    throw e10;
                }
                throw aVar.n(e10);
            } finally {
                aVar.u();
            }
        }

        @NotNull
        public String toString() {
            return "AsyncTimeout.sink(" + this.f34730b + ')';
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class d implements z0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z0 f34732b;

        d(z0 z0Var) {
            this.f34732b = z0Var;
        }

        @Override // ua.z0
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a timeout() {
            return a.this;
        }

        @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a aVar = a.this;
            z0 z0Var = this.f34732b;
            aVar.t();
            try {
                z0Var.close();
                v8.k0 k0Var = v8.k0.f35197a;
                if (aVar.u()) {
                    throw aVar.n(null);
                }
            } catch (IOException e10) {
                if (!aVar.u()) {
                    throw e10;
                }
                throw aVar.n(e10);
            } finally {
                aVar.u();
            }
        }

        @Override // ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            kotlin.jvm.internal.t.i(sink, "sink");
            a aVar = a.this;
            z0 z0Var = this.f34732b;
            aVar.t();
            try {
                long j11 = z0Var.read(sink, j10);
                if (aVar.u()) {
                    throw aVar.n(null);
                }
                return j11;
            } catch (IOException e10) {
                if (aVar.u()) {
                    throw aVar.n(e10);
                }
                throw e10;
            } finally {
                aVar.u();
            }
        }

        @NotNull
        public String toString() {
            return "AsyncTimeout.source(" + this.f34732b + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f34723j = millis;
        f34724k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long w(long j10) {
        return this.f34728h - j10;
    }

    @NotNull
    public final IOException n(@Nullable IOException iOException) {
        return v(iOException);
    }

    public final void t() {
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            f34722i.e(this, jH, zE);
        }
    }

    public final boolean u() {
        return f34722i.d(this);
    }

    @NotNull
    protected IOException v(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @NotNull
    public final x0 x(@NotNull x0 sink) {
        kotlin.jvm.internal.t.i(sink, "sink");
        return new c(sink);
    }

    @NotNull
    public final z0 y(@NotNull z0 source) {
        kotlin.jvm.internal.t.i(source, "source");
        return new d(source);
    }

    protected void z() {
    }
}
