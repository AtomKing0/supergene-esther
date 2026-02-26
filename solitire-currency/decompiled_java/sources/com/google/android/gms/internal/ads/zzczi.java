package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzczi implements Runnable {
    private final WeakReference zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzczj zzczjVar = (zzczj) this.zza.get();
        if (zzczjVar != null) {
            zzczjVar.zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcze
                @Override // com.google.android.gms.internal.ads.zzdcg
                public final void zza(Object obj) throws ExecutionException, InterruptedException {
                    ((zzczc) obj).zzb();
                }
            });
        }
    }
}
