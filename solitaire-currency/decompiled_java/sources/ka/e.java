package ka;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final b f29729h = new b(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final e f29730i = new e(new c(ha.d.N(t.r(ha.d.f26516i, " TaskRunner"), true)));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final Logger f29731j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a f29732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f29734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f29735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<ka.d> f29736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<ka.d> f29737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Runnable f29738g;

    /* JADX INFO: compiled from: TaskRunner.kt */
    public interface a {
        void a(@NotNull e eVar, long j10);

        void b(@NotNull e eVar);

        void execute(@NotNull Runnable runnable);

        long nanoTime();
    }

    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        @NotNull
        public final Logger a() {
            return e.f29731j;
        }
    }

    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ThreadPoolExecutor f29739a;

        public c(@NotNull ThreadFactory threadFactory) {
            t.i(threadFactory, "threadFactory");
            this.f29739a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // ka.e.a
        public void a(@NotNull e taskRunner, long j10) throws InterruptedException {
            t.i(taskRunner, "taskRunner");
            long j11 = j10 / 1000000;
            long j12 = j10 - (1000000 * j11);
            if (j11 > 0 || j10 > 0) {
                taskRunner.wait(j11, (int) j12);
            }
        }

        @Override // ka.e.a
        public void b(@NotNull e taskRunner) {
            t.i(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // ka.e.a
        public void execute(@NotNull Runnable runnable) {
            t.i(runnable, "runnable");
            this.f29739a.execute(runnable);
        }

        @Override // ka.e.a
        public long nanoTime() {
            return System.nanoTime();
        }
    }

    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ka.a aVarD;
            long jNanoTime;
            while (true) {
                e eVar = e.this;
                synchronized (eVar) {
                    aVarD = eVar.d();
                }
                if (aVarD == null) {
                    return;
                }
                ka.d dVarD = aVarD.d();
                t.f(dVarD);
                e eVar2 = e.this;
                boolean zIsLoggable = e.f29729h.a().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jNanoTime = dVarD.h().g().nanoTime();
                    ka.b.c(aVarD, dVarD, "starting");
                } else {
                    jNanoTime = -1;
                }
                try {
                    try {
                        eVar2.j(aVarD);
                        k0 k0Var = k0.f35197a;
                        if (zIsLoggable) {
                            ka.b.c(aVarD, dVarD, t.r("finished run in ", ka.b.b(dVarD.h().g().nanoTime() - jNanoTime)));
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    if (zIsLoggable) {
                        ka.b.c(aVarD, dVarD, t.r("failed a run in ", ka.b.b(dVarD.h().g().nanoTime() - jNanoTime)));
                    }
                    throw th;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        t.h(logger, "getLogger(TaskRunner::class.java.name)");
        f29731j = logger;
    }

    public e(@NotNull a backend) {
        t.i(backend, "backend");
        this.f29732a = backend;
        this.f29733b = 10000;
        this.f29736e = new ArrayList();
        this.f29737f = new ArrayList();
        this.f29738g = new d();
    }

    private final void c(ka.a aVar, long j10) {
        if (ha.d.f26515h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        ka.d dVarD = aVar.d();
        t.f(dVarD);
        if (!(dVarD.c() == aVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean zD = dVarD.d();
        dVarD.m(false);
        dVarD.l(null);
        this.f29736e.remove(dVarD);
        if (j10 != -1 && !zD && !dVarD.g()) {
            dVarD.k(aVar, j10, true);
        }
        if (!dVarD.e().isEmpty()) {
            this.f29737f.add(dVarD);
        }
    }

    private final void e(ka.a aVar) {
        if (ha.d.f26515h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        aVar.g(-1L);
        ka.d dVarD = aVar.d();
        t.f(dVarD);
        dVarD.e().remove(aVar);
        this.f29737f.remove(dVarD);
        dVarD.l(aVar);
        this.f29736e.add(dVarD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(ka.a aVar) {
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.b());
        try {
            long jF = aVar.f();
            synchronized (this) {
                c(aVar, jF);
                k0 k0Var = k0.f35197a;
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (this) {
                c(aVar, -1L);
                k0 k0Var2 = k0.f35197a;
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    @Nullable
    public final ka.a d() {
        boolean z10;
        if (ha.d.f26515h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        while (!this.f29737f.isEmpty()) {
            long jNanoTime = this.f29732a.nanoTime();
            Iterator<ka.d> it = this.f29737f.iterator();
            long jMin = Long.MAX_VALUE;
            ka.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                ka.a aVar2 = it.next().e().get(0);
                long jMax = Math.max(0L, aVar2.c() - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z10 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                e(aVar);
                if (z10 || (!this.f29734c && (!this.f29737f.isEmpty()))) {
                    this.f29732a.execute(this.f29738g);
                }
                return aVar;
            }
            if (this.f29734c) {
                if (jMin < this.f29735d - jNanoTime) {
                    this.f29732a.b(this);
                }
                return null;
            }
            this.f29734c = true;
            this.f29735d = jNanoTime + jMin;
            try {
                try {
                    this.f29732a.a(this, jMin);
                } catch (InterruptedException unused) {
                    f();
                }
            } finally {
                this.f29734c = false;
            }
        }
        return null;
    }

    public final void f() {
        int size = this.f29736e.size() - 1;
        if (size >= 0) {
            while (true) {
                int i10 = size - 1;
                this.f29736e.get(size).b();
                if (i10 < 0) {
                    break;
                } else {
                    size = i10;
                }
            }
        }
        int size2 = this.f29737f.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i11 = size2 - 1;
            ka.d dVar = this.f29737f.get(size2);
            dVar.b();
            if (dVar.e().isEmpty()) {
                this.f29737f.remove(size2);
            }
            if (i11 < 0) {
                return;
            } else {
                size2 = i11;
            }
        }
    }

    @NotNull
    public final a g() {
        return this.f29732a;
    }

    public final void h(@NotNull ka.d taskQueue) {
        t.i(taskQueue, "taskQueue");
        if (ha.d.f26515h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (taskQueue.c() == null) {
            if (!taskQueue.e().isEmpty()) {
                ha.d.c(this.f29737f, taskQueue);
            } else {
                this.f29737f.remove(taskQueue);
            }
        }
        if (this.f29734c) {
            this.f29732a.b(this);
        } else {
            this.f29732a.execute(this.f29738g);
        }
    }

    @NotNull
    public final ka.d i() {
        int i10;
        synchronized (this) {
            i10 = this.f29733b;
            this.f29733b = i10 + 1;
        }
        return new ka.d(this, t.r("Q", Integer.valueOf(i10)));
    }
}
