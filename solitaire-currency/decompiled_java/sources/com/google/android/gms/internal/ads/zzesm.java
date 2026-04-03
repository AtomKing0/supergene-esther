package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesm implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;

    zzesm(zzgcu zzgcuVar, zzffg zzffgVar) {
        this.zza = zzgcuVar;
        this.zzb = zzffgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 21;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzesn zzc() throws Exception {
        return new zzesn("requester_type_2".equals(com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzc(this.zzb.zzd)));
    }
}
