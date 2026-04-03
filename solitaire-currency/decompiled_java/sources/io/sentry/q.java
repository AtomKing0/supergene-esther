package io.sentry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultCompositePerformanceCollector.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class q implements j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f28086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28087g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f28081a = new io.sentry.util.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile Timer f28082b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<String, List<r3>> f28083c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f28088h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f28089i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<a1> f28084d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<z0> f28085e = new ArrayList();

    /* JADX INFO: compiled from: DefaultCompositePerformanceCollector.java */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Iterator it = q.this.f28084d.iterator();
            while (it.hasNext()) {
                ((a1) it.next()).c();
            }
        }
    }

    /* JADX INFO: compiled from: DefaultCompositePerformanceCollector.java */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - q.this.f28089i <= 10) {
                return;
            }
            q.this.f28089i = jCurrentTimeMillis;
            r3 r3Var = new r3();
            Iterator it = q.this.f28084d.iterator();
            while (it.hasNext()) {
                ((a1) it.next()).d(r3Var);
            }
            Iterator it2 = q.this.f28083c.values().iterator();
            while (it2.hasNext()) {
                ((List) it2.next()).add(r3Var);
            }
        }
    }

    public q(@NotNull SentryOptions sentryOptions) {
        boolean z10 = false;
        this.f28087g = (SentryOptions) io.sentry.util.w.c(sentryOptions, "The options object is required.");
        for (y0 y0Var : sentryOptions.getPerformanceCollectors()) {
            if (y0Var instanceof a1) {
                this.f28084d.add((a1) y0Var);
            }
            if (y0Var instanceof z0) {
                this.f28085e.add((z0) y0Var);
            }
        }
        if (this.f28084d.isEmpty() && this.f28085e.isEmpty()) {
            z10 = true;
        }
        this.f28086f = z10;
    }

    @Override // io.sentry.j
    public void a(@NotNull n1 n1Var) {
        Iterator<z0> it = this.f28085e.iterator();
        while (it.hasNext()) {
            it.next().a(n1Var);
        }
    }

    @Override // io.sentry.j
    public void b(@NotNull n1 n1Var) {
        Iterator<z0> it = this.f28085e.iterator();
        while (it.hasNext()) {
            it.next().b(n1Var);
        }
    }

    @Override // io.sentry.j
    @Nullable
    public List<r3> c(@NotNull String str) {
        List<r3> listRemove = this.f28083c.remove(str);
        if (this.f28083c.isEmpty()) {
            close();
        }
        return listRemove;
    }

    @Override // io.sentry.j
    public void close() {
        this.f28087g.getLogger().c(SentryLevel.DEBUG, "stop collecting all performance info for transactions", new Object[0]);
        this.f28083c.clear();
        Iterator<z0> it = this.f28085e.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        if (this.f28088h.getAndSet(false)) {
            k1 k1VarA = this.f28081a.a();
            try {
                if (this.f28082b != null) {
                    this.f28082b.cancel();
                    this.f28082b = null;
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // io.sentry.j
    @Nullable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<r3> l(@NotNull p1 p1Var) {
        this.f28087g.getLogger().c(SentryLevel.DEBUG, "stop collecting performance info for transactions %s (%s)", p1Var.getName(), p1Var.r().n().toString());
        Iterator<z0> it = this.f28085e.iterator();
        while (it.hasNext()) {
            it.next().a(p1Var);
        }
        return c(p1Var.getEventId().toString());
    }

    @Override // io.sentry.j
    public void e(@NotNull final p1 p1Var) {
        if (this.f28086f) {
            this.f28087g.getLogger().c(SentryLevel.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        Iterator<z0> it = this.f28085e.iterator();
        while (it.hasNext()) {
            it.next().b(p1Var);
        }
        if (!this.f28083c.containsKey(p1Var.getEventId().toString())) {
            this.f28083c.put(p1Var.getEventId().toString(), new ArrayList());
            try {
                this.f28087g.getExecutorService().b(new Runnable() { // from class: io.sentry.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f28036a.l(p1Var);
                    }
                }, 30000L);
            } catch (RejectedExecutionException e10) {
                this.f28087g.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Performance collector will not be automatically finished. Did you call Sentry.close()?", e10);
            }
        }
        f(p1Var.getEventId().toString());
    }

    @Override // io.sentry.j
    public void f(@NotNull String str) {
        if (this.f28086f) {
            this.f28087g.getLogger().c(SentryLevel.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        if (!this.f28083c.containsKey(str)) {
            this.f28083c.put(str, new ArrayList());
        }
        if (this.f28088h.getAndSet(true)) {
            return;
        }
        k1 k1VarA = this.f28081a.a();
        try {
            if (this.f28082b == null) {
                this.f28082b = new Timer(true);
            }
            this.f28082b.schedule(new a(), 0L);
            this.f28082b.scheduleAtFixedRate(new b(), 100L, 100L);
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
