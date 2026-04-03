package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfit {
    final /* synthetic */ zzfjd zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzfit(zzfjd zzfjdVar, Object obj, List list, zzfis zzfisVar) {
        this.zza = zzfjdVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfjc zza(Callable callable) {
        zzgci zzgciVarZzb = zzgcj.zzb(this.zzc);
        m mVarZza = zzgciVarZzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfir
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzbzo.zzf);
        m mVarZza2 = zzgciVarZzb.zza(callable, this.zza.zzb);
        return new zzfjc(this.zza, this.zzb, mVarZza, this.zzc, mVarZza2);
    }
}
