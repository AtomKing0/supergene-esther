package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgbf extends zzgbz implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    m zza;
    Object zzb;

    zzgbf(m mVar, Object obj) {
        mVar.getClass();
        this.zza = mVar;
        this.zzb = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.zza;
        Object obj = this.zzb;
        if ((isCancelled() | (mVar == null)) || (obj == null)) {
            return;
        }
        this.zza = null;
        if (mVar.isCancelled()) {
            zzs(mVar);
            return;
        }
        try {
            try {
                Object objZze = zze(obj, zzgcj.zzp(mVar));
                this.zzb = null;
                zzf(objZze);
            } catch (Throwable th) {
                try {
                    zzgdb.zza(th);
                    zzd(th);
                } finally {
                    this.zzb = null;
                }
            }
        } catch (Error e10) {
            zzd(e10);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e11) {
            zzd(e11.getCause());
        } catch (Exception e12) {
            zzd(e12);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final String zza() {
        String str;
        m mVar = this.zza;
        Object obj = this.zzb;
        String strZza = super.zza();
        if (mVar != null) {
            str = "inputFuture=[" + mVar.toString() + "], ";
        } else {
            str = "";
        }
        if (obj == null) {
            if (strZza != null) {
                return str.concat(strZza);
            }
            return null;
        }
        return str + "function=[" + obj.toString() + v8.i.f15839e;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    abstract Object zze(Object obj, Object obj2) throws Exception;

    abstract void zzf(Object obj);
}
