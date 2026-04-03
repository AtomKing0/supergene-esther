package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesx implements zzevo {
    private final zzgcu zza;
    private final zzdvi zzb;

    zzesx(zzgcu zzgcuVar, zzdvi zzdviVar) {
        this.zza = zzgcuVar;
        this.zzb = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 23;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzesy zzc() throws Exception {
        zzdvi zzdviVar = this.zzb;
        String strZzc = zzdviVar.zzc();
        boolean zZzr = zzdviVar.zzr();
        boolean zZzl = com.google.android.gms.ads.internal.zzu.zzs().zzl();
        zzdvi zzdviVar2 = this.zzb;
        return new zzesy(strZzc, zZzr, zZzl, zzdviVar2.zzp(), zzdviVar2.zzs());
    }
}
