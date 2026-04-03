package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgcj extends zzgcl {
    /* JADX WARN: Multi-variable type inference failed */
    public static zzgci zza(Iterable iterable) {
        return new zzgci(false, zzfxr.zzk(iterable), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzgci zzb(Iterable iterable) {
        int i10 = zzfxr.zzd;
        iterable.getClass();
        return new zzgci(true, zzfxr.zzk(iterable), null);
    }

    @SafeVarargs
    public static zzgci zzc(m... mVarArr) {
        return new zzgci(true, zzfxr.zzl(mVarArr), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static m zzd(Iterable iterable) {
        return new zzgbr(zzfxr.zzk(iterable), true);
    }

    public static m zze(m mVar, Class cls, zzful zzfulVar, Executor executor) {
        zzgau zzgauVar = new zzgau(mVar, cls, zzfulVar);
        mVar.addListener(zzgauVar, zzgda.zzc(executor, zzgauVar));
        return zzgauVar;
    }

    public static m zzf(m mVar, Class cls, zzgbq zzgbqVar, Executor executor) {
        zzgat zzgatVar = new zzgat(mVar, cls, zzgbqVar);
        mVar.addListener(zzgatVar, zzgda.zzc(executor, zzgatVar));
        return zzgatVar;
    }

    public static m zzg(Throwable th) {
        th.getClass();
        return new zzgcm(th);
    }

    public static m zzh(Object obj) {
        return obj == null ? zzgcn.zza : new zzgcn(obj);
    }

    public static m zzi() {
        return zzgcn.zza;
    }

    public static m zzj(Callable callable, Executor executor) {
        zzgdj zzgdjVar = new zzgdj(callable);
        executor.execute(zzgdjVar);
        return zzgdjVar;
    }

    public static m zzk(zzgbp zzgbpVar, Executor executor) {
        zzgdj zzgdjVar = new zzgdj(zzgbpVar);
        executor.execute(zzgdjVar);
        return zzgdjVar;
    }

    @SafeVarargs
    public static m zzl(m... mVarArr) {
        return new zzgbr(zzfxr.zzl(mVarArr), false);
    }

    public static m zzm(m mVar, zzful zzfulVar, Executor executor) {
        zzgbe zzgbeVar = new zzgbe(mVar, zzfulVar);
        mVar.addListener(zzgbeVar, zzgda.zzc(executor, zzgbeVar));
        return zzgbeVar;
    }

    public static m zzn(m mVar, zzgbq zzgbqVar, Executor executor) {
        int i10 = zzgbf.zzc;
        executor.getClass();
        zzgbd zzgbdVar = new zzgbd(mVar, zzgbqVar);
        mVar.addListener(zzgbdVar, zzgda.zzc(executor, zzgbdVar));
        return zzgbdVar;
    }

    public static m zzo(m mVar, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return mVar.isDone() ? mVar : zzgdg.zzf(mVar, j10, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgdl.zza(future);
        }
        throw new IllegalStateException(zzfvj.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgdl.zza(future);
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof Error) {
                throw new zzgby((Error) cause);
            }
            throw new zzgdk(cause);
        }
    }

    public static void zzr(m mVar, zzgcf zzgcfVar, Executor executor) {
        zzgcfVar.getClass();
        mVar.addListener(new zzgcg(mVar, zzgcfVar), executor);
    }
}
