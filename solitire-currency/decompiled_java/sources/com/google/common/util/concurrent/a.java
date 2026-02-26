package com.google.common.util.concurrent;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.j2objc.annotations.ReflectionSupport;
import com.ironsource.v8;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: AbstractFuture.java */
/* JADX INFO: loaded from: classes3.dex */
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class a<V> extends h5.a implements m<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final boolean f10166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Logger f10167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final b f10168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f10169g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f10170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile e f10171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile l f10172c;

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, l lVar, l lVar2);

        abstract e d(a<?> aVar, e eVar);

        abstract l e(a<?> aVar, l lVar);

        abstract void f(l lVar, l lVar2);

        abstract void g(l lVar, Thread thread);
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f10173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final c f10174d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f10175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f10176b;

        static {
            if (a.f10166d) {
                f10174d = null;
                f10173c = null;
            } else {
                f10174d = new c(false, null);
                f10173c = new c(true, null);
            }
        }

        c(boolean z10, Throwable th) {
            this.f10175a = z10;
            this.f10176b = th;
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final d f10177b = new d(new C0225a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f10178a;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractFuture.java */
        class C0225a extends Throwable {
            C0225a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f10178a = (Throwable) e5.o.j(th);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<l, Thread> f10183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<l, l> f10184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, l> f10185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f10186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f10187e;

        f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f10183a = atomicReferenceFieldUpdater;
            this.f10184b = atomicReferenceFieldUpdater2;
            this.f10185c = atomicReferenceFieldUpdater3;
            this.f10186d = atomicReferenceFieldUpdater4;
            this.f10187e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.a.a(this.f10186d, aVar, eVar, eVar2);
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f10187e, aVar, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean c(a<?> aVar, l lVar, l lVar2) {
            return androidx.concurrent.futures.a.a(this.f10185c, aVar, lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.a.b
        e d(a<?> aVar, e eVar) {
            return this.f10186d.getAndSet(aVar, eVar);
        }

        @Override // com.google.common.util.concurrent.a.b
        l e(a<?> aVar, l lVar) {
            return this.f10185c.getAndSet(aVar, lVar);
        }

        @Override // com.google.common.util.concurrent.a.b
        void f(l lVar, l lVar2) {
            this.f10184b.lazySet(lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.a.b
        void g(l lVar, Thread thread) {
            this.f10183a.lazySet(lVar, thread);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class g<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a<V> f10188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final m<? extends V> f10189b;

        g(a<V> aVar, m<? extends V> mVar) {
            this.f10188a = aVar;
            this.f10189b = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((a) this.f10188a).f10170a != this) {
                return;
            }
            if (a.f10168f.b(this.f10188a, this, a.u(this.f10189b))) {
                a.r(this.f10188a, false);
            }
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class h extends b {
        private h() {
            super();
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (((a) aVar).f10171b != eVar) {
                    return false;
                }
                ((a) aVar).f10171b = eVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (((a) aVar).f10170a != obj) {
                    return false;
                }
                ((a) aVar).f10170a = obj2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean c(a<?> aVar, l lVar, l lVar2) {
            synchronized (aVar) {
                if (((a) aVar).f10172c != lVar) {
                    return false;
                }
                ((a) aVar).f10172c = lVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.a.b
        e d(a<?> aVar, e eVar) {
            e eVar2;
            synchronized (aVar) {
                eVar2 = ((a) aVar).f10171b;
                if (eVar2 != eVar) {
                    ((a) aVar).f10171b = eVar;
                }
            }
            return eVar2;
        }

        @Override // com.google.common.util.concurrent.a.b
        l e(a<?> aVar, l lVar) {
            l lVar2;
            synchronized (aVar) {
                lVar2 = ((a) aVar).f10172c;
                if (lVar2 != lVar) {
                    ((a) aVar).f10172c = lVar;
                }
            }
            return lVar2;
        }

        @Override // com.google.common.util.concurrent.a.b
        void f(l lVar, l lVar2) {
            lVar.f10198b = lVar2;
        }

        @Override // com.google.common.util.concurrent.a.b
        void g(l lVar, Thread thread) {
            lVar.f10197a = thread;
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    interface i<V> extends m<V> {
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    static abstract class j<V> extends a<V> implements i<V> {
        j() {
        }

        @Override // com.google.common.util.concurrent.a, com.google.common.util.concurrent.m
        public void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            return super.cancel(z10);
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public final V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j10, timeUnit);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class k extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Unsafe f10190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final long f10191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final long f10192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final long f10193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f10194e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f10195f;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.a$k$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractFuture.java */
        class C0226a implements PrivilegedExceptionAction<Unsafe> {
            C0226a() {
            }

            @Override // java.security.PrivilegedExceptionAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e10) {
                    throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new C0226a());
            }
            try {
                f10192c = unsafe.objectFieldOffset(a.class.getDeclaredField("c"));
                f10191b = unsafe.objectFieldOffset(a.class.getDeclaredField("b"));
                f10193d = unsafe.objectFieldOffset(a.class.getDeclaredField(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY));
                f10194e = unsafe.objectFieldOffset(l.class.getDeclaredField(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY));
                f10195f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                f10190a = unsafe;
            } catch (NoSuchFieldException e11) {
                throw new RuntimeException(e11);
            } catch (RuntimeException e12) {
                throw e12;
            }
        }

        private k() {
            super();
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return com.google.android.gms.internal.ads.l.a(f10190a, aVar, f10191b, eVar, eVar2);
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return com.google.android.gms.internal.ads.l.a(f10190a, aVar, f10193d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.a.b
        boolean c(a<?> aVar, l lVar, l lVar2) {
            return com.google.android.gms.internal.ads.l.a(f10190a, aVar, f10192c, lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.a.b
        e d(a<?> aVar, e eVar) {
            e eVar2;
            do {
                eVar2 = ((a) aVar).f10171b;
                if (eVar == eVar2) {
                    return eVar2;
                }
            } while (!a(aVar, eVar2, eVar));
            return eVar2;
        }

        @Override // com.google.common.util.concurrent.a.b
        l e(a<?> aVar, l lVar) {
            l lVar2;
            do {
                lVar2 = ((a) aVar).f10172c;
                if (lVar == lVar2) {
                    return lVar2;
                }
            } while (!c(aVar, lVar2, lVar));
            return lVar2;
        }

        @Override // com.google.common.util.concurrent.a.b
        void f(l lVar, l lVar2) {
            f10190a.putObject(lVar, f10195f, lVar2);
        }

        @Override // com.google.common.util.concurrent.a.b
        void g(l lVar, Thread thread) {
            f10190a.putObject(lVar, f10194e, thread);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final l f10196c = new l(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile Thread f10197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile l f10198b;

        l() {
            a.f10168f.g(this, Thread.currentThread());
        }

        l(boolean z10) {
        }

        void a(l lVar) {
            a.f10168f.f(this, lVar);
        }

        void b() {
            Thread thread = this.f10197a;
            if (thread != null) {
                this.f10197a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.common.util.concurrent.a$a] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    static {
        boolean z10;
        b hVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        f10166d = z10;
        f10167e = Logger.getLogger(a.class.getName());
        ?? r22 = 0;
        r22 = 0;
        try {
            hVar = new k();
            e = null;
        } catch (Error | RuntimeException e10) {
            e = e10;
            try {
                hVar = new f(AtomicReferenceFieldUpdater.newUpdater(l.class, Thread.class, CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY), AtomicReferenceFieldUpdater.newUpdater(l.class, l.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, l.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY));
            } catch (Error | RuntimeException e11) {
                hVar = new h();
                r22 = e11;
            }
        }
        f10168f = hVar;
        if (r22 != 0) {
            ?? r02 = f10167e;
            Level level = Level.SEVERE;
            r02.log(level, "UnsafeAtomicHelper is broken!", e);
            r02.log(level, "SafeAtomicHelper is broken!", r22);
        }
        f10169g = new Object();
    }

    protected a() {
    }

    private void k(StringBuilder sb) {
        try {
            Object objV = v(this);
            sb.append("SUCCESS, result=[");
            n(sb, objV);
            sb.append(v8.i.f15839e);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e10.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb.append("FAILURE, cause=[");
            sb.append(e11.getCause());
            sb.append(v8.i.f15839e);
        }
    }

    private void l(StringBuilder sb) {
        String strA;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.f10170a;
        if (obj instanceof g) {
            sb.append(", setFuture=[");
            o(sb, ((g) obj).f10189b);
            sb.append(v8.i.f15839e);
        } else {
            try {
                strA = e5.t.a(x());
            } catch (RuntimeException | StackOverflowError e10) {
                strA = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strA != null) {
                sb.append(", info=[");
                sb.append(strA);
                sb.append(v8.i.f15839e);
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            k(sb);
        }
    }

    private void n(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void o(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e10) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e10.getClass());
        }
    }

    private static CancellationException p(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private e q(e eVar) {
        e eVar2 = eVar;
        e eVarD = f10168f.d(this, e.f10179d);
        while (eVarD != null) {
            e eVar3 = eVarD.f10182c;
            eVarD.f10182c = eVar2;
            eVar2 = eVarD;
            eVarD = eVar3;
        }
        return eVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(a<?> aVar, boolean z10) {
        e eVar = null;
        while (true) {
            aVar.y();
            if (z10) {
                aVar.w();
                z10 = false;
            }
            aVar.m();
            e eVarQ = aVar.q(eVar);
            while (eVarQ != null) {
                eVar = eVarQ.f10182c;
                Runnable runnable = eVarQ.f10180a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof g) {
                    g gVar = (g) runnable2;
                    aVar = gVar.f10188a;
                    if (((a) aVar).f10170a == gVar) {
                        if (f10168f.b(aVar, gVar, u(gVar.f10189b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = eVarQ.f10181b;
                    Objects.requireNonNull(executor);
                    s(runnable2, executor);
                }
                eVarQ = eVar;
            }
            return;
        }
    }

    private static void s(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f10167e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V t(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw p("Task was cancelled.", ((c) obj).f10176b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f10178a);
        }
        return obj == f10169g ? (V) q.b() : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object u(m<?> mVar) {
        Throwable thA;
        if (mVar instanceof i) {
            Object cVar = ((a) mVar).f10170a;
            if (cVar instanceof c) {
                c cVar2 = (c) cVar;
                if (cVar2.f10175a) {
                    cVar = cVar2.f10176b != null ? new c(false, cVar2.f10176b) : c.f10174d;
                }
            }
            Objects.requireNonNull(cVar);
            return cVar;
        }
        if ((mVar instanceof h5.a) && (thA = h5.b.a((h5.a) mVar)) != null) {
            return new d(thA);
        }
        boolean zIsCancelled = mVar.isCancelled();
        if ((!f10166d) && zIsCancelled) {
            c cVar3 = c.f10174d;
            Objects.requireNonNull(cVar3);
            return cVar3;
        }
        try {
            Object objV = v(mVar);
            if (!zIsCancelled) {
                return objV == null ? f10169g : objV;
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + mVar));
        } catch (Error e10) {
            e = e10;
            return new d(e);
        } catch (CancellationException e11) {
            if (zIsCancelled) {
                return new c(false, e11);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + mVar, e11));
        } catch (RuntimeException e12) {
            e = e12;
            return new d(e);
        } catch (ExecutionException e13) {
            if (!zIsCancelled) {
                return new d(e13.getCause());
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + mVar, e13));
        }
    }

    private static <V> V v(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    private void y() {
        for (l lVarE = f10168f.e(this, l.f10196c); lVarE != null; lVarE = lVarE.f10198b) {
            lVarE.b();
        }
    }

    private void z(l lVar) {
        lVar.f10197a = null;
        while (true) {
            l lVar2 = this.f10172c;
            if (lVar2 == l.f10196c) {
                return;
            }
            l lVar3 = null;
            while (lVar2 != null) {
                l lVar4 = lVar2.f10198b;
                if (lVar2.f10197a != null) {
                    lVar3 = lVar2;
                } else if (lVar3 != null) {
                    lVar3.f10198b = lVar4;
                    if (lVar3.f10197a == null) {
                        break;
                    }
                } else if (!f10168f.c(this, lVar2, lVar4)) {
                    break;
                }
                lVar2 = lVar4;
            }
            return;
        }
    }

    protected boolean A(V v10) {
        if (v10 == null) {
            v10 = (V) f10169g;
        }
        if (!f10168f.b(this, null, v10)) {
            return false;
        }
        r(this, false);
        return true;
    }

    protected boolean B(Throwable th) {
        if (!f10168f.b(this, null, new d((Throwable) e5.o.j(th)))) {
            return false;
        }
        r(this, false);
        return true;
    }

    protected boolean C(m<? extends V> mVar) {
        d dVar;
        e5.o.j(mVar);
        Object obj = this.f10170a;
        if (obj == null) {
            if (mVar.isDone()) {
                if (!f10168f.b(this, null, u(mVar))) {
                    return false;
                }
                r(this, false);
                return true;
            }
            g gVar = new g(this, mVar);
            if (f10168f.b(this, null, gVar)) {
                try {
                    mVar.addListener(gVar, com.google.common.util.concurrent.d.INSTANCE);
                } catch (Error | RuntimeException e10) {
                    try {
                        dVar = new d(e10);
                    } catch (Error | RuntimeException unused) {
                        dVar = d.f10177b;
                    }
                    f10168f.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.f10170a;
        }
        if (obj instanceof c) {
            mVar.cancel(((c) obj).f10175a);
        }
        return false;
    }

    protected final boolean D() {
        Object obj = this.f10170a;
        return (obj instanceof c) && ((c) obj).f10175a;
    }

    @Override // h5.a
    protected final Throwable a() {
        if (!(this instanceof i)) {
            return null;
        }
        Object obj = this.f10170a;
        if (obj instanceof d) {
            return ((d) obj).f10178a;
        }
        return null;
    }

    @Override // com.google.common.util.concurrent.m
    public void addListener(Runnable runnable, Executor executor) {
        e eVar;
        e5.o.k(runnable, "Runnable was null.");
        e5.o.k(executor, "Executor was null.");
        if (!isDone() && (eVar = this.f10171b) != e.f10179d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f10182c = eVar;
                if (f10168f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f10171b;
                }
            } while (eVar != e.f10179d);
        }
        s(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        c cVar;
        Object obj = this.f10170a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f10166d) {
            cVar = new c(z10, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z10 ? c.f10173c : c.f10174d;
            Objects.requireNonNull(cVar);
        }
        a<V> aVar = this;
        boolean z11 = false;
        while (true) {
            if (f10168f.b(aVar, obj, cVar)) {
                r(aVar, z10);
                if (!(obj instanceof g)) {
                    return true;
                }
                m<? extends V> mVar = ((g) obj).f10189b;
                if (!(mVar instanceof i)) {
                    mVar.cancel(z10);
                    return true;
                }
                aVar = (a) mVar;
                obj = aVar.f10170a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = aVar.f10170a;
                if (!(obj instanceof g)) {
                    return z11;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f10170a;
        if ((obj != null) && (!(obj instanceof g))) {
            return t(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            l lVar = this.f10172c;
            if (lVar != l.f10196c) {
                l lVar2 = new l();
                do {
                    lVar2.a(lVar);
                    if (f10168f.c(this, lVar, lVar2)) {
                        do {
                            r.a(this, nanos);
                            if (Thread.interrupted()) {
                                z(lVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f10170a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return t(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        z(lVar2);
                    } else {
                        lVar = this.f10172c;
                    }
                } while (lVar != l.f10196c);
            }
            Object obj3 = this.f10170a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f10170a;
            if ((obj4 != null) && (!(obj4 instanceof g))) {
                return t(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z10) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f10170a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof g)) & (this.f10170a != null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            l(sb);
        }
        sb.append(v8.i.f15839e);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String x() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final e f10179d = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f10180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f10181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e f10182c;

        e(Runnable runnable, Executor executor) {
            this.f10180a = runnable;
            this.f10181b = executor;
        }

        e() {
            this.f10180a = null;
            this.f10181b = null;
        }
    }

    protected void m() {
    }

    protected void w() {
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f10170a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return t(obj2);
            }
            l lVar = this.f10172c;
            if (lVar != l.f10196c) {
                l lVar2 = new l();
                do {
                    lVar2.a(lVar);
                    if (f10168f.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f10170a;
                            } else {
                                z(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return t(obj);
                    }
                    lVar = this.f10172c;
                } while (lVar != l.f10196c);
            }
            Object obj3 = this.f10170a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        throw new InterruptedException();
    }
}
