package m5;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SequentialExecutor.java */
/* JADX INFO: loaded from: classes3.dex */
final class k implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f31450f = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f31451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("queue")
    private final Deque<Runnable> f31452b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("queue")
    private c f31453c = c.IDLE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("queue")
    private long f31454d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f31455e = new b(this, null);

    /* JADX INFO: compiled from: SequentialExecutor.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f31456a;

        a(Runnable runnable) {
            this.f31456a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f31456a.run();
        }

        public String toString() {
            return this.f31456a.toString();
        }
    }

    /* JADX INFO: compiled from: SequentialExecutor.java */
    private final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Runnable f31458a;

        private b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
            r2 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        
            r8.f31458a.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
        
            m5.k.f31450f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.f31458a, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
        
            r8.f31458a = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a() {
            /*
                r8 = this;
                r0 = 0
                r1 = r0
            L2:
                m5.k r2 = m5.k.this     // Catch: java.lang.Throwable -> L82
                java.util.Deque r2 = m5.k.a(r2)     // Catch: java.lang.Throwable -> L82
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L82
                if (r0 != 0) goto L2b
                m5.k r0 = m5.k.this     // Catch: java.lang.Throwable -> L7f
                m5.k$c r0 = m5.k.b(r0)     // Catch: java.lang.Throwable -> L7f
                m5.k$c r3 = m5.k.c.RUNNING     // Catch: java.lang.Throwable -> L7f
                if (r0 != r3) goto L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                if (r1 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                m5.k r0 = m5.k.this     // Catch: java.lang.Throwable -> L7f
                m5.k.d(r0)     // Catch: java.lang.Throwable -> L7f
                m5.k r0 = m5.k.this     // Catch: java.lang.Throwable -> L7f
                m5.k.c(r0, r3)     // Catch: java.lang.Throwable -> L7f
                r0 = 1
            L2b:
                m5.k r3 = m5.k.this     // Catch: java.lang.Throwable -> L7f
                java.util.Deque r3 = m5.k.a(r3)     // Catch: java.lang.Throwable -> L7f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L7f
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L7f
                r8.f31458a = r3     // Catch: java.lang.Throwable -> L7f
                if (r3 != 0) goto L4d
                m5.k r0 = m5.k.this     // Catch: java.lang.Throwable -> L7f
                m5.k$c r3 = m5.k.c.IDLE     // Catch: java.lang.Throwable -> L7f
                m5.k.c(r0, r3)     // Catch: java.lang.Throwable -> L7f
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                if (r1 == 0) goto L4c
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4c:
                return
            L4d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L82
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r8.f31458a     // Catch: java.lang.Throwable -> L5c java.lang.RuntimeException -> L5e
                r3.run()     // Catch: java.lang.Throwable -> L5c java.lang.RuntimeException -> L5e
            L59:
                r8.f31458a = r2     // Catch: java.lang.Throwable -> L82
                goto L2
            L5c:
                r0 = move-exception
                goto L7c
            L5e:
                r3 = move-exception
                java.util.logging.Logger r4 = m5.k.e()     // Catch: java.lang.Throwable -> L5c
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5c
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
                r6.<init>()     // Catch: java.lang.Throwable -> L5c
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L5c
                java.lang.Runnable r7 = r8.f31458a     // Catch: java.lang.Throwable -> L5c
                r6.append(r7)     // Catch: java.lang.Throwable -> L5c
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5c
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5c
                goto L59
            L7c:
                r8.f31458a = r2     // Catch: java.lang.Throwable -> L82
                throw r0     // Catch: java.lang.Throwable -> L82
            L7f:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                throw r0     // Catch: java.lang.Throwable -> L82
            L82:
                r0 = move-exception
                if (r1 == 0) goto L8c
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L8c:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: m5.k.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (k.this.f31452b) {
                    k.this.f31453c = c.IDLE;
                    throw e10;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f31458a;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + k.this.f31453c + "}";
        }

        /* synthetic */ b(k kVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SequentialExecutor.java */
    enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    k(Executor executor) {
        this.f31451a = (Executor) Preconditions.checkNotNull(executor);
    }

    static /* synthetic */ long d(k kVar) {
        long j10 = kVar.f31454d;
        kVar.f31454d = 1 + j10;
        return j10;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c cVar;
        Preconditions.checkNotNull(runnable);
        synchronized (this.f31452b) {
            c cVar2 = this.f31453c;
            if (cVar2 != c.RUNNING && cVar2 != (cVar = c.QUEUED)) {
                long j10 = this.f31454d;
                a aVar = new a(runnable);
                this.f31452b.add(aVar);
                c cVar3 = c.QUEUING;
                this.f31453c = cVar3;
                try {
                    this.f31451a.execute(this.f31455e);
                    if (this.f31453c != cVar3) {
                        return;
                    }
                    synchronized (this.f31452b) {
                        if (this.f31454d == j10 && this.f31453c == cVar3) {
                            this.f31453c = cVar;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e10) {
                    synchronized (this.f31452b) {
                        c cVar4 = this.f31453c;
                        if ((cVar4 != c.IDLE && cVar4 != c.QUEUING) || !this.f31452b.removeLastOccurrence(aVar)) {
                            z = false;
                        }
                        if (!(e10 instanceof RejectedExecutionException) || z) {
                            throw e10;
                        }
                    }
                    return;
                }
            }
            this.f31452b.add(runnable);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f31451a + "}";
    }
}
