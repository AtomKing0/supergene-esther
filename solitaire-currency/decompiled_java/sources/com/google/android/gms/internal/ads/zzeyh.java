package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeyh implements zzevo {
    final zzgcu zza;
    final List zzb;

    public zzeyh(zzbbf zzbbfVar, zzgcu zzgcuVar, List list) {
        this.zza = zzgcuVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 48;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzeyi(this.zza.zzb);
            }
        });
    }
}
