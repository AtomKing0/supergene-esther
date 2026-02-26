package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcnz implements zzbix {
    final /* synthetic */ zzcoa zza;

    zzcnz(zzcoa zzcoaVar) {
        this.zza = zzcoaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (zzcoa.zzg(this.zza, map)) {
            this.zza.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcny
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza.zzd.zzj();
                }
            });
        }
    }
}
