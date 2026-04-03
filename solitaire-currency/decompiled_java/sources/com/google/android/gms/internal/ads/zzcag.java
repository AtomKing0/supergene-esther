package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcag implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcao zzb;

    zzcag(zzcao zzcaoVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao.zzl(this.zzb, this.zza);
        zzcao zzcaoVar = this.zzb;
        if (zzcaoVar.zzq != null) {
            zzcaoVar.zzq.zzf();
        }
    }
}
