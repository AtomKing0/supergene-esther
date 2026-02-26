package com.google.android.gms.internal.ads;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzflz extends TimerTask {
    final /* synthetic */ Timer zza;
    final /* synthetic */ zzfmb zzb;
    final /* synthetic */ zzcey zzc;

    zzflz(zzfmb zzfmbVar, zzcey zzceyVar, Timer timer) {
        this.zzc = zzceyVar;
        this.zza = timer;
        this.zzb = zzfmbVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzb.zzg();
        this.zzc.zza(true);
        this.zza.cancel();
    }
}
