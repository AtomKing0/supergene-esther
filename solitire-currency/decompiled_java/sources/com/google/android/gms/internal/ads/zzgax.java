package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
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

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgax<V> extends zzgdm implements m<V> {
    private static final Object zzbc;
    private static final zza zzbf;
    static final boolean zzd;
    static final zzgct zze;
    private volatile zzd listeners;
    private volatile Object value;
    private volatile zzk waiters;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    abstract class zza {
        /* synthetic */ zza(zzgaw zzgawVar) {
        }

        abstract zzd zza(zzgax zzgaxVar, zzd zzdVar);

        abstract zzk zzb(zzgax zzgaxVar, zzk zzkVar);

        abstract void zzc(zzk zzkVar, zzk zzkVar2);

        abstract void zzd(zzk zzkVar, Thread thread);

        abstract boolean zze(zzgax zzgaxVar, zzd zzdVar, zzd zzdVar2);

        abstract boolean zzf(zzgax zzgaxVar, Object obj, Object obj2);

        abstract boolean zzg(zzgax zzgaxVar, zzk zzkVar, zzk zzkVar2);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzb {
        static final zzb zza;
        static final zzb zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzgax.zzd) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        zzb(boolean z10, Throwable th) {
            this.zzc = z10;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzgax.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<? super zzgax<?>, zzk> zzc;
        final AtomicReferenceFieldUpdater<? super zzgax<?>, zzd> zzd;
        final AtomicReferenceFieldUpdater<? super zzgax<?>, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final zzd zza(zzgax zzgaxVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzgaxVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final zzk zzb(zzgax zzgaxVar, zzk zzkVar) {
            return this.zzc.getAndSet(zzgaxVar, zzkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final void zzc(zzk zzkVar, zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final void zzd(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zze(zzgax zzgaxVar, zzd zzdVar, zzd zzdVar2) {
            return zzgay.zza(this.zzd, zzgaxVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zzf(zzgax zzgaxVar, Object obj, Object obj2) {
            return zzgay.zza(this.zze, zzgaxVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zzg(zzgax zzgaxVar, zzk zzkVar, zzk zzkVar2) {
            return zzgay.zza(this.zzc, zzgaxVar, zzkVar, zzkVar2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzf<V> implements Runnable {
        final zzgax<V> zza;
        final m<? extends V> zzb;

        zzf(zzgax zzgaxVar, m mVar) {
            this.zza = zzgaxVar;
            this.zzb = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzgax) this.zza).value != this) {
                return;
            }
            m<? extends V> mVar = this.zzb;
            if (zzgax.zzbf.zzf(this.zza, this, zzgax.zze(mVar))) {
                zzgax.zzx(this.zza, false);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzg extends zza {
        private zzg() {
            throw null;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final zzd zza(zzgax zzgaxVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzgaxVar) {
                zzdVar2 = zzgaxVar.listeners;
                if (zzdVar2 != zzdVar) {
                    zzgaxVar.listeners = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final zzk zzb(zzgax zzgaxVar, zzk zzkVar) {
            zzk zzkVar2;
            synchronized (zzgaxVar) {
                zzkVar2 = zzgaxVar.waiters;
                if (zzkVar2 != zzkVar) {
                    zzgaxVar.waiters = zzkVar;
                }
            }
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final void zzc(zzk zzkVar, zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final void zzd(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zze(zzgax zzgaxVar, zzd zzdVar, zzd zzdVar2) {
            synchronized (zzgaxVar) {
                if (zzgaxVar.listeners != zzdVar) {
                    return false;
                }
                zzgaxVar.listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zzf(zzgax zzgaxVar, Object obj, Object obj2) {
            synchronized (zzgaxVar) {
                if (zzgaxVar.value != obj) {
                    return false;
                }
                zzgaxVar.value = obj2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zzg(zzgax zzgaxVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzgaxVar) {
                if (zzgaxVar.waiters != zzkVar) {
                    return false;
                }
                zzgaxVar.waiters = zzkVar2;
                return true;
            }
        }

        /* synthetic */ zzg(zzgaz zzgazVar) {
            super(null);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    interface zzh<V> extends m<V> {
        @Override // com.google.common.util.concurrent.m
        /* synthetic */ void addListener(Runnable runnable, Executor executor);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    abstract class zzi<V> extends zzgax<V> implements zzh<V> {
        zzi() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e10) {
                    throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzgax.zzj.1
                    @Override // java.security.PrivilegedExceptionAction
                    public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                zzc = unsafe.objectFieldOffset(zzgax.class.getDeclaredField("waiters"));
                zzb = unsafe.objectFieldOffset(zzgax.class.getDeclaredField("listeners"));
                zzd = unsafe.objectFieldOffset(zzgax.class.getDeclaredField("value"));
                zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (NoSuchFieldException e11) {
                throw new RuntimeException(e11);
            }
        }

        private zzj() {
            throw null;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final zzd zza(zzgax zzgaxVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzgaxVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzgaxVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final zzk zzb(zzgax zzgaxVar, zzk zzkVar) {
            zzk zzkVar2;
            do {
                zzkVar2 = zzgaxVar.waiters;
                if (zzkVar == zzkVar2) {
                    break;
                }
            } while (!zzg(zzgaxVar, zzkVar2, zzkVar));
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final void zzc(zzk zzkVar, zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final void zzd(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zze(zzgax zzgaxVar, zzd zzdVar, zzd zzdVar2) {
            return zzgba.zza(zza, zzgaxVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zzf(zzgax zzgaxVar, Object obj, Object obj2) {
            return zzgba.zza(zza, zzgaxVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgax.zza
        final boolean zzg(zzgax zzgaxVar, zzk zzkVar, zzk zzkVar2) {
            return zzgba.zza(zza, zzgaxVar, zzc, zzkVar, zzkVar2);
        }

        /* synthetic */ zzj(zzgbb zzgbbVar) {
            super(null);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzk {
        static final zzk zza = new zzk(false);
        volatile zzk next;
        volatile Thread thread;

        zzk() {
            zzgax.zzbf.zzd(this, Thread.currentThread());
        }

        zzk(boolean z10) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean z10;
        Throwable th;
        Throwable th2;
        zza zzgVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        zzd = z10;
        zze = new zzgct(zzgax.class);
        Object[] objArr = 0;
        try {
            zzgVar = new zzj(null);
            th2 = null;
            th = null;
        } catch (Error | Exception e10) {
            try {
                th = null;
                th2 = e10;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzgax.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzgax.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzgax.class, Object.class, "value"));
            } catch (Error | Exception e11) {
                th = e11;
                th2 = e10;
                zzgVar = new zzg(objArr == true ? 1 : 0);
            }
        }
        zzbf = zzgVar;
        if (th != null) {
            zzgct zzgctVar = zze;
            Logger loggerZza = zzgctVar.zza();
            Level level = Level.SEVERE;
            loggerZza.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzgctVar.zza().logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzbc = new Object();
    }

    protected zzgax() {
    }

    private static final Object zzA(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzbc) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zze(m mVar) {
        Throwable thZzl;
        if (mVar instanceof zzh) {
            Object zzbVar = ((zzgax) mVar).value;
            if (zzbVar instanceof zzb) {
                zzb zzbVar2 = (zzb) zzbVar;
                if (zzbVar2.zzc) {
                    Throwable th = zzbVar2.zzd;
                    zzbVar = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            Objects.requireNonNull(zzbVar);
            return zzbVar;
        }
        if ((mVar instanceof zzgdm) && (thZzl = ((zzgdm) mVar).zzl()) != null) {
            return new zzc(thZzl);
        }
        boolean zIsCancelled = mVar.isCancelled();
        if ((!zzd) && zIsCancelled) {
            zzb zzbVar3 = zzb.zzb;
            Objects.requireNonNull(zzbVar3);
            return zzbVar3;
        }
        try {
            Object objZzf = zzf(mVar);
            if (!zIsCancelled) {
                return objZzf == null ? zzbc : objZzf;
            }
            return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(mVar)));
        } catch (Error e10) {
            e = e10;
            return new zzc(e);
        } catch (CancellationException e11) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(mVar)), e11)) : new zzb(false, e11);
        } catch (ExecutionException e12) {
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(mVar)), e12)) : new zzc(e12.getCause());
        } catch (Exception e13) {
            e = e13;
            return new zzc(e);
        }
    }

    private static Object zzf(Future future) throws ExecutionException {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
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
        return obj;
    }

    private final void zzu(StringBuilder sb) {
        try {
            Object objZzf = zzf(this);
            sb.append("SUCCESS, result=[");
            if (objZzf == null) {
                sb.append("null");
            } else if (objZzf == this) {
                sb.append("this future");
            } else {
                sb.append(objZzf.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzf)));
            }
            sb.append(v8.i.f15839e);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e10) {
            sb.append("FAILURE, cause=[");
            sb.append(e10.getCause());
            sb.append(v8.i.f15839e);
        } catch (Exception e11) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e11.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zzv(StringBuilder sb) {
        String strConcat;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzw(sb, ((zzf) obj).zzb);
            sb.append(v8.i.f15839e);
        } else {
            try {
                strConcat = zzfvj.zza(zza());
            } catch (Exception | StackOverflowError e10) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e10.getClass()));
            }
            if (strConcat != null) {
                sb.append(", info=[");
                sb.append(strConcat);
                sb.append(v8.i.f15839e);
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzu(sb);
        }
    }

    private final void zzw(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception | StackOverflowError e10) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e10.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzx(zzgax zzgaxVar, boolean z10) {
        zzd zzdVar = null;
        while (true) {
            for (zzk zzkVarZzb = zzbf.zzb(zzgaxVar, zzk.zza); zzkVarZzb != null; zzkVarZzb = zzkVarZzb.next) {
                Thread thread = zzkVarZzb.thread;
                if (thread != null) {
                    zzkVarZzb.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z10) {
                zzgaxVar.zzq();
            }
            zzgaxVar.zzb();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZza = zzbf.zza(zzgaxVar, zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZza != null) {
                zzd zzdVar4 = zzdVarZza.next;
                zzdVarZza.next = zzdVar3;
                zzdVar3 = zzdVarZza;
                zzdVarZza = zzdVar4;
            }
            while (zzdVar3 != null) {
                zzdVar = zzdVar3.next;
                Runnable runnable = zzdVar3.zzb;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzf) {
                    zzf zzfVar = (zzf) runnable2;
                    zzgaxVar = zzfVar.zza;
                    if (zzgaxVar.value == zzfVar) {
                        if (zzbf.zzf(zzgaxVar, zzfVar, zze(zzfVar.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    Objects.requireNonNull(executor);
                    zzy(runnable2, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
            z10 = false;
        }
    }

    private static void zzy(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e10) {
            zze.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e10);
        }
    }

    private final void zzz(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                            break;
                        }
                    } else if (!zzbf.zzg(this, zzkVar2, zzkVar4)) {
                        break;
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    @Override // com.google.common.util.concurrent.m
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzfuu.zzc(runnable, "Runnable was null.");
        zzfuu.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzbf.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzy(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        zzb zzbVar;
        Object obj = this.value;
        if (!(obj instanceof zzf) && !(obj == null)) {
            return false;
        }
        if (zzd) {
            zzbVar = new zzb(z10, new CancellationException("Future.cancel() was called."));
        } else {
            zzbVar = z10 ? zzb.zza : zzb.zzb;
            Objects.requireNonNull(zzbVar);
        }
        zzgax<V> zzgaxVar = this;
        boolean z11 = false;
        while (true) {
            if (zzbf.zzf(zzgaxVar, obj, zzbVar)) {
                zzx(zzgaxVar, z10);
                if (!(obj instanceof zzf)) {
                    break;
                }
                m<? extends V> mVar = ((zzf) obj).zzb;
                if (!(mVar instanceof zzh)) {
                    mVar.cancel(z10);
                    break;
                }
                zzgaxVar = (zzgax) mVar;
                obj = zzgaxVar.value;
                if (!(obj == null) && !(obj instanceof zzf)) {
                    break;
                }
                z11 = true;
            } else {
                obj = zzgaxVar.value;
                if (!(obj instanceof zzf)) {
                    return z11;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzA(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zzbf;
                zzaVar.zzc(zzkVar2, zzkVar);
                if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzz(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzA(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        Object obj3 = this.value;
        Objects.requireNonNull(obj3);
        return zzA(obj3);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (this.value != null) & (!(r0 instanceof zzf));
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
            zzu(sb);
        } else {
            zzv(sb);
        }
        sb.append(v8.i.f15839e);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean zzc(Object obj) {
        if (obj == null) {
            obj = zzbc;
        }
        if (!zzbf.zzf(this, null, obj)) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    protected boolean zzd(Throwable th) {
        th.getClass();
        if (!zzbf.zzf(this, null, new zzc(th))) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    protected final Throwable zzl() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    final void zzr(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzt());
        }
    }

    protected final boolean zzs(m mVar) {
        zzc zzcVar;
        mVar.getClass();
        Object obj = this.value;
        if (obj == null) {
            if (mVar.isDone()) {
                if (!zzbf.zzf(this, null, zze(mVar))) {
                    return false;
                }
                zzx(this, false);
                return true;
            }
            zzf zzfVar = new zzf(this, mVar);
            if (zzbf.zzf(this, null, zzfVar)) {
                try {
                    mVar.addListener(zzfVar, zzgbx.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzbf.zzf(this, zzfVar, zzcVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzb) {
            mVar.cancel(((zzb) obj).zzc);
        }
        return false;
    }

    protected final boolean zzt() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z10 = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return zzA(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.waiters;
                if (zzkVar != zzk.zza) {
                    zzk zzkVar2 = new zzk();
                    do {
                        zza zzaVar = zzbf;
                        zzaVar.zzc(zzkVar2, zzkVar);
                        if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof zzf))) {
                                        return zzA(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    zzz(zzkVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzz(zzkVar2);
                        } else {
                            zzkVar = this.waiters;
                        }
                    } while (zzkVar != zzk.zza);
                }
                Object obj3 = this.value;
                Objects.requireNonNull(obj3);
                return zzA(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) & (!(obj4 instanceof zzf))) {
                    return zzA(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = jNanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            String strConcat = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j11 = -nanos;
                long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
                long nanos2 = j11 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z10 = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                    if (z10) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(" ");
                }
                if (z10) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(strConcat + " for " + string);
        }
        throw new InterruptedException();
    }

    protected void zzb() {
    }

    protected void zzq() {
    }
}
