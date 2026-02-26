package u0;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import u0.p;

/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f34224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f34225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<r0.f, c> f34226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<p<?>> f34227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p.a f34228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f34229f;

    /* JADX INFO: renamed from: u0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActiveResources.java */
    class ThreadFactoryC0701a implements ThreadFactory {

        /* JADX INFO: renamed from: u0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActiveResources.java */
        class RunnableC0702a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f34230a;

            RunnableC0702a(Runnable runnable) {
                this.f34230a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f34230a.run();
            }
        }

        ThreadFactoryC0701a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0702a(runnable), "glide-active-resources");
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    @VisibleForTesting
    static final class c extends WeakReference<p<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final r0.f f34233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f34234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        v<?> f34235c;

        c(@NonNull r0.f fVar, @NonNull p<?> pVar, @NonNull ReferenceQueue<? super p<?>> referenceQueue, boolean z10) {
            super(pVar, referenceQueue);
            this.f34233a = (r0.f) o1.j.d(fVar);
            this.f34235c = (pVar.d() && z10) ? (v) o1.j.d(pVar.c()) : null;
            this.f34234b = pVar.d();
        }

        void a() {
            this.f34235c = null;
            clear();
        }
    }

    a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new ThreadFactoryC0701a()));
    }

    synchronized void a(r0.f fVar, p<?> pVar) {
        c cVarPut = this.f34226c.put(fVar, new c(fVar, pVar, this.f34227d, this.f34224a));
        if (cVarPut != null) {
            cVarPut.a();
        }
    }

    void b() {
        while (!this.f34229f) {
            try {
                c((c) this.f34227d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(@NonNull c cVar) {
        v<?> vVar;
        synchronized (this) {
            this.f34226c.remove(cVar.f34233a);
            if (cVar.f34234b && (vVar = cVar.f34235c) != null) {
                this.f34228e.b(cVar.f34233a, new p<>(vVar, true, false, cVar.f34233a, this.f34228e));
            }
        }
    }

    synchronized void d(r0.f fVar) {
        c cVarRemove = this.f34226c.remove(fVar);
        if (cVarRemove != null) {
            cVarRemove.a();
        }
    }

    @Nullable
    synchronized p<?> e(r0.f fVar) {
        c cVar = this.f34226c.get(fVar);
        if (cVar == null) {
            return null;
        }
        p<?> pVar = cVar.get();
        if (pVar == null) {
            c(cVar);
        }
        return pVar;
    }

    void f(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f34228e = aVar;
            }
        }
    }

    @VisibleForTesting
    a(boolean z10, Executor executor) {
        this.f34226c = new HashMap();
        this.f34227d = new ReferenceQueue<>();
        this.f34224a = z10;
        this.f34225b = executor;
        executor.execute(new b());
    }
}
