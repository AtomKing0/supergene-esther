package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhm<V> extends FutureTask<V> implements Comparable<zzhm<V>> {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzhh zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhm(zzhh zzhhVar, Runnable runnable, boolean z10, String str) {
        super(com.google.android.gms.internal.measurement.zzcy.zza().zza(runnable), null);
        this.zzd = zzhhVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzhh.zza.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z10;
        if (andIncrement == Long.MAX_VALUE) {
            zzhhVar.zzj().zzg().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzhm zzhmVar = (zzhm) obj;
        boolean z10 = this.zza;
        if (z10 != zzhmVar.zza) {
            return z10 ? -1 : 1;
        }
        long j10 = this.zzb;
        long j11 = zzhmVar.zzb;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        this.zzd.zzj().zzm().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzd.zzj().zzg().zza(this.zzc, th);
        if ((th instanceof zzhk) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhm(zzhh zzhhVar, Callable<V> callable, boolean z10, String str) {
        super(com.google.android.gms.internal.measurement.zzcy.zza().zza(callable));
        this.zzd = zzhhVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzhh.zza.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z10;
        if (andIncrement == Long.MAX_VALUE) {
            zzhhVar.zzj().zzg().zza("Tasks index overflow");
        }
    }
}
