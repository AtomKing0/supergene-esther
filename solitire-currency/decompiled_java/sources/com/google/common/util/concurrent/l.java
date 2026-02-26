package com.google.common.util.concurrent;

import com.google.j2objc.annotations.ReflectionSupport;
import com.ironsource.v8;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: InterruptibleTask.java */
/* JADX INFO: loaded from: classes3.dex */
@ReflectionSupport(ReflectionSupport.Level.FULL)
abstract class l<T> extends AtomicReference<Runnable> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Runnable f10204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Runnable f10205b;

    /* JADX INFO: compiled from: InterruptibleTask.java */
    static final class b extends AbstractOwnableSynchronizer implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l<?> f10206a;

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        public String toString() {
            return this.f10206a.toString();
        }

        private b(l<?> lVar) {
            this.f10206a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        f10204a = new c();
        f10205b = new c();
    }

    l() {
    }

    private void g(Thread thread) {
        Runnable runnable = get();
        b bVar = null;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            boolean z11 = runnable instanceof b;
            if (!z11 && runnable != f10205b) {
                break;
            }
            if (z11) {
                bVar = (b) runnable;
            }
            i10++;
            if (i10 > 1000) {
                Runnable runnable2 = f10205b;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z10 = Thread.interrupted() || z10;
                    LockSupport.park(bVar);
                }
            } else {
                Thread.yield();
            }
            runnable = get();
        }
        if (z10) {
            thread.interrupt();
        }
    }

    abstract void a(Throwable th);

    abstract void b(T t10);

    final void c() {
        Runnable runnable = get();
        if (runnable instanceof Thread) {
            b bVar = new b();
            bVar.b(Thread.currentThread());
            if (compareAndSet(runnable, bVar)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (getAndSet(f10204a) == f10205b) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    abstract boolean d();

    abstract T e() throws Exception;

    abstract String f();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objE = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean z10 = !d();
            if (z10) {
                try {
                    objE = e();
                } catch (Throwable th) {
                    try {
                        s.a(th);
                        if (!compareAndSet(threadCurrentThread, f10204a)) {
                            g(threadCurrentThread);
                        }
                        if (z10) {
                            a(th);
                            return;
                        }
                        return;
                    } finally {
                        if (!compareAndSet(threadCurrentThread, f10204a)) {
                            g(threadCurrentThread);
                        }
                        if (z10) {
                            b(q.a(null));
                        }
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f10204a) {
            str = "running=[DONE]";
        } else if (runnable instanceof b) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + v8.i.f15839e;
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + f();
    }

    /* JADX INFO: compiled from: InterruptibleTask.java */
    private static final class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
