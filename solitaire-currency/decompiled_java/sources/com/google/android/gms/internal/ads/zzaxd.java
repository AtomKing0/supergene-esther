package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaxd implements Callable {
    protected final zzavp zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzaro zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzaxd(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i10, int i11) {
        this.zza = zzavpVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzaroVar;
        this.zzf = i10;
        this.zzg = i11;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzk();
        return null;
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzk() throws Exception {
        int i10;
        try {
            long jNanoTime = System.nanoTime();
            Method methodZzj = this.zza.zzj(this.zzb, this.zzc);
            this.zze = methodZzj;
            if (methodZzj == null) {
                return null;
            }
            zza();
            zzauj zzaujVarZzd = this.zza.zzd();
            if (zzaujVarZzd == null || (i10 = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzaujVarZzd.zzc(this.zzg, i10, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
