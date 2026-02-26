package ka;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e f29723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f29724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f29725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private a f29726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<a> f29727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f29728f;

    public d(@NotNull e taskRunner, @NotNull String name) {
        t.i(taskRunner, "taskRunner");
        t.i(name, "name");
        this.f29723a = taskRunner;
        this.f29724b = name;
        this.f29727e = new ArrayList();
    }

    public static /* synthetic */ void j(d dVar, a aVar, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        dVar.i(aVar, j10);
    }

    public final void a() {
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.f29723a) {
            if (b()) {
                h().h(this);
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final boolean b() {
        a aVar = this.f29726d;
        if (aVar != null) {
            t.f(aVar);
            if (aVar.a()) {
                this.f29728f = true;
            }
        }
        int size = this.f29727e.size() - 1;
        boolean z10 = false;
        if (size >= 0) {
            while (true) {
                int i10 = size - 1;
                if (this.f29727e.get(size).a()) {
                    a aVar2 = this.f29727e.get(size);
                    if (e.f29729h.a().isLoggable(Level.FINE)) {
                        b.c(aVar2, this, "canceled");
                    }
                    this.f29727e.remove(size);
                    z10 = true;
                }
                if (i10 < 0) {
                    break;
                }
                size = i10;
            }
        }
        return z10;
    }

    @Nullable
    public final a c() {
        return this.f29726d;
    }

    public final boolean d() {
        return this.f29728f;
    }

    @NotNull
    public final List<a> e() {
        return this.f29727e;
    }

    @NotNull
    public final String f() {
        return this.f29724b;
    }

    public final boolean g() {
        return this.f29725c;
    }

    @NotNull
    public final e h() {
        return this.f29723a;
    }

    public final void i(@NotNull a task, long j10) {
        t.i(task, "task");
        synchronized (this.f29723a) {
            if (!g()) {
                if (k(task, j10, false)) {
                    h().h(this);
                }
                k0 k0Var = k0.f35197a;
            } else if (task.a()) {
                if (e.f29729h.a().isLoggable(Level.FINE)) {
                    b.c(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (e.f29729h.a().isLoggable(Level.FINE)) {
                    b.c(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean k(@NotNull a task, long j10, boolean z10) {
        t.i(task, "task");
        task.e(this);
        long jNanoTime = this.f29723a.g().nanoTime();
        long j11 = jNanoTime + j10;
        int iIndexOf = this.f29727e.indexOf(task);
        if (iIndexOf != -1) {
            if (task.c() <= j11) {
                if (e.f29729h.a().isLoggable(Level.FINE)) {
                    b.c(task, this, "already scheduled");
                }
                return false;
            }
            this.f29727e.remove(iIndexOf);
        }
        task.g(j11);
        if (e.f29729h.a().isLoggable(Level.FINE)) {
            b.c(task, this, z10 ? t.r("run again after ", b.b(j11 - jNanoTime)) : t.r("scheduled after ", b.b(j11 - jNanoTime)));
        }
        Iterator<a> it = this.f29727e.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().c() - jNanoTime > j10) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f29727e.size();
        }
        this.f29727e.add(size, task);
        return size == 0;
    }

    public final void l(@Nullable a aVar) {
        this.f29726d = aVar;
    }

    public final void m(boolean z10) {
        this.f29728f = z10;
    }

    public final void n(boolean z10) {
        this.f29725c = z10;
    }

    public final void o() {
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.f29723a) {
            n(true);
            if (b()) {
                h().h(this);
            }
            k0 k0Var = k0.f35197a;
        }
    }

    @NotNull
    public String toString() {
        return this.f29724b;
    }
}
