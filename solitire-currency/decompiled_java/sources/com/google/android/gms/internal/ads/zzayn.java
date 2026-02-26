package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzayn implements Runnable {
    final /* synthetic */ zzayo zza;

    zzayn(zzayo zzayoVar) {
        this.zza = zzayoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzc) {
            zzayo zzayoVar = this.zza;
            if (zzayoVar.zzd && zzayoVar.zze) {
                zzayoVar.zzd = false;
                com.google.android.gms.ads.internal.util.client.zzm.zze("App went background");
                Iterator it = this.zza.zzf.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzayp) it.next()).zza(false);
                    } catch (Exception e10) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
                    }
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zze("App is still foreground");
            }
        }
    }
}
