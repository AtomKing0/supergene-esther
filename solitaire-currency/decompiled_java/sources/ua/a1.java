package ua;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f34733d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a1 f34734e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f34735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f34736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f34737c;

    /* JADX INFO: compiled from: Timeout.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    @NotNull
    public a1 a() {
        this.f34735a = false;
        return this;
    }

    @NotNull
    public a1 b() {
        this.f34737c = 0L;
        return this;
    }

    public long c() {
        if (this.f34735a) {
            return this.f34736b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    @NotNull
    public a1 d(long j10) {
        this.f34735a = true;
        this.f34736b = j10;
        return this;
    }

    public boolean e() {
        return this.f34735a;
    }

    public void f() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f34735a && this.f34736b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @NotNull
    public a1 g(long j10, @NotNull TimeUnit unit) {
        kotlin.jvm.internal.t.i(unit, "unit");
        if (j10 >= 0) {
            this.f34737c = unit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j10).toString());
    }

    public long h() {
        return this.f34737c;
    }

    /* JADX INFO: compiled from: Timeout.kt */
    public static final class a extends a1 {
        a() {
        }

        @Override // ua.a1
        @NotNull
        public a1 g(long j10, @NotNull TimeUnit unit) {
            kotlin.jvm.internal.t.i(unit, "unit");
            return this;
        }

        @Override // ua.a1
        public void f() {
        }

        @Override // ua.a1
        @NotNull
        public a1 d(long j10) {
            return this;
        }
    }
}
