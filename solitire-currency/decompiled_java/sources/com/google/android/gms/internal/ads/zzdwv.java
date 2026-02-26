package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwv implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdwv(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        final zzauo zzauoVar = (zzauo) this.zza.zzb();
        final Context contextZza = ((zzcgp) this.zzb).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        m mVarZzb = zzgcuVar.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdws
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzauoVar.zzc().zzg(contextZza);
            }
        });
        zzhfk.zzb(mVarZzb);
        return mVarZzb;
    }
}
