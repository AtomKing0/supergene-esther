package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhh extends zzil {
    private static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);

    @Nullable
    private zzhl zzb;

    @Nullable
    private zzhl zzc;
    private final PriorityBlockingQueue<zzhm<?>> zzd;
    private final BlockingQueue<zzhm<?>> zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Thread.UncaughtExceptionHandler zzg;
    private final Object zzh;
    private final Semaphore zzi;
    private volatile boolean zzj;

    zzhh(zzho zzhoVar) {
        super(zzhoVar);
        this.zzh = new Object();
        this.zzi = new Semaphore(2);
        this.zzd = new PriorityBlockingQueue<>();
        this.zze = new LinkedBlockingQueue();
        this.zzf = new zzhj(this, "Thread death: Uncaught exception on worker thread");
        this.zzg = new zzhj(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    public final boolean zzg() {
        return Thread.currentThread() == this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    protected final boolean zzo() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final void zzr() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final void zzt() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final void zzc(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        zza(new zzhm<>(this, runnable, true, "Task exception on worker thread"));
    }

    @Nullable
    final <T> T zza(AtomicReference<T> atomicReference, long j10, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzl().zzb(runnable);
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                zzj().zzu().zza("Interrupted waiting for " + str);
                return null;
            }
        }
        T t10 = atomicReference.get();
        if (t10 == null) {
            zzj().zzu().zza("Timed out waiting for " + str);
        }
        return t10;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(callable);
        zzhm<?> zzhmVar = new zzhm<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            zzhmVar.run();
        } else {
            zza(zzhmVar);
        }
        return zzhmVar;
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        zza(new zzhm<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(callable);
        zzhm<?> zzhmVar = new zzhm<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                zzj().zzu().zza("Callable skipped the worker queue.");
            }
            zzhmVar.run();
        } else {
            zza(zzhmVar);
        }
        return zzhmVar;
    }

    private final void zza(zzhm<?> zzhmVar) {
        synchronized (this.zzh) {
            this.zzd.add(zzhmVar);
            zzhl zzhlVar = this.zzb;
            if (zzhlVar == null) {
                zzhl zzhlVar2 = new zzhl(this, "Measurement Worker", this.zzd);
                this.zzb = zzhlVar2;
                zzhlVar2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzhlVar.zza();
            }
        }
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        zzhm<?> zzhmVar = new zzhm<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            this.zze.add(zzhmVar);
            zzhl zzhlVar = this.zzc;
            if (zzhlVar == null) {
                zzhl zzhlVar2 = new zzhl(this, "Measurement Network", this.zze);
                this.zzc = zzhlVar2;
                zzhlVar2.setUncaughtExceptionHandler(this.zzg);
                this.zzc.start();
            } else {
                zzhlVar.zza();
            }
        }
    }
}
