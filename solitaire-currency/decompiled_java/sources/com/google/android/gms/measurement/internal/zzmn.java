package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import androidx.media3.exoplayer.ExoPlayer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmn {
    final /* synthetic */ zzmi zza;
    private zzmm zzb;

    zzmn(zzmi zzmiVar) {
        this.zza = zzmiVar;
    }

    @WorkerThread
    final void zza(long j10) {
        this.zzb = new zzmm(this, this.zza.zzb().currentTimeMillis(), j10);
        this.zza.zzc.postDelayed(this.zzb, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @WorkerThread
    final void zza() {
        this.zza.zzt();
        if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        this.zza.zzk().zzn.zza(false);
        this.zza.zza(false);
    }
}
