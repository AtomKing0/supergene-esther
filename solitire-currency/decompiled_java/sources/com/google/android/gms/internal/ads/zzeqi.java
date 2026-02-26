package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeqi implements zzevo {
    private final zzgcu zza;

    zzeqi(zzgcu zzgcuVar) {
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 55;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzeqh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzeqj(Long.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() - com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zza()).longValue());
            }
        });
    }
}
