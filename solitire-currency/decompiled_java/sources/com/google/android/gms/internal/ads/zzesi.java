package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesi implements zzevo {
    private final Context zza;
    private final zzgcu zzb;

    zzesi(zzgcu zzgcuVar, Context context) {
        this.zzb = zzgcuVar;
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 57;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzesj zzc() throws Exception {
        com.google.android.gms.ads.internal.zzu.zzp();
        return new zzesj(com.google.android.gms.ads.internal.util.zzt.zzs(this.zza));
    }
}
