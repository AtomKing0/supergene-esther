package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgav extends zzgbz implements Runnable {
    m zza;
    Class zzb;
    Object zzc;

    zzgav(m mVar, Class cls, Object obj) {
        mVar.getClass();
        this.zza = mVar;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        if (((obj == null) || ((mVar == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            th = mVar instanceof zzgdm ? ((zzgdm) mVar).zzl() : null;
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + String.valueOf(mVar.getClass()) + " threw " + String.valueOf(e10.getClass()) + " without a cause");
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        Object objZzp = th == null ? zzgcj.zzp(mVar) : null;
        if (th == null) {
            zzc(objZzp);
            return;
        }
        if (!cls.isInstance(th)) {
            zzs(mVar);
            return;
        }
        try {
            Object objZze = zze(obj, th);
            this.zzb = null;
            this.zzc = null;
            zzf(objZze);
        } catch (Throwable th2) {
            try {
                zzgdb.zza(th2);
                zzd(th2);
            } finally {
                this.zzb = null;
                this.zzc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final String zza() {
        String str;
        m mVar = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String strZza = super.zza();
        if (mVar != null) {
            str = "inputFuture=[" + mVar.toString() + "], ";
        } else {
            str = "";
        }
        if (cls == null || obj == null) {
            if (strZza != null) {
                return str.concat(strZza);
            }
            return null;
        }
        return str + "exceptionType=[" + cls.toString() + "], fallback=[" + obj.toString() + v8.i.f15839e;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    abstract Object zze(Object obj, Throwable th) throws Exception;

    abstract void zzf(Object obj);
}
