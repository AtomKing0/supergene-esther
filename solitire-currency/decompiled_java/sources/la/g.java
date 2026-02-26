package la;

import ga.f0;
import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import la.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RealConnectionPool.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f31059f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f31060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f31061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ka.d f31062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final b f31063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final ConcurrentLinkedQueue<f> f31064e;

    /* JADX INFO: compiled from: RealConnectionPool.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: RealConnectionPool.kt */
    public static final class b extends ka.a {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // ka.a
        public long f() {
            return g.this.b(System.nanoTime());
        }
    }

    public g(@NotNull ka.e taskRunner, int i10, long j10, @NotNull TimeUnit timeUnit) {
        t.i(taskRunner, "taskRunner");
        t.i(timeUnit, "timeUnit");
        this.f31060a = i10;
        this.f31061b = timeUnit.toNanos(j10);
        this.f31062c = taskRunner.i();
        this.f31063d = new b(t.r(ha.d.f26516i, " ConnectionPool"));
        this.f31064e = new ConcurrentLinkedQueue<>();
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(t.r("keepAliveDuration <= 0: ", Long.valueOf(j10)).toString());
        }
    }

    private final int d(f fVar, long j10) {
        if (ha.d.f26515h && !Thread.holdsLock(fVar)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + fVar);
        }
        List<Reference<e>> listN = fVar.n();
        int i10 = 0;
        while (i10 < listN.size()) {
            Reference<e> reference = listN.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                qa.j.f33228a.g().m("A connection to " + fVar.z().a().l() + " was leaked. Did you forget to close a response body?", ((e.b) reference).a());
                listN.remove(i10);
                fVar.C(true);
                if (listN.isEmpty()) {
                    fVar.B(j10 - this.f31061b);
                    return 0;
                }
            }
        }
        return listN.size();
    }

    public final boolean a(@NotNull ga.a address, @NotNull e call, @Nullable List<f0> list, boolean z10) {
        t.i(address, "address");
        t.i(call, "call");
        for (f connection : this.f31064e) {
            t.h(connection, "connection");
            synchronized (connection) {
                if (z10) {
                    if (!connection.v()) {
                    }
                    k0 k0Var = k0.f35197a;
                }
                if (connection.t(address, list)) {
                    call.d(connection);
                    return true;
                }
                k0 k0Var2 = k0.f35197a;
            }
        }
        return false;
    }

    public final long b(long j10) {
        int i10 = 0;
        long j11 = Long.MIN_VALUE;
        f fVar = null;
        int i11 = 0;
        for (f connection : this.f31064e) {
            t.h(connection, "connection");
            synchronized (connection) {
                if (d(connection, j10) > 0) {
                    i11++;
                } else {
                    i10++;
                    long jO = j10 - connection.o();
                    if (jO > j11) {
                        fVar = connection;
                        j11 = jO;
                    }
                    k0 k0Var = k0.f35197a;
                }
            }
        }
        long j12 = this.f31061b;
        if (j11 < j12 && i10 <= this.f31060a) {
            if (i10 > 0) {
                return j12 - j11;
            }
            if (i11 > 0) {
                return j12;
            }
            return -1L;
        }
        t.f(fVar);
        synchronized (fVar) {
            if (!fVar.n().isEmpty()) {
                return 0L;
            }
            if (fVar.o() + j11 != j10) {
                return 0L;
            }
            fVar.C(true);
            this.f31064e.remove(fVar);
            ha.d.n(fVar.D());
            if (this.f31064e.isEmpty()) {
                this.f31062c.a();
            }
            return 0L;
        }
    }

    public final boolean c(@NotNull f connection) {
        t.i(connection, "connection");
        if (ha.d.f26515h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
        }
        if (!connection.p() && this.f31060a != 0) {
            ka.d.j(this.f31062c, this.f31063d, 0L, 2, null);
            return false;
        }
        connection.C(true);
        this.f31064e.remove(connection);
        if (this.f31064e.isEmpty()) {
            this.f31062c.a();
        }
        return true;
    }

    public final void e(@NotNull f connection) {
        t.i(connection, "connection");
        if (!ha.d.f26515h || Thread.holdsLock(connection)) {
            this.f31064e.add(connection);
            ka.d.j(this.f31062c, this.f31063d, 0L, 2, null);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
    }
}
